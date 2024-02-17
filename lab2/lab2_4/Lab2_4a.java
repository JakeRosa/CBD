package com.joaquim.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Lab2_4a {
        private static MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        private static MongoDatabase lab2_4 = mongoClient.getDatabase("lab2_4");
        private static MongoCollection<org.bson.Document> sistema_atend = lab2_4.getCollection("sistema_atend");
        private static int LIMIT = 10;
        private static int TIMESLOT = 30000; // em milisegundos

        public static void main(String[] args) {
                String user;
                String product;

                while (true) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Username ('Enter para terminar'): ");
                        user = scanner.nextLine();

                        if (user.equals("")) {
                                break;
                        }

                        Document doc = new Document("user", user).append("products", Arrays.asList());
                        sistema_atend.insertOne(doc);

                        while (true) {
                                Scanner scanner2 = new Scanner(System.in);
                                System.out.print("Product ('Enter para dar logout'): ");
                                product = scanner2.nextLine();

                                if (product.equals("")) {
                                        sistema_atend.deleteMany(new Document("user", user));
                                        break;
                                }

                                listCheck(user); // remove produtos expirados

                                List<Document> products = sistema_atend.find(new Document("user", user))
                                                .first().getList("products", Document.class);

                                if (products.size() == LIMIT) {
                                        long firstExpiration = products.get(0).getLong("expiration");
                                        System.out.println(
                                                        "ERRO: Limite de produtos atingido! Volte a tentar dentro de "
                                                                        + (firstExpiration - System.currentTimeMillis())
                                                                                        / 1000
                                                                        + " segundos.");
                                } else {
                                        if (productExists(products, product)) { // verifica se o produto já existe
                                                System.out.println("ERRO: Produto já existe!");
                                                continue;
                                        }
                                        addProduct(user, product, System.currentTimeMillis() + TIMESLOT);
                                        System.out.println("Produto adicionado com sucesso!");
                                }
                        }
                }

                sistema_atend.drop();
        }

        public static void addProduct(String user, String productName, long expirationTime) {
                long start, end;

                Document product = new Document("name", productName).append("expiration", expirationTime);

                start = System.nanoTime();
                sistema_atend.updateOne(
                                new Document("user", user),
                                new Document("$push", new Document("products", product)));
                end = System.nanoTime();

                System.out.println("Tempo de execução para adicionar produto (MongoDB): " + (end - start) + " ns");
        }

        public static void listCheck(String user) {
                long start, end;

                start = System.nanoTime();
                List<Object> products = sistema_atend.find(new Document("user", user)).first().getList("products",
                                Object.class);
                List<Document> newProducts = new ArrayList<>();

                for (Object productObj : products) {
                        if (productObj instanceof Document) {
                                Document p = (Document) productObj;
                                if (p.getLong("expiration") > System.currentTimeMillis()) {
                                        newProducts.add(p);
                                }
                        }
                }

                sistema_atend.updateOne(new Document("user", user),
                                new Document("$set", new Document("products", newProducts)));
                end = System.nanoTime();

                System.out.println("Tempo de execução para verificar produtos expirados (MongoDB): " + (end - start)
                                + " ns");
        }

        public static boolean productExists(List<Document> products, String product) {
                boolean exists = false;
                for (Document p : products) {
                        if (p.getString("name").equals(product)) {
                                exists = true;
                                break;
                        }
                }
                return exists;
        }

}