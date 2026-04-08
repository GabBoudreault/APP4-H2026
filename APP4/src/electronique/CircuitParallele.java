package electronique;

import java.util.ArrayList;
import java.util.List;

public class CircuitParallele extends Circuit {
    public List<Composant> composants;

    public CircuitParallele(List<Composant> composants) {
        super();


    }


    @Override
    public double calculerResistance() {
        double resistance = 0;
        double total = 0;
        for (Composant composant : composants) {
            double response = composant.calculerResistance();
            double response2 = Math.pow(response, -1);
            total += response2;


        }
        resistance = Math.pow(total, -1);
        return resistance;
    }
}
