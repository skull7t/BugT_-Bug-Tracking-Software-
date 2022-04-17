import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Arrays;

public class LeadrRegi extends JFrame {
    private JLabel lbl,name,uc,un,uid,p,cp,n1,n2;
    private JTextField nmt,uct,unt,uidt;
    private JPasswordField pp,cpp;
    private JButton register;


    void check_usern(){
        try{
            sqlcon con = new sqlcon();
            String username;
            username=unt.getText();
            String q  = "select * from leaders where username = '"+username+"'";
          //  String q  = "select * from leaders where username = '"+username+"'";
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

    void storeData(){
        setTitle("leader's Registration");
        String name,emp_id,username,userid,password;
        name= nmt.getText();
        emp_id= uct.getText();
        username=unt.getText();
        userid=uidt.getText();
        password=pp.getText();
        try {
            sqlcon con = new sqlcon();
            //String q1 = "insert into leaders values(null,null,'"+name+"','"+emp_id+"','"+username+"','"+userid+"','"+password+"',null);";
            String q1 = "insert into leaders values(null,null,'"+name+"','"+emp_id+"','"+username+"','"+userid+"','"+password+"');";
            con.s.executeUpdate(q1);
            System.out.println("Data inserted");
            JOptionPane.showMessageDialog(null, "You'll be able to login after the Manager approves your request");
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
        } else if (uct.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete all details");
        } else if (unt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete all details");
        } else if (uidt.getText().equals("")) {
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
    LeadrRegi(){
        setTitle("Leader's Registration");
        lbl = new JLabel("Leader's Registration");
        lbl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
        lbl.setBounds(40,1,520,80);
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



        uc = new JLabel("Employee Code");
        uc.setFont(new Font("Segoe UI", Font.BOLD,11));
        uc.setBounds(265,100,100,30);
        add(uc);

        uct = new JTextField();
        uct.setFont(new Font("Raleway", Font.BOLD, 14));
        uct.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        uct.setBounds(380,105,150,20);
        add(uct);


        un = new JLabel("Username");
        un.setFont(new Font("Segoe UI", Font.BOLD,11));
        un.setBounds(28,150,100,30);
        add(un);

        unt = new JTextField();
        unt.setFont(new Font("Raleway", Font.BOLD, 14));
        unt.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        unt.setBounds(80,155,150,20);
        add(unt);

        uid = new JLabel("User Id");
        uid.setFont(new Font("Segoe UI", Font.BOLD,11));
        uid.setBounds(265,150,100,30);
        add(uid);

        uidt = new JTextField();
        uidt.setFont(new Font("Raleway", Font.BOLD, 14));
        uidt.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        uidt.setBounds(380,155,150,20);
        add(uidt);


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


        n1 = new JLabel("*Employee code provided by the employer.");
        n1.setFont(new Font("Segoe UI", Font.PLAIN,14));
        n1.setBounds(28,300,300,30);
        add(n1);

        n2 = new JLabel("*UserID provided by the company.");
        n2.setFont(new Font("Segoe UI", Font.PLAIN,14));
        n2.setBounds(28,335,300,30);
        add(n2);



        register = new JButton("Register");
        register.setBounds(230,450,100,25);
        register.setOpaque(false);
        register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        register.setContentAreaFilled(false);
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
        new LeadrRegi();
    }
}
