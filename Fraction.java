/**
 * This is a class that represents a Fraction.
 * 
 * @author ...
 */
public class Fraction {
    private int num; //numerator
    private int den; //denominator
    /**
     * Default constructor. Creates 1/2 as the default fraction
     */
    public Fraction() {
        num = 1;
        den = 2;
    }
    /**
     * Overloaded constructor. Assigns numerator and denominator to the values of
     * parameters but prevents denominator being set to zero. If denominator
     * attempted to be set to zero, it sets it to 1 instead and prints and error
     * message to the terminal.
     * 
     * @param n the incoming value for numerator.
     * @param d the incoming value for denominator.
     */
    public Fraction(int n, int d) {
        num = n;
        setDenominator(d);
    }
    /**
     * Overloaded constructor. Takes a String that represents a fraction, which
     * is of the form "n/d" where n and d Strings that represent integer values
     * and are separated by a '/' char. The constructor pulls out n and d
     * and assigns their values to numerator and denominator respectively, and 
     * prevents denominator being set to zero. If denominator attempted to be set 
     * to zero, it sets it to 1 instead and prints and error message to the terminal.
     * 
     * @param f a String of the form "n/d" that represents a fraction.
     */
    public Fraction(String f) {
        int fwdIndex = f.indexOf("/");
        String numString = f.substring(0, fwdIndex);
        String denString = f.substring(fwdIndex+1);
        num = Integer.parseInt(numString);
        int d = Integer.parseInt(denString);
        setDenominator(d);
    }
    /**
     * Copy Constructor. Sets numerator and denominator to the parameter fraction's
     * numerator and denominator
     * 
     * @param f the Fraction object to copy.
     */
    public Fraction(Fraction f) {
        this.num = f.num;
        this.den = f.den;
    }
    /**
     * Accessor Method for numerator
     * 
     * @return the Fraction's numerator
     */
    public int getNumerator() {
        return this.num;
    }
    /**
     * Accessor Method for denominator
     * 
     * @return the Fraction's denominator
     */
    public int getDenominator() {
        return this.den;
    }
    /** Mutator method for setting the fraction's numerator
     * 
     *  @param n the int to set the numerator
     */ 
    public void setNumerator(int n) {
        this.num = n; 
    }
    /** Mutator method for setting the fraction's denominator. Will prevent
     * the denominator from being set to zero and assigns it to 1 instead if attempted
     * 
     *  @param d the int to set the denominator
     */ 
    public void setDenominator(int d) {
        if (d != 0) {
            den = d;
        } else {
            den = 1;
            System.out.println("Error: Attempted to make denominator zero!");
        }
    }
    /** Method for converting a Fraction into a String.
     * 
     *  @return a String representation of the Fraction of the form "num/den"
     */ 
    public String toString() {
        return num +"/" + den;
    }
    
    /*public static Fraction mult(Fraction a, Fraction b) {
        Fraction answer = new Fraction ((a.num * b.num), (a.den * b.den));
        return answer;
    }*/
    
   /*
    * Mutator method for multiplying this fraction (object you call with) with a
    * @param a is the Fraction to multiply with
    */   
    public void mult(Fraction a) {
        this.num *= a.num; //this.num and this.den is object you call with
        this.den *= a.den;
        
        
    }
}