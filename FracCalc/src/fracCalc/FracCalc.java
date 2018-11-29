package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	boolean quitStatus = false;
    while(quitStatus == false) {
    	System.out.println("Enter an equation, or quit the program.");
    	Scanner input = new Scanner(System.in);
    	String consoleInput = input.nextLine();
    	if (consoleInput != "quit") {
    		System.out.println(produceAnswer(consoleInput));
    	} else {
    		quitStatus = true;
    	}
    	
    }
    
    System.out.println("Program quit.");
    	

    
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        String part1 = null;
        String operand = null;
        String part2 = null;
        String[] splitExpression = input.split(" ");
        part1 = splitExpression[0];
        operand = splitExpression[1];
        part2 = splitExpression[2];
        //make return a string that includes part 2 
        
        
     //return part2;		//was for part 1
    }
    
    public static String[] parseOperand(String input) {
    	String[] parsed = {null, null, null};
    	
    	
    	
    	return parsed;//String[]
    // TODO: Fill in the space below with any helper methods that you think you will need
    }
}