public class ExceptionExample{

	public static void main(String[] args) {
		int[] arr = new int[5]; //size 5
		System.out.println("Statement 1");
		System.out.println("Statement 2");
		System.out.println("Statement 3");
		try{
		arr[6]=10;
		}catch(Exception e){
			System.err.println(e);
		}finally{
			System.out.println("Finally");
		}
		System.out.println("Statement 4");
		System.out.println("Statement 5");
		System.out.println("Statement 6");


	}
}