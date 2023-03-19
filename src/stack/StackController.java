package stack;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class StackController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void OpenVisaulisation(ActionEvent event) {
    	Stack stack = new Stack();
    	stack.stack();
    }

    @FXML
    void initialize() {

    }

}
