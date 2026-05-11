package Cart_Validator;
/**
 * E-Commerce Cart Validator
 ** Simulates a backend checkout system.
 * - Validates user input to prevent negative numbers and zero-item carts.
 * - Applies Promotional discount tiers based on subtotal amounts.
 * - Calculates an 8% state tax on the discounted subtotal.
 * - Generates a final formatted receipt.
 */
import java.util.*;
public class CartValidator
{
    static void main()
    {
        Scanner sc=new Scanner(System.in);
        double p=0.0;
        double n=0.0;
        //Input validation loop for product price
        while(true) {
            System.out.println("Enter price of 1 product");
          if (sc.hasNextDouble()) {
              p = sc.nextDouble();
                     if(p>0.00)
                     break; // ensures price is strictly psoitive
             }
             System.out.println("Invalid Input,Enter a numerical value greater than 0.");
          sc.next();// consume invalid output
         }
        //input validation loop for product quantity
      while(true) {
          System.out.println("Enter number of product you wish to purchase");
         if (sc.hasNextDouble()) {
             n = sc.nextDouble();
             if(n>0.00)
             break; // ensures quantity is strictly positive
             }
         System.out.println("Invalid Input,Enter a numerical value greater than 0.");
         sc.next();
      }
      //core checkout logic
        double subtotal = p*n;
        double discount = Discount(subtotal);
        double dprice = subtotal-discount;
        double tax = Taxapplied(dprice);
        double fprice = dprice+tax;
        Reciept(p,n,subtotal,discount,tax,fprice);
    }

    /**
     * Calculates the discount amount based on predefined promotional tiers
     * tier 1: under $50(0%)
     * tier 2:$50 to $99,99(10%)
     * tier 3: $100 and above(20%)
     */

    static double Discount(double subtotal1)
    {
        double discount = 0.0;
        double discountrate =0.0 ;
        double discountprice =0.0;
       if(subtotal1<50.0)
           discountrate = 0.0;
       else if (subtotal1>=50.0 && subtotal1<=99.99)
           discountrate = 10.0;
       else discountrate = 20.0;
       discountprice = (discountrate/100)*subtotal1;
       return discountprice;
    }

    //calculates an 8% state tax applied strictly to the post-discount price
    static double Taxapplied(double dprice) //dprice is discountedprice
    {
        double taxrate = 0.08;
        double tax = dprice*taxrate;
        return tax;
    }

    //prints the final itemized receipt to the console
    static void Reciept(double price,double number,double subtotal,double discountapplied,double tax,double finalprice)
    {
        System.out.println("The product price is $ "+price);
        System.out.println("The number of product is $ "+number);
        System.out.println("The subtotal price is $ "+subtotal);
        System.out.println("The discount applied is $ "+discountapplied);
        System.out.println("Tax applied is $ "+tax);
        System.out.println("Final price is $ "+finalprice);
    }
}
