package electronique;

import java.util.ArrayList;
import java.util.List;

public class CircuitSerie extends Circuit {
    public List<Composant> composants;
    public CircuitSerie(List<Composant> list) {
        super();



    }

    @Override
    public  double calculerResistance() {
        double sommeDesResistances = 0;
        for (Composant composant:composants){

            sommeDesResistances += composant.calculerResistance();}
        return sommeDesResistances;
    }
}
