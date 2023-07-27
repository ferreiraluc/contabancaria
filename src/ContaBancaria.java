import java.util.Scanner;

public class ContaBancaria {
    private String nomeCompleto;
    private double saldo;

    public ContaBancaria(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        this.saldo = 100;
    }

    public void resgate(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para resgate.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para resgate.");
        } else {
            saldo -= valor;
            System.out.println("Resgate realizado com sucesso. Saldo restante: " + saldo + " unidades.");
        }
    }

    public void deposito(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
        } else {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso. Saldo atual: " + saldo + " unidades.");
        }
    }

    public double saldoDisponivel() {
        return saldo;
    }

    public void investir() {
        double valorInvestido = saldo * 0.05;
        saldo += valorInvestido;
        System.out.println("Valor investido com sucesso. Saldo atual: " + saldo + " unidades.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome completo: ");
        String nomeCompleto = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(nomeCompleto);

        int opcao;
        do {
            System.out.println("\n----- Menu -----");
            System.out.println("1 - Depositar");
            System.out.println("2 - Resgatar");
            System.out.println("3 - Investir");
            System.out.println("4 - Saldo disponível");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.deposito(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor para resgate: ");
                    double valorResgate = scanner.nextDouble();
                    conta.resgate(valorResgate);
                    break;
                case 3:
                    conta.investir();
                    break;
                case 4:
                    System.out.println("Saldo disponível: " + conta.saldoDisponivel() + " unidades.");
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}
