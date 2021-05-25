package com.group.app;

import javafx.scene.control.ListView;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;
import javafx.collections.transformation.SortedList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model  {

	private static final String filepath = "MovieObjects";

	private List<Movie> movieList = new ArrayList<Movie>();

	public ListView<String> getTitlesList(final String order){
		ObservableList list = FXCollections.observableArrayList();
		ListView<String> listView = new ListView<String>();
		Iterator<Movie> moviesIterator = this.movieList.iterator();

		while(moviesIterator.hasNext()) {
			list.add(moviesIterator.next().MovieTitle);
		}

		SortedList<String> sortedList = new SortedList(list);
		sortedList.setComparator(new Comparator<String>(){
            @Override
            public int compare(String arg0, String arg1) {
            	int o = 1;
				if (order == "Z -> A"){
					o = -1;
				}
				
                return o * arg0.compareToIgnoreCase(arg1);
            }
        });

		listView.setItems(sortedList);

		return listView;
	}

	public List<Movie> getMovieList(){
		return this.movieList;
	}


	public void SaveToFile(){

		try {

			FileOutputStream fos = new FileOutputStream(filepath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.movieList);
			oos.close();
			//System.out.println("The Object  was succesfully written to a file");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void ReadFromFile(){

		try {

			FileInputStream fis = new FileInputStream(filepath);
			ObjectInputStream ois = new ObjectInputStream(fis);

			this.movieList = (List<Movie>) ois.readObject();

			ois.close();


			//System.out.println("The Object  was succesfully read from a file");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}


}


