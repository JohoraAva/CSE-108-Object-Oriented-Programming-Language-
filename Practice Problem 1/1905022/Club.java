public class Club {
    private int id;
    private String name;
    private Player[] players;
    // add your code here
    private int playerCount;

	// you are not allowed to write any other constructor
    public Club() {
        this.players = new Player[11];
    }

	public double getSalary() {
        double total = 0;
        for (int i = 0; i < playerCount; i++) {
            total += players[i].getSalary();
        }
        return total;
    }
    // add your code here
    public void setId(int i)
    {
        id=i;
    }

    public void setName(String s)
    {
        name=s;
    }

    public void addPlayer(Player player)
    {
        //players[playerCount]=new Player();
        players[playerCount++]=player;
    }

    public int getId()
    {
       return id;
    }

    public String getName()
    {
        return name;
    }

    public Player getMaxSalaryPlayer()
    {
        double maxSalary=players[0].getSalary();
        int index=0;
        for(int i=1;i<playerCount;i++)
        {
            if(players[i].getSalary()>maxSalary)
            {
                maxSalary=players[i].getSalary();
                index=i;
            }
        }
        return players[index];
    }
}