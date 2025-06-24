package stepspo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Base;
import pages.HomePage;
import pages.ReservePage;

public class ComprarPassagemPO {

    /* Atributos - Estágio Final */
    final WebDriver driver;             // Selenium só pode usar e devolver
    private HomePage homePage;          // Só eu posso usar a Home
    private ReservePage reservePage;    // Só eu posso usar a Reserve

    public String origem;
    public String destino;

    public ComprarPassagemPO (Base base){
        this.driver = base.driver;
    }

    /* As anotações @Before e @After ficam no Hooks.java */

    @Given("que acesso o site {string} PO")
    public void que_acesso_o_site_po(String url) {
        homePage = new HomePage(driver);
        homePage.acessarHomePage(url);

        // validar se abriu a página correta através do nome da guia
        assertEquals("BlazeDemo", homePage.lerNomeDaGuia());
        
    }

    @When("seleciono a {string} e {string} PO")
    public void seleciono_a_e_po(String origem, String destino) {
        this.origem = origem; // this.origem é a variável origem | = origem vem do arquivo .feature
        this.destino = destino;
        homePage.selecionarOrigemDestino(origem, destino);

        //ToDo: Na preparação de aula há um ajuste de sincronismo
        // para conseguir visualizar o robô escolhendo
    }

    @And("clico no botão Find Flights PO")
    public void clico_no_botão_find_flights_po() {
        homePage.clicarBtnFindFlights();
        // chama a página seguinte --> Reserve
        reservePage = new ReservePage(driver);
    }

    @Then("visualizo a lista de voos PO")
    public void visualizo_a_lista_de_voos_po() {
        assertEquals("BlazeDemo - reserve", reservePage.lerNomeDaGuia());
        assertEquals("Flights from " + this.origem + " to  " + this.destino + ":", reservePage.lerCabecalhoVoos());
        assertEquals(driver, destino);
    }
}
