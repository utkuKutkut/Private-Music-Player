import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class main {



    public static <musicplayer> void main(String[] args) throws NoSuchAlgorithmException, IOException, ClassNotFoundException {


        File myObj = new File("Music_Player.txt");

            if (myObj.createNewFile()) {
                String msg = "No registered file has been found. New session is starting ...\nFile created: " + myObj.getName();
                musicPlayer main2=new musicPlayer();
                JOptionPane optionPane = new JOptionPane();
                optionPane.setMessage(msg);
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog(null, "INFO");
                dialog.setVisible(true);
                System.out.println("File created: " + myObj.getName());



                FileOutputStream fileOut = null;
                try {
                    String filepath= "Music_Player.txt";
                    fileOut = new FileOutputStream(filepath);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                ObjectOutputStream objectOut = null;
                try {
                    objectOut = new ObjectOutputStream(fileOut);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    objectOut.writeObject(main2);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    objectOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }else{
                String msg = "Registered file found: " + myObj.getName()+"\n Reading the specified file ...";
                musicPlayer main2=new musicPlayer();
                JOptionPane optionPane = new JOptionPane();
                optionPane.setMessage(msg);
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog(null, "INFO");
                dialog.setVisible(true);
            }




            String filepath = "Music_Player.txt";
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            musicPlayer main = (musicPlayer) objectIn.readObject();










        JFrame schema = new JFrame();
        schema.setTitle("Welcome to Music Player!");
        schema.setSize(800, 800);
        schema.setResizable(false);
        schema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        schema.add(panel);


        JTextArea textArea = new JTextArea();
        textArea.setBounds(300, 50, 100, 250);
        JButton button = new JButton("Click here to add new user !");
        button.setBounds(70, 50, 250, 35);
        JButton button2 = new JButton("Click here to delete a user !");
        button2.setBounds(70, 100, 250, 35);
        JButton button3 = new JButton("Click here to get user details !");
        button3.setBounds(70, 150, 250, 35);
        JButton button4 = new JButton("Click here to add a new song !");
        button4.setBounds(70, 200, 250, 35);
        JButton button5 = new JButton("Click here to delete a song !");
        button5.setBounds(70, 250, 250, 35);
        JButton button6 = new JButton("Click here to add a new playlist !");
        button6.setBounds(70, 300, 250, 35);
        JButton button7 = new JButton("Click here to add song to a playlist !");
        button7.setBounds(70, 350, 250, 35);
        JButton button8 = new JButton("Click here to get playlist details !");
        button8.setBounds(70, 400, 250, 35);
        JButton button9 = new JButton("Click here to delete a playlist !");
        button9.setBounds(70, 450, 250, 35);
        JButton button10 = new JButton("Click here to display all songs !");
        button10.setBounds(400, 50, 250, 35);
        JButton button11 = new JButton("Click here to display all users !");
        button11.setBounds(400, 100, 250, 35);
        JButton button12 = new JButton("Click here to follow a person !");
        button12.setBounds(400, 150, 250, 35);
        JButton button13 = new JButton("Click here to list all followers !");
        button13.setBounds(400, 200, 250, 35);
        JButton button14 = new JButton("Click here to change subscription type !");
        button14.setBounds(400, 250, 270, 35);

        JButton button15 = new JButton("Save your changes!");
        button15.setBounds(500, 600, 200, 35);
        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(button10);
        panel.add(button11);
        panel.add(button12);
        panel.add(button13);
        panel.add(button14);
        panel.add(button15);

        JLabel label = new JLabel("Welcome to Music Player App !");


        label.setBounds(270, 1, 400, 35);

        panel.add(label);

        JMenuBar menubar = new JMenuBar();
        schema.setJMenuBar(menubar);


        JMenu help = new JMenu("Help");
        JMenuItem item = new JMenuItem("About Music Player?");
        help.add(item);

        menubar.add(help);
        JMenu exit = new JMenu("Exit");
        menubar.add(exit);

        JTable table = new JTable();


        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                main.addUser();
                schema.add(textArea);
                textArea.append("\nNew user added!");
                panel.add(textArea);

                JScrollPane scroll = new JScrollPane(textArea);
                scroll.setBounds(50, 500, 400, 200);

                panel.add(scroll);

            /*
            FileWriter fw = null;
            try {
                fw = new FileWriter("temp.txt",true);
            } catch (IOException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }


            try {
                fw.write("New User Added to the system !");
                fw.write(System.lineSeparator()) ;
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }


            try {
                fw.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

*/
            }
        });

        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String num1;
                int number1;
                num1 = JOptionPane.showInputDialog("Enter the user ID");
                number1 = Integer.parseInt(num1);


                if (main.deleteUser(number1) == -1) {
                    schema.add(textArea);
                    textArea.append("\nUser couldn't found. Please enter the correct ID !");
                    panel.add(textArea);
                } else {
                    schema.add(textArea);
                    textArea.append("\nUser deleted!");
                    panel.add(textArea);
                }

                JScrollPane scroll = new JScrollPane(textArea);
                scroll.setBounds(50, 500, 400, 200);
                panel.add(scroll);

            /*
            FileWriter fw = null;
            try {
                fw = new FileWriter("temp.txt",true);
            } catch (IOException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }


            try {
                fw.write("User has been deleted !!");
                fw.write(System.lineSeparator()) ;
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }


            try {
                fw.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

*/
            }
        });


        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String num1;
                int number1;
                num1 = JOptionPane.showInputDialog("Enter the user ID");
                number1 = Integer.parseInt(num1);

                String msg;
                msg = main.userDetails(number1);
                JOptionPane optionPane = new JOptionPane();
                optionPane.setMessage(msg);
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog(null, "User details");
                dialog.setVisible(true);

            }


        });


        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                main.addSong();
                schema.add(textArea);
                textArea.append("\nNew song added!");
                panel.add(textArea);

                JScrollPane scroll = new JScrollPane(textArea);
                scroll.setBounds(50, 500, 400, 200);

                panel.add(scroll);

            }
        });


        button5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String num1;
                int number1;
                num1 = JOptionPane.showInputDialog("Enter the song ID");
                number1 = Integer.parseInt(num1);


                if (main.deleteSong(number1) == -1) {
                    schema.add(textArea);
                    textArea.append("\nSong couldn't found. Please enter the correct ID !");
                    panel.add(textArea);
                } else {
                    schema.add(textArea);
                    textArea.append("\nSong deleted!");
                    panel.add(textArea);
                }

                JScrollPane scroll = new JScrollPane(textArea);
                scroll.setBounds(50, 500, 400, 200);
                panel.add(scroll);

            }
        });


        button6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String num1;
                int number1;
                num1 = JOptionPane.showInputDialog("Enter the user ID");
                number1 = Integer.parseInt(num1);

                if (main.addPlaylistUser(number1) == -1) {
                    schema.add(textArea);
                    textArea.append("\nID is not valid!");
                    panel.add(textArea);
                } else {
                    schema.add(textArea);
                    textArea.append("\nPlaylist added!");
                    panel.add(textArea);
                }

                JScrollPane scroll = new JScrollPane(textArea);
                scroll.setBounds(50, 500, 400, 200);
                panel.add(scroll);

            }
        });


        button7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String num1, num2;
                int songID, playID;

                num1 = JOptionPane.showInputDialog("Please enter the song ID");
                songID = Integer.parseInt(num1);
                num2 = JOptionPane.showInputDialog("Please enter the playlist ID");
                playID = Integer.parseInt(num2);

                if (main.addSongToPlaylist(songID, playID) == -1) {
                    schema.add(textArea);
                    textArea.append("\nInvalid input! Try again...");
                    panel.add(textArea);
                } else {
                    schema.add(textArea);
                    textArea.append("\nSong added to playlist successfully!");
                    panel.add(textArea);
                }
                JScrollPane scroll = new JScrollPane(textArea);
                scroll.setBounds(50, 500, 400, 200);

                panel.add(scroll);
            }
        });


        button8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String num1;
                int number1;
                num1 = JOptionPane.showInputDialog("Enter the playlist ID");
                number1 = Integer.parseInt(num1);

                String msg;
                msg = main.playlistDetails(number1);
                JOptionPane optionPane = new JOptionPane();
                optionPane.setMessage(msg);
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog(null, "Playlist details");
                dialog.setVisible(true);

            }
        });


        button9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String num1;
                int number1;
                num1 = JOptionPane.showInputDialog("Enter the playlist ID");
                number1 = Integer.parseInt(num1);


                if (main.deletePlaylist(number1) == -1) {
                    schema.add(textArea);
                    textArea.append("\nPlaylist couldn't found. Please enter the correct ID !");
                    panel.add(textArea);
                } else {
                    schema.add(textArea);
                    textArea.append("\nPlaylist deleted!");
                    panel.add(textArea);
                }

                JScrollPane scroll = new JScrollPane(textArea);
                scroll.setBounds(50, 500, 400, 200);
                panel.add(scroll);

            }
        });


        //display all songs
        button10.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String msg;
                msg = main.printAllSongs();
                JOptionPane optionPane = new JOptionPane();
                optionPane.setMessage(msg);
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog(null, "All songs");
                dialog.setVisible(true);
            }
        });

        //display all users
        button11.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String msg;
                msg = main.printAllUsers();
                JOptionPane optionPane = new JOptionPane();
                optionPane.setMessage(msg);
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog(null, "All users");
                dialog.setVisible(true);
            }
        });


        button12.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String num1, num2;
                int userID, followID;

                num1 = JOptionPane.showInputDialog("Please enter the user ID");
                userID = Integer.parseInt(num1);
                num2 = JOptionPane.showInputDialog("Please enter the ID of user which you want to follow");
                followID = Integer.parseInt(num2);

                if (main.followPerson(userID, followID) == -1) {
                    schema.add(textArea);
                    textArea.append("\nInvalid input! Try again...");
                    panel.add(textArea);
                } else {
                    schema.add(textArea);
                    textArea.append("\nSuccess.");
                    panel.add(textArea);
                }
                JScrollPane scroll = new JScrollPane(textArea);
                scroll.setBounds(50, 500, 400, 200);

                panel.add(scroll);
            }
        });


        button13.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String msg;
                String num1;
                int userID;

                num1 = JOptionPane.showInputDialog("Please enter the user ID");
                userID = Integer.parseInt(num1);

                msg = main.printFollowers(userID);
                JOptionPane optionPane = new JOptionPane();
                optionPane.setMessage(msg);
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog(null, "All followers");
                dialog.setVisible(true);
            }
        });


        button14.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String num1, num2, num3, sname, saddress, wname, waddress, card, msg = "";
                int userID, type, sID;
                double cNum;

                num1 = JOptionPane.showInputDialog("Please enter the user ID");
                userID = Integer.parseInt(num1);
                num2 = JOptionPane.showInputDialog("\n1-Public\n2-Student\n3-Premium\nWhat type of subscription do you want?(Type the number)");
                type = Integer.parseInt(num2);
                if (type == 1) {
                    msg = main.subscribePublic(userID);
                    JOptionPane optionPane = new JOptionPane();
                    optionPane.setMessage(msg);
                    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog(null, "INFO");
                    dialog.setVisible(true);
                } else if (type == 2) {
                    sname = JOptionPane.showInputDialog("Please enter your school name");
                    num3 = JOptionPane.showInputDialog("Please enter your school ID");
                    sID = Integer.parseInt(num3);
                    saddress = JOptionPane.showInputDialog("Please enter the school address");
                    msg = main.subscribeStudent(userID, sname, sID, saddress);
                    JOptionPane optionPane = new JOptionPane();
                    optionPane.setMessage(msg);
                    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog(null, "INFO");
                    dialog.setVisible(true);
                } else if (type == 3) {
                    wname = JOptionPane.showInputDialog("Please enter your work organization name");
                    waddress = JOptionPane.showInputDialog("Please enter your work organization address");
                    card = JOptionPane.showInputDialog("In order to do payment, please provide your credit card number:");
                    cNum = Double.parseDouble(card);
                    msg = main.subscribePremium(userID, wname, waddress, cNum);
                    JOptionPane optionPane = new JOptionPane();
                    optionPane.setMessage(msg);
                    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog(null, "INFO");
                    dialog.setVisible(true);
                } else {
                    msg += "Invalid choice. Type should be 1,2 or 3!";
                    JOptionPane optionPane = new JOptionPane();
                    optionPane.setMessage(msg);
                    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog(null, "ERROR");
                    dialog.setVisible(true);
                }
            }


        });

        // save file
        button15.addActionListener(new ActionListener() {
            private String filepath = "";

            public void actionPerformed(ActionEvent e) {

                File myObj = new File("Music_Player.txt");
                try {
                    if (myObj.createNewFile()) {
                        String msg = "Your file created: " + myObj.getName();
                        JOptionPane optionPane = new JOptionPane();
                        optionPane.setMessage(msg);
                        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                        JDialog dialog = optionPane.createDialog(null, "INFO");
                        dialog.setVisible(true);
                        System.out.println("File created: " + myObj.getName());
                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


                FileOutputStream fileOut = null;
                try {
                    filepath += "Music_Player.txt";
                    fileOut = new FileOutputStream(filepath);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                ObjectOutputStream objectOut = null;
                try {
                    objectOut = new ObjectOutputStream(fileOut);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    objectOut.writeObject(main);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    objectOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                String msg = "Your changes has been saved to file: " + myObj.getName();
                JOptionPane optionPane = new JOptionPane();
                optionPane.setMessage(msg);
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog(null, "INFO");
                dialog.setVisible(true);


            }
        });


        schema.setVisible(true);
        //end of main !!
    }

        // this part controls if application got modified by someone else !!!!! //
    public static byte[] createChecksum(String filename) throws IOException, NoSuchAlgorithmException {
        InputStream fis =  new FileInputStream(filename);

        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("MD5");
        int numRead;

        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);

        fis.close();
        return complete.digest();
    }


    public static String getMD5Checksum(String filename) throws Exception {
        byte[] b = createChecksum(filename);
        String result = "";

        for (int i=0; i < b.length; i++) {
            result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }













}
