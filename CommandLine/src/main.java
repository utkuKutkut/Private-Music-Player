import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        musicPlayer main = new musicPlayer();


        while (true) {
            System.out.println("\n\nWelcome to Music Player.\n1.Add User\n2.Delete User\n3.Get user details\n4.Add song\n5.Delete song\n6.Add playlist\n7.Add song to playlist\n8.Get playlist details\n9.Delete playlist\n10.Display all songs\n11.Display all users\n12.Follow person\n13.List all followers\n14.Change subscription type\nPlease enter your choise:");
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            int n = reader.nextInt();
            switch (n) {
                case 1:
                    main.addUser();
                    break;
                case 2:
                    System.out.println("Enter the user ID:");
                    Scanner reader2 = new Scanner(System.in);  // Reading from System.in
                    int id = reader2.nextInt();
                    main.deleteUser(id);
                    break;
                case 3:
                    System.out.println("Enter the user ID:");
                    Scanner reader3 = new Scanner(System.in);  // Reading from System.in
                    int id2 = reader3.nextInt();
                    main.userDetails(id2);
                    break;
                case 4:
                    main.addSong();
                    break;
                case 5:
                    System.out.println("Enter the song ID:");
                    Scanner reader4 = new Scanner(System.in);  // Reading from System.in
                    int id3 = reader4.nextInt();
                    main.deleteSong(id3);
                    break;
                case 6:
                    System.out.println("Enter the user ID:");
                    Scanner reader5 = new Scanner(System.in);  // Reading from System.in
                    int id4 = reader5.nextInt();
                    main.addPlaylistUser(id4);
                    break;
                case 7:
                    System.out.println("Enter the song ID:");
                    Scanner reader6 = new Scanner(System.in);  // Reading from System.in
                    int id5 = reader6.nextInt();
                    System.out.println("Enter the playlist ID:");
                    Scanner reader7 = new Scanner(System.in);  // Reading from System.in
                    int id6 = reader7.nextInt();
                    main.addSongToPlaylist(id5,id6);
                    break;
                case 8:
                    System.out.println("Enter the playlist ID:");
                    Scanner reader8 = new Scanner(System.in);  // Reading from System.in
                    int id7 = reader8.nextInt();
                    main.playlistDetails(id7);
                    break;
                case 9:
                    System.out.println("Enter the playlist ID:");
                    Scanner reader9 = new Scanner(System.in);  // Reading from System.in
                    int id8 = reader9.nextInt();
                    main.deletePlaylist(id8);
                    break;
                case 10:
                    main.printAllSongs();
                    break;
                case 11:
                    main.printAllUsers();
                    break;
                case 12:
                    System.out.println("Enter your ID:");
                    Scanner reader10 = new Scanner(System.in);  // Reading from System.in
                    int id9 = reader10.nextInt();
                    System.out.println("ID of user which you want to follow:");
                    Scanner reader11 = new Scanner(System.in);  // Reading from System.in
                    int id10 = reader11.nextInt();
                    main.followPerson(id9,id10);
                    break;
                case 13:
                    System.out.println("Enter the user ID");
                    Scanner reader12 = new Scanner(System.in);  // Reading from System.in
                    int id11 = reader12.nextInt();
                    main.printFollowers(id11);
                    break;
                case 14:
                    System.out.println("Enter the user ID");
                    Scanner reader13 = new Scanner(System.in);  // Reading from System.in
                    int id12 = reader13.nextInt();
                    System.out.println("\n1-Public\n2-Student\n3-Premium\nWhat type of subscription do you want?(Type the number)");
                    Scanner reader14 = new Scanner(System.in);  // Reading from System.in
                    int type = reader13.nextInt();
                    if(type==1 || type==2 || type==3) {
                        main.changeSubscription(id12, type);
                    }
                    else{
                        System.out.println("Invalid choice.");
                    }
            }


        }
    }

}
