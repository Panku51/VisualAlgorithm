package sortingalgorithmvisualization;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.beans.value.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.lang.Thread;  
import java.io.*; 
public class HomepageController implements Initializable {
    
    @FXML private Button logoutButton;
    @FXML private Button pauseButton;
    @FXML private Button sortButton;
    @FXML private Button randomButton;
    @FXML private ChoiceBox<AbstractSort> chooseBox;
    @FXML private ChoiceBox<Integer> nodeBox;
    @FXML private ChoiceBox<Integer> speedBox;
    @FXML private Pane display;
    @FXML private Label comp;
    @FXML public TextField first;
    @FXML public  TextField second;
    @FXML public TextField third;
    @FXML private Button getArray;
    @FXML private TextField array;
    

    
    public void labelDisabler() {
    	first.setDisable(true);
    }
    public void labelEnabler() {
    	try {
    	first.setDisable(false);
    	}
    	catch (Exception e) {
    		System.out.println(e);
    	}
    	System.out.println("triggerd");
    }
   

    Connection connection;
    SequentialTransition st;
    boolean running = false;
    
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 350;
    public static final int BUTTON_BOUNDARY = 100;
    public static final int X_GAP = 10;
    public static int NO_OF_NODES = 10;
    public static int SPEED = 50;
    
    private Node nodes[];
    public static AbstractSort abstractSort;
    
    @FXML
    void randomButtonAction(MouseEvent event) {
        generator();
    }
    
    @FXML
    void pauseButtonAction(MouseEvent event) {
        if (running) {
            st.pause();
            pauseButton.setText("Continue");
            running = false;
        }
        else {
            st.play();
            pauseButton.setText("Pause");
            running = true;
        }
    }

    @FXML
    void sortButtonAction(MouseEvent event) {
        running = true;
        sortButton.setDisable(true);
        logoutButton.setDisable(true);
        randomButton.setDisable(true);
        pauseButton.setDisable(false);
        comp.setFont(Font.font("Verdana", 15));
        comp.setText("Sorting running....");
        comp.setTextFill(Color.web("#D8D8D8"));
        display.getChildren().add(comp);
        //logoutButton.setDisable(true);
        
        abstractSort = chooseBox.getSelectionModel().getSelectedItem();
        st = new SequentialTransition();
        st.getChildren().addAll(abstractSort.startSort(nodes));
        st.setOnFinished(e -> {
            randomButton.setDisable(false);
            pauseButton.setDisable(true);
            logoutButton.setDisable(false);
            running = false;
            comp.setText("Array is sorted");
        });
        st.play();
    }
    
    @FXML
    void logoutProcess(MouseEvent event) throws IOException {
        Parent dash = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Scene dashScene = new Scene(dash);
        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        window.setTitle("Sorting Algorithm Visualization");
        window.setScene(dashScene);
        window.show();
    }
    
