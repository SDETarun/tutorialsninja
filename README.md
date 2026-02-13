# Tutorialsninja Automation Framework

## Overview

This project is a **production-ready Selenium Test Automation Framework** built using:

* Java
* Selenium WebDriver
* TestNG
* Maven
* ExtentReports
* Page Object Model (POM)

It is designed using industry best practices and is suitable for **enterprise-level UI automation and CI/CD integration**.

Automates key workflows of the Tutorialsninja demo application including:

* User Registration
* Login
* Homepage validation
* Negative test scenarios

---

## Key Features

* Page Object Model (POM) design pattern
* ExtentReports professional reporting
* Screenshot capture on test failure
* TestNG test execution
* Maven build management
* CI/CD ready framework
* Configurable browser execution
* Scalable and maintainable structure

---

## Tech Stack

| Layer          | Technology               |
| -------------- | ------------------------ |
| Language       | Java                     |
| UI Automation  | Selenium WebDriver       |
| Test Framework | TestNG                   |
| Build Tool     | Maven                    |
| Reporting      | ExtentReports            |
| CI/CD          | GitHub Actions / Jenkins |
| Design Pattern | Page Object Model        |

---

## Framework Architecture

```
                 Test Classes
                      │
                      ▼
               Page Object Classes
                      │
                      ▼
                   BaseTest
                      │
          ┌───────────┴───────────┐
          ▼                       ▼
  Config.properties       Locator.properties
          │
          ▼
       WebDriver
          │
          ▼
      Browser Execution
          │
          ▼
  ExtentReports + Screenshots
```

---

## Project Structure

```
tutorialsninja
│
├── pom.xml
│
├── src/test/java
│   ├── base
│   │   ├── BaseTest.java
│   │   └── ExtentManager.java
│   │
│   ├── pages
│   │   ├── homepage
│   │   ├── login
│   │   └── registration
│   │
│   ├── tests
│   │   ├── testRegistration.java
│   │   └── testNegativeRegistration.java
│   │
│   └── utils
│       ├── ScreenshotUtil.java
│       └── ConfigReader.java
│
├── src/test/resources
│   ├── config.properties
│   └── locators.properties
│
└── screenshots
```

---

## Installation

Clone repository:

```
git clone [https://github.com/your-username/tutorialsninja.git](https://github.com/SDETarun/tutorialsninja.git)
cd tutorialsninja
```

Install dependencies:

```
mvn clean install
```

---

## Running Tests

Run all tests:

```
mvn test
```

Run specific test:

```
mvn -Dtest=testRegistration test
```

Run using TestNG XML:

```
mvn clean test -DsuiteXmlFile=testng.xml
```

---

## ExtentReports

ExtentReports provides professional HTML reports including:

* Pass / Fail status
* Screenshots
* Execution logs
* Test duration
* Environment details

Report location:

```
/reports/ExtentReport.html
```

Example report view includes:

* Dashboard
* Test timeline
* Failure screenshots

---

## Screenshot on Failure

Framework automatically captures screenshot when test fails.

Location:

```
/screenshots/
```

Implementation handled in:

```
ScreenshotUtil.java
```

Integrated with TestNG Listener or BaseTest teardown.

---

## Configuration

Edit configuration:

```
src/test/resources/config.properties
```

Example:

```
browser=chrome
url=https://tutorialsninja.com/demo/
timeout=10
```

---

## CI/CD Integration

This framework supports:

* GitHub Actions
* Jenkins
* Azure DevOps

Example GitHub Actions workflow:

```
name: Selenium Tests

on:
  push:
    branches: [ main ]

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v3

    - name: Setup Java
      uses: actions/setup-java@v3
      with:
        java-version: '11'

    - name: Run tests
      run: mvn clean test
```

---

## Reports Generated

| Report        | Location                  |
| ------------- | ------------------------- |
| Extent Report | reports/ExtentReport.html |
| TestNG Report | test-output/index.html    |
| Screenshots   | screenshots/              |

---

## Best Practices Implemented

* Page Object Model
* Reusable BaseTest
* Separate locator management
* Config-driven execution
* Screenshot on failure
* Professional reporting
* CI/CD ready structure

---

## Future Improvements

* Parallel execution
* Docker integration
* Cross-browser testing
* Cloud execution (BrowserStack / Selenium Grid)
* Logging using Log4j

---

## Author

Tarun Naudiyal
Software Test Engineer

Skills:

* Selenium WebDriver
* Java
* TestNG
* Automation Framework Design
* CI/CD Integration

---

## License

This project is for educational and portfolio purposes.
