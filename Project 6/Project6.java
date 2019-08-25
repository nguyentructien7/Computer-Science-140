/*
 * Project 6
 * author: Tien Nguyen
 * date: December -17-2015
 * description: This project is about javaFX,panes, pictures, buttons, arrays - display the image and add a function to each button.
 */
package project.pkg6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author tiennguyen
 */
public class Project6 extends Application {

    @Override
    public void start(Stage primaryStage) {
        final int WIDTH = 750;
        final int HEIGHT = 750;
        final int CenterX = 750;
        final int CenterY = 750;
        //All of the pane
        BorderPane borderPane = new BorderPane();//stick to the scene
        FlowPane flowPane = new FlowPane();//line them up left to right
        Pane pane = new Pane();
        flowPane.setPadding(new Insets(35, 35, 50, 50));//how far the picture away from the sene
        //Set the buttons on top of the image
        //StackPane pane2 = new StackPane();
        borderPane.setStyle("-fx-background-image: url(\"http://cdn.imgs.tuts.dragoart.com/how-to-draw-a-cute-pig_1_000000004097_5.jpg\"); "
                + "-fx-background-repeat: stretch;"
                + "-fx-background-size: HEIGHT WIDTH;"
                + "-fx-background-position: center center; ");//display the image
        borderPane.setTop(flowPane);

        // create 5 buttons
        Button icon1 = new Button();
        Button icon2 = new Button();
        Button icon3 = new Button();
        Button icon4 = new Button();
        Button icon5 = new Button();
        //set the buttons next to each other
        flowPane.getChildren().add(icon1);
        flowPane.getChildren().add(icon2);
        flowPane.getChildren().add(icon3);
        flowPane.getChildren().add(icon4);
        flowPane.getChildren().add(icon5);

        // The tile of the buttons
        icon1.setText("DIAGONAL FLIP");
        icon2.setText("GRAYSCALE");
        icon3.setText("MOSAIC");
        icon4.setText("ADD FLAIR");
        icon5.setText("ORIGINAL");

        //Button 1: “Diagonal Flip” 
        icon1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Image image1 = new Image("http://cdn.imgs.tuts.dragoart.com/how-to-draw-a-cute-pig_1_000000004097_5.jpg");

                // get the width & heightof the images
                int width = (int) image1.getWidth();
                int height = (int) image1.getHeight();

                WritableImage writableImage = new WritableImage(width, height);
                //set up to read image pixels
                PixelReader pixelReader = image1.getPixelReader();
                PixelWriter pixelWriter = writableImage.getPixelWriter();

                int[][] imageArray = new int[width][height];
                //check the rows and the column and match it with the picture
                for (int p = 0; p < imageArray.length; p++) {
                    for (int o = 0; o < imageArray[p].length; o++) {
                        Color color = pixelReader.getColor(p, o);
                        pixelWriter.setColor(p, (imageArray.length - 1) - o, color);
                    }
                }

                ImageView image01 = new ImageView(writableImage);
                borderPane.getChildren().clear();//clear the border pane
                flowPane.getChildren().clear();//clear the flow pane]
                borderPane.getChildren().add(image01);//display the image
                flowPane.getChildren().addAll(icon1, icon2, icon3, icon4, icon5);//add the buttons back 
                borderPane.setCenter(flowPane);//put the flow pane with the buttons back into the flow pane

            }
        });
        //Button 2: “Grayscale” 
        icon2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Image image2 = new Image("http://cdn.imgs.tuts.dragoart.com/how-to-draw-a-cute-pig_1_000000004097_5.jpg");
                // get the width & heightof the images
                int width = (int) image2.getWidth();
                int height = (int) image2.getHeight();
                //set up to read image pixels
                WritableImage writableImage = new WritableImage(width, height);
                PixelWriter pixelWriter = writableImage.getPixelWriter();
                PixelReader pixelReader = image2.getPixelReader();
                int[][] imageArray4 = new int[width][height];

                // check the pixel
                for (int d = 0; d < imageArray4.length; d++) {
                    for (int f = 0; f < imageArray4[d].length; f++) {
                         //read the color
                        Color gray = pixelReader.getColor(d, f);
                       //Stored the color
                        double colorRed = gray.getRed();
                        double colorGreen = gray.getGreen();
                        double colorBlue = gray.getBlue();
                        // calculate the average by add them up and divide by how many number there are
                        double avgerage = (colorRed + colorGreen +colorBlue) / 3;
                        
                        Color ChangeToGray = new Color(avgerage, avgerage, avgerage, 1);
                        //change the color to gray
                        pixelWriter.setColor(d, f, ChangeToGray);

                    }
                }

                ImageView finalImage2 = new ImageView(writableImage);
                borderPane.getChildren().clear();//clear the border pane
                flowPane.getChildren().clear();//clear the flow pane
                borderPane.getChildren().add(finalImage2);//print out the image gray
                flowPane.getChildren().addAll(icon1, icon2, icon3, icon4, icon5); //add the buttons back 
                borderPane.setCenter(flowPane);//put the flow pane with the buttons back into the flow pane
                

            }
        }
        );
        //Button 3: “Mosaic” 
        icon3.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Image image3 = new Image("http://cdn.imgs.tuts.dragoart.com/how-to-draw-a-cute-pig_1_000000004097_5.jpg");

                        // get the width & heightof the images
                        int two = 2;
                        int x = 0;
                        int y = 0;
                        int width = (int) image3.getWidth() / two;
                        int height = (int) image3.getHeight() / two;
                        int chunks = height * width;

                        WritableImage writableImage = new WritableImage(width, height);
                        //set up to read image pixels
                        PixelReader pixelReader = image3.getPixelReader();
                        PixelWriter pixelWriter = writableImage.getPixelWriter();

                        int[][] imageArray3 = new int[width][height];
                        for (int d = 0; d < imageArray3.length; d++) {
                            for (int f = 0; f < imageArray3[d].length; f++) {
                                
                                //imageArray3[d][f].addAll( splitImage( image3.getPart( d + width ,f + height ,width, height )) );
                            }
                        }

                        ImageView finalImage3 = new ImageView(writableImage);
                        borderPane.getChildren().clear();//clear the border pane
                        flowPane.getChildren().clear();//clear the flow pane
                        borderPane.getChildren().add(finalImage3);//displays the image
                        flowPane.getChildren().addAll(icon1, icon2, icon3, icon4, icon5);//add the buttons back 
                        borderPane.setCenter(flowPane);//put the flow pane with the buttons back into the flow pane
                       

                    }
                }
        );
        // Button 4: “Add Flair”
        icon4.setOnAction((ActionEvent event) -> {
            Image bacon = new Image("http://www.clipartlord.com/wp-content/uploads/2015/01/bacon2.png");
            PixelReader pixelReader = bacon.getPixelReader();

            // get the width & heightof the images
            int width = (int) bacon.getWidth();
            int height = (int) bacon.getHeight();
            //set up to read image pixels
            WritableImage writableImage = new WritableImage(width, height);
            PixelWriter pixelWriter = writableImage.getPixelWriter();

            int[][] imageArray4 = new int[width][height];

            // check the height and width
            for (int d = 0; d < imageArray4.length; d++) {
                for (int f = 0; f < imageArray4[d].length; f++) {
                    Color color = pixelReader.getColor(d, f);
                    if (color.equals(Color.WHITE) || color.equals(Color.TRANSPARENT)) {
                        pixelWriter.setColor(d, f, color);
                    }
                    pixelWriter.setColor(d, f, color);
                }
            }

            ImageView finalImage = new ImageView(writableImage);
            borderPane.getChildren().clear();//clear the border pane
            flowPane.getChildren().clear();//clear the flow pane
            borderPane.getChildren().add(finalImage);
            flowPane.getChildren().addAll(icon1, icon2, icon3, icon4, icon5);//add the buttons back
            borderPane.setCenter(flowPane);//put the flow pane with the buttons back into the flow pane
        });
        //Button 5: “Original”
        icon5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                borderPane.getChildren().clear();//clear the border pane
                flowPane.getChildren().clear();//clear the flow pane
                borderPane.setStyle("-fx-background-image: url(\"http://cdn.imgs.tuts.dragoart.com/how-to-draw-a-cute-pig_1_000000004097_5.jpg\"); "
                        + "-fx-background-repeat: stretch;"
                        + "-fx-background-size: HEIGHT WIDTH;"
                        + "-fx-background-position: center center; ");
                flowPane.getChildren().addAll(icon1, icon2, icon3, icon4, icon5);//add the buttons back 
                borderPane.setCenter(flowPane);//put the flow pane with the buttons back into the flow pane
            }
        }
        );
        //This is the entire frame
        Scene scene = new Scene(borderPane, WIDTH, HEIGHT);

        // Title the image
        primaryStage.setTitle("Piggy!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
