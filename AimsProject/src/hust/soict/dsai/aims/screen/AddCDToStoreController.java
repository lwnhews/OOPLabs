package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddCDToStoreController {
    private Store store;

    private CompactDisc CD;

    @FXML
    private Button btnAddTrack;

    @FXML
    private Button btnSave;

    @FXML
    private TextField tfArtist;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfTitle;

    private boolean checkAllFields = false;

    @FXML
    void btnAddTrackPressed(ActionEvent event) {
        new AddTrack(CD);
    }

    @FXML
    void btnSavePressed(ActionEvent event) {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String artist = tfArtist.getText();
        float cost = 0.0f;
        try {
            cost = Float.parseFloat(tfCost.getText());
            if (cost < 0){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Cost must be positive!");
                alert.setTitle("Invalid");
                alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to parse cost!");
            alert.setTitle("Wrong type");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        CompactDisc CD = new CompactDisc(title, category, cost, artist);
        store.addMedia(CD);
        tfTitle.clear();
        tfCategory.clear();
        tfCost.clear();
        tfArtist.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "CD has been added to the store!");
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        btnSave.setDisable(true);

        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());
        tfCategory.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());
        tfCost.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());
        tfArtist.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());
    }

    private void checkTextFields(){
        if (!tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty() && !tfCost.getText().isEmpty() && !tfArtist.getText().isEmpty()){
            checkAllFields = true;
        } else {
            checkAllFields = false;
        }
        btnSave.setDisable(!checkAllFields);
    }

    public AddCDToStoreController(Store store){
        super();
        this.store = store;
    }
}
