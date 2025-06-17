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