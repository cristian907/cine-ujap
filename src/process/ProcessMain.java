package process;

import java.io.IOException;
import java.util.Scanner;

public class ProcessMain {
    public static void process(int[][][] triArray, String[][] biArray, String[] strArray, Scanner key, boolean databaseExists) throws IOException {

        Process.iniSeats(triArray);
        if (!databaseExists) {
            //Inicio de Arreglos
            Process.iniShowtime(biArray);
            Process.iniMovie(strArray);

            //Process desarrollo
            Process.attachData(biArray, strArray, key);
        }

        Process.showMenu(strArray,biArray,triArray, key);
    }
}
