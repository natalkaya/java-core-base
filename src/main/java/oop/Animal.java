package oop;

abstract public class Animal {
    protected String name;
    protected Integer maxRunDistance;
    protected Integer maxSwimDistance;

    public Animal(String name, Integer maxRunDistance, Integer maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    public void run(Integer distance) {
        if (distance >= maxRunDistance) {
            System.out.printf("\n%s runs %d m", this.name, distance);
        } else {
            System.out.printf("\nDistance %d is too much, max running distance for %s: %d", distance, this.name,
                    this.maxRunDistance);
        }
    }
    public void swim(Integer distance) {
        if (distance >= maxRunDistance) {
            System.out.printf("\n%s swims %d m", this.name, distance);
        } else {
            System.out.printf("\nDistance %d is too much, max swimming distance: %d", distance, this.maxRunDistance);
        }
    }
}
