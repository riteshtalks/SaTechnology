# SaTechnology
SaTechnology Test

Created this project on maven with java, selenium and testNG.

1. In POM.xml file, provided the dependencies of selenium and testNG
2. Created testNG class with below methods:
   a. beforetest() with @BeforeTest annotation to initiate browser.
   b. confirmAccessibilityOfTheTopLevelMenus() method with @Test annotation to gverify tyhe Top-Level menu items
   c. verifyRequestADemoButton() method with @Test annotation to verify the 'Request A Demo' button.
   d. verifyContactUs() method with @Test annotation to verify the 'Contact Us' then from fillup scenarios.

3. Assert classs is used to assert the actual and expected result.
4. Select class is used to select from 'Job Role' drop down menu
5. Explicit wait is used to click on 'I Agree' toggle checkbox as there was inbuilt chrom popup was coming which was not allowing to click at that time.
6. Defect document is attached.
   
