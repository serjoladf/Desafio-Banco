import java.util.Random;

abstract class Conta {
    Random gerador  = new Random();
    protected double saldo;
    protected String titular;
    private int agencia;
    private int numeroConta;

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public abstract void depositar(double valor);

    public abstract boolean sacar(double valor);

    public abstract boolean transferir(double valor, Conta destino);

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public abstract void imprimirExtrato();

    public abstract int geradorConta();

    public abstract int geradorAgencia();
}

