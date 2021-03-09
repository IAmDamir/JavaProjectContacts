import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddWindowController implements Initializable {

    public AnchorPane personAnchorPane;
    public AnchorPane organizationAnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showPersonAnchorPane(true);
        showOrganizationAnchorPane(false);
    }

    public void onCancelButtonClicked(MouseEvent mouseEvent) {
        final Node source = (Node) mouseEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void onPersonButtonClicked(MouseEvent mouseEvent) {
        showPersonAnchorPane(true);
        showOrganizationAnchorPane(false);
    }

    public void onOrganizationButtonClicked(MouseEvent mouseEvent) {
        showPersonAnchorPane(false);
        showOrganizationAnchorPane(true);
    }

    private void showPersonAnchorPane(boolean isShow){
        showAnchorPane(personAnchorPane, isShow);
    }

    private void showOrganizationAnchorPane(boolean isShow){
        showAnchorPane(organizationAnchorPane, isShow);
    }

    private void showAnchorPane(AnchorPane anchorPane, boolean isShow){
        anchorPane.setVisible(isShow);
        anchorPane.setDisable(!isShow);
    }

}
