package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    public WebDriver driver;
    public Cart (WebDriver driver){
        this.driver = driver;
    }

   public void check(){

       driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
   }

}
