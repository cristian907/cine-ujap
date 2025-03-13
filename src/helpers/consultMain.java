package helpers;

import validateItem.Validate;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class consultMain {

    public static void consult(boolean opt, Scanner key) throws IOException {
        String movies = Paths.get("").toRealPath().toString() + "/src/storage/storeMovieSchedule.txt";
        String times = Paths.get("").toRealPath().toString() + "/src/storage/storeMovieSchedule.txt";
        String text;

        if (opt) {
            Scanner file = Validate.readFile(movies);
            text = "Introduzca el nombre de la pelicula a buscar";
            System.out.println(text);
            String name = Validate.validMovieName(text, key);
            String[] res;
            if (file != null) {
                res = consultData.consultName(file, name);
                if (res != null) {
                    consultData.showCaseMovie(res);
                } else {
                    System.out.println("El nombre no fue encontrado.");
                }
            }

        } else {
            Scanner file = Validate.readFile(times);
            text = "Introduzca el primer horario del rango a buscar";
            System.out.println(text);
            String hi = Validate.validHour(text, key);
            text = "Introduzca el segundo horario del rango a buscar";
            System.out.println(text);
            String hf = Validate.validHour(text, key);
            String r = "";
            if (file != null) {
                String res = consultData.consultTime(file, consultData.convertTime(hi), consultData.convertTime(hf), r);
                if (!res.trim().isEmpty()) {
                    consultData.showCaseTime(res);
                } else {
                    System.out.println("Disculpe, no hay peliculas en ese rango.");
                }
            }

        }
    }
}