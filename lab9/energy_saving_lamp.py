from lamp import Lamp

class EnergySavingLamp(Lamp):
    def __init__(self, power=60, energy_saving_factor=0.5):
        super().__init__(power)  
        self.__energy_saving_factor = energy_saving_factor  

    def turn_on(self):
        reduced_power = self.get_power() * self.__energy_saving_factor
        print(f"Energy-saving lamp is on, consuming {reduced_power:.2f} watts.")

    def get_energy_saving_factor(self):
        return self.__energy_saving_factor
