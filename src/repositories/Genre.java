package repositories;

public class Genre {

    private String movieGenre;
    private String movies;
    private String serialArchiveNumber;

    // Constructor

    /**
     * Constructor por defecto de la clase Genre.
     * Inicializa los atributos a valores nulos.
     */
    public Genre() {
        this.movieGenre = null;
        this.movies = null;
        this.serialArchiveNumber = null;
    }

    /**
     * Constructor que inicializa un objeto Genre con un género y un número de archivo serial.
     *
     * @param genre               El género de la película.
     * @param serialArchiveNumber El número de archivo serial asociado al género.
     * @throws IllegalArgumentException Si el género o el número de archivo serial son inválidos o están incompletos.
     */
    public Genre(String genre, String serialArchiveNumber) throws IllegalArgumentException {
        this.utilValGenre(genre);
        this.serialArchiveNumber = (serialArchiveNumber.isEmpty()) ? null : serialArchiveNumber;

        if (this.serialArchiveNumber == null || this.movieGenre == null) {
            throw new IllegalArgumentException("- Error-Instancia: Objeto incompleto. ");
        }
    }

    // Getters

    /**
     * Obtiene el nombre de las películas asociadas al género.
     *
     * @return El nombre de las películas.
     */
    public String getMovies() {
        return movies;
    }

    /**
     * Obtiene el género de la película.
     *
     * @return El género de la película.
     */
    public String getMovieGenre() {
        return movieGenre;
    }

    /**
     * Obtiene el número de archivo serial asociado al género.
     *
     * @return El número de archivo serial.
     */
    public String getSerialArchive() {
        return this.serialArchiveNumber;
    }

    // Setters

    /**
     * Establece el nombre de las películas asociadas al género.
     *
     * @param name El nombre de las películas.
     */
    public void setMovies(String name) {
        this.movies = name;
    }

    /**
     * Establece el género de la película.
     *
     * @param genre El género de la película.
     */
    public void setMovieGenre(String genre) {
        this.movieGenre = genre;
    }

    /**
     * Establece el número de archivo serial asociado al género.
     *
     * @param serial El número de archivo serial.
     */
    public void setSerialArchive(String serial) {
        this.serialArchiveNumber = (serial.isEmpty()) ? null : serial;
    }

    // Métodos privados

    /**
     * Verifica si el género proporcionado es válido y lo asigna al atributo movieGenre.
     *
     * @param genre El género a validar.
     * @throws IllegalArgumentException Si el género es inválido o está vacío.
     */
    private void utilValGenre(String genre) throws IllegalArgumentException {
        if (!(genre.trim().isEmpty() || genre == null)) {
            String moGenre = genre.trim().toLowerCase();

            if (moGenre.equals("suspenso") || moGenre.equals("terror") || moGenre.equals("comedia") || moGenre.equals("romance")
                    || moGenre.equals("documental") || moGenre.equals("experimental") || moGenre.equals("accion") || moGenre.equals("ciencia-ficcion")) {
                this.movieGenre = moGenre;
            } else {
                throw new IllegalArgumentException(" [El genero no es valido] los disponibles son comedia, terror, romance, suspenso, documental y experimental");
            }
        } else {
            throw new IllegalArgumentException(" [el genero no puede estar vacio] ");
        }
    }
}