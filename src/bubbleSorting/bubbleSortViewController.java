package bubbleSorting;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class bubbleSortViewController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void OpenExplore(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("ExploreBubbleSort.fxml"));
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
    void OpenHome(MouseEvent event) {
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
   public void OpenVisualisation(ActionEvent event) {
    	 BubbleSort b=new BubbleSort();
         b.Sorting(); 
    }

    @FXML
   void DoReturn(MouseEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/bubbleSorting/bubbleSortView.fxml"));
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
