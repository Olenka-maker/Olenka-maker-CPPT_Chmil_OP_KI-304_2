class Lamp: 
    def __init__(self, power=60): 
        self.__power = power 

    def turn_on(self): 
        print(f"Lamp is on, consuming {self.__power} watts.")  

    def turn_off(self): 
        print("Lamp is off.") 

    def get_power(self): 
        return self.__power 
