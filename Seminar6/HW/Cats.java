package Seminar6.HW;

import java.util.Objects;

public class Cats {
    private String name;
    private String color;
    private String breed;
    private int age;
    private int prize;       

    public Cats(String Name, String Color, String Breed, int Age, int Prize){
        this.name = Name;
        this.color = Color;
        this.breed = Breed;
        this.age = Age;
        this.prize = Prize;
    }

    @Override
    public String toString() 
    {
        return String.format("%s-%s-%s-%d-%d", name, color, breed, age, prize);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(name, color, breed, age, prize);
    } 

    //identity verification (here I made mistake specially. I don't check "color" parameter rightly and "breed" parameter throw away)
    @Override
    public boolean equals(Object object) 
    {
        if (object == null || getClass() != object.getClass()) return false;
        if (this == object) return true;

        Cats cat = (Cats) object;
        return (name.equals(cat.name) || color.equals(cat.color)) && age == (cat.age) && prize == (cat.prize);
    }

    //prize comparison
    public boolean prizeComparison(Object object)
    {
        if (object == null || getClass() != object.getClass()) return false;
        if (this == object) return true;

        Cats cat = (Cats) object;
        return prize == (cat.prize);
    }    
}
