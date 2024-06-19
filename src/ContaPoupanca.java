class ContaPoupanca extends Conta {
    public ContaPoupanca(String nomeCliente) {
        super(nomeCliente);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(double valor, Conta destino) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Poupança:");
        System.out.printf("Nome: %s, Saldo: %.2f%n", nomeCliente, saldo);
    }
}