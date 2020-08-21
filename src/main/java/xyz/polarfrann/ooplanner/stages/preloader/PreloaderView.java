package xyz.polarfrann.ooplanner.stages.preloader;
/*
    PreloaderView class for OOPlanner
    Created on 21/08/2020 at 18:42
    by frann
*/

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PreloaderView {

    private Stage loadingStage;
    private ProgressBar progressBar;
    private Text loadingText;

    public void loadStageSettings() {
        loadingStage.initStyle(StageStyle.UNDECORATED);
        loadingStage.setResizable(false);
        loadingStage.toFront();
        loadingStage.setScene(addCss(createLoadingScene(), "/Preloader.css"));
        loadingStage.show();
        centerOnScreen();
    }
    private Scene addCss(Scene scene, String filePath) {
        scene.getStylesheets().add(getClass().getResource(filePath).toExternalForm());
        return scene;
    }

    private Scene createLoadingScene() {
        BorderPane rootBorder = new BorderPane();
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        rootBorder.setCenter(root);
        progressBar = new ProgressBar();
        root.getStyleClass().add("border-pane");
        progressBar.getStyleClass().add("progress-bar");
        loadingText = new Text("...");
        loadingText.getStyleClass().add("loading-text");
        root.getChildren().add(progressBar);
        root.getChildren().add(loadingText);
        return new Scene(rootBorder, 450, 100);
    }

    private void centerOnScreen() {
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        double xPos = (primScreenBounds.getWidth() - loadingStage.getWidth()) / 2;
        double yPos = (primScreenBounds.getHeight() - loadingStage.getHeight()) / 2;
        loadingStage.setX(xPos);
        loadingStage.setY(yPos);
    }

    public void setStage(Stage stage) {
        loadingStage = stage;
    }

    public Stage getLoadingStage() {
        return loadingStage;
    }

    public void setLoadingText(String text) {
        loadingText.setText(text);
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }
}
