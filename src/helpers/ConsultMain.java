package helpers;

import validateItem.Validate;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConsultMain {

    public static void consult(boolean opt, Scanner key) throws IOException {
        String movies = Paths.get("").toRealPath().toString() + "/src/storage/MovieSchedule.txt";
        String times = Paths.get("").toRealPath().toString() + "/src/storage/MovieSchedule.txt";
        String text;

        if (opt) {
            Scanner file = Validate.readFile(movies);
            text = "Introduzca el nombre de la pelicula a buscar: ";
            System.out.println(text);
            String name = Validate.validMovieName(text, key);
            String[] res;
            if (file != null) {
                res = ConsultData.consultName(file, name);
                if (res != null) {
                    ConsultData.showCaseMovie(res);
                } else {
                    System.out.println("El nombre no fue encontrado.");
                }
            }

        } else {
            Scanner file = Validate.readFile(times);
            text = "Introduzca el primer horario del rango a buscar: ";
            System.out.println(text);
            String hi = Validate.validHour(text, key);
            text = "Introduzca el segundo horario del rango a buscar: ";
            System.out.println(text);
            String hf = Validate.validHour(text, key);
            String r = "";
            if (file != null) {
                String res = ConsultData.consultTime(file, ConsultData.convertTime(hi), ConsultData.convertTime(hf), r);
                if (!res.trim().isEmpty()) {
                    ConsultData.showCaseTime(res);
                } else {
                    System.out.println("Disculpe, no hay peliculas en ese rango.");
                }
            }

        }
    }
}