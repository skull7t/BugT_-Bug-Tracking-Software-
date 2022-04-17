import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;

public class TestrDashboard extends JFrame {
    JLabel icon,iname,name,tlla,iu,cm,ab,mb,pi,cm_icon,ab_icon,mb_icon,pi_icon;
    JButton logout,refresh;
    JScrollPane sp,sp2;
    JTable tb,tb2;
    String[] columnNames = {"Name", "Message"};
    String[] columnNames2 = {"Name", "Message"};
    String projectn,nam,usern;
    void get_data_dashboard(String pn,String nm,String un){
        projectn = pn;
        nam = nm;
        usern = un;
        name.setText(nm.toUpperCase(Locale.ROOT));
        set_private_table(un);

    }


    void set_broad_table(){
        //jSCROLLPANE
        sp = new JScrollPane();
        sp.setBounds(50, 250, 300, 280);
        add(sp);

        //SETTING TABLE
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        tb = new JTable();
        tb.setModel(model);
        sp.setViewportView(tb);

        //Table Data
        sqlcon con = new sqlcon();
        PreparedStatement ps;
        ResultSet rs;
        String str = "select username,message from message where to_username is null;" ;
        try {
            ps = con.c.prepareStatement(str);
            rs = ps.executeQuery();
            String un,msg;
            while(rs.next()){
                un=rs.getString(1);
                msg=rs.getString(2);
                model.addRow(new Object[]{un,msg});

            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    void set_private_table(String usr){
        //jSCROLLPANE
        sp2 = new JScrollPane();
        sp2.setBounds(560, 250, 300, 280);
        add(sp2);

        //SETTING TABLE
        DefaultTableModel model2 = new DefaultTableModel();
        model2.setColumnIdentifiers(columnNames2);
        tb2 = new JTable();
        tb2.setModel(model2);
        sp2.setViewportView(tb2);

        //Table Data
        sqlcon con = new sqlcon();
        PreparedStatement ps;
        ResultSet rs;
        String str = "select username,message from message where to_username = '"+usr+"';" ;
        try {
            ps = con.c.prepareStatement(str);
            rs = ps.executeQuery();
            String un,msg;
            while(rs.next()){
                un=rs.getString(1);
                msg=rs.getString(2);
                System.out.println(msg);
                model2.addRow(new Object[]{un,msg});

            }
        }
        catch (Exception e){
            System.out.println(e);
        }



    }




    TestrDashboard(){
        setTitle("Tester's Dashboard");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/icons8-bug-64.png"));
        Image i2 = i1.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        icon = new JLabel(i3);
        icon.setBounds(400, 10, 60, 60);
        add(icon);

        iname = new JLabel("BugT");
        iname.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
        iname.setBounds(460,1,150,100);
        add(iname);

        name = new JLabel("Manager's Name");
        name.setFont(new Font("YU Gothic UI Semibold", Font.PLAIN, 18));
        name.setBounds(770,0,170,45);
        add(name);

        logout = new JButton("Logout");
        logout.setBounds(780,40,80,25);
        logout.setOpaque(false);
        logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //logout.setForeground(Color.WHITE);
        logout.setContentAreaFilled(false);
        add(logout);

        ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("icon/icons8-create-50.png"));
        Image j2 = j1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon j3 = new ImageIcon(j2);
        cm_icon = new JLabel(j3);
        cm_icon.setBounds(50, 100, 60, 60);
        cm_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(cm_icon);

        cm = new JLabel("Create Message");
        cm.setFont(new Font("YU Gothic UI Semibold", Font.PLAIN, 18));
        cm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cm.setBounds(110,106,170,45);
        add(cm);


        ImageIcon k1 = new ImageIcon(ClassLoader.getSystemResource("icon/icons8-add-50.png"));
        Image k2 = k1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon k3 = new ImageIcon(k2);
        ab_icon = new JLabel(k3);
        ab_icon.setBounds(270, 100, 60, 60);
        ab_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(ab_icon);

        ab = new JLabel("Add Bugs");
        ab.setFont(new Font("YU Gothic UI Semibold", Font.PLAIN, 18));
        ab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ab.setBounds(330,106,170,45);
        add(ab);


        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon/icons8-settings-50.png"));
        Image l2 = l1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        mb_icon = new JLabel(l3);
        mb_icon.setBounds(470, 100, 60, 60);
        mb_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(mb_icon);

        mb = new JLabel("Modify Bugs");
        mb.setFont(new Font("YU Gothic UI Semibold", Font.PLAIN, 18));
        mb.setBounds(525,106,170,45);
        mb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(mb);



        ImageIcon m1 = new ImageIcon(ClassLoader.getSystemResource("icon/icons8-project-50.png"));
        Image m2 = m1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon m3 = new ImageIcon(m2);
        pi_icon = new JLabel(m3);
        pi_icon.setBounds(680, 100, 60, 60);
        pi_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(pi_icon);

        pi = new JLabel("Project info");
        pi.setFont(new Font("YU Gothic UI Semibold", Font.PLAIN, 18));
        pi.setBounds(742,106,170,45);
        pi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(pi);


        tlla = new JLabel("Leader's Last Active");
        tlla.setFont(new Font("YU Gothic UI Semibold", Font.PLAIN, 18));
        tlla.setBounds(120,200,170,45);
        add(tlla);

        iu = new JLabel("Important Updates");
        iu.setFont(new Font("YU Gothic UI Semibold", Font.PLAIN, 18));
        iu.setBounds(640,200,170,45);
        add(iu);



        set_broad_table();
        //jSCROLLPANE
       /* sp = new JScrollPane();
        sp.setBounds(50, 250, 300, 280);
        add(sp);

        //SETTING TABLE
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        tb = new JTable();
        tb.setModel(model);
        sp.setViewportView(tb);




        //jSCROLLPANE
        sp2 = new JScrollPane();
        sp2.setBounds(560, 250, 300, 280);
        add(sp2);

        //SETTING TABLE
        DefaultTableModel model2 = new DefaultTableModel();
        model2.setColumnIdentifiers(columnNames2);
        tb2 = new JTable();
        tb2.setModel(model2);
        sp2.setViewportView(tb2);*/


        refresh = new JButton("Refresh");
        refresh.setBounds(420,380,80,25);
        refresh.setOpaque(false);
        refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //logout.setForeground(Color.WHITE);
        refresh.setContentAreaFilled(false);
        add(refresh);

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set_broad_table();
                set_private_table(usern);
            }
        });



        setLayout(null);
        setSize(950,617);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null, "Logged Out");
            }
        });


        ab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                addBug abg = new addBug();
                abg.get_data_addBug(projectn,usern);
            }
        });
        ab_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                addBug abg = new addBug();
                abg.get_data_addBug(projectn,usern);
            }
        });
        mb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                modifyBug mb =new modifyBug();
                mb.get_data_mb(usern);
            }
        });
        mb_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                modifyBug mb =new modifyBug();
                mb.get_data_mb(usern);
            }
        });

        cm_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CreateMessage cm = new CreateMessage();
                cm.get_data_message(usern);
            }
        });
        cm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CreateMessage cm = new CreateMessage();
                cm.get_data_message(usern);
            }
        });
        pi_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                project_info pin = new project_info();
                pin.get_data_prinfo(projectn);
            }
        });
        pi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                project_info pin = new project_info();
                pin.get_data_prinfo(projectn);
            }
        });


    }

    public static void main(String[] args) {
        new TestrDashboard();
    }
}
