package GasBooking;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Delivery extends Booking{

    public String delPersonName;
    public int customerOtp;
    public Delivery(String name, String street, String area, String pincode, String mobile, int numOfCylinders, Date lastDate, SimpleDateFormat dateFormat) {
        super(name, street, area, pincode, mobile, numOfCylinders, lastDate, dateFormat);
    }

    public void amountCalc(){
        long refundDiff=date_2.getTime()-date_1.getTime();
        long newRefundDiff= TimeUnit.DAYS.convert(refundDiff,TimeUnit.MILLISECONDS);

        if(newRefundDiff>7){
            refund=41.25;
            amount-=refund;
        }
    }

    public void verifyOtp(){
        customerOtp=new Scanner(System.in).nextInt();
        if(status.equals("B")){
            if(customerOtp !=otp){
                System.out.println("Sorry ! Wrong Otp");
                status="C";
            }else {
                System.out.println("Successfully delivered. Thank you!!");
                status="D";//Delivered.
            }
        }else{
            System.out.println("Sorry no booking found.");
        }

    }
    public void setDelPersonName(){
        System.out.println("\n Enter the delivery persons name: ");
        delPersonName=new Scanner(System.in).nextLine();

    }


}
