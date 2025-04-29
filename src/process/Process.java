package process;

import validateItem.Validate;
import java.io.IOException;
import java.util.Scanner;

public class Process {

    public static void iniSeats(int[][][] info) {
        if (info != null) {
            for (int i = 0; i < info.length; i++) {
                for (int j = 0; j < info[i].length; j++) {
                    info[i][j][2] = 20;
                    for (int k = 0; k < info[i][j].length - 1; k++) {
                        info[i][j][k] = 0;
                    }
                }
            }
        }
    }

    public static void iniShowtime(String[][] times) {
        if (times != null) {
            for (int i = 0; i < times.length; i++) {
                for (int j = 0; j < times[i].length; j++) {
                    times[i][j] = "";
                }
            }
        }
    }

    public static void iniMovie(String[] names) {
        if (names != null) {
            for (int i = 0; i < names.length; i++) {
                names[i] = "";
            }
        }
    }

    public static void inigenres(String[] genres) {
        if (genres != null) {
            for (int i = 0; i < genres.length; i++) {
                genres[i] = "";
            }
        }
    }

    public static void inifinShowtime(String[][] finTimes) {
        if (finTimes != null) {
            for (int i = 0; i < finTimes.length; i++) {
                for (int j = 0; j < finTimes[i].length; j++) {
                    finTimes[i][j] = "";
                }
            }
        }
    }

    public static void attachData(String[][] times, String[] names, String[] genres, String[][] finShowTimes, Scanner key) {
        String text, dure = "";
        if (times != null && finShowTimes != null && names != null && genres != null) {
            for (int i = 0; i < times.length; i++) {
                text = "\nIntroduzca el nombre de la pelicula #" + (i + 1) + ": ";
                System.out.print(text);
                names[i] = Validate.validMovieName(text, key);
                text = "\nIntroduzca el genero de la pelicula #" + (i + 1) + ": ";
                System.out.print(text);
                genres[i] = Validate.validGenreName(text, key);
                text = "\nIntroduzca la duracion de la pelicula #" + (i + 1) + ": ";
                System.out.print(text);
                dure = Validate.validfinHour(text, key);
                for (int j = 0; j < times[0].length; j++) {
                    text = "Introduzca el horario #" + (j + 1) + " de la pelicula " + names[i] + " (formato de 24 horas): ";
                    System.out.print(text);
                    times[i][j] = Validate.validHour(text, key);
                    finShowTimes[i][j] = Validate.calcHour(dure, times[i][j]);
                }
            }
        }
    }

    public static void showCase(String[] names, String[][] times, String[] genres, String[][] finShowTimes, Scanner key) {
        System.out.println("\n-----------------------------------------CATALOGO-----------------------------------------\n");
        if (names != null && times != null && genres != null && finShowTimes != null) {
            for (int i = 0; i < times.length; i++) {
                System.out.printf("%-25s\n", names[i]);
                System.out.printf("Genero: %-25s\n", genres[i]);
                for (int j = 0; j < times[0].length - 1; j++) {
                    System.out.printf("\t%-5s - %-5s \t\t//\t", times[i][j], finShowTimes[i][j]);
                }
                System.out.printf("\t%-5s - %-5s\n", times[i][times[0].length - 1], finShowTimes[i][finShowTimes[0].length - 1]);
                System.out.println();
            }
            System.out.print("\nPresione ENTER para continuar: ");
            key.nextLine();
        }
    }

    public static void buyTicket(String[] movies, String[][] times, int[][][] info, Scanner key) {
        int movieID, timeID = 0;
        String text, movieName, showTime = "";
        if (movies != null && times != null && info != null) {
            for (int i = 0; i < movies.length; i++) {
                System.out.println((i + 1) + ". " + movies[i]);
            }
            text = "\nIntroduzca el ID de la pelicula a comprar (0 para cancelar): ";
            System.out.print(text);
            movieID = Validate.valIdExist(movies.length, text, key);
            if (movieID == -1) return;

            while (Validate.isMovieSoldOut(info, movieID)) {
                System.out.println("Disculpe la película está agotada, seleccione otra pelicula.");
                System.out.print(text);
                movieID = Validate.valIdExist(movies.length, text, key);
            }
            movieName = movies[movieID];

            for (int j = 0; j < times[0].length; j++) {
                System.out.println((j + 1) + ". " + times[movieID][j]);
            }
            text = "\nIntroduzca el ID del horario a comprar (0 para cancelar): ";
            System.out.print(text);
            timeID = Validate.valIdExist(times[0].length, text, key);
            if (timeID == -1) return;
            while (info[movieID][timeID][2] == 0) {
                System.out.println("Disculpe, los asientos estan agotados, seleccione otro horario.");
                System.out.println(text);
                timeID = Validate.valIdExist(times[0].length, text, key);
            }
            showTime = times[movieID][timeID];
            printTicket(info, movieID, timeID, movieName, showTime, key);
            key.nextLine();
        }
    }

