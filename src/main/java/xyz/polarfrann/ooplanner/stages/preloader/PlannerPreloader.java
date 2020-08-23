package xyz.polarfrann.ooplanner.stages.preloader;
/*
    PlannerPreloader class for OOPlanner
    Created on 21/08/2020 at 16:46
    by frann

    Singleton Class
*/

import javafx.application.Preloader;
import javafx.stage.Stage;

public class PlannerPreloader extends Preloader {

    private PreloaderView view;

    private static PlannerPreloader instance;

    @Override
    public void start(Stage loadingStage) {
        instance = this;
        view = new PreloaderView();
        view.loadStageSettings(loadingStage);
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification pn) {
        if (pn instanceof ProgressNotification) {
            ProgressNotification pnt = (ProgressNotification) pn;
            view.getProgressBar().setProgress(pnt.getProgress() / 100);
        }

    }

    public PreloaderView getPreloaderView() {
        return view;
    }

    public static PlannerPreloader getInstance() {
        return instance;
    }
}
