/*
   Multi-Threading:
   ----------------
   Multi-tasking:
      |-Process based multi-tasking
	  |-Thread based multi-tasking
	      (Multi-Threading)
*/
class  ThreadDemo1
{
	public static void main(String[] args) 
	{
		
		System.out.println(Thread.currentThread().getName());
		ThreadDemo1  obj1=new ThreadDemo1();
		obj1.m3();

		Other  obj2=new Other();
		

		Runnable r1=()->{
			obj2.m1();
		};

		Thread  t1=new Thread(r1);
		t1.setName("our thread-1");
		t1.start();
		Thread  t2=new Thread(r1);
		t2.setName("our thread-2");
        t2.start();
		
	}

	void m3(){
		System.out.println(Thread.currentThread().getName());
	}
}

class Other
{
	void  m1(){
		m2();
		System.out.println("m1 method ::"+Thread.currentThread().getName());
	}

	void  m2(){
		System.out.println("m2 method ::"+Thread.currentThread().getName());
	}
}
