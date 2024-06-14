import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class AllFile  extends Main
{
    private static final String FILE_NAME = "players.txt";
    public static void  readFromFile() throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        while(true)
        {
            String line = br.readLine();
            if (line == null) break;
            /// for clubList
            String[] tokens = line.split(",");
            if(!ClubExists(tokens[4])) {
                Club c = new Club();
                c.setName(tokens[4]);
                clubList.add(c);
            }

        }
        br.close();
        ///playerList
        ///
        BufferedReader br2 = new BufferedReader(new FileReader(FILE_NAME));
        while (true) {
            String line = br2.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            Player p = new Player();
            p.setName(tokens[0]);
            p.setCountryName(tokens[1]);
            p.setAge(Integer.parseInt(tokens[2]));
            p.setHeight(Double.parseDouble(tokens[3]));
            p.setClubName(tokens[4]);
            p.setPosition(tokens[5]);
            p.setNumber(Integer.parseInt(tokens[6]));
            p.setSalary(Double.parseDouble(tokens[7]));
            playerList.add(p);

        }
        br2.close();

        for(int i=0;i< playerList.size();i++)
        {
            for(int j=0;j< clubList.size();j++)
            {
                if(playerList.get(i).getClubName().equalsIgnoreCase(clubList.get(j).getName()))
                {
                    clubList.get(j).addPlayer(playerList.get(i));
                    break;
                }
            }
        }
        /*for(int i=0;i< clubList.size();i++)
            clubList.get(i).show();*/
        //return playerList;
    }

    public static void writeToFile() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));

        for (Player p : playerList) {
            bw.write(p.getName() + "," + p.getCountryName() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClubName() + "," + p.getPosition() + "," + p.getNumber() + "," + p.getSalary());
            bw.write("\n");
        }
        bw.close();
    }

    public static void ShowCountrywisePlayer() throws Exception
    {
        /// countryList
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        while(true)
        {
            String line = br.readLine();
            if (line == null) break;
                /// for clubList
            String[] tokens = line.split(",");
                if(!CountryExists(tokens[1])) {
                    Country c = new Country();
                    c.setName(tokens[1]);
                    countryList.add(c);
                }

        }
        br.close();
      /*  for(int i=0;i< countryList.size();i++)
            countryList.get(i).show();*/
        for(int i=0;i< playerList.size();i++)
        {
            for(int j=0;j< countryList.size();j++)
            {
                if(playerList.get(i).getCountryName().equalsIgnoreCase(countryList.get(j).getName()))
                {
                    countryList.get(j).playerCount++;
                    break;
                }
            }
        }
    }


}
