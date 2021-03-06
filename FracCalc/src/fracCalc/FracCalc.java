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
        String[] splitExpression = new String[3];
        splitExpression = input.split(" ");
        String part1 = splitExpression[0];
        String operand = splitExpression[1];
        String part2 = splitExpression[2];
        String[] part1return = parseOperand(part1);
        String[] part2return = parseOperand(part2);
        String[] value = findOperand(part1return, operand, part2return);
        String convertedValue = value[0] + "_" + value[1] + "/" + value[2];
        return convertedValue;
  //   return ("whole:" + part2return[0] + " numerator:" + part2return[1] + " denominator:" + part2return[2]);
    }	
    
   
    //METHOD: Returns the input as an array the rest of the program can use
    public static String[] parseOperand(String input) {		
    	String[] parsed = {"0", "0", "0"};
    	if (input.contains("_") && input.contains("/")) {
    
    		//This is a fraction and a whole number
    		String[] preParsing = new String[2];
    		preParsing = input.split("_");
    		//Now we have to get the fraction out.
    		String[] preParsing2 = (preParsing[1].split("/"));	//Separates fraction
    		parsed[0] = preParsing[0];				//Final assignment
    		parsed[1] = preParsing2[0];				//Final assignment
    		parsed[2] = preParsing2[1];				//Final assignment

    	} else if (input.contains("/")) {
    		
    		//This is just a fraction
    		String[] preParsingFrac = (input.split("/"));	//Separates fraction
    		parsed[0] = "0";							//Final assignment
    		parsed[1] = preParsingFrac[0];				//Final assignment
    		parsed[2] = preParsingFrac[1];				//Final assignment
   		
    	} else {
    		
    		//This is just a whole number.
    		String[] preParsing = new String[2];
    		preParsing = input.split("_");
    		parsed[0] = Integer.toString(Integer.parseInt(preParsing[0]) - 1);		//Final assignment
    		parsed[1] = "1";				//Final assignment
    		parsed[2] = "1";				//Final assignment
    		
    	}
    
    	return parsed;	//Returns input, parsed as a String[]
    // TODO: Fill in the space below with any helper methods that you think you will need
    
    
    }
    
    //METHOD: Checks operands and sends request for correct function
    
    public static String[] findOperand(String[] firstFrac, String operandIn, String[] secondFrac) {
    	String[] output = {"0","0","0"};
    	
    	if (operandIn.equals("+")) {
    		//This is addition   		
    		output[0] = Integer.toString(Integer.parseInt(firstFrac[0]) + Integer.parseInt(secondFrac[0]));
    		//Check common denominators
    		if (secondFrac[2].equals(firstFrac[2])) {
    			int num1 = Integer.parseInt(firstFrac[1]);
    			int num2 = Integer.parseInt(secondFrac[1]);
    			output[1] = Integer.toString(num1 +num2);
    			output[2] = firstFrac[2];
    		} else {
    			//Mixed number issue
    			//Set Numerator: Each Numerator is multiplied by the opposite denominator. Use temporary variables.
    			int num1 = Integer.parseInt(firstFrac[1]) * Integer.parseInt(secondFrac[2]);	//Converts the string to a int temporarily to multiply it.
    			int num2 = Integer.parseInt(secondFrac[1]) * Integer.parseInt(firstFrac[2]);
    			output[1] = Integer.toString(num1 + num2);
    			int den1 = Integer.parseInt(firstFrac[2]);
    			int den2 = Integer.parseInt(secondFrac[2]);
    			output[2] = Integer.toString(den1 * den2);
    		}
    		
    	} else if (operandIn.equals("-")) {
    		//This is subtraction
    		int whole1 = Integer.parseInt(firstFrac[0]);
    		int whole2 = Integer.parseInt(secondFrac[0]);
    		output[0] = Integer.toString(whole1 - whole2);
    		//Check common denominators
    		if (secondFrac[2].equals(firstFrac[2])) {
    			int num1 = Integer.parseInt(firstFrac[1]);
    			int num2 = Integer.parseInt(secondFrac[2]);
    			output[1] = Integer.toString(num1 - num2);	
    			output[2] = firstFrac[2];
    		} else {
    			//Mixed number issue
    			//Set Numerator: Each Numerator is multiplied by the opposite denominator. Use temporary variables.
    			int num1 = Integer.parseInt(firstFrac[1]) * Integer.parseInt(secondFrac[2]);	//Converts the string to a int temporarily to multiply it.
    			int num2 = Integer.parseInt(secondFrac[1]) * Integer.parseInt(firstFrac[2]);
    			output[1] = Integer.toString(num1 - num2);
    			int den1 = Integer.parseInt(firstFrac[2]);
    			int den2 = Integer.parseInt(secondFrac[2]);
    			output[2] = Integer.toString(den1 * den2);
    		}
    	} else if (operandIn.equals("*")) {
    		//This is multiplication
    		//No denominator check necessary
    		int numerator1 = (Integer.parseInt(firstFrac[0]) * Integer.parseInt(firstFrac[2])) + Integer.parseInt(firstFrac[1]);
    		int numerator2 = (Integer.parseInt(secondFrac[0]) * Integer.parseInt(secondFrac[2])) + Integer.parseInt(secondFrac[1]);
    		output[2] = Integer.toString(Integer.parseInt(firstFrac[2]) * Integer.parseInt(secondFrac[2]));//both denominators multiplied
    		output[1] = Integer.toString(numerator1 * numerator2);
    		output[0] = Integer.toString(Integer.parseInt(output[1]) / Integer.parseInt(output[2]));//num added dived by denominator no remainder
    		output[1] = Integer.toString(Integer.parseInt(output[1]) - (Integer.parseInt(output[0]) * Integer.parseInt(output[2])));
    	
    	} else if (operandIn.equals("/")) {
    		//This is division
    		int numerator1 = (Integer.parseInt(firstFrac[0]) * Integer.parseInt(firstFrac[2])) + Integer.parseInt(firstFrac[1]);
    		int numerator2 = (Integer.parseInt(secondFrac[0]) * Integer.parseInt(secondFrac[2])) + Integer.parseInt(secondFrac[1]);
    		output[2] = Integer.toString(Integer.parseInt(firstFrac[2]) * numerator2);//both denominators multiplied
    		output[1] = Integer.toString(numerator1 * Integer.parseInt(secondFrac[2]));
    		output[0] = Integer.toString(Integer.parseInt(output[1]) / Integer.parseInt(output[2]));//num added dived by denominator no remainder
    		output[1] = Integer.toString(Integer.parseInt(output[1]) - (Integer.parseInt(output[0]) * Integer.parseInt(output[2])));
    	
    	} else {
    		output[0] = "Operand isn't reading.";
    	}
    	
    	return output;
    }    
    
}