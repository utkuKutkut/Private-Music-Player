import java.io.Serializable;

//My abstract class. I will use this to override the other subscription classes
public abstract class subscription implements Serializable {

    private int songLimit;
    private String subscriptionType;

    public subscription(int songLimit,String subscriptionType) {
        this.songLimit=songLimit;
        this.subscriptionType=subscriptionType;
    }

    //abstract getters
    public int getSongLimit(){
        return songLimit;
    }
    public String getSubscriptionType(){
        return subscriptionType;
    }

}
