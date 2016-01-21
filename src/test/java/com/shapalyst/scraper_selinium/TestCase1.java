package com.shapalyst.scraper_selinium;
//package com.shapalyst.scraper;
//
//
//import java.util.regex.Pattern;
//import java.util.concurrent.TimeUnit;
//import org.testng.annotations.*;
//import static org.testng.Assert.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//
//public class TestCase1 {
//  private WebDriver driver;
//  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();
//
//  @BeforeClass(alwaysRun = true)
//  public void setUp() throws Exception {
//    driver = new FirefoxDriver();
//    baseUrl = "https://www.shoppersstop.com/";
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//  }
//
//  @Test
//  public void testCase1() throws Exception {
//    driver.get(baseUrl + "/haute-curry-women-cotton-anarkali-printed-churidar-suit/p-9758640");
//    driver.findElement(By.cssSelector("li.selected.scroll > a")).click();
//    driver.findElement(By.cssSelector("div.AddToCart-AddToCartAction > #addToCartForm > #addToCartButton")).click();
//    driver.findElement(By.id("minicart_id")).click();
//    driver.wait(1000*30);
//  }
//
//  @AfterClass(alwaysRun = true)
//  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
//  }
//
//  private boolean isElementPresent(By by) {
//    try {
//      driver.findElement(by);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      driver.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }
//
//  private String closeAlertAndGetItsText() {
//    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
//      if (acceptNextAlert) {
//        alert.accept();
//      } else {
//        alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
//}
