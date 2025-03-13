package composables;

import validateItem.Validate;

import java.io.File;

public class storeArchive {
    public static void storeItemMovie(String[] movie, String[][] showTime, int[][][] info, String root) {
        String text = "";
        String route = root + "storeMovieSchedule.txt";
        File report = new File(route);
        if (report.exists()) report.delete();
        if (movie != null && showTime != null) {
            for (int i = 0; i < showTime.length; i++) {

                text = String.valueOf(movie[i]) + " ";
                Validate.valArchive(text, route, false);
                for (int j = 0; j < showTime[i].length - 1; j++) {
                    text = String.valueOf(showTime[i][j]) + " ";

                    Validate.valArchive(text, route, false);
                }
                text = String.valueOf(showTime[i][showTime[0].length - 1]);
                Validate.valArchive(text, route, i < showTime.length - 1);
            }
        }
    }

    public static void storeName(String[] movie, String root) {
        String text = "";
        String route = root + "Movies.txt";
        File report = new File(route);
        if (report.exists()) report.delete();
        if (movie != null) {
            for (int i = 0; i < movie.length; i++) {
                text = String.valueOf(movie[i]) + " ";
                Validate.valArchive(text, route, false);
            }
            Validate.valArchive("", route, false);
        }
    }

    public static void storeHour(String[][] showTime, String root) {
        String text = "";
        String route = root + "Times.txt";
        File report = new File(route);
        if (report.exists()) report.delete();
        if (showTime != null) {
            for (int i = 0; i < showTime.length; i++) {
                for (int j = 0; j < showTime[0].length; j++) {
                    text = String.valueOf(showTime[i][j]) + " ";
                    Validate.valArchive(text, route, false);
                }
                Validate.valArchive("\n", route, false);
            }
        }
    }

    public static void storeShowReport(String[] movie, String[][] showTimes, int[][][] info,String root) {
        String text = "";
        String route = root + "storeReport.txt";
        int aux, plus = 0, plusTotal = 0;
        File report = new File(route);
        if (report.exists()) report.delete();
        Validate.valArchive("---------------------Reporte de ventas--------------------", route, true);
        if (showTimes != null && movie != null) {
            for (int i = 0; i < showTimes.length; i++) {
                text = "Película " + (i + 1) + ":";
                Validate.valArchive(text, route, true);
                text = String.format("Nombre: %7s", movie[i]);
                Validate.valArchive(text, route, true);
                text = "Hora    |   Ventas n   |    Ventas s   |     TOTAL $";
                Validate.valArchive(text, route, true);
                for (int j = 0; j < showTimes[0].length; j++) {
                    aux = (info[i][j][0]) * 3 + (info[i][j][1]) * 6;
                    plus += aux;
                    plusTotal += aux;
                    text = String.format("%5s       %4d$           %4d$           %4d$", showTimes[i][j], info[i][j][0] * 3, info[i][j][1] * 6, aux);
                    Validate.valArchive(text, route, true);
                }
                text = String.format("                                            %4d$", plus);
                Validate.valArchive(text, route, true);
                text = "";
                Validate.valArchive(text, route, true);
                plus = 0;
            }
            text = "El total de ventas del dia fue de: " + plusTotal + "$";
            Validate.valArchive(text, route, true);
        }
    }

}