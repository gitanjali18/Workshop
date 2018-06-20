public interface MyFunctionalInterface{
	
	String methodA(String a, String b);

	default void methodB(int a, int b){
		System.out.println(a+b);
	}

	static void staticMethod(String input){
		System.out.println(input);
	}

}