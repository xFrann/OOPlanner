package xyz.polarfrann.ooplanner.stages.preloader;
/*
    PreloaderView class for OOPlanner
    Created on 21/08/2020 at 18:42
    by frann
*/

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import xyz.polarfrann.ooplanner.stages.Decorator;

public class PreloaderView {

    private Stage loadingStage;
    private ProgressBar progressBar;
    private Text loadingText;

    public void loadStageSettings(Stage loadingStage) {
        this.loadingStage = loadingStage;

        loadingStage.setScene(addCss(createLoadingScene()));

        Decorator decorator = new Decorator(loadingStage);
        decorator.setPopupWindow();
        decorator.showStage();
        decorator.centerWindow();
    }
    private Scene addCss(Scene scene) {
        scene.getStylesheets().add(getClass().getResource("/Preloader.css").toExternalForm());
        return scene;
    }

    private Scene createLoadingScene() {
        //TODO Clean this up somehow
        BorderPane rootBorder = new BorderPane();
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        rootBorder.setCenter(root);
        progressBar = new ProgressBar();
        root.getStyleClass().add("border-pane");
        progressBar.getStyleClass().add("progress-bar");
        loadingText = new Text();
        loadingText.getStyleClass().add("loading-text");
        root.getChildren().add(progressBar);
        root.getChildren().add(loadingText);
        return new Scene(rootBorder, 450, 100);
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
