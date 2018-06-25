package SeleniumAd.org.SelMaven;

import org.testng.annotations.Test;

import pages.ExamplePage;
import utility.ExcelUtil;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class NewTest
{
	private WebDriver driver;
  @Test(priority=1,dataProvider="logindata")
  public void f(String uname,String pwd) 
  {
	  /*driver.findElement(By.name("userName")).sendKeys("invalidUN");
	  driver.findElement(By.name("password")).sendKeys("invalidPW");
	  driver.findElement(By.name("login")).click();*/
	  
	  ExamplePage.uname.sendKeys(uname);
	  ExamplePage.pwd.sendKeys(pwd);
	  ExamplePage.login_button.click();
	 
	  
	  
	  
  }
  
  @DataProvider(name="logindata")
  public String[][] login_data() throws Exception
  {
	  ExcelUtil.setExcelPath("sheet1","C:/SELENIUM_SS/Book1.xlsx");
	  String username=ExcelUtil.getCellData(1, 1);
	  String password=ExcelUtil.getCellData(1, 2);
	  
	  return new String[][] {
		  new String[]{username,password}
		  };
  }
  
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.gecko.driver","C:\\SELENIUM_SS\\Selenium Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	  driver =new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get("http://newtours.demoaut.com/");
	  PageFactory.initElements(driver,ExamplePage.class);
	  
  }

  @AfterTest
  public void afterTest() 
  {
	  
  }

}
