package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import Server.LoginDTO;
import java.io.IOException;

import static sample.Main.clubList;

public class Controller {
    Main main;
    @FXML
    private Label nameLabel;

    @FXML
    private Label passLabel;

    @FXML
    private TextField nameText;

    @FXML
    private PasswordField pas;

    @FXML
    private Button SinginBut;

    @FXML
    private Button SignupBut;
    @FXML
    private ImageView img;
    @FXML
    private Button resetBut;


    @FXML
    void reset(ActionEvent event)
    {
        nameText.setText(null);
        pas.setText(null);
    }

    @FXML
    void SignIn(ActionEvent event)
    {
        String userName = nameText.getText();
        String password = pas.getText();
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName(userName);
        loginDTO.setPassword(password);

        try {
            main.getNetworkUtil().write(loginDTO);
            System.out.println( nameText.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SignUp(ActionEvent event)
    {
        try {
            main.RegisterPage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void load()
    {
        Image i= new Image(Main.class.getResourceAsStream("fifa.jpg"));
        img.setImage(i);
    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Password");
        alert.setHeaderText("Incorrect Password");
        alert.setContentText("The password you provided is not correct.");
        alert.showAndWait();

    }
    public void ShowAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Username");
        alert.setHeaderText("Incorrect username");
        alert.setContentText("The username you provided is not correct.");
        alert.showAndWait();
    }

    public void setMain(Main main)
    {
        this.main=main;
    }
}
