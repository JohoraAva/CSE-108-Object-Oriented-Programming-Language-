package sample;

import java.io.*;

import static sample.Player.exchangePlayerList;

public class AllFile  extends Main
{
    public static final String FILE_NAME = "players.txt";
    private static final String Club_NAME = "clubs.txt";
    private static final String ExchangePlayer_NAME = "ExchangePlayer.txt";
    public static void  readFromFile() throws Exception {

        BufferedReader br1 = new BufferedReader(new FileReader(Club_NAME));
        while(true)
        {
            String line = br1.readLine();
            if (line == null) break;
            /// for clubList
            String[] tokens = line.split(",");
            Club c = new Club();
            c.setName(tokens[0]);
            c.setPas(tokens[1]);
            clubList.add(c);

        }
        br1.close();
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
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(Club_NAME));
        for (Player p : playerList) {
            bw.write(p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClubName() + "," + p.getPosition() + "," + p.getNumber() + "," + p.getSalary());
            bw.write("\n");
        }
        bw.close();
        for(Club c: clubList)
        {
            bw1.write(c.getName() + "," + c.getPas() );//
            bw1.write("\n");
        }
        bw1.close();
    }

}
