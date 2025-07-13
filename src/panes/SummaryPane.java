package panes;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import app.InstallerApp;
import javafx.geometry.*;

public class SummaryPane extends VBox {
    public SummaryPane(InstallerApp app) {
        Label summary = new Label("Ready to install to:\n" + app.getInstallPath());
        Button install = new Button("Install");
        install.setOnAction(e -> app.showInstall());

        setSpacing(20);
        setAlignment(Pos.CENTER);
        getChildren().addAll(summary, install);
    }
}
