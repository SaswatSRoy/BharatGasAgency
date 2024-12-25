package GasBooking;
import customers.GasConnection;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Booking extends GasConnection{
    public double otp=5678,amount=875.0,refund =0 ;
    public String delDate,status,delMobileNumber="8249365552",bookingDate;
    public Date date_1,date_2;

    public Booking(String name, String street, String area, String pincode, String mobile, int numOfCylinders, Date lastDate, SimpleDateFormat dateFormat) {
        super(name, street, area, pincode, mobile, numOfCylinders, lastDate, dateFormat);
    }

    public void getDate(){
        System.out.println("Enter Booking Date: ");
        bookingDate=new Scanner(System.in).nextLine();
        date_1=null;
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        try{
            date_1=dateFormat.parse(bookingDate);
        }catch (Exception e){
            System.out.println("The error: "+ e);
        }

        System.out.println("Enter the Delivery Date: ");
        delDate=new Scanner(System.in).nextLine();
        date_2=null;
        try{
            date_2=dateFormat.parse(delDate);
        }catch (Exception e){
            System.out.println("The error: "+e);
        }

        try{
            long timeDiff=date_1.getTime()-date_2.getTime();
            long newTimeDiff= TimeUnit.DAYS.convert(timeDiff,TimeUnit.MILLISECONDS);

            if(newTimeDiff>7){
                status="P"; //Pending Status
            }
        }catch (Exception e){
            System.out.println("The error while calculating difference: "+e);
        }

    }

    public void validate(){
        long validatingDiffDate= date_1.getTime()-lastDate.getTime();
        long updatedValidatingDiffDate= TimeUnit.DAYS.convert(validatingDiffDate,TimeUnit.MILLISECONDS);

        if(numOfCylinders==1){
            if(updatedValidatingDiffDate<30){
                System.out.println("Booking cannot be done.");
                status="C"; //booking canceled.
            }else{
                status="B";
                System.out.println("Booking Successful");// Booking successful
                lastDate=date_1;
            }
        } else if (numOfCylinders==2) {
            if (updatedValidatingDiffDate<50){
                System.out.println("Booking cannot be done.");
                status="C";
            }else{
                status="B";
                System.out.println("Booking Successful");
                lastDate=date_1;
            }
        }
    }
}
