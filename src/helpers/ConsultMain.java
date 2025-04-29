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



    public static void consult(Scanner key, ArchiveUtil arch) throws IOException {
        Queue<Movie> movieQueue = new Queue<>();
        Queue<Time> timeQueue = new Queue<>();
        Queue<Genre> genreQueue = new Queue<>();
        Stack<Object> stack = new Stack<>();
        String text = "";
        int option;
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
                ConsultData.searchName(key, arch, movieQueue);
            } else if (option == 2) {
                ConsultData.searchHours(key, arch, timeQueue);
            } else if (option == 3) {
                ConsultData.searchGenres(key, arch, genreQueue);
            } else if (option == 4) {
                ConsultData.showCaseDequeue(movieQueue,timeQueue, genreQueue, stack);
                StoreArchive.StackStore(stack, arch);
                System.out.println("¡Gracias por elegir CineUjap, vuelva pronto!");
                return;
            } else {
                System.out.println("\n¡ERROR! Elija una opción valida");
                System.out.print("Presione ENTER para continuar: ");
                key.nextLine();
            }
        } while (option != 4);

    }
}