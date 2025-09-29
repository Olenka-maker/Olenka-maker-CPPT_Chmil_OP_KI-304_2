import os
import struct
import sys
import math

def writeResTxt(fName, result):
    with open(fName, 'w') as f:
        f.write(str(result))


def readResTxt(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'r') as f:
                result = float(f.read())
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result


def writeResBin(fName, result):
    with open(fName, 'wb') as f:
        
        f.write(struct.pack('f', result))


def readResBin(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'rb') as f:
               
                result = struct.unpack('f', f.read())[0]
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result


def calculate(x):
   
    return 1 / math.tan(2 * x)

if __name__ == "__main__":
   
    data = float(input("Enter value for x: "))
    result = calculate(data)
    print(f"Result is: {result}")

    try:
        
        writeResTxt("textRes.txt", result)
        writeResBin("binRes.bin", result)
        
       
        print("Result from binRes.bin: {0}".format(readResBin("binRes.bin")))
        print("Result from textRes.txt: {0}".format(readResTxt("textRes.txt")))
    except FileNotFoundError as e:
        print(e)
        sys.exit(1)
