package plates;

public class Cat {
    private String name;
    private int appetite;
    private boolean bellyful;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.bellyful = false;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) bellyful = true;
    }

    @Override
    public String toString() {
        return "Cat: " + name + "; bellyful: " + bellyful;
    }
}
