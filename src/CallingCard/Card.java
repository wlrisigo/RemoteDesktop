package CallingCard;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

public class Card extends Application {
    public static void main(String[] args) {
    	
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Remote Desktop");
        Button smart = new Button();
        smart.setText("Initiate SmartService RD");
        Button customer = new Button();
        
        //Calling Card is way for customer to request LogMeIn Customer Service
        customer.setText("IVLS Calling Card");
        customer.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	  try {
                      Runtime rt = Runtime.getRuntime();
                      //Process pr = rt.exec("C:\Program Files (x86)\LogMeIn Rescue Technician Console\LogMeInRescueTechnicianConsole_x64\LMIRTechConsole.exe");
                      Process pr = rt.exec("C:\\Program Files (x86)\\LogMeIn Rescue Calling Card\\okgp8w\\CallingCard.exe");
       
                      BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
       
                      String line=null;
       
                      while((line=input.readLine()) != null) {
                          System.out.println(line);
                      }
                      int exitVal = pr.waitFor();
                      System.out.println("Exited with error code "+exitVal);
       
                  } catch(Exception e) {
                      System.out.println(e.toString());
                      e.printStackTrace();
                  }
            	  new Thread().start();
            }
        });
        
  
        smart.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
            	  try {
                      Runtime rt = Runtime.getRuntime();
                      //Process pr = rt.exec("C:\Program Files (x86)\LogMeIn Rescue Technician Console\LogMeInRescueTechnicianConsole_x64\LMIRTechConsole.exe");
                      Process pr = rt.exec("C:\\Program Files (x86)\\LogMeIn Rescue Technician Console\\LogMeInRescueTechnicianConsole_x64\\LMIRTechConsole.exe");
       
                      BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
       
                      String line=null;
       
                      while((line=input.readLine()) != null) {
                          System.out.println(line);
                      }
       
                      int exitVal = pr.waitFor();
                      System.out.println("Exited with error code "+exitVal);
       
                  } catch(Exception e) {
                      System.out.println(e.toString());
                      e.printStackTrace();
                  }
            }
        });
        
        
        
        VBox root = new VBox();
       
        root.getChildren().addAll(smart, customer);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}