public class League {
    private Match[] matches;
    private int matchCount;
    private int clubCount;
    // add your variables here, if required
    private String name=new String();
    private Club []clubs;

    public League() {
        // assume a league can have at most 5 clubs, add code for initialization accordingly
        clubCount = 0;
        matchCount = 0;
        clubs= new Club[5];
    }
    public void printLeagueInfo(){
        System.out.println("League : " + name);
        printClubs();
    }

    public void printClubs(){
        System.out.println("Clubs:");
        // print the name of the clubs of this league, each one on a line
        for(int i= 0; i<clubCount;i++)
            System.out.println(clubs[i].getName());
    }

    public void scheduleMatches(){
        matchCount = (clubCount*(clubCount-1));
        matches = new Match[matchCount];
        int matchNo = 0;
        int k=0;
        for (int i=0; i<clubCount; i++){
            for (int j=0; j<clubCount ; j++){
                // check the constructor of the Match class and add your code here
                if(i!=j)
                    matches[k++]=new Match(++matchNo,clubs[i],clubs[j]);
                // note that there will be two matches between club A and club B
                // in the first match, club A will play as the home team and in the second match, as the away team
            }
        }
    }

    public void simulateMatches(){
        for (int i=0; i<matchCount; i++){
            matches[i].play();
        }
    }

    public void showStandings(){
        // sort the clubs in descending order of points
        // note that, the sequence in which clubs were added to the league, should be unchanged
        // check the given sample output for clarification
        // (carefully observe the output of showStandings() followed by printLeagueInfo() method calls
        // you can use additional arrays if needed
        // print the clubs in descending order of points

        Club []tempClubs=new Club[clubCount];
        for (int i=0; i<clubCount; i++)
            tempClubs[i]=clubs[i];

        for (int i=0; i<clubCount; i++)
        {
            for (int j = i+1; j < clubCount; j++)
            {
                if(tempClubs[j].getScore()>tempClubs[i].getScore())
                {
                    Club temp=new Club();
                    temp=tempClubs[i];
                    tempClubs[i]=tempClubs[j];
                    tempClubs[j]=temp;

                }
            }
        }
        System.out.println("Sl. - Club - Points");
        for (int i=0; i<clubCount; i++)
            System.out.println(i+1 + ". " + tempClubs[i].getName()+" "+ tempClubs[i].getScore());

    }



    // add your methods here, if required


    public void setName(String s)
    {
        name=s;
    }

    public void addClub(Club c)
    {
        clubs[clubCount++]=c;
    }

    public void removeClub(Club club)
    {
        int index=-1;
        for(int i=0;i<clubCount;i++)
        {
            if(clubs[i].getId()==club.getId())
            {
                index=i;
                break;
            }
        }

        for(int i=index;i+1<clubCount;i++)
        {
            clubs[i]=clubs[i+1];
        }
        clubCount--;

        for(int i=0; i<clubCount;i++)
        {
            clubs[i].reset();
        }


    }

    public void printMatches()
    {
        System.out.println("Matches:");
        for (int i=0; i<matchCount; i++){
            matches[i].showResult();
    }
}


}