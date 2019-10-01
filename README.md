# Jakarta-ee MicroService

## Introduction
### Watch forward
### What is Jakarta ee ?

### Payara
```
[baptiste@DESKTOP-FUI7H3K simple-microservice]$ mvn payara-micro:bundle -P payara
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------< org.keywer.jakarta:simple-microservice >---------------
[INFO] Building simple-microservice 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO] 
[INFO] --- payara-micro-maven-plugin:1.0.5:bundle (default-cli) @ simple-microservice ---
[INFO] Configured Artifact: fish.payara.extras:payara-micro:5.192:jar
[INFO] Unpacking /home/baptiste/.m2/repository/fish/payara/extras/payara-micro/5.192/payara-micro-5.192.jar to /home/baptiste/IdeaProjects/simple-microservice/target/extracted-payaramicro with includes "" and excludes ""
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO] Copying application file [/home/baptiste/IdeaProjects/simple-microservice/target/simple-microservice-1.0-SNAPSHOT.war] to [/home/baptiste/IdeaProjects/simple-microservice/target/extracted-payaramicro/MICRO-INF/deploy/ROOT.war]
[INFO] Updated timestamp of deployment file [/home/baptiste/IdeaProjects/simple-microservice/target/extracted-payaramicro/MICRO-INF/deploy/ROOT.war]
[INFO] Building jar: /home/baptiste/IdeaProjects/simple-microservice/target/simple-microservice-1.0-SNAPSHOT-microbundle.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.553 s
[INFO] Finished at: 2019-09-28T17:31:44+02:00
[INFO] ------------------------------------------------------------------------
```
#### How launch ?
Payara will create an executable jar for you
java -jar target/simple-microservice-1.0-SNAPSHOT-microbundle.jar

### TomEE
```
mvn clean package -P tomee
```
```
[INFO] --- maven-war-plugin:2.2:war (default-war) @ simple-microservice ---
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.thoughtworks.xstream.core.util.Fields (file:/home/baptiste/.m2/repository/com/thoughtworks/xstream/xstream/1.3.1/xstream-1.3.1.jar) to field java.util.Properties.defaults
WARNING: Please consider reporting this to the maintainers of com.thoughtworks.xstream.core.util.Fields
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[INFO] Packaging webapp
[INFO] Assembling webapp [simple-microservice] in [/home/baptiste/IdeaProjects/simple-microservice/target/simple-microservice-1.0-SNAPSHOT]
[INFO] Processing war project
[INFO] Processing overlay [ id org.apache.tomee:tomee-embedded:uber]
[INFO] Webapp assembled in [91152 msecs]
[INFO] Building war: /home/baptiste/IdeaProjects/simple-microservice/target/simple-microservice-1.0-SNAPSHOT.war
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  02:23 min
[INFO] Finished at: 2019-09-29T01:24:44+02:00
[INFO] ------------------------------------------------------------------------

```
#### How launch ?
Tomee create an executable war
```
 java -jar target/simple-microservice-1.0-SNAPSHOT.war
```

### OpenLiberty
```
mvn clean install -P openliberty

java -jar target/simple-microservice-1.0-SNAPSHOT.jar 
```
### KumuluzEE
#### Create jar
```
[baptiste@DESKTOP-FUI7H3K simple-microservice]$ mvn clean package -P kumuluz
```

#### Launch
```
java -jar target/simple-microservice-1.0-SNAPSHOT.jar
```

### Wildfly

### Quarkus
