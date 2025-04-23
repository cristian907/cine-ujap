package composables;

import repositories.ArchiveUtil;
import validateItem.Validate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;

public class StoreArchive {
    public static int randomSerial = (int)(Math.random()*1000)+1;

    public static void storeItemMovie(String[] movie, String[][] showTime, ArchiveUtil archive, boolean checking) throws IOException{
        String text = "";
        int cont = 0;
        LocalDateTime time = LocalDateTime.now();
        String definitiveHour = time.toString().substring(0,time.toString().length()-16);
        String routeName;
        if(!checking){
            routeName = "MoviesWithHours"+definitiveHour+"_serial"+randomSerial;
        }else{
            routeName = "MoviesWithHours";
        }
        if (movie != null && showTime != null) {
            for (int i = 0; i < showTime.length; i++) {
                text = movie[i] + " ";
                archive.setCreateArchive(text,routeName,false);
                for (int j = 0; j < showTime[i].length-1; j++) {
                    text = showTime[i][j] + " ";
                    archive.setCreateArchive(text,routeName,false);
                }
                cont++;
                text = String.valueOf(showTime[i][showTime[0].length - 1]);
                if(cont< movie.length){
                    archive.setCreateArchive(text,routeName,true);
                }else {
                    archive.setCreateArchive(text,routeName,false);
                }
            }
            time = null;
        }
    }

    public static void storeName(String[] movie, ArchiveUtil archive, boolean checking) {
        String text = "";
        LocalDateTime time = LocalDateTime.now();
        String definitiveHour = time.toString().substring(0,time.toString().length()-16);
        String routeName;
        if(!checking){
            routeName = "MovieStore"+definitiveHour+"_serial"+randomSerial;
        }else{
            routeName = "MovieStore";
        }
        if (movie != null) {
            for (int i = 0; i < movie.length-1; i++) {
                text = movie[i] + " ";
                archive.setCreateArchive(text,routeName,false);
            }
            text = String.valueOf(movie[movie.length-1]);
            archive.setCreateArchive(text,routeName,false);

            time = null;
        }
    }

    public static void storeNameAndGender(String[] movie, String[] gender, ArchiveUtil archive, boolean checking) {
        String text = ""; int cont = 0;
        LocalDateTime time = LocalDateTime.now();
        String definitiveHour = time.toString().substring(0,time.toString().length()-16);
        String routeName;
        if(!checking){
            routeName = "MovieAndGenderStore"+definitiveHour+"_serial"+randomSerial;
        }else{
            routeName = "MovieAndGenderStore";
        }
        if (movie != null && gender != null) {
            for (int i = 0; i < movie.length; i++) {
                text = movie[i] + " "+gender[i];
                if(cont < movie.length-1) {
                    archive.setCreateArchive(text, routeName, true);
                }else{
                    archive.setCreateArchive(text, routeName, false);
                }
                cont++;
            }
            time = null;
        }
    }

    public static void storeHour(String[][] showTime, ArchiveUtil archive, boolean checking) {
        String text = "";
        int cont = 0;
        LocalDateTime time = LocalDateTime.now();
        String definitiveHour = time.toString().substring(0,time.toString().length()-16);
        String routeName;
        if(!checking){
            routeName = "timeStore"+definitiveHour+"_serial"+randomSerial;
        }else{
            routeName = "timeStore";
        }
        if (showTime != null) {
            for (int i = 0; i < showTime.length; i++) {
                for (int j = 0; j < showTime[0].length-1; j++) {
                    text = showTime[i][j] + " ";
                    archive.setCreateArchive(text,routeName,false);
                }
                cont ++;
                text = String.valueOf(showTime[i][showTime[0].length - 1]);
                if(cont< showTime.length){
                    archive.setCreateArchive(text,routeName,true);
                }else {
                    archive.setCreateArchive(text,routeName,false);
                }
            }
            time = null;
        }
    }

    public static void storeShowReport(String[] movie, String[][] showTimes, int[][][] info,ArchiveUtil archive, boolean checking) {
        String text = "";
        int aux, plus = 0, plusTotal = 0;
        LocalDateTime time = LocalDateTime.now();
        String definitiveHour = time.toString().substring(0,time.toString().length()-16);
        String routeName;
        if(!checking){
            routeName = "ReportStore"+definitiveHour+"_serial"+randomSerial;
        }else{
            routeName = "ReportStore";
        }
        archive.setCreateArchive("---------------------Reporte de ventas--------------------",routeName,true);

        if (showTimes != null && movie != null && info != null) {
            for (int i = 0; i < showTimes.length; i++) {
                text = "Película " + (i + 1) + ":";
                //Validate.valArchive(text, route, true);
                archive.setCreateArchive(text,routeName,true);
                text = String.format("Nombre: %7s", movie[i]);
                //Validate.valArchive(text, route, true);
                archive.setCreateArchive(text,routeName,true);
                text = "Hora    |   Ventas n   |    Ventas s   |     TOTAL $";
                //Validate.valArchive(text, route, true);
                archive.setCreateArchive(text,routeName,true);
                for (int j = 0; j < showTimes[0].length; j++) {
                    aux = (info[i][j][0]) * 3 + (info[i][j][1]) * 6;
                    plus += aux;
                    plusTotal += aux;
                    text = String.format("%5s       %4d$           %4d$           %4d$", showTimes[i][j], info[i][j][0] * 3, info[i][j][1] * 6, aux);
                    //Validate.valArchive(text, route, true);
                    archive.setCreateArchive(text,routeName,true);
                }
                text = String.format("                                            %4d$", plus);
                //Validate.valArchive(text, route, true);
                archive.setCreateArchive(text,routeName,true);
                text = "";
                //Validate.valArchive(text, route, true);
                archive.setCreateArchive(text,routeName,true);
                plus = 0;
            }
            text = "El total de ventas del dia fue de: " + plusTotal + "$";
            archive.setCreateArchive(text,routeName,true);
            //Validate.valArchive(text, route, false);
        }
        time = null;
    }
}