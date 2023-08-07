package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

//Operaciones a ejecutar en archvio peliculas.txt
public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo); //Solo se crea la variable para buscarlo
        return archivo.exists();  //El Metodo exists() retorna un boolean.
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        List<Pelicula> listaPeliculas = new ArrayList();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine(); // Leemos las lineas del archivo
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                listaPeliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close(); //Cerramos el flujo
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al listar peliculas:" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al listar peliculas:" + ex.getMessage());
        }
        return listaPeliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar)); //Abro el archivo.
            salida.println(pelicula.getNombre()); // Escribo el nombre de la pelicula.
            salida.close(); //Cierro el archivo
            System.out.println("Se ha escrito en el archivo.");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al escribir archivo: " + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null; //aqui almacenamos las lineas del archivo
            linea = entrada.readLine();
            int indice = 1;
            while(linea != null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Pelicula " + linea + " encontrada en el indice "+ indice;
                }
                indice++;
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error al leer archivo: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error al escribir archivo: " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo); //Asi se habre el archivo
            salida.close(); //Asi se cierra el archivo
            System.out.println("Se ha creado el archivo.");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al crear archivo:" + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if(archivo.exists()){
            archivo.delete();
        }
        System.out.println("Se ha borrado el archivo.");
    }

}
