import java.util.Comparator;

public class sortByMac implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getMac().compareTo(o2.getMac());
    }
}
