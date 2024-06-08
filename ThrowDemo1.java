/*
   Exception handling:
   -------------------
      DefaultExceptionHandler---->create an object of type exception-->
	  throw that object with 3 info

	  Name of the exception: Description
	  Location

	  Throwable
	  Exception
	     CheckedException--->Compiler will check at compiletime

	  RuntimeException
	    Uncheckedexception--->Compiler will not check at compiletime
*/

import java.util.Scanner;

class InvalidPinNumberException extends RuntimeException
{
    InvalidPinNumberException(String  str){
		super(str);
    }
}

class ThrowDemo1 
{
	public static void main(String[] args) 
	{
		Scanner s1=new Scanner(System.in);
		System.out.println("Please enter pin number");
		String  pin=s1.next();
		if(pin.length()==4){
			System.out.println("Your pin number is ="+pin);
		}
		else{
			   throw new InvalidPinNumberException("wrong pin number,please try again...");
		  
		}
		System.out.println("hello");
	}
}

/*
    System.out.println(10/0);

    Exception in thread "main" java.lang.ArithmeticException: / by zero
        at ThrowDemo1.main(ThrowDemo1.java:15)

   =======================================================================
     throw new ArithmeticException("/ by zero");

	Exception in thread "main" java.lang.ArithmeticException: / by zero
        at ThrowDemo1.main(ThrowDemo1.java:15)
*/
