package xyz.polarfrann.ooplanner.stages;
/*
    Decorator class for OOPlanner
    Created on 22/08/2020 at 12:00
    by frann
*/

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Decorator {

    private final Stage plannerStage;

    public Decorator(Stage stage) {
        plannerStage = stage;
    }

    public void decorateWindow(String version, String icon) {
        plannerStage.setTitle("OOPlanner " + version);
        plannerStage.getIcons().add(new Image(getClass().getResourceAsStream("/" + icon)));
    }

    public void setWindowSize(int width, int height) {
        plannerStage.setWidth(width);
        plannerStage.setHeight(height);
    }

    public void setWindowPosition(int x, int y) {
        plannerStage.setX(x);
        plannerStage.setY(y);
    }

    public void centerWindow() {
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        double xPos = (primScreenBounds.getWidth() - plannerStage.getWidth()) / 2;
        double yPos = (primScreenBounds.getHeight() - plannerStage.getHeight()) / 2;
        plannerStage.setX(xPos);
        plannerStage.setY(yPos);
    }

    public void setPopupWindow() {
        plannerStage.setResizable(false);
        plannerStage.initStyle(StageStyle.UNDECORATED);
    }

    public void showStage() {
        plannerStage.toFront();
        plannerStage.show();
    }

}
