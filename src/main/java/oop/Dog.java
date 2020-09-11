package oop;

public class Dog extends Animal{

    public Dog(String name) {
        super(name, 500, 10);
    }

    @Override
    public void swim(Integer distanceInMeters) {
        System.out.printf("\nDog %s swims %d m", this.name, distanceInMeters);
    }

}
