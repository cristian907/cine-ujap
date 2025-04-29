package composables;

import Structure.Stack;
import repositories.ArchiveUtil;
import repositories.Genre;
import repositories.Movie;
import repositories.Time;

import java.io.IOException;
import java.time.LocalDateTime;

public class StoreArchive {
    public static int randomSerial = (int) (Math.random() * 1000) + 1;

    public static void storeItemMovie(String[] movie, String[][] showTime, String[][] finalHour, ArchiveUtil archive, boolean checking) throws IOException {
        String text = "";
        int cont = 0;
        LocalDateTime time = LocalDateTime.now();
        String finalTime = time.toString().replace(":", "-");
        String routeName;
        if (!checking) {
            routeName = "MoviesWithHours_" + finalTime + "_serial" + randomSerial;
        } else {
            routeName = "MoviesWithHours";
        }
        if (movie != null && showTime != null) {
            for (int i = 0; i < showTime.length; i++) {
                text = movie[i] + " ";
                archive.setCreateArchive(text, routeName, false);
                for (int j = 0; j < showTime[i].length - 1; j++) {
                    text = showTime[i][j] + "-" + finalHour[i][j] + " ";
                    archive.setCreateArchive(text, routeName, false);
                }
                cont++;
                text = (showTime[i][showTime[0].length - 1]) + "-" + (finalHour[i][finalHour[0].length - 1]);
                if (cont < movie.length) {
                    archive.setCreateArchive(text, routeName, true);
                } else {
                    archive.setCreateArchive(text, routeName, false);
                }
            }
            time = null;
        }
    }

    public static void storeItemMovieOnlyHour(String[] movie, String[][] showTime, ArchiveUtil archive, boolean checking) throws IOException {
        String text = "";
        int cont = 0;
        LocalDateTime time = LocalDateTime.now();
        String finalTime = time.toString().replace(":", "-");
        String routeName;
        if (!checking) {
            routeName = "MoviesWithOnlyHour_" + finalTime + "_serial" + randomSerial;
        } else {
            routeName = "MoviesWithOnlyHour";
        }
        if (movie != null && showTime != null) {
            for (int i = 0; i < showTime.length; i++) {
                text = movie[i] + " ";
                archive.setCreateArchive(text, routeName, false);
                for (int j = 0; j < showTime[i].length - 1; j++) {
                    text = showTime[i][j] + " ";
                    archive.setCreateArchive(text, routeName, false);
                }
                cont++;
                text = String.valueOf(showTime[i][showTime[0].length - 1]);
                if (cont < movie.length) {
                    archive.setCreateArchive(text, routeName, true);
                } else {
                    archive.setCreateArchive(text, routeName, false);
                }
            }
            time = null;
        }
    }

    public static void storeNameAndGenre(String[] movie, String[] genre, ArchiveUtil archive, boolean checking) {
        String text = "";
        int cont = 0;
        LocalDateTime time = LocalDateTime.now();
        String finalTime = time.toString().replace(":", "-");
        String routeName;
        if (!checking) {
            routeName = "MovieAndGenreStore_" + finalTime + "_serial" + randomSerial;
        } else {
            routeName = "MovieAndGenreStore";
        }
        if (movie != null && genre != null) {
            for (int i = 0; i < movie.length; i++) {
                text = movie[i] + " " + genre[i];
                if (cont < movie.length - 1) {
                    archive.setCreateArchive(text, routeName, true);
                } else {
                    archive.setCreateArchive(text, routeName, false);
                }
                cont++;
            }
            time = null;
        }
    }


    public static void storeShowReport(String[] movie, String[][] showTimes, int[][][] info, ArchiveUtil archive, boolean checking) {
        String text = "";
        int aux, plus = 0, plusTotal = 0;
        LocalDateTime time = LocalDateTime.now();
        String finalTime = time.toString().replace(":", "-");
        String routeName;
        if (!checking) {
            routeName = "ReportStore_" + finalTime + "_serial" + randomSerial;
        } else {
            routeName = "ReportStore";
        }
        archive.setCreateArchive("---------------------Reporte de ventas--------------------", routeName, true);

        if (showTimes != null && movie != null && info != null) {
            for (int i = 0; i < showTimes.length; i++) {
                text = "Película " + (i + 1) + ":";
                archive.setCreateArchive(text, routeName, true);
                text = String.format("Nombre: %7s", movie[i]);
                archive.setCreateArchive(text, routeName, true);
                text = "Hora    |   Ventas n   |    Ventas s   |     TOTAL $";
                archive.setCreateArchive(text, routeName, true);
                for (int j = 0; j < showTimes[0].length; j++) {
                    aux = (info[i][j][0]) * 3 + (info[i][j][1]) * 6;
                    plus += aux;
                    plusTotal += aux;
                    text = String.format("%5s       %4d$           %4d$           %4d$", showTimes[i][j], info[i][j][0] * 3, info[i][j][1] * 6, aux);
                    archive.setCreateArchive(text, routeName, true);
                }
                text = String.format("                                            %4d$", plus);
                archive.setCreateArchive(text, routeName, true);
                plus = 0;
            }
            text = "El total de ventas del dia fue de: " + plusTotal + "$";
            archive.setCreateArchive(text, routeName, true);
        }
        time = null;
    }

    public static void StackStore(Stack stack, ArchiveUtil archive) {
        LocalDateTime time = LocalDateTime.now();
        String finalTime = time.toString().replace(":", "-");
        String routeName;
        String text = "";
        Object data;
        routeName = "StackStore_" + finalTime + "_serial" + randomSerial;

        while (!stack.isEmpty()) {
            data = stack.pop();
            if (data != null) {

                if (data instanceof Movie) {
                    Movie item = (Movie) data;
                    text = "Pelicula: " + item.getmovieName() + "\n" + "Horario: ";
                    for (int i = 1; i < item.getMovieTimes().length; i++) {
                        text += item.getMovieTimes()[i] + " ";
                    }
                } else if (data instanceof Time) {
                    Time item = (Time) data;
                    text = "Rango: " + item.getIniHour() + "-" + item.getFinHour() + "\n";
                    String[] line = item.getMovies().split("/");
                    for (int i = 0; i < line.length; i++) {
                        text += (line[i]) + "\n";
                    }
                } else if (data instanceof Genre) {
                    Genre item = (Genre) data;
                    text = "Genero: " + item.getMovieGenre() + "\n";
                    String[] line = item.getMovies().split("/");
                    for (int i = 0; i < line.length; i++) {
                        text += (line[i]) + " ";
                    }
                }
                archive.setCreateArchive(text, routeName, true);
                text = "*-----------------------------------------------------------------------------------------*";
                archive.setCreateArchive(text, routeName, true);

            }


        }
    }
}