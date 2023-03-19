package selectionSort;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class selSortController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void doHome(MouseEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/home/HomeView.fxml"));
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
    void doReturn(MouseEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/sortingMenu/SortingView.fxml"));
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
    void openExplore(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/selectionSort/sel2.fxml"));
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
    public void openVisualisation(ActionEvent event) {
    	SelectionSort selection = new SelectionSort();
    	selection.SelSort();
    }

    @FXML
    void initialize() {

    }

}
