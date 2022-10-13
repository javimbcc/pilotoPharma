package modelos.consultas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.DTOs.dtaToOpr_cat_productosDTO;
import modelos.DTOs.opr_cat_productosDTO;



public class consultasPostgreSQl {

	public static List<opr_cat_productosDTO> listarProductos(Connection conexion) {
		//Declaramos la lista
		List<opr_cat_productosDTO> listProductos = new ArrayList<opr_cat_productosDTO>();
		// Declaramos el state y la respuesta
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		if (conexion != null) {

			try {
				System.out.println("HACEMOS LA CONSULTA");
				// Abrimos la declaracion
				declaracionSQL = conexion.createStatement();
				// Se hace y ejecuta la consulta
				resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"dlk_operacional_productos\".\"opr_cat_productos\"");

				//Lo metemos en la lista
				
				listProductos = dtaToOpr_cat_productosDTO.ReaderAListAlumnoDTO(resultadoConsulta);
				
				
			} catch (SQLException e) {

				System.out.println("Error generando la declaracionSQL: " + e);

			}
		}
		return listProductos;
	}
	
	public static void insertarProductos(Connection conexion) {
		// Declaramos el state y la respuesta
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		if (conexion != null) {

			try {
				System.out.println("HACEMOS EL INSERT");
				// Abrimos la declaracion
				declaracionSQL = conexion.createStatement();
				// Se hace y ejecuta la consulta
				resultadoConsulta = declaracionSQL.executeQuery("INSERT INTO \"dlk_operacional_productos\".\"opr_cat_productos\" md_uuid,cod_producto, nombre_producto, tipo_producto_origen, tipo_producto_clase, des_producto)"
						+ "	VALUES ('adf131029022fch12345','hig_p_gelf_f','Gel de aceite de fresa, Farlane.','Propio','Higiene','Gel de aceite de fresa producido por marca propia Farlane.')");
	
			} catch (SQLException e) {

				System.out.println("Error en la insercionSQL: " + e);

			}
		}
		
	}
	
}
