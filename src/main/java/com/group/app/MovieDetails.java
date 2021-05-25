package com.group.app;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MovieDetails extends GridPane {

    private Movie movie;

    public MovieDetails(Movie movie) {

        this.movie = movie;

        Button playButton = new Button("Play the movie");
        Image cover;
        ImageView movieCover = null;
        try {
            cover = new Image(new FileInputStream(movie.MovieCover), 400, 400, true, false);
            movieCover = new ImageView(cover);

        }
        catch(Exception e) {}

        setMinSize(100, 600);
        setPadding(new Insets(10, 10, 10, 10));
        setVgap(5);
        setHgap(5);
        setAlignment(Pos.TOP_CENTER);

        add(new Text("Title:"), 0, 0);
        add(new Text(movie.MovieTitle), 1, 0);
        add(new Text("Directed By:"), 0, 1);
        add(new Text(movie.MovieDirector), 1, 1);
        add(new Text("Genre:"), 0, 2);
        add(new Text(movie.MovieGenre), 1, 2);
        add(new Text("Runtime (min):"), 0, 3);
        add(new Text(String.valueOf(movie.MovieRuntime)),1,3);
        add(new Text("Premiere Date:"),0,4);
        add(new Text(movie.MoviePremiereDate),1,4);

        add(new Text("About a movie:"),0,5);
        add(new Text(movie.MovieDescription),1,5);

        if(movieCover != null) {
            add(movieCover, 0, 6, 2, 1);
        }

        add(playButton, 0, 20);

        playButton.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                playMovie();
            }
        });
    }
    public static boolean detail() {return true;}

    private void playMovie()
    {
        if( Desktop.isDesktopSupported() )
        {
            new Thread(() -> {
                try {
                    Desktop.getDesktop().open(new File(movie.MoviePath));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }).start();
        }
    }
}
