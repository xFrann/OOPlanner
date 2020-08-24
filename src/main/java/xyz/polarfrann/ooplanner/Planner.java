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
import javafx.stage.StageStyle;
import xyz.polarfrann.ooplanner.stages.preloader.PreloaderController;
import xyz.polarfrann.ooplanner.stages.Decorator;

public class Planner extends Application {

    private static final PlannerInitializer initializer = new PlannerInitializer();

    public static void main(String[] args) {
        initializer.enablePreloader();
        initializer.startDebug();
        launch();
    }

    @Override
    public void init() throws InterruptedException {
        if (initializer.isPreloaderEnabled()) {
            PreloaderController loadingController = new PreloaderController(this);
            loadingController.fakeLoad();
        }
    }

    @Override
    public void start(Stage plannerStage) throws Exception {
        FXMLLoader fxLoader = new FXMLLoader(getClass().getResource("/Planner.fxml"));
        Parent rootContainer = fxLoader.load();
        Scene scene = new Scene(rootContainer);
        scene.getStylesheets().add("/Menu.css");
        plannerStage.setScene(scene);

        Decorator decorator = new Decorator(plannerStage);
        plannerStage.initStyle(StageStyle.UNDECORATED);
        decorator.decorateWindow(initializer.getVersion(), "icons/dummy-icon.png");
        decorator.setWindowSize(1000, 1000);
        decorator.showStage();
        decorator.centerWindow();
        /*
            TODO: Fix the Menu items accelerators labels icons showing up (not intended)
            TODO: More Menu styling (text padding and submenus)
            TODO: Finish the menu contents
            TODO: Make the explorer container resizable
            TODO: Style the explorer container and tree view
            TODO: Setup project explorer by working with the tree view
         */

    }

}
