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
    	if (!consoleInput.equals("quit")) {
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
/*        String part1 = null;
        String operand = null;
        String part2 = null;	*/
        String[] splitExpression = new String[3];
        splitExpression = input.split(" ");
        String part1 = splitExpression[0];
        String operand = splitExpression[1];
        String part2 = splitExpression[2];
        String[] part2return = parseOperand(part2);
        //make return a string that includes part 2 
        return ("whole:" + part2return[0] + " numerator:" + part2return[1] + " denominator:" + part2return[2]);
        
        
    //return part2;		//was for part 1
    }	
 
    // TODO: Implement this function to produce the solution to the input
    
    
    
   
    
/*    public static String produceAnswer(String input)
    { 
    	//Figure out what's going on in the input
    		//>Send each  number to parseOperand
    	//
    	return "Code incomplete";
    }
    */
    
    
    
    
    
    public static String[] parseOperand(String input) {		//Makes the user input into an array the rest of the program can use
    	String[] parsed = {"0", "0", "0"};
    	if (input.contains("_") && input.contains("/")) {
    		//This is a fraction and a whole number
    		String[] preParsing = new String[2];
    		preParsing = input.split("_");
    		//Now we have to get the fraction out.  //Beware of spaghetti code here sorry ms dreyer
    		String[] preParsing2 = (preParsing[1].split("/"));	//Seperates fraction
    		parsed[0] = preParsing[0];				//Final assignment
    		parsed[1] = preParsing2[0];				//Final assignment
    		parsed[2] = preParsing2[1];				//Final assignment

    	} else if (input.contains("/")) {
    		//This is just a fraction
    		String[] preParsingFrac = (input.split("/"));	//Seperates fraction
    		parsed[0] = "0";							//Final assignment
    		parsed[1] = preParsingFrac[0];				//Final assignment
    		parsed[2] = preParsingFrac[1];				//Final assignment
   		
    	} else {
    		//This is just a whole number.			//Throw if "num_" instead of "num" [DONE] 
    		parsed = input.split("_");				//Final assignment
    			//Returns like this: "[num]"
    	}
    	
    	
    	
    	return parsed;//String[]     //Might have to convert to regular string
    // TODO: Fill in the space below with any helper methods that you think you will need
    }
}