public class Calculate {

    public static double compute(double x) throws IllegalArgumentException {
        if (x == 0) {
            throw new IllegalArgumentException("x cannot be 0, because cot(2x) is undefined.");
        }

       
        double result = 1 / Math.tan(2 * x);

        
        if (result == 0) {
            throw new IllegalArgumentException("cot(2x) cannot be 0.");
        }

        return 1 / result; 
    }
}