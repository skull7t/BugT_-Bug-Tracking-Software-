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

public class addLeaders extends JFrame {
    JLabel lbl;
    JScrollPane sp;
    JTable tb;
    JButton add2;
    String columnNames[]={"Name","UserID","Username","EmpCode"};
    String username;
    void add2project(){
        System.out.println("username = " + username);
        try{
            sqlcon con = new sqlcon();
            String r ="update leaders set status='approved' where username='"+username+"'";
            con.s.executeUpdate(r);
            System.out.println("Data inserted");
            JOptionPane.showMessageDialog(null, " Leader Approved ");
            dispose();
            new addLeaders();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    addLeaders(){
        lbl = new JLabel("Add Team Leaders");
        lbl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
        lbl.setBounds(100,1,450,80);
        add(lbl);


        //jSCROLLPANE
        sp = new JScrollPane();
        sp.setBounds(55, 80, 450, 350);
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
        String str = "select name,userid,username,empid from leaders where status is null;" ;
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





        add2 = new JButton("Add");
        add2.setBounds(235,450,80,25);
        add2.setOpaque(false);
        add2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add2.setContentAreaFilled(false);
        add(add2);


        //Jtable Mouse Event
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRowIndex= tb.getSelectedRow();
                username = model.getValueAt(selectedRowIndex,2).toString();
            }
        });

        //Button Event
        add2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add2project();
            }
        });




        setLayout(null);
        setSize(576,541);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new addLeaders();
    }
}
