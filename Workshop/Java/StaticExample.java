public class StaticExample{

	private int number = 123;
	private static String string="Hello";

	
	public static  void printSomethingAgain(){
		System.out.println("A Static method.");
	}

	public void printSomething(){
		printSomethingAgain();
		System.out.println("haha "+" some string  "+string);
		System.out.println("Some number "+number);

	}


}