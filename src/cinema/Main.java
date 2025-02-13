package cinema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text = "";
        int[][][] movieInfo;
        String[][] showtimes;
        String[] movies;
        int movie, times = 0;
        Scanner key = new Scanner(System.in);
        String route = "src/cinema/Reporte.txt";

        // Peticion de longitud de los arreglos
        text = "\nIntroduzca la cantidad de peliculas para el día de hoy: ";
        movie = Validate.valSize(text, key);

        text = "\nIntroduzca la cantidad de horarios por pelicula: ";
        times = Validate.valSize(text, key);

        // Instanciacion de Arreglos
        movies = new String[movie];
        showtimes = new String[movie][times];
        movieInfo = new int[movie][times][3];

        // Inicializacion de Arreglos
        Process.iniSeats(movieInfo);
        Process.iniShowtime(showtimes);
        Process.iniMovie(movies);

        // Llenado inicial de datos de los arreglos
        Process.attachData(showtimes, movies, key);

        // Ejecucion del menu de opciones
        Process.showMenu(movies, showtimes, movieInfo, route, key);

        movieInfo = null;
        showtimes = null;
        movies = null;
        key.close();
    }
}
