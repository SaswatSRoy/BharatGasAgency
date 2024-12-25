import GasBooking.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static gasPackage.gasAgency.*;

public class Main {
    static int bcount=0, pcount=0, ccount=0, dcount=0;
    static int count;
    static String dpname;
    static Scanner scanner = new Scanner(System.in);

    public static void cylinderCount(Delivery[] obj){  //to access all the attributes , we use the concept of Object. And Delivery is used as it inherits all the parent classes.

        String [] months= new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};

        for (Delivery delivery:obj){
            count=0;
            System.out.println("In the month of "+ months[delivery.date_2.getMonth()] +" :");
            System.out.println(" *In "+ delivery.area);
            if(delivery.status.equals("D")){
                count+=delivery.numOfCylinders;
            }
            System.out.println(" - "+count+" cylinders Delivered Successfully :)");
        }
        System.out.println("\n");
    }

    public static void checkLateDelivery(Delivery []obj){
        String [] months= new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
        int []month=new int[12];
        for(Delivery delivery:obj){
            if(delivery.status.equals("D")&& delivery.amount==833.75){
                month[delivery.date_2.getMonth()]+=1;
            }
        }
        System.out.println("------------Late Delivery-------------");
        for(int i=0;i<12;i++){
            System.out.println(" * In "+months[i]+" there are: "+month[i]);
        }
        System.out.println("\n");
    }

    public static void numOfSingleCylindersHolders(Delivery []obj){
        System.out.println("--------------Single Cylinder Holders---------------");
        for(int i=0;i<obj.length;i++){
            if(obj[i].numOfCylinders==1){
                System.out.println(" * Customer Name: "+obj[i].name);
                System.out.println(" * Mobile Number: "+obj[i].mobile);
                System.out.println(" * Gas Connection Number: "+(i+101));
            }
        }
        System.out.println("\n");

    }

    public static void numOfDoubleCylindersHolders(Delivery []obj){
        System.out.println("--------------Double Cylinder Holders---------------");
        for(int i=0;i<obj.length;i++){
            if(obj[i].numOfCylinders==2){
                System.out.println(" * Customer Name: "+obj[i].name);
                System.out.println(" * Mobile Number: "+obj[i].mobile);
                System.out.println(" * Gas Connection Number: "+(i+201));
            }
        }
        System.out.println("\n");

    }

    public static void deliveryDetails(Delivery[]obj){
        System.out.println("-----------------Delivery Details--------------------");
        System.out.println("Enter delivery person name: ");
        dpname=new Scanner(System.in).nextLine();

        for(Delivery delivery:obj){
            if(delivery.status.equals("D")&& delivery.delPersonName.equals(dpname)){
                System.out.println(" * Customer Name: "+delivery.name);
                System.out.println(" - "+delivery.street+", "+delivery.area+", "+delivery.pincode);
            }
        }
        System.out.println("\n");
    }


    public static void report(Delivery[]obj){
        System.out.println("-------------------Delivery Report----------------------");
        for (Delivery delivery : obj) {
            switch (delivery.status) {
                case "D" -> dcount++;
                case "B" -> bcount++;
                case "C" -> ccount++;
                case "P" -> pcount++;
                default -> System.out.println("Status Invalid");
            }
            System.out.println(" * Booked");
            System.out.println(" - "+bcount+" booked");
            System.out.println(" * Canceled");
            System.out.println(" - "+ccount+" cancelled");
            System.out.println(" * Delivered");
            System.out.println(" - "+dcount+" delivered");
            System.out.println(" * Pending");
            System.out.println(" - "+pcount+" pending");
            System.out.println("\n");
        }

    }
    public static void invoice(Delivery []obj){
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String invoiceDate=sdf.format(d);
        for(int i=0;i<obj.length;i++){
            if(obj[i].status.equals("D")){
                System.out.println("----------------------------------------------------------");
                System.out.println("                        INVOICE                           ");
                System.out.println("----------------------------------------------------------");
                System.out.println("* Gas Agency Code: "+agencyCode+"\t\t\t"+" Date of Invoice: "+invoiceDate);
                System.out.println("* Gas Agency Name: "+agencyName+"\t\t"+" Agency phone number: "+phoneNumber);
                System.out.println("* Gas Connection No: "+(i+101)+"\t\t\t"+" Customer Name: "+obj[i].name);
                System.out.println("* Booking Date: "+sdf.format(obj[i].date_1)+"\t\t"+" Customer Mobile No: "+obj[i].mobile);
                System.out.println("----------------------------------------------------------");
                System.out.println("* Amount: "+obj[i].amount);
                System.out.println("* Refund: "+obj[i].refund);
                System.out.println("* Total Amount"+(obj[i].amount-obj[i].refund));
                System.out.println("----------------------------------------------------------");
                System.out.println("* Delivery Person Name: "+obj[i].delPersonName+"\t\t"+" Delivery person phone number: "+obj[i].delMobileNumber);
                System.out.println("* Delivery Date: "+sdf.format(obj[i].date_2));
                System.out.println("----------------------------------------------------------");
                System.out.println("\n\n");

            }
        }
    }

    public static void main(String[] args) {
        System.out.println("****************************************************************");
        System.out.println("                     Bharat Gas Agency                          ");
        System.out.println("****************************************************************");

        System.out.println("Enter the number of customers: ");
        int numCustomers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create array of deliveries
        Delivery[] deliveries = new Delivery[numCustomers];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Input customer details
            for (int i = 0; i < numCustomers; i++) {
                System.out.println("\nEnter details for Customer " + (i + 1) + ":");

                System.out.println("Enter customer name: ");
                String name = scanner.nextLine();

                System.out.println("Enter street address: ");
                String street = scanner.nextLine();

                System.out.println("Enter area: ");
                String area = scanner.nextLine();

                System.out.println("Enter pincode: ");
                String pincode = scanner.nextLine();

                System.out.println("Enter mobile number: ");
                String mobile = scanner.nextLine();

                System.out.println("Enter number of cylinders (1 or 2): ");
                int numCylinders = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.println("Enter last booking date (dd/MM/yyyy): ");
                String lastDateStr = scanner.nextLine();
                Date lastDate = sdf.parse(lastDateStr);

                // Create delivery object
                deliveries[i] = new Delivery(name, street, area, pincode, mobile, numCylinders, lastDate, sdf);

                // Get booking and delivery dates
                System.out.println("\nBooking Process for " + name);
                deliveries[i].getDate();

                // Validate booking
                deliveries[i].validate();

                if (deliveries[i].status.equals("B")) {
                    // Set delivery person
                    deliveries[i].setDelPersonName();

                    // Calculate amount including any refunds
                    deliveries[i].amountCalc();

                    // Verify OTP for delivery
                    System.out.println("Enter OTP for delivery verification (default: 5678): ");
                    deliveries[i].verifyOtp();
                }

                System.out.println("\n----------------------------------------");
            }

            // Generate reports
            boolean showReports = true;
            while (showReports) {
                System.out.println("\nReport Menu:");
                System.out.println("1. Cylinder Count by Month");
                System.out.println("2. Late Delivery Report");
                System.out.println("3. Single Cylinder Holders");
                System.out.println("4. Double Cylinder Holders");
                System.out.println("5. Delivery Person Details");
                System.out.println("6. Overall Report");
                System.out.println("7. Generate Invoices");
                System.out.println("8. Exit");

                System.out.println("\nEnter your choice (1-8): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        cylinderCount(deliveries);
                        break;
                    case 2:
                        checkLateDelivery(deliveries);
                        break;
                    case 3:
                        numOfSingleCylindersHolders(deliveries);
                        break;
                    case 4:
                        numOfDoubleCylindersHolders(deliveries);
                        break;
                    case 5:
                        deliveryDetails(deliveries);
                        break;
                    case 6:
                        report(deliveries);
                        break;
                    case 7:
                        invoice(deliveries);
                        break;
                    case 8:
                        showReports = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
