package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends CommonPage {
    
    /* 1. Construtor - ligando a HomePage com CommonPage */
    public HomePage(WebDriver driver){
        super (driver); // driver herdado de CommonPage - super classe
        PageFactory.initElements(driver, this);
    }

    /* 2. Elementos Mapeados - Funções */

    // mapeamento para os combos Origem e Destino (são estruturas praticamente iguais)
    @FindBy(name = "fromPort")
    WebElement selectOrigem;

    @FindBy(name = "toPort")
    WebElement selectDestino;

    // mapeamento do botão "Find Flights"
    @FindBy(css = ".btn-primary")
    //@FindBy(css = "input[value]")
    WebElement btnFindFlights;

    /* 3. Ações com os elementos mapeados */
    public void acessarHomePage(String url) {
        driver.get(url);
    }

    public void selecionarOrigemDestino(String origem, String destino) {
        new Select(selectOrigem).selectByVisibleText(origem); // seleciona na lista o valor de "Origem"
        new Select(selectDestino).selectByVisibleText(destino); // seleciona na lista o valor de "Destino"
    }

    public void clicarBtnFindFlights(){
        btnFindFlights.click();
    }
    
}
