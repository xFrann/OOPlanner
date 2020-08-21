package xyz.polarfrann.ooplanner.stages.preloader;
/*
    PlannerPreloader class for OOPlanner
    Created on 21/08/2020 at 16:46
    by frann
*/

import javafx.application.Preloader;
import javafx.stage.Stage;

public class PlannerPreloader extends Preloader {

    private PreloaderView view;

    @Override
    public void start(Stage loadingStage) {
        view = new PreloaderView();
        view.setStage(loadingStage);
        view.loadStageSettings();
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification pn) {
        if (pn instanceof ProgressNotification) {
            ProgressNotification pnt = (ProgressNotification) pn;
            System.out.println(pnt.getProgress());
            view.getProgressBar().setProgress(pnt.getProgress() / 100);
            closeIfFinished(pnt.getProgress());
        }

    }
    private void closeIfFinished(double progress) {
        if (progress == 100.0) {
            view.getLoadingStage().close();
        }
    }

    public PreloaderView getPreloaderView() {
        return view;
    }
}
