class ContaPoupanca extends Conta {
<<<<<<< HEAD
    private double taxaRendimento = 1.05;
=======
>>>>>>> a86adac3734f72529719153ef839e391423bee5f
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
<<<<<<< HEAD
        System.out.printf("Rendimento da conta: %.2f%n",(saldo*taxaRendimento));
=======
>>>>>>> a86adac3734f72529719153ef839e391423bee5f
    }
}