// Liu Zhiyong 1509264
package CSE105;
import java.util.*;
import java.io.*;
import java.text.*;
public class Data 
{
    static Scanner kb = new Scanner(System.in);
    
    public static void inputCar()//Input a new car for sale
    {
        if(CarForSale.listOfCarsForSale.size()<20)
        {
            CarForSale.addCar();
            System.out.print("The new car has been added!\n");
            System.out.println("Please enter '0' return to main interface:");
            kb.nextInt();
            kb.nextLine();
        }
        else
        {
            System.out.print("There are already 20 cars for sale!\n");
            System.out.println("Please enter '0' return to main interface:");
            kb.nextInt();
            kb.nextLine();
            
        }
           
        
    }
    
    public static void sellCar()//Sell a car, and move this car from CarForSale to CarSold
    {
        CarSold.addCarSold();
        System.out.print("Sell this car successfully!\n");
        System.out.print("Please enter '0' return to main interface:");
        kb.nextInt();
        kb.nextLine();
    }
    
    
    public static void writeTextFile()//Write car objects into text file
    {
        File file = new File("System.txt");
        try
        {
            BufferedWriter fw = new BufferedWriter(new FileWriter(file,false));
            
            Iterator<CarForSale> it = CarForSale.listOfCarsForSale.iterator();
            while(it.hasNext())
            {
                CarForSale a = it.next();
                fw.write(a.flatten());
                fw.newLine();
            }
            
            Iterator<CarSold> itc = CarSold.listOfCarSale.iterator();
            while(itc.hasNext())
            {
                CarSold a = itc.next();
               fw.write(a.flatten());
               fw.newLine();
            }
            
            fw.flush();
            fw.close();
            System.out.print("All cars have been stored in file.\n");
        }
        catch(Exception e)
        {
            System.out.print("Error writting to file.");
        }
    }
    
    public static void readTextFile()//Read car objects from text file
    {
        File file = new File("System.txt");
        String line;
        try
        {
           
            BufferedReader fr = new BufferedReader(new FileReader(file));
            SimpleDateFormat cb = new SimpleDateFormat("yyyy/mm/dd");
            while( (line=fr.readLine())!=null)
            {
                String s[] = line.split(",");
                 
                if(s[0].equals("OnSale"))
                {
                    CarForSale a = new CarForSale();
                    a.setID(Integer.parseInt(s[1]));
                    a.setPurchasePrice(Integer.parseInt(s[2]));
                    a.setDateOfPurchase(cb.parse(s[3]));
                    CarForSale.listOfCarsForSale.add(a);
                }
                else
                {
                    CarSold a = new CarSold();
                    a.setID(Integer.parseInt(s[1]));
                    a.setPurchasePrice(Integer.parseInt(s[2]));
                    a.setDateOfPurchase(cb.parse(s[3]));
                    a.setSalePrice(Integer.parseInt(s[4]));
                    a.setDateOfSale(cb.parse(s[5]));
                    CarSold.listOfCarSale.add(a);
                }
            }
            fr.close();
            System.out.print("Succeed in reading from file.\n");
        }
        catch(Exception e)
        {
            System.out.print("Error reading from file.\n");
        }
       
    }
    
}
