# Lifemapper Landing Page

Lifemapper landing page is designed for users to quick access biodiversity data objects metadata and lineage. It is composed of a three-layer architecture:

1. Backend layer: Backend layer includes one persistent MongoDB service which is served as metadata repository and file archive which hosts biodiversity objects.
2. Middle Layer: Middle layer includes web service using Spring framework which responds to queries or ingestions by accessing backend mongoDB and file archive.
3. Frontend Layer: Frontend layer includes UI design and JS scripts which send AJAX call to middle layer web services.

Here is a general architecture graph for Lifemapper Landing page:
![alt tag](https://raw.githubusercontent.com/Gabriel-Zhou/LMLandingpage/master/docs/arclandingpage.png)

Some sample landing pages are as below:

1. Projection Set: hdl.handle.net/11723/d506d6e9-54f8-4c5c-9e95-054a26db24d1

2. Occurrence Set: hdl.handle.net/11723/b476e6d8-6554-4f45-9eab-b77133bcb7cc

#Installation Guide

## Software Dependencies

1. Apache Maven 3.0 or higher
2. JDK 1.6 or higher
3. Apache XML Beans 2.3.0
4. Apache Tomcat 6.0.x or higher
5. Komadu Provenance Collection Tool V1.0 and Deploy as Web Service
(Available at: https://github.com/Data-to-Insight-Center/komadu)

##Building the Source
1. Check Out Komadu Pingback Model code from git repository:
```
git clone https://github.com/Gabriel-Zhou/Komadu-Pingback.git
```

2. Edit the config.properties file found under src/main/java/edu/indiana/d2i/komadu/pingback/server and set your host name, port number for Tomcat Service and data root path to store all transaction data.

3. Build Komadu Pingback Model
```
mvn clean compile war:war
```

##Set up Tomcat and deploy Komadu Pingback Web Service
1. Copy {Komadu-Pingback_checkout_path}/target/Komadu-Pingback-Server-1.0-SNAPSHOT.war to 
{your_tomcat_home}/webapps/ directory.
2. Start Tomcat.

##Executing Basic Use Case

Once you have successfully deployed Komadu Pingback Model on Tomcat, you can execute the basic use case with guide available at:
```
https://github.com/Gabriel-Zhou/Komadu-Pingback/wiki/Basic-Use-Case:-Revision-of-Dummy-File
```








