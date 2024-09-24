class ContaPoupanca extends Conta {
    private double taxaRendimento = 1.05;
    private String titular;
    private int numeroCP;
    private int numeroAg;

    public ContaPoupanca(String titular,int numeroCP, int numeroAg) {
        this.titular = titular;
        this.numeroCP = numeroCP;
        this.numeroAg = numeroAg;
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
    public int geradorAgencia() {
        numeroAg = gerador.nextInt(1) + 50;
        return numeroAg;
    }

    @Override
    public int geradorConta() {
        numeroCP = gerador.nextInt(2000) + 3000;
        return numeroCP;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Poupança:");
        System.out.printf("Aência: %d%n",numeroAg);
        System.out.printf("Conta: %d%n",numeroCP);
        System.out.printf("Nome: %s, Saldo: %.2f%n", titular, saldo);
        System.out.printf("Rendimento da conta: %.2f%n",(saldo*taxaRendimento));
    }
}