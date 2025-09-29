try:
    n = int(input("Enter size: "))  
    symbol = input("Enter character: ")


    matrix = [[' ' for _ in range(n)] for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if i <= j and i + j >= n - 1:
                matrix[i][j] = symbol

    print("Array:")
    for row in matrix:
        print(" ".join(row))

  
    try:
        with open("output.txt", "w") as writer:
            for row in matrix:
                writer.write(" ".join(row) + "\n")
        print("Array is written")
    except IOError:
        print("Error!!!!")
except ValueError:
    print("Invalid input! Please enter a valid integer for the size.")
