package org.example;

import org.apache.spark.launcher.JavaModuleOptions;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class CsvToDataframeApp {

    public static void main(String[] args) {
        CsvToDataframeApp app = new CsvToDataframeApp();
        app.start();
    }

    private void start() {
        SparkSession spark = SparkSession.builder()
                .appName("CSV to Dataset")
                .master("local")
                // .master("spark://10.0.0.43:7077") // Indirizzo del master Spark nel container
                // .config("spark.driver.host", "local") // Permette la comunicazione tra host e
                // container
                // .config("spark.driver.bindAddress", "0.0.0.0")
                /// .config("spark.submit.deployMode", "client")

                // Configurazioni opzionali per ottimizzare la connessione
                // .config("spark.executor.memory", "2g")
                // .config("spark.driver.memory", "2g")
                // .config("spark.executor.cores", "2")
                .getOrCreate();

        Dataset<Row> df = spark.read().format("csv")
                .option("header", "true")
                .load("data/books.csv");

        df.show(5);
    }

}
