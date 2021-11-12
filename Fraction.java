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
        int slash = f.indexOf("/");
        String numString = f.substring(0, slash);
        String denString = f.substring(slash + 1);
        this.num = Integer.parseInt(numString); // changing numString into int
        int d = Integer.parseInt(denString); // changing denString into int
        setDenominator(d); // den if 0 check
    }
    /**
     * Copy Constructor. Sets numerator and denominator instances to the parameter fraction's
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
            this.den = d;
        } else {
            this.den = 1;
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
    
    public static Fraction staticMult(Fraction a, Fraction b) {
        Fraction answer = new Fraction ((a.num * b.num), (a.den * b.den));
        return answer;
    }
    
   /*
    * Mutator method for multiplying this fraction (object you call with) with a
    * @param a is the Fraction to multiply with
    */   
    public void mult(Fraction a) {
        this.num *= a.num; //this.num and this.den is object you call with
        this.den *= a.den;        
    }
    
    /*
     * Helper method to find the GCF of given numerator and denominator parameters using Euclid's algorithm
     * @ param a Fraction's numerator
     * @ param b Fraction's denominator
     */
    
    /*
     * Euclid's algorithm: repeatedly substracting smaller (Math.min) number from larger (Math.max) number. 
     * Then, subtract smallest num with second largest num in equatioM. This is to get the GCF
     */    
    public int GCF(int a, int b) {
        
        if (a == 0 || b == 0) return 1; 
        
        while (a != b) {
            if (a > b) a -= b;
            else b -= a;
        }
        return a;
    }
    
    /*
     * Mutator method to reduce fraction into lowest values
     * to reduce, divide num and den by the GCF
     */
    public void reduce() {
        this.num /= GCF(num, den);
        this.den /= GCF(num, den);
    }
    
    public static Fraction mult (Fraction a, Fraction b) {
       int newNum = a.num * b.num;
       int newDen = a.den * b.den;
       
       Fraction answer = new Fraction (newNum, newDen);
       answer.reduce();
       
       return answer;
    }
    
    public static Fraction div (Fraction a, Fraction b) {
       
      if (a.den == 0 || b.den == 0) {  
         System.out.print("Error: Denominator was set to 0.");
         Fraction answer = new Fraction (a.num * b.den, 1);
      }    
          
      int newNum = a.num * b.den;
      int newDen = a.den * b.num; 

      Fraction answer = new Fraction (newNum, newDen);
      answer.reduce();
       
      return answer; 
    }
    
    public static Fraction add (Fraction a, Fraction b) {
         int newNum = a.num + b.num;
         int newDen = a.den + b.den; 

         Fraction answer = new Fraction (newNum, newDen);
         answer.reduce();
       
         return answer;
    }
    
     public static Fraction subtract (Fraction a, Fraction b) {
         int newNum = a.num - b.num;
         int newDen = Math.max(a.den, b.den) - Math.min(a.den, b.den);
         if (newDen == 0) newDen = 1;

         Fraction answer = new Fraction (newNum, newDen);
         answer.reduce();
       
         return answer;
    }
}