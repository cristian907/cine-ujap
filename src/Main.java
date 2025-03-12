import validateItem.Validate;
import process.processMain;

public class Main {
    public static void main(String[] args) {
        String text = "";
        int[][][] movieInfo;
        String[][] showtimes;
        String[] movies;
        int movie, times = 0;
        String route = System.getProperty("user.dir")+"/src/cinema/Report.txt";



        // Peticion de longitud de los arreglos

        text = "\nIntroduzca la cantidad de peliculas para el día de hoy: ";
        movie = Validate.valSize(text);

        text = "\nIntroduzca la cantidad de horarios por pelicula: ";
        times = Validate.valSize(text);


        // Instanciacion de Arreglos
        movies = new String[movie];
        showtimes = new String[movie][times];
        movieInfo = new int[movie][times][3];

        //desarrollo
        processMain.process(movieInfo,showtimes,movies);

        movieInfo = null;
        showtimes = null;
        movies = null;
    }
}
