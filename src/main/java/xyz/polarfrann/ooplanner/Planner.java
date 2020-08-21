package xyz.polarfrann.ooplanner;
/*
    Planner Class for OOPlanner
    Created on 21/08/2020 at 14:17
    by frann

    Main Project Class
*/

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import xyz.polarfrann.ooplanner.stages.preloader.PlannerPreloader;

public class Planner extends Application {

    private FXMLLoader fxLoader;

    public static void main(String[] args) {
        PlannerInitializer initializer = new PlannerInitializer();
        initializer.startDebug();
        System.setProperty("javafx.preloader", "xyz.polarfrann.ooplanner.stages.preloader.PlannerPreloader");
        launch();
    }

    @Override
    public void init() throws InterruptedException {
        notifyPreloader(new Preloader.ProgressNotification(5));
        PlannerPreloader.getInstance().getPreloaderView().setLoadingText("Loading Stuff...");
        Thread.sleep(2000);
        notifyPreloader(new Preloader.ProgressNotification(25));
        PlannerPreloader.getInstance().getPreloaderView().setLoadingText("Initializing tests...");
        Thread.sleep(2000);
        notifyPreloader(new Preloader.ProgressNotification(65));
        PlannerPreloader.getInstance().getPreloaderView().setLoadingText("Almost done...");
        Thread.sleep(2000);
        notifyPreloader(new Preloader.ProgressNotification(99));
        PlannerPreloader.getInstance().getPreloaderView().setLoadingText("Done!");
        Thread.sleep(1000);
        notifyPreloader(new Preloader.ProgressNotification(100));


    }

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

}
