package Application;

import dev.failsafe.internal.util.Assert;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;


public class Login
{
    WebDriver driver;
    public By UserNam = By.xpath("//*[@id=\"user-name\"]");
    public By LoginB = By.xpath("//*[@id=\"login-button\"]");
    public By Password = By.xpath("//*[@id=\"password\"]");
    public By LogOut =  By.xpath("//*[@id=\"logout_sidebar_link\"]");
    public By Menu = By .xpath("//*[@id=\"react-burger-menu-btn\"]");

;
    public  Login (WebDriver driver)  {
        this.driver = driver;

    }
 public void UserName () throws IOException {

      FileInputStream file  = new FileInputStream("src/main/java/Data/Data2.xlsx");
      Workbook workbook = new XSSFWorkbook(file);
      Sheet sheet = workbook.getSheet("Sheet1");

      Row row = sheet.getRow(1);
      Cell usernameCell = row.getCell(0);
      String username = usernameCell.getStringCellValue();
      driver.findElement(UserNam).sendKeys(username);

    }
    public void UserNameInvalid () throws IOException {
        FileInputStream file  = new FileInputStream("src/main/java/Data/Data2.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet("Sheet1");

        Row row = sheet.getRow(2);
        Cell usernameCell = row.getCell(0);
        String username = usernameCell.getStringCellValue();
        driver.findElement(UserNam).sendKeys(username);

    }


public void LoginB (){
    driver.findElement(LoginB).click();
}
public void Pasword ( ) throws IOException {
    FileInputStream file  = new FileInputStream("src/main/java/Data/Data2.xlsx");
    Workbook workbook = new XSSFWorkbook(file);
    Sheet sheet = workbook.getSheet("Sheet1");

    Row row = sheet.getRow(1);
    Cell PasswCell = row.getCell(1);
    String password = PasswCell.getStringCellValue();
    driver.findElement(Password).sendKeys(password);
}
    public void PaswordInvalid ( ) throws IOException {
        FileInputStream file  = new FileInputStream("src/main/java/Data/Data2.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet("Sheet1");

        Row row = sheet.getRow(2);
        Cell PasswCell = row.getCell(1);
        String password = PasswCell.getStringCellValue();
        driver.findElement(Password).sendKeys(password);
    }
public void BarM (){
        driver.findElement(Menu).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    WebElement LT = wait.until(ExpectedConditions.elementToBeClickable(LogOut));
    LT.click();
}
/*<test name="Testing_Firefox">
    <parameter name="browser" value="firefox"/>
    <parameter name="url" value= "https://www.saucedemo.com"/>
    <classes>
        <class name="test">
        </class>
    </classes>
</test>*/
}
