package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Confirmation {
    WebDriver driver;
    public By finish = By.xpath("//*[@id=\"finish\"]");

    public Confirmation(WebDriver driver){
        this.driver = driver;

    }
public void confB(){
        driver.findElement(finish).click();}
}
