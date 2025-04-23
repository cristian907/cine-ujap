package repositories;

public class Genre {

    private String movieGenre;
    private String movieName;
    private String serialArchiveNumber;

    public Genre(String genre, String name, String serialArchiveNumber){

        this.utilValMovieName(name);
        this.utilValGender(genre);
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

    public String getmovieGender() {
        return movieGenre;
    }

    public void setMovieGender(String gender) {
        this.movieGenre = gender;
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
    private void utilValGender(String gender) throws IllegalArgumentException{

        String moGender = gender.trim().toLowerCase();

        if (moGender.equals("suspenso") || moGender.equals("terror") || moGender.equals("comedia") || moGender.equals("romance")
                || moGender.equals("documental") || moGender.equals("experimental") || moGender.equals("accion")){
            this.movieGenre = moGender;
        } else{
            throw new IllegalArgumentException(" [El genero no es valido] los disponibles son comedia, terror, romance, suspenso, documental y experimental" );
        }
    }


}
