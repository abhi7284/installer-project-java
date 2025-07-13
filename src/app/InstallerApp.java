package app;

import java.io.PrintWriter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import panes.*;

public class InstallerApp extends Application {
    private Stage stage;
    private String installPath = "";

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        showIntroduction();
    }

    public void showIntroduction() {
        stage.setScene(new Scene(new IntroductionPane(this), 600, 400));
        stage.setTitle("Installer - Introduction");
        stage.show();
    }

    public void showLicense() {
        stage.setScene(new Scene(new LicensePane(this), 600, 400));
    }

    public void showDirectory() {
        stage.setScene(new Scene(new DirectoryPane(this), 600, 400));
    }

    public void showSummary() {
        stage.setScene(new Scene(new SummaryPane(this), 600, 400));
    }

    public void showInstall() {
        stage.setScene(new Scene(new InstallPane(this), 600, 400));
    }

    public void showFinish() {
        stage.setScene(new Scene(new FinishPane(), 600, 400));
    }

    public void setInstallPath(String path) {
        this.installPath = path;
    }

    public String getInstallPath() {
        return installPath;
    }

    public static void main(String[] args) {
    try {
            launch(args);
        } catch (Exception e) {
            e.printStackTrace();
            try (PrintWriter out = new PrintWriter("error.log")) {
                e.printStackTrace(out);
            } catch (Exception ignored) {}
        }
    }
}
