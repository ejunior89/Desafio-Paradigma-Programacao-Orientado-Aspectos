// ContaBancaria.java
public class ContaBancaria {
    private String tipoConta;
    private double saldo;

    public ContaBancaria(String tipoConta, double saldo) {
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    public void realizarSaque(double valor) {
        if (saldoSuficiente(valor)) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso na conta " + tipoConta);
        } else {
            System.out.println("Saldo insuficiente na conta " + tipoConta);
        }
    }

    private boolean saldoSuficiente(double valor) {
        return saldo >= valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }
}
