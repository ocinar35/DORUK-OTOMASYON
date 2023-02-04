## Instructions
Test Scenarios are prepared by;

Oğuz ÇINAR

QA Automation Engineer

ocinar2525@gmail.com

https://www.linkedin.com/in/oguz-cinar-qa/

### Build Tool
```Maven```

### Dependencies
```selenium-java```
```webdrivermanager```
```cucumber-java```
```cucumber-junit```
```reporting-plugin```

### Plugins
```maven-surefire-plugin```

### System Requirements
```Java 8 + SDK```

### Nice to Know
1 - For running tests scenarios;

        - go to CukerRunner.java class (src > test > java > doruk > runners > CukesRunner)
        - specify a tag in CucumberOptions
                * @wip for UI tests
        - run CukesRunner.java class

2 - Cucumber BDD Framework has 2 layers;

        - Business Layer --> src > test > resources > features
        - Implementation Layer --> src > > test > java > doruk > step_defs
3 - Automated UI case on <ins>https://cloud.promanage.net/testteam/ui</ins>.

4 - <ins>Relevant credentials</ins> are located in configuration.properties file.

5 - Followed  <ins>Page Object Model</ins> & <ins>Singleton Design Pattern.</ins>

6 - Achieved <ins>Data Driven Testing</ins> by configuration.properties

7 - Implemented <ins>Gherkin Language</ins> in feature files.

8 - Utilized <ins>Hooks</ins> class for taking screenshots if a test fails.