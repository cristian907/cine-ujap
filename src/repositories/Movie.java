package repositories;

public class Movie {

    private String movieName;
    private String movieGenre;
    private String[] movieTimes;
    private String serialArchiveNumber;

    // Constructor

    /**
     * Constructor por defecto de la clase Movie.
     * Inicializa los atributos a valores nulos.
     */
    public Movie() {
        this.movieName = null;
        this.movieGenre = null;
        this.movieTimes = null;
        this.serialArchiveNumber = null;
    }

    /**
     * Constructor que inicializa un objeto Movie con un nombre de película y un número de archivo serial.
     *
     * @param movieName           El nombre de la película.
     * @param serialArchiveNumber El número de archivo serial asociado a la película.
     * @throws IllegalArgumentException Si el nombre de la película o el número de archivo serial son inválidos o están incompletos.
     */
    public Movie(String movieName, String serialArchiveNumber) throws IllegalArgumentException {
        this.utilValMovieName(movieName);
        this.serialArchiveNumber = (serialArchiveNumber.isEmpty()) ? null : serialArchiveNumber;

        if (this.movieName == null || this.serialArchiveNumber == null) {
            throw new IllegalArgumentException("- Error-Instancia: Objeto incompleto. ");
        }
    }

    // Getters

    /**
     * Obtiene el nombre de la película.
     *
     * @return El nombre de la película.
     */
    public String getmovieName() {
        return movieName;
    }

    /**
     * Obtiene el género de la película.
     *
     * @return El género de la película.
     */
    public String getmovieGenre() {
        return movieGenre;
    }

    /**
     * Obtiene el número de archivo serial asociado a la película.
     *
     * @return El número de archivo serial.
     */
    public String getSerialArchive() {
        return this.serialArchiveNumber;
    }

    /**
     * Obtiene los horarios de la película.
     *
     * @return Un arreglo con los horarios de la película.
     */
    public String[] getMovieTimes() {
        return movieTimes;
    }

    // Setters

    /**
     * Establece el nombre de la película.
     *
     * @param name El nombre de la película.
     */
    public void setmovieName(String name) {
        this.movieName = name;
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
     * Establece el número de archivo serial asociado a la película.
     *
     * @param serial El número de archivo serial.
     */
    public void setSerialArchive(String serial) {
        this.serialArchiveNumber = (serial.isEmpty()) ? null : serial;
    }

    /**
     * Establece los horarios de la película.
     *
     * @param movieTimes Un arreglo con los horarios de la película.
     */
    public void setMovieTimes(String[] movieTimes) {
        this.movieTimes = movieTimes;
    }

    // Métodos privados

    /**
     * Verifica que el nombre de la película no sea nulo, vacío o demasiado largo.
     *
     * @param name El nombre de la película a validar.
     * @throws IllegalArgumentException Si el nombre es nulo, vacío o tiene más de 30 caracteres.
     */
    private void utilValMovieName(String name) throws IllegalArgumentException {
        if (name.trim().isEmpty() || name == null) {
            throw new IllegalArgumentException(" [El nombre no puede ser nulo o vacio] ");
        } else if (name.length() > 30) {
            throw new IllegalArgumentException(" [El nombre no puede tener mas de 30 caracteres] ");
        } else {
            this.movieName = name;
        }
    }
}