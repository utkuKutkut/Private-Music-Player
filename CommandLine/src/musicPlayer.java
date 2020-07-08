import java.util.ArrayList;
import java.util.Scanner;

public class musicPlayer {

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

    public void deleteUser(int id) {
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
        }
    }

    public void addSong() {
        song newSong=new song(songKeys,"Song "+songKeys,"Genre "+songKeys);
        songKeys++;
        allSongs.add(newSong);
        System.out.println("Song added successfully!");
    }


    public void deleteSong(int id) {
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
        }
    }


    public void addPlaylistUser(int id) {
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
        }
        else{
            playList newPlaylist=new playList(playlistKeys,"My Playlist "+playlistKeys,owner);
            allPlaylists.add(newPlaylist);
            allUsers.get(index).userPlayLists.add(newPlaylist);
            playlistKeys++;
        }
    }

    public void addSongToPlaylist(int songID,int playID) {
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
        }
        else{
            allPlaylists.get(index2).songsOfPlaylist.add(allSongs.get(index1));
            System.out.println("Song added to playlist successfully.");
        }
    }

    public void deletePlaylist(int play_id) {
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
        }
    }


    public void followPerson(int user1ID,int user2ID) {
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
        }
        else{
            allUsers.get(index1).Followings.add(allUsers.get(index2));
            allUsers.get(index2).Followers.add(allUsers.get(index1));
        }

    }


    public  void printAllUsers(){
        for(int i=0;i<allUsers.size();i++){
            System.out.println(allUsers.get(i).toString());
        }
    }

    public  void userDetails(int id){
        int found=0;
        for(int i=0;i<allUsers.size();i++){
            if(allUsers.get(i).userID==id){
                System.out.println(allUsers.get(i).toString());
                found=1;
                break;
            }
        }
        if (found==0){
            System.out.println("User ID not valid");
        }
    }

    public  void playlistDetails(int id){
        for(int i=0;i<allPlaylists.size();i++) {
            if (allPlaylists.get(i).playListID == id) {
                System.out.println(allPlaylists.get(i).toString());
                break;
            }
        }
    }

    public  void printAllSongs(){
        for(int i=0;i<allSongs.size();i++){
            System.out.println(allSongs.get(i).toString());
        }
    }

    public  void printFollowers(int id){
        int found=0;
        int index=0;
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
                    }
                }
            }
        }
        else{
            System.out.println("Invalid ID");
        }
    }

    public void changeSubscription(int userID,int type){
        int index=0; int found=0;
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





}
