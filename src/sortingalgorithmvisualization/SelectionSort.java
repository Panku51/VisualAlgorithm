package sortingalgorithmvisualization;

import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;




public class SelectionSort extends AbstractSort{
	public  HomepageController getcontrol(){
		Parent root;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HomepageController homeController = loader.getController();
        return homeController;
	}
   // @FXML private TextField first;
  //  @FXML private TextField second;
	

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
    	HomepageController temp = getcontrol();
        transitions = new ArrayList<>();
        int minIdx;
        for (int i = 0; i < nodes.length - 1; i++) {
        	
            minIdx = i;
            transitions.add(colorNode(nodes, NEWMIN_COLOR, minIdx));
            for (int j = i+1; j < nodes.length; j++) {
                temp.labelEnabler();
               // HomepageController.first.setDisable(true);
              //  HomepageController.second.setDisable(false);
                transitions.add(colorNode(nodes, SELECT_COLOR, j));
                if (nodes[j].getValue() < nodes[minIdx].getValue()) {
                    if (minIdx == i) transitions.add(ColorNode(nodes, minIdx, j, MIN_COLOR, NEWMIN_COLOR));
                    else transitions.add(ColorNode(nodes, minIdx, j, Color.CRIMSON, NEWMIN_COLOR));
                    minIdx = j;
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