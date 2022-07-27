package aula02;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _1_InteragindoComElementos {
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
	@DisplayName("Automatizar cadastro de novo usuário no Facebook")
	public void cadastro() throws InterruptedException {
		driver.get("https://pt-br.facebook.com/");

		Thread.sleep(2000);
		// driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		// Thread.sleep(2000);
		driver.findElement(By.linkText("Criar nova conta")).click();
		Thread.sleep(2000);
		// Dentro da tela de cadastro
		driver.findElement(By.name("firstname")).sendKeys("Eduardo");
		driver.findElement(By.name("lastname")).sendKeys("Silva");
		driver.findElement(By.name("reg_email__")).sendKeys("eass6@discente.ifpe.edu.br");
		// driver.findElement(By.name("reg_email_confirmation__")).sendKeys("eass6@discente.ifpe.edu.br");
		driver.findElement(By.name("reg_passwd__")).sendKeys("admin123");
		Thread.sleep(2000);

		// COMBOBOX //

		WebElement comboDia = driver.findElement(By.id("day"));
		Select selectDia = new Select(comboDia);
		// selectDia.selectByIndex(2);
		// selectDia.selectByValue("8");
		selectDia.selectByVisibleText("11");
		Thread.sleep(1000);

		WebElement comboMes = driver.findElement(By.id("month"));
		Select selectMes = new Select(comboMes);
		selectMes.selectByVisibleText("Nov");
		Thread.sleep(1000);

		WebElement comboAno = driver.findElement(By.id("year"));
		Select selectAno = new Select(comboAno);
		selectAno.selectByVisibleText("1987");
		Thread.sleep(1000);

		// RADIOBUTTON -> Feminino (1), Masculino (2), Personalizdo (-1)//

		List<WebElement> radios = driver.findElements(By.name("sex"));
		for (WebElement radio : radios) {
			if (radio.getAttribute("value").contentEquals("2") && (!radio.isSelected())) {
				radio.click();
			}
		}

		// SUBMIT//

		driver.findElement(By.name("websubmit")).submit();

	}

	@Test
	@DisplayName("Pesquisando o CV Lattes de uma pessoa pelo nome.")
	public void pesquisa() throws InterruptedException {
		driver.get("https://buscatextual.cnpq.br/buscatextual/busca.do");
		Thread.sleep(2000);

		driver.findElement(By.name("textoBusca")).sendKeys("Eduardo Antonio Sabino Silva");
		Thread.sleep(2000);
		driver.findElement(By.name("buscarDemais")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("buscarDoutores")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("botaoBuscaFiltros")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Eduardo Antonio Sabino Silva")).click();
		Thread.sleep(2000);
	}

	@AfterEach
	public void depoisDeCada() {
		// Fechar a página
		driver.quit();
	}

}
