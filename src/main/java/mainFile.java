import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;


	

public class mainFile extends Thread{
	private static Object[] t2;
	private static Object files;
	String fn ;
	BST N ;
	public mainFile(String n) {
		fn=n ;
	}
	public void run(){
		Scanner sc = new Scanner(System.in) ;
		fn=fn+".txt" ;
		try {
				String token = "" ;
				BST btree = new BST();
				FileReader fr=new FileReader(new File(fn));
				Scanner myReader=new Scanner(fr);
			    while(myReader.hasNext()){
			        token = myReader.next();
			        btree.insert(token);		   
			    }
			    N = btree ;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public static void main(String[] args) throws InterruptedException, specialCharacterException, incorrectInputException {
		// TODO Auto-generated method stub
		word arr[] = null;
		
		System.out.println("number of input files are = " + args.length);
		for(int i=0 ; i<args.length ; i++)
		{
			System.out.println("File no" + (i+1) + " = " + args[i] + ".txt");
		}
		mainFile t1 = new mainFile(args[0]);	//t1 for vocabulary file
		t1.setName(args[0]);
		t1.start();
		files t2[] = new files[args.length-1];	//t2 for input files
		
		
		for(int i=0 ; i<args.length-1 ; i++)
		{
			t2[i] = new files(args[i+1]) ;
			t2[i].setName(args[i+1]);
			t2[i].start();
		}
		Thread.sleep(250);

		int choice;
		do {
			System.out.println("enter 1 to see BST tree");
			System.out.println("enter 2 to display vectors");
			System.out.println("enter 3 to see frequency of matching words");
			System.out.println("enter 4 to enter query");
			System.out.println("enter 0 to exit");
			
			
			//exception for if choice less than 0, greater than 9
			
			Scanner sc = new Scanner(System.in);
			choice=sc.nextInt();
			if(choice<1 || choice>4) {
				throw new incorrectInputException("input can only be a number");
			}
			
			if(choice==1)
			{
				t1.N.preorder();
				System.out.println("\n");
			}
			
			else if(choice==2)
			{
				for(int i=0;i<3;i++) {
					System.out.println("file no "+(i+1)+": "+t2[i].v1);
				}
				//System.out.println("first file: " + t2[0].v1);
				//System.out.println("second file: " + t2[1].v1);
				System.out.println();
			}
			
			else if(choice==3)
			{
				
				arr=new word[args.length-1] ;
				for (int i=0;i<args.length-1 ;i++)
				{
					arr[i]=new word() ;
					for(int j=0;j<t2[i].v1.size();j++)
					{
						if(t1.N.breadthFirst(t2[i].v1.elementAt(j)))
						{
							if(arr[i].search(t2[i].v1.elementAt(j)))
							{
								arr[i].addWord(t2[i].v1.elementAt(j));
							}
							else
							{
								arr[i].incFreq(t2[i].v1.elementAt(j));
							}
						}
					}
					System.out.println();
				}
				
				//displaying matching vectors
				for(int i=0;i<arr.length;i++) {
					arr[i].display();
				}
			}
			else if(choice==4)
			{
				int count=0;
				int Status=0;
				System.out.print("Enter the String you want to search for : ");
				String sent=sc.next();
				
				//exception for checking special characters
				
				char sentArr[]=new char[sent.length()];
				for(int i=0;i<sent.length();i++) {
					sentArr[i]=sent.charAt(i);			
				}
				
				for(int i=0;i<sent.length();i++) {
					if(sentArr[i]<'a' || sentArr[i]>'z') {
						throw new specialCharacterException("special characters are not allowed in input");
					}
				}
				
				word wordobj2 = new word();
				for(int i=0;i<args.length-1;i++) {
					Status=wordobj2.wordfound(sent, t2[i].v1);
					if(Status>0) {
						System.out.println("The String "+sent+" Found in "+args[i+1]);
						System.out.println("number of occurances of the string = "+Status);
					}
				}
				if(Status==0) {
					System.out.println("Word Not found\n\n");
				}
				System.out.println("\n");
			}
		}while(choice!=0);
		
	}

}