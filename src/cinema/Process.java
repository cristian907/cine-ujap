package cinema;

import java.util.Scanner;

public class Process {
    public static void iniSeats(int[][][] matrix) {
        if (matrix != null) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    for (int k = 0; k < matrix[i][j].length; k++) {
                        matrix[i][j][k] = 0;
                    }
                }
            }
        }
    }

    public static void iniShowtime(String[][] showtime) {
        if (showtime != null) {
            for (int i = 0; i < showtime.length; i++) {
                for (int j = 0; j < showtime[i].length; j++) {
                    showtime[i][j] = "";
                }
            }
        }
    }

    public static void iniMovie(String[] name) {
        if (name != null) {
            for (int i = 0; i < name.length; i++) {
                name[i] = "";
            }
        }
    }

    public static void attachData(String[][] showtime, String[] name) {
        String text = "";
//        ***CAMBIAR ENTRADA DE DATOS A VALIDATE***
        Scanner enter = new Scanner(System.in);
            for (int i = 0; i < showtime.length; i++) {
                text = "\nIntroduzca el nombre de la pelicula #" + (i + 1) + ": ";
                System.out.print(text);
                name[i] = enter.next();
//                ***TEMPORAL - ENTRADA DE DATOS POR VALIDATE
                for (int j = 0; j < showtime[0].length; j++) {
                    text = "Introduzca el horario #" + (j + 1) + " de la pelicula " + name[i] + " (formato de 24 horas): ";
                    System.out.print(text);
                    showtime[i][j] = Validate.validHour(enter.next(), text);
                }
            }


    }

    public static void showCase(String[] name, String[][] showtime) {
        System.out.println("\tCATALOGO\n");
        if (name != null && showtime != null) {
            for (int i = 0; i < showtime.length; i++) {
                System.out.printf("%-25s\n", name[i]);
                for (int j = 0; j < showtime[0].length - 1; j++) {
                    System.out.printf("%-6s  //   ", showtime[i][j]);
                }
                System.out.printf("%-6s", showtime[i][showtime[0].length - 1]);
                System.out.println("\n");
            }

        }

    }

    public static void buyTicket(String[] movies, String[][] showtimes, int[][][] info) {
        int movieID, timeID;
        String text;
        Scanner enter = new Scanner(System.in);

            for (int i = 0; i < movies.length; i++) {
                System.out.println((i + 1) + ". " + movies[i]);
            }
            text = "Introduzca el ID de la pelicula a comprar: ";
            System.out.print(text);
            movieID = enter.nextInt()-1;

            for (int j = 0; j < showtimes[0].length; j++) {
                System.out.println((j + 1) + ". " + showtimes[movieID][j]);
            }
            text = "Introduzca el ID del horario a comprar: ";
            System.out.print(text);
            timeID = enter.nextInt()-1;

    }
}
