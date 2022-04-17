import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateMessage extends JFrame {
    JLabel lbl,message;
    JTextField messageb,messagep,usern;
    JButton broadcast,send;
    String username;

    void check_empty() {
        if (messageb.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete all details");
        } else {
            broad();
        }
    }
    void check_empty2() {
        if (messagep.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else if (usern.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else{
            send();
        }
    }

    void get_data_message(String userni){
        username = userni;
    }
    void broad(){
        String msg;
        msg = messageb.getText();
        try {
            sqlcon con = new sqlcon();
            String q1 = "insert into message values(null,'"+username+"','"+msg+"',null)";
            con.s.executeUpdate(q1);
            System.out.println("Data inserted");
            JOptionPane.showMessageDialog(null, "Message Sent");
            messageb.setText("");
        }

        catch (Exception e){
            System.out.println(e);
        }

    }
    void send(){
        String msg,touser;
        msg = messagep.getText();
        touser = usern.getText();
        try {
            sqlcon con = new sqlcon();
            String q1 = "insert into message values(null,'"+username+"','"+msg+"','"+touser+"')";
            con.s.executeUpdate(q1);
            System.out.println("Data inserted");
            JOptionPane.showMessageDialog(null, "Message Sent");
            messagep.setText("");
            usern.setText("");
        }

        catch (Exception e){
            System.out.println(e);
        }

    }



    CreateMessage(){
        setTitle("Create Message");
        lbl = new JLabel("Create Message");
        lbl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
        lbl.setBounds(100,1,520,80);
        add(lbl);

        lbl = new JLabel("Broadcast Message");
        lbl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
        lbl.setBounds(150,70,520,80);
        add(lbl);

        message = new JLabel("Message");
        message.setFont(new Font("Segoe UI", Font.BOLD,11));
        message.setBounds(150,150,50,30);
        add(message);

        messageb = new JTextField();
        messageb.setFont(new Font("Raleway", Font.BOLD, 14));
        messageb.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        messageb.setBounds(230,155,150,20);
        add(messageb);

        broadcast = new JButton("Broadcast");
        broadcast.setBounds(230,210,120,25);
        broadcast.setOpaque(false);
        broadcast.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        broadcast.setContentAreaFilled(false);
        add(broadcast);



        lbl = new JLabel("Personal Message");
        lbl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
        lbl.setBounds(150,250,520,80);
        add(lbl);



        message = new JLabel("Message");
        message.setFont(new Font("Segoe UI", Font.BOLD,11));
        message.setBounds(150,330,50,30);
        add(message);

        messagep = new JTextField();
        messagep.setFont(new Font("Raleway", Font.BOLD, 14));
        messagep.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        messagep.setBounds(230,335,150,20);
        add(messagep);

        message = new JLabel("To Username");
        message.setFont(new Font("Segoe UI", Font.BOLD,11));
        message.setBounds(150,380,100,30);
        add(message);

        usern = new JTextField();
        usern.setFont(new Font("Raleway", Font.BOLD, 14));
        usern.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        usern.setBounds(230,385,150,20);
        add(usern);


        send = new JButton("Send");
        send.setBounds(230,440,120,25);
        send.setOpaque(false);
        send.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        send.setContentAreaFilled(false);
        add(send);


        broadcast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check_empty();
            }
        });

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check_empty2();
            }
        });

        setLayout(null);
        setSize(576,541);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args) {
        new CreateMessage();
    }
}
