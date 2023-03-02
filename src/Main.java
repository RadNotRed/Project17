public class Main {
    private int value;
    private boolean hasPenny;

    public Main(int value) {
        this.value = value;
        this.hasPenny = false;
    }

    public int getValue() {
        return value;
    }

    public boolean hasPenny() {
        return hasPenny;
    }

    public void addPenny() {
        hasPenny = true;
    }

    public void clear() {
        hasPenny = false;
    }

    @Override
    public String toString() {
        if (hasPenny) {
            return "P";
        } else {
            return Integer.toString(value);
        }
    }
}
