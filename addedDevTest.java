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

public class addedDevTest extends JFrame {
    JLabel lbl;
    JScrollPane sp;
    JTable tb;
    JButton add2;
    String columnNames[]={"Category","Name","EmpID","Username","Development"};
    String username,project_name;

    void table_data(String pn){
        //jSCROLLPANE
        sp = new JScrollPane();
        sp.setBounds(10, 80, 530, 350);
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
        //  String str = "select catg,name,empid,username,development from developers where project_name is null;" ;
        String str = "select catg,name,empid,username,development from devtesters where project_name = '"+pn+"';" ;
        System.out.println(str);

        try {
            ps = con.c.prepareStatement(str);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            String cat,nm,ei,un,dev;
            while(rs.next()){
                cat=rs.getString(1);
                nm=rs.getString(2);
                ei=rs.getString(3);
                un=rs.getString(4);
                dev=rs.getString(5);

                model.addRow(new Object[]{cat,nm,ei,un,dev});

            }

            System.out.println("Total columns : " + rsmd.getColumnCount());
            System.out.println("column name : " + rsmd.getColumnName(1));
            System.out.println("column data type  : " + rsmd.getColumnTypeName(1));
        }
        catch (Exception e){
            System.out.println(e);
        }
        //Jtable Mouse Event
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRowIndex= tb.getSelectedRow();
                username = model.getValueAt(selectedRowIndex,3).toString();
            }
        });




    }


    void get_data_addDevTest(String prjname){
        project_name=prjname;
        System.out.println("recieved at adddtv "+project_name);
        table_data(prjname);

    }
    void remove(){
        System.out.println("username = " + username);
        try{
            sqlcon con = new sqlcon();
            //  String r ="update developers set project_name='"+project_name+"' where username='"+username+"'";
            String r ="update devtesters set project_name = null where username='"+username+"'";
            System.out.println(r);
            con.s.executeUpdate(r);
            System.out.println("Data removed");
            JOptionPane.showMessageDialog(null, " Member removed from project ");
            table_data(project_name);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }




    addedDevTest(){
        setTitle("Added Members");
        lbl = new JLabel("Added Members");
        lbl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
        lbl.setBounds(100,1,450,80);
        add(lbl);




        add2 = new JButton("Remove");
        add2.setBounds(235,450,80,25);
        add2.setOpaque(false);
        add2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add2.setContentAreaFilled(false);
        add(add2);




        //Button Event
        add2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove();
            }
        });




        setLayout(null);
        setSize(576,541);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }

    public static void main(String[] args) {
        new addedDevTest();
    }
}
