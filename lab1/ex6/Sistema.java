package redis.ex6;

import redis.clients.jedis.Jedis;

public class Sistema {
    protected Jedis jedis = new Jedis();

    public Jedis getJedis() {
        return jedis;
    }

    public void adicionarUtilizador(String username) {
        if (jedis.lrange("users", 0, -1).contains(username)) {
            System.out.println("ERRO: Utilizador já existe!");
            return;
        }

        for (String user : jedis.lrange("users", 0, -1)) {
            jedis.hset(username, user, "");
        }

        jedis.rpush("users", username);

        System.out.println("Utilizador " + username + " adicionado com sucesso!");
    }

    public void enviarMensagem(String emissor, String recetor, String msg) {
        if (!jedis.lrange("users", 0, -1).contains(recetor)) {
            System.out.println("ERRO: Utilizador não existe!");
            return;
        }

        if (!jedis.lrange("users", 0, -1).contains(emissor)) {
            System.out.println("ERRO: Utilizador não existe!");
            return;
        }

        jedis.hset(recetor, emissor, msg);

        System.out.println("Mensagem enviada com sucesso!");
    }

    public void receberMensagem(String emissor, String recetor) {
        if (!jedis.lrange("users", 0, -1).contains(recetor)) {
            System.out.println("ERRO: Utilizador não existe!");
            return;
        }

        if (!jedis.lrange("users", 0, -1).contains(emissor)) {
            System.out.println("ERRO: Utilizador não existe!");
            return;
        }

        if (jedis.hget(recetor, emissor).equals("")) {
            System.out.println("Não existem mensagens enviadas por " + emissor + "!");
            return;
        }

        System.out.println("Mensagem recebida de " + emissor + ": " + jedis.hget(recetor, emissor));
        jedis.hset(recetor, emissor, "");
    }
}
