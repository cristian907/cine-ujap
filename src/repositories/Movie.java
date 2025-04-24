package repositories;

public class Movie {

    private String movieName;
    private String movieGenre;
    private String serialArchiveNumber;

    //Constructor
    public Movie(String movieName, String serialArchiveNumber){

        this.utilValMovieName(movieName);
        this.serialArchiveNumber = (serialArchiveNumber.isEmpty()) ? null: serialArchiveNumber;

        if (this.movieName == null || this.serialArchiveNumber == null){
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

    public String getSerialArchive(){
        return this.serialArchiveNumber;
    }

    //Setters
    public void setmovieName(String name) {
        this.movieName = name;
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
            this.movieName = name;
        }

    }
//    private void utilValGenre(String genre) throws IllegalArgumentException{
//
//        String moGenre = genre.trim().toLowerCase();
//
//        if (moGenre.equals("suspenso") || moGenre.equals("terror") || moGenre.equals("comedia") || moGenre.equals("romance")
//                || moGenre.equals("documental") || moGenre.equals("experimental") || moGenre.equals("accion")){
//            this.movieGenre = moGenre;
//        } else{
//            throw new IllegalArgumentException(" [El genero no es valido] los disponibles son comedia, terror, romance, suspenso, documental y experimental" );
//        }
//    }
}