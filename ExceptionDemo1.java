/*
  
  Exception handling:
  -------------------

  DefaultExceptionHandler:---

  1. object create 
  2. puts 3 info in that object
  3. throws object
  4. if corresponding catch is available---->
  5. otherwise shutdown the jvm


  try
  catch
  finally

  throw
  throws
  ------------------------------
  Checked Exception   ----> checked by compiler at compiletime====>Exception
  Unchecked Exception-----> not checked by compiler at compiletime==>RuntimeException
 
*/


class ProductNotFoundException extends RuntimeException
{
    ProductNotFoundException(String  s){
		super(s);
    }
}

class Product
{
	private String  pname;

	Product(String pname){
		this.pname=pname;
	}

	void checkProduct(String  x){
		Database  d1=new Database();
		boolean  flag=d1.getDBProduct(x);
		if(flag==true){
			System.out.println(x+ "Product available in database");
		}
		else{
			try{
				throw new ProductNotFoundException(x +" is not aavilable in db");
			}
			catch(ProductNotFoundException  pnfe){
				 System.out.println("Internal problem  please try again later");
			}
		}
	}
}
class Database
{
	boolean  getDBProduct(String  pname){
		 if(pname.equalsIgnoreCase("Laptop")){
			 return true;
		 }
		 return false;
	}
}

class  ExceptionDemo1
{
	public static void main(String[] args) 
	{
		java.util.Scanner s1=new java.util.Scanner(System.in);
		System.out.println("Enter product name");
		String  name=s1.next();

		Product  p1=new Product(name);
		p1.checkProduct(name);

		System.out.println("waiting for response from server");
	}
}


/*
  error: unreported exception SQLException; must be caught or declared to be thrown
                Connection  con=DriverManager.getConnection("","","");

  unreported exception InterruptedException; must be caught or declared to be thrown
                Thread.sleep(1000);

  error: unreported exception ProductNotFoundException; must be caught or declared to be thrown
                throw new ProductNotFoundException();
*/