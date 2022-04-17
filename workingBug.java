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

public class workingBug extends JFrame {
    JLabel lbl,tt,tti,sh,shi,des,desi,sev,sevi;
    JScrollPane sp;
    JTable tb;
    JButton add2;
    String title;
    private DefaultTableModel dt;
    String d[]={"Working","Solved"};
    JButton addb;
    String columnNames[]={"Title","Short_hand","Description","Severity"};
    String usernames;
    void get_data_workingBug(String usern){
        usernames=usern;
        System.out.println("usern = " + usernames);
        show_table(usern);
    }
    void show_table(String username){


        //jSCROLLPANE
        sp = new JScrollPane();
        sp.setBounds(2, 80, 550, 200);
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
        System.out.println("at entry: "+username);
        String str = "select title,short_hand,description,severity from bugs where developer_name= '"+username+"' and status ='working';" ;
        System.out.println(str);
        System.out.println("after str " + username);
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

        //Table Listener
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRowIndex= tb.getSelectedRow();
                tti.setText(model.getValueAt(selectedRowIndex,0).toString());
                shi.setText(model.getValueAt(selectedRowIndex,1).toString());
                desi.setText(model.getValueAt(selectedRowIndex,2).toString());
                sevi.setText(model.getValueAt(selectedRowIndex,3).toString());
                title=model.getValueAt(selectedRowIndex,0).toString();
            }
        });

    }
    void solved(){
        try{
            sqlcon con = new sqlcon();
            String r ="update bugs set status ='Solved' where title='"+title+"'";
            con.s.executeUpdate(r);
            System.out.println("Data inserted");
            JOptionPane.showMessageDialog(null, "Set status Solved for: "+usernames+"");
            dispose();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    workingBug(){
        setTitle("Solved Bugs");
        lbl = new JLabel("Solving Bugs");
        lbl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
        lbl.setBounds(100,1,450,80);
        add(lbl);




        //BUTTON
        add2 = new JButton("Solved");
        add2.setBounds(235,450,80,25);
        add2.setOpaque(false);
        add2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add2.setContentAreaFilled(false);
        add(add2);

        //More Info
        tt = new JLabel("Title:");
        tt.setBounds(10,300,100,30);
        tt.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(tt);

        tti = new JLabel("No info");
        tti.setBounds(50,305,200,23);
        tti.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(tti);



        sh = new JLabel("Short Hand:");
        sh.setBounds(10,350,100,30);
        sh.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(sh);

        shi = new JLabel("No info");
        shi.setBounds(100,355,200,23);
        shi.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(shi);


        des = new JLabel("Description:");
        des.setBounds(10,400,100,30);
        des.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(des);

        desi = new JLabel("No info");
        desi.setBounds(100,405,200,23);
        desi.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(desi);



        sev = new JLabel("Severity:");
        sev.setBounds(10,450,100,30);
        sev.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(sev);

        sevi = new JLabel("No info");
        sevi.setBounds(80,455,200,23);
        sevi.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(sevi);



        add2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solved();
            }
        });



        //Jframe
        setLayout(null);
        setSize(576,541);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



    }

    public static void main(String[] args) {
        new workingBug();
    }
}
