import java.util.Scanner;

class Cliente {
    private String nomeCliente;
    private Scanner scanner = new Scanner(System.in);

    public String nomeCliente() {
        System.out.println("Digite seu nome:");
        nomeCliente = scanner.nextLine();
        return nomeCliente;
    }

    public String getNome() {
        return nomeCliente;
    }

    public void setNome(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}