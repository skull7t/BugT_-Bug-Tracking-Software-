import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Arrays;

public class ManagerRegi extends JFrame {
    private JLabel lbl,name,uc,un,uid,cc,sc,p,cp,n1,n2,n3,n4,n5;
    private JTextField nmt,uct,unt,uidt,cct,sct;
    private JPasswordField pp,cpp;
    private JButton register;

    void check_usern(){
        try{
            sqlcon con = new sqlcon();
            String username;
            username=unt.getText();
            String q  = "select * from manager where username = '"+username+"'";
          //  String q  = "select * from manager where username = '"+username+"'";
            ResultSet rs = con.s.executeQuery(q);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Username already exists");
            }else{
                check_Scode();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }




    void storeData(){
        String name,emp_code,username,userid,company,password;
        name= nmt.getText();
        emp_code= uct.getText();
        username=unt.getText();
        userid=uidt.getText();
        company=cct.getText();
        password=pp.getText();
        try {
            sqlcon con = new sqlcon();
           // String q1 = "insert into MangerRegiV3 values('"+name+"','"+emp_code+"','"+username+"','"+userid+"','"+company+"','"+password+"')";
            String q1 = "insert into manager values(null,'"+name+"','"+emp_code+"','"+username+"','"+userid+"','"+company+"','"+password+"')";
            con.s.executeUpdate(q1);
            System.out.println("Data inserted");
            JOptionPane.showMessageDialog(null, "Account Created");
            setVisible(false);
            new ManagerLogin().setVisible(true);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    void check_Scode(){
        if(sct.getText().equals("tcr123")){
            check_password();
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid Secret Code");
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
    void check_empty(){
        if(nmt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else if(uct.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else if(unt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else if(uidt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else if(cct.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else if(sct.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else if(pp.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else if(cpp.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else {
            check_usern();
        }
    }



    ManagerRegi(){
        setTitle("Manager's Registration");
        lbl = new JLabel("Manager's Registration");
        lbl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
        lbl.setBounds(28,1,520,80);
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


        cc = new JLabel("Company Code");
        cc.setFont(new Font("Segoe UI", Font.BOLD,11));
        cc.setBounds(28,200,100,30);
        add(cc);

        cct = new JTextField();
        cct.setFont(new Font("Raleway", Font.BOLD, 14));
        cct.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        cct.setBounds(80,205,150,20);
        add(cct);


        sc = new JLabel("Secret Code");
        sc.setFont(new Font("Segoe UI", Font.BOLD,11));
        sc.setBounds(265,200,100,30);
        add(sc);

        sct = new JTextField();
        sct.setFont(new Font("Raleway", Font.BOLD, 14));
        sct.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        sct.setBounds(380,205,150,20);
        add(sct);



        p = new JLabel("Password");
        p.setFont(new Font("Segoe UI", Font.BOLD,11));
        p.setBounds(28,250,100,30);
        add(p);

        pp = new JPasswordField();
        pp.setFont(new Font("Raleway", Font.BOLD, 14));
        pp.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        pp.setBounds(80,255,150,20);
        add(pp);

        cp = new JLabel("Confirm Password");
        cp.setFont(new Font("Segoe UI", Font.BOLD,11));
        cp.setBounds(265,250,100,30);
        add(cp);

        cpp = new JPasswordField();
        cpp.setFont(new Font("Raleway", Font.BOLD, 14));
        cpp.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        cpp.setBounds(380,255,150,20);
        add(cpp);


        n1 = new JLabel("*Employee code provided by the employer.");
        n1.setFont(new Font("Segoe UI", Font.PLAIN,14));
        n1.setBounds(28,300,300,30);
        add(n1);

        n2 = new JLabel("*UserID provided by the company.");
        n2.setFont(new Font("Segoe UI", Font.PLAIN,14));
        n2.setBounds(28,325,300,30);
        add(n2);

        n3 = new JLabel("*Company code of the company.");
        n3.setFont(new Font("Segoe UI", Font.PLAIN,14));
        n3.setBounds(28,350,300,30);
        add(n3);

        n4 = new JLabel("*Secret code provided by the software for manager's registration.");
        n4.setFont(new Font("Segoe UI", Font.PLAIN,14));
        n4.setBounds(28,375,450,30);
        add(n4);

        n5 = new JLabel("*Remember Username and Password for Login.");
        n5.setFont(new Font("Segoe UI", Font.PLAIN,14));
        n5.setBounds(28,400,450,30);
        add(n5);

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
        new ManagerRegi();
    }
}
