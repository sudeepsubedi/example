import java.util.Scanner;

public class SciCalculator
{
    public static void main(String[] args)
    {
        /*
        *Start the program by assuming that program should run
        * define all the involved parameters
         */

        boolean shouldRun = true;
        double totalResult = 0.0;
        double currentResult = 0.0;
        int numberOfLoops = 0;
        boolean showFullMenu = true;
        Scanner input = new Scanner(System.in);
        


        //while loop will execute only if shouldRun is true which is always true the first time
        while(shouldRun)
        {
            //the menu will print when we run the program as showFullMenu is always true for the first time
            if(showFullMenu)
            {
                System.out.println("Current Result: " + currentResult);
                System.out.println();
                System.out.println("Calculator Menu");
                System.out.println("---------------");
                System.out.println("0. Exit Program");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Exponentiation");
                System.out.println("6. Logarithm");
                System.out.println("7. Display Average");
                System.out.println();

            }

            //Ask for menu selection 
            System.out.print("Enter Menu Selection: ");

            
            int selection = input.nextInt();
      
            //shouldRun is assigned false if user enters 0
            if(selection==0)
            {
                System.out.println();
                System.out.println("Thanks for using this calculator. Goodbye!");
                shouldRun = false;
                
            }

            //if the user enters any number from 1-6 we perform calculations as directed
            else if(selection >=1 && selection <7)
            {
                numberOfLoops = numberOfLoops + 1;
                showFullMenu = true;
                double firstOperand;
                double secondOperand;

                /*first the user is asked for firstOperand as a string
                *user's choice can be RESULT or from 1-6
                * we change string into double according to the condition
                */
                System.out.print("Enter first operand: ");
                String firstOperandstr = input.next();
                if(firstOperandstr.equals("RESULT"))
                {
                    firstOperand = currentResult;
                }
                else
                {
                    firstOperand = Double.parseDouble(firstOperandstr);
                }

                //we use the same technique as firstOperand with the secondOperand
                System.out.print("Enter second operand: ");
                String secondOperandstr = input.next();
                System.out.println();

                if(secondOperandstr.equals("RESULT"))
                {
                    secondOperand = currentResult;
                }
                else
                {
                    secondOperand = Double.parseDouble(secondOperandstr);
                }

                //perform operations as indicated
                if(selection == 1)
                {
                    currentResult = (firstOperand + secondOperand);
                }
                else if(selection == 2)
                {
                    currentResult =  (firstOperand - secondOperand);
                }
                else if(selection == 3)
                {
                    currentResult =  (firstOperand * secondOperand);
                }
                else if(selection == 4)
                {
                    currentResult =  (firstOperand/secondOperand);
                }
                else if(selection == 5)
                {
                    currentResult =  (Math.pow(firstOperand,secondOperand));
                }
                //first operand is used as the base and the second as the yield for logarithm
                else
                {
                    currentResult = Math.log(secondOperand)/Math.log(firstOperand);
                }

                //totalResult is calculated
                totalResult = totalResult + currentResult;



            }

            //if the user chooses 7 as his option
            else if(selection == 7)
            {
                //Full menu won't be displayed
                showFullMenu = false;

                //If user enters 7 for the very first time the menu is displayed
                if(numberOfLoops==0)
                {
                    System.out.println();
                    System.out.println("Error: No calculations yet to average!");
                    System.out.println();
                }

                //If 7 is entered any other time except the very first time of program execution
                else
                {
                    double average = totalResult/numberOfLoops;
                    System.out.println();
                    System.out.println("Sum of calculations: " + totalResult);
                    System.out.println("Number of calculations: " + numberOfLoops);

                    /*converting the average into a 2 decimal format
                     *use printf to produce answer with 2 decimal points
                     */
                    System.out.printf("Average of calculations: %.2f" , average);
                    System.out.println();
                    System.out.println();
                }


            }

            //if the user inputs any number besides 0-7
            else
            {
                showFullMenu= false;
                System.out.println();
                System.out.println("Error: Invalid selection!");
                System.out.println();
            }
        }
    }

}