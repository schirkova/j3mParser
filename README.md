# j3mParser
A java library for parsing J3M metadata files and extracting specific values

To use, construct an instance of J3mParserImpl either with a j3m file, a j3m JSON string, or a JSONObject.
Call methods defined by the J3MParser Interface to extract individual values.


j3mParser uses com.fasterxml.jackson for JSON parsing

In order to use from command line:
1. build: mvn clean install
2. run: java -jar target/j3mParse-0.0.1-SNAPSHOT-jar-with-dependencies.jar -h (displays help menu)
2.a run: java -jar target/j3mParse-0.0.1-SNAPSHOT-jar-with-dependencies.jar -gpsd <path to j3m file> (Displays GPS Data)
e.g. java -jar target/j3mParse-0.0.1-SNAPSHOT-jar-with-dependencies.jar -gpsd src/test/resources/latest_j3m.json (Displays GPS Data)
