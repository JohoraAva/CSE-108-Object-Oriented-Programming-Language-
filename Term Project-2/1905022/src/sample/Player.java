package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable
{
    private String name,country,clubName,position;
    private int age,number;
    private double height,salary;

    private boolean isSold;
    private String exClubName;

    public static List<Player> exchangePlayerList=new ArrayList<Player>();


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
    public String getCountry()
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


    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public String getExClubName() {
        return exClubName;
    }

    public void setExClubName(String exClubName) {
        this.exClubName = exClubName;
    }


}

