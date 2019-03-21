package br.com.paulo.steps;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import br.com.paulo.entity.Filme;
import br.com.paulo.entity.NotaAluguel;
import br.com.paulo.service.AluguelService;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class AlugarFilmesSteps {

	private Filme filme;
	private AluguelService aluguelService = new AluguelService();
	private NotaAluguel notaAluguel;

	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
		filme = new Filme();
		filme.setEstoque(arg1);
	}

	@Dado("^que o preço do aluguel seja (\\d+) reais$")
	public void queOPreçoDoAluguelSejaReais(int arg1) throws Throwable {
		filme.setAluguel(arg1);
	}

	@Quando("^alugar$")
	public void alugar() throws Throwable {
		notaAluguel = aluguelService.alugar(filme);
	}

	@Entao("^o preço do aluguel será (\\d+) reais$")
	public void oPreçoDoAluguelSeráReais(int arg1) throws Throwable {
		assertEquals(arg1, notaAluguel.getPreco());
	}

	@Entao("^a data de entrega será no dia seguinte$")
	public void aDataDeEntregaSeráNoDiaSeguinte() throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);

		Date dataRetorno = notaAluguel.getDataEntrega();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(dataRetorno);
		
		assertEquals(cal.get(Calendar.DAY_OF_MONTH), cal2.get(Calendar.DAY_OF_MONTH));
		assertEquals(cal.get(Calendar.MONTH), cal2.get(Calendar.MONTH));
		assertEquals(cal.get(Calendar.YEAR), cal2.get(Calendar.YEAR));
	}

	@Entao("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable {
		assertEquals(arg1, filme.getEstoque());
	}

}
