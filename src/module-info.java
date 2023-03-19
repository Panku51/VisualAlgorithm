module VisualAlgorithm {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	requires javafx.swing;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
	opens home to javafx.graphics, javafx.fxml;
	opens sortingMenu to javafx.graphics, javafx.fxml;
	opens dsMenu to javafx.graphics, javafx.fxml;
	opens pfMenu to javafx.graphics, javafx.fxml;
	opens selectionSort to javafx.graphics, javafx.fxml;
	opens sortingalgorithmvisualization  to javafx.graphics, javafx.fxml;
	opens djikstra to javafx.graphics, javafx.fxml;
	opens bubbleSorting to javafx.graphics, javafx.fxml;
	opens queue to javafx.graphics, javafx.fxml;
	opens insertionSort to javafx.graphics, javafx.fxml;
	opens stack to javafx.graphics, javafx.fxml;
	opens linkedList to javafx.graphics, javafx.fxml;

}
