package helpers;

import repositories.ArchiveUtil;
import validateItem.Validate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConsultMain {

    public static void consult(Scanner key, ArchiveUtil arch) throws IOException {

        String text = "";
        int option, opt = 0;
        System.out.println("\n\nSeleccione el modo de busqueda:");
        do {
            System.out.println("\nMenu de Opciones");
            System.out.println("1. Busqueda de peliculas por nombre");
            System.out.println("2. Busqueda de peliculas por horario");
            System.out.println("3. Busqueda de peliculas por género");
            System.out.println("4. Terminar busqueda");
            text = "\nSeleccione una opción: ";
            option = Validate.valOpt(text, key);
            switch (option) {
                case 1:
                    ConsultData.selectSearch(0, key, arch);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("¡Gracias por elegir CineUjap, vuelva pronto!");
                    break;
                default:
                    System.out.println("\n¡ERROR! Elija una opción valida");
                    System.out.print("Presione ENTER para continuar: ");
                    key.nextLine();
            }
        } while (option != 4);


    }


}