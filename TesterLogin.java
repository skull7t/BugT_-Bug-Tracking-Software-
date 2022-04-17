import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TesterLogin extends JFrame {
    private JLabel icon,username,password,managerlog,name;
    private JTextField usernametxt;
    private JPasswordField passwordtxt;
    private JButton login;


    void send_data(String username){
        TestrDashboard td = new TestrDashboard();
        sqlcon con = new sqlcon();
        PreparedStatement ps;
        ResultSet rs;
       // String str = "select project_name,name,username from developers where username ='"+username+"'" ;
        String str = "select project_name,name,username from devtesters where username ='"+username+"'" ;

        try {
            ps = con.c.prepareStatement(str);
            rs = ps.executeQuery();

            //ResultSetMetaData rsmd = rs.getMetaData();
            String pn,nm,un;
            while(rs.next()){
                pn=rs.getString(1);
                nm=rs.getString(2);
                un=rs.getString(3);
                System.out.println(pn);
                System.out.println(nm);
                System.out.println(un);
                td.get_data_dashboard(pn,nm,un);
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
            //String q  = "select * from developers where username = '"+username+"' and password = '"+password+"' and catg='tester' and project_name is not null";
            String q  = "select * from devtesters where username = '"+username+"' and password = '"+password+"' and catg='tester' and project_name is not null";
            ResultSet rs = con.s.executeQuery(q);
            if(rs.next()){
                dispose();
                JOptionPane.showMessageDialog(null, "Logged in Successfully");
                send_data(username);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }




    TesterLogin(){
        setTitle("Tester's Login");
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
        //usernametxt.setBorder(BorderFactory.createLineBorder(Color.decode("#1671dc")));
        usernametxt.setBounds(170,140,150,25);
        add(usernametxt);

        passwordtxt = new JPasswordField();
        passwordtxt.setFont(new Font("Raleway", Font.BOLD, 14));
        passwordtxt.setBounds(170,192,150,25);
        add(passwordtxt);


        name = new JLabel("BugT");
        name.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 24));
        //name.setForeground(Color.WHITE);
        name.setBounds(256,10,150,100);
        add(name);

        managerlog = new JLabel("Tester's Login");
        managerlog.setFont(new Font("Clarendon Lt Bt", Font.PLAIN, 14));
        managerlog.setBounds(320,60,150,100);
        //managerlog.setForeground(Color.WHITE);
        add(managerlog);

        login = new JButton("Login");
        login.setBounds(200,240,80,25);
        login.setOpaque(false);
        login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //login.setForeground(Color.WHITE);
        //login.setForeground(new Color(43,76,188));//Provide the r g b values
        login.setContentAreaFilled(false);
        // login.setBorder(new LineBorder(Color.WHITE,2));
        add(login);


        setLayout(null);
        setSize(481,329);
        setVisible(true);
        setResizable(false);
        //getContentPane().setBackground(Color.decode("#0099ff"));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check_empty();
            }
        });



    }

    public static void main(String[] args) {
        new  TesterLogin();
    }
}
