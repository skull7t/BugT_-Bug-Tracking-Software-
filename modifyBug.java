import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class modifyBug extends JFrame {
    JLabel lbl;
    JScrollPane sp;
    JTable tb;
    JButton add2;
    JTextField tt,sh,desc ;
    JLabel pn,cn,ds,ty,tl,due,pnt;
    JComboBox sever;
    private DefaultTableModel dt;
    String d[]={"Low","Medium","High","Very High"};
    JButton addb;
    String columnNames[]={"Title","Short_hand","Description","Severity"};
    String tester;

    void get_data_mb(String usn){
        tester=usn;
        table_data(usn);
    }

    void table_data(String usernm){

        //jSCROLLPANE
        sp = new JScrollPane();
        sp.setBounds(2, 80, 550, 150);
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
        String str = "select title,short_hand,description,severity from bugs where tester_name='"+usernm+"';" ;
        try {
            ps = con.c.prepareStatement(str);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            String tt,sh,desc,sev;
            while(rs.next()){
                tt=rs.getString(1);
                sh=rs.getString(2);
                desc=rs.getString(3);
                sev=rs.getString(4);

                model.addRow(new Object[]{tt, sh, desc,sev});

            }

            System.out.println("Total columns : " + rsmd.getColumnCount());
            System.out.println("column name : " + rsmd.getColumnName(1));
            System.out.println("column data type  : " + rsmd.getColumnTypeName(1));
        }
        catch (Exception e){
            System.out.println(e);
        }
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRowIndex= tb.getSelectedRow();
                pnt.setText(model.getValueAt(selectedRowIndex,0).toString());
                sh.setText(model.getValueAt(selectedRowIndex,1).toString());
                desc.setText(model.getValueAt(selectedRowIndex,2).toString());
            }
        });


    }
    void show_data(){
        sqlcon con = new sqlcon();
        DefaultTableModel model = new DefaultTableModel();
        PreparedStatement ps;
        ResultSet rs;
        String str = "select title,short_hand,description,severity from bugs;" ;
        try {
            ps = con.c.prepareStatement(str);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            String tt,sh,desc,sev;
            while(rs.next()){
                tt=rs.getString(1);
                sh=rs.getString(2);
                desc=rs.getString(3);
                sev=rs.getString(4);

                model.addRow(new Object[]{tt, sh, desc,sev});

            }

            System.out.println("Total columns : " + rsmd.getColumnCount());
            System.out.println("column name : " + rsmd.getColumnName(1));
            System.out.println("column data type  : " + rsmd.getColumnTypeName(1));
        }
        catch (Exception e){
            System.out.println(e);
        }



    }


    void modify_data(){
        String title,short_hand,description,severity;
        title = pnt.getText();
        short_hand = sh.getText();
        description= desc.getText();
        severity =  sever.getSelectedItem().toString();
        System.out.println(severity);
        try{
            sqlcon con = new sqlcon();
            String q1 = "insert into bugs(id,title,short_hand,description,severity,status)values(null,'"+title+"','"+short_hand+"','"+description+"','"+severity+"','unsolved')";
            String r ="update bugs set short_hand='"+short_hand+"',description='"+description+"',severity='"+severity+"',status='unsolved' where title='"+title+"'";
            con.s.executeUpdate(r);
            System.out.println("Data inserted");
            JOptionPane.showMessageDialog(null, "modified successfully");
            show_data();
            sh.setText("");
            desc.setText("");
            table_data(tester);


        }
        catch (Exception e){
            System.out.println(e);
        }
    }





    modifyBug(){
        setTitle("Modify Bugs");
        lbl = new JLabel("Modify your bugs");
        lbl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
        lbl.setBounds(100,1,450,80);
        add(lbl);



        //EDIT
        pn = new JLabel("Title");
        pn.setBounds(10,300,100,30);
        pn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(pn);


        pnt = new JLabel("Title can't be changed");
        pnt.setBounds(50,300,150,30);
        pnt.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(pnt);

        /*tt = new JTextField();
        tt.setFont(new Font("Raleway", Font.BOLD, 12));
        tt.setBounds(50,305,200,23);
        add(tt);*/

        cn = new JLabel("Short Hand");
        cn.setBounds(270,300,100,30);
        cn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(cn);

        sh = new JTextField();
        sh.setFont(new Font("Raleway", Font.BOLD, 12));
        sh.setBounds(350,305,200,23);
        add(sh);


        ds = new JLabel("Description");
        ds.setBounds(10,355,100,30);
        ds.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(ds);

        desc = new JTextField();
        desc.setFont(new Font("Raleway", Font.BOLD, 12));
        desc.setBounds(85,360,200,23);
        add(desc);

        ty = new JLabel("Severity");
        ty.setBounds(300,355,100,30);
        ty.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(ty);

        sever= new JComboBox(d);
        sever.setBounds(360,360,130,20);
        sever.setFont(new Font("Raleway", Font.PLAIN, 11));
        sever.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(sever);











        add2 = new JButton("Modify");
        add2.setBounds(235,450,80,25);
        add2.setOpaque(false);
        add2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add2.setContentAreaFilled(false);
        add(add2);



        setLayout(null);
        setSize(576,541);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        add2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modify_data();
            }
        });



    }

    public static void main(String[] args) {
        new modifyBug();
    }
}
