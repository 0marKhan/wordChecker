import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

class files extends Thread{
		String fn;
	
		//vectors to store file names
		Vector<String> v1 = new Vector<String>(1);
		public files(String n) {
			fn=n+".txt" ;
		}
		public void run(){
	
			try {
					String token = "" ;
					//sc = new Scanner(new File(fn));
					FileReader fr=new FileReader(new File(fn));
					Scanner myReader=new Scanner(fr);
				    while(myReader.hasNext()){
				        token = myReader.next();
				        v1.add(token);	//adding file names to vector
				    }
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    //System.out.println(v1);
			
			
		}
	}
