package xyz.polarfrann.ooplanner;
/*
    Planner Class for OOPlanner
    Created on 21/08/2020 at 14:17
    by frann

    Main Project Class
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Planner extends Application {

    private FXMLLoader fxLoader;

    @Override
    public void start(Stage plannerStage) throws Exception {

        fxLoader = new FXMLLoader(getClass().getResource("/Planner.fxml"));

        Parent rootContainer = fxLoader.load();

        plannerStage.setScene(new Scene(rootContainer));
        plannerStage.show();

    }

    public FXMLLoader getFxLoader() {
        return fxLoader;
    }

    public static void main(String[] args) {
        PlannerInitializer initializer = new PlannerInitializer();
        initializer.startDebug();
        launch(args);
    }

}
