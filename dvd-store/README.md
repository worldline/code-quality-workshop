# ep2 kata
The objective of this session is to stimulate the team spirit, and illustrate the benefits of good practice:
 - Work in pairs
 - Write tests to ensure quality
 - Coding conventions
 
## Technical points

The dvd-store app is powered by Quarkus, Java 17 & H2 Database.
The database is reset at startup, see class `DataInitTool` to see how a minimal dataset is created.

<ins>How to run the project locally ?</ins>

Either create a new Quarkus run configuration, or launch via mvn goal. 
``` script
compile quarkus:dev
```

The default application port is 8082, customizable in application.properties.

Several REST APIs are available, documented [here](http://localhost:8082/q/swagger-ui).

# dvd-store Project

This project is an app for a video/DVD renting company, and was developed by (too) many developers. Some of them were part of the owner's family ... and not even developers.
Hence quality and long-term vision are not the motto for this app. But this stops now ! 
The company has recently been bought, and the new owner got genius ideas to make the business great again.

Fortunately, your team has been selected to make this dream a reality, implement features and increase the overall quality.
You're allowed to modify anything you want:
 - Add new class, new package
 - Change the data model
 - Correct any problems you see
 
The objective is to implement the requirements and improve the quality, not to over-think every aspect.
Some assumptions you can make :
   - No need to care about DB constraints
   - No Null Entity or fields
   - If you have trouble doing proper DB requests, it is fine to load all entries of a table, then filter it in Java. The objective
is not to master Panache.


However, it is recommended to stay with Quarkus, Java 17 and H2 :-)

