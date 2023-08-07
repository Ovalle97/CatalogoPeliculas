package mx.com.gm.peliculas.negocio;

//Intermediario entre Main y guardado de informacion de datos.

import mx.com.gm.peliculas.excepciones.*;


public interface CatalogoPeliculas {
    public static final String NOMBRE_ARCHIVO = "peliculas.txt";
    
    void agregarPelicula(String nombrePelicula);
    void listarPeliculas();
    void buscarPelicula(String buscar);
    void iniciarCatalogoPeliculas();
}
