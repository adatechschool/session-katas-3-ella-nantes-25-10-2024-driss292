import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        try {

            // Je récupère et je parse le contenu du fichier pokemon.json
            Object pokemons = new JSONParser().parse(new FileReader("pokemon.json"));

            // Fichier JSON de tests
            // Object pokemons = new JSONParser().parse(new FileReader("test.json"));

            // Je cast l'objet pokemon en objet JSON
            JSONObject pokemonToJson = (JSONObject) pokemons;

            // Je récupère le contenu du tableau JSON via la clé de ce dernier ("pokemon")
            JSONArray pokemonArray = (JSONArray) pokemonToJson.get("pokemon");

            // J'affiche de nombre de pokémons dans le fichier
            System.out.println("Il y a " + pokemonArray.size() + " pokémons dans le fichier JSON.");

            // Je boucle sur le tableau pokemonArray
            for (int i = 0; i < pokemonArray.size(); i++) {
                JSONObject poke = (JSONObject) pokemonArray.get(i);

                for (Object key : poke.keySet()) {
                    String keyStr = (String) key;
                    Object value = poke.get(keyStr);

                    System.out.println(keyStr + " : " + value);

                }
            }

            // Je boucle sur le tableau pokemonArray pour ne récupérer que les pokemons
            // ayant un poids supérieur à 10kg
            for (Object pokemon : pokemonArray) {

                JSONObject poke = (JSONObject) pokemon;

                // Extraction et conversion du poids
                String weightKey = (String) poke.get("weight");

                // Je "supprime" l'unité de mesure pour effectuer la condition de filtre
                double weight = Double.parseDouble(weightKey.replace(" kg", ""));

                // Filtre des Pokémon avec poids > 10
                if (weight > 10) {
                    // Affiche les informations du Pokémon
                    System.out.println("Nom : " + poke.get("name"));
                    System.out.println("Poids : " + weightKey);
                    System.out.println("================================");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
