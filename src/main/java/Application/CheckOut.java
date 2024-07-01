package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut {
    WebDriver driver ;

    public By Name = By.xpath("//*[@id=\"first-name\"]");
    public By LastName = By.xpath("//*[@id=\"last-name\"]");
    public By zipCode = By.xpath("//*[@id=\"postal-code\"]");
    public By ConBtn = By.xpath("//*[@id=\"continue\"]");

  public CheckOut(WebDriver driver) {
        this.driver=driver;
    }
    public void fName(){

      driver.findElement(Name).sendKeys("samkelo");
    }
    public void lName(){
      driver.findElement(LastName).sendKeys("Mnqonywa");

    }
    public void Code(){
       driver.findElement(zipCode).sendKeys(String.valueOf( 1575));
    }
    public void BtnCon(){
      driver.findElement(ConBtn).click();
    }


}
