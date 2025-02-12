package cinema;

// importamos las librerias necesarias

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validate {
    // vali
    public static int valSize(String text) {
        int size = 0;
        Scanner read = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(text);
                size = read.nextInt();

                if (size < 1 ) {
                    System.out.println("Error: No se admiten valores menores a 1");
                } else if (size > 5) {
                    System.out.println("Error: No se admiten valores mayores a 5");
                } else {
                    return size;
                }
            } catch (Exception e) {
                System.out.println("Error: Verifique que esta escribiendo numeros y no caracteres");
                read.nextLine();
            }
        }
    }

    public static String validHour(String time, String text) {
        Scanner enter = new Scanner(System.in);
        while (true) {

            if (!time.matches("\\d{1,2}:\\d{2}")) {
                System.out.println("Error: Formato incorrecto, es H:MM");
                System.out.print(text);
                time = enter.nextLine();
                continue;
            }
            String[] parts = time.split(":");
            try {
                int hour = Integer.parseInt(parts[0]);
                int minutes = Integer.parseInt(parts[1]);
                if (hour < 0 || hour > 24 || minutes < 0 || minutes >= 60) {
                    System.out.println("Error: la hora tiene que estar entre 0 y 24 y los minutos entre 0 y 60");
                    System.out.print(text);
                    time = enter.nextLine();
                    continue;
                }
                String str = "%02d:%02d";
                return String.format(str, hour, minutes);

            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese numeros, no caracteres");

            }
        }

    }

    public static String validMovieName(String name, String text) {
        Scanner enter = new Scanner(System.in);
        while (true) {
            if (name.length() > 30) {
                System.out.println("Error: Nombre mayor a 30 caracteres, por favor abreviar el nombre");
                System.out.print(text);
                name = enter.nextLine();
            } else if (name.isEmpty()) {
                System.out.println("Error: Introduzca un nombre");
                System.out.print(text);
                name = enter.nextLine();
            } else {
                return name.trim();
            }
        }
    }

    public static int valIdExist(int num, String text) {
        Scanner read = new Scanner(System.in);
        int enter;
        while (true) {
            try {
                enter = read.nextInt() - 1;
                while (enter < 0 || enter > num - 1) {
                    System.out.println("¡ERROR! El ID no existe\n");
                    System.out.print(text);
                    enter = read.nextInt() - 1;
                }
                return enter;
            } catch (Exception e) {
                System.out.println("¡ERROR! Ingrese numeros, no caracteres\n");
                System.out.print(text);
                read.nextLine();
            }

        }
    }

    public static int validSeatQty(int num, String text) {
        Scanner read = new Scanner(System.in);
        int enter;
        while (true) {
            try {
                enter = read.nextInt();

                if (enter < 1) {
                    System.out.println("Introduzca un numero de entradas valido\n");
                    System.out.println(text);
                    enter = read.nextInt();
                }

                while (enter > num) {
                    System.out.println("Hay " + num + " asientos disponibles\n");
                    System.out.println(text);
                    enter = read.nextInt();
                }

                return enter;

            } catch (Exception e) {
                System.out.println("¡ERROR! Ingrese numeros, no caracteres\n");
                System.out.println(text);
                read.nextLine();
            }
        }
    }

    public static void checkSeatQty(int seats) {

    }

    public static int valInt(String text) {
        Scanner read = new Scanner(System.in);
        int option = 0;
        try {
            System.out.print(text);
            option = read.nextInt();
            if (option < 1 || option > 5) {
                option = 0;
            }
            return option;
        } catch (Exception e) {
            return option;
        }
    }

    public static void valArchive(String content, String route, boolean boo) {
        try (BufferedWriter addArchive = new BufferedWriter(new FileWriter(route, true))) {
            addArchive.write(content);
            if (boo) {
                addArchive.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public static boolean isMovieSoldOut(int[][][] info, int id){
        for (int j = 0; j < info[0].length; j++) {
            if(info[id][j][2] != 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isCinemaSoldOut(int[][][] info){
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info[0].length; j++) {
                if (info[i][j][2] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}