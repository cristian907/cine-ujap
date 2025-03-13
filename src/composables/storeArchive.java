package composables;

import validateItem.Validate;

public class storeArchive {
    public static void storeItemMovie(String movie[], String showTime[][], int nfo[][][], String root) {
        String text = "";
        String route = root + "storeMovieSchedule.txt";

        if (movie != null && showTime != null) {
            for (int i = 0; i < showTime.length; i++) {

                text = String.valueOf(movie[i]) + " ";
                Validate.valArchive(text, route, false);
                for (int j = 0; j < showTime[i].length; j++) {
                    text = String.valueOf(showTime[i][j]) + " ";

                    Validate.valArchive(text, route, false);
                }
                text = String.valueOf(showTime[i][showTime[0].length - 1]);
                Validate.valArchive(text, route, i < showTime.length - 1);
            }
        }
    }
    public static void storeName(String movie[],String root){
        String text = "";
        String route = root + "Movies.txt";
        if (movie != null ) {
            for (int i = 0; i < movie.length; i++) {
                text = String.valueOf(movie[i])+" ";
                Validate.valArchive(text, route, false);
            }
            Validate.valArchive("\n", route, false);
        }
    }
    public static void storeHour(String showTime[][],String root){
        String text = "";
        String route = root + "Times.txt";
        if (showTime != null ) {
            for (int i = 0; i < showTime.length; i++) {
                for (int j = 0; j < showTime[0].length; j++) {
                    text = String.valueOf(showTime[i][j])+" ";
                    Validate.valArchive(text, route, false);
                }
                Validate.valArchive("\n", route, false);
            }
        }
    }

}