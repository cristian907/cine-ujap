package validateItem;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Validate {

    public static boolean fileExists() throws IOException {
        String data = Paths.get("").toRealPath().toString()+"/src/storage/MovieSchedule.txt";
        String movies = Paths.get("").toRealPath().toString()+"/src/storage/Movies.txt";
        String times = Paths.get("").toRealPath().toString()+"/src/storage/Times.txt";
        File fileA = new File(data);
        File fileB = new File(movies);
        File fileC = new File(times);

        if (!fileA.exists() || !fileB.exists() || !fileC.exists()) {
            System.out.println("No existen los archivos, se creara el catalogo manualmente");
            return false;
        }
        fileA = null;
        fileB = null;
        fileC = null;
        return true;
    }

    public static Scanner readFile(String route) {

        if (route == null || route.trim().isEmpty()) {
            System.out.println("Error: Ruta Invalida");
            return null;
        }

        File file = new File(route);
        if (!file.isFile()) {
            System.out.println("La ruta especificada no es un archivo: " + route);
            return null;
        }

        try {
            return new Scanner(file);

        } catch (IOException e) {
            System.out.println("Error al abrir o leer el archivo");
        }
        file = null;
        return null;
    }

    // Metodo para validar el tamaño del vector
    public static int valSize(String text, Scanner key) {
        try {
            System.out.print(text);
            int size = Integer.parseInt(key.nextLine());

            if (size < 1) {
                System.out.println("Error: No se admiten valores menores a 1.");
                return valSize(text, key);
            } else if (size > 5) {
                System.out.println("Error: No se admiten valores mayores a 5.");
                return valSize(text, key);
            } else {
                return size;
            }
        } catch (Exception e) {
            System.out.println("Error: Verifique que está escribiendo números.");
            return valSize(text, key);
        }
    }

    // Metodo para validar el horario de la pelicula
    public static String validHour(String text, Scanner key) {
        String time = key.nextLine();
        while (true) {

            if (!time.matches("\\d{1,2}:\\d{2}")) {
                System.out.println("Error: Formato incorrecto, es H:MM");
                System.out.print("\n" + text);
                time = key.nextLine();
                continue;
            }
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            if (hour < 0 || hour > 23 || minutes < 0 || minutes > 59) {
                System.out.println("Error: la hora tiene que estar entre 0 y 23 y los minutos entre 0 y 59.");
                System.out.print("\n" + text);
                time = key.nextLine();
                continue;
            }
            String str = "%02d:%02d";
            parts = null;
            return String.format(str, hour, minutes);
        }
    }


    // Metodo para validar el nombre de la pelicula
    public static String validMovieName(String text, Scanner key) {
        String name = key.nextLine();
        int i=0;
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

    // Metodo para validar la existencia el ID introducido
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

    // Metodo para validar el ID de las entradas
    public static int validSeatQtypart1(int num, String text, Scanner key) {
        try {
            System.out.print(text);
            int enter = Integer.parseInt(key.nextLine());
            return validateSeatQtypart2(num, text, key, enter);
        } catch (Exception e) {
            System.out.println("¡ERROR! Ingrese números, no caracteres.");
            return validSeatQtypart1(num, text, key);
        }
    }

    public static int validateSeatQtypart2(int num, String text, Scanner key, int enter) {
        if (enter < 0) {
            System.out.println("Introduzca un número de entradas válido.");
            return validSeatQtypart1(num, text, key);
        }
        if (enter > num) {
            System.out.println("Disculpe, solo hay " + num + " asientos disponibles.");
            return validSeatQtypart1(num, text, key);
        }
        return enter;
    }

    // Validar el ID del menu
    public static int valOpt(String text, Scanner key) {
        int option = 0;
        try {
            System.out.print(text);
            option = Integer.parseInt(key.nextLine());
            if (option < 1 || option > 10) {
                option = 0;
            }
            return option;
        } catch (Exception e) {
            return option;
        }
    }

    // Metodo para validar la escritura del archivo
    public static void valArchive(String content, String route, boolean boo) {
        if (content == null ) {
            System.out.println("El contenido esta vacio, por lo tanto no se escribirá nada");
            return;
        }
        try (BufferedWriter addArchive = new BufferedWriter(new FileWriter(route, true))) {
            addArchive.write(content);
            if (boo) {
                addArchive.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    // Metodo para validar si la pelicula esta agotada
    public static boolean isMovieSoldOut(int[][][] info, int id) {
        for (int j = 0; j < info[0].length; j++) {
            if (info[id][j][2] != 0) {
                return false;
            }
        }
        return true;
    }

    // Metodo para validar si el cine esta agotado
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