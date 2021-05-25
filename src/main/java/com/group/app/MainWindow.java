package com.group.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;
import java.time.Year;

public class MainWindow {

	private Stage stage = new Stage();

	 BorderPane borderPane;

	 Button searchButton = new Button();
	 Button addEntryButton = new Button("Add Мovie",new ImageView(new Image("file:addicon.png")));
	 Button removeEntryButton = new Button("Remove Мovie",new ImageView(new Image("file:removeicon.png")));

	 TextField searchField = new TextField();

	 ListView<String> list = new ListView<String>();
	 ComboBox orderOptions = new ComboBox();



	public void setAddMovieButtonHandler(EventHandler<ActionEvent> handler){
		this.addEntryButton.setOnAction(handler);
	}
    public void setSearchMovieButtonHandler(EventHandler<ActionEvent> handler){ this.searchButton.setOnAction(handler); }

	public void setRemoveEntryButtonHandler(EventHandler<ActionEvent> handler){this.removeEntryButton.setOnAction(handler);}

	public void setOrderSelectorOtions(ObservableList<String> l){
		this.orderOptions.setItems(l);
		this.orderOptions.getSelectionModel().selectFirst();
	}

	public ComboBox getOrderSelector(){
		return this.orderOptions;
	}

	public void setOrderSelectorHandler(EventHandler<ActionEvent> handler){
		this.orderOptions.setOnAction(handler);
	}

	private HBox createTopMenu() {

		double size = 75.00;
		HBox topMenu = new HBox();
		HBox topRightMenu = new HBox();
		HBox topLeftMenu = new HBox();
		topMenu.setPrefHeight(size+10.00);
		GridPane OrderPane = new GridPane();

		OrderPane.setAlignment(Pos.TOP_RIGHT);
		OrderPane.add(this.orderOptions,0,0);

		orderOptions.setMinHeight(size);
		addEntryButton.setMinHeight(size);
		removeEntryButton.setMinHeight(size);
		searchButton.setMinHeight(size);
		searchField.setMinHeight(size);
		OrderPane.setMinHeight(size);

		HBox searchBox = new HBox();
		searchBox.getChildren().addAll(this.searchField,searchButton);

		topRightMenu.getChildren().addAll(searchBox,OrderPane);
		topRightMenu.setSpacing(15);
		topRightMenu.setAlignment(Pos.TOP_RIGHT);
		topLeftMenu.getChildren().addAll(addEntryButton,removeEntryButton);
		topLeftMenu.setSpacing(15);
		topLeftMenu.setAlignment(Pos.TOP_LEFT);

		topMenu.getChildren().addAll(topLeftMenu,topRightMenu);
		topMenu.setSpacing(50);

		return topMenu;
	}

	public void updateMoviesList(ListView<String> l) {
		this.list.setItems(l.getItems());
	}

	public MainWindow() {

		this.stage.setTitle("Film Library");

		this.addEntryButton.setMinSize(250,50);
		this.addEntryButton.setStyle("-fx-text-fill: #191970;  -fx-border-color: #000000; -fx-border-width: 1px; -fx-font-size: 20;");

		this.removeEntryButton.setMinSize(250,50);
		this.removeEntryButton.setStyle("-fx-text-fill: #191970;  -fx-border-color: #000000; -fx-border-width: 1px; -fx-font-size: 20;");

		this.searchButton.setGraphic(new ImageView(new Image("file:searchicon.png")));

		this.searchField.setMinSize(50,70);
		this.searchField.setFont(new Font("Arial",20));
		this.searchButton.setMinSize(10,10);

		this.orderOptions.setStyle("-fx-text-fill: #191970;  -fx-border-color: #000000; -fx-border-width: 1px; -fx-font-size: 20;");


		this.searchButton.setStyle("-fx-text-fill: #191970;  -fx-border-color: #000000; -fx-border-width: 1px; -fx-font-size: 13;");

		this.list.setMinWidth(250);

		borderPane = new BorderPane();
		borderPane.setTop(this.createTopMenu());
		borderPane.setLeft(this.list);

		Scene scene = new Scene(borderPane, 1100, 800);
		this.stage.setScene(scene);

		borderPane.setStyle("-fx-background-color:FLORALWHITE;");

	}

	public void show(){
		this.stage.show();
	}
}