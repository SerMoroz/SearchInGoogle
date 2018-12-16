Project "Search in Google"
(This tests check search "Selenium" term in Google)

Steps for installation and settings:

1. Instal the Intellij IDEA Community version (https://www.jetbrains.com/idea/download/#section=windows)
2. Install the last version of JAVA (http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)
3. Install the last version of Mozilla Firefox (https://www.mozilla.org/en-US/firefox/new/)
4. Download and copy archive content in C:\Windows\System32  (https://github.com/mozilla/geckodriver/releases)
5. Download and install Git tool (https://git-scm.com/downloads)
6. Add all necessary dependencies to the file "pom.xml"

Project contains 2 folders:
1. Page (Objects included : BasePage, HomePage, SearchResultPage)
2. Test (Tests included : BaseTest, SearchTest)

Run tests:
1. To execute tests run command from terminal: mvn test -DSearchTestSuite=search-test.xml
2. To execute tests from project open: src\test\java\test\SearchTest and press "Run test"