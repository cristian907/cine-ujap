package cinema;

public class Main {
    public static void main(String[] args) {
        int[][][] movies = new int[5][5][5];
        String[][] showtimes = new String[5][5];
        String[] name = new String[5];
        Process.iniInfo(movies);
        Process.iniShowtime(showtimes);
        Process.iniMovie(name);

        Process.attachData(movies, showtimes, name);

        movies = null;
        showtimes = null;
        name = null;
    }
}
