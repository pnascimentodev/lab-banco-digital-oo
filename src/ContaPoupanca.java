
public class ContaPoupanca extends Conta {
	
	private static final double TAXA_JUROS = 0.05; // 5% ao mês

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("\n=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
		System.out.println(String.format("Taxa de juros: %.2f%%", TAXA_JUROS * 100));
		super.imprimirHistoricoTransacoes();
	}
	
	public void aplicarRendimentoMensal() {
		double valorRendimento = saldo * TAXA_JUROS;
		depositar(valorRendimento);
		transacoes.add(new Transacao("RENDIMENTO MENSAL", valorRendimento, saldo));
	}
}
