

import util.NetworkUtil;

import java.util.Scanner;

public class Client {

    public Client(String serverAddress, int serverPort) {
        Menue();
        try {
            System.out.print("Enter name of the client: ");
            Scanner scanner = new Scanner(System.in);
            String clientName = scanner.nextLine();
            NetworkUtil networkUtil = new NetworkUtil(serverAddress, serverPort);
            networkUtil.write(clientName);
            new ReadThreadClient(networkUtil);
            new WriteThreadClient(networkUtil, clientName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void Menue()
    {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. GetList");
        System.out.println("4. SendOne");
        System.out.println("5. Broadcast");
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        if(n==1)
        {
            Server.Register();
        }
        if(n==2)
        {
            //Info.Register();

        }


    }

    public static void main(String args[]) {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        Client client = new Client(serverAddress, serverPort);
    }
}


