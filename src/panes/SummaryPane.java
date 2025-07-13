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

        Button back = new Button("Back");
        back.setOnAction(e -> app.showDirectory());

        HBox buttonBox = new HBox(10, back, install);
        buttonBox.setAlignment(Pos.CENTER_LEFT);

        // setSpacing(20);
        // setAlignment(Pos.CENTER);
        setSpacing(10);
        setPadding(new Insets(10));
        getChildren().addAll(summary, buttonBox);
    }
}
