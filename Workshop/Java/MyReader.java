import java.io.*;

public class MyReader{
	public void readFromAFile(String fileName){
		FileReader file=null;
		try{
		file=new FileReader("fileName");
		int c;
		while((c=file.read())!=-1){
			System.out.println(c);
		}
	}catch(FileNotFoundException fnfe){
		System.err.println(fnfe);

	}catch(IOException io){
	
		System.err.println(io);
	}finally{
		
		try{
			file.close();
		}catch(IOException io){
			System.err.println(io);
		}
	}
}

	public void writeToAFile(String fileName,String input)throws IOException{
		FileWriter file=new FileWriter("fileName");
		for(int i=0;i<input.length();i++){
			file.write(input.charAt(i));
		}
		file.close();
	}
}


			//Throws
			//Throw






