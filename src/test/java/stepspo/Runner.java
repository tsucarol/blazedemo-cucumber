package stepspo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions (
    features = { "src/test/resources/featurespo" },     // caminho para as features
    glue =     { "stepspo" },                           // caminho para a automação
    dryRun = false,                                     // exibição do log
    monochrome = true                                   // detalhes do log
)
public class Runner {
    /* Classe vazia. Será programada se um framework de relatório for adicionado no projeto */
}
