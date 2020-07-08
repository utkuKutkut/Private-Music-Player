

public class premium_subscription extends subscription{
    //song limit is almost limitless...
    private static final int limit=10000;
    private static final String subsType="Premium";
    protected double paymentTotal;
    protected double creditCardNumber;
    protected String workOrganisation;
    protected String workAddress;

    public premium_subscription(String workOrganisation,String workAddress,double creditCardNumber){
        super(limit,subsType);
        this.workOrganisation=workOrganisation;
        this.workAddress=workAddress;
        this.creditCardNumber=creditCardNumber;

        //this will be the cost of premium subs.
        this.paymentTotal=100;
    }

}
