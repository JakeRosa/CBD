package redis.ex5;

import java.io.FileNotFoundException;
import java.util.Scanner;

import redis.clients.jedis.Jedis;

public class SistemaAtend {
    public static int LIMIT = 10;
    public static int TIMESLOT = 30;

    public static void main(String[] args) throws FileNotFoundException {
        Jedis jedis = new Jedis();
        String answer;

        Scanner scan = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scan.nextLine();

        // solução antiga

        // jedis.set("limit", "0");
        // jedis.expire("limit", TIMESLOT);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Digite um produto ('Enter' para terminar): ");
            answer = sc.nextLine();

            if (answer.equals("")) {
                break;
            }

            for (String product : jedis.lrange(username, 0, -1)) {
                if (jedis.ttl(product) == -2) {
                    jedis.lrem(username, 0, product);
                }
            }

            if (jedis.llen(username) == LIMIT) {
                System.out.println("ERRO: Limite de produtos excedido! Volte a tentar dentro de "
                        + jedis.ttl(jedis.lindex(username, 0)) + " segundos");
            } else {
                if (jedis.lrange(username, 0, -1).contains(answer)) {
                    System.out.println("ERRO: Este produto já está na lista!");
                    continue;
                }
                jedis.rpush(username, answer);
                jedis.set(answer, "");
                jedis.expire(answer, TIMESLOT);
                System.out.println("Produto " + answer + " adicionado!");
            }

            // solução antiga

            // if (jedis.ttl("limit") != -2) {
            // if (Integer.parseInt(jedis.get("limit")) == LIMIT) {
            // System.out.println("ERRO: Limite de produtos excedido! Volte a tentar dentro
            // de "
            // + jedis.ttl("limit") + " segundos");
            // } else {
            // if (jedis.lrange(username, 0, -1).contains(answer)) {
            // System.out.println("ERRO: Este produto já está na lista!");
            // } else {
            // jedis.incr("limit");
            // jedis.rpush(username, answer);
            // System.out.println("Produto adicionado!");
            // }
            // }
            // } else {
            // jedis.set("limit", "1");
            // jedis.expire("limit", TIMESLOT);
            // jedis.rpush(username, answer);
            // System.out.println("Produto adicionado!");
            // }
        }

        scan.close();

        // solução antiga

        // System.out.println("Produtos que o user " + username + " pediu: ");
        // jedis.lrange(username, 0, -1).forEach(System.out::println);

        jedis.flushDB();
        jedis.close();
    }
}