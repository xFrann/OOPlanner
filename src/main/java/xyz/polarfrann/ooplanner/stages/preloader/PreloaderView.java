package xyz.polarfrann.ooplanner.stages.preloader;
/*
    PreloaderView class for OOPlanner
    Created on 21/08/2020 at 18:42
    by frann
*/

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PreloaderView {

    private Stage loadingStage;
    private ProgressBar progressBar;

    public void loadStageSettings() {
        loadingStage.initStyle(StageStyle.UNDECORATED);
        loadingStage.setResizable(false);
        loadingStage.toFront();
        loadingStage.setScene(createLoadingScene());
        loadingStage.show();
        centerOnScreen();
    }
    private Scene createLoadingScene() {
        BorderPane rootBorder = new BorderPane();
        progressBar = new ProgressBar();
        rootBorder.setCenter(progressBar);
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

    public ProgressBar getProgressBar() {
        return progressBar;
    }
}
