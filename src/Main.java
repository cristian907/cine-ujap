import composables.StoreMain;
import helpers.ConsultMain;
import repositories.ArchiveUtil;
import validateItem.Validate;
import process.ProcessMain;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String text = "";
        int[][][] movieInfo;
        String[][] showtimes;
        String[] movies;
        String[][] finShowtimes;
        String[] genres;
        ArchiveUtil archive = null;
        int movieQty = 0, timeQty = 0;
        Scanner key = new Scanner(System.in);

        String router = Paths.get("").toRealPath().toString() + "/src/storage/";

        try {
            archive = new ArchiveUtil(router);
        } catch (FileNotFoundException | IllegalArgumentException e) {
            System.out.println("- Error-Instancia: [" + e.getMessage() + "] ");
            return;
        }

        if (archive.directoriesExist()) {
            int option = 0;
            System.out.println("\n\nBienvenido a Cine-Ujap:");
            do {
                System.out.println("\nSeleccione un modulo");
                System.out.println("1. Modulo de busqueda");
                System.out.println("2. Modulo de ventas");
                System.out.println("3. Cerrar Programa");
                text = "\nSeleccione una opción: ";
                option = Validate.valOpt(text, key);

                if (option == 1) {
                    ConsultMain.consult(key, archive);
                    return;
                } else if (option == 2) {

                } else if (option == 3) {
                    return;
                } else {
                    System.out.println("\n¡ERROR! Elija una opción valida");
                    System.out.print("Presione ENTER para continuar: ");
                    key.nextLine();
                }
            } while (option != 2);

        }

        // Peticion de longitud de los arreglos
        text = "\nIntroduzca la cantidad de peliculas para el día de hoy: ";
        movieQty = Validate.valSize(text, key);

        text = "\nIntroduzca la cantidad de horarios por pelicula: ";
        timeQty = Validate.valSize(text, key);

        // Instanciacion de Arreglos
        movies = new String[movieQty];
        showtimes = new String[movieQty][timeQty];
        movieInfo = new int[movieQty][timeQty][3];
        genres = new String[movieQty];
        finShowtimes = new String[movieQty][timeQty];

        //desarrollo
        ProcessMain.process(movieInfo, showtimes, movies, genres, finShowtimes, key);
        StoreMain.store(movieInfo, showtimes, movies, genres, finShowtimes, archive);

        movies = null;
        showtimes = null;
        movieInfo = null;
        genres = null;
        finShowtimes = null;
        archive = null;
        key.close();
    }
}

