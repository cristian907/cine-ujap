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
}