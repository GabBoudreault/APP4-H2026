package app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import electronique.Circuit;
import electronique.CircuitSerie;
import electronique.Composant;
import electronique.Resistance;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CircuitApp {
    public CircuitApp() {

    }

    public static void main(String[] args) {
        System.out.println("---Bonjour, choisissez un fichier Json----");
        System.out.println("----> [1]: Complexe_industriel_nord\n" + "----> [2]: Eclairage_public\n" + "----> [3]: reseau_secours");
        Scanner scanner = new Scanner(System.in);
        int reponse = scanner.nextInt();




        if (reponse == 1)
            try {
                FileReader fileReader1 = new FileReader("src/donnees/fichiers_json/complexe_industriel_zone_nord.json");
                CircuitBuilder circuitBuilder = new CircuitBuilder();
                Composant circuit = circuitBuilder.construireCircuit("src/donnees/fichiers_json/complexe_industriel_zone_nord.json");
                double resistance = circuit.calculerResistance();
                System.out.println("Résistance équivalente du dossier #1 est = "+resistance+" ohms.");





                fileReader1.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        else if (reponse == 2) {
            try {
                FileReader fileReader2 = new FileReader("src/donnees/fichiers_json/eclairage_public_quartier.json");
                CircuitBuilder circuitBuilder =new CircuitBuilder();
                Composant circuit = circuitBuilder.construireCircuit("src/donnees/fichiers_json/eclairage_public_quartier.json");
                double resistance = circuit.calculerResistance();
                System.out.println("Résistance équivalente du dossier #2 est = "+resistance+" ohms.");

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        } else if (reponse == 3) {


            try {
                FileReader fileReader3 = new FileReader("src/donnees/fichiers_json/reseau_secours_hopital.json");
                CircuitBuilder circuitBuilder = new CircuitBuilder();
                Composant circuit = circuitBuilder.construireCircuit("src/donnees/fichiers_json/reseau_secours_hopital.json");
                double resistance = circuit.calculerResistance();
                System.out.println("Résistance équivalente du dossier #3 est = "+resistance+" ohms.");


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Entrez un chiffre entre 1 et 3.");

        }


    }
}
