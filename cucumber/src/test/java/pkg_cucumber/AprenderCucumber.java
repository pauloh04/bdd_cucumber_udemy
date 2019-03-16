package pkg_cucumber;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AprenderCucumber {

	@Given("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable {
	}

	@When("^executa-lo$")
	public void executaLo() throws Throwable {
	}

	@Then("^a especificacao deve finalizar com sucesso$")
	public void aEspecificacaoDeveFinalizarComSucesso() throws Throwable {
	}
	
	//----
	
	private int contador = 0;
	
	@Given("^que o valor do contador e (\\d+)$")
	public void queOValorDoContadorE(int valor) throws Throwable {
		contador = valor;
	}

	@When("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int valor) throws Throwable {
		contador = contador + valor;
	}

	@Then("^o valor do contador sera (\\d+)$")
	public void oValorDoContadorSera(int valor) throws Throwable {
		assertEquals(valor, contador);
	}

}
