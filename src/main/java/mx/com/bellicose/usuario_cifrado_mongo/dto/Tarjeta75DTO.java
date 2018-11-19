package mx.com.bellicose.usuario_cifrado_mongo.dto;

import com.google.gson.annotations.SerializedName;
import com.mongodb.BasicDBObject;

public class Tarjeta75DTO {
	String clave = "1111111111111111";
	String vi = "1111111111111111";

	@SerializedName("Id")
	private int id;
	@SerializedName("Numero")
	private String numero;
	@SerializedName("Cp")
	private String cp;
	@SerializedName("Email")
	private String email;
	@SerializedName("Celular")
	private String celular;
	@SerializedName("RFC")
	private String rfc;
	
	public Tarjeta75DTO(BasicDBObject dbObject){
		try{
			this.id=dbObject.getInt("Id");
			this.numero=dbObject.getString("Numero");
			this.cp=dbObject.getString("Cp");
			this.email=dbObject.getString("Email");
			this.celular=dbObject.getString("Celular");
			this.rfc=dbObject.getString("RFC");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BasicDBObject toDbObjectTarjeta75DTO(){
		BasicDBObject basicDBObject = new BasicDBObject();
		try{
			basicDBObject.append("Id", this.getId());
			basicDBObject.append("Numero", this.getNumero());
			basicDBObject.append("Cp", this.getCp());
			basicDBObject.append("Email", this.getEmail());
			basicDBObject.append("Celular", this.getCelular());
			basicDBObject.append("RFC", this.getRfc());
		} catch(Exception e){
			e.printStackTrace();
		}
		return basicDBObject;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:" + id + " numero: " + numero + " cp: " + cp + " email:" + email + " celular: " + celular + " rfc: " + rfc;
	}
}
