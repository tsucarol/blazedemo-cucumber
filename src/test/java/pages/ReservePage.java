package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservePage extends CommonPage {

    /* 1. Construtor */
    public ReservePage(WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);
    }

    /* 2. Mapeamento de elementos */
    @FindBy(css = "h3")
    WebElement flightsHeader; // cabeçalho dos vôos

    /* 3. Ações (Não são asserts / validações) */
    public String lerCabecalhoVoos(){
        return flightsHeader.getText();
    }
}
