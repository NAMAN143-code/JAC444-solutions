import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Third {
	private static ObjectOutputStream output;
	
	public static void main(String[] args){
		openFile();
		addStudents();
		closeFile();
	}
    
	public static void openFile(){
		try{
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("students.txt")));
		}catch(IOException err){
			System.err.println("Error openin file.");
			System.exit(1); 
		}
	}
	// add student informations to file
	public static void addStudents(){
		Scanner input = new Scanner(System.in);
		System.out.printf("%s%n%s%nEnter: ", 
				"Enter Student ID, First Name, Last Name, and Courses.",
				"End input Ctrl+Z for Windows, Ctrl+D for Mac.");
		
		while(input.hasNext()){ // loop through until EOF
			try{		
				Student student = new Student(); // call default constructor
			
				student.setStID(input.nextInt());
				student.setFirstName(input.next());
				student.setLastName(input.next());
				

				String[] tokens = input.nextLine().split("\\s");

				for(int i = 0; i < tokens.length; i++){
					if(tokens[i].equals("")){ 
						continue;
					}else
						student.setCourses(tokens[i]);
				}
				output.writeObject(student); //serialize student object into file
			}catch (NoSuchElementException elementException){
				System.err.println("Invalid input. Please try again.");
				input.nextLine(); // discard input so user can try again
			}catch (IOException err){
				System.err.println("Error writing to file. Terminating.");
				break;
			} 
			System.out.print("Enter: ");
		}
		input.close(); 
	}

	public static void closeFile(){
		try{
			if(output != null)
				output.close();
		}catch(IOException err){
			System.err.println("Error open file.");
		}
	}
}