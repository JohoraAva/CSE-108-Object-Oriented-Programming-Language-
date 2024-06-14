import javafx.fxml.FXMLLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Info
{
  //  public static HashMap<String,String> clientInfo=new HashMap<String,String>();

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

      //  for()
    }

}
