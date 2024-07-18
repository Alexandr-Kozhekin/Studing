package Maps;

public class Groundhog2 extends Groundhog {

    public Groundhog2(int number) {
        super(number);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Groundhog2 && (number == ((Groundhog2)o).number);
    }

    @Override
    public int hashCode() {
        return number;
    }
}
