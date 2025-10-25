package ui.medcontrol.Caretaker;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Objects;

public class MainCaretakerWindow{

    private final Stage stage;
    private final MainCaretakerController controller;
    private final String caretakerName, caretakerPassword;

    Image logo = new Image(Objects.requireNonNull(getClass().getResource("/images/canvas.png")).toExternalForm());
    ImageView logoView = new ImageView(logo);

    public MainCaretakerWindow(Stage stage, String careUser, String carePass){
        caretakerName = careUser;
        caretakerPassword = carePass;
        stage.close();
       this.stage = stage;
       this.controller = new MainCaretakerController();
    }

    public void show() {

        // Styling operations

        logoView.setFitHeight(275);
        logoView.setFitWidth(275);
        logoView.setPreserveRatio(true);
        logoView.setSmooth(true);


        stage.close();

        stage.setTitle("Caretaker");
        stage.setResizable(false);
        stage.centerOnScreen();

        BorderPane root = new BorderPane();

        HBox topbar = new HBox(logoView);
        topbar.setAlignment(Pos.CENTER);

        GridPane middleBar = new GridPane();
        middleBar.setHgap(10);
        middleBar.setVgap(10);

        HBox botBar = new HBox(15);


        root.setTop(topbar);
        root.setCenter(middleBar);
        root.setBottom(botBar);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Caretaker");


        if (caretakerName.equals("MAIN") && caretakerPassword.equals("MAIN")) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Caretaker");
            alert.setHeaderText(null);
            alert.setContentText("LOGGED IN AS CARETAKER ->" + caretakerName);
            alert.showAndWait();
            stage.show();

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Caretaker");
            alert.setHeaderText(null);
            alert.setContentText("INVALID LOGGED IN");
            alert.showAndWait();
            stage.close();

        }


    }


}
