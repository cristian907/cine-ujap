package repositories;

public class Time {

    private String iniHour;
    private String finHour;
    private String serialArchiveNumber;

    public Time(String iniHour, String finHour, String serialArchiveNumber) throws IllegalArgumentException{

        this.utilValiniHour(iniHour);
        this.utilValfinHour(finHour);
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

    private void utilValfinHour(String hour) throws IllegalArgumentException{

        if (!hour.matches("\\d{1,2}:\\d{2}")){
            throw new IllegalArgumentException(" [la hora debe estar escrita en formato hh:mm] ");

        }else{
            this.finHour=hour;
        }
    }
}