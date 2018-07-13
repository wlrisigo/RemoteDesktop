package Login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.*;

public class LOGMEIN extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Remote Desktop");
        Button btn = new Button();
        btn.setText("Login to Remote Desktop");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
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
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}