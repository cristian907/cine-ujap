package process;

import java.io.IOException;
import java.util.Scanner;

public class ProcessMain {
    public static void process(int[][][] movieInfo, String[][] showTimes, String[] movies, String[] genres, String[][] finShowTime, Scanner key) throws IOException {

        Process.iniSeats(movieInfo);

        //Inicio de Arreglos
        Process.iniShowtime(showTimes);
        Process.iniMovie(movies);
        Process.inigenres(genres);
        Process.inifinShowtime(finShowTime);

        //Process desarrollo
        Process.attachData(showTimes, movies, genres, finShowTime, key);

        Process.showMenu(movies, showTimes, movieInfo, genres, finShowTime, key);
    }
}
