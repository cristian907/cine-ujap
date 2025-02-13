package cinema;

// importamos las librerias necesarias

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Validate {
    //metodo para validar el tamaño del vector
    public static int valSize(String text, Scanner key) {
        int size = 0;
        while (true) {
            try {
                System.out.print(text);
                size = Integer.parseInt(key.nextLine());

                if (size < 1) {
                    System.out.println("Error: No se admiten valores menores a 1.");
                } else if (size > 5) {
                    System.out.println("Error: No se admiten valores mayores a 5.");
                } else {
                    return size;
                }
            } catch (Exception e) {
                System.out.println("Error: Verifique que esta escribiendo numeros.");
            }
        }
    }

    // metodo para validar el horario de la pelicula
    public static String validHour(String time, String text, Scanner key) {
        while (true) {

            if (!time.matches("\\d{1,2}:\\d{2}")) {
                System.out.println("Error: Formato incorrecto, es H:MM");
                System.out.print("\n"+text);
                time = key.nextLine();
                continue;
            }
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            if (hour < 0 || hour > 23 || minutes < 0 || minutes >= 59) {
                System.out.println("Error: la hora tiene que estar entre 0 y 23 y los minutos entre 0 y 59.");
                System.out.print("\n"+text);
                time = key.nextLine();
                continue;
            }
            String str = "%02d:%02d";
            parts = null;
            return String.format(str, hour, minutes);
        }
    }

    // metodo para validar el nombre de la pelicula
    public static String validMovieName(String name, String text, Scanner key) {
        while (true) {
            if (name.length() > 50) {
                System.out.println("Error: Nombre mayor a 50 caracteres, por favor abreviar el nombre.");
                System.out.print(text);
                name = key.nextLine();
            } else if (name.trim().isEmpty()) {
                System.out.println("Error: Introduzca un nombre.");
                System.out.print(text);
                name = key.nextLine();
            } else {
                return name.trim();
            }
        }
    }

    // metodo para validar la existencia el ID introducido
    public static int valIdExist(int num, String text, Scanner key) {
        int enter = 0;
        while (true) {
            try {
                enter = Integer.parseInt(key.nextLine()) - 1;
                while (enter < -1 || enter > num - 1) {
                    System.out.println("¡ERROR! El ID no existe.");
                    System.out.print(text);
                    enter = Integer.parseInt(key.nextLine()) - 1;
                }
                return enter;
            } catch (Exception e) {
                System.out.println("¡ERROR! Ingrese un ID valido.");
                System.out.print(text);
            }
        }
    }

    // metodo para validar el ID de las entradas
    public static int validSeatQty(int num, String text, Scanner key) {
        int enter = 0;
        while (true) {
            try {
                enter = Integer.parseInt(key.nextLine());

                if (enter < 0) {
                    System.out.println("Introduzca un numero de entradas valido.");
                    System.out.println(text);
                    enter = Integer.parseInt(key.nextLine());
                }

                while (enter > num) {
                    System.out.println("Disculpe, solo hay " + num + " asientos disponibles.");
                    System.out.println(text);
                    enter = Integer.parseInt(key.nextLine());
                }
                return enter;

            } catch (Exception e) {
                System.out.println("¡ERROR! Ingrese numeros, no caracteres.");
                System.out.println(text);
            }
        }
    }

    // validar el ID del menu
    public static int valOpt(String text, Scanner key) {
        int option = 0;
        try {
            System.out.print(text);
            option = Integer.parseInt(key.nextLine());
            if (option < 1 || option > 5) {
                option = 0;
            }
            return option;
        } catch (Exception e) {
            return option;
        }
    }

    // metodo para validar la escritura del archivo
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

    // metodo para validar si la pelicula esta agotada
    public static boolean isMovieSoldOut(int[][][] info, int id) {
        for (int j = 0; j < info[0].length; j++) {
            if (info[id][j][2] != 0) {
                return false;
            }
        }
        return true;
    }

    // metodo para validar si el cine esta agotado
    public static boolean isCinemaSoldOut(int[][][] info) {
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