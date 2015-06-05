TABLE OF CONTENTS
-----------------
<ol>
<li> Introduction  </li>
<li> Statement of Work </li>
<li> Requirements </li>
<li> What was automated (Scenario 1) </li>
<li> What was automated (Scenario 2) </li>
<li> Project (Location, Structure) </li>
<li> API Documentation (Javadoc) </li>
<li> Command-line Invocation </li>
<li> Output (Expected) </li>
<li> Explanation of Issues seen with Automation Exercise </li>
</ol>


1. Introduction
---------------------------------------------------------------------------
This is the README.md file for the 'Interview Homework' presented to Eric
    Wiegman as part of his consideration for the _"Senior Test Automation
    Engineer"_ position at Wikia.

2. Statement of Work
------------------------------
 I have created a web UI test project using the Selenium WebDriver open-source
    technology and have used Maven as the tool to perform the build and deploy
    the test (running the TestNG suite with the surefire plugin). The client
    language is Java and the test harness used is TestNG.

3. Specified Project Requirements
-------------------------------------------------------------
1. Keep in mind that your code should be flexible, expandable and
    maintainable.
1. You should be able to run your tests against the Firefox and Chrome
    browsers.
1. Tests should be written in Selenium WebDriver.
1. Feel free to use any language and framework (Java/TestNG/Maven is
    recommended, as we are developing our scripts in it, but any other
    languages/frameworks are permissible).
