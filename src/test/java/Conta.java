import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {
	public int saldo, saque;
	public boolean clientePrime = true;

	/**
	 * @author nicolas
	 * @param int1 do tipo Int metodo: Cliente especial com vinculo bom com o Banco, esta com saldo negativo de -200 reais.
	 */

	@Given("um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {

		if (this.clientePrime)
			this.saldo = int1;
		else
			throw new io.cucumber.java.PendingException();

	}

	/**
	 * @author nicolas
	 * @param int1 do tipo int metodo: Cliente especial solicita um valor de 100 reais
	 */

	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int1) {
		this.saque = int1;
		if (this.saque != int1)
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * @author nicolas
	 * @param int1 do tipo int metodo: Após o cliente especial efetuar o saque de 100 reais o saldo atual da conta será atualizado
	 */

	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int1) {
		if (int1 != (this.saldo - (this.saque))) {
			throw new io.cucumber.java.PendingException();
		}
	}

	/**
	 * @author nicolas
	 * @param int1 do tipo int metodo: Cliente comum com saldo negativo de -300 reais.
	 */

	@Given("um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
		if (!this.clientePrime)
			this.saldo = int1;
		else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * @author nicolas
	 * @param int1 do tipo int metodo: Cliente comum solicita saque de 200 reais.
	 */

	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer int1) {
		this.saque = int1;
		if (this.saque != int1)
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * @author nicolas
	 * @param int1 do tipo int metodo: Como o cliente é comum não tem um vínculo bom com o Banco, o saque não será efetuado e irá retornar uma
	 *             mensagem dizendo "Saldo insuficiente".
	 */
	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		
		if (this.clientePrime == false && this.saldo < this.saque)
			System.out.println("Saldo insuficiente.");
		else if(this.clientePrime == false && this.saldo > this.saque) {
			System.out.println("Saque realizado");
		}
		else
			throw new io.cucumber.java.PendingException();
	}

}
