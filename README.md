# My first apache beam

In this project, you can find a quick start with Apache Beam

The project is based on official quick start apache beam
documentation [HERE](https://beam.apache.org/get-started/quickstart-java/)

Also, you can find more information in the [HELP.md](./HELP.md) file

### Versions

- Java 1.8
- Maven 3.8.2

### PreConditions

To run this project, I provide a file to processing called `dept_data.txt` in the resources folder. You should copy this
and put it in any folder to process it.

For example, I put the file in the `/tmp` folder.

To run the program, it receives two arguments: the file's location to process and the destiny to the files after
processing the data.

I used the `/tmp` folder for both.

### Commands to init

1. `mvn clean package exec:java -Dexec.args="/tmp/dept_data.txt /tmp"`
