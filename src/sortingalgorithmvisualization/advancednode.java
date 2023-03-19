package sortingalgorithmvisualization;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class advancednode extends Node{

	public advancednode(int bar) {
		super(bar);
	}
	
	public Node create(Node bar) {
		final Text text = new Text ("ab");
		final Node stack = new Node();
		stack.getChildren().addAll(bar, text);
		return stack;
		
	}

}
