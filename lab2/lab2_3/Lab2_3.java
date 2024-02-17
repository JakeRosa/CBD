package com.joaquim.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Lab2_3 {
        private static MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        private static MongoDatabase cbd = mongoClient.getDatabase("cbd");
        private static MongoCollection<org.bson.Document> restaurants = cbd.getCollection("restaurants");

        public static void main(String[] args) {

                // Alinea a)
                Document restaurant1 = new Document("address",
                                new Document("building", "2931").append("coord", Arrays.asList(-70.28, 50))
                                                .append("rua", "Dr. Mário Sacramento").append("zipcode", "3800"))
                                .append("localidade", "Aveiro").append("gastronomia", "Tuga")
                                .append("grades", Arrays.asList(
                                                new Document("date", new Document("$date", "2023-10-02T00:00:00Z"))
                                                                .append("grade", "A").append("score", 50),
                                                new Document("date", new Document("$date", "2023-10-03T00:00:00Z"))
                                                                .append("grade", "B")
                                                                .append("score", "40")))
                                .append("nome", "Tasca do Ric").append("restaurant_id", "293882");

                restaurants.insertOne(restaurant1);

                System.out.println("INSERÇÃO DE RESTAURANTE: ");
                System.out.println(restaurant1.toJson());
                System.out.println();

                restaurants.updateOne(new Document("nome", "Tasca do Ric"),
                                new Document("$set", new Document("nome", "Tasca do Jake")));

                System.out.println("EDIÇÃO DO ANTERIOR: ");
                FindIterable<Document> updatedRestaurant = restaurants.find(new Document("nome", "Tasca do Jake"));
                for (Document doc : updatedRestaurant) {
                        System.out.println(doc.toJson());
                }
                System.out.println();

                System.out.println("PESQUISA DE TODOS OS RESTAURANTES DE GASTRONOMIA PORTUGUESA: ");
                FindIterable<Document> ptRestaurants = restaurants.find(new Document("gastronomia", "Portuguese"));
                for (Document doc : ptRestaurants) {
                        System.out.println(doc.toJson());
                }
                System.out.println();

                restaurants.deleteMany(new Document("nome", "Tasca do Jake"));

                // Alinea b)
                System.out.println("PESQUISAS SEM ÍNDICE: ");

                long start = System.nanoTime();
                FindIterable<Document> findLocalidade = restaurants.find(new Document("localidade", "Bronx"));
                System.out.println("Tempo da pesquisa da localidade Bronx (antes da indexação): "
                                + (System.nanoTime() - start) + " nanossegundos");

                start = System.nanoTime();
                FindIterable<Document> findGastronomia = restaurants.find(new Document("gastronomia", "Chinese"));
                System.out.println("Tempo de pesquisa da gastronomia Chinese (antes da indexação): "
                                + (System.nanoTime() - start) + " nanossegundos");

                start = System.nanoTime();
                FindIterable<Document> findNome = restaurants.find(new Document("nome",
                                "Burger King"));
                System.out.println("Tempo de pesquisa do nome Burger King (antes da indexação): "
                                + (System.nanoTime() - start) + " nanossegundos");
                System.out.println();

                System.out.println("PESQUISAS COM ÍNDICE: ");

                restaurants.createIndex(new Document("localidade", 1));
                restaurants.createIndex(new Document("gastronomia", 1));
                restaurants.createIndex(new Document("nome", "text"));

                start = System.nanoTime();
                FindIterable<Document> findLocalidade1 = restaurants.find(new Document("localidade", "Bronx"));
                System.out.println("Tempo da pesquisa da localidade Bronx (depois da indexação): "
                                + (System.nanoTime() - start) + " nanossegundos");

                start = System.nanoTime();
                FindIterable<Document> findGastronomia1 = restaurants.find(new Document("gastronomia", "Chinese"));
                System.out.println("Tempo de pesquisa da gastronomia Chinese (depois da indexação): "
                                + (System.nanoTime() - start) + " nanossegundos");

                start = System.nanoTime();
                FindIterable<Document> findNome1 = restaurants.find(new Document("nome",
                                "Burger King"));
                System.out.println("Tempo de pesquisa do nome Burger King (depois da indexação): "
                                + (System.nanoTime() - start) + " nanossegundos");
                System.out.println();

                // Alinea c)
                System.out.println(
                                "11. Liste o nome, a localidade e a gastronomia dos restaurantes que pertencem ao Bronx e cuja gastronomia é do tipo \"American\" ou \"Chinese\"");
                FindIterable<Document> ex11 = restaurants.find(
                                new Document("localidade", "Bronx").append("gastronomia",
                                                new Document("$in", Arrays.asList("American", "Chinese"))))
                                .projection(new Document("nome", 1).append("localidade",
                                                1).append("gastronomia", 1));
                for (Document doc : ex11) {
                        System.out.println(doc.toJson());
                }
                System.out.println();

                System.out.println(
                                "12. Liste o restaurant_id, o nome, a localidade e a gastronomia dos restaurantes localizados em \"Staten Island\", \"Queens\", ou \"Brooklyn\"");
                FindIterable<Document> ex12 = restaurants.find(new Document("localidade",
                                new Document("$in", Arrays.asList("Staten Island", "Queens", "Brooklyn"))))
                                .projection(new Document("restaurant_id", 1).append("nome",
                                                1).append("localidade", 1)
                                                .append("gastronomia", 1));
                for (Document doc : ex12) {
                        System.out.println(doc.toJson());
                }
                System.out.println();

                System.out.println(
                                "18. Liste nome, localidade, grade e gastronomia de todos os restaurantes localizados em Brooklyn que não incluem gastronomia \"American\" e obtiveram uma classificação (grade) \"A\". Deve apresentá-los por ordem decrescente de gastronomia.");
                FindIterable<Document> ex18 = restaurants.find(new Document("localidade",
                                "Brooklyn")
                                .append("gastronomia", new Document("$ne",
                                                "American"))
                                .append("grades.grade", "A"))
                                .projection(new Document("nome", 1).append("localidade",
                                                1).append("grades.grade", 1)
                                                .append("gastronomia", 1))
                                .sort(new Document("gastronomia", -1));
                for (Document doc : ex18) {
                        System.out.println(doc.toJson());
                }
                System.out.println();

                System.out.println(
                                "20. Apresente o nome e número de avaliações (numGrades) dos 3 restaurante com mais avaliações");
                AggregateIterable<Document> ex20 = restaurants.aggregate(Arrays.asList(
                                new Document("$project", new Document("_id", 0).append("nome", 1).append("numGrades",
                                                new Document("$size", "$grades"))),
                                new Document("$sort", new Document("numGrades", -1)),
                                new Document("$limit", 3)));
                for (Document doc : ex20) {
                        System.out.println(doc.toJson());
                }
                System.out.println();

                System.out.println(
                                "23. Indique os restaurantes que têm gastronomia \"Portuguese\", o somatório de score é superior a 50 e estão numa latitude inferior a -60.");
                AggregateIterable<Document> ex23 = restaurants.aggregate(Arrays.asList(
                                new Document("$match", new Document("gastronomia",
                                                "Portuguese").append("address.coord.0",
                                                                new Document("$lt", -60))),
                                new Document("$project", new Document("restaurant_id", 1).append("nome",
                                                1).append("sumScore",
                                                                new Document("$sum", "$grades.score"))),
                                new Document("$match", new Document("sumScore", new Document("$gt", 50)))));
                for (Document doc : ex23) {
                        System.out.println(doc.toJson());
                }
                System.out.println();

                // Alinea d)
                System.out.println("Numero de localidades distintas: " + countLocalidades());
                System.out.println();

                System.out.println("Numero de restaurantes por localidade: ");
                Map<String, Integer> map = countRestByLocalidade();
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        System.out.println("-> " + entry.getKey() + " - " + entry.getValue());
                }
                System.out.println();

                System.out.println("Nome de restaurantes contendo 'Park' no nome: ");
                List<String> list = getRestWithNameCloserTo("Park");
                for (String s : list) {
                        System.out.println("-> " + s);
                }
                System.out.println();

        }

        public static int countLocalidades() {
                AggregateIterable<Document> numLocalidades = restaurants.aggregate(Arrays.asList(
                                new Document("$group", new Document("_id", "$localidade")),
                                new Document("$count", "numLocalidades")));
                return numLocalidades.first().getInteger("numLocalidades");
        }

        public static Map<String, Integer> countRestByLocalidade() {
                AggregateIterable<Document> numRestByLocalidade = restaurants.aggregate(Arrays.asList(
                                new Document("$group", new Document("_id", "$localidade").append("numRestaurantes",
                                                new Document("$sum", 1)))));

                HashMap<String, Integer> map = new HashMap<>();
                for (Document doc : numRestByLocalidade) {
                        map.put(doc.getString("_id"), doc.getInteger("numRestaurantes"));
                }

                return map;
        }

        public static List<String> getRestWithNameCloserTo(String name) {
                FindIterable<Document> names = restaurants.find(new Document("nome",
                                new Document("$regex", name)));

                List<String> list = new ArrayList<>();
                for (Document doc : names) {
                        list.add(doc.getString("nome"));
                }

                return list;
        }
}