package pages;

import org.openqa.selenium.WebDriver;

/* Está se comunincando com Base.java */
public class CommonPage {
    
    public WebDriver driver; // "bola quando recebe o passe"

    /* Construtor - conecta o exterior com o interior da classe */
    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    /* Funções em comum nas páginas aqui */
    public String lerNomeDaGuia() {
        return driver.getTitle();
    }
}
