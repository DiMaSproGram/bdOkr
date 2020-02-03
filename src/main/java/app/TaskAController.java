package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class TaskAController {
    private DataBaseAPI dataBaseAPI = DataBaseAPI.getDataBaseAPI();

    @FXML
    private TableView<BelRegion> table;

    @FXML
    public TableColumn<BelRegion, String> regionCol;
    @FXML
    private TableColumn<BelRegion, String> regionCenterCol;
    @FXML
    private TableColumn<BelRegion, Double> areaCol;

    @FXML
    private TextField areaLbl;

    public void setScene(String fxmlFile, String title, Stage stage) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlFile));
        Stage newWindow = new Stage();
        newWindow.setTitle(title);
        newWindow.setScene(new Scene(root2, 620, 500));
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.initOwner(stage);
        newWindow.show();
    }

    public void click(ActionEvent event) throws SQLException {
        if(areaLbl.getText() != null) {
            ObservableList<BelRegion> regions = FXCollections.observableArrayList(dataBaseAPI.findByArea(Double.parseDouble(areaLbl.getText())));

            regionCol.setCellValueFactory(new PropertyValueFactory<BelRegion, String>("regionName"));
            regionCenterCol.setCellValueFactory(new PropertyValueFactory<BelRegion, String>("regionCenterName"));
            areaCol.setCellValueFactory(new PropertyValueFactory<BelRegion, Double>("area"));

            table.setItems(regions);
        }
    }
}
