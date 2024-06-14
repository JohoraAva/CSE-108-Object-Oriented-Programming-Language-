public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public String toString()
    {
        return name+ " is a "+getClass().getName()+", aged "+age;
    }
}