package redis.ex5;

import java.io.FileNotFoundException;
import java.util.Scanner;

import redis.clients.jedis.Jedis;

public class SistemaAtendQuant {
    public static int LIMIT = 10;
    public static int TIMESLOT = 30;

    public static void main(String[] args) throws FileNotFoundException {
        Jedis jedis = new Jedis();
        String answer;
        String quantity;

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

            System.out.print("Digite a quantidade ('Enter' para terminar): ");
            quantity = sc.nextLine();

            if (quantity.equals("")) {
                break;
            }

            int totalQuantity = 0;

            for (String product : jedis.lrange(username, 0, -1)) {
                if (jedis.ttl(product) == -2) {
                    jedis.lrem(username, 0, product);
                    continue;
                }
                totalQuantity += Integer.parseInt(jedis.get(product));
            }

            if (totalQuantity + Integer.parseInt(quantity) > LIMIT) {
                System.out.println("ERRO: Limite de produtos excedido! Volte a tentar dentro de "
                        + jedis.ttl(jedis.lindex(username, 0))
                        + " segundos ou digite um valor menor de unidades");
            } else {
                if (jedis.lrange(username, 0, -1).contains(answer)) {
                    System.out.println("ERRO: Este produto já está na lista!");
                    continue;
                }
                jedis.rpush(username, answer);
                jedis.set(answer, quantity);
                jedis.expire(answer, TIMESLOT);
                System.out.println("Produto " + answer + " e quantidade adicionados!");
            }

            // solução antiga

            // if (jedis.ttl("limit") != -2) {
            // if (Integer.parseInt(jedis.get("limit")) >= LIMIT) {
            // System.out.println("ERRO: Limite de unidades excedido! Volte a tentar dentro
            // de "
            // + jedis.ttl("limit") + " segundos ou digite um valor menor de unidades");
            // } else {
            // if (jedis.hkeys(username).contains(answer)) {
            // jedis.incrBy("limit", Integer.parseInt(quantity));
            // jedis.hincrBy(username, answer, Integer.parseInt(quantity));
            // System.out.println("Quantidade do produto foi atualizada!");
            // } else {
            // jedis.incrBy("limit", Integer.parseInt(quantity));
            // jedis.hset(username, answer, quantity);
            // System.out.println("Produto e quantidade adicionados!");
            // }
            // }
            // } else {
            // jedis.set("limit", "1");
            // jedis.expire("limit", TIMESLOT);
            // jedis.hset(username, answer, quantity);
            // System.out.println("Produto e quantidade adicionados!");
            // }
        }

        scan.close();

        // solução antiga

        // System.out.println("Produtos que o user " + username + " pediu: ");
        // for (Map.Entry<String, String> entry : jedis.hgetAll(username).entrySet()) {
        // System.out.println(entry.getKey() + ": " + entry.getValue() + " unidades");
        // }

        jedis.flushDB();
        jedis.close();
    }
}
