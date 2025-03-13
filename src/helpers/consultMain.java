package helpers;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class consultMain{

    public consultMain() throws FileNotFoundException {
        Scanner archivo = new Scanner(new File("prueba.txt"));
        String text="";
        String prueba=consultData.consultTime(archivo, consultData.convertTime("1:00"), consultData.convertTime("3:00"), text);
        consultData.showCaseTime(prueba);

    }
}
