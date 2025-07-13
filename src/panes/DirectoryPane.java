package panes;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.DirectoryChooser; // ✅ missing import
import javafx.geometry.*;
import java.io.File;
import app.InstallerApp;

import java.io.File;

public class DirectoryPane extends VBox {
    public DirectoryPane(InstallerApp app) {
        Label label = new Label("Choose installation directory:");
        TextField pathField = new TextField(System.getProperty("user.home") + File.separator + "MyApp");

        Button browse = new Button("Browse");
        browse.setOnAction(e -> {
            DirectoryChooser chooser = new DirectoryChooser();
            chooser.setTitle("Select Installation Folder");
            File selected = chooser.showDialog(null);
            if (selected != null) {
                pathField.setText(selected.getAbsolutePath());
            }
        });

        Button next = new Button("Next");
        next.setOnAction(e -> {
            app.setInstallPath(pathField.getText());
            app.showSummary();
        });

        setSpacing(10);
        setPadding(new Insets(10));
        getChildren().addAll(label, pathField, browse, next);
    }
}
