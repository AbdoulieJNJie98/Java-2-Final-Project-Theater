/*
 * Abdoulie J NJie
 * CIST 2372
 * 4/21/2020
 This program uses a JavaFX interface to show off how a 4 moive theaters with different show times allows a user to 
 pick their seat. This user will be click on whichever theater they may like, and choose which movie and showtime
 to buy ticket for.
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;  
import java.util.Scanner;

public class FinalProjectJava2 extends Application
{
    int totalNumberOfTicketsSold = 0; // accumerlator that will hold the number of tickets sold per show time
    int count = 0; // number user to help keep count of the number of tickets sold
    protected Text text = new Text(); // protected text that will be used through out the program   
    
    protected BorderPane getPane() // pane method that will help set the interface up
    {
        // radio buttons that repserenting the different theaters
        RadioButton theaterOne = new RadioButton("Theater 1");
        RadioButton theaterTwo = new RadioButton("Theater 2");
        RadioButton theaterThree = new RadioButton("Theater 3");
        RadioButton theaterFour = new RadioButton("Theater 4");
       
        VBox paneForRadioButtons = new VBox(20); // Vobx pane that will align the radio buttons
        // the set up of the pane for the radio buttons
        paneForRadioButtons.setAlignment(Pos.BASELINE_LEFT);
        paneForRadioButtons.setStyle("-fix-border-color: black");
        paneForRadioButtons.getChildren().addAll(theaterOne, theaterTwo, theaterThree, theaterFour);
        
        BorderPane pane = new BorderPane(); //new border pane to ceneter the radio buttons
        pane.setCenter(paneForRadioButtons); // centering pane for radio buttons
        
        
        
        // toggle group to hold the radio buttons in one block space
        ToggleGroup group = new ToggleGroup();
        theaterOne.setToggleGroup(group);
        theaterTwo.setToggleGroup(group);
        theaterThree.setToggleGroup(group);
        theaterFour.setToggleGroup(group);
        
        // action events that will deteremine what will be displayed based off which button the user clicks 
        theaterOne.setOnAction(a ->
        {
            // if statement that will determine what happens when theater one is clikced
            if (theaterOne.isSelected())
            {
                text.setFill(Color.BLACK);
            
                // text header for theater
                Text textForTheaterOne = new Text(10,15, "Thearter One Showtimes");
                Pane paneForTheaterOneText = new Pane();
                pane.setTop(paneForTheaterOneText);
                paneForTheaterOneText.getChildren().addAll(textForTheaterOne);
                        
                // radio buttons to hold showtimes
                RadioButton showTime1 = new RadioButton("Kill Bill Show Times");
                RadioButton showTime2 = new RadioButton("Howl's Moving Castel Show Times");
                RadioButton showTime3 = new RadioButton("Pulp Fiction Show Times");
                
                // pane for the radio buttons of the showtimes
                VBox paneForRad = new VBox(20);
                paneForRad.setPadding(new Insets(5, 5, 5, 5));
                paneForRad.setStyle("-fix-border-color: black");
                paneForRad.getChildren().addAll(showTime1, showTime2, showTime3);
                pane.setCenter(paneForRad);
        
                // toggle group to group the radio buttons
                ToggleGroup group1 = new ToggleGroup();
                showTime1.setToggleGroup(group1);
                showTime2.setToggleGroup(group1);
                showTime3.setToggleGroup(group1);
                    
                    // action event that will show what happens when user clicks one of the showtimes
                    showTime1.setOnAction(b ->
                    {
                        totalNumberOfTicketsSold = 100;
                                    
                        // if statement that will show the showtimes of kill bill
                        if(showTime1.isSelected())
                        { 
                        Text textForTheaterOneFilmOne = new Text(10,15, "Kill Bill Showtimes");
                        Pane paneForTheaterOneFilmOne = new Pane();
                        pane.setTop(paneForTheaterOneFilmOne);
                        paneForTheaterOneFilmOne.getChildren().addAll(textForTheaterOneFilmOne);
                        
                        // radio buttons for showtimes
                        RadioButton showTimeA = new RadioButton("Kill Bill 10:00 AM" );
                        RadioButton showTimeB = new RadioButton("Kill Bill 3:00 PM Sold Out");
                        RadioButton showTimeC = new RadioButton("Kill Bill 8:00 PM Sold Out" );
                        
                        // pane for showtimes
                        VBox paneForShowTimeTheaterOneKill = new VBox(20);
                        paneForShowTimeTheaterOneKill.setPadding(new Insets(5, 5, 5, 5));
                        paneForShowTimeTheaterOneKill.setStyle("-fix-border-color: black");
                        paneForShowTimeTheaterOneKill.getChildren().addAll(showTimeA, showTimeB, showTimeC);
                        pane.setCenter(paneForShowTimeTheaterOneKill);
        
                        // toggle gorup for showtimes for kill be
                        ToggleGroup showTimeOneKill = new ToggleGroup();
                        showTimeA.setToggleGroup(showTimeOneKill);
                        showTimeB.setToggleGroup(showTimeOneKill);
                        showTimeC.setToggleGroup(showTimeOneKill);
                        
                            // event actio that shows what happens when a showtime from a specfic film's showtime is clicked
                            showTimeA.setOnAction (c ->
                            {
                                
                                if(showTimeA.isSelected())
                                {
                                   Text textForTheaterOneKillSeats = new Text(10,15, "Seats");
                                   Pane paneForTheaterOneKillSeats = new Pane();
                                   pane.setTop(paneForTheaterOneKillSeats);
                                   paneForTheaterOneKillSeats.getChildren().addAll(textForTheaterOneKillSeats);
                                   
                                   
                                    //boolean seatIsPressed = false;
                                   
                                    // array list that will create 50 radio buttons to repsernset seats
                                     ArrayList<RadioButton> theaterOneKillSeats = new ArrayList<>();
                                    for(int i = 0; i < 50; i++)
                                    {
                                        RadioButton seatsKillOne = new RadioButton("S" + (i + 1));
                                        theaterOneKillSeats.add(seatsKillOne);
                                        
                                        if(i < 30)
                                        {
                                            totalNumberOfTicketsSold = 130;
                                            seatsKillOne.setSelected(true);
                                            seatsKillOne.setTextFill(Color.RED);
                                        }
                                        
                                        seatsKillOne.setOnAction(C->
                                        {
                                            if(seatsKillOne.isSelected() == true)
                                            {
                                                count++;
                                            }
                                            else
                                            {
                                                count--;
                                            }
                                        });
                                    }
                                   
                                   Button confirm = new Button("Confirm");
                                   Pane paneForConfrim = new Pane();
                                   paneForConfrim.getChildren().addAll(confirm);
                                   pane.setBottom(paneForConfrim);
                                    
                                    confirm.setOnAction(D ->
                                    {
                                       totalNumberOfTicketsSold = 130 + count;
                                       System.out.println("You have purchased " + count + " Tickets.");
                                       System.out.println("The total number of tickets sold today in Theater One Kill Bill: " + totalNumberOfTicketsSold);
                                       System.exit(0);
                                    });
                                    
                                    
                                    
                   
                                    FlowPane paneForSetOneSeats = new FlowPane();
                                    paneForSetOneSeats.setHgap(5);
                                    paneForSetOneSeats.setVgap(5);

                    
                                    paneForSetOneSeats.setPadding(new Insets(5,5,5,5));
                                    paneForSetOneSeats.setStyle("-fix-border-color:black");
                    
                                    paneForSetOneSeats.getChildren().addAll(theaterOneKillSeats);
                    
                                    pane.setCenter(paneForSetOneSeats);
                                }
                            });
                        }
                    });
                    
                     showTime2.setOnAction(d ->
                    {
                                    
                        // if statement that will show the showtimes of kill bill
                        if(showTime2.isSelected())
                        { 
                        Text textForTheaterOneFilmTwo = new Text(10,15, "Howl's Moiving Castel Showtimes");
                        Pane paneForTheaterOneFilmTwo = new Pane();
                        pane.setTop(paneForTheaterOneFilmTwo);
                        paneForTheaterOneFilmTwo.getChildren().addAll(textForTheaterOneFilmTwo);
                        
            
                        RadioButton showTimeA2 = new RadioButton("Howl's Moiving Castel 10:00 AM Sold Out" );
                        RadioButton showTimeB2 = new RadioButton("Howl's Moiving Castel 3:00 PM");
                        RadioButton showTimeC2 = new RadioButton("Howl's Moiving Castel 8:00 PM Sold Out" );
       
                        VBox paneForShowTimeTheaterOneHowl = new VBox(20);
                        paneForShowTimeTheaterOneHowl.setPadding(new Insets(5, 5, 5, 5));
                        paneForShowTimeTheaterOneHowl.setStyle("-fix-border-color: black");
                        paneForShowTimeTheaterOneHowl.getChildren().addAll(showTimeA2, showTimeB2, showTimeC2);
                        pane.setCenter(paneForShowTimeTheaterOneHowl);
        
        
                        ToggleGroup showTimeOneKill = new ToggleGroup();
                        showTimeA2.setToggleGroup(showTimeOneKill);
                        showTimeB2.setToggleGroup(showTimeOneKill);
                        showTimeC2.setToggleGroup(showTimeOneKill);
                    
                            showTimeB2.setOnAction (e ->
                            {
                                if(showTimeB2.isSelected())
                                {
                                   Text textForTheaterOneHowlSeats = new Text(10,15, "Seats");
                                   Pane paneForTheaterOneHowlSeats = new Pane();
                                   pane.setTop(paneForTheaterOneHowlSeats);
                                   paneForTheaterOneHowlSeats.getChildren().addAll(textForTheaterOneHowlSeats);
                                   
                                    
                                   
                                    // array list that will create 50 radio buttons to repsernset seats
                                     ArrayList<RadioButton> theaterOneHowlSeats = new ArrayList<>();
                                    for(int i = 0; i < 50; i++)
                                    {
                                        RadioButton seatsHowlOne = new RadioButton("S" + (i + 1));
                                        theaterOneHowlSeats.add(seatsHowlOne);
                                        
                                         if(i < 30)
                                        {
                                            seatsHowlOne.setSelected(true);
                                            seatsHowlOne.setTextFill(Color.RED);
                                        }
                                        
                                        seatsHowlOne.setOnAction(C->
                                        {
                                            if(seatsHowlOne.isSelected() == true)
                                            {
                                                count++;
                                            }
                                            else
                                            {
                                                count--;
                                            }
                                        });
                                        
                                   Button confirm = new Button("Confirm");
                                   Pane paneForConfrim = new Pane();
                                   paneForConfrim.getChildren().addAll(confirm);
                                   pane.setBottom(paneForConfrim);
                                    
                                    confirm.setOnAction(D ->
                                    {
                                       totalNumberOfTicketsSold = 130 + count;
                                       System.out.println("You have purchased " + count + " Tickets.");
                                       System.out.println("The total number of tickets sold today in Theater One Kill Bill: " + totalNumberOfTicketsSold);
                                       System.exit(0);
                                    });
                                    }
                                   
                   
                                    FlowPane paneForSetOneSeats = new FlowPane();
                                    paneForSetOneSeats.setHgap(5);
                                    paneForSetOneSeats.setVgap(5);

                    
                                    paneForSetOneSeats.setPadding(new Insets(5,5,5,5));
                                    paneForSetOneSeats.setStyle("-fix-border-color:black");
                    
                                    paneForSetOneSeats.getChildren().addAll(theaterOneHowlSeats);
                    
                                    pane.setCenter(paneForSetOneSeats);
                                }
                            });
                        }
                    });
                     
                     
                        showTime3.setOnAction(f ->
                    {
                                    
                        // if statement that will show the showtimes of kill bill
                        if(showTime3.isSelected())
                        { 
                        Text textForTheaterOneFilmThree = new Text(10,15, "Pulp Fiction Showtimes");
                        Pane paneForTheaterOneFilmThree = new Pane();
                        pane.setTop(paneForTheaterOneFilmThree);
                        paneForTheaterOneFilmThree.getChildren().addAll(textForTheaterOneFilmThree);
                        
            
                        RadioButton showTimeA3 = new RadioButton("Pulp Fiction 10:00 AM Sold Out" );
                        RadioButton showTimeB3 = new RadioButton("Pulp Fiction 3:00 PM Sold Out");
                        RadioButton showTimeC3 = new RadioButton("Pulp Fiction 8:00 PM" );
       
                        VBox paneForShowTimeTheaterOnePulp = new VBox(20);
                        paneForShowTimeTheaterOnePulp.setPadding(new Insets(5, 5, 5, 5));
                        paneForShowTimeTheaterOnePulp.setStyle("-fix-border-color: black");
                        paneForShowTimeTheaterOnePulp.getChildren().addAll(showTimeA3, showTimeB3, showTimeC3);
                        pane.setCenter(paneForShowTimeTheaterOnePulp);
        
        
                        ToggleGroup showTimeOneKill = new ToggleGroup();
                        showTimeA3.setToggleGroup(showTimeOneKill);
                        showTimeB3.setToggleGroup(showTimeOneKill);
                        showTimeC3.setToggleGroup(showTimeOneKill);
                    
                            showTimeC3.setOnAction (g ->
                            {
                                if(showTimeC3.isSelected())
                                {
                                   Text textForTheaterOnePulpSeats = new Text(10,15, "Seats");
                                   Pane paneForTheaterOnePulpSeats = new Pane();
                                   pane.setTop(paneForTheaterOnePulpSeats);
                                   paneForTheaterOnePulpSeats.getChildren().addAll(textForTheaterOnePulpSeats);
                                   
                                    
                                   
                                    // array list that will create 50 radio buttons to repsernset seats
                                     ArrayList<RadioButton> theaterOnePulpSeats = new ArrayList<>();
                                    for(int i = 0; i < 50; i++)
                                    {
                                        RadioButton seatsPulpOne = new RadioButton("S" + (i + 1));
                                        theaterOnePulpSeats.add(seatsPulpOne);
                                        
                                                                                
                                         if(i < 30)
                                        {
                                            seatsPulpOne.setSelected(true);
                                            seatsPulpOne.setTextFill(Color.RED);
                                        }
                                        
                                        seatsPulpOne.setOnAction(C->
                                        {
                                            if(seatsPulpOne.isSelected() == true)
                                            {
                                                count++;
                                            }
                                            else
                                            {
                                                count--;
                                            }
                                        });
                                        
                                   Button confirm = new Button("Confirm");
                                   Pane paneForConfrim = new Pane();
                                   paneForConfrim.getChildren().addAll(confirm);
                                   pane.setBottom(paneForConfrim);
                                    
                                    confirm.setOnAction(D ->
                                    {
                                       totalNumberOfTicketsSold = 130 + count;
                                       System.out.println("You have purchased " + count + " Tickets.");
                                       System.out.println("The total number of tickets sold today in Theater One Kill Bill: " + totalNumberOfTicketsSold);
                                       System.exit(0);
                                    });
                                    }
                                        
                                    
                                    
                   
                                    FlowPane paneForSetOneSeats = new FlowPane();
                                    paneForSetOneSeats.setHgap(5);
                                    paneForSetOneSeats.setVgap(5);

                    
                                    paneForSetOneSeats.setPadding(new Insets(5,5,5,5));
                                    paneForSetOneSeats.setStyle("-fix-border-color:black");
                    
                                    paneForSetOneSeats.getChildren().addAll(theaterOnePulpSeats);
                    
                                    pane.setCenter(paneForSetOneSeats);
                                }
                            });
                        }
                    });
            }
        });
        
        
        theaterTwo.setOnAction(h ->
        {
            if (theaterTwo.isSelected())
            {
                text.setFill(Color.BLACK);
                
                Text textForTheaterTwo = new Text(10,15, "Thearter Two Showtimes");
                Pane paneForTheaterTwoText = new Pane();
                pane.setTop(paneForTheaterTwoText);
                paneForTheaterTwoText.getChildren().addAll(textForTheaterTwo);
                        
            
                RadioButton showTime4 = new RadioButton("Kill Bill Show Times");
                RadioButton showTime5 = new RadioButton("Howl's Moving Castel Show Times");
                RadioButton showTime6 = new RadioButton("Pulp Fiction Show Times");
       
                VBox paneForRad = new VBox(20);
                paneForRad.setPadding(new Insets(5, 5, 5, 5));
                paneForRad.setStyle("-fix-border-color: black");
                paneForRad.getChildren().addAll(showTime4, showTime5, showTime6);
                pane.setCenter(paneForRad);
        
        
                ToggleGroup group1 = new ToggleGroup();
                showTime4.setToggleGroup(group1);
                showTime5.setToggleGroup(group1);
                showTime6.setToggleGroup(group1);
 
                    showTime4.setOnAction(b ->
                    {
                        totalNumberOfTicketsSold = 100;
                                    
                        // if statement that will show the showtimes of kill bill
                        if(showTime4.isSelected())
                        { 
                        Text textForTheaterOneFilmOne = new Text(10,15, "Kill Bill Showtimes");
                        Pane paneForTheaterOneFilmOne = new Pane();
                        pane.setTop(paneForTheaterOneFilmOne);
                        paneForTheaterOneFilmOne.getChildren().addAll(textForTheaterOneFilmOne);
                        
            
                        RadioButton showTimeA4 = new RadioButton("Kill Bill 10:00 AM Sold Out" );
                        RadioButton showTimeB4 = new RadioButton("Kill Bill 3:00 PM");
                        RadioButton showTimeC4 = new RadioButton("Kill Bill 8:00 PM Sold Out" );
       
                        VBox paneForShowTimeTheaterTwoKill = new VBox(20);
                        paneForShowTimeTheaterTwoKill.setPadding(new Insets(5, 5, 5, 5));
                        paneForShowTimeTheaterTwoKill.setStyle("-fix-border-color: black");
                        paneForShowTimeTheaterTwoKill.getChildren().addAll(showTimeA4, showTimeB4, showTimeC4);
                        pane.setCenter(paneForShowTimeTheaterTwoKill);
        
        
                        ToggleGroup showTimeOneKill = new ToggleGroup();
                        showTimeA4.setToggleGroup(showTimeOneKill);
                        showTimeB4.setToggleGroup(showTimeOneKill);
                        showTimeC4.setToggleGroup(showTimeOneKill);
                        
                            
                            showTimeB4.setOnAction (c ->
                            {
                                
                                if(showTimeB4.isSelected())
                                {
                                   Text textForTheaterTwoKillSeats = new Text(10,15, "Seats");
                                   Pane paneForTheaterTwoKillSeats = new Pane();
                                   pane.setTop(paneForTheaterTwoKillSeats);
                                   paneForTheaterTwoKillSeats.getChildren().addAll(textForTheaterTwoKillSeats);
                                   
                                   
                                    // array list that will create 50 radio buttons to repsernset seats
                                     ArrayList<RadioButton> theaterTwoKillSeats = new ArrayList<>();
                                    for(int i = 0; i < 50; i++)
                                    {
                                        RadioButton seatsKillTwo = new RadioButton("S" + (i + 1));
                                        theaterTwoKillSeats.add(seatsKillTwo);
                                        //seatIsPressed = seatsKillOne.isPressed();
                                        
                                        if(i < 30)
                                        {
                                            totalNumberOfTicketsSold = 130;
                                            seatsKillTwo.setSelected(true);
                                            seatsKillTwo.setTextFill(Color.RED);
                                        }
                                        
                                        seatsKillTwo.setOnAction(C->
                                        {
                                            if(seatsKillTwo.isSelected() == true)
                                            {
                                                count++;
                                            }
                                            else
                                            {
                                                count--;
                                            }
                                        });
                                    }
                                   
                                   Button confirm = new Button("Confirm");
                                   Pane paneForConfrim = new Pane();
                                   paneForConfrim.getChildren().addAll(confirm);
                                   pane.setBottom(paneForConfrim);
                                    
                                    confirm.setOnAction(D ->
                                    {
                                       totalNumberOfTicketsSold = 130 + count;
                                       System.out.println("You have purchased " + count + " Tickets.");
                                       System.out.println("The total number of tickets sold today in Theater Two Kill Bill: " + totalNumberOfTicketsSold);
                                       System.exit(0);
                                    });
                                    
                                    
                                    
                   
                                    FlowPane paneForSetOneSeats = new FlowPane();
                                    paneForSetOneSeats.setHgap(5);
                                    paneForSetOneSeats.setVgap(5);

                    
                                    paneForSetOneSeats.setPadding(new Insets(5,5,5,5));
                                    paneForSetOneSeats.setStyle("-fix-border-color:black");
                    
                                    paneForSetOneSeats.getChildren().addAll(theaterTwoKillSeats);
                    
                                    pane.setCenter(paneForSetOneSeats);
                                }
                            });
                        }
                    });
                    
                     showTime5.setOnAction(d ->
                    {
                                    
                        // if statement that will show the showtimes of kill bill
                        if(showTime5.isSelected())
                        { 
                        Text textForTheaterOneFilmTwo = new Text(10,15, "Howl's Moiving Castel Showtimes");
                        Pane paneForTheaterOneFilmTwo = new Pane();
                        pane.setTop(paneForTheaterOneFilmTwo);
                        paneForTheaterOneFilmTwo.getChildren().addAll(textForTheaterOneFilmTwo);
                        
            
                        RadioButton showTimeA5 = new RadioButton("Howl's Moiving Castel 10:00 AM Sold Out" );
                        RadioButton showTimeB5 = new RadioButton("Howl's Moiving Castel 3:00 PM Sold Out");
                        RadioButton showTimeC5 = new RadioButton("Howl's Moiving Castel 8:00 PM" );
       
                        VBox paneForShowTimeTheaterTwoHowl = new VBox(20);
                        paneForShowTimeTheaterTwoHowl.setPadding(new Insets(5, 5, 5, 5));
                        paneForShowTimeTheaterTwoHowl.setStyle("-fix-border-color: black");
                        paneForShowTimeTheaterTwoHowl.getChildren().addAll(showTimeA5, showTimeB5, showTimeC5);
                        pane.setCenter(paneForShowTimeTheaterTwoHowl);
        
        
                        ToggleGroup showTimeOneKill = new ToggleGroup();
                        showTimeA5.setToggleGroup(showTimeOneKill);
                        showTimeB5.setToggleGroup(showTimeOneKill);
                        showTimeC5.setToggleGroup(showTimeOneKill);
                    
                            showTimeC5.setOnAction (e ->
                            {
                                if(showTimeC5.isSelected())
                                {
                                   Text textForTheaterOneHowlSeats = new Text(10,15, "Seats");
                                   Pane paneForTheaterOneHowlSeats = new Pane();
                                   pane.setTop(paneForTheaterOneHowlSeats);
                                   paneForTheaterOneHowlSeats.getChildren().addAll(textForTheaterOneHowlSeats);
                                   
                                    
                                   
                                    // array list that will create 50 radio buttons to repsernset seats
                                     ArrayList<RadioButton> theaterOneHowlSeats = new ArrayList<>();
                                    for(int i = 0; i < 50; i++)
                                    {
                                        RadioButton seatsHowlTwo = new RadioButton("S" + (i + 1));
                                        theaterOneHowlSeats.add(seatsHowlTwo);
                                        
                                         if(i < 30)
                                        {
                                            seatsHowlTwo.setSelected(true);
                                            seatsHowlTwo.setTextFill(Color.RED);
                                        }
                                        
                                        seatsHowlTwo.setOnAction(C->
                                        {
                                            if(seatsHowlTwo.isSelected() == true)
                                            {
                                                count++;
                                            }
                                            else
                                            {
                                                count--;
                                            }
                                        });
                                        
                                   Button confirm = new Button("Confirm");
                                   Pane paneForConfrim = new Pane();
                                   paneForConfrim.getChildren().addAll(confirm);
                                   pane.setBottom(paneForConfrim);
                                    
                                    confirm.setOnAction(D ->
                                    {
                                       totalNumberOfTicketsSold = 130 + count;
                                       System.out.println("You have purchased " + count + " Tickets.");
                                       System.out.println("The total number of tickets sold today in Theater Two Howl's Moving Castel: " + totalNumberOfTicketsSold);
                                       System.exit(0);
                                    });
                                    }
                                   
                   
                                    FlowPane paneForSetOneSeats = new FlowPane();
                                    paneForSetOneSeats.setHgap(5);
                                    paneForSetOneSeats.setVgap(5);

                    
                                    paneForSetOneSeats.setPadding(new Insets(5,5,5,5));
                                    paneForSetOneSeats.setStyle("-fix-border-color:black");
                    
                                    paneForSetOneSeats.getChildren().addAll(theaterOneHowlSeats);
                    
                                    pane.setCenter(paneForSetOneSeats);
                                }
                            });
                        }
                    });
                     
                     
                        showTime6.setOnAction(f ->
                    {
                                    
                        // if statement that will show the showtimes of kill bill
                        if(showTime6.isSelected())
                        { 
                        Text textForTheaterTwoFilmThree = new Text(10,15, "Pulp Fiction Showtimes");
                        Pane paneForTheaterTwoFilmThree = new Pane();
                        pane.setTop(paneForTheaterTwoFilmThree);
                        paneForTheaterTwoFilmThree.getChildren().addAll(textForTheaterTwoFilmThree);
                        
            
                        RadioButton showTimeA6 = new RadioButton("Pulp Fiction 10:00 AM" );
                        RadioButton showTimeB6 = new RadioButton("Pulp Fiction 3:00 PM Sold Out");
                        RadioButton showTimeC6 = new RadioButton("Pulp Fiction 8:00 PM Sold Out" );
       
                        VBox paneForShowTimeTheaterTwoPulp = new VBox(20);
                        paneForShowTimeTheaterTwoPulp.setPadding(new Insets(5, 5, 5, 5));
                        paneForShowTimeTheaterTwoPulp.setStyle("-fix-border-color: black");
                        paneForShowTimeTheaterTwoPulp.getChildren().addAll(showTimeA6, showTimeB6, showTimeC6);
                        pane.setCenter(paneForShowTimeTheaterTwoPulp);
        
        
                        ToggleGroup showTimeOneKill = new ToggleGroup();
                        showTimeA6.setToggleGroup(showTimeOneKill);
                        showTimeB6.setToggleGroup(showTimeOneKill);
                        showTimeC6.setToggleGroup(showTimeOneKill);
                    
                            showTimeA6.setOnAction (g ->
                            {
                                if(showTimeA6.isSelected())
                                {
                                   Text textForTheaterTwoPulpSeats = new Text(10,15, "Seats");
                                   Pane paneForTheaterTwoPulpSeats = new Pane();
                                   pane.setTop(paneForTheaterTwoPulpSeats);
                                   paneForTheaterTwoPulpSeats.getChildren().addAll(textForTheaterTwoPulpSeats);
                                   
                                    
                                   
                                    // array list that will create 50 radio buttons to repsernset seats
                                     ArrayList<RadioButton> theaterTwoPulpSeats = new ArrayList<>();
                                    for(int i = 0; i < 50; i++)
                                    {
                                        RadioButton seatsPulpTwo = new RadioButton("S" + (i + 1));
                                        theaterTwoPulpSeats.add(seatsPulpTwo);
                                        
                                                                                
                                         if(i < 30)
                                        {
                                            seatsPulpTwo.setSelected(true);
                                            seatsPulpTwo.setTextFill(Color.RED);
                                        }
                                        
                                        seatsPulpTwo.setOnAction(C->
                                        {
                                            if(seatsPulpTwo.isSelected() == true)
                                            {
                                                count++;
                                            }
                                            else
                                            {
                                                count--;
                                            }
                                        });
                                        
                                   Button confirm = new Button("Confirm");
                                   Pane paneForConfrim = new Pane();
                                   paneForConfrim.getChildren().addAll(confirm);
                                   pane.setBottom(paneForConfrim);
                                    
                                    confirm.setOnAction(D ->
                                    {
                                       totalNumberOfTicketsSold = 130 + count;
                                       System.out.println("You have purchased " + count + " Tickets.");
                                       System.out.println("The total number of tickets sold today in Theater Two Pulp Fiction: " + totalNumberOfTicketsSold);
                                       System.exit(0);
                                    });
                                    }
                                        
                                    
                                    
                   
                                    FlowPane paneForSetOneSeats = new FlowPane();
                                    paneForSetOneSeats.setHgap(5);
                                    paneForSetOneSeats.setVgap(5);

                    
                                    paneForSetOneSeats.setPadding(new Insets(5,5,5,5));
                                    paneForSetOneSeats.setStyle("-fix-border-color:black");
                    
                                    paneForSetOneSeats.getChildren().addAll(theaterTwoPulpSeats);
                    
                                    pane.setCenter(paneForSetOneSeats);
                                }
                            });
                        }
                    });
            }
        });
        
        theaterThree.setOnAction(n ->
        {
            if (theaterThree.isSelected())
            {
                text.setFill(Color.BLACK);
                
                Text textForTheaterThree= new Text(10,15, "Thearter Three Showtimes");
                Pane paneForTheaterThreeText = new Pane();
                pane.setTop(paneForTheaterThreeText);
                paneForTheaterThreeText.getChildren().addAll(textForTheaterThree);
                        
            
                RadioButton showTime7 = new RadioButton("Kill Bill Show Times");
                RadioButton showTime8 = new RadioButton("Howl's Moving Castel Show Times");
                RadioButton showTime9 = new RadioButton("Pulp Fiction Show Times");
       
                VBox paneForRad = new VBox(20);
                paneForRad.setPadding(new Insets(5, 5, 5, 5));
                paneForRad.setStyle("-fix-border-color: black");
                paneForRad.getChildren().addAll(showTime7, showTime8, showTime9);
                pane.setCenter(paneForRad);
        
        
                ToggleGroup group1 = new ToggleGroup();
                showTime7.setToggleGroup(group1);
                showTime8.setToggleGroup(group1);
                showTime9.setToggleGroup(group1);
 
                    showTime7.setOnAction(b ->
                    {
                        totalNumberOfTicketsSold = 100;
                                    
                        // if statement that will show the showtimes of kill bill
                        if(showTime7.isSelected())
                        { 
                        Text textForTheaterOneFilmThree = new Text(10,15, "Kill Bill Showtimes");
                        Pane paneForTheaterOneFilmThree = new Pane();
                        pane.setTop(paneForTheaterOneFilmThree);
                        paneForTheaterOneFilmThree.getChildren().addAll(textForTheaterOneFilmThree);
                        
            
                        RadioButton showTimeA7 = new RadioButton("Kill Bill 10:00 AM Sold Out" );
                        RadioButton showTimeB7 = new RadioButton("Kill Bill 3:00 PM Sold Out");
                        RadioButton showTimeC7 = new RadioButton("Kill Bill 8:00 PM" );
       
                        VBox paneForShowTimeTheaterThreeKill = new VBox(20);
                        paneForShowTimeTheaterThreeKill.setPadding(new Insets(5, 5, 5, 5));
                        paneForShowTimeTheaterThreeKill.setStyle("-fix-border-color: black");
                        paneForShowTimeTheaterThreeKill.getChildren().addAll(showTimeA7, showTimeB7, showTimeC7);
                        pane.setCenter(paneForShowTimeTheaterThreeKill);
        
        
                        ToggleGroup showTimeOneKill = new ToggleGroup();
                        showTimeA7.setToggleGroup(showTimeOneKill);
                        showTimeB7.setToggleGroup(showTimeOneKill);
                        showTimeC7.setToggleGroup(showTimeOneKill);
                        
                            
                            showTimeC7.setOnAction (c ->
                            {
                                
                                if(showTimeC7.isSelected())
                                {
                                   Text textForTheaterThreeKillSeats = new Text(10,15, "Seats");
                                   Pane paneForTheaterThreeKillSeats = new Pane();
                                   pane.setTop(paneForTheaterThreeKillSeats);
                                   paneForTheaterThreeKillSeats.getChildren().addAll(textForTheaterThreeKillSeats);
                                   
                                   
                                    //boolean seatIsPressed = false;
                                   
                                    // array list that will create 50 radio buttons to repsernset seats
                                     ArrayList<RadioButton> theaterThreeKillSeats = new ArrayList<>();
                                    for(int i = 0; i < 50; i++)
                                    {
                                        RadioButton seatsKillThree = new RadioButton("S" + (i + 1));
                                        theaterThreeKillSeats.add(seatsKillThree);
                                        //seatIsPressed = seatsKillOne.isPressed();
                                        
                                        if(i < 30)
                                        {
                                            totalNumberOfTicketsSold = 130;
                                            seatsKillThree.setSelected(true);
                                            seatsKillThree.setTextFill(Color.RED);
                                        }
                                        
                                        seatsKillThree.setOnAction(C->
                                        {
                                            if(seatsKillThree.isSelected() == true)
                                            {
                                                count++;
                                            }
                                            else
                                            {
                                                count--;
                                            }
                                        });
                                    }
                                   
                                   Button confirm = new Button("Confirm");
                                   Pane paneForConfrim = new Pane();
                                   paneForConfrim.getChildren().addAll(confirm);
                                   pane.setBottom(paneForConfrim);
                                    
                                    confirm.setOnAction(D ->
                                    {
                                       totalNumberOfTicketsSold = 130 + count;
                                       System.out.println("You have purchased " + count + " Tickets.");
                                       System.out.println("The total number of tickets sold today in Theater Three Kill Bill: " + totalNumberOfTicketsSold);
                                       System.exit(0);
                                    });
                                    
                                    
                                    
                   
                                    FlowPane paneForSetOneSeats = new FlowPane();
                                    paneForSetOneSeats.setHgap(5);
                                    paneForSetOneSeats.setVgap(5);

                    
                                    paneForSetOneSeats.setPadding(new Insets(5,5,5,5));
                                    paneForSetOneSeats.setStyle("-fix-border-color:black");
                    
                                    paneForSetOneSeats.getChildren().addAll(theaterThreeKillSeats);
                    
                                    pane.setCenter(paneForSetOneSeats);
                                }
                            });
                        }
                    });
                    
                     showTime8.setOnAction(d ->
                    {
                                    
                        // if statement that will show the showtimes of kill bill
                        if(showTime8.isSelected())
                        { 
                        Text textForTheaterOneFilmTwo = new Text(10,15, "Howl's Moiving Castel Showtimes");
                        Pane paneForTheaterOneFilmTwo = new Pane();
                        pane.setTop(paneForTheaterOneFilmTwo);
                        paneForTheaterOneFilmTwo.getChildren().addAll(textForTheaterOneFilmTwo);
                        
            
                        RadioButton showTimeA8 = new RadioButton("Howl's Moiving Castel 10:00 AM" );
                        RadioButton showTimeB8 = new RadioButton("Howl's Moiving Castel 3:00 PM Sold Out");
                        RadioButton showTimeC8 = new RadioButton("Howl's Moiving Castel 8:00 PM Sold Out" );
       
                        VBox paneForShowTimeTheaterTwoHowl = new VBox(20);
                        paneForShowTimeTheaterTwoHowl.setPadding(new Insets(5, 5, 5, 5));
                        paneForShowTimeTheaterTwoHowl.setStyle("-fix-border-color: black");
                        paneForShowTimeTheaterTwoHowl.getChildren().addAll(showTimeA8, showTimeB8, showTimeC8);
                        pane.setCenter(paneForShowTimeTheaterTwoHowl);
        
        
                        ToggleGroup showTimeOneKill = new ToggleGroup();
                        showTimeA8.setToggleGroup(showTimeOneKill);
                        showTimeB8.setToggleGroup(showTimeOneKill);
                        showTimeC8.setToggleGroup(showTimeOneKill);
                    
                            showTimeA8.setOnAction (e ->
                            {
                                if(showTimeA8.isSelected())
                                {
                                   Text textForTheaterOneHowlSeats = new Text(10,15, "Seats");
                                   Pane paneForTheaterOneHowlSeats = new Pane();
                                   pane.setTop(paneForTheaterOneHowlSeats);
                                   paneForTheaterOneHowlSeats.getChildren().addAll(textForTheaterOneHowlSeats);
                                   
                                    
                                   
                                    // array list that will create 50 radio buttons to repsernset seats
                                     ArrayList<RadioButton> theaterOneHowlSeats = new ArrayList<>();
                                    for(int i = 0; i < 50; i++)
                                    {
                                        RadioButton seatsHowlTwo = new RadioButton("S" + (i + 1));
                                        theaterOneHowlSeats.add(seatsHowlTwo);
                                        
                                         if(i < 30)
                                        {
                                            seatsHowlTwo.setSelected(true);
                                            seatsHowlTwo.setTextFill(Color.RED);
                                        }
                                        
                                        seatsHowlTwo.setOnAction(C->
                                        {
                                            if(seatsHowlTwo.isSelected() == true)
                                            {
                                                count++;
                                            }
                                            else
                                            {
                                                count--;
                                            }
                                        });
                                        
                                   Button confirm = new Button("Confirm");
                                   Pane paneForConfrim = new Pane();
                                   paneForConfrim.getChildren().addAll(confirm);
                                   pane.setBottom(paneForConfrim);
                                    
                                    confirm.setOnAction(D ->
                                    {
                                       totalNumberOfTicketsSold = 130 + count;
                                       System.out.println("You have purchased " + count + " Tickets.");
                                       System.out.println("The total number of tickets sold today in Theater Three Howl's Moving Castel: " + totalNumberOfTicketsSold);
                                       System.exit(0);
                                    });
                                    }
                                   
                   
                                    FlowPane paneForSetOneSeats = new FlowPane();
                                    paneForSetOneSeats.setHgap(5);
                                    paneForSetOneSeats.setVgap(5);

                    
                                    paneForSetOneSeats.setPadding(new Insets(5,5,5,5));
                                    paneForSetOneSeats.setStyle("-fix-border-color:black");
                    
                                    paneForSetOneSeats.getChildren().addAll(theaterOneHowlSeats);
                    
                                    pane.setCenter(paneForSetOneSeats);
                                }
                            });
                        }
                    });
                     
                     
                        showTime9.setOnAction(f ->
                    {
                                    
                        // if statement that will show the showtimes of kill bill
                        if(showTime9.isSelected())
                        { 
                        Text textForTheaterTwoFilmThree = new Text(10,15, "Pulp Fiction Showtimes");
                        Pane paneForTheaterTwoFilmThree = new Pane();
                        pane.setTop(paneForTheaterTwoFilmThree);
                        paneForTheaterTwoFilmThree.getChildren().addAll(textForTheaterTwoFilmThree);
                        
            
                        RadioButton showTimeA9 = new RadioButton("Pulp Fiction 10:00 AM Sold Out" );
                        RadioButton showTimeB9 = new RadioButton("Pulp Fiction 3:00 PM Sold Out");
                        RadioButton showTimeC9 = new RadioButton("Pulp Fiction 8:00 PM" );
       
                        VBox paneForShowTimeTheaterTwoPulp = new VBox(20);
                        paneForShowTimeTheaterTwoPulp.setPadding(new Insets(5, 5, 5, 5));
                        paneForShowTimeTheaterTwoPulp.setStyle("-fix-border-color: black");
                        paneForShowTimeTheaterTwoPulp.getChildren().addAll(showTimeA9, showTimeB9, showTimeC9);
                        pane.setCenter(paneForShowTimeTheaterTwoPulp);
        
        
                        ToggleGroup showTimeOneKill = new ToggleGroup();
                        showTimeA9.setToggleGroup(showTimeOneKill);
                        showTimeB9.setToggleGroup(showTimeOneKill);
                        showTimeC9.setToggleGroup(showTimeOneKill);
                    
                            showTimeC9.setOnAction (g ->
                            {
                                if(showTimeC9.isSelected())
                                {
                                   Text textForTheaterTwoPulpSeats = new Text(10,15, "Seats");
                                   Pane paneForTheaterTwoPulpSeats = new Pane();
                                   pane.setTop(paneForTheaterTwoPulpSeats);
                                   paneForTheaterTwoPulpSeats.getChildren().addAll(textForTheaterTwoPulpSeats);
                                   
                                    
                                   
                                    // array list that will create 50 radio buttons to repsernset seats
                                     ArrayList<RadioButton> theaterTwoPulpSeats = new ArrayList<>();
                                    for(int i = 0; i < 50; i++)
                                    {
                                        RadioButton seatsPulpTwo = new RadioButton("S" + (i + 1));
                                        theaterTwoPulpSeats.add(seatsPulpTwo);
                                        
                                                                                
                                         if(i < 30)
                                        {
                                            seatsPulpTwo.setSelected(true);
                                            seatsPulpTwo.setTextFill(Color.RED);
                                        }
                                        
                                        seatsPulpTwo.setOnAction(C->
                                        {
                                            if(seatsPulpTwo.isSelected() == true)
                                            {
                                                count++;
                                            }
                                            else
                                            {
                                                count--;
                                            }
                                        });
                                        
                                   Button confirm = new Button("Confirm");
                                   Pane paneForConfrim = new Pane();
                                   paneForConfrim.getChildren().addAll(confirm);
                                   pane.setBottom(paneForConfrim);
                                    
                                    confirm.setOnAction(D ->
                                    {
                                       totalNumberOfTicketsSold = 130 + count;
                                       System.out.println("You have purchased " + count + " Tickets.");
                                       System.out.println("The total number of tickets sold today in Theater Three Pulp Fiction: " + totalNumberOfTicketsSold);
                                       System.exit(0);
                                    });
                                    }
                                        
                                    
                                    
                   
                                    FlowPane paneForSetOneSeats = new FlowPane();
                                    paneForSetOneSeats.setHgap(5);
                                    paneForSetOneSeats.setVgap(5);

                    
                                    paneForSetOneSeats.setPadding(new Insets(5,5,5,5));
                                    paneForSetOneSeats.setStyle("-fix-border-color:black");
                    
                                    paneForSetOneSeats.getChildren().addAll(theaterTwoPulpSeats);
                    
                                    pane.setCenter(paneForSetOneSeats);
                                }
                            });
                        }
                    });
            }
       
        });
        
        theaterFour.setOnAction(t ->
        {
            if (theaterFour.isSelected())
            {
                Text textForTheaterThree= new Text(10,15, "Thearter Four Showtimes");
                Pane paneForTheaterThreeText = new Pane();
                pane.setTop(paneForTheaterThreeText);
                paneForTheaterThreeText.getChildren().addAll(textForTheaterThree);
                        
            
                RadioButton showTime10 = new RadioButton("Kill Bill Show Times");
                RadioButton showTime11 = new RadioButton("Howl's Moving Castel Show Times");
                RadioButton showTime12 = new RadioButton("Pulp Fiction Show Times");
       
                VBox paneForRad = new VBox(20);
                paneForRad.setPadding(new Insets(5, 5, 5, 5));
                paneForRad.setStyle("-fix-border-color: black");
                paneForRad.getChildren().addAll(showTime10, showTime11, showTime12);
                pane.setCenter(paneForRad);
        
        
                ToggleGroup group1 = new ToggleGroup();
                showTime10.setToggleGroup(group1);
                showTime11.setToggleGroup(group1);
                showTime12.setToggleGroup(group1);
 
                    showTime10.setOnAction(b ->
                    {
                        totalNumberOfTicketsSold = 100;
                                    
                        // if statement that will show the showtimes of kill bill
                        if(showTime10.isSelected())
                        { 
                        Text textForTheaterOneFilmThree = new Text(10,15, "Kill Bill Showtimes");
                        Pane paneForTheaterOneFilmThree = new Pane();
                        pane.setTop(paneForTheaterOneFilmThree);
                        paneForTheaterOneFilmThree.getChildren().addAll(textForTheaterOneFilmThree);
                        
            
                        RadioButton showTimeA10 = new RadioButton("Kill Bill 10:00 AM Sold Out" );
                        RadioButton showTimeB10 = new RadioButton("Kill Bill 3:00 PM ");
                        RadioButton showTimeC10 = new RadioButton("Kill Bill 8:00 PM Sold Out" );
       
                        VBox paneForShowTimeTheaterThreeKill = new VBox(20);
                        paneForShowTimeTheaterThreeKill.setPadding(new Insets(5, 5, 5, 5));
                        paneForShowTimeTheaterThreeKill.setStyle("-fix-border-color: black");
                        paneForShowTimeTheaterThreeKill.getChildren().addAll(showTimeA10, showTimeB10, showTimeC10);
                        pane.setCenter(paneForShowTimeTheaterThreeKill);
        
        
                        ToggleGroup showTimeOneKill = new ToggleGroup();
                        showTimeA10.setToggleGroup(showTimeOneKill);
                        showTimeB10.setToggleGroup(showTimeOneKill);
                        showTimeC10.setToggleGroup(showTimeOneKill);
                        
                            
                            showTimeB10.setOnAction (c ->
                            {
                                
                                if(showTimeB10.isSelected())
                                {
                                   Text textForTheaterThreeKillSeats = new Text(10,15, "Seats");
                                   Pane paneForTheaterThreeKillSeats = new Pane();
                                   pane.setTop(paneForTheaterThreeKillSeats);
                                   paneForTheaterThreeKillSeats.getChildren().addAll(textForTheaterThreeKillSeats);
                                   
                                   
                                    //boolean seatIsPressed = false;
                                   
                                    // array list that will create 50 radio buttons to repsernset seats
                                     ArrayList<RadioButton> theaterThreeKillSeats = new ArrayList<>();
                                    for(int i = 0; i < 50; i++)
                                    {
                                        RadioButton seatsKillThree = new RadioButton("S" + (i + 1));
                                        theaterThreeKillSeats.add(seatsKillThree);
                                        //seatIsPressed = seatsKillOne.isPressed();
                                        
                                        if(i < 30)
                                        {
                                            totalNumberOfTicketsSold = 130;
                                            seatsKillThree.setSelected(true);
                                            seatsKillThree.setTextFill(Color.RED);
                                        }
                                        
                                        seatsKillThree.setOnAction(C->
                                        {
                                            if(seatsKillThree.isSelected() == true)
                                            {
                                                count++;
                                            }
                                            else
                                            {
                                                count--;
                                            }
                                        });
                                    }
                                   
                                   Button confirm = new Button("Confirm");
                                   Pane paneForConfrim = new Pane();
                                   paneForConfrim.getChildren().addAll(confirm);
                                   pane.setBottom(paneForConfrim);
                                    
                                    confirm.setOnAction(D ->
                                    {
                                       totalNumberOfTicketsSold = 130 + count;
                                       System.out.println("You have purchased " + count + " Tickets.");
                                       System.out.println("The total number of tickets sold today in Theater Four Kill Bill: " + totalNumberOfTicketsSold);
                                       System.exit(0);
                                    });
                                    
                                    
                                    
                   
                                    FlowPane paneForSetOneSeats = new FlowPane();
                                    paneForSetOneSeats.setHgap(5);
                                    paneForSetOneSeats.setVgap(5);

                    
                                    paneForSetOneSeats.setPadding(new Insets(5,5,5,5));
                                    paneForSetOneSeats.setStyle("-fix-border-color:black");
                    
                                    paneForSetOneSeats.getChildren().addAll(theaterThreeKillSeats);
                    
                                    pane.setCenter(paneForSetOneSeats);
                                }
                            });
                        }
                    });
                    
                     showTime11.setOnAction(d ->
                    {
                                    
                        // if statement that will show the showtimes of kill bill
                        if(showTime11.isSelected())
                        { 
                        Text textForTheaterOneFilmTwo = new Text(10,15, "Howl's Moiving Castel Showtimes");
                        Pane paneForTheaterOneFilmTwo = new Pane();
                        pane.setTop(paneForTheaterOneFilmTwo);
                        paneForTheaterOneFilmTwo.getChildren().addAll(textForTheaterOneFilmTwo);
                        
            
                        RadioButton showTimeA11 = new RadioButton("Howl's Moiving Castel 10:00 AM Sold Out" );
                        RadioButton showTimeB11 = new RadioButton("Howl's Moiving Castel 3:00 PM");
                        RadioButton showTimeC11 = new RadioButton("Howl's Moiving Castel 8:00 PM Sold Out" );
       
                        VBox paneForShowTimeTheaterTwoHowl = new VBox(20);
                        paneForShowTimeTheaterTwoHowl.setPadding(new Insets(5, 5, 5, 5));
                        paneForShowTimeTheaterTwoHowl.setStyle("-fix-border-color: black");
                        paneForShowTimeTheaterTwoHowl.getChildren().addAll(showTimeA11, showTimeB11, showTimeC11);
                        pane.setCenter(paneForShowTimeTheaterTwoHowl);
        
        
                        ToggleGroup showTimeOneKill = new ToggleGroup();
                        showTimeA11.setToggleGroup(showTimeOneKill);
                        showTimeB11.setToggleGroup(showTimeOneKill);
                        showTimeC11.setToggleGroup(showTimeOneKill);
                    
                            showTimeB11.setOnAction (e ->
                            {
                                if(showTimeB11.isSelected())
                                {
                                   Text textForTheaterOneHowlSeats = new Text(10,15, "Seats");
                                   Pane paneForTheaterOneHowlSeats = new Pane();
                                   pane.setTop(paneForTheaterOneHowlSeats);
                                   paneForTheaterOneHowlSeats.getChildren().addAll(textForTheaterOneHowlSeats);
                                   
                                    
                                   
                                    // array list that will create 50 radio buttons to repsernset seats
                                     ArrayList<RadioButton> theaterOneHowlSeats = new ArrayList<>();
                                    for(int i = 0; i < 50; i++)
                                    {
                                        RadioButton seatsHowlTwo = new RadioButton("S" + (i + 1));
                                        theaterOneHowlSeats.add(seatsHowlTwo);
                                        
                                         if(i < 30)
                                        {
                                            seatsHowlTwo.setSelected(true);
                                            seatsHowlTwo.setTextFill(Color.RED);
                                        }
                                        
                                        seatsHowlTwo.setOnAction(C->
                                        {
                                            if(seatsHowlTwo.isSelected() == true)
                                            {
                                                count++;
                                            }
                                            else
                                            {
                                                count--;
                                            }
                                        });
                                        
                                   Button confirm = new Button("Confirm");
                                   Pane paneForConfrim = new Pane();
                                   paneForConfrim.getChildren().addAll(confirm);
                                   pane.setBottom(paneForConfrim);
                                    
                                    confirm.setOnAction(D ->
                                    {
                                       totalNumberOfTicketsSold = 130 + count;
                                       System.out.println("You have purchased " + count + " Tickets.");
                                       System.out.println("The total number of tickets sold today in Theater Four Howl's Moving Castel: " + totalNumberOfTicketsSold);
                                       System.exit(0);
                                    });
                                    }
                                   
                   
                                    FlowPane paneForSetOneSeats = new FlowPane();
                                    paneForSetOneSeats.setHgap(5);
                                    paneForSetOneSeats.setVgap(5);

                    
                                    paneForSetOneSeats.setPadding(new Insets(5,5,5,5));
                                    paneForSetOneSeats.setStyle("-fix-border-color:black");
                    
                                    paneForSetOneSeats.getChildren().addAll(theaterOneHowlSeats);
                    
                                    pane.setCenter(paneForSetOneSeats);
                                }
                            });
                        }
                    });
                     
                     
                        showTime12.setOnAction(f ->
                    {
                                    
                        // if statement that will show the showtimes of kill bill
                        if(showTime12.isSelected())
                        { 
                        Text textForTheaterTwoFilmThree = new Text(10,15, "Pulp Fiction Showtimes");
                        Pane paneForTheaterTwoFilmThree = new Pane();
                        pane.setTop(paneForTheaterTwoFilmThree);
                        paneForTheaterTwoFilmThree.getChildren().addAll(textForTheaterTwoFilmThree);
                        
            
                        RadioButton showTimeA12 = new RadioButton("Pulp Fiction 10:00 AM Sold Out" );
                        RadioButton showTimeB12 = new RadioButton("Pulp Fiction 3:00 PM Sold Out");
                        RadioButton showTimeC12 = new RadioButton("Pulp Fiction 8:00 PM" );
       
                        VBox paneForShowTimeTheaterTwoPulp = new VBox(20);
                        paneForShowTimeTheaterTwoPulp.setPadding(new Insets(5, 5, 5, 5));
                        paneForShowTimeTheaterTwoPulp.setStyle("-fix-border-color: black");
                        paneForShowTimeTheaterTwoPulp.getChildren().addAll(showTimeA12, showTimeB12, showTimeC12);
                        pane.setCenter(paneForShowTimeTheaterTwoPulp);
        
        
                        ToggleGroup showTimeOneKill = new ToggleGroup();
                        showTimeA12.setToggleGroup(showTimeOneKill);
                        showTimeB12.setToggleGroup(showTimeOneKill);
                        showTimeC12.setToggleGroup(showTimeOneKill);
                    
                            showTimeC12.setOnAction (g ->
                            {
                                if(showTimeC12.isSelected())
                                {
                                   Text textForTheaterTwoPulpSeats = new Text(10,15, "Seats");
                                   Pane paneForTheaterTwoPulpSeats = new Pane();
                                   pane.setTop(paneForTheaterTwoPulpSeats);
                                   paneForTheaterTwoPulpSeats.getChildren().addAll(textForTheaterTwoPulpSeats);
                                   
                                    
                                   
                                    // array list that will create 50 radio buttons to repsernset seats
                                     ArrayList<RadioButton> theaterTwoPulpSeats = new ArrayList<>();
                                    for(int i = 0; i < 50; i++)
                                    {
                                        RadioButton seatsPulpTwo = new RadioButton("S" + (i + 1));
                                        theaterTwoPulpSeats.add(seatsPulpTwo);
                                        
                                                                                
                                         if(i < 30)
                                        {
                                            seatsPulpTwo.setSelected(true);
                                            seatsPulpTwo.setTextFill(Color.RED);
                                        }
                                        
                                        seatsPulpTwo.setOnAction(C->
                                        {
                                            if(seatsPulpTwo.isSelected() == true)
                                            {
                                                count++;
                                            }
                                            else
                                            {
                                                count--;
                                            }
                                        });
                                        
                                   Button confirm = new Button("Confirm");
                                   Pane paneForConfrim = new Pane();
                                   paneForConfrim.getChildren().addAll(confirm);
                                   pane.setBottom(paneForConfrim);
                                    
                                    confirm.setOnAction(D ->
                                    {
                                       totalNumberOfTicketsSold = 130 + count;
                                       System.out.println("You have purchased " + count + " Tickets.");
                                       System.out.println("The total number of tickets sold today in Theater Three Pulp Fiction: " + totalNumberOfTicketsSold);
                                       System.exit(0);
                                    });
                                    }
                                        
                                    
                                    
                   
                                    FlowPane paneForSetOneSeats = new FlowPane();
                                    paneForSetOneSeats.setHgap(5);
                                    paneForSetOneSeats.setVgap(5);

                    
                                    paneForSetOneSeats.setPadding(new Insets(5,5,5,5));
                                    paneForSetOneSeats.setStyle("-fix-border-color:black");
                    
                                    paneForSetOneSeats.getChildren().addAll(theaterTwoPulpSeats);
                    
                                    pane.setCenter(paneForSetOneSeats);
                                }
                            });
                        }
                    });
            }
       
        });
        
        return pane;
    }
        
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Scene scene = new Scene(getPane(), 450, 300);
        primaryStage.setTitle("Java Theaters");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

       public static void main(String[]args)
       {
           try
           {
               File ticketFile = new File("SavedTickets.txt");
               if(ticketFile.createNewFile())
               {
                   System.out.println("File Created: " + ticketFile.getName());
               }
                   
                   else
                   {
                         System.out.println("File exists.");  
                   }
           }
           catch(IOException e)
            {
                System.out.println("Error Occurred.");
                e.printStackTrace();
            }
           
           
           launch(args);
       }
    
    
}

