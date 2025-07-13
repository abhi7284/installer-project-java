package panes;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import InstallerApp;

public class IntroductionPane extends VBox {
    public IntroductionPane(InstallerApp app) {
        Label label = new Label("Welcome to the Installer!");
        Button next = new Button("Next");
        next.setOnAction(e -> app.showLicense());

        setAlignment(Pos.CENTER);
        setSpacing(20);
        getChildren().addAll(label, next);
    }
}
