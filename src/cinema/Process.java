package cinema;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Process {
    public static void iniSeats(int[][][] matrix) {
        if (matrix != null) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j][0] = 20;
                    for (int k = 0; k < matrix[i][j].length - 1; k++) {
                        matrix[i][j][k + 1] = 0;
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
        Scanner enter = new Scanner(System.in);
        for (int i = 0; i < showtime.length; i++) {
            text = "Introduzca el nombre de la pelicula #" + (i + 1) + ": ";
            System.out.print(text);
            name[i] = Validate.validMovieName(enter.nextLine(), text);
            for (int j = 0; j < showtime[0].length; j++) {
                text = "Introduzca el horario #" + (j + 1) + " de la pelicula " + name[i] + " (formato de 24 horas): ";
                System.out.print(text);
                showtime[i][j] = Validate.validHour(enter.nextLine(), text);
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
                System.out.println();
            }

        }

    }

    public static void buyTicket(String[] movies, String[][] showtimes, int[][][] info) {
        int movieID, timeID, ticketID, seatQty;
        String text;
        Scanner enter = new Scanner(System.in);

        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i]);
        }
        text = "Introduzca el ID de la pelicula a comprar: ";
        System.out.print(text);
        movieID = Validate.valIdExist(enter.nextInt() - 1, movies.length, text);

        for (int j = 0; j < showtimes[0].length; j++) {
            System.out.println((j + 1) + ". " + showtimes[movieID][j]);
        }
        text = "Introduzca el ID del horario a comprar: ";
        System.out.print(text);
        timeID = Validate.valIdExist(enter.nextInt() - 1, showtimes[0].length, text);
//        timeID = enter.nextInt() - 1;

        text = "Seleccione la cantidad de entradas a comprar\nCantidad de entradas dispoibles: " + info[movieID][timeID][0];
        System.out.println(text);
//        seatQty = enter.nextInt();

        info[movieID][timeID][0] -= seatQty;

        text = "Seleccione tipo de entrada a comprar:\n1. Entrada simple\n2. Entrada con Snack";
        System.out.println(text);
        ticketID = enter.nextInt();

        if (ticketID == 1) {
            info[movieID][timeID][1] += seatQty;
        } else {
            info[movieID][timeID][2] += seatQty;
        }

    }

    public static void showMenu(String[] name, String[][] times, int[][][] matrix) {
        Scanner enter = new Scanner(System.in);
        String text = "";
        int option;
        System.out.println("\n\n¡Bienvenido a CineUjap!");
        do {
            System.out.println("\nMenu de Opciones");
            System.out.println("1. Mostrar Cartelera");
            System.out.println("2. Comprar Entradas");
            System.out.println("\n¡ATENCION SOLO PERSONAL AUTORIZADO!");
            System.out.println("3. Cambiar Cartelera");
            System.out.println("4. Escribir reporte de ventas");
            System.out.println("5. Cerrar Programa");
            System.out.print("\nSeleccione una opción: ");
            option = Validate.valInt(text);
            switch (option) {
                case 1:
                    showCase(name, times);
                    break;
                case 2:
                    buyTicket(name, times, matrix);
                    break;
                case 3:
                    iniMovie(name);
                    iniShowtime(times);
                    iniSeats(matrix);
                    attachData(times, name);
                    break;
                case 4:
                    System.out.println("falta reporte de ventas");
                    break;
                case 5:
                    System.out.println("Gracias por elegir CineUjap, vuelva pronto");
                    break;
                default:
                    System.out.println("\n¡ERROR! Elija una opción valida");
                    System.out.println("Presione ENTER para continuar: ");
                    enter.nextLine();
            }
        } while (option != 5);
    }
}