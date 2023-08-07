package mx.com.gm.peliculas.negocio;

import java.util.List;
import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    private IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_ARCHIVO);
            datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de Acceso a Datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("Pelicula agregada");
        System.out.println("");
    }

    @Override
    public void listarPeliculas() {
            System.out.println("Peliculas del catalogo:");
        try {
            List peliculas = this.datos.listar(NOMBRE_ARCHIVO);
            for (Object pelicula : peliculas) {
                System.out.println(pelicula);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a Datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("");
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_ARCHIVO, buscar);
            System.out.println(resultado == null ? "No se ha econtrado " + buscar + " en el catálogo." : resultado);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a Datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("");
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if(this.datos.existe(NOMBRE_ARCHIVO)){
                datos.borrar(NOMBRE_ARCHIVO);
                datos.crear(NOMBRE_ARCHIVO);
            } else{
                datos.crear(NOMBRE_ARCHIVO);
            }
            System.out.println("Catalogo Peliculas inicializado");
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
        System.out.println("");
    }

}
