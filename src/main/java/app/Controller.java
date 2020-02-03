package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Controller {

    private static Controller init;

    @FXML
    private TableView<BelRegion> table;

    @FXML
    public TableColumn<BelRegion, String> regionCol;
    @FXML
    private TableColumn<BelRegion, String> redionCenterCol;
    @FXML
    private TableColumn<BelRegion, Double> areaCol;
    @FXML
    private TableColumn<BelRegion, Double> populationCol;

    @FXML
    private Menu taskA;

    Stage stage;

    private DataBaseAPI dataBaseAPI = DataBaseAPI.getDataBaseAPI();

    public static Controller getController(){
        return init;
    }
    public void initialize() throws SQLException, ClassNotFoundException {
        init = this;
        ObservableList<BelRegion> regions = FXCollections.observableArrayList(dataBaseAPI.getRegions());
        regionCol.setCellValueFactory(new PropertyValueFactory<BelRegion, String>("regionName"));
        redionCenterCol.setCellValueFactory(new PropertyValueFactory<BelRegion, String>("regionCenterName"));
        areaCol.setCellValueFactory(new PropertyValueFactory<BelRegion, Double>("area"));
        populationCol.setCellValueFactory(new PropertyValueFactory<BelRegion, Double>("popul"));

        table.setItems(regions);
    }

    public void click(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(table.getSelectionModel().getSelectedItem() != null) {
            dataBaseAPI.delete(table.getSelectionModel().getSelectedItems().get(0).getId());
            initialize();
        }
    }

    public void clickAdd(ActionEvent event) throws IOException {
        if(stage != null)
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        new AddController().setScene("fxml/add.fxml", "Add", stage);
    }


    public void clickA(ActionEvent event) throws IOException {
        if(stage != null)
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        new TaskAController().setScene("fxml/taskA.fxml", "TaskA", stage);
    }
}
