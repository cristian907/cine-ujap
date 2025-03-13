package process;

import validateItem.Validate;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class processMain {
    public static void process(int[][][] triArray, String[][] biArray, String[] strArray, Scanner key, boolean databaseExists) throws IOException {

        process.iniSeats(triArray);
        if (!databaseExists) {
            //Inicio de Arreglos
            process.iniShowtime(biArray);
            process.iniMovie(strArray);

            //Process desarrollo
            process.attachData(biArray, strArray, key);
        }

        process.showMenu(strArray,biArray,triArray, key);
    }
}
