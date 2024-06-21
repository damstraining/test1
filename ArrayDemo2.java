/*

     Array Introduction
	 Array declaration
	 Array creation [both primitve and non primitive]
	 Array initialization  
     ----------------------------------------------

	 2 D Array creation:
	 -------------------
     
	 []
	 [][]
	 [][][]

	 int   a;
	 int[]   x;==>object===>new


	 int[]   x=new int[10];  byte , short , int , char

	 double[]  y=new double[4];

	 =============================================================

	 Array of arrays
	 -------------------





*/

class Employee
{
	int  eid;
	String name;
	double sal;

	Employee(int  eid,String name,double sal){
		 this.eid=eid;
		 this.name=name;
		 this.sal=sal;
	}

    public static Employee[]  getListOfEmployee(){

		  Employee[]  listOfEmployees=new Employee[3];

		  listOfEmployees[0]=new Employee(111,"Raja",1000.0);
		  listOfEmployees[1]=new Employee(222,"Rani",2000.0);
		  listOfEmployees[2]=new Employee(333,"Ramesh",3000.0);

		  return listOfEmployees;

    }

	public String toString(){
		return "Employee [ id= "+  eid +" name ="+name +" salary="+sal+"]";
	}
}


class  ArrayDemo2
{
	public static void main(String[] args) 
	{
		Employee[]  e1=Employee.getListOfEmployee();

		for (Employee e :  e1)
		{
			System.out.println(e);
		}
        
	}
}
