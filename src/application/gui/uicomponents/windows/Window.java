package application.gui.uicomponents.windows;

import javafx.application.Application;
import javafx.stage.Stage;

public abstract class Window extends Application
{

	@Override
	public void start(Stage stage) throws Exception 
	{
		stage.setTitle(title());
		
	}
	
	public abstract String title();
}
