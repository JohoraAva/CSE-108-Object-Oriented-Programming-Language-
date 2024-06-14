package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

import static sample.Main.ClubExists;
import static sample.Main.clubList;

public class Registerpage {
    private Main main;


        @FXML
        private Label title;

        @FXML
        private Label nameLabel;

        @FXML
        private Label passLabel;

        @FXML
        private TextField nameText;

        @FXML
        private PasswordField pas;
        @FXML
        private Button backBut;

        @FXML
        private Button signUpBut;

        @FXML
        private Button ResetBut;

        @FXML
        private Label passLabel1;

        @FXML
        private PasswordField pas1;

        @FXML
        void signUp(ActionEvent event)
        {
            if(ClubExists(nameText.getText()))
            {
                ShowAlert();
                nameText.setText(null);
            }
            else if(!pas.getText().equals(pas1.getText()))
            {
                ShowAlertPass();
                pas.setText(null);
                pas1.setText(null);
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Registration completed successfully");
                alert.setTitle("Success");
                alert.setContentText(" Your registration is completed successfully.");

                alert.showAndWait();
                addClub();

            }
        }

    private void addClub()
    {
        Club c=new Club();
        c.setName(nameText.getText());
        c.setPas(pas.getText());
        clubList.add(c);
        try {
            AllFile.readFromFile();
            AllFile.writeToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ShowAlertPass()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Password mismatch");
        alert.setHeaderText("Invalid Password");
        alert.setContentText("Yor password doesn't match. Please try again");
        alert.showAndWait();
    }

    private void ShowAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Username");
        alert.setHeaderText("Invalid username");
        alert.setContentText("The username is already exists. Use a different one");
        alert.showAndWait();
    }

    @FXML
        void reset(ActionEvent event)
        {
            nameText.setText(null);
            pas.setText(null);
            pas1.setText(null);
        }



    public void setMain(Main main)
    {
        this.main=main;
    }
    @FXML
    void Goback(ActionEvent event)
    {
        try {
            main.mainpage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
