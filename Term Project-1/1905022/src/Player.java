public class Player
{
    private String name,country,clubName,position;
    private int age,number;
    private double height,salary;

   /* public void Show()
    {
        System.out.println("Name  Country  Age  Height Club Name Position Salary");
        //ShowInfo();

    }*/
    @Override
    public String toString()
    {
        return "Name: "+name+" Country Name: "+country+" Age:"+age+" Height:"+height +" ClubName:"+ clubName+" Position:" +position+" Number:"+number+" Weekly Salary:"+salary;
    }
    public void setName(String s)
    {
        name=s;
    }
    public String getName()
    {
        return name;
    }
    public void setCountryName(String s)
    {
        country=s;
    }
    public String getCountryName()
    {
        return country;
    }
    public void setClubName(String s)
    {
        clubName=s;
    }
    public String getClubName()
    {
        return clubName;
    }
    public void setPosition(String s)
    {
        position=s;
    }
    public String getPosition()
    {
        return position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double  getSalary()
    {
        return salary;
    }

    public void setAge(int i)
    {
        age=i;
    }
    public int getAge()
    {
        return age;
    }

    public void setHeight(double d)
    {
        height=d;
    }
    public double getHeight()
    {
        return height;
    }

    public void setNumber(int n)
    {
        number=n;
    }
    public int getNumber()
    {
       return number;
    }
}

