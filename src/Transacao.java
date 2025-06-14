import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private LocalDateTime data;
    private String tipo;
    private double valor;
    private double saldoAposTransacao;
    
    public Transacao(String tipo, double valor, double saldoAposTransacao) {
        this.data = LocalDateTime.now();
        this.tipo = tipo;
        this.valor = valor;
        this.saldoAposTransacao = saldoAposTransacao;
    }
    
    public LocalDateTime getData() {
        return data;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public double getValor() {
        return valor;
    }
    
    public double getSaldoAposTransacao() {
        return saldoAposTransacao;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("%s - %s: R$ %.2f - Saldo: R$ %.2f", 
                data.format(formatter), tipo, valor, saldoAposTransacao);
    }
}
