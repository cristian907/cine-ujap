package storage;

import validateItem.Validate;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class LoadData {

    public static String[] loadNames() throws IOException {
        String route = Paths.get("").toRealPath().toString() + "/src/storage/movies.txt";
        Scanner file = Validate.readFile(route);
        if (file != null) {
            String[] names = file.nextLine().split(" ");
            file.close();
            return names;
        } else {
            return null;
        }
    }

    public static String[][] loadTimes(String[] names) throws IOException {
        String route = Paths.get("").toRealPath().toString() + "/src/storage/times.txt";
        Scanner file = Validate.readFile(route);
        if (file != null) {
            String[][] times = new String[names.length][];
            for (int i = 0; i < times.length; i++) {
                times[i] = file.nextLine().split(" ");
            }
            file.close();
            return times;
        } else {
            return null;
        }
    }
}
