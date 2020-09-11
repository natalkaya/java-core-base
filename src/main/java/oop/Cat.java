package oop;

public class Cat extends Animal{

    public Cat(String name) {
        super(name, 200, 0);
    }

    @Override
    public void swim(Integer distance) {
        System.out.printf("\nCat %s can't swim", this.name);
    }
}
