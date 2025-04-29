package helpers;

import Structure.Queue;
import Structure.Stack;
import composables.StoreArchive;
import repositories.ArchiveUtil;
import repositories.Genre;
import repositories.Movie;
import repositories.Time;
import validateItem.Validate;

import java.io.IOException;
import java.util.Scanner;

public class ConsultMain {

    public static Queue<Movie> movieQueue = new Queue<>();
    public static Queue<Time> timeQueue = new Queue<>();
    public static Queue<Genre> genreQueue = new Queue<>();
    public static Stack<Object> stack = new Stack<>();

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

            if (option == 1) {
                ConsultData.selectSearch(0, key, arch);
            } else if (option == 2) {
                ConsultData.selectSearch(1, key, arch);
            } else if (option == 3) {
                ConsultData.selectSearch(2, key, arch);
            } else if (option == 4) {
                ConsultData.showCaseDequeue();
                StoreArchive.StackStore(stack, arch);
                System.out.println("¡Gracias por elegir CineUjap, vuelva pronto!");
            } else {
                System.out.println("\n¡ERROR! Elija una opción valida");
                System.out.print("Presione ENTER para continuar: ");
                key.nextLine();
            }
            System.out.println(option);
        } while (option != 4);
    }
}