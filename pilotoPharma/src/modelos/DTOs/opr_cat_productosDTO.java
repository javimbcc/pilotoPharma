package modelos.DTOs;

public class opr_cat_productosDTO {

	public String md_uuid = "";
	public String md_fch = "";
	public String cod_producto = "";
	public String id_producto = "";
	public String nombre_producto = "";
	public String tipo_producto_origen = "";
	public String tipo_producto_clase = "";
	public String des_producto = "";
	public String fch_alta_producto = "";
	public String fch_baja_producto = "";

	// Constructor
	public opr_cat_productosDTO(String Md_uuid, String Md_fch,String Id_producto, String Cod_producto, String Nombre_producto,
			String Tipo_producto_origen, String Tipo_producto_clase, String Des_producto, String Fch_alta_producto,
			String Fch_baja_producto) {

		this.md_uuid = Md_uuid;
		this.md_fch = Md_fch;
		this.id_producto = Id_producto;
		this.cod_producto = Cod_producto;
		this.nombre_producto = Nombre_producto;
		this.tipo_producto_origen = Tipo_producto_origen;
		this.tipo_producto_clase = Tipo_producto_clase;
		this.des_producto = Des_producto;
		this.fch_alta_producto = Fch_alta_producto;
		this.fch_baja_producto = Fch_baja_producto;
	}

}
