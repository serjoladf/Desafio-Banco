import java.util.Scanner;

class Cliente {
    private String titular;
    private Scanner scanner = new Scanner(System.in);

    public String titular() {
        System.out.println("Digite seu nome:");
        titular = scanner.nextLine();
        return titular;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}