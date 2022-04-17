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

public class deleteProjects extends JFrame {
    JLabel lbl;
    JScrollPane sp;
    JTable tb;
    JButton add2;
    String columnNames[]={"Project Name","Client","Type","Team Leader","Due"};
    String project_name;
    void delete_proj(){
        try {
            sqlcon con = new sqlcon();
            String q1 = "delete from project where project_name='"+project_name+"';";
            String q2 ="update leaders set project_name=null where project_name='"+project_name+"';";
          //  String q3 ="update developers set project_name=null where project_name='"+project_name+"';";
            String q3 ="update devtesters set project_name=null where project_name='"+project_name+"';";

            con.s.executeUpdate(q1);
            con.s.executeUpdate(q2);
            con.s.executeUpdate(q3);
            System.out.println("Data Deleted");
            JOptionPane.showMessageDialog(null, "Project Deleted all the member removed");
            dispose();
            new deleteProjects();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    deleteProjects(){
        setTitle("Delete Projects");
        lbl = new JLabel("Delete Projects");
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
        String str = "select project_name,client,type,team_leader,due from project;" ;
        try {
            ps = con.c.prepareStatement(str);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            String pn,cl,ty,tl,du;
            while(rs.next()){
                pn=rs.getString(1);
                cl=rs.getString(2);
                ty=rs.getString(3);
                tl=rs.getString(4);
                du=rs.getString(5);


                model.addRow(new Object[]{pn,cl,ty,tl,du});

            }

            System.out.println("Total columns : " + rsmd.getColumnCount());
            System.out.println("column name : " + rsmd.getColumnName(1));
            System.out.println("column data type  : " + rsmd.getColumnTypeName(1));
        }
        catch (Exception e){
            System.out.println(e);
        }





        add2 = new JButton("Delete");
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
                project_name = model.getValueAt(selectedRowIndex,0).toString();
            }
        });

        //Button Event
        add2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete_proj();
            }
        });




        setLayout(null);
        setSize(576,541);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args) {
        new deleteProjects();
    }
}
