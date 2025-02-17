package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class min1 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://demo.automationtesting.in/Register.html");

        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Ashish");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Dadheech");
        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("C-11 Main street, city, country");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ashishdadheech@gmail.com");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9314804219");

        driver.findElement(By.xpath("//input[@value='Male']")).click();

        driver.findElement(By.id("checkbox1")).click();
        driver.findElement(By.id("checkbox2")).click();
        driver.findElement(By.id("checkbox3")).click();

        driver.findElement(By.id("msdd")).click();
        driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Hindi')]")).click();

        driver.findElement(By.cssSelector("body")).click();
        Thread.sleep(2000);

        Select skills = new Select(driver.findElement(By.id("Skills")));
        skills.selectByVisibleText("Java");

        Select country = new Select(driver.findElement(By.id("countries")));
        country.selectByVisibleText("India");

        driver.findElement(By.xpath("//span[@role='combobox']")).click();
        driver.findElement(By.xpath("//li[contains(text(),'India')]")).click();

        Select year = new Select(driver.findElement(By.id("yearbox")));
        year.selectByVisibleText("1998");

        Select month = new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));
        month.selectByVisibleText("March");

        Select day = new Select(driver.findElement(By.id("daybox")));
        day.selectByVisibleText("10");

        driver.findElement(By.id("firstpassword")).sendKeys("Test@123");
        driver.findElement(By.id("secondpassword")).sendKeys("Test@123");

        driver.findElement(By.id("submitbtn")).click();

        WebElement successMsg = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your registration')]"));

        if (successMsg.isDisplayed()) {
            System.out.println("🎉 Registration Successful!");
        } else {
            System.out.println("❌ Registration Failed!");
        }

        Thread.sleep(5000);

        driver.quit();
    }
}
