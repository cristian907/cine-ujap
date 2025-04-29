package repositories;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class ArchiveUtil {
    private String router;

    // Constructor

    /**
     * Constructor que inicializa un objeto ArchiveUtil con una ruta específica.
     *
     * @param router La ruta del directorio donde se encuentran los archivos.
     * @throws FileNotFoundException     Si el directorio no existe.
     * @throws IllegalArgumentException Si la ruta es nula o está vacía.
     */
    public ArchiveUtil(String router) throws FileNotFoundException, IllegalArgumentException {
        if (router == null || router.isEmpty()) {
            throw new IllegalArgumentException("La ruta asignada no es válida.");
        }
        this.utilDirectory(router);
    }

    // Getters

    /**
     * Obtiene la ruta del directorio actual.
     *
     * @return La ruta del directorio.
     */
    public String getRouter() {
        return this.router;
    }

    /**
     * Obtiene un archivo específico como un objeto Scanner.
     *
     * @param nameArchive El nombre del archivo a abrir.
     * @return Un objeto Scanner para leer el archivo, o null si ocurre un error.
     * @throws IllegalArgumentException Si el nombre del archivo es nulo o está vacío.
     * @throws FileNotFoundException    Si el archivo no existe o no es un archivo válido.
     */
    public Scanner getArchive(String nameArchive) {
        try {
            if (nameArchive == null || nameArchive.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre del archivo es requerido.");
            }

            File archive = new File(this.router + nameArchive);

            // Verificar si es un archivo y no un directorio
            if (!archive.isFile()) {
                throw new FileNotFoundException("El archivo especificado no es válido.");
            }

            return new Scanner(archive);

        } catch (IOException | IllegalArgumentException e) {
            // Manejo de excepciones al abrir el archivo
            System.out.println("ReadArchive-Error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Obtiene una lista de los nombres de los archivos en el directorio actual.
     *
     * @return Un arreglo de cadenas con los nombres de los archivos, o null si ocurre un error.
     * @throws FileNotFoundException Si no se encuentran archivos en el directorio.
     */
    public String[] getDirectories() {
        try {
            File directories = new File(this.router);

            if (Objects.requireNonNull(directories.list()).length >= 1) {
                return directories.list();
            }
            throw new FileNotFoundException("No se encontraron archivos.");

        } catch (FileNotFoundException e) {
            System.out.println("Directory-Error: " + e.getMessage());
            return null;
        }
    }

    // Setters

    /**
     * Establece una nueva ruta para el directorio.
     *
     * @param router La nueva ruta del directorio.
     * @throws FileNotFoundException Si el directorio no existe.
     */
    public void setRouter(String router) throws FileNotFoundException {
        this.utilDirectory(router);
    }

    /**
     * Crea o escribe contenido en un archivo específico.
     *
     * @param content     El contenido a escribir en el archivo.
     * @param nameArchive El nombre del archivo.
     * @param bool        Si es true, agrega una nueva línea al final del contenido.
     * @throws NullPointerException Si el contenido o el nombre del archivo son nulos o están vacíos.
     */
    public void setCreateArchive(String content, String nameArchive, boolean bool) {
        try (BufferedWriter addArchive = new BufferedWriter(new FileWriter(this.router + nameArchive + ".txt", true))) { // 'true' permite agregar al archivo existente
            if (content.trim().isEmpty() || nameArchive.isEmpty()) {
                throw new NullPointerException("El contenido es requerido.");
            }

            addArchive.write(content);  // Escribir en el archivo
            if (bool) {
                addArchive.newLine(); // Agregar nueva línea opcional
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("- CreateOrWriteArchive-Error: " + e.getMessage());
        }
    }

    /**
     * Verifica si existen archivos en el directorio actual.
     *
     * @return true si existen archivos, false en caso contrario.
     */
    public boolean directoriesExist() {
        File directories = new File(this.router);

        return Objects.requireNonNull(directories.list()).length >= 1;
    }

    // Métodos utilitarios

    /**
     * Valida que el directorio especificado exista y lo establece como la ruta actual.
     *
     * @param router La ruta del directorio a validar.
     * @throws FileNotFoundException Si el directorio no existe.
     */
    private void utilDirectory(String router) throws FileNotFoundException {
        File directories = new File(router);
        if (!directories.exists()) {
            throw new FileNotFoundException("El directorio a guardar no existe.");
        }
        this.router = router;
    }
}



