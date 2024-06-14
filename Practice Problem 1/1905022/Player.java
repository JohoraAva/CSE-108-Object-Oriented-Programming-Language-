public class Player {
    private int number;
    private String name;
    private double salary;

	// you are not allowed to write any other constructor
    public Player(int number, String name) {
        setNumber(number);
        setName(name);
    }


    // add your code here
    private void setNumber(int number)
    {
        this.number=number;
    }
    private void setName(String name)
    {
        this.name=name;
    }
    public void setSalary(double v)
    {
        salary=v;
    }

    public double getSalary()
    {
        return salary;
    }


    public String getName()
    {
        return name;
    }

}
