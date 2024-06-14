package sample;

import Server.NetworkUtil;
import Server.ReadThread;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    Stage stage;
    NetworkUtil nu;
    public static List<Player> playerList = new ArrayList();
    public static List<Club> clubList=new ArrayList();
    public static List<Country> countryList=new ArrayList();

    public static boolean flag=false;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        connectToServer();
        mainpage();

    }

    public void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 44444;
        nu = new NetworkUtil(serverAddress, serverPort);
        new ReadThread(this);
    }
    public NetworkUtil getNetworkUtil()
    {
        return nu;
    }

    public void mainpage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        // Loading the controller
        Controller controller = loader.getController();
        controller.setMain(this);
        controller.load();

        // Set the primary stage
        stage.setTitle("HomePage");
        //stage.
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
        stage.setOnCloseRequest(e-> System.exit(1));
    }
    public void showHomePage(String text) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Homepage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        HomePage controller = loader.getController();
        controller.setMain(this);
        controller.setSetTitle(text);
        controller.load();

        // Set the primary stage
        stage.setTitle("HomePage");
        stage.setScene(new Scene(root, 1100, 650));
        stage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }

    public void RegisterPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Registerpage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        Registerpage controller = loader.getController();
        controller.setMain(this);
        //controller.setSetTitle(text);

        // Set the primary stage
        stage.setTitle("Create New Account");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    public static boolean ClubExists(String s)
    {
        for(int i=0;i< clubList.size();i++)
        {
            if(clubList.get(i).getName().equalsIgnoreCase(s))
                return true;
        }
        return false;
    }


    public void ShowInfoPage(Player player) throws IOException {

        FXMLLoader loader = new FXMLLoader();


        loader.setLocation(getClass().getResource("InfoPage.fxml"));
        Parent root = loader.load();
        InfoPage controller = loader.getController();
        controller.setMain(this);
        controller.setPlayer(player);
        controller.load();

        stage.setTitle("Player Details ");
        stage.setScene(new Scene(root, 900, 650));
        stage.show();

    }


    public void ShowCnWisePlayerPage(String setTitle) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CnWisePlPage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        CnWisePlPage controller = loader.getController();
        controller.setMain(this);

        controller.setClubName(setTitle);

        controller.load();

        // Set the primary stage
        Stage stage=new Stage();
        stage.setTitle("ResultPage");
        stage.setScene(new Scene(root, 500, 410));
        stage.show();
    }

    public void BuyPage(String name) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MarketPage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        MarketPage controller = loader.getController();
        controller.setMain(this);

        controller.setClubName(name);

        controller.load();

        // Set the primary stage
        stage.setTitle("MarketPage");
        stage.setScene(new Scene(root, 900, 600));
        stage.show();
    }

    public void BuyPlayerInfoPage(Player p,String name) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("buyPlayerInfoPage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        BuyPlayerInfoPage controller = loader.getController();
        controller.setMain(this);

        controller.setPlayer(p);
        controller.load();
        controller.setName(name);
        stage.setTitle("Player Buy");
        stage.setScene(new Scene(root, 900, 630));
        stage.show();
    }




}