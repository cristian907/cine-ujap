package cinema;

import java.util.Scanner;

public class Validate {

    public static int valSize(String text){
        int size = 0;
        Scanner read = new Scanner(System.in);
        while(true){
            try{
                System.out.printf(text);
                size = read.nextInt();

                if (size < 1){
                    System.out.println("Error: no se admiten valores menores a 0");
                }
                else{
                    return size;
                }
            }catch(Exception e){
                System.out.println("Error: Verifique que esta escribiendo numeros y no caracteres");
                read.nextLine();
            }
        }
    }

    public static String validHour(String text){
        while (true){


            if (!text.matches("\\d{1,2}:\\d{2}")){
                System.out.println("Error: Formato incorrecto, es H:MM");
                continue;
            }
            String[] parts = text.split(":");
            try{
                int hour = Integer.parseInt(parts[0]);
                int minutes = Integer.parseInt(parts[1]);
                if (hour < 0 || hour > 24 || minutes < 0 || minutes >=60){
                    System.out.println("Error: la hora tiene que estar entre 0 y 24 y los minutos entre 0 y 60");
                    continue;
                }
                return String.format("%02d:%02d");

            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese numeros, no caracteres");

            }
        }

    }

}
