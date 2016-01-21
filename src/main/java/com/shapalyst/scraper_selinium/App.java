package com.shapalyst.scraper_selinium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
  private WebDriver driver;

  public static void main(String[] args) throws InterruptedException {
    App app = new App();
    boolean isScrapeSuccess = app.scrape();
    System.out.println("isScrapeSuccess=" + isScrapeSuccess);
  }

  private boolean scrape() throws InterruptedException {

    try {
      driver = new FirefoxDriver();

      // Go to the given product url
      String baseUrl = "https://www.shoppersstop.com/haute-curry-women-cotton-anarkali-printed-churidar-suit/p-9758640";
      String cartUlr = "https://www.shoppersstop.com/cart";
      int DEFAULT_TIMEOUT_IN_SECONDS = 5;
      driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);

      driver.get(baseUrl);
      System.out.println("opening the baseUrl=" + baseUrl);
      clearPopUpAdvertisement(driver);

      // Click on small Size
      WebDriverWait wait = new WebDriverWait(driver, 2);
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
      // driver.findElement(By.linkText("View Bag")).click();
      driver.get(cartUlr);

      Thread.sleep(5 * 1000);
      driver.quit();
      System.out.println("exit from selenium driver");
      return true;

    } catch (NoSuchElementException nsee) {
      System.out.println("site navigation or element has changed " + nsee);
      return false;
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

    try {
      driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");

      if (driver.findElements(
          By.cssSelector("#webklipper-publisher-widget-container-notification-close-div > span > i")).size() != 0) {
        driver.findElement(By.cssSelector("#webklipper-publisher-widget-container-notification-close-div > span > i"))
            .click();
        // driver.switchTo().activeElement().clear();
      }

      // driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']/span/i")).click();

      driver.switchTo().defaultContent();
    } catch (NoSuchFrameException nsfe) {
      // ok no issues
      ;
    }


  }


}
