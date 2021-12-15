# Apache Beam

Apache Beam is used to processed both types of big data Batch and Streams. And by these names Beam it is called Beam. B for Batch and eam for Stream

Build one time deploy anywhere. You can run Beam in Spark, Flink, Apex, Cloud DataFlow, Samza, GearBump.

Beam pipelines can be development in many lenguages also. You can choose between Java, Python, Go.

## Beam Terminologies

1. Pipeline: The pipeline is entire processing task. From start to finish. Including reading, transforming and writing data.
2. PCollection: It is our distributed data where our Pipeline operates on
	1. Is immutability, so if you apply a transformation on a PCollection it results in creation of new PCollection
	2. The elements in PCollection may be of any type, but all must be of the same type
	3. Operations can not apply from some specific elements in a PCollection
	4. Each element in a PCollection has an associated timestamp
3. PTransform: Represent a data processing operation (Read, Write, Filter, map, etc). It takes one or more PCollection as input and processing function and produces new PCollections

## Read Transform

1. ReadFromFile
2. ReadFromAvro
3. ReadFromParquet
4. ReadFromPubSub
5. ReadFromJDBC
6. ReadFromBigQuery
7. ReadFromBigTable

## Write Transform

1. WriteToFile
2. WriteToAvro
3. WriteToParquet
4. WriteToPubSub
5. WriteToJDBC
6. WriteToBigQuery
7. WriteToBigTable

## Transform Data

1. MapElements (Use to 1-1 mapping function)
2. FlatMapElements (Use to 1-n mapping function)
3. Filter

## Branches Pipelines y Merged

You can create multiple branches from one Pipeline dividing it into many PCollections. And if you want to merge it after processing are finished you can use Flatten transform to join in a one whole again.

## ParDo Transform

Is similar to MapElement or FlatMapElement. It takes each element of input PCollection and apply a function defined inside it and returns a new PCollection with 0-n elements.

You can use ParDo to:

*	Filtering
*	Formatting or Type Conversion
*	Extracting individual or parts of elements

It works through to a DoFn class, it define a method inside it to process the element. For example, the method MapElements work with DoFn internally.

When you define a DoFn class you should to declare the input and output expected. And indise it you should to declare a method called `processElement` where you processing the input element and return the output defined before. Like this.

```java
/**
 * InputType and OutPutType represent any class you defined in your project 
 * (String, Integer, CustomClazz, etc.)
 **/
public class MyCustomDoFnClass extends DoFn<InputType, OutPutType> {
    private static final long serialVersionUID = -4152414725080621936L;

    @ProcessElement
    public void processElement(@Element InputType inputEl, OutputReceiver<OutPutType> out) {

    	OutPutType outEl = new OutPutType();

    	// Do whatever you want .... Parse, transform, convert, etc. 
    	// This processing should return a type of OutPutType called, for example outEl

        out.output(outEl);
    }
}
```
