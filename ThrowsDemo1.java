/*
   throws :
   --------

   Checked exception--------------->we can handle in 2 ways
      |-partially checked
	  |-fully checked
++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	  try{
	  
	  }
	  catch(){
	  
	  }
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++

using throws keyword:

if any exception class extends Throwable or Exception class directly then
only we can have checked exception
===========================================================

   



*/
class AccountNotFoundException1 extends Throwable
{
     AccountNotFoundException1(String msg){
		  super(msg);
     }
}
class CustomerNotFoundException extends Throwable
{
    CustomerNotFoundException(String msg){
		 super(msg);
    }
}
class Account
{
	private long accountNumber;
	private double balance;

	Account(long accountNumber,double balance){
		this.accountNumber=accountNumber;
		this.balance=balance;
	}

	String viewBalance(){

		 if(accountNumber==111222){
		     return "balance in account "+accountNumber  +" is "+balance;
		 }
		 else{

             try{
			    throw new AccountNotFoundException1("Invalid account number");
			 }catch(AccountNotFoundException1  anfe){
				 return anfe.getMessage();
			 }
		 }
		  
	}
}
class Customer
{
   private String customerName;
   private Account  account;

   Customer(Account  account,String  customerName){
	   this.account=account;
	   this.customerName=customerName;
   }

   void checkBalance() throws CustomerNotFoundException{
	   if(customerName.equals("raja")){
	     String  s1= account.viewBalance();
		 System.out.println("Hi "+customerName +" "+s1);
	   }
	   else{
		  throw new CustomerNotFoundException(customerName +" is not available in database");
	   }
   }
}
class  ThrowsDemo1
{
	public static void main(String[] args) throws CustomerNotFoundException
	{
		Account  a1=new Account(111222L,1000.0);

		Customer  c1=new Customer(a1,"raja");

		Account  a2=new Account(12346L,2000.0);

		Customer  c2=new Customer(a2,"rani");

		c1.checkBalance();
	}
}
