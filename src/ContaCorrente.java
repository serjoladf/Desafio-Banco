class ContaCorrente extends Conta {
<<<<<<< HEAD
    private double chequeEspecial = 500.00;
    private final double movCheque = chequeEspecial; //
=======
>>>>>>> a86adac3734f72529719153ef839e391423bee5f
    public ContaCorrente(String nomeCliente) {
        super(nomeCliente);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
<<<<<<< HEAD
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

=======
>>>>>>> a86adac3734f72529719153ef839e391423bee5f
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
<<<<<<< HEAD
        }else if((saldo+chequeEspecial) > valor) { // para haver saque do especial ele tem que ser menor que o valor de saque
            valor = valor - saldo; // alterando a variavel valor depois de descontado o saldo que vai serm menor que valor
            chequeEspecial -= valor; // neste caso o Cheque especial debita a diferença
            saldo = 0; // saldo atualiza para 0 saldo
            depositar(saldo); // chamo a função dando valor Zero ao saldo
            return true;
=======
>>>>>>> a86adac3734f72529719153ef839e391423bee5f
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
        System.out.println("Extrato Conta Corrente:");
        System.out.printf("Nome: %s, Saldo: %.2f%n", nomeCliente, saldo);
<<<<<<< HEAD
        System.out.printf("Cheque Especial: %.2f%n",chequeEspecial); // Extrato do Cheque Especial
=======
>>>>>>> a86adac3734f72529719153ef839e391423bee5f
    }
}