package home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomeViewController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	@FXML
    void OpenAbout(MouseEvent event) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/home/about.fxml"));
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
	void OpenDS(MouseEvent event) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/dsMenu/DsView.fxml"));
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
	void OpenPF(MouseEvent event) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/pfMenu/pathfindingView.fxml"));
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
	void OpenSorting(MouseEvent event) {
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
	void initialize() {

	}

}
