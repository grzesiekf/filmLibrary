package com.group.app;

import java.io.Serializable;

public class Movie implements Serializable {

    String MovieTitle;
    String MovieDirector;
    String MovieGenre;
    int MovieRuntime;
    String MoviePremiereDate;
    String MoviePath;
    String MovieDescription;
    String MovieCover;


    Movie(String MovieTitle,String MovieDirector,String MovieGenre,int MovieRuntime,
          String MoviePremiereDate,String MoviePath,String MovieDescription,String MovieCover){
        this.MovieTitle = MovieTitle;
        this.MovieGenre = MovieGenre;
        this.MovieDirector = MovieDirector;
        this.MovieRuntime = MovieRuntime;
        this.MoviePremiereDate = MoviePremiereDate;
        this.MoviePath = MoviePath;
        this.MovieDescription = MovieDescription;
        this.MovieCover = MovieCover;

    }

    public void show_details(){
        System.out.println(this.MovieTitle );
        System.out.println(this.MovieGenre );
        System.out.println(this.MovieDirector);
        System.out.println(this.MovieRuntime );
        System.out.println(this.MoviePremiereDate);
        System.out.println(this.MoviePath);
        System.out.println(this.MovieDescription);
        System.out.println(this.MovieCover);

    }

    public static boolean movie() {return true;}


    @Override
    public String toString() {
        return new StringBuffer(" MovieTitle: ").append(this.MovieTitle)
                .append(" MovieGenre: ").append(this.MovieGenre).append(" MovieDirector: ").append(this.MovieDirector)
                .append(" MovieRuntime: ").append(this.MovieRuntime ).append(" MoviePremiereDate: ").append(this.MoviePremiereDate)
                .append(" MoviePath: ").append(this.MoviePath ).append(" MovieDescription: ").append(this.MovieDescription)
                .append(" MovieDescription: ").append(this.MovieCover).toString();
    }


}