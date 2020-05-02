import java.util.Comparator;

public class sortByNroRegistro implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getNroRegistro() - o2.getNroRegistro();
    }
}
