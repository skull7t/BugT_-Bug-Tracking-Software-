import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerLogin extends JFrame {
    private JLabel icon,username,password,managerlog,name;
    private JTextField usernametxt;
    private JPasswordField passwordtxt;
    private JButton login;


    void send_data_managerlogin(String uname){
       ManagerDashboard md = new ManagerDashboard();
        sqlcon con = new sqlcon();
        PreparedStatement ps;
        ResultSet rs;
       // String str = "select name from MangerRegiV3 where username ='"+uname+"'" ;
        String str = "select name,username from manager where username ='"+uname+"'" ;

        try {
            ps = con.c.prepareStatement(str);
            rs = ps.executeQuery();
            String nm,un;
            while(rs.next()){
                nm=rs.getString(1);
                un=rs.getString(2);
                System.out.println(nm);
                md.get_data_managerDashboard(nm,un);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    void check_empty(){
        if(usernametxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else if(passwordtxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else {
            check_login();
        }
    }
    void check_login(){
        try {
            sqlcon con = new sqlcon();
            String username,password;
            username=usernametxt.getText();
            password=passwordtxt.getText();
            System.out.println(password);
            //String q  = "select * from MangerRegiV3 where username = '"+username+"' and nums = '"+password+"'";
            String q  = "select * from manager where username = '"+username+"' and password = '"+password+"'";
            ResultSet rs = con.s.executeQuery(q);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Logged in Successfully");
                dispose();
                send_data_managerlogin(username);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

        ManagerLogin(){
        setTitle("Manager's Login");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/icons8-bug-64.png"));
        Image i2 = i1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        icon = new JLabel(i3);
        icon.setBounds(200, 20, 60, 60);
        add(icon);

        ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("icon/icons8-user-25.png"));
        Image j2 = j1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon j3 = new ImageIcon(j2);
        username = new JLabel(j3);
        username.setBounds(120, 130, 45, 40);
        add(username);


        ImageIcon k1 = new ImageIcon(ClassLoader.getSystemResource("icon/icons8-lock-25.png"));
        Image k2 = k1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon k3 = new ImageIcon(k2);
        password = new JLabel(k3);
        password.setBounds(120, 180, 45, 40);
        add(password);


        usernametxt = new JTextField();
        usernametxt.setFont(new Font("Raleway", Font.BOLD, 14));
        usernametxt.setBounds(170,140,150,25);
        add(usernametxt);

        passwordtxt = new JPasswordField();
        passwordtxt.setFont(new Font("Raleway", Font.BOLD, 14));
        passwordtxt.setBounds(170,192,150,25);
        add(passwordtxt);


        name = new JLabel("BugT");
        name.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 24));
        name.setBounds(256,10,150,100);
        add(name);

        managerlog = new JLabel("Manager's Login");
        managerlog.setFont(new Font("Clarendon Lt Bt", Font.PLAIN, 14));
        managerlog.setBounds(320,60,150,100);
        add(managerlog);

        login = new JButton("Login");
        login.setBounds(200,240,80,25);
        login.setOpaque(false);
        login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        login.setContentAreaFilled(false);
        add(login);


        setLayout(null);
        setSize(481,329);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check_empty();
            }
        });

    }

    public static void main(String[] args) {
        new ManagerLogin();

    }


}
