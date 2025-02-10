package cinema;

public class Main {
    public static void main(String[] args) {
        String text = "";
        int[][][] seats;
        String[][] showtimes;
        String[] name;
        int movie, times;

        // Peticion de longitud de los arreglos
        text = "Introduzca la cantidad de peliculas para el día de hoy: ";
        movie = Validate.valSize(text);

        text = "Introduzca la cantidad de horarios por pelicula: ";
        times = Validate.valSize(text);

        //Instanciacion de Arreglos
        name = new String[movie];
        showtimes = new String[movie][times];
        seats = new int[movie][times][20];

       //Inicializacion de Arreglos
        Process.iniSeats(seats);
        Process.iniShowtime(showtimes);
        Process.iniMovie(name);

        //LLenado de datos de los arreglos
        Process.attachData(seats, showtimes, name);

        seats = null;
        showtimes = null;
        name = null;
    }
}
