package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TutorialNinjaAutomation {
    public static void main(String[] args) {
        // Step 1: Setup ChromeDriver using WebDriverManager (No need for manual driver setup)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Step 2: Open the e-commerce website
            driver.get("https://tutorialsninja.com/demo/");
            System.out.println("Website opened successfully!");

            // Step 3: Search for a product (e.g., "Laptop")
            WebElement searchBox = driver.findElement(By.name("search"));
            searchBox.sendKeys("Laptop");
            driver.findElement(By.cssSelector(".btn-default")).click();
            System.out.println("Product searched!");

            // Step 4: Wait for search results & Click on the first product
            WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product-layout .product-thumb h4 a")));
            firstProduct.click();
            System.out.println("First product clicked!");

            // Step 5: Add the product to cart
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-cart")));
            addToCartButton.click();
            System.out.println("Product added to cart!");

            // Step 6: Verify the product is added to the cart
            WebElement cartButton = driver.findElement(By.id("cart-total"));
            cartButton.click();

            WebElement cartItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".table-responsive tbody tr")));

            if (cartItem.isDisplayed()) {
                System.out.println("Test Passed: Product successfully added to cart!");
            } else {
                System.out.println("Test Failed: Product not found in cart!");
            }

        } catch (Exception e) {
            System.out.println("Test Failed: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
            System.out.println("Test completed and browser closed.");
        }
    }
}
