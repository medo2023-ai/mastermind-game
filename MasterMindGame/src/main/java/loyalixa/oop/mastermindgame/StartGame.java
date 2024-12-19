package loyalixa.oop.mastermindgame;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StartGame {
public VBox createstartpage(Stage primaryStage) {
    Label label1 = new Label("Mastermind");
    Label label2 = new Label("Unlock the mysteries of the Brain");
    label2.setStyle("-fx-font-size: 30;-fx-font-weight: bold; -fx-color:#CFCDC3");
    label1.setFont(new Font("Arial", 48));
    label1.setId("mastermind");
    label1.setStyle("-fx-font-size: 48px;" +
            "    -fx-font-weight: bold;" +
            "    -fx-text-fill: linear-gradient(to right, #FFD700, #FF8C00);" +
            "    -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 10, 0.5, 0, 0);");
    TranslateTransition animation = new TranslateTransition();
    animation.setNode(label1);
    animation.setByY(20);
    animation.setDuration(Duration.seconds(1));
    animation.setCycleCount(TranslateTransition.INDEFINITE);
    animation.setAutoReverse(true);
    animation.play();
    Button button1 = new Button("Start game");
    button1.setId("buuton");
    button1.setStyle(
            "-fx-background-color: linear-gradient(#1e3c72, #2a5298); " +
                    "-fx-text-fill: white; " +
                    "-fx-font-size: 16px; " +
                    "-fx-font-family: 'Arial', sans-serif; " +
                    "-fx-padding: 10 20; " +
                    "-fx-border-radius: 10; " +
                    "-fx-background-radius: 10; " +
                    "-fx-border-color: #ffffff; " +
                    "-fx-border-width: 2; " +
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 5, 0, 0, 2); " +
                    "-fx-cursor: hand; " +
                    "-fx-translate-y: 2px;");

    LoadingScreen ref = new LoadingScreen();
    button1.setOnAction(e -> {

        ref.showLoadingScreen(primaryStage);

    });
    VBox vbox1= new VBox(30);
    vbox1.getChildren().addAll(label1,label2,button1);
    vbox1.setStyle("-fx-alignment:center; -fx-padding:100px;");
    return vbox1;


}

    }
