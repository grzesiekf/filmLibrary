package com.group.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

import java.lang.NullPointerException;

public class Controller{
	private String order;

	private Model model;
	private View view;

	private String MovieTitle;

	public class AddMovieButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			AddingMovie addingMovie = new AddingMovie();
			Movie movie;

			try{
				movie = addingMovie.return_Movie();
			} catch (NullPointerException e){
				return;
			}

			model.getMovieList().add(movie);
			view.getMainWindow().updateMoviesList(model.getTitlesList(order));
		}
	}

	public class SearchMovieButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String searchText = view.getMainWindow().searchField.getText();
			for (Movie movie: model.getMovieList()) {
				if(movie.MovieTitle.equalsIgnoreCase(searchText)) {
					 view.getMainWindow().borderPane.setCenter(new MovieDetails(movie));
				}
			}
		}
	}
	public static boolean ifmovie() {return true;}
	public class RemoveMovieButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			for (Movie movie: model.getMovieList()) {

				if(movie.MovieTitle.equals(MovieTitle)) {

					model.getMovieList().remove(movie);
					break;

				}
			}

			view.getMainWindow().updateMoviesList(model.getTitlesList(order));
			view.getMainWindow().borderPane.setCenter(new GridPane());


		}
	}

	public class OrderSelectorHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if( view.getMainWindow().getOrderSelector().getValue()=="Order:  A -> Z")
			order = "A -> Z";
			else order = "Z -> A";
			view.getMainWindow().updateMoviesList(model.getTitlesList(order));
		}
	}


	private void CheckTitleFromList(){


		((ListView<String>) view.getMainWindow().borderPane.getLeft()).getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observableValue, String previous, String current) {

				MovieTitle = current;

				for (Movie movie: model.getMovieList()) {

					if(movie.MovieTitle.equals(MovieTitle)) {

						view.getMainWindow().borderPane.setCenter(new MovieDetails(movie));
						break;

					}
				}

			}
		});



	}

	public Controller(Model model, View view){
		this.model = model;
		this.view = view;

		this.view.getMainWindow().setOrderSelectorOtions(FXCollections.observableArrayList("Order:  A -> Z", "Order:  Z -> A"));
		this.order = "A -> Z";

		this.view.getMainWindow().setAddMovieButtonHandler(new AddMovieButtonHandler());
		this.view.getMainWindow().setSearchMovieButtonHandler(new SearchMovieButtonHandler());
		this.view.getMainWindow().setRemoveEntryButtonHandler(new RemoveMovieButtonHandler());
		this.view.getMainWindow().setOrderSelectorHandler(new OrderSelectorHandler());

		this.CheckTitleFromList();
	}
}