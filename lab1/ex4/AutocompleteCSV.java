package redis.ex4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import redis.clients.jedis.Jedis;

public class AutocompleteCSV {
    public static void main(String[] args) throws FileNotFoundException {
        Jedis jedis = new Jedis();
        File file = new File("lab1/src/main/java/redis/ex4/nomes-pt-2021.csv");
        Scanner names = new Scanner(file);
        String answer = " ";

        while(names.hasNextLine()){
            String[] parts = names.nextLine().split(";");
            String name = parts[0].toLowerCase();
            int score = -Integer.parseInt(parts[1]);
            jedis.zadd("names", score, name);
        }

        names.close();

        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Search for ('Enter' for quit): ");
            answer = sc.nextLine().toLowerCase();
            
            if(answer.equals("")){
                break;
            }

            for (String name : jedis.zrangeByScore("names", "-inf", "0")) {
                if (name.startsWith(answer)) {
                    System.out.println(name);
                }
            }
        }

        jedis.flushDB();
        jedis.close();
    }
}
