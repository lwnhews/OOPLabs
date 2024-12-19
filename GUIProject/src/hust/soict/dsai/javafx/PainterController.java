package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    private boolean isEraserMode = false;

    @FXML
    private ToggleGroup Tools;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (event.getTarget() == drawingAreaPane) {
            if (isEraserMode) {
                Circle eraser = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
                drawingAreaPane.getChildren().add(eraser);
            } else {
                Circle pen = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
                drawingAreaPane.getChildren().add(pen);
            }
        }
    }

    @FXML
    void eraserMode(ActionEvent event) {
        isEraserMode = true;
    }

    @FXML
    void penMode(ActionEvent event) {
        isEraserMode = false;
    }

}
