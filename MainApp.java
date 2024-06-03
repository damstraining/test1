/*
      class:
	  ------
	     |-variables
		     |-static variable
			 |-non static variable | instance variable
			 |-local variables

		|-method
		   |-static method
		   |-non static
		   |-parameterized method
		   |-non parameterized method
		   |-predefined method
		   |-user defined methods
		   |-void return type method
		   |-non void return type method

		 |-block
		    |-static block
			|-instance block

	    |-constructor

====================================================

    Object creation
	    |-object reference variable
		    |-static
			|-non static
			|-local

=======================================================

class  ClassName{

     variable
	 method
	 block
	 constructor

}

===========================================================
eg: ShopApp

class   Customer{

    static  int  shopId; ===========>static variable
	int customerId; //non static variable

	void  purchase(){ ==>non static
	    
		double amount=1000; //local variable

	}

	static void  getShopDetails(){ ==>static method
	    
		

	}

    Customer(){  ==>constructor

	   int   amt=10; -->amt local variable
	}



     {
         String  name="Raja";//local variable

		 //non static block
     }

     static{

           //static block
     }


	 void  login(String  userName,String password){
	 
	 }


	  String  logout(){
	 
	    return "you have logged out successfully";
	 }
} 


=======================================

Customer  c1=new Customer();===>heap area===>separte memory==>non static ==>object reference

Customer  c2=new Customer();

========================================

class loading -====>static ==>method area===>only once==>ClassName

========================================================================

c1.login("Raja","3436248");===>calling non static method

Customer.getShopDetails();===>calling static methods
===============================================================






*/
class  Account
{
	private long accNumber;
	private double minBal;
	private long adhar;
	private String pan;
    
	Account(long accNumber,double minBal,long adhar,String pan){
		 this.accNumber=accNumber;
		 this.minBal=minBal;
		 this.adhar=adhar;
		 this.pan=pan;
	}

	void printAccountDetails(){
		System.out.println("account number ::"+accNumber);
		System.out.println("minimum balance::"+minBal);
        System.out.println("Adhar number ::"+adhar);
        System.out.println("Pan number ::"+pan);
	}

	public void setMinBal(double minBal){
		this.minBal=minBal;
	}
	
}


class MainApp
{
	public static void main(String[] args) 
	{
		Account  a1=new Account(12345,1000.0,2223344874L,"ABCDD2334K");
		Account  a2=new Account(123456,2000.0,222334486324L,"ABC465b334H");
		
		a1.printAccountDetails();
		a2.printAccountDetails();

		a1.setMinBal(30000);
		a2.setMinBal(60000);

		a1.printAccountDetails();
		a2.printAccountDetails();
		
	}
}
