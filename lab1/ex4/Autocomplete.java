package redis.ex4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import redis.clients.jedis.Jedis;

public class Autocomplete {
    public static void main(String[] args) throws FileNotFoundException {
        Jedis jedis = new Jedis();
        File file = new File("lab1/src/main/java/redis/ex4/names.txt");
        Scanner names = new Scanner(file);
        String answer = " ";

        while(names.hasNextLine()){
            jedis.zadd("names", 0, names.nextLine());
        }

        names.close();

        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Search for ('Enter' for quit): ");
            answer = sc.nextLine().toLowerCase();
            
            if(answer.equals("")){
                break;
            }

            jedis.zrangeByLex("names", "[" + answer, "[" + answer + (char)0xFF).forEach(System.out::println);
        }

        jedis.flushDB();
        jedis.close();
    }
}
