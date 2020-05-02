package Universo;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class Punto{
    private double x;
    private double y;
    public Punto(){
        x = ThreadLocalRandom.current().nextDouble(-10,10);
        y = ThreadLocalRandom.current().nextDouble(-30,30);
    }
    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return String.format(Locale.US,"(%.1f,%.1f)", getX(), getY());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
