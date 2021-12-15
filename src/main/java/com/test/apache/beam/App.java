package com.test.apache.beam;

import com.test.apache.beam.domain.DeptDomain;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Filter;
import org.apache.beam.sdk.transforms.GroupByKey;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TypeDescriptor;
import org.apache.beam.sdk.values.TypeDescriptors;

public class App {
    public static void main(String[] args) {

        if (args.length < 2) {
            throw new IllegalArgumentException("You should define almost 2 arguments input file and output folder");
        }


        PipelineOptions options = PipelineOptionsFactory.create();
        Pipeline p1 = Pipeline.create(options);

        PCollection<DeptDomain> input_collection = p1
                .apply("(1) Read all lines", TextIO.read().from(args[0]))
                .apply("(2) Map element to obj", MapElements.into(TypeDescriptor.of(DeptDomain.class)).via(DeptDomain::new));

        PCollection<KV<String, DeptDomain>> output_accounts_kv = input_collection.apply("(3) Filter only accounts", Filter.by(input -> input.getType().equalsIgnoreCase("Accounts")))
                .apply("Convert to KV",
                        MapElements.into(TypeDescriptors.kvs(TypeDescriptors.strings(), TypeDescriptor.of(DeptDomain.class)))
                                .via(d -> KV.of(d.getName(), d)));

        output_accounts_kv
                .apply("(4) non group element accounts to string", MapElements.into(TypeDescriptors.strings()).via(Object::toString))
                .apply("(5) Out result account non group", TextIO.write().withSuffix(".txt").to(args[1]+"/result_eva_sin"));

        output_accounts_kv
                .apply("Grouping KV", GroupByKey.create())
                .apply("(4) FlatMap element accounts", MapElements.into(TypeDescriptors.strings()).via(Object::toString))
                .apply("(5) Out result account", TextIO.write().withSuffix(".txt").to(args[1]+"/result_eva_group"));


        p1.run().waitUntilFinish();
    }

}
