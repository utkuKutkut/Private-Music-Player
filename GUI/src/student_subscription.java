import java.io.Serializable;

public class student_subscription extends subscription implements Serializable {
    private static final int limit=60;
    private static final String subsType="Student";

    protected String schoolName;
    protected int schoolID;
    protected String schoolAddress;

    public student_subscription(String schoolName,String schoolAddress,int schoolID){
        super(limit,subsType);

        this.schoolAddress=schoolAddress;
        this.schoolName=schoolName;
        this.schoolID=schoolID;
    }

}
