abstract class Conta {
    protected String nomeCliente;
    protected double saldo;

    public Conta(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.saldo = 0.0;
    }

    public abstract void depositar(double valor);

    public abstract boolean sacar(double valor);

    public abstract boolean transferir(double valor, Conta destino);

    public double getSaldo() {
        return saldo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public abstract void imprimirExtrato();
}
