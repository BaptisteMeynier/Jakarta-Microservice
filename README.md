# Simple Jakarta-ee MicroService

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