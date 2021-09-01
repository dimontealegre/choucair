import java.awt.List;
import java.text.DateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class newdesign {
	
	private WebDriver driver;
	
	
	
	@Before
	public void setUp() {
		System.setProperty("webDriver.chrome.driver", "src\\test\\resourse\\webDriver○\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://newdesign.millionandup.com/");
	
		
	}
	@Test
	
	public void emergente() throws InterruptedException {
		WebElement email = driver.findElement(By.id("email"));
		
		
		WebElement name = driver.findElement(By.id("name"));
		
		WebElement phone = driver.findElement(By.id("phone"));
		
		WebElement btn = driver.findElement(By.id("btnSendModal"));
		String correo ="elivel88@gmail.com";
		String nombre = "Eliana Licett Velasquez Ledesma";
		
		WebElement btnAgenda = driver.findElement(By.id("btnSendModalSchedule"));
		
		
		email.sendKeys(correo);
		name.sendKeys(nombre);
		phone.sendKeys("3015858911");
		btn.click();
		
		
		Thread.sleep(2000);
		//Agenda
		WebElement despliegaCalendario = driver.findElement(By.id("scheduleDate"));
		despliegaCalendario.click();
		
		Actions acciones = new Actions(driver);
		WebElement icono = driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[3]/div/button[2]/span"));//next
		
		acciones.doubleClick(icono).perform();
		driver.findElement(By.linkText("31")).click();//día
		
		driver.findElement(By.xpath("//*[@id=\"scheduleForm\"]/div[4]/div/div/ul/li[3]/span[1]")).click();//hora
		
		driver.findElement(By.xpath("//*[@id=\"scheduleForm\"]/div[6]/div[1]/button[2]")).click();//videollamada
		
		btnAgenda.click();
		driver.getPageSource().contains("Su presentación del proyecto se programó con éxito. Uno de nuestros agentes se contactará en breve para brindarle detalles.");
		Thread.sleep(3000);
	}
	@After
	public void tearDown() {
		driver.quit();
		
	}

}