1. It is recommended to use the following patterns:
    1. PageObjects: [https://code.google.com/p/selenium/wiki/PageObjects](https://code.google.com/p/selenium/wiki/PageObjects)
   1.  PageFactory: [https://code.google.com/p/selenium/wiki/PageFactory](https://code.google.com/p/selenium/wiki/PageFactory)
1. Add the necessary instructions to the README.md file in English on how to
    run your code from the command line.


3.1. Notes on Requirements
--------------------------
1. Object Oriented Principles and Design considerations were applied when
    designing the java classes.
2. The /src/main/resources/config.properties file has an entry for
    specifying which browser (Firefox or Chrome) to run against.
3. The tool used is Selenium WebDriver (2.45.0).
4. Maven is used to manage project dependencies. The tool used is Selenium
    (with the Java 8 client) and the harness used is TestNG (6.8.8).
5. The PageFactory pattern is used.
6. This file contains instructions on how to run the test from command line.

**Note:** See Section 10 for an explanation of Issues seen with this Automation Exercise

4. The following is a general outline of what was automated for Scenario 1:
---------------------------------------------------------------------------
1. Navigate to http://qm-homework.wikia.com and be redirected to Home page.
2.  Hover over the “Log in” label and wait for the Login form to 'pop up'.
3. Enter username and password (retrieved from the config.properties file),
    left click the login button.
4. Wait for the Anonymous Avatar image to become a User Avatar image.
5. Assert that the title associated with the Avatar is indicating the
    username.

**Notes:**<br>
Initial navigation is done in a @BeforeTest setup routine.<br>
Steps 1 and 2, above,  are encapsulated in a reusable <code>commonLogin</code> method.

5. The following is a general outline of what was automated for Scenario 2:
---------------------------------------------------------------------------
1. Steps 1 through 3 (see section 4, above) are repeated to ensure proper log in to Wikia.
2. Left click the “Contribute” button.
3. Left click the “Add a video” button.
4. On the WikiaVideoAdd page, enter the specified URL into the input text field.
5. Left click the "Add" button. A message with text: “Video page
    File:{FILENAME} successfully added.” is displayed near the top of the page.
6. Left click the link to file on the flash message. (User is directed to a
    specific page that runs the video.)
7. An Assert is performed to ensure the Header text on the page matches the
    name of the video.

Unless otherwise noted, the test cases run were parameterized using the
    TestNG DataProvider -- with that data separated from the code in its own
    /src/main/java/WikiaDataProvider.java file.

6. The project is stored on GitHub at public repository WIKIA_EWIEGMAN.
---------------------------------------------------------------------------
6.1 The directory structure is shown below:

    │   pom.xml
    │   README
    │
    ├───docs
    │   │   allclasses-frame.html
    │   │   allclasses-noframe.html
    │   │   BestClassicalMusicPage.html
    │   │   Const.html
    │   │   constant-values.html
    │   │   deprecated-list.html
    │   │   help-doc.html
    │   │   index.html
    │   │   overview-frame.html
    │   │   overview-summary.html
    │   │   overview-tree.html
    │   │   package-frame.html
    │   │   package-list
    │   │   package-summary.html
    │   │   package-tree.html
    │   │   script.js
    │   │   stylesheet.css
    │   │   Utilities.html
    │   │   VideosOnThisWikiPage.html
    │   │   WikiaDataProviderPage.html
    │   │   WikiaHomePage.html
    │   │   WikiaVideoAddPage.html
    │   │
    │   ├───index-files
    │   │       index-1.html
    │   │       index-10.html
    │   │       index-11.html
    │   │       index-12.html
    │   │       index-13.html
    │   │       index-14.html
    │   │       index-15.html
    │   │       index-16.html
    │   │       index-17.html
    │   │       index-18.html
    │   │       index-19.html
    │   │       index-2.html
    │   │       index-20.html
    │   │       index-3.html
    │   │       index-4.html
    │   │       index-5.html
    │   │       index-6.html
    │   │       index-7.html
    │   │       index-8.html
    │   │       index-9.html
    │   │
    │   ├───java
    │   │       InterviewHomeworkTests.html
    │   │       package-frame.html
    │   │       package-summary.html
    │   │       package-tree.html
    │   │
    │   └───main
    │       └───java
    │               BestClassicalMusicPage.html
    │               HomePage.html
    │               package-frame.html
    │               package-summary.html
    │               package-tree.html
    │               VideosOnThisWikiPage.html
    │               WikiaDataProviderPage.html
    │               WikiaLoginPage.html
    │               WikiaVideoAddPage.html
    │
    └───src
        ├───main
        │   ├───java
        │   │       BestClassicalMusicPage.java
        │   │       Const.java
        │   │       Utilities.java
        │   │       VideosOnThisWikiPage.java
        │   │       WikiaDataProviderPage.java
        │   │       WikiaHomePage.java
        │   │       WikiaVideoAddPage.java
        │   │
        │   └───resources
        │       │   config.properties
        │       │   testng.xml
        │       │
        │       └───chromedriver_win32
        │               chromedriver.exe [not in GitHub. See 8.1.5. of README]
        │
        └───test
            └───java
                    InterviewHomeworkTests.java


6.2 Please note that the directory structure is important, and file/directory
    changes should **not** be made. Failure to leave the structure as is will
    cause Maven, the surefire plugin, or other tools to not recognize the
    classpath items correctly, leading to failures.

7. API Documentation (Javadoc)
------------------------
For more information on the defined java elements in this project, invoke
    index.html at HomeWork/docs and use the API viewer to read the Javadoc
    supplied text.

8. Command-line invocation
---------------------------
1. To call the test from the command line (from within your Windows (DOS)
    Command Prompt or Macintosh/Linux Terminal), you need to ensure some
    prerequisites have first been met.
2. You should have your path set so that it will recognize the Maven binary
    'mvn' no matter which directory you are currently browsing.
3. As it is required by Maven, if you have not already done so set your
    JAVA\_HOME environment variable to be where you installed your Java
    (for instance, 'C:\Program Files\Java\jdk1.8.0_40' if using defaults for
    Windows installation).
4. To simplify the command line call, you should use your Terminal to
    navigate to the directory where the desired pom.xml file is located.
    For this case, this is the directory 'HomeWork'. In that way, the command
    line call will assume there is only one POM file to be run and will
    assume it is in the current directory.
5. Additionally, it appears maven cannot handle dependencies if they are
    executables, so if using Selenium WebDriver to automate the product on a
    Chrome browser you need to retrieve the latest chromedriver executable
    and unzip it to your local drive (see the config.properties
    'chromedriverExeLocation' item to see how to specify the relative path to
     this required executable ... for my Win32 setup, this was
     /src/main/resources/chromedriver_win32/chromedriver.exe for me).

     You may find this zipped chromedriver executable at
     [https://sites.google.com/a/chromium.org/chromedriver/downloads](https://sites.google.com/a/chromium.org/chromedriver/downloads)

8.2. The following is the command line text to be entered in the Command Prompt
    or Terminal:

        mvn compile test

9. Output
---------
9.1. The expected (successful) command line output is shown below
<pre>
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building HomeWork 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.5:resources (default-resources) @ HomeWork -
--
[debug] execute contextualize
[WARNING] Using platform encoding (windows-1252 actually) to copy filtered resou
rces, i.e. build is platform dependent!
[INFO] Copying 3 resources
[INFO]
[INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ HomeWork ---
[WARNING] File encoding has not been set, using platform encoding windows-1252,
i.e. build is platform dependent!
[INFO] Compiling 1 source file to C:\Users\Eric\workspace2\WIKIA_EWIEGMAN\HomeWo
rk\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.5:resources (default-resources) @ HomeWork -
--
[debug] execute contextualize
[WARNING] Using platform encoding (windows-1252 actually) to copy filtered resou
rces, i.e. build is platform dependent!
[INFO] Copying 3 resources
[INFO]
[INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ HomeWork ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.5:testResources (default-testResources) @ Ho
meWork ---
[debug] execute contextualize
[WARNING] Using platform encoding (windows-1252 actually) to copy filtered resou
rces, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory C:\Users\Eric\workspace2\WIKIA_EWIEGM
AN\HomeWork\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:2.3.2:testCompile (default-testCompile) @ HomeW
ork ---
[WARNING] File encoding has not been set, using platform encoding windows-1252,
i.e. build is platform dependent!
[INFO] Compiling 1 source file to C:\Users\Eric\workspace2\WIKIA_EWIEGMAN\HomeWo
rk\target\test-classes
[INFO]
[INFO] --- maven-surefire-plugin:2.14.1:test (default-test) @ HomeWork ---
[INFO] Surefire report directory: C:\Users\Eric\workspace2\WIKIA_EWIEGMAN\HomeWo
rk\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running TestSuite
Starting ChromeDriver 2.15.322448 (52179c1b310fec1797c81ea9a20326839860b7d3) on
port 8059
Only local connections are allowed.
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 81.111 sec

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1:29.056s
[INFO] Finished at: Thu Jun 04 16:38:14 PDT 2015
[INFO] Final Memory: 22M/143M
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
</pre>

9.2. At the point where the 'Running TestSuite' is announced, Maven calls
    surefire, which in turn calls TestNG harness that runs the XML suite in
    Selenium Java code. This performs the steps outlined in README sections 4
    and 5.

9.3. The directory 'target' is created in the 'HomeWork' root, where binaries
    and pass/fail report files are found.

9.4. To see a graphical representation of the pass/fail/skip data associated
    with the testNG Suite run, open the file /target/surefire-reports/index.html
    in your favorite browser.

10. Explanation of Issues seen with Automation Exercise<a id="chapter-1"></a>
--------------------------------------------------------
10.1. There is a nearly constant set of javascripts running in the background
    (especially when a page loads) and these do not seem to be the most
    robust (at least with the environment upon which I tested). These
    ad-swapping routines have caused major browser issues (perhaps more with
    Firefox version '33' than with Chrome version '43.0.2357.81 m', with
    ChromeDriver.exe version '2.15.322448' -- as run on Windows 8.1).

10.1.1. Here is one (of many seen) example of a failure as noted by the Maven
    run of the automation. None of these are easily solved with automation
    tools, and might indicate issues that will affect those manually using
    the product:
<pre>
Jun 04, 2015 10:10:31 AM org.openqa.selenium.support.ui.ExpectedConditions
findElement WARNING: WebDriverException thrown by findElement(By.className:
account-navigation-first-item) org.openqa.selenium.UnhandledAlertException:
Unexpected modal dialog (text: A script on this page may be busy, or it may have
stopped responding. You can stop the script now, open the script in the debugger,
or let the script continue.

Script: http://lax1.ib.adnxs.com/if?e=wqT_3QLuBMBlAgAAAgDWAAUI24vCqwUQ49mY4rPLwe
RQGNLz7-y9ko3uRCABKi0JAAAAAAAAJkARBQgwACZAGcuhRbbzfSVAIRESACkRCbAw9bCAAjjNFEDNFE
gCUOXVsw5Yl9ohYABo2bkDcAB4mosDgAEBigEDVVNEkgEBBvBjmAGsAqAB-gGoAQCwAQC4AQLAAQTIAQ
DQAQDYAQDgAQDwAQCKAld1ZignYScsIDM0MzQzNywgMTQzMzQzNzY1OSk7dWYoJ2MnLCA4NzUyNjc2LC
AxNDMzNDM3NjU5KTt1ZigncgE5GDAyMDY2OTM2HgDwY5ICnQEhU2h5aDZnaWtuSllFRU9YVnN3NFlBQ0
NYMmlFd0FEZ0FRQU5JelJSUTliQ0FBbGdBWU5vRWFBQndBSGdBZ0FFQWlBRUFrQUVCbUFFQm9BRUJxQU
VEc0FFQXVRRUFBQUEBAxBtUU1FQgEJAQFESmtESkFid2FUQVc1RHdGQTJRESgoRHdQLUFCM0tZSTkNFC
SaAh0hT3dZc09RNqAAwGw5b2hJQU0u2AKmCuACuIAf6gIzaHR0cDovL3FtLWhvbWV3b3JrLndpa2lhLm
NvbS8BCnwvUU1fSG9tZVdvcmtfV2lraWHyAhAKBkFEVl9JRBIGMyVcHPICEQoGQ1BHARMcBzIwMTExMT
gBJwgFQ1AFEwA4KWbEgAMAiAMBkAMAmAMAoAMBqgMAsAMAuAMAwAOsAsgDANgDsD7gAwDoAwDwAwD4Aw
GABAA.&dlo=1&referrer=http%3A%2F%2Fqm-homework.wikia.com%2Fwiki%2FQM_HomeWork_Wi
kia:25): A script on this page may be busy, or it may have stopped responding. Y
ou can stop the script now, open the script in the debugger, or let the script c
ontinue.
</pre>
10.2. In other cases, when I hit the LOG IN button on the popup the browser
    was terminally busy "Waiting for data04.adlooxtracking.com...".
    Similarly, I had cases where the browser reported (in status bar) that
    it was processing a request (with no further details). Out of
    frustration, I manually quit the browser to force the
    automation to abort in these cases.

10.3. In a relatively rare set of cases, the browser became non-responsive
    (with *no* apparent diagnostics), requiring a force-quit of the browser
    (by terminating the process).

10.4. The other situation I saw once was a shockwave (warning?) dialog coming
    up and quickly dismissing itself. After that occurrence the browser
    became non-responsive.
