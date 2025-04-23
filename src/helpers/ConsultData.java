package helpers;

import repositories.ArchiveUtil;
import repositories.Genre;
import repositories.Movie;
import repositories.Time;
import validateItem.Validate;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
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

    public static String consultGenre(Scanner arch, String genre, String movies) {

        if (!arch.hasNextLine()) {
            return movies;
        }
        String[] line = arch.nextLine().split(" ");
        String value = line[1].toLowerCase();
        if (value.equals(genre)) {
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

    public static void showCaseGenres(String text) {
        String[] line = text.split(" ");
        System.out.println("peliculas pertenecientes a este genero");
        for (int i = 0; i < line.length; i++) {
            System.out.println(line[i]);
        }
        line = null;
    }

    public static void selectSearch(int opt, Scanner key, ArchiveUtil archive) {
        String text = "";
        String[] directoryList;
        if (opt == 0) {
            Movie movieDefault = null;
            text = "Introduzca el nombre de la pelicula a buscar: ";
            System.out.println(text);
            String name = Validate.validMovieName(text, key);

            try {
                movieDefault = new Movie(name, "default");
            } catch (IllegalArgumentException e) {
                System.out.println();
            }

            directoryList = archive.getDirectories();
            String file = "";
//            String file = getDirectoresPerName(directoryList, movieDefault);

            if (file == null) {
                System.out.println("Error al abrir el archivo.");
                return;
            }

            Scanner movieFile = archive.getArchive(file);

            String[] res = consultName(movieFile, name);
            if (res != null) {
//                ConsultData.showCaseMovie(res);
            } else {
                System.out.println("El nombre no fue encontrado.");
                return;
            }
            res = null;


        } else if (opt == 1) {
            Time timeDefault = null;
            text = "Introduzca el primer horario del rango a buscar: ";
            System.out.println(text);
            String hi = Validate.validHour(text, key);
            text = "Introduzca el segundo horario del rango a buscar: ";
            System.out.println(text);
            String hf = Validate.validHour(text, key);
            String r = "";

            try {
                timeDefault = new Time(hi, hf, "Default");
            } catch (IllegalArgumentException e) {
                System.out.println();
            }

            directoryList = archive.getDirectories();
            String file = "";
//            String file = getDirectoresPerName(directoryList, timeDefault);

            if (file == null) {
                System.out.println("Error al abrir el archivo.");
                return;
            }

            Scanner timeFile = archive.getArchive(file);

            String res = consultTime(timeFile, convertTime(hi), convertTime(hf), r);
            if (!res.trim().isEmpty()) {
//                ConsultData.showCaseTime(res);
            } else {
                System.out.println("Disculpe, no hay peliculas en ese rango.");
            }

            file = null;
        } else {
            Genre genreDefault = null;
            text = "Introduzca el nombre del genero a buscar: ";
            System.out.println(text);
            String name = Validate.validMovieName(text, key);
            String movies = "";

            try {
                genreDefault = new Genre(name, "Default");
            } catch (IllegalArgumentException e) {
                System.out.println();
            }

            directoryList = archive.getDirectories();
            String file = "";
//            String file = getDirectoresPerName(directoryList, Default);

            if (file == null) {
                System.out.println("Error al abrir el archivo.");
                return;
            }

            Scanner genreFile = archive.getArchive(file);

            String res = consultGenre(genreFile, name, movies);
            if (!res.trim().isEmpty()) {
//                ConsultData.showCaseGenres(movies);
                file = null;
            } else {
                System.out.println("Disculpe, el genero no fue encontrado");
            }
            file = null;
        }
    }
}


