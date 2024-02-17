package redis.ex6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        String answer = "";

        while (!answer.toLowerCase().equals("s")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("---------- ESCOLHA UMA OPÇÃO ----------");
            System.out.println("A - Adicionar utilizador");
            System.out.println("E - Enviar mensagem");
            System.out.println("L - Ler mensagem");
            System.out.println("V - Ver utilizadores registados");
            System.out.println("S - Sair");
            System.out.println("----------------------------------------");
            System.out.print("> ");
            answer = sc.nextLine().toLowerCase();

            switch (answer) {
                case "a":
                    System.out.print("Username: ");
                    String username = sc.nextLine();

                    sistema.adicionarUtilizador(username);
                    break;
                case "e":
                    System.out.print("Emissor: ");
                    String emissor = sc.nextLine();

                    System.out.print("Recetor: ");
                    String recetor = sc.nextLine();

                    System.out.print("Mensagem: ");
                    String msg = sc.nextLine();

                    sistema.enviarMensagem(emissor, recetor, msg);
                    break;
                case "l":
                    System.out.print("Recetor: ");
                    recetor = sc.nextLine();

                    System.out.print("Emissor: ");
                    emissor = sc.nextLine();

                    sistema.receberMensagem(emissor, recetor);
                    break;
                case "v":
                    System.out.println("Utilizadores registados: " + sistema.getJedis().lrange("users", 0, -1));
                    break;

                case "s":
                    System.out.println("Encerrando...");
                    sistema.getJedis().flushDB();
                    sistema.getJedis().close();
                    System.exit(0);
            }
        }
    }
}
