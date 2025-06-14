import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;
	private List<Cliente> clientes;

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
		this.clientes = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public void adicionarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public void listarClientes() {
		System.out.println("\n=== Clientes do " + this.nome + " ===");
		for (Cliente cliente : clientes) {
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("---------------------------");
		}
	}
	
	public void listarContas() {
		System.out.println("\n=== Contas do " + this.nome + " ===");
		for (Conta conta : contas) {
			System.out.println("Agência: " + conta.getAgencia());
			System.out.println("Número: " + conta.getNumero());
			System.out.println("Titular: " + conta.cliente.getNome());
			System.out.println("Tipo: " + (conta instanceof ContaCorrente ? "Conta Corrente" : "Conta Poupança"));
			System.out.println("---------------------------");
		}
	}
}
