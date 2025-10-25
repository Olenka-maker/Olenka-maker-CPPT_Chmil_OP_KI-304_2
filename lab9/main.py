from energy_saving_lamp import EnergySavingLamp 
from lamp import Lamp 

def main(): 
    normal_lamp = Lamp() 
    normal_lamp.turn_on()  
    normal_lamp.turn_off()  

    energy_saving_lamp = EnergySavingLamp(power=80, energy_saving_factor=0.4)
    energy_saving_lamp.turn_on()  
    energy_saving_lamp.turn_off() 

if __name__ == "__main__": 
    main()  

