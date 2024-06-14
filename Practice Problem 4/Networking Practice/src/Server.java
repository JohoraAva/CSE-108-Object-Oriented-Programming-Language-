

import util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, NetworkUtil> clientMap;
    public static HashMap<String,String> clientInfo=new HashMap<String,String>();

    Server() {
        clientMap = new HashMap<>();
        try {
            serverSocket = new ServerSocket(33333);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        String clientName = (String) networkUtil.read();
        clientMap.put(clientName, networkUtil);
        new ReadThreadServer(clientMap, networkUtil);
    }
    public static void Register()
    {
        System.out.println("Enter name:");
        Scanner scn=new Scanner(System.in);
        String n=scn.nextLine();
        System.out.println("Enter Pass:");
        String pp=scn.next();
        clientInfo.put(pp,n);

    }
    public static void Login()
    {
        System.out.println("Enter name:");
        Scanner scn=new Scanner(System.in);
        String n=scn.nextLine();
        System.out.println("Enter Pass:");
        String pp=scn.next();
        for(String s: clientInfo.keySet())
        {
            if(!clientInfo.get(s).equals(pp))
                System.out.println("Wrong pass");
            else
            {
                //
            }
        }

    }

    public static void main(String args[]) {
        Server server = new Server();
    }
}
