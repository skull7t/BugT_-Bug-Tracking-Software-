import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Arrays;

public class DeveloperRegi extends JFrame {
    JLabel lbl,name,uc,un,uid,p,cp,n1,n2,n3,ei;
    JTextField nmt,uct,unt,uidt,eit;
    JPasswordField pp,cpp;
    JButton register;
    JComboBox devl;
    String d[]={"Web Development","Software Development","Mobile App Development","Database Management"};
    void storeData(){
        String name,emp_ID,username,devel,password;
        name= nmt.getText();
        emp_ID= eit.getText();
        username=unt.getText();
        devel=devl.getSelectedItem().toString();
        password=pp.getText();
        try {
            sqlcon con = new sqlcon();
            //String q1 = "insert into developers values(null,'developer',null,'"+name+"','"+emp_ID+"','"+username+"','"+devel+"','"+password+"')";
            String q1 = "insert into devtesters values(null,'developer',null,'"+name+"','"+emp_ID+"','"+username+"','"+devel+"','"+password+"')";
            con.s.executeUpdate(q1);
            System.out.println("Data inserted");
            JOptionPane.showMessageDialog(null, "You'll be able to login only after the Leader approves your request");
            dispose();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    void check_password(){
        if((pp.getPassword().length<8)){
            JOptionPane.showMessageDialog(null, "Password length should be equal or greater than 8 Characters");
        }
        else if(!(Arrays.equals(pp.getPassword(),cpp.getPassword()))){
            JOptionPane.showMessageDialog(null, "Password and Confirm Password Doesn't Match");
        }
        else {
            storeData();
        }
    }
    void check_empty() {
        if (nmt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete all details");
        } else if (eit.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete all details");
        } else if (unt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else if (pp.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete all details");
        } else if (cpp.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete all details");
        } else {
            check_usern();
        }
    }
    void check_usern(){
        try{
            sqlcon con = new sqlcon();
            String username;
            username=unt.getText();
           // String q  = "select * from developers where username = '"+username+"'";
            String q  = "select * from devtesters where username = '"+username+"'";

            ResultSet rs = con.s.executeQuery(q);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Username already exists");
            }else{
                check_password();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }



    DeveloperRegi(){
        setTitle("Developer's Registration");
        lbl = new JLabel("Developer's Registration");
        lbl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
        lbl.setBounds(5,1,600,80);
        add(lbl);

        lbl = new JLabel("Name");
        lbl.setFont(new Font("Segoe UI", Font.BOLD,11));
        lbl.setBounds(28,100,50,30);
        add(lbl);

        nmt = new JTextField();
        nmt.setFont(new Font("Raleway", Font.BOLD, 14));
        nmt.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        nmt.setBounds(80,105,150,20);
        add(nmt);



        ei = new JLabel("Employee ID");
        ei.setFont(new Font("Segoe UI", Font.BOLD,11));
        ei.setBounds(265,100,100,30);
        add(ei);

        eit = new JTextField();
        eit.setFont(new Font("Raleway", Font.BOLD, 14));
        eit.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        eit.setBounds(380,105,150,20);
        add(eit);


        un = new JLabel("Username");
        un.setFont(new Font("Segoe UI", Font.BOLD,11));
        un.setBounds(28,150,100,30);
        add(un);

        unt = new JTextField();
        unt.setFont(new Font("Raleway", Font.BOLD, 14));
        unt.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        unt.setBounds(80,155,150,20);
        add(unt);

        uid = new JLabel("Development");
        uid.setFont(new Font("Segoe UI", Font.BOLD,11));
        uid.setBounds(265,150,100,30);
        add(uid);


        devl= new JComboBox(d);
        devl.setBounds(380,155,130,20);
        devl.setFont(new Font("Raleway", Font.PLAIN, 11));
        devl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(devl);



        p = new JLabel("Password");
        p.setFont(new Font("Segoe UI", Font.BOLD,11));
        p.setBounds(28,200,100,30);
        add(p);

        pp = new JPasswordField();
        pp.setFont(new Font("Raleway", Font.BOLD, 14));
        pp.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        pp.setBounds(80,205,150,20);
        add(pp);

        cp = new JLabel("Confirm Password");
        cp.setFont(new Font("Segoe UI", Font.BOLD,11));
        cp.setBounds(265,200,100,30);
        add(cp);

        cpp = new JPasswordField();
        cpp.setFont(new Font("Raleway", Font.BOLD, 14));
        cpp.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        cpp.setBounds(380,205,150,20);
        add(cpp);


        n1 = new JLabel("*Username should consist Employee ID.");
        n1.setFont(new Font("Segoe UI", Font.PLAIN,14));
        n1.setBounds(28,300,300,30);
        add(n1);

        n2 = new JLabel("*Employee ID provided by the company.");
        n2.setFont(new Font("Segoe UI", Font.PLAIN,14));
        n2.setBounds(28,335,300,30);
        add(n2);

        n3 = new JLabel("*Remember Username for Login");
        n3.setFont(new Font("Segoe UI", Font.PLAIN,14));
        n3.setBounds(28,370,300,30);
        add(n3);



        register = new JButton("Register");
        register.setBounds(230,450,100,25);
        register.setOpaque(false);
        register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //register.setForeground(Color.WHITE);
        //register.setForeground(new Color(43,76,188));//Provide the r g b values
        register.setContentAreaFilled(false);
        //register.setBorder(new LineBorder(Color.WHITE,2));
        add(register);


        setLayout(null);
        setSize(576,541);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check_empty();
            }
        });

    }

    public static void main(String[] args) {
        new  DeveloperRegi();
    }
}
