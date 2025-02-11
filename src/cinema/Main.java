package cinema;

public class Main {
    public static void main(String[] args) {
        String text = "";
        int[][][] info;
        String[][] showtimes;
        String[] movies;
        int movie, times;

        // Peticion de longitud de los arreglos
        text = "Introduzca la cantidad de peliculas para el día de hoy: ";
        movie = Validate.valSize(text);

        text = "Introduzca la cantidad de horarios por pelicula: ";
        times = Validate.valSize(text);

        //Instanciacion de Arreglos
        movies = new String[movie];
        showtimes = new String[movie][times];
        info = new int[movie][times][4];

        //Inicializacion de Arreglos
        Process.iniSeats(info);
        Process.iniShowtime(showtimes);
        Process.iniMovie(movies);

        //LLenado de datos de los arreglos
        Process.attachData(showtimes, movies);
        Process.showCase(movies, showtimes);

        Process.buyTicket(movies, showtimes, info);
        info = null;
        showtimes = null;
        movies = null;
    }
}
