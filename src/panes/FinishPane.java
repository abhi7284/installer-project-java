package panes;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class FinishPane extends VBox {
    public FinishPane() {
        Label done = new Label("Installation Finished Successfully!");
        Button close = new Button("Close");
        close.setOnAction(e -> System.exit(0));

        setSpacing(20);
        setAlignment(Pos.CENTER);
        getChildren().addAll(done, close);
    }
}
