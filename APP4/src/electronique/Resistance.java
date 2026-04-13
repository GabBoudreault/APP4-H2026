package electronique;

import java.rmi.server.RemoteRef;

public class Resistance extends Composant {
    private double resistance;
    public Resistance(double resistance){
        this.resistance = resistance;
    }



    @Override
    public double calculerResistance() {
        return resistance;
    }

    public double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        if(resistance >= 0){this.resistance = resistance;}
        else {
            throw new IllegalArgumentException("Résistance invalide");
        }

    }
}
