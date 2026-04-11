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
        double total = 0;
        for (Composant composant : composants) {
            double resistance = composant.calculerResistance();
            total += 1 /resistance;


        }

        return 1 /total;
    }
}
