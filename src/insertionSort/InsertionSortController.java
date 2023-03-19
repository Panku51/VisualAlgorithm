package insertionSort;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InsertionSortController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void OpenExplore(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/insertionSort/Insertion.fxml"));
		// OR
//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    	


    }

    @FXML
    void OpenVisualisation(ActionEvent event) {
    	InsertionSort insertion = new InsertionSort();
    	insertion.InsertionSorting();
    }

    @FXML
    void initialize() {

    }

}
