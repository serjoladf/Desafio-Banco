import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta contaCorrente = null;
        Conta contaPoupanca = null;
        boolean continuar = true;

        Cliente cliente = new Cliente();
        String nome = cliente.nomeCliente();
        cliente.setNome(nome);
        System.out.println("Digite uma Opção cliente, " + cliente.getNome());

        while (continuar) {
            System.out.println("Digite: 1 - Criar conta  2 - Deposito  3 - Saque  4 - Consultar Saldo  5 - Transferência  6 - Saque com Limite Diário  0 - Encerrar");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite: 1 - Conta Corrente  2 - Conta Poupança  3 - Retornar ao Menu Principal");
                    int option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            if (contaCorrente == null) {
                                contaCorrente = new ContaCorrente(cliente.getNome());
                                System.out.println("Conta Corrente criada para " + cliente.getNome());
                                contaCorrente.imprimirExtrato();
                            } else {
                                System.out.println("Conta Corrente já existe.");
                            }
                            break;
                        case 2:
                            if (contaPoupanca == null) {
                                contaPoupanca = new ContaPoupanca(cliente.getNome());
                                System.out.println("Conta Poupança criada para " + cliente.getNome());
                                contaPoupanca.imprimirExtrato();
                            } else {
                                System.out.println("Conta Poupança já existe.");
                            }
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                    break;
                case 2:
                    if (contaCorrente != null || contaPoupanca != null) {
                        System.out.println("Digite: 1 - Depositar em Conta Corrente  2 - Depositar em Conta Poupança");
                        int tipoConta = scanner.nextInt();
                        System.out.println("Digite o valor a ser depositado:");
                        double valorDeposito = scanner.nextDouble();
                        if (tipoConta == 1 && contaCorrente != null) {
                            contaCorrente.depositar(valorDeposito);
                            System.out.printf("Depósito realizado. Saldo Atual Conta Corrente: %.2f%n", contaCorrente.getSaldo());
                            contaCorrente.imprimirExtrato();
                        } else if (tipoConta == 2 && contaPoupanca != null) {
                            contaPoupanca.depositar(valorDeposito);
                            System.out.printf("Depósito realizado. Saldo Atual Conta Poupança: %.2f%n", contaPoupanca.getSaldo());
                            contaPoupanca.imprimirExtrato();
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
                    } else {
                        System.out.println("Nenhuma conta criada. Crie uma conta primeiro.");
                    }
                    break;
                case 3:
                    if (contaCorrente != null || contaPoupanca != null) {
                        System.out.println("Digite: 1 - Sacar de Conta Corrente  2 - Sacar de Conta Poupança");
                        int tipoConta = scanner.nextInt();
                        System.out.println("Digite o valor a ser sacado:");
                        double valorSaque = scanner.nextDouble();
                        if (tipoConta == 1 && contaCorrente != null) {
                            if (contaCorrente.sacar(valorSaque)) {
                                System.out.printf("Saque realizado. Saldo Atual Conta Corrente: %.2f%n", contaCorrente.getSaldo());
                                contaCorrente.imprimirExtrato();
                            } else {
                                System.out.println("Saldo insuficiente.");
                                contaCorrente.imprimirExtrato();
                            }
                        } else if (tipoConta == 2 && contaPoupanca != null) {
                            if (contaPoupanca.sacar(valorSaque)) {
                                System.out.printf("Saque realizado. Saldo Atual Conta Poupança: %.2f%n", contaPoupanca.getSaldo());
                                contaPoupanca.imprimirExtrato();
                            } else {
                                System.out.println("Saldo insuficiente.");
                                contaPoupanca.imprimirExtrato();
                            }
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
                    } else {
                        System.out.println("Nenhuma conta criada. Crie uma conta primeiro.");
                    }
                    break;
                case 4:
                    if (contaCorrente != null || contaPoupanca != null) {
                        System.out.println("Saldo Atual:");
                        if (contaCorrente != null) {
                            System.out.printf("Conta Corrente: %.2f%n", contaCorrente.getSaldo());
                            contaCorrente.imprimirExtrato();
                        }
                        if (contaPoupanca != null) {
                            System.out.printf("Conta Poupança: %.2f%n", contaPoupanca.getSaldo());
                            contaPoupanca.imprimirExtrato();
                        }
                    } else {
                        System.out.println("Nenhuma conta criada. Crie uma conta primeiro.");
                    }
                    break;
                case 5:
                    if (contaCorrente != null || contaPoupanca != null) {
                        System.out.println("Digite: 1 - Transferir de Conta Corrente para Poupança  2 - Transferir de Conta Poupança para Corrente");
                        int tipoTransferencia = scanner.nextInt();
                        System.out.println("Digite o valor a ser transferido:");
                        double valorTransferencia = scanner.nextDouble();
                        if (tipoTransferencia == 1 && contaCorrente != null && contaPoupanca != null) {
                            if (contaCorrente.transferir(valorTransferencia, contaPoupanca)) {
                                System.out.printf("Transferência realizada. Saldo Atual Conta Corrente: %.2f%n", contaCorrente.getSaldo());
                                System.out.printf("Saldo Atual Conta Poupança: %.2f%n", contaPoupanca.getSaldo());
                                contaCorrente.imprimirExtrato();
                                contaPoupanca.imprimirExtrato();
                            } else {
                                System.out.println("Saldo insuficiente para transferência.");
                                contaCorrente.imprimirExtrato();
                            }
                        } else if (tipoTransferencia == 2 && contaPoupanca != null && contaCorrente != null) {
                            if (contaPoupanca.transferir(valorTransferencia, contaCorrente)) {
                                System.out.printf("Transferência realizada. Saldo Atual Conta Poupança: %.2f%n", contaPoupanca.getSaldo());
                                System.out.printf("Saldo Atual Conta Corrente: %.2f%n", contaCorrente.getSaldo());
                                contaPoupanca.imprimirExtrato();
                                contaCorrente.imprimirExtrato();
                            } else {
                                System.out.println("Saldo insuficiente para transferência.");
                                contaPoupanca.imprimirExtrato();
                            }
                        } else {
                            System.out.println("Conta não encontrada ou não criada.");
                        }
                    } else {
                        System.out.println("Nenhuma conta criada. Crie uma conta primeiro.");
                    }
                    break;
                case 6:
                    if (contaCorrente != null || contaPoupanca != null) {
                        System.out.println("Digite: 1 - Saque de Conta Corrente  2 - Saque de Conta Poupança");
                        int tipoConta = scanner.nextInt();
                        System.out.println("Digite o limite diário de saque:");
                        double limiteDiario = scanner.nextDouble();

                        while (true) {
                            System.out.println("Digite o valor a ser sacado ou 0 para encerrar:");
                            double valorSaque = scanner.nextDouble();

                            if (valorSaque == 0) {
                                System.out.println("Transações encerradas.");
                                break;
                            } else if (valorSaque <= limiteDiario) {
                                if (tipoConta == 1 && contaCorrente != null) {
                                    if (contaCorrente.sacar(valorSaque)) {
                                        limiteDiario -= valorSaque;
                                        System.out.printf("Saque realizado. Limite diário restante: %.2f. Saldo Atual Conta Corrente: %.2f%n", limiteDiario, contaCorrente.getSaldo());
                                    } else {
                                        System.out.println("Saldo insuficiente.");
                                        contaCorrente.imprimirExtrato();
                                    }
                                } else if (tipoConta == 2 && contaPoupanca != null) {
                                    if (contaPoupanca.sacar(valorSaque)) {
                                        limiteDiario -= valorSaque;
                                        System.out.printf("Saque realizado. Limite diário restante: %.2f. Saldo Atual Conta Poupança: %.2f%n", limiteDiario, contaPoupanca.getSaldo());
                                    } else {
                                        System.out.println("Saldo insuficiente.");
                                        contaPoupanca.imprimirExtrato();
                                    }
                                } else {
                                    System.out.println("Conta não encontrada.");
                                }
                            } else {
                                System.out.println("Limite diário de saque atingido. Transações encerradas.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Nenhuma conta criada. Crie uma conta primeiro.");
                    }
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}