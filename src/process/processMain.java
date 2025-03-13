package process;

import java.util.Scanner;

public class processMain {
    public static  void process(int triArray[][][], String biArray[][], String strArray[], Scanner key){
        //Inicio de Arrglos
        process.iniSeats(triArray);
        process.iniShowtime(biArray);
        process.iniMovie(strArray);

        //Process desarrollo
        process.attachData(biArray, strArray, key);
        process.showMenu(strArray,biArray,triArray, key);
    }

}
