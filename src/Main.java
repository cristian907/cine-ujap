import validateItem.Validate;
import process.processMain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text = "";
        int[][][] movieInfo;
        String[][] showtimes;
        String[] movies;
        int movie, times = 0;
        String route = System.getProperty("user.dir")+"/src/cinema/Report.txt";
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

        movieInfo = null;
        showtimes = null;
        movies = null;
        key.close();
    }
}
