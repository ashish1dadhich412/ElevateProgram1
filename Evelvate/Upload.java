package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Upload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver(); 
       driver.get("https://the-internet.herokuapp.com/upload");
       driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\LENOVO\\Downloads\\Ashish Dadheech main 4.pdf");
       driver.findElement(By.id("file-submit")).click();
       System.out.println("file Uploaded !");
       
       driver.get("https://the-internet.herokuapp.com/download");
       driver.findElement(By.cssSelector("a[href='download/Ashish Dadheech main 4.pdf']")).click();
     
       Thread.sleep(3000);
       System.out.println("Downloaded Completed");
		
	}

}
