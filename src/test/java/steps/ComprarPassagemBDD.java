package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ComprarPassagemBDD {

    WebDriver driver = new ChromeDriver(); // instancia o objeto Selenium Webdriver como ChromeDriver (faz a comunicação entre o código com o navegador)
    String origem, destino;

    @Before
    public void iniciar() {
        WebDriverManager.chromedriver().setup(); // garantir o driver correto para o Chrome
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000)); // definir o tempo de espera implicito de 3 segundos
        driver.manage().window().maximize(); // exibir a janela maximizada
    }

    @After
    public void finalizar() {
        driver.quit(); // destruir o objeto do Selenium
    }


    @Given("que acesso o site {string}")
    public void que_acesso_o_site(String url) {
        driver.get(url); 
    }

    @When("seleciono a origem {string} e destino {string}")
    public void seleciono_a_origem_e_destino(String origem, String destino) {
        {
            this.origem = origem;
            WebElement lista = driver.findElement(By.name("fromPort"));
            lista.click();
            lista.findElement(By.xpath("//option[. = '" + origem + "']")).click();
        }
        {
            this.destino = destino;
            WebElement lista = driver.findElement(By.name("toPort"));
            lista.click();
            lista.findElement(By.xpath("//option[. = '" + destino + "']")).click();
        }
    }

    @And("clico no botão Find Flights")
    public void clico_no_botão_find_flights() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @Then("visualizo a lista de voos")
    public void visualizo_a_lista_de_voos() {
        assertEquals("Flights from " + origem +  " to " + destino + ":",
        driver.findElement(By.cssSelector("h3")).getText());
    }

}
