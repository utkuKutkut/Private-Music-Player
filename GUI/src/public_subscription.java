import java.io.Serializable;

public class public_subscription extends subscription implements Serializable {
    private static final int limit=20;
    private static final String subsType="Public";

    public public_subscription(){
        super(limit,subsType);
    }

}

