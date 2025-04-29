package helpers;

import Structure.Queue;
import Structure.Stack;
import repositories.ArchiveUtil;
import repositories.Genre;
import repositories.Movie;
import repositories.Time;
import validateItem.Validate;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static helpers.ConsultMain.*;

public class ConsultData {

    public static String getItemsByIndex(String[] items, String index, String select) {

        for (int i = 0; i < select.length(); i++) {
            if (select.charAt(i) == index.charAt(0)) {
                return items[Integer.parseInt(index) - 1];
            }
        }
        return null;
    }

    public static String getDirectoriesPerMovie(String[] items, Movie movieDefault, Scanner key) {

        String txt = "";
        String compare, select = "";
        String text = "\n - Aqui estan los archivos existentes, en cual desea buscar ? \n eliga numeros ";

        if (items == null || items.length < 1) {
            return null;
        }
        System.out.println(text);
        for (int i = 0; i < items.length; i++) {

            if (Objects.equals(items[i].split("_")[0], "MoviesWithOnlyHour")) {
                System.out.println("-  Posicion [" + (i + 1) + "] [" + items[i] + "]");
                select = select + (i + 1);
            }
        }


        String index = key.nextLine();
        txt = getItemsByIndex(items, index, select);

        if (txt == null) {
            return null;
        }

        String[] serialItem = txt.split("_");
        compare = serialItem[serialItem.length - 1];
        movieDefault.setSerialArchive(compare);

        return txt;
    }

    public static String getDirectoriesPerTime(String[] items, Time timeDefault, Scanner key) {

        String txt = "";
        String compare, select = "";
        String text = "\n - Aqui estan los archivos existentes, en cual desea buscar ? \n eliga numeros ";

        if (items == null || items.length < 1) {
            return null;
        }
        System.out.println(text);
        for (int i = 0; i < items.length; i++) {

            if (Objects.equals(items[i].split("_")[0], "MoviesWithOnlyHour")) {
                System.out.println("-  Posicion [" + (i + 1) + "] [" + items[i] + "]");
                select = select + (i + 1);
            }
        }


        String index = key.nextLine();
        txt = getItemsByIndex(items, index, select);

        if (txt == null) {
            return null;
        }

        String[] serialItem = txt.split("_");
        compare = serialItem[serialItem.length - 1];
        timeDefault.setSerialArchive(compare);

        return txt;
    }

