package com.test.apache.beam.functions;

import com.test.apache.beam.domain.DeptDomain;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.KV;

public class RevertKV extends DoFn<KV<String, DeptDomain>, DeptDomain> {
    private static final long serialVersionUID = -4152414725080621936L;

    @ProcessElement
    public void processElement(@Element KV<String, DeptDomain> kvInput, OutputReceiver<DeptDomain> out) {
        out.output(kvInput.getValue());
    }
}
