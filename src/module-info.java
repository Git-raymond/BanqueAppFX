module banqueappfx {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens fr.greta92.banqueappfx to javafx.graphics, javafx.fxml;
}
