package mx.com.bellicose.usuario_cifrado_mongo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import mx.com.bellicose.usuario_cifrado_mongo.dao.UsuarioDAO;
import mx.com.bellicose.usuario_cifrado_mongo.dto.UsuarioDTO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	MongoClient mongoClient = new MongoClient();
    	DBCollection collection = null;
		DB db = mongoClient.getDB("db_cifrada");
		collection = db.getCollection("usuario");
    	
    	ArrayList<UsuarioDTO> usuarios = new ArrayList<>();
    	
    	usuarios.add(new UsuarioDTO("Kev", "Hernandez Flores", 15, new ArrayList<String>(Arrays.asList("Maestro")), true));
    	usuarios.add(new UsuarioDTO("Christopher", "Hernandez Flores", 15, new ArrayList<String>(Arrays.asList("Ingeniero")), true));
    	usuarios.add(new UsuarioDTO("Keruvin", "Hernandez Flores", 15, new ArrayList<String>(Arrays.asList("Arquitecto")), true));
    	usuarios.add(new UsuarioDTO("Rene", "Hernandez Ramirez", 36, new ArrayList<String>(Arrays.asList("Ingeniero")), false));
    	usuarios.add(new UsuarioDTO("Rene", "Hernandez Ramirez", 36, new ArrayList<String>(Arrays.asList("Developer")), false));
    	
//    	Conexión al Servidor de MongoDB
//    	MongoClient mongoClient = new MongoClient();

    	
//    	CRUD Insertamos los objetos futbolistas (o documentos a Mongo) en la colección futbolista
    	for (@SuppressWarnings("unused") UsuarioDTO usuario : usuarios) {
//			collection.insert(usuario.toDbObjectUsuario());
		}
    	
    	
//    	DAO leer
    	UsuarioDAO dao = new UsuarioDAO();
    	List<UsuarioDTO> leer = dao.leer();
    	System.out.println("Lectura de Usuarios");
    	for (UsuarioDTO dbObject : leer) {
			System.out.println(dbObject.toString());
		}
    	
    	
//    	Consulta por posiciones
    	DBCursor consulta = dao.consultaPosicion();
    	System.out.println("Consulta por profesiones");
    	for (DBObject dbObject : consulta) {
			System.out.println(dbObject.toString());
		}
    	
    	
//    	Actualizar edad  	
//    	dao.actualizar();
    	
    	
//    	Eliminar registro
//    	dao.eliminar();
    	
    	
//    	Cerrar la conexión
    	mongoClient.close();
    }
    
}
