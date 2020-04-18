import java.util.Comparator;

public class ComparePorPrecio implements Comparator<Mercaderia> {

    @Override
    public int compare(Mercaderia o1, Mercaderia o2) {
        if (o1.getPrecio() < o2.getPrecio()){
            return 1;
        }
        else if (o1.getPrecio() == o2.getPrecio()) {
            return 0;
        }
        else {
            return -1;
        }
    }
}
