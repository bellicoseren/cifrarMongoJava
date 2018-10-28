package mx.com.bellicose.usuario_cifrado_mongo.dto;

import java.util.ArrayList;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

import mx.com.bellicose.usuario_cifrado_mongo.util.Cifrado;

public class UsuarioDTO {
	
	String clave = "1111111111111111";
	String vi = "1111111111111111";

	private String nombre;
	private String apellido;
	private int edad;
	private ArrayList<String> ocupacion;
	private Boolean profesional;
	
	public UsuarioDTO(){	
	}
	
	public UsuarioDTO(String nombre, String apellido, int edad, ArrayList<String> ocupacion, Boolean profesional){
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.ocupacion=ocupacion;
		this.profesional=profesional;
	}
	
	public UsuarioDTO(BasicDBObject dbObjectUsuario){
		try {
			this.nombre=Cifrado.decifrar(clave, vi, dbObjectUsuario.getString("nombre"));
			this.apellido=Cifrado.decifrar(clave, vi, dbObjectUsuario.getString("apellido"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.edad=dbObjectUsuario.getInt("edad");
		
		BasicDBList listOcupaciones = (BasicDBList) dbObjectUsuario.get("ocupacion");
		this.ocupacion=new ArrayList<>();
		for (Object object : listOcupaciones) {
			this.ocupacion.add(object.toString());
		}
		
		this.profesional=dbObjectUsuario.getBoolean("profesional");
	}
	
	public BasicDBObject toDbObjectUsuario(){
		BasicDBObject dBObjectUsuario = new BasicDBObject();
		
		try {
			dBObjectUsuario.append("nombre", Cifrado.cifrar(clave, vi, this.getNombre()));
			dBObjectUsuario.append("apellido", Cifrado.cifrar(clave, vi, this.getApellido()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dBObjectUsuario.append("ocupacion", this.getOcupaciones());
		dBObjectUsuario.append("edad", this.getEdad());
		dBObjectUsuario.append("profesional", this.isProfesional());
		
		return dBObjectUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellidos(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public ArrayList<String> getOcupaciones() {
		return ocupacion;
	}

	public void setOcupaciones(ArrayList<String> ocupaciones) {
		this.ocupacion = ocupaciones;
	}

	public boolean isProfesional() {
		return profesional;
	}

	public void setProfesional(boolean profesional) {
		this.profesional = profesional;
	}

	@Override
	public String toString() {
		return "nombre: " + nombre + " apellido: " + apellido + " edad: " + edad + " ocupacion: " + ocupacion + " profesional: " + profesional;
	}
}