    private static void printTicket(int[][][] info, int movieID, int timeID, String movieName, String showTime, Scanner key) {
        if (info != null) {
            String text, status = "";
            int seatQty, ticketID, price = 0;
            text = "\nSeleccione la cantidad de entradas a comprar (0 para cancelar).\nCantidad de entradas disponibles: " + info[movieID][timeID][2] + "\n";

            seatQty = Validate.validSeatQtypart1(info[movieID][timeID][2], text, key);
            if (seatQty == 0) return;

            text = "\nSeleccione tipo de entrada a comprar (0 para cancelar):\n1. Entrada simple (3$)\n2. Entrada con Snack (6$)\n";
            System.out.print(text);
            ticketID = Validate.valIdExist(info[0][0].length - 1, text, key);
            if (ticketID == -1) return;

            if (ticketID == 0) {
                info[movieID][timeID][0] += seatQty;
                status = "Entrada simple";
                price = seatQty * 3;
            } else {
                info[movieID][timeID][1] += seatQty;
                status = "Entrada con snack";
                price = seatQty * 6;
            }
            info[movieID][timeID][2] -= seatQty;
            System.out.println("---------------------------------Recibo de Compra---------------------------------");
            System.out.printf("%-30s %50s\n", "Pelicula : ", movieName);
            System.out.printf("%-50s %30s\n", "Horario : ", showTime);
            System.out.printf("%-50s %30s\n", "Tipo de entrada comprada : ", status);
            System.out.printf("%-50s %30d\n", "Cantidad de entradas adquiridas : ", seatQty);
            System.out.printf("%-50s %29d$\n", "Monto total : ", price);
            System.out.printf("\n%57s", "¡Gracias por comprar en CineUjap!");
            System.out.print("\n\nPresione ENTER para continuar: ");
        }
    }


    public static void showMenu(String[] names, String[][] times, int[][][] info, String[] genres, String[][] finShowTimes, Scanner key) throws IOException {
        String text = "";
        int option;
        System.out.println("\n\n¡Bienvenido a CineUjap!");
        if (names != null && times != null && info != null && genres != null) {
            do {
                System.out.println("\nMenu de Opciones");
                System.out.println("1. Mostrar Cartelera");
                System.out.println("2. Comprar Entradas");
                System.out.println("\n¡ATENCION SOLO PERSONAL AUTORIZADO!");
                System.out.println("3. Cambiar Cartelera");
                System.out.println("4. Cerrar Programa");
                text = "\nSeleccione una opción: ";
                option = Validate.valOpt(text, key);
                if (option == 1) {
                    showCase(names, times, genres, finShowTimes, key);
                } else if (option == 2) {
                    if (Validate.isCinemaSoldOut(info)) {
                        System.out.println("Disculpe, todas las películas están agotadas. ¡Vuelva otro día!");
                        System.out.print("\nPresione ENTER para continuar: ");
                        key.nextLine();
                    } else {
                        buyTicket(names, times, info, key);
                    }
                } else if (option == 3) {
                    iniMovie(names);
                    iniShowtime(times);
                    iniSeats(info);
                    attachData(times, names, genres, finShowTimes, key);
                } else if (option == 4) {
                    System.out.println("¡Gracias por elegir CineUjap, vuelva pronto!");
                } else {
                    System.out.println("\n¡ERROR! Elija una opción valida");
                    System.out.print("Presione ENTER para continuar: ");
                    key.nextLine();
                }
            } while (option != 4);
        }
    }
}