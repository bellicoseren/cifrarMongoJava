package mx.com.bellicose.usuario_cifrado_mongo;

import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import mx.com.bellicose.usuario_cifrado_mongo.dao.PortabilidadRegDAO;
import mx.com.bellicose.usuario_cifrado_mongo.dao.Tarjeta75DAO;
import mx.com.bellicose.usuario_cifrado_mongo.dto.PortabilidadRegDTO;
import mx.com.bellicose.usuario_cifrado_mongo.dto.Tarjeta75DTO;
import mx.com.bellicose.usuario_cifrado_mongo.util.Cifrado;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String clave = "1111111111111111";
    	String vi = "1111111111111111";
    	MongoClient mongoClient = new MongoClient();
    	DBCollection collection = null;
    	DBCollection collection1 = null;
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB("cifrada");
//		collection = db.getCollection("Aclaraciones_Bines");
		collection1 = db.getCollection("Bines_C");
    	    	
    	
//    	DAO leer
    	PortabilidadRegDAO dao = new PortabilidadRegDAO();
//    	long inicia = System.currentTimeMillis();
    	List<PortabilidadRegDTO> leer = dao.leer();
//    	System.out.println("Lectura de Usuarios");
    	for (PortabilidadRegDTO dbObject : leer) {
    		try {
//				dbObject.setDescripcion(Cifrado.cifrar(clave, vi, dbObject.getDescripcion()));
//    			dbObject.setDescripcion(Cifrado.decifrar(clave, vi, dbObject.getDescripcion()));
//    			dbObject.setDescripcion(dbObject.getDescripcion());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//    		System.out.println("desc..." +  dbObject.getDescripcion());
//    		collection1.insert(dbObject.toDbObjectPortabilidadReg());
    		//dao.agregar(dbObject);
//			System.out.println(dbObject.toString());
//    		long termina = System.currentTimeMillis() - inicia;
		}   	
//    	collection = db.getCollection("Tarjetas_75");
    	collection1 = db.getCollection("Tarjetas_75_C");
    	
    	Tarjeta75DAO tarjeta75dao = new Tarjeta75DAO();
    	long inicia = System.currentTimeMillis();
    	List<Tarjeta75DTO> leerTarjeta = tarjeta75dao.leer();
    	for (Tarjeta75DTO tarjeta75dto : leerTarjeta) {
    		try {
//				tarjeta75dto.setNumero(Cifrado.cifrar(clave, vi, tarjeta75dto.getNumero()));
//				tarjeta75dto.setCp(Cifrado.cifrar(clave, vi, tarjeta75dto.getCp()));
//				tarjeta75dto.setEmail(Cifrado.cifrar(clave, vi, tarjeta75dto.getEmail()));
//				tarjeta75dto.setCelular(Cifrado.cifrar(clave, vi, tarjeta75dto.getCelular()));
//				tarjeta75dto.setRfc(Cifrado.cifrar(clave, vi, tarjeta75dto.getRfc()));
    			
				tarjeta75dto.setNumero(Cifrado.decifrar(clave, vi, tarjeta75dto.getNumero()));
				tarjeta75dto.setCp(Cifrado.decifrar(clave, vi, tarjeta75dto.getCp()));
				tarjeta75dto.setEmail(Cifrado.decifrar(clave, vi, tarjeta75dto.getEmail()));
				tarjeta75dto.setCelular(Cifrado.decifrar(clave, vi, tarjeta75dto.getCelular()));
				tarjeta75dto.setRfc(Cifrado.decifrar(clave, vi, tarjeta75dto.getRfc()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			tarjeta75dto.setRfc(tarjeta75dto.getRfc());
//			collection1.insert(tarjeta75dto.toDbObjectTarjeta75DTO());
			System.out.println(tarjeta75dto.toString());
		}
    	long termina = System.currentTimeMillis() - inicia;
    	System.out.println("Tiempo total: " + termina);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//    	Consulta por posiciones
//    	DBCursor consulta = dao.consultaPosicion();
//    	System.out.println("Consulta por profesiones");
//    	for (DBObject dbObject : consulta) {
//			System.out.println(dbObject.toString());
//		}
    	
    	
//    	Actualizar edad  	
//    	dao.actualizar();
    	
    	
//    	Eliminar registro
//    	dao.eliminar();
    	
    	
//    	Cerrar la conexión
    	mongoClient.close();
    }
    
}
