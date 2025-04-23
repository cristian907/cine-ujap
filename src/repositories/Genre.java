package repositories;

public class Genre {

    private String movieGenre;
    private String movieName;
    private String serialArchiveNumber;

    public Genre(String genre, String serialArchiveNumber){

//        this.utilValMovieName(name);
        this.utilValGenre(genre);
        this.serialArchiveNumber = (serialArchiveNumber.isEmpty()) ? null: serialArchiveNumber;

        if (this.movieName == null || this.serialArchiveNumber == null || this.movieGenre == null){
            throw new IllegalArgumentException("- Error-Instancia: Objeto incompleto. ");
        }

    }

    public String getmovieName() {
        return movieName;
    }

    public void setmovieName(String name) {
        this.movieName = name;
    }

    public String getmovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String genre) {
        this.movieGenre = genre;
    }

    public String getSerialArchive(){
        return this.serialArchiveNumber;
    }

    public void setSerialArchive(String serial){
        this.serialArchiveNumber = (serial.isEmpty()) ? null: serial;
    }



    private void utilValMovieName(String name) throws IllegalArgumentException {

        if (name.trim().isEmpty()){
            throw new IllegalArgumentException(" [El nombre no puede ser nulo o vacio] ");
        } else {
            this.movieName = name;
        }

    }
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
