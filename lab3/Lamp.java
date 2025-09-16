package lab3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Lamp {

    protected String name;       
    protected String type;       
    protected int wattage;       
    protected boolean on;        
    protected String location;   

    
    private static final String LOG_DIR = "lab3-logs";
    private static final String LOG_FILE_PATH = LOG_DIR + File.separator + "activity.log";

    protected Lamp() {
        this("Default Lamp", "Halogen", 60, "Bathroom");
    }

    protected Lamp(String name, String type, int wattage, String location) {
        this.name = name;
        this.type = type;
        this.wattage = wattage;
        this.location = location;
        this.on = false;
        logAction("created: " + name + " (" + type + ", " + wattage + "W) at " + location);
    }


    protected void ensureLogDir() {
        File dir = new File(LOG_DIR);
        if (!dir.exists()) dir.mkdirs();
    }

    protected void logAction(String message) {
        try {
            ensureLogDir();
            try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_PATH, true))) {
                String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                writer.println(ts + " | " + getClass().getSimpleName() + " | " + name + " | " + message);
            }
        } catch (IOException e) {
            System.err.println("Log error: " + e.getMessage());
        }
    }

    public abstract void showAttributes();

    public void changeWattage(int newWattage) {
        if (newWattage <= 0) {
            System.out.println("Wattage must be > 0.");
            logAction("changeWattage() rejected: " + newWattage);
            return;
        }
        this.wattage = newWattage;
        System.out.println("Wattage of " + name + " changed to " + newWattage + " W.");
        logAction("changeWattage() -> " + newWattage + "W");
    }

    public void clearLogFile() {
        try {
            ensureLogDir();
            new FileWriter(LOG_FILE_PATH, false).close();
            System.out.println("Log file cleared.");
            logAction("log cleared");
        } catch (IOException e) {
            System.err.println("Error while clearing log: " + e.getMessage());
        }
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public int getWattage() { return wattage; }
    public boolean isOnState() { return on; }
    public String getLocation() { return location; }
}