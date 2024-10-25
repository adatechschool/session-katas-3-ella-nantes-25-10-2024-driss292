import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        try {

            Object pokemon = new JSONParser().parse(new FileReader("pokemon.json"));
            JSONObject pokemonToJson = (JSONObject) pokemon;
            JSONArray pokemonArray = (JSONArray) pokemonToJson.get("pokemon");

            System.out.println(pokemonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
