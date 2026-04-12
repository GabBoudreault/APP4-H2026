package electronique;

import java.util.ArrayList;
import java.util.List;

public class CircuitParallele extends Circuit {


    public CircuitParallele(List<Composant> composants) {
        this.composants =composants;


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
