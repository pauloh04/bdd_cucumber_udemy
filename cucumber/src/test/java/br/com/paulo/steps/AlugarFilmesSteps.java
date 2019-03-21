package br.com.paulo.steps;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.paulo.entity.Filme;
import br.com.paulo.entity.NotaAluguel;
import br.com.paulo.entity.TipoAluguel;
import br.com.paulo.service.AluguelService;
import br.com.paulo.utils.DateUtils;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AlugarFilmesSteps {

	private Filme filme;
	private AluguelService aluguelService = new AluguelService();
	private NotaAluguel notaAluguel;
	private String erro;
	private TipoAluguel tipoAluguel = TipoAluguel.COMUM;

	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
		filme = new Filme();
		filme.setEstoque(arg1);
	}

	@Dado("^que o preço do aluguel seja (\\d+) reais$")
	public void queOPreçoDoAluguelSejaReais(int arg1) throws Throwable {
		filme.setAluguel(arg1);
	}

	@Dado("^que o tipo dp aluguel seja (.*)$")
	public void queOTipoDpAluguelSejaExtendido(String tipo) throws Throwable {
		tipoAluguel = tipo.equals("comum") ? TipoAluguel.COMUM
				: tipo.equals("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.SEMANAL;
	}

	@Quando("^alugar$")
	public void alugar() throws Throwable {
		try {
			notaAluguel = aluguelService.alugar(filme, tipoAluguel);
		} catch (Exception e) {
			erro = e.getMessage();
		}
	}

	@Então("^o preço do aluguel será (\\d+) reais$")
	public void oPreçoDoAluguelSeráReais(int arg1) throws Throwable {
		assertEquals(arg1, notaAluguel.getPreco());
	}

	@Então("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable {
		assertEquals(arg1, filme.getEstoque());
	}

	@Então("^não será possível por falta de estoque$")
	public void nãoSeráPossívelPorFaltaDeEstoque() throws Throwable {
		assertEquals("Falta de estoque", erro);
	}

	@Então("^a data de entrega será em (\\d+) dias?$")
	public void aDataDeEntregaSeráEmDias(int arg1) throws Throwable {
		Date dataEsperada = DateUtils.obterDiferencaDias(arg1);
		Date dataReal = notaAluguel.getDataEntrega();

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		assertEquals(df.format(dataReal), df.format(dataEsperada));
	}

	@Então("^a pontuação recebida será de (\\d+) pontos$")
	public void aPontuaçãoRecebidaSeráDePontos(int arg1) throws Throwable {
		assertEquals(arg1, notaAluguel.getPontuacao());
	}
}
