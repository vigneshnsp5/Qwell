package Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	public static WebDriver driver;
	
	static String property = ".//src//Common//Properties.properties"; 
	
	public static Properties property() throws IOException {
		
		FileInputStream fis = new FileInputStream(property);
		
		Properties pro = new Properties();
		
		pro.load(fis);
		
		return pro;
		
	}
	
	public static String browserName() throws IOException {
		
		String browsername=	property().getProperty("browser");
		System.out.println(browsername);
		return browsername;	
	}
	
	public static String chromeBrowserPath() throws IOException {
		String path = property().getProperty("chromedriver");
		return path;
	}
	public static String firefoxBrowserPath() throws IOException {
		String path = property().getProperty("firefoxdriver");
		return path;
	}
	
	public static String screenshotPath() throws IOException {
		String path = property().getProperty("screenshot");
		return path;
	}
	
	public static String datafilepath() throws IOException{
		String path = property().getProperty("datafile");
		return path;
	}
	public static String url() throws IOException{
		String path =  property().getProperty("url");
		return path;
	}
	
  @BeforeTest
  public void launchBrowser() throws IOException {
	  
	  if(browserName().equals("chrome")) {
		  System.setProperty("webdriver.chrome.driver", chromeBrowserPath());
		  driver = new ChromeDriver();
	  }
	  else if(browserName().equals("firefox")) {
		  System.setProperty("webdriver.gecko.driver", firefoxBrowserPath());
		  driver = new FirefoxDriver();  
	  }
	  else {
		  System.out.println("This is not the valid browser");
	  }
	  driver.manage().window().maximize();
	  driver.get(url());
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  }
  
  //@AfterTest
  public void closeBroser() {
	  
	  driver.close();
	  
  }
  
  public static void takeScreenShot(String filename) throws IOException {
	  EventFiringWebDriver ef = new EventFiringWebDriver(driver);
	  File f1 = ef.getScreenshotAs(OutputType.FILE);
	  File f2 = new File(screenshotPath()+filename+".png");
	  FileUtils.copyFile(f1, f2);
  }
  
  public static String testData(String sheetname, int r, int c) throws IOException, Exception {
	 
	  FileInputStream fis = new FileInputStream(datafilepath());
	  
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet sheet = wb.getSheet(sheetname);
	  XSSFRow row = sheet.getRow(r);
	  XSSFCell cell = row.getCell(c);
	  String data = cell.getStringCellValue();
	  return data;  
  }
  
  
  
  
  
  
}
