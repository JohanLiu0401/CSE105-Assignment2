// Liu Zhiyong 1509264
package CSE105;
import java.util.*;
import java.text.*;
public class CarForSale
{
    private int id;
    private int purchasePrice;
    private Date dateOfPurchase;
    public static ArrayList<CarForSale> listOfCarsForSale = new ArrayList<CarForSale>();
    static Scanner kb = new Scanner(System.in);
    private String isOnSale = "OnSale";
    
    public int getID()
    {
        return id;
    }
    
    public int getPurchasePrice()
    {
        return purchasePrice;
    }
    
    public Date getDateOfPurchase()
    {
        return dateOfPurchase;
    }
    
    public void setID(int id)
    {
        this.id = id;
    }
    
    public void setPurchasePrice(int purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }
    
    public void setDateOfPurchase(Date dateOfPurchase)
    {
        this.dateOfPurchase = dateOfPurchase;
    }
    
    public String flatten()                     //Return the string content of CarForSale object
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd");
        String date1 = df.format(dateOfPurchase);

        return isOnSale+","+id+","+purchasePrice+","+ date1;
    }

    public static void addCar()                 //Add a new car for sale
    {
        boolean inputPrice = false;
        boolean inputDate = false;
        boolean inputUnique = false;
        SimpleDateFormat cb = new SimpleDateFormat("yyyy mm dd");
        CarForSale a = new CarForSale();

        System.out.print("Please enter the id of car (a unique number):\n");
        while(!inputUnique)
        {
            int id = kb.nextInt();
            kb.nextLine();
            if(!isUnique(id))
            {
                System.out.print("The input id is same as another car, Please enter agagin:\n");
            }
            else
            {
                a.id = id;
                inputUnique = true;
            }
        }

        System.out.print("Please enter the purchase price:\n");
        while(!inputPrice)
        {
            try
            {
                a.purchasePrice = kb.nextInt();
                kb.nextLine();
                inputPrice=true;
            }
            catch(Exception e1)
            {
                kb.nextLine();
                System.out.print("Invalid date, please enter again:\n");
            }
        }

        System.out.print("Please enter the date of purchase in the format of \"yyyy mm dd\":\n");
        while(!inputDate)
        {
            try
            {
                a.dateOfPurchase=cb.parse(kb.nextLine());
                inputDate = true;
            }
            catch(Exception e2)
            {   
                System.out.print("Invalid date, please enter again:\n");
            }
        }
        listOfCarsForSale.add(a);

    }

    public static void displayCarForSale()                  //Display all the cars for sale
    {
        CarForSale[] array = bubbleSort(listOfCarsForSale);
        System.out.print("\nID\t  PriceOfPurchase\tDateOfPurchase\t\n");
        SimpleDateFormat df = new SimpleDateFormat("yyyy mm dd");
        for(int i =0;i<array.length;i++)
        {
            String date = df.format(array[i].dateOfPurchase);
            System.out.print(array[i].id+"\t\t"+array[i].purchasePrice+"\t\t"+date+"\n");
        }
        System.out.println("Number of cars for sale:"+array.length);
        System.out.print("\nPlease enter '0' to quit this display table:\n");
        kb.nextInt();

    }

    public static CarForSale[] bubbleSort(ArrayList<CarForSale> listOfCarForSale)// Sort the cars for sale by date of purchase price
    {
        int number = listOfCarForSale.size();
        CarForSale[] array = new CarForSale[number];
        Iterator<CarForSale> it = listOfCarsForSale.iterator();
        int i = 0;
        while(it.hasNext())
        {
            array[i] = it.next();
            i++;
        }

        int length = array.length;
        for(int j = 0;j<(length-1);j++)
        {
            for(int k = 0;k<(length-j-1);k++)
            {
                if(array[k].dateOfPurchase.after(array[k+1].dateOfPurchase))
                {
                    CarForSale temp = new CarForSale();
                    temp = array[k];
                    array[k] = array[k+1];
                    array[k+1] = temp;
                }
            }
        }

        return array;
    }


    public static boolean isUnique(int id)                      //test the input id if is unique in cars for sale
    {
        Iterator<CarForSale> it = listOfCarsForSale.iterator();
        while(it.hasNext())
        {
            if(it.next().id == id)
            {
                return false;
            }
        }
        return true;
    }
}
    
   
    
    
    

