import java.util.ArrayList;


public class user{
    protected int userID;
    protected String userName;
    protected String email;
    protected subscription subsType;
    protected ArrayList <user> Followers= new ArrayList<>();
    protected ArrayList <user> Followings =new ArrayList<>();
    protected ArrayList <playList> userPlayLists =new ArrayList<playList>();



    public user(int userid, String username,String email){
        //By default, public
        this.subsType=new public_subscription();

        this.userName=username;
        this.userID=userid;
        this.email=email;
    }




    //OBJECT SERIALIZATION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public String toString() {
        return "User [Name="+userName+", ID="+userID+", Email="+email+", Subscription Type="+subsType.getSubscriptionType()+"]";
    }


}
