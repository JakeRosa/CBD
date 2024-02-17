package com.mycompany.app;

import java.io.PrintWriter;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;

public class App {
        public static void main(String[] args) {
                Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "12345678"));
                try (Session session = driver.session(SessionConfig.forDatabase("healthcare"))) {
                        PrintWriter writer = new PrintWriter("CBD_L44c_output.txt", "UTF-8");

                        // reset database
                        session.run("MATCH (n) DETACH DELETE n");

                        // insert data
                        insertData(session);

                        // queries
                        System.out.println("Starting queries..." + "\n");

                        System.out.println("\n 1. Encontrar a média de idade dos pacientes admitidos em cada hospital");
                        writer.println("1. Encontrar a média de idade dos pacientes admitidos em cada hospital");
                        Result result1 = session.run("MATCH (p:Person)-[:ADMITTED_TO]->(h:Hospital)\n" +
                                        "RETURN h.name AS HospitalName, AVG(p.age) AS AverageAge\n" +
                                        "LIMIT 3000"); // o output estava muito grande
                        for (Record record : result1.list()) {
                                System.out.println(record);
                                writer.println(record);
                        }
                        System.out.println("(...)");
                        writer.println("(...)");
                        System.out.println();

                        System.out.println(
                                        "\n 2. Médicos que trataram pacientes com resultados de teste anormais e a lista dos mesmos");
                        writer.println(
                                        "\n 2. Médicos que trataram pacientes com resultados de teste anormais e a lista dos mesmos");
                        Result result2 = session.run("MATCH (d:Doctor)-[t:TREATED]->(p:Person)\n" +
                                        "WHERE t.testResults = 'Abnormal'\n" +
                                        "RETURN d.name AS doctorName, COLLECT(p.name) AS peopleAbnormalResults\n" +
                                        "LIMIT 3000"); // o output estava muito grande
                        for (Record record : result2.list()) {
                                System.out.println(record);
                                writer.println(record);
                        }
                        System.out.println("(...)");
                        writer.println("(...)");
                        System.out.println();

                        System.out.println("\n 3. Hospitais que trataram pessoas com mais de 84 anos");
                        writer.println("\n 3. Hospitais que trataram pessoas com mais de 84 anos");
                        Result result3 = session.run("MATCH (p:Person)-[:ADMITTED_TO]->(h:Hospital)\n" +
                                        "WHERE p.age > 84\n" +
                                        "RETURN DISTINCT h.name");
                        for (Record record : result3.list()) {
                                System.out.println(record);
                                writer.println(record);
                        }
                        System.out.println();

                        System.out.println("\n 4. Contagem de pessoas para cada condição médica");
                        writer.println("\n 4. Contagem de pessoas para cada condição médica");
                        Result result4 = session.run("MATCH (p:Person)\n" +
                                        "RETURN p.medicalCondition, COUNT(p) AS peopleCount\n" +
                                        "ORDER BY peopleCount DESC");
                        for (Record record : result4.list()) {
                                System.out.println(record);
                                writer.println(record);
                        }
                        System.out.println();

                        System.out.println(
                                        "\n 5. Médicos que trabalham/já trabalharam em mais que um hospitais, e a lista dos mesmos");
                        writer.println(
                                        "\n 5. Médicos que trabalham/já trabalharam em mais que um hospitais, e a lista dos mesmos");
                        Result result5 = session.run("MATCH (d:Doctor)-[:WORKS_ON]->(h:Hospital)\n" +
                                        "WITH d, COLLECT(h.name) AS hospitals\n" +
                                        "WHERE SIZE(hospitals) > 1\n" +
                                        "RETURN d.name, hospitals");
                        for (Record record : result5.list()) {
                                System.out.println(record);
                                writer.println(record);
                        }
                        System.out.println();

                        System.out.println("\n 6. Caminho mais longo entre dois pacientes");
                        writer.println("\n 6. Caminho mais longo entre dois pacientes");
                        Result result6 = session.run("MATCH path = shortestPath((p1:Person)-[*]-(p2:Person))\n" +
                                        "WHERE p1 <> p2\n" +
                                        "RETURN p1.name, p2.name, length(path)\n" +
                                        "ORDER BY length(path) DESC\n" +
                                        "LIMIT 1");
                        for (Record record : result6.list()) {
                                System.out.println(record);
                                writer.println(record);
                        }
                        System.out.println();

                        System.out.println("\n 7. Os 5 hospitais com mais pacientes diabéticos");
                        writer.println("\n 7. Os 5 hospitais com mais pacientes diabéticos");
                        Result result7 = session.run("MATCH (p:Person)-[:ADMITTED_TO]->(h:Hospital)\n" +
                                        "WHERE p.medicalCondition = 'Diabetes'\n" +
                                        "RETURN h.name AS HospitalName, COUNT(p) AS DiabeticPatientsCount\n" +
                                        "ORDER BY DiabeticPatientsCount DESC\n" +
                                        "LIMIT 5");
                        for (Record record : result7.list()) {
                                System.out.println(record);
                                writer.println(record);
                        }
                        System.out.println();

                        System.out.println("\n 8. Média de idade dos pacientes por médico");
                        writer.println("\n 8. Média de idade dos pacientes por médico");
                        Result result8 = session.run("MATCH (d:Doctor)-[:TREATED]->(p:Person)\n" +
                                        "RETURN d.name AS DoctorName, AVG(p.age) AS AveragePatientAge\n" +
                                        "ORDER BY AveragePatientAge DESC\n" +
                                        "LIMIT 3000"); // o output estava muito grande
                        for (Record record : result8.list()) {
                                System.out.println(record);
                                writer.println(record);
                        }
                        System.out.println("(...)");
                        writer.println("(...)");
                        System.out.println();

                        System.out.println(
                                        "\n 9. O médico que tratou o maior número de pacientes com condições médicas anormais");
                        writer.println("\n 9. O médico que tratou o maior número de pacientes com condições médicas anormais");
                        Result result9 = session.run("MATCH (d:Doctor)-[t:TREATED]->(p:Person)\n" +
                                        "WHERE t.testResults = 'Abnormal'\n" +
                                        "RETURN d.name AS DoctorName, COUNT(p) AS abnormalPatientsCount\n" +
                                        "ORDER BY abnormalPatientsCount DESC\n" +
                                        "LIMIT 1");
                        for (Record record : result9.list()) {
                                System.out.println(record);
                                writer.println(record);
                        }
                        System.out.println();

                        System.out.println(
                                        "\n 10. A média de idade dos pacientes admitidos em cada tipo de condição médica");
                        writer.println("\n 10. A média de idade dos pacientes admitidos em cada tipo de condição médica");
                        Result result10 = session.run("MATCH (p:Person)-[:ADMITTED_TO]->(h:Hospital)\n" +
                                        "RETURN p.medicalCondition AS condition, AVG(p.age) AS AverageAge\n" +
                                        "ORDER BY AverageAge DESC");
                        for (Record record : result10.list()) {
                                System.out.println(record);
                                writer.println(record);
                        }
                        System.out.println();

                        session.close();
                        driver.close();

                        writer.flush();
                        writer.close();

                } catch (Exception e) {
                        System.out.println(e);
                }

        }

        public static void insertData(Session session) {
                System.out.println("Inserting data..." + "\n");
                session.run("LOAD CSV WITH HEADERS FROM 'file:///healthcare_dataset.csv' AS row\n" +
                                "MERGE (p:Person {name: row.Name})\n" +
                                "SET p += {\n" +
                                "  age: toInteger(row.Age),\n" +
                                "  gender: row.Gender,\n" +
                                "  bloodType: row[\"Blood Type\"],\n" +
                                "  medicalCondition: row[\"Medical Condition\"],\n" +
                                "  billingAmount: toFloat(row[\"Billing Amount\"])," +
                                "  roomNumber: toInteger(row[\"Room Number\"])," +
                                "  dischargeDate: date(row[\"Discharge Date\"])\n" +
                                "}\n" +
                                "MERGE (doc:Doctor {name: row.Doctor})\n" +
                                "MERGE (h:Hospital {name: row.Hospital})\n");

                session.run("LOAD CSV WITH HEADERS FROM 'file:///healthcare_dataset.csv' AS row\n" +
                                "MATCH (p:Person {name: row.Name})\n" +
                                "MATCH (h:Hospital {name: row.Hospital})\n" +
                                "MERGE (p)-[:ADMITTED_TO {\n" +
                                "  dateOfAdmission: date(row[\"Date of Admission\"])," +
                                "  admissionType: row[\"Admission Type\"]\n" +
                                "}]->(h)\n");

                session.run("LOAD CSV WITH HEADERS FROM 'file:///healthcare_dataset.csv' AS row\n" +
                                "MATCH (d:Doctor {name: row.Doctor})\n" +
                                "MATCH (h:Hospital {name: row.Hospital})\n" +
                                "MERGE (d)-[:WORKS_ON]->(h)\n");

                session.run("LOAD CSV WITH HEADERS FROM 'file:///healthcare_dataset.csv' AS row\n" +
                                "MATCH (p:Person {name: row.Name})\n" +
                                "MATCH (d:Doctor {name: row.Doctor})\n" +
                                "MERGE (d)-[:TREATED {\n" +
                                "  medication: row.Medication,\n" +
                                "  testResults: row[\"Test Results\"]\n" +
                                "}]->(p)\n");
                System.out.println("Data inserted successfully! \n");
        }
}
