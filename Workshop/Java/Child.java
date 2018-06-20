public class Child extends Parent {
	
	 @Override
	 protected void methodA(){
	 	super.methodA();
	 	System.out.println("Overridden method A");
	 }

	 @Override
	 public void methodB(){
	 	super.methodB();
	 	System.out.println("Overridden method B");
	 }

	 public static void main(String[] args) {
	 	Child child = new Child();
	 	child.methodA();
	 	child.methodB();
	 }
}