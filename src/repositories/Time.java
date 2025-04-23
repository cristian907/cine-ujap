package repositories;

import java.util.Scanner;

public class Time {

    private String iniHour;
    private String finHour;
    private String serialArchiveNumber;

    public Time(){

    }

    public Time(String iniHour, String dure, String serialArchiveNumber) throws IllegalArgumentException{

        this.utilValiniHour(iniHour);
        this.calcHour(dure);
        this.serialArchiveNumber = (serialArchiveNumber.isEmpty()) ? null: serialArchiveNumber;

        if (this.iniHour == null || this.serialArchiveNumber == null || this.finHour == null){
            throw new IllegalArgumentException("- Error-Instancia: Objeto incompleto. ");
        }

    }

    public String getIniHour() {
        return iniHour;
    }

    public void setIniHour(String hour) {
        this.iniHour = hour;
    }

    public String getFinHour() {
        return finHour;
    }

    public void setFinHour(String hour) {
        this.finHour = hour;
    }

    public String getSerialArchive(){
        return this.serialArchiveNumber;
    }

    public void setSerialArchive(String serial){
        this.serialArchiveNumber = (serial.isEmpty()) ? null: serial;
    }

    private void utilValiniHour(String hour) throws IllegalArgumentException{

        if (!hour.matches("\\d{1,2}:\\d{2}")){
            throw new IllegalArgumentException(" [la hora debe estar escrita en formato hh:mm] ");

        }else{
            this.iniHour=hour;
        }
    }

    private void calcHour(String dure){

        String[] parts = iniHour.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        String[] dureParts = dure.split(":");
        int dureHour = Integer.parseInt(dureParts[0]);
        int dureMinutes = Integer.parseInt(dureParts[1]);
        int finMinutes = dureMinutes + minutes;
        int finHour = dureHour + hour;
        if (finMinutes>59){
            finMinutes-=60;
            finHour++;
        }
        if (finHour>23){
            finHour-=24;
        }

        String str = "%02d:%02d";
        parts = null;
        dureParts = null;
        this.finHour=String.format(str, finHour, finMinutes);

    }

}