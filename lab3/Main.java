package lab3; 

public class Main { 
        public static void main(String[] args) {

        SmartLamp l1 = new SmartLamp();
        l1.showAttributes();

        
        SmartLamp l2 = new SmartLamp("LED Lamp", "LED", 12, "Kitchen", 70);
        
        l2.showAttributes();

        
        l2.turnOn();
        l2.setBrightness(85);
        l2.changeWattage(15);
        l2.showAttributes();
        l2.turnOff();

        
         l2.clearLogFile();
    }
}