package animals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Cat extends Animal{
    public List <Cat> catList=new ArrayList<>();



    public Cat(String name, Calendar birth) {
        super(name, birth);
        kind=Kind.CAT;
    }


    public Cat() {
        kind=Kind.CAT;
    }

    public Integer infoCatList () {
         return catList.size();
    }
}
