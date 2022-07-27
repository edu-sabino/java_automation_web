package aula01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
	public void antesDoMetodo() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	@Disabled
	public void findElementByName() throws InterruptedException {
		driver.get("http://www.google.com.br");
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys("IFPE Jaboatão");
		Thread.sleep(3000);
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(2000);
	}
	@Test
	@Disabled
	public void findElementByPartialLinkText() throws InterruptedException {
		driver.get("http://www.google.com.br");
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		//Informar "IFPE Jaboatão"
		campoDeTexto.sendKeys("IFPE Jaboatão");
		Thread.sleep(3000);
		//Clicar no botão pesquisar
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(2000);
		//Entrar no primeiro link que contenha o termo Jaboatão.
		driver.findElement(By.partialLinkText("Jaboatão")).click();
		Thread.sleep(2000);
		//Dentro do site do IFPE, clicar em Cursos
		driver.findElement(By.linkText("Cursos")).click();
		Thread.sleep(2000);
	}
	@Test
	@Disabled
	public void findElementByCSS() throws InterruptedException {
		driver.get("http://www.google.com.br");
		WebElement campoDeTexto = driver.findElement(By.cssSelector("input[name=\"q\"]"));
		//Informar "IFPE Jaboatão"
		campoDeTexto.sendKeys("IFPE Jaboatão");
		Thread.sleep(3000);
		//Clicar no botão pesquisar
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(2000);
		//Entrar no primeiro link que contenha o termo Jaboatão.
		driver.findElement(By.partialLinkText("Jaboatão")).click();
		Thread.sleep(2000);
		//Dentro do site do IFPE, clicar em Cursos
		driver.findElement(By.linkText("Cursos")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("*[id='f1b2a2df48c64d11a3d6fa651d200977'] h2")).getText());
	}
	@Test
	public void findElementByXPath() throws InterruptedException {
		driver.get("http://www.google.com.br");
		WebElement campoDeTexto = driver.findElement(By.cssSelector("input[name=\"q\"]"));
		//Informar "IFPE Jaboatão"
		campoDeTexto.sendKeys("IFPE Jaboatão");
		Thread.sleep(3000);
		//Clicar no botão pesquisar
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(2000);
		//Entrar no primeiro link que contenha o termo Jaboatão.
		driver.findElement(By.partialLinkText("Jaboatão")).click();
		Thread.sleep(2000);
		//Dentro do site do IFPE, clicar em Cursos
		driver.findElement(By.linkText("Cursos")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//*[@id='f1b2a2df48c64d11a3d6fa651d200977']//h2")).getText());
	}
	@AfterEach
	public void depoisDoMetodo() {
		//Fechar
		driver.quit();
	}
}
