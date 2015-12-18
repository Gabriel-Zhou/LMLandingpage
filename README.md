# Lifemapper Landing Page

Lifemapper landing page is designed for users to quick access biodiversity data objects metadata and lineage. It is composed of a three-layer architecture:

1. Backend layer: Backend layer includes one persistent MongoDB service which is served as metadata repository and file archive which hosts biodiversity objects.
2. Middle Layer: Middle layer includes web service using Spring framework which responds to queries or ingestions by accessing backend mongoDB and file archive.
3. Frontend Layer: Frontend layer includes UI design and JS scripts which send AJAX call to middle layer web services.

Here is a general architecture graph for Lifemapper Landing page:
![alt tag](https://raw.githubusercontent.com/Gabriel-Zhou/LMLandingpage/master/docs/arclandingpage.png)

Some sample landing pages are as below:

1. Projection Set 

hdl.handle.net/11723/d506d6e9-54f8-4c5c-9e95-054a26db24d1

2. Occurrence Set 

hdl.handle.net/11723/b476e6d8-6554-4f45-9eab-b77133bcb7cc

#Installation Guide

## Software Dependencies

1. Apache Maven V3.0 or higher
2. JDK V1.6 or higher
3. Python V2.6 or higher with SimpleHttpServer module
4. MongoDB Server V3.0 or higher

##Building the Source
1. Check Out Source Codes:
```
git clone https://github.com/Gabriel-Zhou/LMLandingpage.git
```
2. Edit the SpringConfig.properties file found under src/main/resources and set your backend mongoDB uri with username/password if exists.
```
vi src/main/resources/SpringConfig.properties
```
3. Build Komadu Pingback Model
```
mvn clean install
```

##Deploy LMLandingpage middle layer web services using nohup
```
nohup java -jar ./target/LM-landingpage-0.0.1-SNAPSHOT.jar &
```

##Deploy LMLandingpage frontend layer UI


```
https://github.com/Gabriel-Zhou/Komadu-Pingback/wiki/Basic-Use-Case:-Revision-of-Dummy-File
```








