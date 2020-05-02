import java.util.Comparator;

public class OrdenarPorPrecio implements Comparator<Mercaderia> {
    @Override
    public int compare(Mercaderia o1, Mercaderia o2) {
        return Double.compare(o2.getPrecio(), o1.getPrecio());
    }
}
