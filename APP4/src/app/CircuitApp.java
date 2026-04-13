package app;

import electronique.Composant;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CircuitApp {
    public CircuitApp() {

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String[] fichiersJson = {"APP4/donnees/fichiers_json/complexe_industriel_zone_nord.json",
                "APP4/donnees/fichiers_json/eclairage_public_quartier.json",
                "APP4/donnees/fichiers_json/reseau_secours_hopital.json"
        };

        int response = -1;
        while (response != 0) {
            System.out.println("Bonjour! Veuillez choisir un fichier Json.");
            System.out.println("-----> [1]- Complexe industriel de la zone nord");
            System.out.println("-----> [2]- Éclairage public du quartier");
            System.out.println("-----> [3]- Réseau de secours de l'hôpital");
            System.out.println("[0]- Quitter le programme.");
            response = scanner.nextInt();





            if (response >= 1 && response <= 3){
                try {String cheminFichier = fichiersJson[response-1];
                    CircuitBuilder circuitBuilder = new CircuitBuilder();
                    Composant circuit = circuitBuilder.construireCircuit(cheminFichier);
                    double resistance = circuit.calculerResistance();
                    System.out.println("La résistance du circuit est "+resistance+" ohms.");

                }catch (Exception e){
                    System.out.println("Fichier introuvable ou inconnu.");
                }

            }
            else if (response == 0){
                System.out.println("Vous avez quitter le programme. Merci!");
                scanner.close();
            }
            else {
                throw new InputMismatchException("Veuillez entrez un chiffre de 1 à 3.");
            }
        }


    }
}