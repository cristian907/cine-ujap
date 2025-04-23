package helpers;

import java.util.Arrays;
import java.util.Scanner;

public class ConsultData {

    public static int convertTime(String text) {
        String[] time = text.split(":");
        int h = Integer.parseInt(time[0]) * 60;
        int m = Integer.parseInt(time[1]);
        time = null;
        return h + m;
    }

    public static boolean isMovieInRange(String[] line, int min, int max) {
        if (line != null) {
            for (int i = 1; i < line.length; i++) {
                int t = convertTime(line[i]);
                if (t >= min && t <= max) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getTimes(String text, String[] line, int min, int max) {
        if (line != null) {
            for (int i = 1; i < line.length; i++) {
                int t = convertTime(line[i]);
                if (t >= min && t <= max) {
                    text = text + " " + line[i];
                }
            }
        }
        return text;
    }

    public static String[] consultName(Scanner arch, String name) {
        name = name.toLowerCase();
        if (!arch.hasNextLine()) {
            return null;
        }

        String[] line = arch.nextLine().split(" ");
        String value = line[0].toLowerCase();
        line = Arrays.copyOfRange(line, 1, line.length);

        if (value.equals(name)) {
            return line;
        }

        String[] result = consultName(arch, name);

        // Procesamiento adicional: si result es nulo, imprimimos que no se encontró
        if (result == null) {
            System.out.println("El nombre " + name + " no fue encontrado en esta línea: " + String.join(" ", line));
        }

        line = null;
        return result;

    }

    public static String consultTime(Scanner arch, int min, int max, String text) {

        if (!arch.hasNextLine()) {
            return text.trim();
        }
        String[] line = arch.nextLine().split(" ");
        ;
        if (isMovieInRange(line, min, max)) {
            text = text + line[0] + " -";
            text = getTimes(text, line, min, max);
            text = text + "/";
        }

        line = null;
        return consultTime(arch, min, max, text);
    }

    public static String consultGenre(Scanner arch, String genre, String movies){

        if (!arch.hasNextLine()){
            return movies;
        }
        String[] line = arch.nextLine().split(" ");
        String value = line[1].toLowerCase();
        if (value.equals(genre)){
            movies = movies + line[0] + " ";
        }

        line = null;
        return consultGenre(arch, genre, movies);
    }

    public static void showCaseMovie(String[] name) {
        if (name != null) {
            System.out.print(name[0] + " - ");
            for (int i = 1; i < name.length; i++) {
                System.out.print(name[i] + " ");
            }
            System.out.println();
        }
    }

    public static void showCaseTime(String text) {
        String[] line = text.split("/");
        System.out.println("Peliculas disponibles en este horario");
        for (int i = 0; i < line.length; i++) {
            System.out.println(line[i]);
        }
        line = null;
    }
    public static void showCaseGenres(String text){
        String[] line = text.split(" ");
        System.out.println("peliculas pertenecientes a este genero");
        for (int i = 0; i < line.length; i++) {
            System.out.println(line[i]);
        }
        line = null;
    }
}


