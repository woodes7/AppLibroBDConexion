package ConexionServicios;

import java.sql.Connection;
import java.util.ArrayList;

import ConexionDtos.LibroDto;

/**
 * Interfaz que define los métodos de consulta a la base de datos 
 * @author Puesto4
 */
public interface interfazConexionConsultas {
	/**
	 * Metodo que realiza una consulta tipo Select para mostrar los lirbos	 
	 * @param conexionGenerada
	 * @return
	 */
	public ArrayList<LibroDto> ListaselecionarLibros(Connection conexionGenerada);

	/**
	 * Metodo que realiza una consulta para modificar un libro en la base de datos
	 * @param conexionGenerada
	 * @return
	 */
	public ArrayList<LibroDto> modificarLibro(Connection conexionGenerada);

	/**
	 * Metodo que realiza una consulta para insertar un libro en la base de datos
	 * @param conexionGenerada
	 * @return
	 */
	public ArrayList<LibroDto> insertarLibro(Connection conexionGenerada);
}
