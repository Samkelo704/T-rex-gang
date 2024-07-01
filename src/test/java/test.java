import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.*;

import Application.*;


import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class test {
    WebDriver driver;
    ExtentReports reports = new ExtentReports();
    ExtentTest test ;
    ExtentSparkReporter spark;


    @BeforeMethod
    @Parameters({"browser","url"})
    public void setup(String browser,String url){

      if(browser.equalsIgnoreCase("firefox")){
          driver= new FirefoxDriver();
          driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
          driver.manage().window().maximize();


      } else if (browser.equalsIgnoreCase("chrome")) {
          driver = new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
          driver.manage().window().maximize();

      }

      if(url != null && !url.isEmpty()){
          driver.get(url);
      }
      spark = new ExtentSparkReporter("src/main/java/Reporting/reports.html");
      reports.attachReporter(spark);

    }


  @Test(priority = 1)
  public void LoginInvalid () throws InterruptedException, IOException {
      test = reports.createTest("Testing login ","Try to logIn with Invalid Logins");
      Login lg = new Login(driver);
      Thread.sleep(2000);
      lg.UserNameInvalid();
      Thread.sleep(2000);
      lg.PaswordInvalid();
      Thread.sleep(2000);
      lg.LoginB();
      Thread.sleep(2000);
      WebElement HD = driver.findElement(By.xpath("//*[@id=\"root\"]"));
      File source = HD.getScreenshotAs(OutputType.FILE);
      File DS = new File("src/main/java/utilitis/HomePageWithInvalid.png");
      FileHelper.copyFile(source,DS);
      test.log(Status.FAIL, "Failed to login");
  }
@Test(priority = 2)
    public void LogIn () throws InterruptedException, IOException {

        test = reports.createTest("Testing Login", "Trying to login with valid details");
        WebElement SwayName = driver.findElement(By.className("form_group"));
        WebElement credit = driver.findElement(RelativeLocator.with(By.className("login_logo")).above(SwayName));
        System.out.println(credit.getText());
        WebElement HhD = driver.findElement(By.xpath("//*[@id=\"root\"]"));
       File sourceH = HhD.getScreenshotAs(OutputType.FILE);
       File DSh = new File("src/main/java/utilitis/HomePage.png");
       FileHelper.copyFile(sourceH,DSh);
       String Webname = "Swag Labs";
             if(Webname.matches(credit.getText())) {
              test.log(Status.PASS, "it is on the home page");
          }else {
          test.log(Status.FAIL, "it failed to locate the home page");
}
             Login LG = new Login(driver);
            Thread.sleep(2000);
             LG.UserName();
             Thread.sleep(2000);
             LG.Pasword();
             Thread.sleep(2000);
             LG.LoginB();
             Thread.sleep(2000);
        WebElement PrD = driver.findElement(By.xpath("//*[@id=\"root\"]"));
        File PdSC = PrD.getScreenshotAs(OutputType.FILE);
        File pDS = new File("src/main/java/utilitis/ProductPage.png");
        FileHelper.copyFile(PdSC,pDS);
        WebElement PR = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
             if(PR.getText().equals("Products")){
        test.log(Status.PASS,"it is on the Product page");
        }else{
                 test.log(Status.FAIL,"it is not in the Product page");
             }
          Products PD = new Products(driver);
             Thread.sleep(2000);
          PD.clickOnProducts();
          Thread.sleep(2000);
           PD.clickTheCart();
           Thread.sleep(2000);
             LG.BarM();
             Thread.sleep(2000);
            LG.UserName();
            Thread.sleep(2000);
            LG.Pasword();
            Thread.sleep(2000);
            LG.LoginB();
            Thread.sleep(2000);
             PD.clickOnAnotherProducts();
             Thread.sleep(2000);
             PD.clickTheCart();
             Thread.sleep(2000);
             WebElement CH  = driver.findElement(By.xpath("//*[@id=\"root\"]"));
               File chD = CH.getScreenshotAs(OutputType.FILE);
                File DCh = new File("src/main/java/utilitis/CartPage.png");
                FileHelper.copyFile(chD,DCh);

              if(CH.isDisplayed()) {
                  test.log(Status.PASS,"it is on the Cart page");
              }else{
                  test.log(Status.FAIL,"it failed to check out in cart");
              }
           Cart Ct = new Cart(driver);
              Thread.sleep(2000);
           Ct.check();
           Thread.sleep(2000);
        WebElement SD = driver.findElement(By.xpath("//*[@id=\"root\"]"));
        File cD = SD.getScreenshotAs(OutputType.FILE);
        File DC = new File("src/main/java/utilitis/CheckOutPage.png");
        FileHelper.copyFile(cD,DC);
    WebElement ckp = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        if (ckp.isDisplayed()) {
            test.log(Status.PASS,"it is on the Checkout page");
        }else{
            test.log(Status.FAIL,"it failed to check out in cart");
        }
        CheckOut ck = new CheckOut(driver);
        Thread.sleep(2000);
        ck.fName();
        Thread.sleep(2000);
        ck.lName();
        Thread.sleep(2000);
        ck.Code();
        Thread.sleep(2000);
        ck.BtnCon();
        Thread.sleep(2000);
        WebElement Sp = driver.findElement(By.xpath("//*[@id=\"root\"]"));
        File cDp = Sp.getScreenshotAs(OutputType.FILE);
        File DCp = new File("src/main/java/utilitis/OverViewPage.png");
        FileHelper.copyFile(cDp,DCp);
        if(Sp.isDisplayed()){
            test.log(Status.PASS,"it is on the Overview page");
    }else{
            test.log(Status.FAIL,"it failed to open Overview page");
    }

       Confirmation cn = new Confirmation(driver);
        Thread.sleep(2000);
        cn.confB();
        Thread.sleep(2000);
        test.log(Status.PASS,"Order has been confirmed");
    WebElement Spt = driver.findElement(By.xpath("//*[@id=\"root\"]"));
    File cDt = Sp.getScreenshotAs(OutputType.FILE);
    File DCpt = new File("src/main/java/utilitis/ConfirmationPage.png");
    FileHelper.copyFile(cDt,DCpt);

    }



    @AfterMethod
    public void tearDwn() throws IOException {

        reports.flush();
        File html = new File("src/main/java/Reporting/reports.html");
        if(html.exists()&& Desktop.isDesktopSupported()){
            Desktop.getDesktop().browse(html.toURI());
        }else {
            System.out.println("Desktop is not supported");
        }
        driver.quit();
    }
}
