import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class musicPlayer implements Serializable {

    public ArrayList<playList> allPlaylists = new ArrayList <playList> ();
    public ArrayList<user> allUsers= new ArrayList<user>();
    public ArrayList <song> allSongs = new ArrayList <song> ();

    int userKeys=1;
    int songKeys=1;
    int playlistKeys=1;
    int emailKeys=1;

    public void addUser() {
        user newUser= new user(userKeys,"User "+userKeys,"Email "+emailKeys);
        userKeys++;
        emailKeys++;
        allUsers.add(newUser);
        System.out.println("User added successfully!");
    }

    public int deleteUser(int id) {
        int found=0;
        for(int i=0;i<allUsers.size();i++){
            if(allUsers.get(i).userID==id){
                allUsers.remove(allUsers.get(i));
                found=1;
                System.out.println("User deleted successfully!");
                break;
            }
        }

        if(found==0) {
            System.out.println("User couldn't found. Please enter the correct ID !");
            return -1;
        }
        return 1;
    }

    public void addSong() {
        song newSong=new song(songKeys,"Song "+songKeys,"Genre "+songKeys);
        songKeys++;
        allSongs.add(newSong);
        System.out.println("Song added successfully!");
    }


    public int deleteSong(int id) {
        int found=0;
        for(int i=0;i<allSongs.size();i++){
            if(allSongs.get(i).songID==id){
                //notice that users still can have the deleted songs in their playlist (if they added before the deletion)
                allSongs.remove(allSongs.get(i));
                found=1;
                System.out.println("Song deleted !");
                break;
            }
        }
        if(found==0) {
            System.out.println("Song ID couldn't find!");
            return -1;
        }
        return 1;
    }


    public int addPlaylistUser(int id) {
        int found=0;int index=0;
        String owner="";
        for(int i=0;i<allUsers.size();i++){
            if(allUsers.get(i).userID==id){
                owner=allUsers.get(i).userName;
                index=i;
                found=1;
                break;
            }
        }
        if(found==0){
            System.out.println("User ID is invalid");
            return -1;
        }
        else{
            playList newPlaylist=new playList(playlistKeys,"My Playlist "+playlistKeys,owner);
            allPlaylists.add(newPlaylist);
            allUsers.get(index).userPlayLists.add(newPlaylist);
            playlistKeys++;
            return 1;
        }

    }

    public int addSongToPlaylist(int songID,int playID) {
        int found1=0; int found2=0;
        int index1=0; int index2=0;
        for(int i=0;i<allSongs.size();i++){
            if(songID==allSongs.get(i).songID){
                found1=1;
                index1=i;
            }
        }
        for(int i=0;i<allPlaylists.size();i++){
            if(playID==allPlaylists.get(i).playListID){
                found2=1;
                index2=i;
            }
        }
        if(found1==0 || found2==0){
            System.out.println("Invalid input");
            return -1;
        }
        else{
            allPlaylists.get(index2).songsOfPlaylist.add(allSongs.get(index1));
            System.out.println("Song added to playlist successfully.");
            return 1;
        }
    }

    public int deletePlaylist(int play_id) {
        int found=0;
        for(int i=0;i<allPlaylists.size();i++) {
            if (allPlaylists.get(i).playListID == play_id) {
                found = 1;
                allPlaylists.remove(allPlaylists.get(i));
                System.out.println("Playlist deleted successfully!");
                break;
            }
        }
        if(found==0){
            System.out.println("Invalid playList ID");
            return -1;
        }
        return 1;
    }


    public int followPerson(int user1ID,int user2ID) {
        int found1=0 ,found2=0;
        int index1=0, index2=0;
        for(int i=0;i<allUsers.size();i++){
            if(allUsers.get(i).userID==user1ID){
                found1=1;
                index1=i;
            }
            else if(allUsers.get(i).userID==user2ID){
                found2=1;
                index2=i;
            }
        }
        if(found1!=1 || found2!=1){
            System.out.println("User ID is not valid...");
            return -1;
        }
        else{
            allUsers.get(index1).Followings.add(allUsers.get(index2));
            allUsers.get(index2).Followers.add(allUsers.get(index1));
        }
        return 1;
    }


    public  String printAllUsers(){
        String msg="";
        for(int i=0;i<allUsers.size();i++){
            System.out.println(allUsers.get(i).toString());
            msg+=allUsers.get(i).toString();
            msg+="\n";
        }
        return msg;
    }

    public  String userDetails(int id){
        int found=0;
        for(int i=0;i<allUsers.size();i++){
            if(allUsers.get(i).userID==id){
                System.out.println(allUsers.get(i).toString());
                found=1;
                return allUsers.get(i).toString();
            }
        }
        if (found==0){
            System.out.println("User ID not valid");
            return "User ID not valid";
        }
        return "";
    }

    public  String playlistDetails(int id){
        for(int i=0;i<allPlaylists.size();i++) {
            if (allPlaylists.get(i).playListID == id) {
                System.out.println(allPlaylists.get(i).toString());
                return allPlaylists.get(i).toString();
            }
        }
        return "";
    }

    public String printAllSongs(){
        String all="";
        for(int i=0;i<allSongs.size();i++){
            System.out.println(allSongs.get(i).toString());
            all+=allSongs.get(i).toString();
            all+="\n";
        }
        return all;
    }

    public  String printFollowers(int id){
        int found=0;
        int index=0;
        String msg="";
        for(int i=0;i<allUsers.size();i++){
            if(id==allUsers.get(i).userID){
                index=i;
                found=1;
                break;
            }
        }
        if(found==1){
            for(int i=0;i<allUsers.get(index).Followers.size();i++){
                for(int j=0;j<allUsers.size();j++){
                    //The reason we have 2 loop is, we need to make sure this follower is still alive in the system
                    if(allUsers.get(index).Followers.get(i).userID==allUsers.get(j).userID){
                        System.out.println(allUsers.get(index).Followers.get(i));
                        msg+=allUsers.get(index).Followers.get(i);
                        msg+="\n";
                    }
                }
            }
        }
        else{
            System.out.println("Invalid ID");
            msg+="Invalid user ID!";
        }
        return msg;
    }

    // this function for COMMAND LINE version. I didn't use for GUI
    public void changeSubscription(int userID,int type){
        int index=0; int found=0;
        String msg="";
        for(int i=0;i<allUsers.size();i++){
            if(allUsers.get(i).userID==userID){
                index=i;
                found=1;
                break;
            }
        }
        //type=1 public, type=2 student, type=3 premium
        if(type==1 && found==1){
            public_subscription newSubs=new public_subscription();
            allUsers.get(index).subsType=newSubs;
        }
        else if(type==2 && found==1){
            System.out.println("Enter your School name:");
            Scanner reader1 = new Scanner(System.in);  // Reading from System.in
            String name1 = reader1.nextLine();
            System.out.println("Enter your School ID:");
            Scanner reader2 = new Scanner(System.in);  // Reading from System.in
            int id1 = reader2.nextInt();
            System.out.println("Enter your School Address:");
            Scanner reader3 = new Scanner(System.in);  // Reading from System.in
            String address = reader3.nextLine();

            student_subscription newSubs=new student_subscription(name1,address,id1);
            allUsers.get(index).subsType=newSubs;
        }
        else if(type==3 && found==1){
            System.out.println("Enter your Work organization name:");
            Scanner reader1 = new Scanner(System.in);  // Reading from System.in
            String name1 = reader1.nextLine();
            System.out.println("Enter your Work organization address:");
            Scanner reader2 = new Scanner(System.in);  // Reading from System.in
            String address = reader2.nextLine();
            System.out.println("In order to do payment, please provide your credit card number:");
            Scanner reader3 = new Scanner(System.in);  // Reading from System.in
            double cardNumber  = reader3.nextInt();

            premium_subscription newSubs=new premium_subscription(name1,address,cardNumber);
            allUsers.get(index).subsType=newSubs;
        }
        else{
            System.out.println("Invalid ID");
        }


    }


    //These functions were necessarry for GUI version of music player application !!!
    public String subscribePublic(int userID) {
        String msg="";
        int index=0; int found=0;
        for(int i=0;i<allUsers.size();i++){
            if(allUsers.get(i).userID==userID){
                index=i;
                found=1;
                break;
            }
        }

        if(found==1){
            public_subscription newSubs=new public_subscription();
            allUsers.get(index).subsType=newSubs;
            msg+="Subscription type successfully changed!";
        }
        else{
            msg+="Invalid user ID!";
        }
        return msg;
    }


    public String subscribeStudent(int userID,String sname,int sID,String saddress) {
        String msg="";
        int index=0; int found=0;
        for(int i=0;i<allUsers.size();i++){
            if(allUsers.get(i).userID==userID){
                index=i;
                found=1;
                break;
            }
        }

        if(found==1){
            student_subscription newSubs=new student_subscription(sname,saddress,sID);
            allUsers.get(index).subsType=newSubs;
            msg+="Subscription type successfully changed!";
        }
        else{
            msg+="Invalid user ID!";
        }
        return msg;
    }


    public String subscribePremium(int userID,String wname,String waddress,double cnumber) {
        String msg="";
        int index=0; int found=0;
        for(int i=0;i<allUsers.size();i++){
            if(allUsers.get(i).userID==userID){
                index=i;
                found=1;
                break;
            }
        }

        if(found==1){
            premium_subscription newSubs=new premium_subscription(wname,waddress,cnumber);
            allUsers.get(index).subsType=newSubs;
            msg+="Subscription type successfully changed!";
        }
        else{
            msg+="Invalid user ID!";
        }
        return msg;
    }




}
