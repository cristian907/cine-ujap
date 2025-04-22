import composables.StoreMain;
import loaders.LoadData;
import validateItem.Validate;
import process.ProcessMain;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String text = "";
        int[][][] movieInfo;
        String[][] showtimes;
        String[] movies;
        int movieQty = 0, timeQty = 0;
        Scanner key = new Scanner(System.in);

        boolean databaseExists = Validate.fileExists();

        if (databaseExists) {
            movies = LoadData.loadNames();
            showtimes = LoadData.loadTimes(movies);
            if (movies != null && showtimes != null) {
                movieInfo = new int[movies.length][showtimes.length][3];
            } else {
                System.out.println("Error: Fallo al cargar el archivo");
                return;
            }
        } else {
            // Peticion de longitud de los arreglos
            text = "\nIntroduzca la cantidad de peliculas para el día de hoy: ";
            movieQty = Validate.valSize(text, key);

            text = "\nIntroduzca la cantidad de horarios por pelicula: ";
            timeQty = Validate.valSize(text, key);

            // Instanciacion de Arreglos
            movies = new String[movieQty*2];
            showtimes = new String[movieQty][timeQty+1];
            movieInfo = new int[movieQty][timeQty][3];
            System.out.println(showtimes[0][2]);
        }
        //desarrollo
        ProcessMain.process(movieInfo, showtimes, movies, key, databaseExists);
        StoreMain.store(movieInfo, showtimes, movies);

        movieInfo = null;
        showtimes = null;
        movies = null;
        key.close();
    }
}
