
public class ContaCorrente extends Conta {
	
	private static final double TAXA_MENSAL = 12.0;

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("\n=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
		System.out.println(String.format("Taxa mensal: R$ %.2f", TAXA_MENSAL));
		super.imprimirHistoricoTransacoes();
	}
	
	public void cobrarTaxaMensal() {
		this.sacar(TAXA_MENSAL);
		transacoes.add(new Transacao("TAXA MENSAL", TAXA_MENSAL, saldo));
	}
	
}
