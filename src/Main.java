import composables.storeMain;
import validateItem.Validate;
import process.processMain;
import composables.storeMain;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException {
        String text = "";
        int[][][] movieInfo;
        String[][] showtimes;
        String[] movies;
        int movie, times = 0;
        Scanner key = new Scanner(System.in);


        // Peticion de longitud de los arreglos

        text = "\nIntroduzca la cantidad de peliculas para el día de hoy: ";
        movie = Validate.valSize(text, key);

        text = "\nIntroduzca la cantidad de horarios por pelicula: ";
        times = Validate.valSize(text, key);


        // Instanciacion de Arreglos
        movies = new String[movie];
        showtimes = new String[movie][times];
        movieInfo = new int[movie][times][3];

        //desarrollo
        processMain.process(movieInfo,showtimes,movies,key);
        storeMain.store(movieInfo, showtimes, movies);

        movieInfo = null;
        showtimes = null;
        movies = null;
        key.close();
    }
}
