module VisualAlgorithm {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	opens home to javafx.graphics, javafx.fxml;
	opens sortingMenu to javafx.graphics, javafx.fxml;
	opens dsMenu to javafx.graphics, javafx.fxml;
	opens pfMenu to javafx.graphics, javafx.fxml;
	opens selectionSort to javafx.graphics, javafx.fxml;
	opens sortingalgorithmvisualization  to javafx.graphics, javafx.fxml;


}
