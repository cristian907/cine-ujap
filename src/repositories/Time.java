package repositories;

public class Time {

    private String iniHour;
    private String finHour;
    private String movies;
    private String serialArchiveNumber;

    // Constructor

    /**
     * Constructor por defecto de la clase Time.
     * Inicializa los atributos a valores nulos.
     */
    public Time() {
        this.iniHour = null;
        this.finHour = null;
        this.movies = null;
        this.serialArchiveNumber = null;
    }

    /**
     * Constructor que inicializa un objeto Time con una hora de inicio, una hora de fin y un número de archivo serial.
     *
     * @param iniHour             La hora de inicio en formato hh:mm.
     * @param finHour             La hora de fin en formato hh:mm.
     * @param serialArchiveNumber El número de archivo serial asociado al horario.
     * @throws IllegalArgumentException Si alguno de los parámetros es inválido o está incompleto.
     */
    public Time(String iniHour, String finHour, String serialArchiveNumber) throws IllegalArgumentException {
        this.iniHour = utilValHour(iniHour);
        this.finHour = utilValHour(finHour);
        this.serialArchiveNumber = (serialArchiveNumber.isEmpty()) ? null : serialArchiveNumber;

        if (this.iniHour == null || this.serialArchiveNumber == null || this.finHour == null) {
            throw new IllegalArgumentException("- Error-Instancia: Objeto incompleto. ");
        }
    }

    // Getters

    /**
     * Obtiene la hora de inicio.
     *
     * @return La hora de inicio en formato hh:mm.
     */
    public String getIniHour() {
        return iniHour;
    }

    /**
     * Obtiene la hora de fin.
     *
     * @return La hora de fin en formato hh:mm.
     */
    public String getFinHour() {
        return finHour;
    }

    /**
     * Obtiene el número de archivo serial asociado al horario.
     *
     * @return El número de archivo serial.
     */
    public String getSerialArchive() {
        return this.serialArchiveNumber;
    }

    /**
     * Obtiene el nombre de las películas asociadas al horario.
     *
     * @return El nombre de las películas.
     */
    public String getMovies() {
        return movies;
    }

    // Setters

    /**
     * Establece la hora de inicio.
     *
     * @param hour La hora de inicio en formato hh:mm.
     */
    public void setIniHour(String hour) {
        this.iniHour = hour;
    }

    /**
     * Establece la hora de fin.
     *
     * @param hour La hora de fin en formato hh:mm.
     */
    public void setFinHour(String hour) {
        this.finHour = hour;
    }

    /**
     * Establece el número de archivo serial asociado al horario.
     *
     * @param serial El número de archivo serial.
     */
    public void setSerialArchive(String serial) {
        this.serialArchiveNumber = (serial.isEmpty()) ? null : serial;
    }

    /**
     * Establece el nombre de las películas asociadas al horario.
     *
     * @param movies El nombre de las películas.
     */
    public void setMovies(String movies) {
        this.movies = movies;
    }

    // Métodos privados

    /**
     * Verifica que la hora proporcionada sea válida y esté en el formato hh:mm.
     *
     * @param hour La hora a validar.
     * @return La hora validada en formato hh:mm.
     * @throws IllegalArgumentException Si la hora es nula, está vacía o no cumple con el formato hh:mm.
     */
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