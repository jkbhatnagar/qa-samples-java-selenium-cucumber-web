# Web Automation - Java - Selenium - Cucumber - Extent Reports



## USAGE

### Travis CI Builds

    //
    

### Run Locally:
 - Pre-requisites: java version 13, jdk version 13, maven (optional), internet access, 
 - Download or clone the 'develop' branch locally. Open Terminal and "cd" to branch directory.
 - Run all TCs : Running locally without installing maven : 
 
     ```./mvnw clean test -Dcucumber.options="--tags @RegressionTest --plugin com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:output --glue stepdefs" -Dbrowser=chrome -Dexemode=local```
 
 - Run all TCs : Running locally from local maven installation: 
 
    ```mvn clean test -Dcucumber.options="--tags @RegressionTest --plugin com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:output --glue stepdefs" -Dbrowser=chrome -Dexemode=local```

 - Run Smoke TCs : Running locally without local maven : 
 
    ```./mvnw clean test -Dcucumber.options="--tags @SmokeTest --plugin com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:output --glue stepdefs" -Dbrowser=chrome -Dexemode=local```

### Run locally on Docker Containers using Selenium Grid

 - Install Selenium Docker Containers and setup Grid infrastructure with 1 Chrome node and 1 Firefox node (must have docker and docker compose installed):
 
     ```docker-compose up -d```

 - Check that hub and node containers are running and node containers are linked to node:

     ```
     docker ps --all
     docker logs "hub ContainerId" --> change hub container id based on result from docker -ps --all. It should show logs like:
  
      INFO [Hub.start] - Selenium Grid hub is up and running
      INFO [Hub.start] - Nodes should register to http://172.19.0.2:4444/grid/register/
      INFO [Hub.start] - Clients should connect to http://172.19.0.2:4444/wd/hub
      INFO [DefaultGridRegistry.add] - Registered a node http://172.19.0.3:5555
      INFO [DefaultGridRegistry.add] - Registered a node http://172.19.0.4:5555
  
     ```

 - Selenium Hub should be available at "http://localhost:4444/grid/console"
 
 - Install VNC Viewer and connect to firefox and chrome nodes. When you run TCs, you can see the browser windows opening in VNC. Don't move mouse or click in VNC windows:
 
     - chrome : localhost:5900 with password “secret”
     - firefox : localhost:5901 with password “secret”
 
 - NOTE: You can later bring down docker containers using:
  ```docker-compose down```
    
 - Run all TCs : Running locally on docker container without installing maven : 
 
     ```./mvnw clean test -Dcucumber.options="--tags @RegressionTest --plugin com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:output --glue stepdefs" -Dbrowser=chrome -Dexemode=remote```
     
 - Run Smoke TCs : Running locally on docker container without local maven : 
 
    ```./mvnw clean test -Dcucumber.options="--tags @SmokeTest --plugin com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:output --glue stepdefs" -Dbrowser=chrome -Dexemode=remote```

### Reports:
 - Extent report is generated at testreport/HtmlReport/ExtentHtml.html
 - Report provides detailed scenarios and step execution summary, with passed - failed - skipped results
 - Sample report screens in screenshots directory

### Maintenance:
- Don't change RunCucumberTest, extent.properties, extent-config.xml
- Add global constants to src/test/java/utils/UtilConstants.
- Add new Cucumber feature files to src/test/features.
- Add new Step Definition files to src/test/java/stepdefs.
- Add page objects to src/test/java/pages.

## TASK LIST

### Completed
- [x] Add Cucumber support
- [x] Add Cucumber Table support
- [x] Add Selenium support
- [x] Add Selenium grid support
- [x] Add Selenium Docker containers support
- [x] Add Extent Report support
- [x] Use Cucumber @Tags to categorize Test Scenarios into @SmokeTest and @RegressionTest
- [x] Read constants and globals from Constants.java or a .properties file

### Pending
- [ ] Split Step definition and feature for different services to separate files
- [ ] Create model POJO classes for Success and Failure responses and extract response in the for advanced assertions, path assertions, and sharing objects between in-flight test cases
- [ ] Add assertion failure comments (if required)
- [ ] Pretty print request and responses in logs
- [ ] Generate a log file
- [ ] Use YAML or Properties file based test data
- [ ] Add test data in Cucumber steps as "Example" and then use <placeholder> tags to avoid repeating same data in Given and Then (must if reading data from external file)
- [ ] Add Environment changer so that same code and assertions can be used with different data for different Test Environments (SIT/UAT/PROD)
- [ ] Use cucumber-picocontainer to add Dependency Injection to share in-flight test objects between test cases

        https://www.coveros.com/using-dependency-injectors-simplify-code-cucumber/
        http://www.thinkcode.se/blog/2017/04/01/sharing-state-between-steps-in-cucumberjvm-using-picocontainer

- Move common tasks and assertions to utility class

        https://github.com/jaganduraisamy/RestAssured-BDD-Java/blob/master/src/test/java/utilities/Utils.java

## REPORT SCREENS

![Dashboard-All](/screenshots/Dashboard-All.png)

![Dashboard-Failed](/screenshots/Dashboard-Failed.png)

![TestGroups](/screenshots/TestGroups.png)

![Defects](/screenshots/Defects.png)


## RESOURCE REFERENCES
- Cucumber base

        https://github.com/cucumber/cucumber-java-skeleton

- Samples

        https://github.com/angiejones/restassured-with-cucumber-demo
        https://github.com/raghwendra-sonu/REST-assured_Cucumber

