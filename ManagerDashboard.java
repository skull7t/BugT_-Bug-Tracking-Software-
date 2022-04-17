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

public class ManagerDashboard extends JFrame {
    JLabel icon,iname,mname,cp_icon,cp,al_icon,al,lr_icon,lr,pp_icon,pp,tlla,iu;
    JButton logout,refresh;
    JScrollPane sp,sp2;
    JTable tb,tb2;
    String[] columnNames = {"Name", "Message"};
    String[] columnNames2 = {"Name", "Message"};
    String  manager_name,user_name;


    void get_data_managerDashboard(String name,String un){
        mname.setText(name.toUpperCase(Locale.ROOT));
        manager_name = name;
        user_name = un;
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






    ManagerDashboard(){
        setTitle("Manager's Dashboard");
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

        mname = new JLabel("Manager's Name");
        mname.setFont(new Font("YU Gothic UI Semibold", Font.PLAIN, 18));
        mname.setBounds(770,0,170,45);
        add(mname);

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
        cp_icon = new JLabel(j3);
        cp_icon.setBounds(50, 100, 60, 60);
        cp_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(cp_icon);

        cp = new JLabel("Create Message");
        cp.setFont(new Font("YU Gothic UI Semibold", Font.PLAIN, 18));
        cp.setBounds(110,106,170,45);
        cp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(cp);


        ImageIcon k1 = new ImageIcon(ClassLoader.getSystemResource("icon/icons8-add-50.png"));
        Image k2 = k1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon k3 = new ImageIcon(k2);
        al_icon = new JLabel(k3);
        al_icon.setBounds(270, 100, 60, 60);
        al_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(al_icon);

        al = new JLabel("Create Project");
        al.setFont(new Font("YU Gothic UI Semibold", Font.PLAIN, 18));
        al.setBounds(330,106,170,45);
        al.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(al);


        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon/icons8-delete-trash-50.png"));
        Image l2 = l1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        lr_icon = new JLabel(l3);
        lr_icon.setBounds(470, 100, 60, 60);
        lr_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(lr_icon);

        lr = new JLabel("Delete Projects");
        lr.setFont(new Font("YU Gothic UI Semibold", Font.PLAIN, 18));
        lr.setBounds(525,106,170,45);
        lr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(lr);



        ImageIcon m1 = new ImageIcon(ClassLoader.getSystemResource("icon/icons8-project-50.png"));
        Image m2 = m1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon m3 = new ImageIcon(m2);
        pp_icon = new JLabel(m3);
        pp_icon.setBounds(680, 100, 60, 60);
        pp_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(pp_icon);

        pp = new JLabel("Project Performance");
        pp.setFont(new Font("YU Gothic UI Semibold", Font.PLAIN, 18));
        pp.setBounds(742,106,170,45);
        pp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(pp);


        tlla = new JLabel("Broadcast Messages");
        tlla.setFont(new Font("YU Gothic UI Semibold", Font.PLAIN, 18));
        tlla.setBounds(120,200,170,45);
        add(tlla);

        iu = new JLabel("Personal Messages");
        iu.setFont(new Font("YU Gothic UI Semibold", Font.PLAIN, 18));
        iu.setBounds(640,200,170,45);
        add(iu);

        set_broad_table();

        refresh = new JButton("Refresh");
        refresh.setBounds(420,380,80,25);
        refresh.setOpaque(false);
        refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        refresh.setContentAreaFilled(false);
        add(refresh);


        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set_broad_table();
                set_private_table(user_name);
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


        cp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CreateMessage cm = new CreateMessage();
                cm.get_data_message(manager_name);
            }
        });
        cp_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CreateMessage cm = new CreateMessage();
                cm.get_data_message(manager_name);
            }
        });
        al.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new createProject();
            }
        });
        al_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new createProject();
            }
        });
        lr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new deleteProjects();
            }
        });
        lr_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new deleteProjects();
            }
        });
        pp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ProjectPerform pp = new ProjectPerform();
                pp.get_data_pp(user_name);
            }
        });
        pp_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ProjectPerform pp = new ProjectPerform();
                pp.get_data_pp(user_name);
            }
        });
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null, "Logged Out");
            }
        });
    }

    public static void main(String[] args) {
            new ManagerDashboard();
    }
}
