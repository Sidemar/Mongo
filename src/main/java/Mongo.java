import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import org.bson.conversions.Bson;

/**
 *
 * @author sidemar
 */
public class Mongo{
    public static void main(String[] args) {
        System.out.println("Criando uma conexão com o banco de dados MongoDB");
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("db1");
        
        System.out.println("Criando uma coleção no banco de dados db1");
        //db.createCollection("colecao1");
        
        System.out.println("Acessando a colecao1 no banco de dados db1");
        MongoCollection collection = db.getCollection("colecao1");
        
        System.out.println("Criando um documento");
        Document obj1 = new Document();
	obj1.put("titulo", "MongoDB com Java");
	obj1.put("descricao", "Crud com MongoDB e Java");
        obj1.put("url", "https://medium.com/@sidemar.r7/uma-introdu%C3%A7%C3%A3o-ao-mongodb-com-java-686c9126c762");
        
        System.out.println("Inserindo o documento");
        collection.insertOne(obj1);
        
        System.out.println("Consultando dos os objetos da coleção");
        FindIterable<Document> docs = collection.find();
        for (Document doc : docs) {
            System.out.println(doc.toString());
        }
        
        System.out.println("Criando filtro para atualizar todos os objetos com titulo = MongoDB com Java");
        Bson filter = eq("titulo", "MongoDB com Java");
        
        System.out.println("Criando a query para mudar o titulo para MongoDB + Java");
        Bson updateOperation = set("titulo", "MongoDB + Java");
        
        System.out.println("Atualizando de fato o valor");
        UpdateResult updateResult = collection.updateOne(filter, updateOperation);
        
        System.out.println("Consultado novamente para verificar se os valores foram realmente alterados");
        docs = collection.find();
        for (Document doc : docs) {
            System.out.println(doc.toString());
        }
        
        System.out.println("Deletando o objeto");
        filter = eq("titulo", "MongoDB + Java");
        collection.findOneAndDelete(filter);
    }
}
