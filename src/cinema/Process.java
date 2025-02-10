package cinema;

import java.util.Scanner;

public class Process {
    public static void iniInfo(int[][][] matrix){
        if(matrix != null){
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    for(int k = 0; k < matrix[i][j].length; k++){
                        matrix[i][j][k] = 0;
                    }
                }
            }
        }
    }

    public static void iniShowtime(String[][] showtime){
        if(showtime != null){
            for(int i = 0; i < showtime.length; i++){
                for(int j = 0; j < showtime[i].length; j++){
                    showtime[i][j] = "";
                }
            }
        }
    }

    public static void iniMovie(String[] name) {
        if(name != null){
            for(int i = 0; i < name.length; i++){
                name[i] = "";
            }
        }
    }

    public static void attachData(int[][][] matrix, String[][] showtime, String[] name) {
//        String text = "";
//        ***CAMBIAR ENTRADA DE DATOS A VALIDATE***
        try (Scanner enter = new Scanner(System.in)) {
            for (int i = 0; i < showtime.length; i++) {
                System.out.println("Introduzca el nombre de la pelicula #"+(i+1)+": ");
                name[i] = enter.nextLine();
//                ***TEMPORAL - ENTRADA DE DATOS POR VALIDATE
                for (int j = 0; j < showtime[0].length; j++) {
                    System.out.println("Introduzca el horario #"+(j+1)+" de la pelicula "+name[i]+" (formato de 24 horas)");
                    showtime[i][j] = enter.nextLine();
                }
            }
        }

    }
}
