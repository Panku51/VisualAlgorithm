package linkedList;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class LinkListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void OpenVisualisation(MouseEvent event) {
    	DoublyLinkedList linklist= new DoublyLinkedList();
    	linklist.LinkList();

    }

    @FXML
    void initialize() {

    }

}
