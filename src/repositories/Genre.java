package repositories;

public class Genre {

    private String movieGenre;
    private String movies;
    private String serialArchiveNumber;

    //Constructor
    public Genre(String genre, String serialArchiveNumber) throws IllegalArgumentException{


        this.utilValGenre(genre);
        this.serialArchiveNumber = (serialArchiveNumber.isEmpty()) ? null: serialArchiveNumber;

        if (this.serialArchiveNumber == null || this.movieGenre == null){
            throw new IllegalArgumentException("- Error-Instancia: Objeto incompleto. ");
        }

    }
    //Getters
    public String getMovies() {
        return movies;
    }
    public String getMovieGenre() {
        return movieGenre;
    }

    public String getSerialArchive(){
        return this.serialArchiveNumber;
    }

    //Setters
    public void setMovies(String name) {
        this.movies = name;
    }

    public void setMovieGenre(String genre) {
        this.movieGenre = genre;
    }

    public void setSerialArchive(String serial){
        this.serialArchiveNumber = (serial.isEmpty()) ? null: serial;
    }


    //Verifica que el nombre no este vacio
    private void utilValMovieName(String name) throws IllegalArgumentException {

        if (name.trim().isEmpty()){
            throw new IllegalArgumentException(" [El nombre no puede ser nulo o vacio] ");
        } else {
            this.movies = name;
        }

    }

    //Verifica el nombre del genero y que sea valido o exista
    private void utilValGenre(String genre) throws IllegalArgumentException{

        String moGenre = genre.trim().toLowerCase();

        if (moGenre.equals("suspenso") || moGenre.equals("terror") || moGenre.equals("comedia") || moGenre.equals("romance")
                || moGenre.equals("documental") || moGenre.equals("experimental") || moGenre.equals("accion")){
            this.movieGenre = moGenre;
        } else{
            throw new IllegalArgumentException(" [El genero no es valido] los disponibles son comedia, terror, romance, suspenso, documental y experimental" );
        }
    }
}
