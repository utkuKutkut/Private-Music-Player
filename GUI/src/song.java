import java.io.Serializable;

public class song implements Serializable {
    protected int songID;
    protected String songName;
    protected String genre;

    public song(int id,String name,String genre){
        this.songID=id;
        this.songName=name;
        this.genre=genre;
    }

    //OBJECT SERIALIZATION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public String toString() {
        return "Song [name="+songName+", id="+songID+", genre="+genre+"]";
    }

}
