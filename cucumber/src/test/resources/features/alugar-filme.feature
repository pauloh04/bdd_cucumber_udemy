#language: pt
Funcionalidade: Alugar filme
  Como um usuário
  Eu quero cadastrar aluguéis de filmes
  Para controlar preços e datas de entrega

  Cenário: Deve alugar um filme com sucesso
    Dado um filme com estoque de 2 unidades
    E que o preço do aluguel seja 3 reais
    Quando alugar
    Entao o preço do aluguel será 3 reais
    E a data de entrega será no dia seguinte
    E o estoque do filme será 1 unidade