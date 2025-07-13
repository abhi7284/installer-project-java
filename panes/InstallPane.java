package panes;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import InstallerApp;
import util.InstallerUtils;

import java.io.InputStream;
import java.nio.file.*;

public class InstallPane extends VBox {
    public InstallPane(InstallerApp app) {
        Label status = new Label("Installing...");
        ProgressBar bar = new ProgressBar();
        getChildren().addAll(status, bar);
        setSpacing(10);
        setPadding(new Insets(10));

        new Thread(() -> {
            try {
                InputStream zipStream = getClass().getResourceAsStream("/archive.zip");
                Path dest = Paths.get(app.getInstallPath());
                InstallerUtils.unzip(zipStream, dest);

                // UI update after install
                javafx.application.Platform.runLater(() -> {
                    status.setText("Installation Complete.");
                    app.showFinish();
                });
            } catch (Exception e) {
                javafx.application.Platform.runLater(() -> status.setText("Error: " + e.getMessage()));
            }
        }).start();
    }
}
