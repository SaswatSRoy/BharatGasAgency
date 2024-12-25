package customers;
import gasPackage.gasAgency;
public class Customer implements gasAgency{
    public String name;
    public String street,area,pincode,mobile;

    public Customer(String name, String street, String area, String pincode, String mobile) {
        this.name = name;
        this.street = street;
        this.area = area;
        this.pincode = pincode;
        this.mobile = mobile;
    }
}
