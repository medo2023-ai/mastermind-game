package loyalixa.oop.mastermindgame;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


public class LoadingScreen {
    public void showLoadingScreen(Stage primaryStage) {
        StackPane loading = new StackPane();
        loading.setStyle("-fx-background-color: #113A4F");

        Label label2 = new Label("please wait...");
        label2.setFont(new Font("Arial", 24));
        label2.setTextFill(Color.WHITE);
        label2.setStyle(
                "-fx-fill: linear-gradient(#ff0000, #8b0000); " +
                        "-fx-stroke: black; " +
                        "-fx-stroke-width: 3; " +
                        "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.8), 10, 0.5, 0, 5); -fx-font-weight: bold; -fx-font-size: 24px;"
        );

        Circle c1 = new Circle(10, Color.WHITE);
        Circle c2 = new Circle(10, Color.WHITE);
        Circle c3 = new Circle(10, Color.WHITE);

        HBox h1 = new HBox(15, c1, c2, c3);
        h1.setStyle("-fx-alignment: center");

        createAnimation(c1, 0).play();
        createAnimation(c2, 200).play();
        createAnimation(c3, 400).play();

        VBox v2 = new VBox(10, h1, label2);
        v2.setStyle("-fx-alignment: center");
        loading.getChildren().add(v2);

        Scene s1 = new Scene(loading, 800, 600);
        primaryStage.setScene(s1);

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
            javafx.application.Platform.runLater(() -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("master_mind.fxml"));
                    Parent root = loader.load();

                    // الحصول على الـ Stage الحالي
                    Stage primaryStage1 = (Stage) loading.getScene().getWindow();

                    // إنشاء مشهد جديد
                    Scene gameScene = new Scene(root);
                    primaryStage1.setScene(gameScene); // تبديل المشهد
                    primaryStage1.show();
                } catch (IOException e) {
                    System.out.println("IOException");
                }
            });
        }).start();
    }

    private TranslateTransition createAnimation(Circle circle, int delay) {
        TranslateTransition animation = new TranslateTransition(Duration.millis(800), circle);
        animation.setByY(10);
        animation.setCycleCount(TranslateTransition.INDEFINITE);
        animation.setAutoReverse(true);
        animation.setDelay(Duration.millis(delay));
        return animation;
    }
}

