package cinema;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.File;

public class Process {
    public static void iniSeats(int[][][] matrix) {
        if (matrix != null) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j][2] = 20;
                    for (int k = 0; k < matrix[i][j].length - 1; k++) {
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
        Scanner enter = new Scanner(System.in);
        System.out.println("\n----------------------------------CATALOGO----------------------------------\n");
        if (name != null && showtime != null) {
            for (int i = 0; i < showtime.length; i++) {
                System.out.printf("%-25s\n", name[i]);
                for (int j = 0; j < showtime[0].length - 1; j++) {
                    System.out.printf("\t%-6s \t\t//\t", showtime[i][j]);
                }
                System.out.printf("\t%-6s\n", showtime[i][showtime[0].length - 1]);
                System.out.println();
            }
            System.out.print("\nPresione ENTER para continuar: ");
            enter.nextLine();
        }

    }

    public static void buyTicket(String[] movies, String[][] showtimes, int[][][] info) {
        int movieID, timeID, ticketID, seatQty;
        String text;
        Scanner enter = new Scanner(System.in);
        String status, movieName, showTime;
        int prize;

        if(movies != null && showtimes != null && info != null) {
            for (int i = 0; i < movies.length; i++) {
                System.out.println((i + 1) + ". " + movies[i]);
            }
            text = "Introduzca el ID de la pelicula a comprar: ";
            System.out.print(text);
            movieID = Validate.valIdExist(movies.length, text);
            while( Validate.isMovieSoldOut(info, movieID)){
                System.out.println("Disculpe la película está agotada, seleccione otra pelicula ");
                System.out.print(text);
                movieID = Validate.valIdExist(movies.length, text);
            }
            movieName = movies[movieID];

            for (int j = 0; j < showtimes[0].length; j++) {
                System.out.println((j + 1) + ". " + showtimes[movieID][j]);
            }
            text = "Introduzca el ID del horario a comprar: ";
            System.out.print(text);
            timeID = Validate.valIdExist(showtimes[0].length, text);
            while (info[movieID][timeID][2] == 0) {
                System.out.println("Disculpe, los asientos estan agotados, seleccione otro horario");
                System.out.println(text);
                timeID = Validate.valIdExist(showtimes[0].length, text);
            }
            showTime = showtimes[movieID][timeID];

            text = "Seleccione la cantidad de entradas a comprar\nCantidad de entradas disponibles: " + info[movieID][timeID][2];
            System.out.println(text);
            seatQty = Validate.validSeatQty(info[movieID][timeID][2], text);
            info[movieID][timeID][2] -= seatQty;

            text = "Seleccione tipo de entrada a comprar:\n1. Entrada simple (3$)\n2. Entrada con Snack (6$)";
            System.out.println(text);
            ticketID = Validate.valIdExist(info[0][0].length-1, text);

            if (ticketID == 1) {
                info[movieID][timeID][0] += seatQty;
                status = "Entrada con snack";
                prize = seatQty*6;
            } else {
                info[movieID][timeID][1] += seatQty;
                status = "Entrada simple";
                prize = seatQty*3;
            }
            System.out.println("---------------------------------Recibo de venta---------------------------------");
            System.out.printf("%-50s %30s\n","Pelicula : ",movieName);
            System.out.printf("%-50s %30s\n","Horario : ",showTime);
            System.out.printf("%-50s %30s\n","Tipo de entrada comprada : ",status);
            System.out.printf("%-50s %30d\n","Cantidad de entradas adquiridas : ",seatQty);
            System.out.printf("%-50s %30d$\n","Monto total : ",prize);

        }
    }

    public static void showReport(String[] movie, String[][] showTimes, String route, int[][][] info) {
        String text = "";
        int aux = 0, plus = 0;
        File report = new File(route);
        if(report.exists()) {
            boolean delete = report.delete(); //hola
        }
        Validate.valArchive("----------------------------Reporte de ventas----------------------------", route ,true );
        if (showTimes != null && movie != null ){
            for (int i = 0; i < showTimes.length; i++) {
                text = "Opción " + (i + 1) + ":";
                Validate.valArchive(text, route, true);
                text = "Nombre:                   |   Ventas n   |   Ventas s   |    TOTAL $";
                Validate.valArchive(text, route, true);
                text = String.format("%-7s", movie[i]);
                Validate.valArchive(text, route, true);
                for (int j = 0; j < showTimes[0].length; j++) {
                    aux = (info[i][j][0])*3 + (info[i][j][1])*6;
                    plus += aux;
                    text = String.format("%-30s%4d$        \t%4d$       \t%4d$", showTimes[i][j], info[i][j][0]*3, info[i][j][1]*6, aux);
                    Validate.valArchive(text, route, true);
                }
                text = String.format("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t%4d$", plus);
                Validate.valArchive(text, route, true);
                text = "";
                Validate.valArchive(text, route, true);
                plus = 0;
            }
        }
    }

    public static void showMenu(String[] name, String[][] times, int[][][] matrix, String route) {
        Scanner enter = new Scanner(System.in);
        String text = "";
        int option, band = 0;
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
                    if ( Validate.isCinemaSoldOut(matrix)){
                        System.out.println("Disculpe, todas las películas están agotadas. ¡Vuelva otro día!");
                        System.out.print("\nPresione ENTER para continuar: ");
                        enter.nextLine();
                    }
                    else {
                        buyTicket(name, times, matrix);
                        System.out.println("\n¡Gracias por comprar en CineUjap!");
                        System.out.print("\nPresione ENTER para continuar: ");
                        enter.nextLine();
                    }
                    break;
                case 3:
                    iniMovie(name);
                    iniShowtime(times);
                    iniSeats(matrix);
                    attachData(times, name);
                    break;
                case 4:
                    if (band == 0) {
                        showReport(name, times, route, matrix);
                        band = 1;
                    }
                    System.out.println("El informe ya fue impreso, cierre el programa para verlo");
                    System.out.print("\nPresione ENTER para continuar: ");
                    enter.nextLine();
                    break;
                case 5:
                    System.out.println("¡Gracias por elegir CineUjap, vuelva pronto!");
                    break;
                default:
                    System.out.println("\n¡ERROR! Elija una opción valida");
                    System.out.print("Presione ENTER para continuar: ");
                    enter.nextLine();
            }
        } while (option != 5);
    }
}