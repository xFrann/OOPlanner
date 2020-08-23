package xyz.polarfrann.ooplanner.stages.preloader;
/*
    PreloaderController class for OOPlanner
    Created on 22/08/2020 at 11:14
    by frann
*/

import javafx.application.Platform;
import javafx.application.Preloader;
import xyz.polarfrann.ooplanner.Planner;

public class PreloaderController {

    Planner planner;

    public PreloaderController(Planner planner) {
        this.planner = planner;
    }
    /*
    Simulates loading data
    Made for visualizing the loading screen
    */
    public void fakeLoad() throws InterruptedException {
        for (int i = 0; i <= 100; i++) {
            notifyPreloader(i);
            PlannerPreloader.getInstance().getPreloaderView().setLoadingText("Loading Stuff... " + i + "%");
            Thread.sleep(50);
        }
        Platform.runLater(() -> PlannerPreloader.getInstance().getPreloaderView().getLoadingStage().close());
    }

    public void notifyPreloader(double loadAmount) {
        planner.notifyPreloader(new Preloader.ProgressNotification(loadAmount));
    }

}
