package ui.medcontrol.Login;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import ui.medcontrol.Caretaker.MainCaretakerWindow;
import ui.medcontrol.Patient.PatientWindow;

import java.util.Objects;

public class LoginWindow {

    private final Stage stage;
    private final LoginController controller;

    Image logo = new Image(Objects.requireNonNull(Objects.requireNonNull(getClass().getResource("/images/canvas.png")).toExternalForm()));
    ImageView logoView = new ImageView(logo);

    Image patientPic = new Image(Objects.requireNonNull(getClass().getResource("/images/patient.jpg")).toExternalForm());
    ImageView patientPicView = new ImageView(patientPic);

    Button patientButton = new Button("Entrar");
    TextField patientName = new TextField();

    Button caretakerButton = new Button("Entrar");
    TextField caretakerName = new TextField();
    TextField caretakerLogin = new TextField();

    Button closerButton = new Button("Closer");


    Image caretakerPic = new Image(Objects.requireNonNull(getClass().getResource("/images/careTaker.jpg")).toExternalForm());
    ImageView caretakerPicView = new ImageView(caretakerPic);

    Circle clip = new Circle(100);

    public LoginWindow(Stage stage) {

        this.stage = stage;
        this.controller = new LoginController(stage, this, patientButton, caretakerButton, patientName, caretakerName, caretakerLogin);

    }


    public void show() {


        clip.setCenterY(100);
        clip.setCenterX(100);

        logoView.setFitWidth(275);
        logoView.setFitHeight(275);
        logoView.setPreserveRatio(true);
        logoView.setSmooth(true);

        patientButton.setId("patient");
        patientButton.setOnAction(e -> {
            controller.onButtonClick(patientButton);

        });


        patientPicView.setFitWidth(225);
        patientPicView.setFitHeight(225);
        patientPicView.setPreserveRatio(true);
        patientPicView.setSmooth(true);



        caretakerButton.setId("caretaker");
        caretakerButton.setOnAction(e -> {
            controller.onButtonClick(caretakerButton);
        });

        caretakerPicView.setFitWidth(225);
        caretakerPicView.setFitHeight(225);
        caretakerPicView.setPreserveRatio(true);
        caretakerPicView.setSmooth(true);
        caretakerPicView.setClip(clip);

        BorderPane root = new BorderPane();
        HBox topBar = new HBox(logoView);
        topBar.setAlignment(Pos.CENTER);
        GridPane midInfo = new GridPane();
        HBox botBar = new HBox(25);

        //Patient side of formatting
        midInfo.add(patientPicView, 0, 0);
        midInfo.add(patientName, 0, 1);
        midInfo.add(patientButton, 0, 2);

        //Caretaker side of formatting
        midInfo.add(caretakerPicView, 1, 0);
        midInfo.add(caretakerName, 1, 1);
        midInfo.add(caretakerButton, 1, 3);
        midInfo.add(caretakerLogin, 1, 2);

        midInfo.setAlignment(Pos.CENTER);
        midInfo.setAlignment(Pos.CENTER);

        midInfo.setHgap(10);
        midInfo.setVgap(10);

        root.setTop(topBar);
        root.setCenter(midInfo);
        root.setBottom(botBar);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();


    }

}
