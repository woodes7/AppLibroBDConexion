package ConexionServicios;

import java.sql.Connection;
/**
 * Interfaz que define los métodos de conexion a la base de datos
 * @author Puesto4
 *
 */
public interface InterfazConexion {
/**
 * Metedo para establecer la conexión
 * @return
 */
	public Connection establecerConexion();
}
