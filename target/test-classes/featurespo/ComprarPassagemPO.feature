Feature: Comprar Passagem PO
    Escolher e comprar passagens aereas (Comentário

    Scenario Outline: Comprar com Sucesso PO
        Given que acesso o site "https://www.blazedemo.com/" PO
        When seleciono a <origem> e <destino> PO
        And clico no botão Find Flights PO
        Then visualizo a lista de voos PO
        When clico no <ordem_do_voo> PO
    Examples:
    | origem      | destino  |  ordem_do_voo |
    | "São Paolo" | "Cairo"  |       2       |
    | "Boston"    | "London" |       5       |
