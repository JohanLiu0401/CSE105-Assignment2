// Liu Zhiyong 1509264
package CSE105;
import java.util.*;
import java.text.*;
public class CarSold {
    private int id;
    private int purchasePrice;
    private int salePrice;
    private Date dateOfPurchase;
    private Date dateOfSale;
    static ArrayList<CarSold> listOfCarSale = new ArrayList<CarSold>();
    static Scanner kb = new Scanner(System.in);
    private String isOnSale = "Sold";
    
    public void setID(int id)
    {
        this.id = id;
    }
    public void setPurchasePrice(int purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }
    public void setSalePrice(int salePrice)
    {
        this.salePrice = salePrice;
    }
    public void setDateOfPurchase(Date dateOfPurchase)
    {
        this.dateOfPurchase = dateOfPurchase;
    }
    public void setDateOfSale(Date dateOfSale)
    {
        this.dateOfSale = dateOfSale;
    }
    public String flatten()//Return the string content of CarSold object
    {
        SimpleDateFormat cb = new SimpleDateFormat("yyyy/mm/dd");
        String date1 = cb.format(dateOfPurchase);
        String date2 = cb.format(dateOfSale);
        
        return isOnSale+","+id+","+purchasePrice+","+date1+","+salePrice+","+date2;
        
    }
    
    public static void addCarSold()//Add a car sold. 
    {
        System.out.print("Which car will be sold? Please enter the id:\n");
        int idChoose;
        boolean idValid = false;
        CarSold a = new CarSold();
        CarForSale b;
        while(!idValid)
        {
            Iterator<CarForSale> it = CarForSale.listOfCarsForSale.iterator();
            idChoose = kb.nextInt();
            kb.nextLine();
            while(it.hasNext())
            {
                b=it.next();
                if(b.getID()==idChoose)
                {
                    a.purchasePrice = b.getPurchasePrice();
                    a.dateOfPurchase = b.getDateOfPurchase();
                    a.id = b.getID();
                    it.remove();
                    idValid = true;
                }
            } 
            
            if(idValid == false)
            {
                System.out.print("No this car for sale, please enter an another id:\n");
            }
        }
        
        boolean inputPrice=false;
        boolean inputDate=false;
        System.out.print("Please enter the sale price:\n");
        while(!inputPrice)
        {
            try
            {
                a.salePrice= kb.nextInt();//Note the price of sold
                kb.nextLine();
                inputPrice = true;
            }
            catch(Exception e1)
            {
                System.out.print("Invalid price, Please enter again:\n");
                kb.nextLine();
            }
        }
        
        SimpleDateFormat cb = new SimpleDateFormat("yyyy mm dd");
        System.out.print("Please enter the date of sale in the format of \"yyyy mm dd\":\n");
        while(!inputDate)
        {
            try
            {
                a.dateOfSale=cb.parse(kb.nextLine());//Note the date of sold
                inputDate=true;
                
            }
            catch(Exception e2)
            {
                System.out.print("Invalid date, Please enter again:\n");
            }
        }
        listOfCarSale.add(a);
    }
    
    public static void displayCarSold()//Display all the cars sold and the total profit
    {
        int totalProfit = 0;
        System.out.print("\nID\t  PriceOfPurchase\tPriceOfSale\t\n");
        Iterator<CarSold> it = listOfCarSale.iterator();
        while(it.hasNext())
        {
            CarSold a = it.next();
            totalProfit = totalProfit + (a.salePrice-a.purchasePrice);
            System.out.print(a.id+"\t\t"+a.purchasePrice+"\t\t   "+a.salePrice+"\n");
        }
        System.out.print("TotalProfit = "+totalProfit+"\n\n");
        
        System.out.println("Please enter '0' to quit this display table:");
        kb.nextInt();
    }
    
    
}
