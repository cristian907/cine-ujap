import composables.StoreMain;
import repositories.ArchiveUtil;
import storage.LoadData;
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

        String router = Paths.get("").toRealPath().toString()+"/src/storage/";

        try {
            archive = new ArchiveUtil(router);
        } catch (FileNotFoundException | IllegalArgumentException e) {
            System.out.println("- Error-Instancia: ["+e.getMessage()+"] ");
            return;
        }

        int movieQty = 0, timeQty = 0;
        Scanner key = new Scanner(System.in);

//        boolean databaseExists = Validate.fileExists();
//
//        if (databaseExists) {
//            movies = LoadData.loadNames();
//            showtimes = LoadData.loadTimes(movies);
//            if (movies != null && showtimes != null) {
//                movieInfo = new int[movies.length][showtimes.length][3];
//            } else {
//                System.out.println("Error: Fallo al cargar el archivo");
//               // return;
//            }
//        } else {
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
//        }
            //desarrollo
            ProcessMain.process(movieInfo, showtimes, movies, genres, finShowtimes, key);
            StoreMain.store(movieInfo, showtimes, movies ,genres,finShowtimes, archive);

            movies = null;
            showtimes = null;
            movieInfo = null;
            genres = null;
            finShowtimes = null;
            archive = null;
            key.close();
        }
    }

