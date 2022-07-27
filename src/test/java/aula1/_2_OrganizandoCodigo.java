package aula1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _2_OrganizandoCodigo {
	ChromeDriver driver;

	@BeforeAll
	public static void antesDeTudo() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void antesDeCada() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	@Disabled
	public void findElementByName() throws InterruptedException {
		driver.get("http://www.google.com.br");
		// Thread.sleep(5000);
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys("IFPE Jaboatão");
		Thread.sleep(5000);
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(2000);
	}
	@Test
	public void findElementByPartialLinkText() throws InterruptedException {
		driver.get("http://www.google.com.br");
		// Thread.sleep(5000);
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys("IFPE Jaboatão");
		Thread.sleep(3000);
		campoDeTexto.submit();
		driver.findElement(By.name("btnl")).click();
		//driver.findElement(By.name("btnK")).click();
		Thread.sleep(2000);
		//System.out.println(driver.findElement(By.cssSelector(div[id="f1b2a2df48c64d11a3d6fa651d200977"])));
	}

	@AfterEach
	public void depoisDeCada() {
		// Fechar a página
		driver.quit();
	}

}
