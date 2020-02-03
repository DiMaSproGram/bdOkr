package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.SQLException;

public class AddController {
    private DataBaseAPI dataBaseAPI = DataBaseAPI.getDataBaseAPI();
    private Controller controller = Controller.getController();

    @FXML
    private TextField region;
    @FXML
    private TextField regionCenter;
    @FXML
    private TextField area;
    @FXML
    private TextField popul;

    public void setScene(String fxmlFile, String title, Stage stage) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlFile));
        Stage newWindow = new Stage();
        newWindow.setTitle(title);
        newWindow.setScene(new Scene(root2, 330, 330));
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.initOwner(stage);
        newWindow.show();
    }

    public void click(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(region.getText() != null && regionCenter.getText() != null && area.getText() != null && popul.getText() != null) {
            dataBaseAPI.add(region.getText(), regionCenter.getText(), Double.parseDouble(area.getText()), Double.parseDouble(popul.getText()));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            controller.initialize();
            stage.close();
        }
    }
}
