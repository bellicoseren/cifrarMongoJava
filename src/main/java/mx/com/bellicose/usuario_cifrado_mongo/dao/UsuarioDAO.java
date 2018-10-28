package mx.com.bellicose.usuario_cifrado_mongo.dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import mx.com.bellicose.usuario_cifrado_mongo.Utils;
import mx.com.bellicose.usuario_cifrado_mongo.dto.UsuarioDTO;

public class UsuarioDAO {

	private MongoClient mongoClient = new MongoClient();
	private DBCursor cursor = null;
	private DBCollection collection = null;
	
	
	/*
	 *  READ Leer todos los usuarios de la base de datos
	 */
	public List<UsuarioDTO> leer() {


		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB("db_cifrada");

		collection = db.getCollection("usuario");

		List<UsuarioDTO> usuarios = new ArrayList<>();
		
		int numDocumentos = (int) collection.getCount();
		System.out.println("Hay " + numDocumentos + " en la colección");

		cursor = collection.find();
		try {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				System.out.println(dbObject.toString());
				usuarios.add((UsuarioDTO) Utils.fromDBObject(dbObject, UsuarioDTO.class));
			}
		} finally {
			cursor.close();
		}
		
		return usuarios;
	}
	
	
	/*
	 * CREATE un usuario a la base de datos
	 */
	public void agregar(UsuarioDTO usuarioDTO){
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB("db_cifrada");
		collection = db.getCollection("usuario");
		
		collection.insert(usuarioDTO.toDbObjectUsuario());
		System.out.println("Registro agregado");
	}
	
	
	public DBCursor consultaPosicion(){
		
    	//READ Consulta con condiciones
    	System.out.println("Usuarios ocupacion profesionista");
    	DBObject query = new BasicDBObject("ocupacion", new BasicDBObject("$regex", "Profesionista"));
    	
    	cursor = collection.find(query);
    	try{
	    	while(cursor.hasNext()){
	    		UsuarioDTO usuarioDTO = new UsuarioDTO((BasicDBObject) cursor.next());
	    		System.out.println(usuarioDTO.getNombre());
	    	}
    	}finally{
    		cursor.close();
    	}
		return cursor;
	}
	
	
	
	public void actualizar(){
		
    	//UPDATE Actualizar edad de los usuarios
    	DBObject find = new BasicDBObject("edad", new BasicDBObject("$gt", 100));
    	DBObject update = new BasicDBObject().append("$inc", new BasicDBObject().append("edad", 0));
    	collection.update(find, update, false, true);
	}
	
	
	
	public void eliminar(){
    	//DELETE Borrar usuarios que no sean profesionales
    	DBObject dbObject = new BasicDBObject("profesional", false);
    	collection.remove(dbObject);
	}
	
}
