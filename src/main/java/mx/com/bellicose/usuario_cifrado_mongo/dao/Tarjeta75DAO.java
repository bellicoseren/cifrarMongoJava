package mx.com.bellicose.usuario_cifrado_mongo.dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import mx.com.bellicose.usuario_cifrado_mongo.Utils;
import mx.com.bellicose.usuario_cifrado_mongo.dto.Tarjeta75DTO;

public class Tarjeta75DAO {
	private MongoClient mongoClient = new MongoClient();
	private DBCursor cursor = null;
	private DBCollection collection = null;
	
	public List<Tarjeta75DTO> leer() {
	
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB("cifrada");
		collection = db.getCollection("Tarjetas_75_C");
		
		List<Tarjeta75DTO> list = new ArrayList<>();
		
		int numDocs = (int) collection.getCount();
		System.out.println("Hay " + numDocs + " documentos en la colección");
		
		cursor = collection.find();
		
		try {
			while(cursor.hasNext()){
				DBObject dbObject = cursor.next();
				list.add((Tarjeta75DTO) Utils.fromDBObject(dbObject, Tarjeta75DTO.class));
			}
		} finally {
			cursor.close();
		}
		return list;
	}
	
	@SuppressWarnings("deprecation")
	public void agregar(Tarjeta75DTO tarjeta75dto){
		DB db = mongoClient.getDB("cifrada");
		collection = db.getCollection("Tarjetas_75");
		
		collection.insert(tarjeta75dto.toDbObjectTarjeta75DTO());
		System.out.println("Registro agregado");
	}
}
