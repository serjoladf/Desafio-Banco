class ContaCorrente extends Conta{
    private double chequeEspecial = 500.00;
    private final double movCheque = chequeEspecial;
    private int numeroCC;
    private int numeroAg;


    public ContaCorrente(String titular, int numeroCC, int numeroAg) {
        this.titular = titular;
        this.numeroCC = numeroCC;
        this.numeroAg = numeroAg;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        if(movCheque > chequeEspecial){ // Neste bloco caso tenha utilizado o limite do cheque especial
            double diferenca = movCheque - chequeEspecial; // ao depositar o limite é restabelecido
             if(saldo > diferenca) {
                 chequeEspecial += diferenca; // cheque especial recebe ele mais a diferença
                 saldo -= diferenca;
             }else{
                 chequeEspecial += valor;
                 saldo -= valor; // se valor menor ele recebe eele mais valor
             }
        }

    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }else if((saldo+chequeEspecial) > valor) { // para haver saque do especial ele tem que ser menor que o valor de saque
            valor = valor - saldo; // alterando a variavel valor depois de descontado o saldo que vai serm menor que valor
            chequeEspecial -= valor; // neste caso o Cheque especial debita a diferença
            saldo = 0; // saldo atualiza para 0 saldo
            depositar(saldo); // chamo a função dando valor Zero ao saldo
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
        numeroAg = gerador.nextInt(51) + 99;
        return numeroAg;
    }

    @Override
    public int geradorConta() {
        numeroCC = gerador.nextInt(1000) + 1999;
      return numeroCC;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Corrente:");
        System.out.printf("Agência: %d%n",numeroAg);
        System.out.printf("Conta: %d%n",numeroCC);
        System.out.printf("Nome: %s%nSaldo: %.2f%n", titular, saldo);
        System.out.printf("Cheque Especial: %.2f%n",chequeEspecial); // Extrato do Cheque Especial
    }


}