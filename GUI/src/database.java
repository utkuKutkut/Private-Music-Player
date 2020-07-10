import java.beans.Statement;
import java.sql.*;

public class database {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    String url="jdbc:mysql://localhost:3306/";
    String userName="root";
    //your username and password are different, for sure...
    String password="1234";

    //one should change these variables according to her system. Mysql database is used for the sake of this template
    public database(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con1=DriverManager.getConnection(url,userName,password);
            java.sql.Statement s1= con1.createStatement();
            String s = "CREATE DATABASE IF NOT EXISTS MUSIC";
            s1.executeUpdate(s);

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MUSIC",userName,password);
            System.out.println("Connected!");


            // in this part, tables are being crated.
            PreparedStatement createUser= con.prepareStatement("CREATE TABLE IF NOT EXISTS `MUSIC`.`user` (\r\n" +
                    " `id` int(11) DEFAULT '0',\r\n" +
                    " `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL,\r\n" +
                    " `email` varchar(60) DEFAULT NULL,\r\n" +
                    " PRIMARY KEY (`id`)\r\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='user data';") ;

            createUser.executeUpdate();

            PreparedStatement createSong= con.prepareStatement("CREATE TABLE IF NOT EXISTS `MUSIC`.`song` (\r\n" +
                    " `id` int(11) DEFAULT '0',\r\n" +
                    " `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL,\r\n" +
                    " `genre` varchar(60) DEFAULT NULL,\r\n" +
                    " PRIMARY KEY (`id`)\r\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='song data';") ;

            createSong.executeUpdate();

            PreparedStatement createPlaylist= con.prepareStatement("CREATE TABLE IF NOT EXISTS `MUSIC`.`playlist` (\r\n" +
                    " `id` int(11) DEFAULT '0',\r\n" +
                    " `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL,\r\n" +
                    " `owner` varchar(64) COLLATE utf8_unicode_ci NOT NULL,\r\n" +
                    " PRIMARY KEY (`id`)\r\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='playlist data';") ;

            createPlaylist.executeUpdate();


            // in this part I inserted necessary info //
            //lets add 2 users into the system//
            int id1=1;
            String var1="user1";
            String email1="email1";
            PreparedStatement post=con.prepareStatement("INSERT INTO user (id, name, email) VALUES ('"+id1+"','"+var1+"', '"+email1+"' )");
            post.executeUpdate();

            int id2=2;
            String var2="user2";
            String email2="email2";
            PreparedStatement post2=con.prepareStatement("INSERT INTO user (id, name, email) VALUES ('"+id2+"','"+var2+"', '"+email2+"' )");
            post2.executeUpdate();

            //lets add 2 songs into the system//
            int ids=1;
            String vars="song1";
            String genre="rock";
            PreparedStatement post3=con.prepareStatement("INSERT INTO song (id, name, genre) VALUES ('"+ids+"','"+vars+"', '"+genre+"' )");
            post3.executeUpdate();
            int ids2=2;
            String vars2="song2";
            String genre2="pop";
            PreparedStatement post4=con.prepareStatement("INSERT INTO song (id, name, genre) VALUES ('"+ids2+"','"+vars2+"', '"+genre2+"' )");
            post4.executeUpdate();

            //also, lets add 2 playlists into the system//
            int idp=1;
            String varp="playlist1";
            String owner1="user1";
            PreparedStatement post5=con.prepareStatement("INSERT INTO playlist (id, name, owner) VALUES ('"+idp+"','"+varp+"', '"+owner1+"' )");
            post5.executeUpdate();
            int idp2=2;
            String varp2="playlist2";
            String owner2="user2";
            PreparedStatement post6=con.prepareStatement("INSERT INTO playlist (id, name, owner) VALUES ('"+idp2+"','"+varp2+"', '"+owner2+"' )");
            post6.executeUpdate();

            System.out.println("All tables are updated successfully !!");;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
