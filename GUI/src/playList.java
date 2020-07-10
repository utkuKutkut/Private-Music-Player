import java.io.Serializable;
import java.util.ArrayList;

public class playList implements Serializable {

    protected int playListID;
    protected String playListName;
    protected String owner;

    protected ArrayList<song> songsOfPlaylist=new ArrayList<song>();

    public playList(int playListid,String name,String owner){
        this.playListID=playListid;
        this.playListName=name;
        this.owner=owner;
    }

    //OBJECT SERIALIZATION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public String toString() {
        return "Playlist [name="+playListName+", id="+playListID+", owner="+owner+"]";
    }


}
