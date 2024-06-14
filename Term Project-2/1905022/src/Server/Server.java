package Server;


import sample.AllFile;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import static sample.Main.clubList;


public class Server {

    private ServerSocket serverSocket;
    HashMap<String, String> clubs= new HashMap<String, String>();
    private HashMap<String, ClubInfo> clubInfo= new HashMap<String, ClubInfo>();
    Server() {
        clubs=makeTheMap();
        System.out.println(clubs.size()+" "+clubs.get("liver234"));
        try {
            serverSocket = new ServerSocket(44444);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("server.Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
       // new ReadThreadServer( clubs,networkUtil);
        new ReadThreadServer( clubInfo,networkUtil);
        System.out.println("after serve "+clubs.get("Liverpool"));
    }


    private  HashMap<String,String> makeTheMap()
    {
        HashMap<String,String> clubs=new HashMap<String,String>();
        for(int i=0;i<clubList.size();i++)
        {
            clubs.put(clubList.get(i).getName(),clubList.get(i).getPas());
        }
        return clubs;
    }
    public static void main(String args[])
    {
        System.out.println("main server");
        try {
            AllFile.readFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(clubList.size());
        Server server = new Server();
    }
}
