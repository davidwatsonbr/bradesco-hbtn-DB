import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import java.util.Arrays;

public class UsuarioOperations {

    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Alice", 25);
        Usuario usuario2 = new Usuario("Bob", 30);
        Usuario usuario3 = new Usuario("Charlie", 35);
        MongoDBConnection connection = new MongoDBConnection();

        if (connection.getDatabase() != null) {
            try {
                MongoCollection<Document> collection = connection.getDatabase().getCollection("usuarios");

                System.out.println("Limpando coleção...");
                collection.deleteMany(new Document());

                System.out.println("\nInserindo registros de usuários...");
                collection.insertOne(usuario1.toDocument());
                collection.insertMany(Arrays.asList(usuario2.toDocument(), usuario3.toDocument()));

                System.out.println("\nListando usuários inseridos...");
                for(Document doc : collection.find()) {
                    System.out.println(Usuario.fromDocument(doc));
                }

                System.out.println("\nAtualizando idade Bob para 32 anos...");
                collection.updateOne(Filters.eq("nome", "Bob"), Updates.set("idade", 32));

                System.out.println("\nListando usuários após atualização de idade...");
                for(Document doc : collection.find()) {
                    System.out.println(Usuario.fromDocument(doc));
                }

                System.out.println("\nApagando o registro Charlie...");
                collection.deleteOne(Filters.eq("nome", "Charlie"));

                System.out.println("\nListando usuários após deleção de Charlie...");
                for(Document doc : collection.find()) {
                    System.out.println(Usuario.fromDocument(doc));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                connection.closeConnection();
            }
        }
    }
}
