package commonutilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Hello world!
 *
 */
public class AppDriver 
{
	public static WebDriver driver=null;
	public static Properties Config=new Properties();
	public static Properties Obj=new Properties();
	public static Library library=new Library();;
	@BeforeMethod
	public void launchApp() throws Exception{
		FileInputStream fis_config=new FileInputStream("F:\\ProjectWorkspace\\CrossAsystProject\\src\\main\\java\\properties\\Config.properties");
		Config.load(fis_config);
		FileInputStream obj_config=new FileInputStream("F:\\ProjectWorkspace\\CrossAsystProject\\src\\main\\java\\properties\\Object.properties");
		Obj.load(obj_config);
		if(Config.getProperty("browser").equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", Config.getProperty("driverpath"));
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(Config.getProperty("url"));
	}
/*	@AfterMethod
	public void clickOnSignOut(){
		library.clickOnAnyElement("//a[normalize-space(text())='Sign out']", "xpath", "click");
		//driver.quit();
	}
*/}
