package counter;

import animals.Animal;

public class CounterAnimal {
    public Integer counter = 0;

    public void add(Animal animal) {
        if (animal.name == null) {
            System.out.println("no name");
        } else {
            System.out.println("have name");
            counter++;
        }
    }
}
