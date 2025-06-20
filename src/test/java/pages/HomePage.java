package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonPage {
    
    /* 1. Construtor - ligando a HomePage com CommonPage */
    public HomePage(WebDriver driver){
        super (driver); // driver herdado de CommonPage - super classe
        PageFactory.initElements(driver, this);
    }

    /* 2. Elementos Mapeados - Funções */

    // mapeamento para os combos Origem e Destino
    public By byLocal(String local) {
        return By.cssSelector("option[value=\"" + local + "\"]"); // == option[value="Rome"]
    }

    @FindBy(css = "input[value]")
    WebElement btnFindFlights;

    /* 3. Ações com os elementos mapeados */
    public void acessarHomePage() {
        driver.get("https://blazedemo.com");
    }

    public void selecionarOrigemDestino(String byOrigem, String byDestino) {
        driver.findElement(byLocal(byOrigem)); // seleciona na lista o valor de "Origem"
        driver.findElement(byLocal(byDestino)); // seleciona na lista o valor de "Destino"
    }

    public void clicarBtnFindFlights(){
        btnFindFlights.click();
    }
}
