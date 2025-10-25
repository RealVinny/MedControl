package ui.medcontrol.Login;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.medcontrol.Caretaker.MainCaretakerWindow;
import ui.medcontrol.Patient.PatientWindow;

import java.awt.*;

public class LoginController {

    private final LoginWindow window;
    private final Button patientBut;
    private final Button caretakerBut;
    private final TextField patientName;
    private final TextField caretakerName;
    private final TextField caretakerLogin;
    private final Stage stage;


    public LoginController(Stage stage, LoginWindow lWindow, Button patBut, Button carBut, TextField patName, TextField carName, TextField carLog) {

        this.stage = stage;
    this.window = lWindow;
    this.patientBut = patBut;
    this.caretakerBut = carBut;
    this.patientName = patName;
    this.caretakerName = carName;
    caretakerLogin = carLog;

    }

    public void patientLogin(String patName, String patPassword){
        PatientWindow patWin = new PatientWindow();
        patWin.show();
    }

    public void caretakerLogin(Stage stage, String caretakerName, String caretakerPassword) {
        MainCaretakerWindow carWin = new MainCaretakerWindow(stage, caretakerName, caretakerPassword);
            carWin.show();
    }

        public void onButtonClick(Button btn) {
        if (btn.getId().equals("patient")) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(patientName.getText());
            alert.setTitle("Login de paciente!");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else if(btn.getId().equals("caretaker")) {
            caretakerLogin(stage, caretakerName.getText(), caretakerLogin.getText());

        }else{
            System.out.println(btn.getId());
        }

    }





}
