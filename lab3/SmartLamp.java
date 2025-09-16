package lab3;

public class SmartLamp extends Lamp implements Switchable {

    private int brightness; 

    public SmartLamp() {
        super();
        this.brightness = 50;
    }

    public SmartLamp(String name, String type, int wattage, String location, int brightness) {
        super(name, type, wattage, location);
        setBrightness(brightness);
    }

    public void setBrightness(int percent) {
        if (percent < 0) percent = 0;
        if (percent > 100) percent = 100;
        this.brightness = percent;
        System.out.println("Brightness of " + name + " set to " + brightness + "%.");
        logAction("setBrightness(" + brightness + "%)");
    }

    public int getBrightness() {
        return brightness;
    }

    @Override
    public void showAttributes() {
        logAction("showAttributes()");
        System.out.println("============== SMART LAMP ==============");
        System.out.println("Name      : " + name);
        System.out.println("Type      : " + type);
        System.out.println("Wattage   : " + wattage + " W");
        System.out.println("Location  : " + location);
        System.out.println("Power     : " + (on ? "ON" : "OFF"));
        System.out.println("Brightness: " + brightness + "%");
        System.out.println("========================================\n");
    }

    @Override
    public void turnOn() {
        if (!on) {
            on = true;
            System.out.println(name + " is now ON.");
            logAction("turnOn()");
        } else {
            System.out.println(name + " is already ON.");
        }
    }

    @Override
    public void turnOff() {
        if (on) {
            on = false;
            System.out.println(name + " is now OFF.");
            logAction("turnOff()");
        } else {
            System.out.println(name + " is already OFF.");
        }
    }

    @Override
    public boolean isOn() {
        return on;
    }
}