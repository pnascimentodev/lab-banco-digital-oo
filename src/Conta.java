
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected List<Transacao> transacoes;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.transacoes = new ArrayList<>();
	}	@Override
	public void sacar(double valor) {
		if (valor > saldo) {
			System.out.println("Operação não realizada. Saldo insuficiente!");
			return;
		}
		saldo -= valor;
		transacoes.add(new Transacao("SAQUE", valor, saldo));
	}

	@Override
	public void depositar(double valor) {
		if (valor <= 0) {
			System.out.println("Operação não realizada. Valor de depósito inválido!");
			return;
		}
		saldo += valor;
		transacoes.add(new Transacao("DEPÓSITO", valor, saldo));
	}
	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (valor > saldo) {
			System.out.println("Operação não realizada. Saldo insuficiente para transferência!");
			return;
		}
		this.sacar(valor);
		contaDestino.depositar(valor);
		transacoes.add(new Transacao("TRANSFERÊNCIA (SAÍDA)", valor, saldo));
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
	public void imprimirHistoricoTransacoes() {
		System.out.println("\n=== Histórico de Transações ===");
		if (transacoes.isEmpty()) {
			System.out.println("Não há transações registradas.");
		} else {
			for (Transacao transacao : transacoes) {
				System.out.println(transacao);
			}
		}
	}
	
	public List<Transacao> getTransacoes() {
		return transacoes;
	}
}
