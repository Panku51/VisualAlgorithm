package selectionSort;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;

import java.util.List;
import javafx.scene.paint.Color;
import javafx.animation.FillTransition;
import javafx.util.Duration;


 abstract  class AbstractSort {
    public final Color START_COLOR = Color.WHITE;
    public final Color SELECT_COLOR = Color.CYAN;
    public final Color FINAL_COLOR = Color.web("0xe53935",1.0);
    public final Color SORTED_COLOR = Color.web("0xf4511e",1.0);
    
    static int X;
    ParallelTransition p;
    FillTransition f;
    
    static {
        X = HomepageController.WINDOW_WIDTH / HomepageController.NO_OF_NODES;
    }
    
    void fillTransion(Node c, Color color) {
        f = new FillTransition();
        f.setShape(c);
        f.setToValue(color);
        f.setDuration(Duration.millis(HomepageController.SPEED));
        p.getChildren().add(f);
    }
    
    ParallelTransition colorNode(Node[] arr, Color color, int...a) {
        p = new ParallelTransition();
        for (int i = 0; i < a.length; i++) {
            fillTransion(arr[a[i]], color);
        }
        return p;
    }
    
    ParallelTransition colorNode(List<Node> list, Color color) {
        p = new ParallelTransition();
        for (Node c : list) {
            fillTransion(c, color);
        }
        return p;
    }
    
    ParallelTransition swap(Node a[], int i, int j) {
        p = new ParallelTransition();
        int dx = j-i;
        p.getChildren().addAll(a[i].moveX(X * dx), a[j].moveX(-X * dx));
        Node tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        return p;
    }
    
    public abstract ArrayList<Transition> startSort(Node[] a);
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
            transitions.add(colorNode(nodes, NEWMIN_COLOR, minIdx));
            for (int j = i+1; j < nodes.length; j++) {
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
    

public class Node extends Rectangle {
    private int val;
    
    public Node(int n) {
        val = n;
    } 
    
    public int getValue() {
        return val;
    }
    
    public TranslateTransition moveX(int x) {
        TranslateTransition translation = new TranslateTransition();
        translation.setNode(this);
        translation.setDuration(Duration.millis(HomepageController.SPEED));
        translation.setByX(x);
        return translation;
    }
}

}