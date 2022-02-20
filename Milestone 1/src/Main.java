import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {
    public static String varX;
	public static String varY;
	static HashMap<String, String> StringString = new HashMap<String, String>();
	static HashMap<String, Integer> StringInt = new HashMap<String, Integer>();

	public static boolean loop = true;
	public static void main(String[] args) {

		String theCommand;
			
		System.out.println("\t Welcome to the abdoXP OS ");
		
		System.out.println("The following operations can be done:"
				+ ""
				+ "\n"
				+ "1) Read the data of any file and print or pint variable value \n"
				+ "2) Write text output to a file \n"
				+ "3) assign a value to variables\n");
		
		
		System.out.println("To assign a value to variables write: first type assign then type the x and  y, where x is the variable and y is the value assigned. The value could be an integer number, or a string \n");
        System.out.println("After assigning a variable you can view this variable by writing: view then insert the variable name and it will return the value inside this variable");
		System.out.println("To write data to a file write: writeFile then insert the variable name that contain the file path and the data that you wnat to write");
		System.out.println("To read data from a file write : readFile and type the file path \n");
		System.out.println("To terminate write exit \n");
		System.out.println("You can start by assigning variables or reading");
		System.out.println("If you have a file that contain a list of instructions and you want to execute it write: execute then enter the file name ");
		System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+ \n");
		
		int counter=0;
		 
		
		
		while(loop) {
			if(counter == 0) {
		        System.out.println("Write a command: ");

				theCommand = readInput();
				try {
					readvalue(theCommand);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				counter++;
			}
			System.out.println("Any other commands?");
			theCommand = readInput();
			try {
				readvalue(theCommand);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		
		}
        
        
        

		
	}
	
	public static void readvalue(String x) throws IOException{
		
		String theCommand2;

		
		switch(x) {
		  case "exit":
		    System.out.print("Goodbye");
		    loop = false;
		    break;
		    
		    
		    
		  case "assign":
			  System.out.println("insert the X");
			  varX = readInput();
			  System.out.println("insert the Y");
			  varY = readInput();
			  
			  if(Pattern.matches("[a-zA-Z]+", varY))
				  assignStrinng(varX,varY);
			  else
				  assignInt(varX,varY);
			   
			  
		    break;
		    
		  case "readFile":

			    String fname;
			    Scanner scan = new Scanner(System.in);

			    System.out.print("Enter File Path to Open (with extension like (FilePath)/file.txt) : ");
			    fname = scan.nextLine();


			    String line = null;
			    try
			    {
			        FileReader fileReader = new FileReader(fname);

			        BufferedReader bufferedReader = new BufferedReader(fileReader);

			        while((line = bufferedReader.readLine()) != null)
			        {
			            System.out.println(line);
			        }

			        /* always close the file after use */
			        bufferedReader.close();
			    }
			    catch(IOException ex)
			    {
			        System.out.println("Error reading file named '" + fname + "'");
			       
			    }
		    
		    break;
		    
		  case "writeFile":
			  Scanner scann = new Scanner(System.in);
			  String kk;
			  System.out.println("enter the variable name that contain the file path");
			  kk = scann.nextLine();

			  System.out.println("enter the data");

		        String str = scann.nextLine();
		  
		        // attach a file to FileWriter 
		        FileWriter fw=new FileWriter(kk);
		  
		        // read character wise from string and write 
		        // into FileWriter 
		        for (int i = 0; i < str.length(); i++)
		            fw.write(str.charAt(i));
		  
		        System.out.println("Writing successful");
		        //close the file 
		        fw.close();
		    	
		   // }
	    
		    break;
		    
		  case "view":
			  String s;
			  System.out.println("enter the variable name");
			  s=  readInput();
			  if(StringString.get(s) == null && StringInt.get(s) == null) {
			        System.out.println("you havent initialize a variable yet :(");
			        break;
			  }
			  
			  else 
				  if(StringString.get(s) == null)
				  System.out.println(StringInt.get(s)+"\n");
				  else
			  System.out.println(StringString.get(s)+"\n");

				  
		    break;
		    
		  case "execute":
			  String fi;
			  System.out.println("enter the filePath");
			  fi=readInput();
			  try {
					File myObj = new File(fi);
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						String data = myReader.nextLine();
						runfile(data);
					}
					myReader.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			
		    
			  break;
			  
			  
		  default:
			  System.out.println("invalid command try again \n");
				theCommand2 = readInput();
				readvalue(theCommand2);
			  break;
		}
		
		
	}
	public static String readInput(){
		Scanner scanner = new Scanner(System.in);       

    
		String message = scanner.nextLine();
		 
		return message;
	}
	
	
	public static void assignStrinng(String x, String y) {
		

		StringString.put(x,y);
		
	}
	
	
	
	public static void assignInt(String x, String y) {
		
		int integervalue = Integer.parseInt(y);
		StringInt.put(x,integervalue);
		
	}
	
	
	public static void runfile(String s) {
		String[] parts = s.split("\\r?\\n");
		  System.out.println(parts[0]);

		
	}
	
	
	
		
	}
