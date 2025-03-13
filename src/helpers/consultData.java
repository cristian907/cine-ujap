package helpers;

import java.util.Scanner;

public class consultData {

    public static int convertTime(String text) {
        String[] time = text.split(":");
        int h = Integer.parseInt(time[0]) * 60;
        int m = Integer.parseInt(time[1]);
        return h + m;
    }

    public static boolean isMovieInRange(String[] line, int min, int max) {
        for (int i = 1; i < line.length; i++) {
            int t = convertTime(line[i]);
            if (t >= min && t <= max) {
                return true;
            }
        }
        return false;
    }

    public static String getTimes(String text, String[] line, int min, int max) {
        for (int i = 1; i < line.length; i++) {
            int t = convertTime(line[i]);
            if (t >= min && t <= max) {
                text = text + " " + line[i];
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

        if (value.equals(name)) {
            return line;
        }

        return consultName(arch, name);

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
        return consultTime(arch, min, max, text);
    }

    public static void showCaseMovie(String[] name) {
        System.out.print(name[0] + " - ");
        for (int i = 1; i < name.length; i++) {
            System.out.print(name[i] + " ");
        }
        System.out.println();
    }

    public static void showCaseTime(String text) {
        String[] line = text.split("/");
        System.out.println("Peliculas disponibles en este horario");
        for (int i = 0; i < line.length; i++) {
            System.out.println(line[i]);
        }
        line = null;
    }
}


