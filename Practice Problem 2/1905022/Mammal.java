public class Mammal extends Animal
{
    public Mammal(String name,int age)
    {
        super(name,age);
    }
    public void printBloodType()
    {
        //if(getClass().getName()=="Mammal")
        System.out.print(", Warm-Blooded!");
    }
}
