import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    @FXML
    private TextField searchTextField;
    @FXML
    private TableView<Contact> contactsTableView;
    @FXML
    private TableColumn<Contact, String> nameTableColumn;
    @FXML
    private TableColumn<Contact, String> phoneTableColumn;
    @FXML
    private TableColumn<Contact, String> emailTableColumn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contactsTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        nameTableColumn.prefWidthProperty().bind(contactsTableView.widthProperty().multiply(0.33));
        phoneTableColumn.prefWidthProperty().bind(contactsTableView.widthProperty().multiply(0.33));
        emailTableColumn.prefWidthProperty().bind(contactsTableView.widthProperty().multiply(0.33));

        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        emailTableColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        updateContactsTableView();
    }

    private void updateContactsTableView(){
        List<Contact> contactsList = Contacts.get().getList();
        contactsTableView.getItems().setAll(contactsList);
    }

    @FXML
    private void onSearchClicked(MouseEvent event){
        System.out.println("Text: " + searchTextField.getText());
    }

    @FXML
    private void onAddClicked(MouseEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("add_view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 630, 400);
            Stage stage = new Stage();
            stage.setTitle("Add Window");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
