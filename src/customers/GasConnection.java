package customers;

import java.text.SimpleDateFormat;
import java.util.*;

public class GasConnection extends Customer{
    public int numOfCylinders;
    String date;
    static int connectionNumber=1000;{
        connectionNumber++;
    }
    public Date lastDate;
    SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");

    public GasConnection(String name, String street, String area, String pincode, String mobile, int numOfCylinders, Date lastDate, SimpleDateFormat dateFormat) {
        super(name, street, area, pincode, mobile);
        this.numOfCylinders = numOfCylinders;
        this.lastDate = lastDate;
        this.dateFormat = dateFormat;
    }
    public void getLastDate(){
        System.out.print("Enter the Last Date:");
        date=new Scanner(System.in).nextLine();
        try {
            lastDate= dateFormat.parse(date);
        }catch (Exception e){
            System.out.println("Error in Last Date: "+e);
        }

    }
}
