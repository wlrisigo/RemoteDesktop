package Login;


import java.io.*;
 
public class CmdLine {
 
       public static void main(String args[]) {
 
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
}