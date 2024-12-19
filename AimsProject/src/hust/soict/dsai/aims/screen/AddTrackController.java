package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddTrackController {
    private CompactDisc CD;

    @FXML
    private Button btnSave;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;

    private boolean checkAllFields = false;

    @FXML
    void btnSavePressed(ActionEvent event) {
        String title = tfTitle.getText();
        int length = 0;
        try {
            length = Integer.parseInt(tfLength.getText());
            if (length < 0){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Length must be positive!");
                alert.setTitle("Invalid length.");
                alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to parse length!");
            alert.setTitle("Wrong type");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        Track track = new Track(title, length);
        CD.addTrack(track);
        tfTitle.clear();
        tfLength.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Track has been added!");
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        btnSave.setDisable(true);

        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());
        tfLength.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());
    }

    private void checkTextFields(){
        if (!tfTitle.getText().isEmpty() && !tfLength.getText().isEmpty()){
            checkAllFields = true;
        } else {
            checkAllFields = false;
        }
        btnSave.setDisable(!checkAllFields);
    }

    public AddTrackController(CompactDisc CD){
        super();
        this.CD = CD;
    }
}
