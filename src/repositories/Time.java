package repositories;

public class Time {

    private String iniHour;
    private String finHour;
    private String movies;
    private String serialArchiveNumber;

    //Constructor
    public Time(String iniHour, String finHour, String serialArchiveNumber) throws IllegalArgumentException {


        this.iniHour = utilValHour(iniHour);

        this.finHour = utilValHour(finHour);

        this.serialArchiveNumber = (serialArchiveNumber.isEmpty()) ? null : serialArchiveNumber;

        if (this.iniHour == null || this.serialArchiveNumber == null || this.finHour == null) {
            throw new IllegalArgumentException("- Error-Instancia: Objeto incompleto. ");
        }

    }

    //Getters
    public String getIniHour() {
        return iniHour;
    }

    public String getFinHour() {
        return finHour;
    }

    public String getSerialArchive() {
        return this.serialArchiveNumber;
    }

    public String getMovies() {
        return movies;
    }

    //Setters
    public void setIniHour(String hour) {
        this.iniHour = hour;
    }

    public void setFinHour(String hour) {
        this.finHour = hour;
    }

    public void setSerialArchive(String serial) {
        this.serialArchiveNumber = (serial.isEmpty()) ? null : serial;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    //Verifica el formato en el que debe ser ingresado la hora
    private String utilValHour(String hour) throws IllegalArgumentException {

        if (!(hour.trim().isEmpty() || hour == null)) {

            if (!hour.matches("\\d{1,2}:\\d{2}")) {
                throw new IllegalArgumentException(" [la hora debe estar escrita en formato hh:mm] ");

            } else {
                return hour;
            }
        } else {
            throw new IllegalArgumentException(" [la hora no debe estar vacia] ");
        }
    }
}