    public static String getDirectoriesPerGenre(String[] items, Genre genreDefault, Scanner key) {

        String txt = "";
        String compare, select = "";
        String text = "\n - Aqui estan los archivos existentes, en cual desea buscar ? \n eliga numeros ";

        if (items == null || items.length < 1) {
            return null;
        }
        System.out.println(text);
        for (int i = 0; i < items.length; i++) {

            if (Objects.equals(items[i].split("_")[0], "MovieAndGenreStore")) {
                System.out.println("-  Posicion [" + (i + 1) + "] [" + items[i] + "]");
                select = select + (i + 1);
            }
        }


        String index = key.nextLine();
        txt = getItemsByIndex(items, index, select);

        if (txt == null) {
            return null;
        }

        String[] serialItem = txt.split("_");
        compare = serialItem[serialItem.length - 1];
        genreDefault.setSerialArchive(compare);

        return txt;
    }

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
            movies = movies + line[0] + "/";
        }

        line = null;
        return consultGenre(arch, genre, movies);
    }

    public static void showCaseMovie(Movie movie) {
        if (movie != null) {
            System.out.print(movie.getmovieName() + " - ");
            for (int i = 1; i < movie.getMovieTimes().length; i++) {
                System.out.print(movie.getMovieTimes()[i] + " ");
            }
            System.out.println();
        }
    }

    public static void showCaseTime(Time time) {
        String[] line = time.getMovies().split("/");
        System.out.println("Peliculas disponibles en este horario: " + time.getIniHour() + "-" + time.getFinHour());
        for (int i = 0; i < line.length; i++) {
            System.out.println(line[i]);
        }
        line = null;
    }

    public static void showCaseGenres(Genre genre) {
        String[] line = genre.getMovies().split("/");
        System.out.println(line[0]);
        System.out.println("peliculas pertenecientes a este genero: " + genre.getMovieGenre());
        for (int i = 0; i < line.length; i++) {
            System.out.println(line[i]);
        }
        line = null;
    }

    public static void searchName(Scanner key, ArchiveUtil archive, Queue<Movie> movieQueue){

        String text = "";
        String[] directoryList;

        Movie movieDefault = new Movie();
        text = "Introduzca el nombre de la pelicula a buscar: ";
        System.out.println(text);
        String name = Validate.validMovieName(text, key);

        try {
            movieDefault = new Movie(name, "default");
        } catch (IllegalArgumentException e) {
            System.out.println();
        }

        directoryList = archive.getDirectories();
        String file = getDirectoriesPerMovie(directoryList, movieDefault, key);

        if (file == null) {
            System.out.println("Error al abrir el archivo.");
            return;
        }

        Scanner movieFile = archive.getArchive(file);

        String[] res = consultName(movieFile, name);
        if (res != null) {
            movieDefault.setmovieName(name);
            movieDefault.setMovieTimes(res);
            movieQueue.enqueue(movieDefault);
        } else {
            System.out.println("El nombre no fue encontrado.");
            return;
        }
        res = null;
    }

    public static void searchGenres(Scanner key, ArchiveUtil archive, Queue<Genre> genreQueue){


        String text = "";
        String[] directoryList;

        Genre genreDefault = new Genre();
        text = "Introduzca el nombre del genero a buscar: ";
        System.out.println(text);
        String name = Validate.validGenreName(text, key);
        if (name == null) {
            return;
        }
        String movies = "";

        try {
            genreDefault = new Genre(name, "Default");
        } catch (IllegalArgumentException e) {
            System.out.println();
        }

        directoryList = archive.getDirectories();
        String file = getDirectoriesPerGenre(directoryList, genreDefault, key);

        if (file == null) {
            System.out.println("Error al abrir el archivo.");
            return;
        }

        Scanner genreFile = archive.getArchive(file);

        String res = consultGenre(genreFile, name, movies);
        if (!res.trim().isEmpty()) {
            genreDefault.setMovieGenre(name);
            genreDefault.setMovies(res);
            genreQueue.enqueue(genreDefault);
            file = null;
        } else {
            System.out.println("Disculpe, el genero no fue encontrado");
        }
        file = null;
    }

    public static void searchHours(Scanner key, ArchiveUtil archive, Queue<Time> timeQueue){

        String text = "";
        String[] directoryList;

        Time timeDefault = new Time();
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
        String file = getDirectoriesPerTime(directoryList, timeDefault, key);

        if (file == null) {
            System.out.println("Error al abrir el archivo.");
            return;
        }

        Scanner timeFile = archive.getArchive(file);

        String res = consultTime(timeFile, convertTime(hi), convertTime(hf), r);
        if (!res.trim().isEmpty()) {
            timeDefault.setIniHour(hi);
            timeDefault.setFinHour(hf);
            timeDefault.setMovies(res);
            timeQueue.enqueue(timeDefault);
        } else {
            System.out.println("Disculpe, no hay peliculas en ese rango.");
        }

        file = null;
    }

    public static void showCaseDequeue(Queue<Movie> movieQueue, Queue<Time> timeQueue, Queue<Genre> genreQueue, Stack<Object> stack) {
        while (!movieQueue.isEmpty()) {
            Movie movie = movieQueue.dequeue();
            showCaseMovie(movie);
            stack.push(movie);
        }
        while (!timeQueue.isEmpty()) {
            Time time = timeQueue.dequeue();
            showCaseTime(time);
            stack.push(time);
        }
        while (!genreQueue.isEmpty()) {
            Genre genre = genreQueue.dequeue();
            showCaseGenres(genre);
            stack.push(genre);
        }
    }
}


