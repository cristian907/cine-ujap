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

}
