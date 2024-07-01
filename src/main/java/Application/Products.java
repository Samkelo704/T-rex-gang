package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products {
    WebDriver driver;
public  Products(WebDriver driver){
    this.driver=driver;

}
public void clickOnProducts()
{
    driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

}

public void clickTheCart(){

    driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
}
}
