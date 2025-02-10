package cinema;

public class Main {
    public static void main(String[] args) {
        String text = "";
        int[][][] movies = new int[5][5][5];
        String[][] showtimes = new String[5][5];
        String[] name = new String[5];
        int movie, times;

        text = "Introduzca la cantidad de peliculas para el día de hoy";
        movie = Validate.valSize(text);

        text = "Introduzca la cantidad de horarios por pel";



        Process.iniInfo(movies);
        Process.iniShowtime(showtimes);
        Process.iniMovie(name);

        Process.attachData(movies, showtimes, name);

        movies = null;
        showtimes = null;
        name = null;
    }
}
