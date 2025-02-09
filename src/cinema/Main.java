package cinema;

public class Main {
    public static void main(String[] args) {
        int[][][] movies = new int[5][5][5];
        int[][] showtimes = new int[5][5];
        String[] name = new String[5];
        Process.iniInfo(movies);
        Process.iniShowtime(showtimes);
        Process.iniMovie(name);

        movies = null;
        showtimes = null;
        name = null;
    }
}
