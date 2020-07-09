/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author sidem
 */
public class Mongo {
    public static void main(String[] args) {
        /*try{
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            mongoClient.getDatabaseNames().forEach(System.out::println);

            DB db = mongoClient.getDB("teste");
            DBCollection coll = db.getCollection("tabela1");
            
            BasicDBObject doc = new BasicDBObject("title", "MongoDB").
            append("description", "database").
            append("likes", 100).
            append("url", "http://www.tutorialspoint.com/mongodb/").
            append("by", "tutorials point");
            coll.insert(doc);
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }*/
        
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("teste");
        //db.createCollection("Tabela2");
        MongoCollection collection = db.getCollection("Tabela2");
        Document obj1 = new Document();
		obj1.put("title", "MongoDB2");
		obj1.put("description", "database");
		obj1.put("gender", "male");
                obj1.put("likes", 100);
                obj1.put("url", "http://www.tutorialspoint.com/mongodb/");
                obj1.put("by", "tutorials point");
        
        collection.insertOne(obj1);
        
        
        
        //collection.insertOne(doc);
    }
}
