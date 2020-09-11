package plates;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int n) {
        int temp = food - n;
        if (temp >= 0) {
            food -= n;
            return true;
        } else return false;
    }
    public void info() {
        System.out.println("plate: " + food);
    }

    public void add(int n) {
        food +=n;
    }
}
