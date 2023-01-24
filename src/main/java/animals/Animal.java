package animals;

import java.util.Calendar;

public abstract class Animal {
    Kind kind;
    public String name;
    public Calendar birth;
    public Integer counter;

    public Animal(Kind kind, String name, Calendar birth) {
        this.kind = kind;
        this.name = name;
        this.birth = birth;
    }

    public Animal(String name, Calendar birth) {
        this.name = name;
        this.birth = birth;
        this.kind=Kind.ANIMAL;
    }

    public Animal() {
        this.kind = Kind.ANIMAL;
    }
}

