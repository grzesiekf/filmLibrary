package com.group.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.format.DateTimeFormatter;

public class AddingMovie{

    Stage AddingMovieStage;

    Text directorLabel;
    Text runtimeLabel;
    Text genreLabel ;
    Text titleLabel;
    Text preimieredateLabel;
    Text MovieFileLabel;
    Text CoverFileLabel;
    Text AboutMovieLabel;
    Text SelectedFileText;
    Text SelectedCoverText;
    TextField titleText;

    Label FilePathLabel;
    Label CoverPathLabel;

    TextArea AboutMovieArea;

    TextField directorText;

    SpinnerValueFactory <Integer> valueFactory;
    Spinner<Integer> MovieRuntimeSpinner;

    Button addfile;
    Button addCover;
    Button addbutton;

    DatePicker premieredate;

    FileChooser MoviefileChooser;
    FileChooser CoverfileChooser;

    ChoiceBox GenreBox;

    GridPane gridPane;

    Scene scene;


    AddingMovie(){

        this.AddingMovieStage = new Stage();

        this.directorLabel = new Text("Directed By:");
        this.runtimeLabel = new Text("Runtime (min):");
        this.genreLabel = new Text("Genre:");
        this.titleLabel = new Text("Title:");
        this.FilePathLabel = new Label("");
        this.CoverPathLabel = new Label("");
        this.preimieredateLabel = new Text("Premiere Date:");
        this.MovieFileLabel = new Text("Movie File:");
        this.CoverFileLabel = new Text("Movie Cover:");
        this.AboutMovieLabel = new Text("About a movie:");

        this.AboutMovieArea = new TextArea();
        this.SelectedFileText = new Text("");
        this.SelectedCoverText = new Text("");
        this. titleText = new TextField();
        this. directorText = new TextField();

        this.valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 300, 0);
        this.MovieRuntimeSpinner = new Spinner<Integer>();

        this.addfile = new Button("Add file");
        this.addCover = new Button("Add cover");
        this.addbutton = new Button("Finish");

        this.premieredate = new DatePicker();


        this.MoviefileChooser = new FileChooser();
        this.CoverfileChooser = new FileChooser();

        this.GenreBox = new ChoiceBox();

        this.gridPane = new GridPane();

        this.scene = new Scene(gridPane);

        this.set_buttons_on_action();
        this.set_panel();

        this.AddingMovieStage.showAndWait();

    }

    private void set_buttons_on_action(){


        this.addfile.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent e) {
                File file =   MoviefileChooser.showOpenDialog(AddingMovieStage);
                FilePathLabel.setText(file.toString());
            }});



        addCover.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent e) {
                File file =   CoverfileChooser.showOpenDialog(AddingMovieStage);
                CoverPathLabel.setText(file.toString());
            }});


        addbutton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent e) {
                
                if (titleText.getText() != null && !(titleText.getText().trim().isEmpty()) &&
                        directorText.getText() != null && !(directorText.getText().trim().isEmpty())
                        && FilePathLabel.getText() != "")
                {
                    premieredate.getValue();
                    GenreBox.getSelectionModel();
                    MovieRuntimeSpinner.getValue();
                    CoverPathLabel.getText();
                    AboutMovieArea.getText();
                    AddingMovieStage.close();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Data Error");
                    alert.setContentText("Enter all data");
                    alert.showAndWait();
                }

            }});

    }

    private void  set_panel(){

        MovieRuntimeSpinner.setValueFactory(valueFactory);
        MovieRuntimeSpinner.setEditable(true);
        MoviefileChooser.setTitle("Open Resource File");
        GenreBox.getItems().addAll
                ("Action","Adventure","Comedy","Crime","Drama","Fantasy","Historical","Horror","Romance","ScienceFiction","Thriller");

        AboutMovieArea.setPrefSize(300,200);
        AboutMovieArea.setWrapText(true);

        gridPane.setMinSize(100, 600);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.add(titleLabel, 0, 0);
        gridPane.add(titleText, 1, 0);
        gridPane.add(directorLabel, 0, 1);
        gridPane.add(directorText, 1, 1);
        gridPane.add(genreLabel, 0, 2);
        gridPane.add(runtimeLabel, 0, 3);
        gridPane.add(MovieRuntimeSpinner,1,3);
        gridPane.add(GenreBox, 1, 2);
        gridPane.add(preimieredateLabel,0,4);
        gridPane.add(premieredate,1,4);

        gridPane.add(MovieFileLabel,0,5);
        gridPane.add(addfile,1,5);
        gridPane.add(SelectedFileText,0,6);
        gridPane.add(FilePathLabel,1,6);

        gridPane.add(CoverFileLabel,0,7);
        gridPane.add(addCover,1,7);
        gridPane.add(SelectedCoverText,0,8);
        gridPane.add(CoverPathLabel,1,8);

        gridPane.add(AboutMovieLabel,0,9);
        gridPane.add(AboutMovieArea,1,10);

        gridPane.add(addbutton, 1, 20);



        titleLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        directorLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        genreLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        runtimeLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        preimieredateLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        AboutMovieLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        MovieFileLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        SelectedFileText.setStyle("-fx-font: normal bold 15px 'serif' ");
        SelectedCoverText.setStyle("-fx-font: normal bold 15px 'serif' ");
        CoverFileLabel.setStyle("-fx-font: normal bold 15px 'serif' ");

        gridPane.setStyle("-fx-background-color:FLORALWHITE;");


        AddingMovieStage.setTitle("Adding movie");
        AddingMovieStage.setScene(scene);
        AddingMovieStage.setResizable(false);

    }
    public static boolean add(){return true;}

    public Movie return_Movie(){



        String Title = titleText.getText();
        String Director = directorText.getText();
        String Genre = GenreBox.getValue().toString();
        int Runtime = MovieRuntimeSpinner.getValue();
        String PremiereDate = premieredate.getValue().format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));
        String FilePath = FilePathLabel.getText();
        String CoverPath = CoverPathLabel.getText();
        String Description = AboutMovieArea.getText();

        return new Movie(Title,Director,Genre,Runtime,PremiereDate,FilePath,Description,CoverPath);

    }

}