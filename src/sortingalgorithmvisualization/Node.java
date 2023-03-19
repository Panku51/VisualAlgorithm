package sortingalgorithmvisualization;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Node extends Rectangle {
    private int val;
    
    public Node(int n) {
        val = n;
    } 
    
    public int getValue() {
        return val;
    }
    final Text text = new Text("abc");

    
    public TranslateTransition moveX(int x) {
        TranslateTransition translation = new TranslateTransition();
        translation.setNode(this);
        translation.setDuration(Duration.millis(HomepageController.SPEED));
        translation.setByX(x);
        return translation;
    }
}
