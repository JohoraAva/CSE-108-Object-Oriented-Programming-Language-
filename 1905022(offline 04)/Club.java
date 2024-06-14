public class Club
{
    private int id;
    private String name=new String();
    private int score=0;

    public void setId(int i)
    {
        id=i;
    }
    public void setName(String s)
    {
        name=s;
    }

    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }

    public void score(int n)
    {
        score+=n;

    }
    public void setScore(int n)
    {
        score=n;
    }
    public int getScore()
    {
        return score;
    }

    public void reset()
    {
        score=0;
    }
}