// Liu Zhiyong 1509264
package CSE105;
import java.util.*;

public class UsedCarSystemStart 
{

    public static void main(String[] args) 
    {
        boolean isQuit=false;
        int inputSelection;
        Scanner kb = new Scanner(System.in);
        Data.readTextFile();
        System.out.print("Welcome to Car System!\n");
        while(!isQuit)
        {
            
            System.out.print("Please select the function you need:\n");
            System.out.print("--Add a new car, please enter '1'\n");
            System.out.print("--Sell a car, please enter '2'\n");
            System.out.print("--Display all cars for sale, please enter '3'\n");
            System.out.print("--Display the sales report, please enter '4'\n");
            System.out.print("--Quit the system, please enter '0'\n");
            System.out.print("Please enter your command:\n");
            
            inputSelection = kb.nextInt();
            if(inputSelection == 1)
            {
                Data.inputCar();
            }
            else if(inputSelection == 2)
            {
                Data.sellCar();;
            }
            else if(inputSelection == 3)
            {
                CarForSale.displayCarForSale();
            }
            else if(inputSelection == 4)
            {
                CarSold.displayCarSold();
            }
            else
            {  
                Data.writeTextFile();
                System.out.print("System close");
                isQuit=true;
            }
        }
    }
}
    

