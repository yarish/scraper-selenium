package com.shapalyst.scraper_selinium;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App {

  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();


  public static void main(String[] args) throws InterruptedException {

    App app = new App();
    app.scrape();
  }


  private void scrape() throws InterruptedException {
    driver = new FirefoxDriver();

    // Go to the given product url
    baseUrl = "https://www.shoppersstop.com/haute-curry-women-cotton-anarkali-printed-churidar-suit/p-9758640";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    driver.get(baseUrl);
    System.out.println("opening the baseUrl=" + baseUrl);
    clearPopUpAdvertisement(driver);

    // Click on small Size
    WebDriverWait wait = new WebDriverWait(driver, 30);
    driver.findElement(By.xpath("(//a[contains(text(),'M')])[24]")).click();
    System.out.println("Clicked on Medium size icon");

    // Click on add to cart
    clearPopUpAdvertisement(driver);
    // wait.until(ExpectedConditions.elementToBeClickable(By
    // .cssSelector("div.AddToCart-AddToCartAction > #addToCartForm > #addToCartButton")));
    driver.findElement(By.cssSelector("div.AddToCart-AddToCartAction > #addToCartForm > #addToCartButton")).click();
    System.out.println("Clicked on Add to Cart button");

    // click on view bag
    clearPopUpAdvertisement(driver);
    // wait.until(ExpectedConditions.elementToBeClickable(By.id("minicart_id")));
    // driver.findElement(By.id("minicart_id")).click();
    driver.findElement(By.linkText("View Bag")).click();
    Thread.sleep(5 * 1000);
    driver.quit();

    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }


  }


  private void clearPopUpAdvertisement(WebDriver driver) {

    // if
    // (driver.findElements(By.cssSelector("#webklipper-publisher-widget-container-notification-close-div > span > i"))
    // .size() != 0) {
    // driver.findElement(By.cssSelector("#webklipper-publisher-widget-container-notification-close-div > span > i"))
    // .click();
    // driver.switchTo().activeElement().clear();
    // }
    //
    // if (driver.findElements(By.cssSelector("#\\~b05bc807")).size() != 0) {
    // driver.findElement(By.cssSelector("#\\~b05bc807")).click();
    // driver.get(baseUrl);
    // }

    // driver.get("https://www.shoppersstop.com/discount-promotions");
    // driver.get(baseUrl);

    driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");

    if (driver.findElements(By.cssSelector("#webklipper-publisher-widget-container-notification-close-div > span > i"))
        .size() != 0) {
      driver.findElement(By.cssSelector("#webklipper-publisher-widget-container-notification-close-div > span > i"))
          .click();
      // driver.switchTo().activeElement().clear();
    }

    // driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']/span/i")).click();

    driver.switchTo().defaultContent();



  }


}
