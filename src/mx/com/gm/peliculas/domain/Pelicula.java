package mx.com.gm.peliculas.domain;

 // Simplemente representa el objeto pelicula.

public class Pelicula {
    private String nombre;
    
    public Pelicula(){
    }
    
    public Pelicula(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "nombre=" + nombre + '}';
    }
    
    
}
