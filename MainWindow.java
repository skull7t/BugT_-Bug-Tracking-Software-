import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    JLabel icon;
    JLabel name;
    JComboBox cb;
    JLabel activity;
    JLabel about;
    JLabel feat;
    JLabel pricing;
    JLabel cp;
    JLabel mainimg;
    int check;
    String d[]={"Manager's Registration","Teamleader's Registration","Developer's Registration","Tester's Registration","Manger's Login","TeamLeader's Login","Developer's Login","Tester's Login"};

    void forward(){
        if(check==0){
            new ManagerRegi();
        }
        else if(check==1){
            new LeadrRegi();
        }
        else if(check==2){
            new DeveloperRegi();
        }
        else if(check==3){
            new TesterRegi();
        }
        else if(check==4){
            new ManagerLogin();
        }
        else if(check==5){
            new leaderLogin();
        }
        else if(check==6){
            new DeveloperLogin();
        }
        else if(check==7){
            new TesterLogin();
        }
    }


    MainWindow(){
        setTitle("BugT");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/icons8-bug-64.png"));
        Image i2 = i1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        icon = new JLabel(i3);
        icon.setBounds(260, 10, 60, 60);
        add(icon);


        name = new JLabel("BugT");
        name.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 24));
        name.setBounds(318,1,150,100);
        add(name);

        about = new JLabel("About");
        about.setBounds(30,34,60,30);
        about.setFont(new Font("Raleway", Font.BOLD, 12));
        about.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(about);

        feat = new JLabel("Features");
        feat.setBounds(100,34,60,30);
        feat.setFont(new Font("Raleway", Font.BOLD, 12));
        feat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(feat);

        pricing = new JLabel("Pricing");
        pricing.setBounds(188,34,60,30);
        pricing.setFont(new Font("Raleway", Font.BOLD, 12));
        pricing.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(pricing);



        activity = new JLabel("Activity");
        activity.setBounds(425,34,60,30);
        activity.setFont(new Font("Raleway", Font.BOLD, 12));
        add(activity);


        cb= new JComboBox(d);
        cb.setBounds(470,40,130,20);
        cb.setFont(new Font("Raleway", Font.PLAIN, 11));
        cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(cb);


        ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("icon/main.png"));
        Image j2 = j1.getImage().getScaledInstance(618, 289, Image.SCALE_DEFAULT);
        ImageIcon j3 = new ImageIcon(j2);
        mainimg = new JLabel(j3);
        mainimg.setBounds(0, 77, 618, 289);
        add(mainimg);





        cp = new JLabel("Copyright ©2022 BugT.Rohit_Patil.All Right Reserved.");
        cp.setBounds(135,380,600,30);
        cp.setFont(new Font("Raleway", Font.PLAIN, 12));
        add(cp);


        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check = cb.getSelectedIndex();
                System.out.println(check);
                forward();
            }
        });





        setLayout(null);
        setSize(618,460);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
