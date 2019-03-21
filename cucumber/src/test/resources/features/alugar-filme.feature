#language: pt
Funcionalidade: Alugar filme
  Como um usuário
  Eu quero cadastrar aluguéis de filmes
  Para controlar preços e datas de entrega

  Cenário: Deve alugar um filme com sucesso
    Dado um filme com estoque de 2 unidades
    E que o preço do aluguel seja 3 reais
    Quando alugar
    Então o preço do aluguel será 3 reais
    E a data de entrega será em 1 dias
    E o estoque do filme será 1 unidade

  Cenário: Não deve alugar filme sem estoque
    Dado um filme com estoque de 0 unidades
    Quando alugar
    Então não será possível por falta de estoque
    E o estoque do filme será 0 unidade

  Cenário: Deve dar condições especiais para categoria extendida
    Dado um filme com estoque de 2 unidades
    E que o preço do aluguel seja 4 reais
    E que o tipo dp aluguel seja extendido
    Quando alugar
    Então o preço do aluguel será 8 reais
    E a data de entrega será em 3 dias
    E a pontuação recebida será de 2 pontos

  Cenário: Deve alugar para categoria comum
    Dado um filme com estoque de 2 unidades
    E que o preço do aluguel seja 4 reais
    E que o tipo dp aluguel seja comum
    Quando alugar
    Então o preço do aluguel será 4 reais
    E a data de entrega será em 1 dias
    E a pontuação recebida será de 1 pontos
