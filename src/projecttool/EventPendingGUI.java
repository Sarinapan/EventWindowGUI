/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttool;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Sakina Pan
 */
public class EventPendingGUI extends Application {
    
    private TableView table;
    private Text actionStatus;
    private static double xOffset = 0;
    private static double yOffset = 0;
    
    @Override
    public void start(Stage primaryStage) {
       primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image("/projecttool/NCP.PNG"));
        primaryStage.setTitle("Unit Table");
        
      

        
        Label label = new Label("Event Pending");

        label.setTextFill(Color.LIGHTGRAY);
        label.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
        label.setTranslateX(55);
        label.setTranslateY(-10);
       // HBox hb = new HBox();
        //hb.setAlignment(Pos.CENTER);
        //hb.getChildren().add(label);

        
        Image image = new Image("/projecttool/NCP.PNG");
        ImageView TIcon = new ImageView();
        TIcon.setImage(image);
        TIcon.setFitWidth(45);
        TIcon.setPreserveRatio(true);
        TIcon.setSmooth(true);
        TIcon.setCache(true);
        TIcon.setTranslateX(2);
        TIcon.setTranslateY(9);
        
       ImageView Exit = new ImageView("/projecttool/ExitButton2.PNG");
       Exit.getStyleClass().add("ImageView");
       Exit.setFitHeight(18);
       Exit.setFitWidth(18);
       Exit.setTranslateX(572);
       Exit.setTranslateY(9);
       Exit.setOnMouseClicked(new EventHandler<MouseEvent>(){
           @Override
           public void handle(MouseEvent t){
               System.exit(0);
           }
           
       });
       
       ImageView Min = new ImageView("/projecttool/minimizeButton1.PNG");
       Min.getStyleClass().add("ImageView");
       Min.setFitHeight(18);
       Min.setFitWidth(18);
       Min.setTranslateX(550);
       Min.setTranslateY(7);
       
       Min.setOnMouseClicked(new EventHandler<MouseEvent>(){
           @Override
           public void handle(MouseEvent me){
               primaryStage.setIconified(true);
           }
           
       });

       
        
       // createTable();
       table = new TableView();

        TableColumn prioityCol = new TableColumn("Prioity");
        prioityCol.setCellValueFactory(new PropertyValueFactory("Prioity"));
        TableColumn timeCol = new TableColumn("Time");
        timeCol.setCellValueFactory(new PropertyValueFactory("Time"));
        TableColumn eventNumberCol = new TableColumn("Event Number");
        eventNumberCol.setCellValueFactory(new PropertyValueFactory("Event Number"));
        TableColumn TypeCol = new TableColumn("Type");
        TypeCol.setCellValueFactory(new PropertyValueFactory("Type"));
        TableColumn locationCol = new TableColumn("Loction");
        locationCol.setCellValueFactory(new PropertyValueFactory("Location"));
        
        table.getColumns().setAll(prioityCol,timeCol,eventNumberCol,TypeCol,locationCol);
        table.setPrefWidth(450);
        table.setPrefHeight(225);
        table.setTranslateX(0);
        table.setTranslateY(24);


      
        
        
  
      actionStatus = new Text();
      actionStatus.setFill(Color.FIREBRICK);
       
           
        
       
        
        VBox vbox = new VBox(-16);
        
        vbox.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.setPadding(new Insets(-10, 0, -10, 0));

        vbox.getChildren().addAll(Exit,Min, TIcon, actionStatus,label,table );
        Scene scene = new Scene(vbox, 600,300); // w x h
       
       
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.getScene().setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset = primaryStage.getX() - event.getScreenX();
                yOffset = primaryStage.getY() - event.getScreenY();
            }
        });
        primaryStage.getScene().setOnMouseDragged(new EventHandler<MouseEvent>() { 

          @Override 
          public void handle(MouseEvent event) { 
          
                primaryStage.setX(event.getScreenX() + xOffset);
                primaryStage.setY(event.getScreenY() + yOffset);
          } 
           
        }); 
        
     
     // Resizer.addResizeListener(primaryStage);
    
    
    }
}  
   

      
   
    

