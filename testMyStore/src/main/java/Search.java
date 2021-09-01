import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search  {

	
	private WebDriver driver;

	
	@Before
	public void setUp() {
		System.setProperty("webDriver.chrome.driver", "src\\test\\resourse\\webDriver○\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("http://automationpractice.com/index.php");

}
	@Test
	
	public void consulta () {
		WebElement search = driver.findElement(By.id("search_query_top"));
			
		search.clear();
		search.sendKeys("Mujeres");
		search.submit();
		driver.getPageSource().contains("Please enter a search keyword");

		
	}
	
	@After
	
	public void tearDown() {
		driver.quit();
		
	}
	
}
