package com.group.app;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	Model model = new Model();
	View view = new View();
	Controller controller = new Controller(this.model, this.view);

	public static void main(String[] args) {
		launch(args);
	}
	public static boolean status() {return true;}
	@Override
	public void start(Stage primaryStage) {

		this.model.ReadFromFile();
		this.view.getMainWindow().updateMoviesList(this.model.getTitlesList(""));

	}


	@Override
	public void stop(){

		this.model.SaveToFile();

	}

}