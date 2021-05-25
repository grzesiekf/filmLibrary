package com.group.app;

public class View {
	private MainWindow mainWindow = new MainWindow();

	public MainWindow getMainWindow(){
		return this.mainWindow;
	}

	public View() {
		this.mainWindow.show();
	}
}