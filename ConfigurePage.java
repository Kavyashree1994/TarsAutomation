import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class ConfigurePage {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expectedTitle = "TARS Admin Login Page | Increase Conversion Rates with Conversational Landing Pages for Google Ads - Tars" ;

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kavyashree.kb\\Selenium jar files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://admin.hellotars.com/login");
		System.out.println(driver.getTitle());
		
		String actualTitle = driver.getTitle();
		
		// Verifying the actual title with expected title
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("** PASS - verification successful - The correct Title is Displayed on the Webpage **");
			} else {
			System.out.println("** FAIL - verification unsuccessful **");
			}

		driver.findElement(By.id("login-email")).sendKeys("kavyabhagirath26@gmail.com");
		driver.findElement(By.name("password")).sendKeys("kavya@1994");
		driver.findElement(By.xpath("//*[@id='login-submit']")).click();
		
	    WebElement success=	driver.findElement(By.xpath("//div[text()='Login successful']"));
	    if(success.isDisplayed())
	      {
		     System.out.println("** Pass--- Login Successful is displayed on the Webpage **");
	      }
	      else {
		     System.out.println("Fail");
	      }
		
		driver.findElement(By.xpath("//span[contains(text(),'Payroll')]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Configure')]")).click();
		
		
		WebElement ChatbotTitle = driver.findElement(By.name("title"));
		Assert.assertTrue(ChatbotTitle.isDisplayed());
		ChatbotTitle.clear();
		ChatbotTitle.sendKeys("Payroll123");
		System.out.println(ChatbotTitle.getText());		
		
		driver.findElement(By.id("brand-name")).clear();
        driver.findElement(By.id("brand-name")).sendKeys("Payroll123");
        WebElement TxtBoxContent = driver.findElement(By.xpath("//*[@id='convbot-url-suffix']"));
        System.out.println(TxtBoxContent.getText());
        
        Select s = new Select(driver.findElement(By.id("locale-setting")));
        s.selectByValue("de");
      
        driver.findElement(By.id("convbot-config-save")).click();
        driver.navigate().back();

        driver.quit();
	}

}
