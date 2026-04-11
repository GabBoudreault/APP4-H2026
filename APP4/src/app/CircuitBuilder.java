package app;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import electronique.CircuitParallele;
import electronique.CircuitSerie;
import electronique.Composant;
import electronique.Resistance;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CircuitBuilder {
    public CircuitBuilder() {

    }

    public Composant construireCircuit(String cheminFichier) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode jsonNode = mapper.readTree(new File(cheminFichier));

            return lireComposant(jsonNode);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }








    private Composant lireComposant(JsonNode  jsonNode) throws IOException {
        String type = jsonNode.get("type").asText();

        if (Objects.equals(type, "resistance")) {

            return new Resistance(jsonNode.get("valeur").asDouble());

        } else if (Objects.equals(type, "serie")) {

            List<Composant> listecomposants = new ArrayList<>();

            for (JsonNode composantNode : jsonNode.get("composants")) {
                listecomposants.add(construireCircuit(String.valueOf(composantNode)));

            }
            return new CircuitSerie(listecomposants);


        } else {
            List<Composant> listecomposants = new ArrayList<>();
            for (JsonNode composantNode : jsonNode.get("parallele")) {
                listecomposants.add(construireCircuit(String.valueOf(composantNode)));
            }
            return new CircuitParallele(listecomposants);
        }


    }
}



