package panes;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import app.InstallerApp;
import javafx.geometry.*;

public class LicensePane extends VBox {
    public LicensePane(InstallerApp app) {
        Label title = new Label("License Agreement");
        TextArea licenseText = new TextArea("Insert license text here...");
        licenseText.setWrapText(true);
        licenseText.setEditable(false);

        CheckBox agree = new CheckBox("I agree to the terms");
        Button next = new Button("Next");
        next.setDisable(true);
        agree.setOnAction(e -> next.setDisable(!agree.isSelected()));

        next.setOnAction(e -> app.showDirectory());

        Button back = new Button("Back");
        back.setOnAction(e -> app.showIntroduction());

        HBox buttonBox = new HBox(10, back, next);
        buttonBox.setAlignment(Pos.CENTER_LEFT);

        setSpacing(10);
        setPadding(new Insets(10));
        getChildren().addAll(title, licenseText, agree, buttonBox);
    }
}
