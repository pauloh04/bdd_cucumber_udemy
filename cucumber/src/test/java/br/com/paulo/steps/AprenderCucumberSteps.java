package br.com.paulo.steps;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.paulo.utils.DateConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AprenderCucumberSteps {

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

	//----
	
	Date entrega = new Date();
	
	@Given("^que a entrega é dia (.*)$")
	public void queAEntregaÉDia(@Transform(DateConverter.class) Date data) throws Throwable {
		entrega = data;
	}

	@When("^a entrega atrasar em (\\d+) (dias|meses)$")
	public void aEntregaAtrasarEmDias(int valor, String tempo) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		
		if(tempo.equals("dias"))
			cal.add(Calendar.DAY_OF_MONTH, valor);
		else
			cal.add(Calendar.MONTH, valor);
		
		entrega = cal.getTime();
	}

	@Then("^deve ser entregue dia (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void deveSerEntregueDia(String data) throws Throwable {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataEntrega = dateFormat.format(entrega);
		assertEquals(dataEntrega, data);
	}
	
	//----
	
	@Given("^que o ticket\\s*(especial)?\\s*é (\\D{2}\\d{3,4})*?$")
	public void queOTicketÉAF(String especial, String task ) throws Throwable {
	}

	@Given("^que o valor da passagem é R\\$ ((\\d)\\.\\d{0,1}){0,1}(\\d){3,4},(\\d){2}$")
	public void queOValorDaPassagemÉR$(String arg1, String arg2, String arg3, String arg4) throws Throwable {
	}

	@Given("^que o nome do passageiro é \"([^\"]*)\"$")
	public void queONomeDoPassageiroÉ(String arg1) throws Throwable {
	}

	@Given("^que o telefone do passageiro é (\\d){3,4}-(\\d){4}$")
	public void queOTelefoneDoPassageiroÉ(int arg1, int arg2) throws Throwable {
	}

	@When("^criar os steps$")
	public void criarOsSteps() throws Throwable {
	}

	@Then("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
	}

	//----
	
}