    public void generator() {
        sortButton.setDisable(false);
        display.getChildren().clear();
        this.nodes = GenerateRandomNodes.GenerateRandomNodes(NO_OF_NODES);
        display.getChildren().addAll(Arrays.asList(nodes)); 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
        try { connection = DriverManager.getConnection("jdbc:derby://localhost:1527/myDatabase", "app", "app"); }
        catch(SQLException e) { }
        
        pauseButton.setDisable(true);
        
      //  this.nodes = GenerateRandomNodes.GenerateRandomNodes(NO_OF_NODES);
     //   display.getChildren().addAll(Arrays.asList(nodes));
        generator();
        //for (int i = 0; i < NO_OF_NODES; i++) System.out.println(nodes[i].getValue());
        
        Integer speed[] = {1, 5, 10, 50, 100, 500};
        speedBox.setValue(50);
        Tooltip tt1 = new Tooltip();
        tt1.setStyle("-fx-base: #AE3522; " + "-fx-text-fill: BLACK;" + "-fx-background-color : WHITE;");
        tt1.setText("Choose Speed");
        speedBox.setTooltip(tt1);
        speedBox.setItems(FXCollections.observableArrayList(speed));

        speedBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                Integer n = new Integer(newValue);
                SPEED = n.intValue();
            } 
        });
        
        List <AbstractSort> sortList = new ArrayList<>();
        sortList.add(new SelectionSort());
        sortList.add(new QuickSort());
        sortList.add(new BubbleSort());
        
        chooseBox.setValue(new SelectionSort());
        Tooltip tt2 = new Tooltip();
        tt2.setStyle("-fx-base: #AE3522; " + "-fx-text-fill: BLACK;" + "-fx-background-color : WHITE;");
        tt2.setText("Choose Sorting Algorithm");
        chooseBox.setTooltip(tt2);
        chooseBox.setItems(FXCollections.observableArrayList(sortList));
        chooseBox.getSelectionModel().select(4);
        
        chooseBox.setConverter(new StringConverter<AbstractSort>() {
            @Override
            public String toString(AbstractSort absSort) {
                if (absSort == null) return "";
                else return absSort.getClass().getSimpleName();
            }
            
            @Override
            public AbstractSort fromString(String s) {
                return null;
            }
        });
    }    
    
    public class SelectionSort extends AbstractSort{
    	
    	    private ArrayList<Transition> transitions;
    	    private static final Color MIN_COLOR = Color.LIGHTGREEN;
    	    private static final Color NEWMIN_COLOR = Color.PURPLE;
    	    
    	    private ParallelTransition ColorNode(Node nodes[], int x, int y, Color A, Color B) {
    	        ParallelTransition p = new ParallelTransition();
    	        p.getChildren().addAll(colorNode(nodes, A, x), colorNode(nodes, B, y));
    	        return p;
    	    }
    	    
    	    @Override
    	    public ArrayList <Transition> startSort(Node[] nodes) {
    	        transitions = new ArrayList<>();
    	        int minIdx;
    	        for (int i = 0; i < nodes.length - 1; i++) {
    	            minIdx = i;
    	          //  FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
    	          //  HomepageController homeController = loader.getController();
    	         //start threads one by one
    	         first.setBackground(null);
    	           // HomepageController.comp.setText("blah blah blah blah blsah blajh blah bklah");
    	            transitions.add(colorNode(nodes, NEWMIN_COLOR, minIdx));
    	            for (int j = i+1; j < nodes.length; j++) {
    	              first.setDisable(true);
    	            	//first.setStyle("-fx-background-color : black;");
    	              second.setDisable(false);
    	                transitions.add(colorNode(nodes, SELECT_COLOR, j));
    	                if (nodes[j].getValue() < nodes[minIdx].getValue()) {

    	                    if (minIdx == i) transitions.add(ColorNode(nodes, minIdx, j, MIN_COLOR, NEWMIN_COLOR));
    	                    else transitions.add(ColorNode(nodes, minIdx, j, Color.CRIMSON, NEWMIN_COLOR));
    	                    minIdx = j;
    	                	second.setDisable(true);
  	    	              third.setDisable(false);
    	                    
    	                }
    	                else transitions.add(colorNode(nodes, START_COLOR, j));
    	            }
    	            if (minIdx != i) transitions.add(swap(nodes, i, minIdx));
    	            transitions.add(colorNode(nodes, SORTED_COLOR, i, minIdx));
    	        }
    	        transitions.add(colorNode(Arrays.asList(nodes), FINAL_COLOR));
    	        return transitions;
    	    }
    	} 
    @FXML
    void getCustomInput(MouseEvent event) {
    	
    	String temp = array.getText();
    	String[] arr= temp.split(",");
    	//System.out.println(arr[0]);
    	int CustAry[]= new int[arr.length];
    	for(int i=0;i<arr.length;i++)
    	{
    		CustAry[i]= Integer.parseInt(arr[i]);
    	}
    	
    	System.out.println(CustAry[1]);
    	NO_OF_NODES=CustAry.length;
    	sortButton.setDisable(false);
        display.getChildren().clear();
        this.nodes = GenerateRandomNodes.GenerateRandomNodes(CustAry);
        display.getChildren().addAll(Arrays.asList(nodes)); 
        //display.getChildren().addAll(CustAry); 
        
    }

}

