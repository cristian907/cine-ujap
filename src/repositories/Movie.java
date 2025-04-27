package repositories;

public class Movie {

    private String movieName;
    private String movieGenre;
    private String[] movieTimes;
    private String serialArchiveNumber;

    //Constructor
    public Movie(String movieName, String serialArchiveNumber) throws IllegalArgumentException {

        this.utilValMovieName(movieName);
        this.serialArchiveNumber = (serialArchiveNumber.isEmpty()) ? null : serialArchiveNumber;

        if (this.movieName == null || this.serialArchiveNumber == null) {
            throw new IllegalArgumentException("- Error-Instancia: Objeto incompleto. ");
        }
    }

    //Getters
    public String getmovieName() {
        return movieName;
    }

    public String getmovieGenre() {
        return movieGenre;
    }

    public String getSerialArchive() {
        return this.serialArchiveNumber;
    }

    //Setters
    public void setmovieName(String name) {
        this.movieName = name;
    }

    public void setMovieGenre(String genre) {
        this.movieGenre = genre;
    }

    public void setSerialArchive(String serial) {
        this.serialArchiveNumber = (serial.isEmpty()) ? null : serial;
    }

    //Verifica que el nombre no este vacio
    private void utilValMovieName(String name) throws IllegalArgumentException {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(" [El nombre no puede ser nulo o vacio] ");
        } else {
            this.movieName = name;
        }
    }

    public String[] getMovieTimes() {
        return movieTimes;
    }

    public void setMovieTimes(String[] movieTimes) {
        this.movieTimes = movieTimes;
    }
}