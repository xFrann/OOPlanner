package xyz.polarfrann.ooplanner;
/*
    PlannerInitializer class for OOPlanner
    Created on 21/08/2020 at 15:08
    by frann
*/

public class PlannerInitializer {

    private boolean isPreloaderEnabled = false;
    private final String version = getClass().getPackage().getImplementationVersion();
    private final String operatingSystem = System.getProperty("os.name");


    public void startDebug() {
        System.out.println("Running OOPlanner version " + version + " on " + operatingSystem);
        System.out.println("Preloader enabled: " + isPreloaderEnabled);
    }

    public void enablePreloader() {
        this.isPreloaderEnabled = true;
        System.setProperty("javafx.preloader", "xyz.polarfrann.ooplanner.stages.preloader.PlannerPreloader");
    }

    public boolean isPreloaderEnabled() {
        return isPreloaderEnabled;
    }

    public String getVersion() {
        return version;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }
}
