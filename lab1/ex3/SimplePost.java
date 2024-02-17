package redis.ex3;
import redis.clients.jedis.Jedis;

public class SimplePost {
	public static String USERS_SET = "users:set"; // Key set for users' name
	public static String USERS_LIST = "users:list"; // Key list for users' name
	public static String USERS_HASH = "users:hash"; // Key hash for users' name

	public static void main(String[] args) {
		Jedis jedis = new Jedis();

		// some users
		String[] users = { "Ana", "Pedro", "Maria", "Luis" };

		// jedis.del(USERS_KEY); // remove if exists to avoid wrong type

		System.out.println("---SET---");
		for (String user : users)
			jedis.sadd(USERS_SET, user);
		jedis.smembers(USERS_SET).forEach(System.out::println);

		System.out.println("---LIST---");
		for (String user: users)
			jedis.rpush(USERS_LIST, user);
		jedis.lrange(USERS_LIST, 0, users.length).forEach(System.out::println);
		
		System.out.println("---HASH---");
		for (int i = 0; i<users.length; i++)
			jedis.hset(USERS_HASH, "user:"+i, users[i]);
		for(String id: jedis.hgetAll(USERS_HASH).keySet())
			System.out.println("ID: " + id + "	Name: " + jedis.hgetAll(USERS_HASH).get(id));

		jedis.del(USERS_HASH);
		jedis.del(USERS_LIST);
		jedis.del(USERS_SET);
		jedis.close();
	}
}