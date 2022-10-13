package modelos.DTOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dtaToOpr_cat_productosDTO {

	public static List<opr_cat_productosDTO> ReaderAListAlumnoDTO(ResultSet resultadoConsulta)
    {
		//Metemos los datos en la lista productosDTO
        List<opr_cat_productosDTO> listProductosDTO = new ArrayList<opr_cat_productosDTO>();
        try {
			while (resultadoConsulta.next())
			{
				listProductosDTO.add(new opr_cat_productosDTO(
			        (resultadoConsulta.getString("md_uuid")), 
			        resultadoConsulta.getString("md_fch"), 
			        resultadoConsulta.getString("id_producto"),
			        resultadoConsulta.getString("cod_producto"),
			        resultadoConsulta.getString("nombre_producto"),
			        resultadoConsulta.getString("tipo_producto_origen"),
			        resultadoConsulta.getString("tipo_producto_clase"),
			        resultadoConsulta.getString("des_producto"),
			        resultadoConsulta.getString("fch_alta_producto"),
			        resultadoConsulta.getString("fch_baja_producto")
			        )
			        );

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Una vez metidos los datos en la lista devolvemos la lista con los productos
        return listProductosDTO;
    }
}
