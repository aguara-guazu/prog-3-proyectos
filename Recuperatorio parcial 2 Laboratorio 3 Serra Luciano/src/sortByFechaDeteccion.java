import java.util.Comparator;

public class sortByFechaDeteccion implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getFechaDeteccion().compareTo(o2.getFechaDeteccion());
    }
}
