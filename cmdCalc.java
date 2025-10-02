import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class cmdCalc {
    //global variables
    public static double result;
    public static double x;
    public static double y;
    private static double memory;
    public static boolean running;

    //Global list history for storing records for calculation
    private static ArrayList<String> history = new ArrayList<>();



    public static void main(String[] args){ //entry point

        Scanner scanner = new Scanner(System.in);

        running = true;

        while (running){ //main programme loop
            //display menu options
            System.out.println("\n1. Start math operation");
            System.out.println("2. history");
            System.out.println("3.M+,M-,MC,MR");
            System.out.println("4. exit");
            System.out.print("Choose option: ");
            String choice = scanner.next();



            switch (choice){ //process user's menu choice
                case "1"://math operations
                    try{
                        System.out.print("Enter first value: ");
                        int x_value = scanner.nextInt();
                        System.out.print("Enter second value: ");
                        int y_value = scanner.nextInt();
                        //converts to double for calculation
                        x = (double) x_value;
                        y = (double) y_value;
                    } catch (InputMismatchException e){
                        //handles non-numeric input
                        System.out.println("You entered a non-digit number");
                        running = true;
                        break;
                    }


                    Double result=null; //stores result
                    String operationRecord=""; //stores operation for history

                    System.out.print("Enter operation(+,-,/,x,%): ");
                    String operation = scanner.next();
                
                    //perform arithmetic operation
                    switch (operation) { 
                        case "+":
                            System.out.println(add(x,y));
                            result=add(x,y);
                            operationRecord= x + " + " + y + " = " +result;
                            break;
                        case "-":
                            System.out.println(sub(x,y));
                            result=add(x,y);
                            operationRecord= x + " - " + y + " = " +result;
                            break;
                        case "/":
                            System.out.println(div(x,y));
                            result=add(x,y);
                            operationRecord= x + " / " + y + " = " +result;
                            break;
                        case "x":
                        case "X":
                            System.out.println(mul(x,y));
                            result=add(x,y);
                            operationRecord= x + " x " + y + " = " +result;
                            break;
                        case "%":
                            System.out.print(mod(x,y));
                            result=add(x,y);
                            operationRecord= x + " + " + y + " = " +result;
                            break;
                        default:
                            System.out.println("\nyou did not choose an operation\n");
                            break;
                    }
                    updateHistory(operationRecord); //add operation to history

                    break;

                case "2": //shows the list of evaluations done
                    displayHistory();
                    break;

                case "3":
                    System.out.print("\nChoose Memory function(1.M+, 2.M-,3.MC, 4.MR)> ");
                    String memoryOp = scanner.next();
    
                    //handling the memory
                    switch (memoryOp){

                        case "1":
                        case "m+":

                            System.out.print("Enter value to be saved> ");
                            try{
                                int saveValue = scanner.nextInt();
                                memoryAdd(saveValue);
                            } catch (InputMismatchException e){

                                System.out.println("Invalid input");
                                break;
                            }

                            break;

                        case "m-":
                        case "2":
                            System.out.println("\n enter value to be removed>");
                            try
                            {
                                int removevalue =scanner.nextInt();

                                memorySub(removevalue);
                            } catch(InputMismatchException e)
                                {
                                    System.out.println("invalid input");
                                }
                            break;

                        case "mc":
                        case "3":
                            memoryClear();
                            break;

                        case "mr":
                        case "4":
                            System.out.print(memoryRecall());
                            break;


                        default:
                            System.out.print("error!");
                            break;
                    }

                    break;

                case "4":
                    System.out.print("You are now leaving the program...");
                    try{

                        Thread.sleep(2000);
                    } catch(InterruptedException e) {
                        //
                    }

                    running = false;
                    break;

            }

        }
    }
    /*
        Methods used in this calculator
        f1 -> first input value
        f2 -> second input value
    */


    public static double add(double f1, double f2){
        result = f1 + f2;
        return result;
    }

    public static double sub(double f1, double f2){
        result = f1 - f2;
        return result;
    }

    public static double mul(double f1, double f2){
        result = f1 * f2;
        return result;
    }

    public static double mod(double f1, double f2){
        result = f1 % f2;
        return result;
    }

    public static double div(double f1, double f2){
        result = f1 / f2;
        return result;
    }

    public static void memoryClear(){
        memory = 0.0;
        System.out.print("memory cleared");
    }

    public static double memoryRecall(){
        return memory;
    }

    public static double memoryAdd(double value){
        memory += value;
        System.out.println("Added: "+value+" to the memory\n");
        return memory;

    }

    public static void memorySub(double value){
        memory -= value;
        System.out.println("Removed: "+value+" from the memory");

    }

    static void updateHistory(String operation)
    {
        history.add(operation);
    }

    public static void displayHistory()
    {
        if (history.isEmpty())
        {
            System.out.println("\nNo calculation in history.\n");
        }
        else
        {
            System.out.println("\ncalculation History:\n");
            for (int i = 0; i< history.size(); i++)
            {
                System.out.println((i+ 1) + "." + history.get(i));

            }
            System.out.print("\n");
        }
    }

}
