package mx.com.bellicose.usuario_cifrado_mongo.dto;

import com.google.gson.annotations.SerializedName;
import com.mongodb.BasicDBObject;

import mx.com.bellicose.usuario_cifrado_mongo.util.Cifrado;


public class PortabilidadRegDTO {
	
	String clave = "1111111111111111";
	String vi = "1111111111111111";
    
	 @SerializedName("Id") 
	private int id;
	 @SerializedName("Bin") 
	private int bin;
	 @SerializedName("Descripcion") 
	private String descripcion;
	
	public PortabilidadRegDTO(BasicDBObject dbObjectPortabilidadReg){
		try {
//			this.nombre=Cifrado.decifrar(clave, vi, dbObjectUsuario.getString("nombre"));
			this.id=dbObjectPortabilidadReg.getInt("Id");
			this.bin=dbObjectPortabilidadReg.getInt("Bin");
//			this.descripcion=Cifrado.decifrar(clave, vi, dbObjectPortabilidadReg.getString("Descripcion"));
			this.descripcion=dbObjectPortabilidadReg.getString("Descripcion");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		BasicDBList listOcupaciones = (BasicDBList) dbObjectUsuario.get("ocupacion");
//		this.ocupacion=new ArrayList<>();
//		for (Object object : listOcupaciones) {
//			this.ocupacion.add(object.toString());
//		}
	}
	
	public BasicDBObject toDbObjectPortabilidadReg(){
		BasicDBObject dBObjectPortabilidadReg = new BasicDBObject();
		
		try {
//			dBObjectUsuario.append("nombre", Cifrado.cifrar(clave, vi, this.getNombre()));
//			dBObjectUsuario.append("apellido", Cifrado.cifrar(clave, vi, this.getApellido()));
			dBObjectPortabilidadReg.append("Id", this.getId());
			dBObjectPortabilidadReg.append("Bin", this.getBin());
			dBObjectPortabilidadReg.append("Descripcion", Cifrado.cifrar(clave, vi, this.getDescripcion()));
		} catch (Exception e) {
//			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
		return dBObjectPortabilidadReg;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBin() {
		return bin;
	}

	public void setBin(int bin) {
		this.bin = bin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "id: " + id + " bin: " + bin + " descripcion: " + descripcion;
	}
}
