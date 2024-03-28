import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        // Evitar conflito com a opcao 0 (sair)
        int[] opcoesDisponiveisDePc = {1, 2, 3};

        Computador[] PCS = new Computador[3];

        PCS[0] = new Computador("Positivo", 3300);
        PCS[0].mostraPCConfigs();
        PCS[0].hwBasico[0].nome = "Pentium Core i3";
        PCS[0].hwBasico[0].capacidade = 2200;
        PCS[0].hwBasico[1].nome = "Memoria RAM";
        PCS[0].hwBasico[1].capacidade = 8;
        PCS[0].hwBasico[2].nome = "HD";
        PCS[0].hwBasico[2].capacidade = 500;
        PCS[0].os.nome = "Linux Ubuntu";
        PCS[0].os.tipo = 32;

        PCS[1] = new Computador("Acer", 8800);
        PCS[1].hwBasico[0].nome = "Pentium Core i5";
        PCS[1].hwBasico[0].capacidade = 3370;
        PCS[1].hwBasico[1].nome = "Memoria RAM";
        PCS[1].hwBasico[1].capacidade = 16;
        PCS[1].hwBasico[2].nome = "HD";
        PCS[1].hwBasico[2].capacidade = 1;
        PCS[1].os.nome = "Windows 8";
        PCS[1].os.tipo = 64;

        PCS[2] = new Computador("Vaio", 4800);
        PCS[2].hwBasico[0].nome = "Pentium Core i7";
        PCS[2].hwBasico[0].capacidade = 4500;
        PCS[2].hwBasico[1].nome = "Memoria RAM";
        PCS[2].hwBasico[1].capacidade = 32;
        PCS[2].hwBasico[2].nome = "HD";
        PCS[2].hwBasico[2].capacidade = 2;
        PCS[2].os.nome = "Windows 10";
        PCS[2].os.tipo = 64;

        Scanner input = new Scanner(System.in);

        int opcao;

        // Essa variavel serve apenas pra limitar cliente.computadores (porque o array precisa de um limite)
        boolean acabouDinheiro = true;

        System.out.println("Insira seu nome");
        cliente.nome = input.nextLine();
        System.out.println("Insira seu CPF:");
        cliente.cpf = input.nextLong();

        do {
            // Acabou Dinheiro sempre true, ate que se prove o contrario
            acabouDinheiro = true;

            System.out.println("Qual opção de PC você gostaria de comprar?");
            for (int i = 0; i < opcoesDisponiveisDePc.length; i++) {
                System.out.print(opcoesDisponiveisDePc[i] + " ");
            }

            System.out.println("(Selecione 0 para sair)");

            opcao = input.nextInt();

            if(opcao != 0) {
                for (int i = 0; i < cliente.computadores.length; i++) {
                    if (cliente.computadores[i] == null) {
                        cliente.computadores[i] = PCS[opcao - 1];
                        acabouDinheiro = false;
                        // Se ainda tem slot de PC disponivel, pode preencher
                        break;
                    }
                }
                System.out.println("PC adicionado ao carrinho: ");
                PCS[opcao - 1].mostraPCConfigs();
            }
        } while(opcao != 0 && !acabouDinheiro);
        System.out.println("Total da compra: ");
        System.out.println("R$" + cliente.calculaTotalCompra());
    }

}
