Feature: Comprar Passagem
    Escolher e comprar passagens aereas

    Scenario: Comprar com Sucesso
        Given que acesso o site "https://www.blazedemo.com/"
        When seleciono a origem "São Paolo" e destino "Cairo"
        And clico no botão Find Flights
        Then visualizo a lista de voos


    Scenario Outline: Comprar com Sucesso DDT
        Given que acesso o site "https://www.blazedemo.com/"
        When seleciono a <origem> e <destino>
        And clico no botão Find Flights
        Then visualizo a lista de voos
    Examples:
    | origem      | destino  |
    | "São Paolo" | "Cairo"  |
    | "Boston"    | "London" |


# TESTE POSITIVO SEPARADO DOS TESTES NEGATIVOS (ESTRUTURA MAIS APROVADA PELO MERCADO DE TRABALHO)
    Scenario Outline: Login Positivo
        Given que acesso a página de Login
        When preencho o <email> e a <senha>
        And clico no botão Login
        Then exibe  a mensagem de Login com Sucesso
    Examples:
    | email                   | senha       |
    | cliente@iterasys.com.br | Laranja25   | #1 VV

    Scenario Outline: Login Negativo
        Given que acesso a página de Login
        When preencho o <email> e a <senha>
        And clico no botão Login
        Then exibe  a mensagem de email ou senha incorretos
    Examples:
    | email                   | senha       |
    | cliente@iterasys.com.br | Laranja24   | # VF
    | aluno@iterasys.com.br   | Laranja25   | # FV
    | aluno@iterasys.com.br   | Laranja24   | # FF

# TESTE POSITIVO + TESTES NEGATIVOS
Scenario Outline: Login 
        Given que acesso a página de Login
        When preencho o <email> e a <senha>
        And clico no botão Login
        Then exibe  a mensagem de email ou senha incorretos
    Examples:
    | email                   | senha       | tipo | mensagem                   |
    | cliente@iterasys.com.br | Laranja25   |  P   | Login com Sucesso          |
    | cliente@iterasys.com.br | Laranja24   |  N   | email ou senha incorretos  |
    | aluno@iterasys.com.br   | Laranja25   |  N   | email ou senha incorretos  |
    | aluno@iterasys.com.br   | Laranja24   |  N   | email ou senha incorretos  |