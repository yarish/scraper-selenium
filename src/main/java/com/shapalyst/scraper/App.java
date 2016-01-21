package com.shapalyst.scraper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
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
      int DEFAULT_TIMEOUT_IN_SECONDS = 5;
      driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);

      // Go to the given product url
      // String baseUrl =
      // "https://www.shoppersstop.com/haute-curry-women-cotton-anarkali-printed-churidar-suit/p-9758640";
      String baseUrl =
          "https://www.shoppersstop.com/demarca-women-bember-and-georgette-saree/p-200355834?PageSpeed=noscript";
      String cartUlr = "https://www.shoppersstop.com/cart";
      driver.get(baseUrl);
      System.out.println("\n(1)Visiting the given product url :\n" + baseUrl);
      clearPopUpAdvertisement(driver);

      // scrape product name
      WebElement productDescriptionElement =
          driver.findElement(By.cssSelector(".product_description > h1:nth-child(2)"));
      String productDescription = productDescriptionElement.getText();
      System.out.println("\nouter html=" + productDescriptionElement.getAttribute("outerHTML"));
      System.out.println("\n(2) scraped productDescription=" + productDescription);

      // Click on medium Size else leave it to default
      // if (driver.findElements(By.xpath("(//a[contains(text(),'M')])[24]")).size() != 0) {
      // driver.findElement(By.xpath("(//a[contains(text(),'M')])[24]")).click();
      // System.out.println("Clicked on Medium size icon");
      // } else {
      // System.out.println("Medium size is not available - leave it as default ");
      // }

      System.out.println("\n(3)Default size is selelcted  ");

      // Click on add to cart
      clearPopUpAdvertisement(driver);
      driver.findElement(By.cssSelector("div.AddToCart-AddToCartAction > #addToCartForm > #addToCartButton")).click();
      System.out.println("\n(4)Clicked on Add to Cart button");

      // click on view bag
      clearPopUpAdvertisement(driver);
      System.out.println("\n(5)Visiting to Cart page");
      driver.get(cartUlr);

      // check weather the added product is available in shopping cart
      WebElement addedProuctInTheCartElement = driver.findElement(By.cssSelector(".pro-name > a:nth-child(1)"));
      String addedProuctInTheCart = addedProuctInTheCartElement.getText();
      System.out.println("\nouter html=" + addedProuctInTheCartElement.getAttribute("outerHTML"));
      System.out.println("\n(6) scraped addedProuctInTheCart=" + productDescription);
      System.out.println("\n===============================================");
      System.out.println("\n(7)Print cart page source =" + driver.getPageSource());
      System.out.println("\n===============================================");

      if (productDescription.equalsIgnoreCase(addedProuctInTheCart)) {
        System.out.println("\n(8)Product is added successfully into the shopping cart!");
        System.out.println("\n means step(2) and step(6) values are same! ");
      }

      driver.quit();
      System.out.println("\n(9)Quit the Firefox driver! ");
      return true;

    } catch (NoSuchElementException nsee) {
      System.out.println("(-1)ERROR: site navigation or element has changed " + nsee);
      return false;
    }

  }

  private void clearPopUpAdvertisement(WebDriver driver) {

    try {
      driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");

      if (driver.findElements(
          By.cssSelector("#webklipper-publisher-widget-container-notification-close-div > span > i")).size() != 0) {
        driver.findElement(By.cssSelector("#webklipper-publisher-widget-container-notification-close-div > span > i"))
            .click();
      }
      driver.switchTo().defaultContent();
    } catch (NoSuchFrameException nsfe) {
      // ok no issues - as long as promotion adv does not come I am happy !
      ;
    }

  }
}
