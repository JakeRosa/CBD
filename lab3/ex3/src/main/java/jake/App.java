package jake;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class App {

    public static void main(String[] args) {
        Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
        Session session = cluster.connect("cbd_ex2");

        // alinea a)
        System.out.println("ALINEA A)");
        System.out.println();

        // delete all rows of wuant
        session.execute("DELETE FROM cbd_ex2.users WHERE username = 'wuant';");
        session.execute("DELETE FROM cbd_ex2.videos WHERE id = 11;");
        session.execute("DELETE FROM cbd_ex2.videos_by_user WHERE username = 'wuant';");

        long ts = System.currentTimeMillis();

        // Insert
        session.execute(
                "INSERT INTO cbd_ex2.users (username, nome, email, user_timestamp) VALUES ('wuant', 'Paulo', 'wuant@gmail.com', "
                        + ts + ");");
        session.execute(
                "INSERT INTO cbd_ex2.videos (id, username, name, description, tags, video_timestamp) VALUES (11, 'wuant', 'Uabo', 'Video sobre uabos', {'gaming', 'funny'}, "
                        + ts + ");");
        session.execute(
                "INSERT INTO cbd_ex2.videos_by_user (id, username, name, description, tags, video_timestamp) VALUES (11, 'wuant', 'Uabo', 'Video sobre uabos', {'gaming', 'funny'}, "
                        + ts + ");");

        System.out.println("LINHAS INSERIDAS: ");
        System.out.println();

        System.out.println("USERS: ");
        for (Row row : session.execute("SELECT * FROM cbd_ex2.users WHERE username = 'wuant';")) {
            System.out.println(row);
        }
        System.out.println();

        System.out.println("VIDEOS: ");
        for (Row row : session.execute("SELECT * FROM cbd_ex2.videos WHERE id = 11;")) {
            System.out.println(row);
        }
        System.out.println();

        System.out.println("VIDEOS_BY_USER: ");
        for (Row row : session.execute("SELECT * FROM cbd_ex2.videos_by_user WHERE username = 'wuant';")) {
            System.out.println(row);
        }
        System.out.println();

        // Update
        session.execute("UPDATE cbd_ex2.users SET nome = 'Paulo Borges' WHERE username = 'wuant';");
        session.execute("UPDATE cbd_ex2.videos SET name = 'O Grande Uabo' WHERE id = 11;");
        session.execute(
                "UPDATE cbd_ex2.videos_by_user SET name = 'O Grande Uabo' WHERE username = 'wuant' AND video_timestamp = '"
                        + ts + "';");

        System.out.println("LINHAS ATUALIZADAS: ");

        System.out.println("USERS: ");
        for (Row row : session.execute("SELECT * FROM cbd_ex2.users WHERE username = 'wuant';")) {
            System.out.println(row);
        }
        System.out.println();

        System.out.println("VIDEOS: ");
        for (Row row : session.execute("SELECT * FROM cbd_ex2.videos WHERE id = 11;")) {
            System.out.println(row);
        }
        System.out.println();

        System.out.println("VIDEOS_BY_USER: ");
        for (Row row : session
                .execute("SELECT * FROM cbd_ex2.videos_by_user WHERE username = 'wuant';")) {
            System.out.println(row);
        }
        System.out.println();

        // Search
        System.out.println("VIDEOS PUBLICADOS POR 'wuant': ");
        for (Row row : session.execute("SELECT * FROM cbd_ex2.videos_by_user WHERE username = 'wuant';")) {
            System.out.println(row);
        }

        // alinea b)
        System.out.println("ALINEA B)");
        System.out.println();

        System.out.println("10. Permitir a pesquisa do rating médio de um vídeo e quantas vezes foi votado");
        for (Row row : session.execute(
                "SELECT video_id, AVG(rating) AS average_rating, COUNT(rating_id) AS total_votes FROM ratings WHERE video_id = 1;")) {
            System.out.println(row);
        }
        System.out.println();

        System.out.println("1. Os últimos 3 comentários introduzidos para um vídeo");
        for (Row row : session
                .execute("SELECT * FROM comments WHERE video_id = 2 ORDER BY comment_timestamp DESC LIMIT 3")) {
            System.out.println(row);
        }
        System.out.println();

        System.out.println("2. Lista das tags de determinado vídeo");
        for (Row row : session.execute("SELECT tags FROM videos WHERE id = 1")) {
            System.out.println(row);
        }
        System.out.println();

        System.out.println("4. Os últimos 5 eventos de determinado vídeo realizados por um utilizador");
        for (Row row : session.execute("SELECT * FROM events WHERE username='mrbeast' and video_id=1 LIMIT 5;")) {
            System.out.println(row);
        }
    }
}
