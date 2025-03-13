package composables;

import validateItem.Validate;

public class storeArchive {
    public static void storeItemMovie(String movie[], String showTime[][], int nfo[][][], String root) {
        String text = "";
        String route = root + "resultado.txt";

        if (movie != null && showTime != null) {
            for (int i = 0; i < showTime.length; i++) {
                text = movie[i] + " ";
                Validate.valArchive(text, route, false);

                for (int j = 0; j < showTime[i].length; j++) {
                    text = showTime[i][j] + " ";
                    Validate.valArchive(text, route, false);
                }
                if (i < showTime.length - 1) {
                    Validate.valArchive("", route, true);
                }
            }
        }
    }
}
