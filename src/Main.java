
public class Main {

	public static void main(String[] args) {
		// Criando o banco
		Banco banco = new Banco("Banco Digital");
		
		// Criando clientes
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		venilton.setCpf("123.456.789-00");
		venilton.setEndereco("Rua Java, 123");
		venilton.setEmail("venilton@email.com");
		venilton.setTelefone("(11) 99999-8888");
		
		Cliente maria = new Cliente();
		maria.setNome("Maria");
		maria.setCpf("987.654.321-00");
		maria.setEndereco("Avenida POO, 456");
		maria.setEmail("maria@email.com");
		maria.setTelefone("(11) 98888-7777");
		
		// Adicionando clientes ao banco
		banco.adicionarCliente(venilton);
		banco.adicionarCliente(maria);
		
		// Criando contas
		Conta ccVenilton = new ContaCorrente(venilton);
		Conta poupancaVenilton = new ContaPoupanca(venilton);
		Conta ccMaria = new ContaCorrente(maria);
		
		// Adicionando contas ao banco
		banco.adicionarConta(ccVenilton);
		banco.adicionarConta(poupancaVenilton);
		banco.adicionarConta(ccMaria);
		
		// Realizando operações
		ccVenilton.depositar(1000);
		ccVenilton.transferir(500, poupancaVenilton);
		ccVenilton.sacar(200);
		
		ccMaria.depositar(2000);
		ccMaria.transferir(300, ccVenilton);
		
		// Aplicando rendimento na poupança
		((ContaPoupanca) poupancaVenilton).aplicarRendimentoMensal();
		
		// Cobrando taxa mensal da conta corrente
		((ContaCorrente) ccVenilton).cobrarTaxaMensal();
		
		// Tentativa de saque com valor maior que o saldo
		ccVenilton.sacar(10000);
		
		// Listando clientes e contas do banco
		banco.listarClientes();
		banco.listarContas();
		
		// Imprimindo extratos
		ccVenilton.imprimirExtrato();
		poupancaVenilton.imprimirExtrato();
		ccMaria.imprimirExtrato();
	}
}
