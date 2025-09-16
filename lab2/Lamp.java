package lab2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Lamp {

    private String name;       
    private String type;       
    private int wattage;        
    private boolean isOn;     
    private String location;    

    private static final String LOG_DIR = "lab2";
    private static final String LOG_FILE_PATH = LOG_DIR + File.separator + "activity.log";

    
    public Lamp() {
        this.name = "Default Lamp";
        this.type = "Halogen";
        this.wattage = 60;
        this.isOn = false;
        this.location = "Bathroom";
    }

    
    public Lamp(String name, String type, int wattage, String location) {
        this.name = name;
        this.type = type;
        this.wattage = wattage;
        this.isOn = false;
        this.location = location;
    }

    private void logAction(String message) {
        try {

            File logDir = new File(LOG_DIR);
            if (!logDir.exists()) {
                logDir.mkdirs();
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_PATH, true))) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                writer.println(dtf.format(now) + " - " + message);
            }

        } catch (IOException e) {
            System.err.println("Error  " + e.getMessage());
        }
    }

    
    public void showAttributes() {
        logAction("ShowAttributes() called for: " + name);
        System.out.println("--------------- Lamp Info ---------------");
        System.out.println("Name      : " + name);
        System.out.println("Type      : " + type);
        System.out.println("Wattage   : " + wattage + " W");
        System.out.println("Location  : " + location);
        System.out.println("Is it On? : " + (isOn ? "Yes" : "No"));
        System.out.println("----------------------------------------\n");
    }

   
    public void turnOn() {
        logAction("TurnOn() called for: " + name);
        if (!isOn) {
            isOn = true;
            System.out.println(name + " is now ON.");
        } else {
            System.out.println(name + " is already ON.");
        }
    }

    
    public void turnOff() {
        logAction("Method turnOff() called for: " + name);
        if (isOn) {
            isOn = false;
            System.out.println(name + " is now OFF.");
        } else {
            System.out.println(name + " is already OFF.");
        }
    }

    
    public void changeWattage(int newWattage) {
        logAction("ChangeWattage() called for: " + name + " to " + newWattage + " W");
        this.wattage = newWattage;
        System.out.println("Wattage of " + name + " changed  " + newWattage + " W.");
    }

    
    public void clearLogFile() {
        try {
            File logDir = new File(LOG_DIR);
            if (!logDir.exists()) logDir.mkdirs();

            FileWriter writer = new FileWriter(LOG_FILE_PATH, false);
            writer.close();
            System.out.println("File was cleared.");
        } catch (IOException e) {
            System.err.println("Error  " + e.getMessage());
        }
    }

  
    public static void main(String[] args) {

        
        Lamp lamp1 = new Lamp();
        Lamp lamp2 = new Lamp("LED Lamp", "LED", 15, "Kitchen");

        lamp1.showAttributes();
        lamp2.showAttributes();

        lamp2.turnOn();
        lamp2.changeWattage(20);
        lamp2.turnOff();

        lamp1.turnOn();
        lamp1.turnOff();

        lamp1.clearLogFile();
    }
}
