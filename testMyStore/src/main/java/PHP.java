import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PHP {
	
	private WebDriver driver;
	By user = By.name("username");
	By pass = By.name("password");
	By btn = By.name("FormsButton2");
	
	String usuario = "elivelasquez";
	String clave = "A1234567";
	
	
	@Before
	public void setUp() {
		System.setProperty("webDriver.chrome.driver", "src\\test\\resourse\\webDriver○\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("http://thedemosite.co.uk/addauser.php");
	
		
		/*/
		WebElement user = driver.findElement(By.name("username"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement btnsave = driver.findElement(By.name("FormsButton2"));
		*/
	}

	@Test
	
	public void usuario () throws InterruptedException {

		
		driver.findElement(user).click();
		driver.findElement(user).sendKeys(usuario);
		driver.findElement(pass).sendKeys(clave);
		driver.findElement(btn).click(); 
		
		Thread.sleep(2000);
		
		driver.getPageSource().contains("The username: elivelasquez");

		
		
		
	}
	
	@Test
	
	public void login() throws InterruptedException {
		
		driver.findElement(By.linkText("move onto the Login page to test it!")).click();
		driver.findElement(user).click();
		driver.findElement(user).sendKeys(usuario);
		driver.findElement(pass).click();
		driver.findElement(pass).sendKeys(clave);
		driver.findElement(btn).click();

		Thread.sleep(3000);
		
		driver.getPageSource().contains("Successful Login");
	}
	
	@After
	
	public void tearDown() {
		driver.quit();
		
	}
	
	
	
}
