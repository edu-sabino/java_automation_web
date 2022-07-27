package aula1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _1_PrimeirosPassos {
	@Test
	public void primeiroTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.google.com.br");
		driver.manage().window().maximize();

		// Pausa para carregar
		Thread.sleep(2000);

		// Demonstração
		Assertions.assertEquals("Google", driver.getTitle());

		// Fechar a página
		driver.quit();
	}

}
