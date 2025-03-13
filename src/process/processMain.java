package process;

import validateItem.Validate;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class processMain {
    public static void process(int[][][] triArray, String[][] biArray, String[] strArray, Scanner key) throws IOException {

        //Inicio de Arreglos
        process.iniSeats(triArray);
        process.iniShowtime(biArray);
        process.iniMovie(strArray);

        //Process desarrollo
        process.attachData(biArray, strArray, key);
        process.showMenu(strArray,biArray,triArray, key);
    }
}
