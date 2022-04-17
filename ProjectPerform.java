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

public class ProjectPerform extends JFrame {
    JLabel lbl;
    JScrollPane sp;
    JTable tb;
    JButton add2;
    JTextField tt,sh,desc ;
    JLabel pn,pni,cl,cli,tl,tli,dev,devi,tes,tesi,uns,unsi,sol,soli,wor,wori,tot,toti;
    JComboBox sever;
    private DefaultTableModel dt;
    String project_n;
    JButton addb;
    String columnNames[]={"Project Name","Client","Type","Leader"};
    DefaultTableModel model = new DefaultTableModel();
    String username;

    void get_data_pp(String usern){
        username=usern;
    }












    void gen_data(){
        sqlcon con = new sqlcon();
        PreparedStatement ps,ps1,ps2,ps3,ps4;
        ResultSet rs,rs1,rs2,rs3,rs4;
        String str = "select count(name) from devtesters where project_name='"+project_n+"' and catg ='developer';" ;
        String str1 = "select count(name) from devtesters where project_name='"+project_n+"' and catg ='tester';" ;
        String str2 ="select count(status) from bugs where project_name='"+project_n+"' and status = 'unsolved';";
        String str3 ="select count(status) from bugs where project_name='"+project_n+"' and status = 'solved';";
        String str4 ="select count(status) from bugs where project_name='"+project_n+"' and status = 'working';";

        try {
            ps = con.c.prepareStatement(str);
            rs = ps.executeQuery();

            ps1 = con.c.prepareStatement(str1);
            rs1 = ps1.executeQuery();

            ps2 = con.c.prepareStatement(str2);
            rs2 = ps2.executeQuery();

            ps3 = con.c.prepareStatement(str3);
            rs3 = ps3.executeQuery();

            ps4 = con.c.prepareStatement(str4);
            rs4 = ps4.executeQuery();





           // ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                devi.setText(rs.getString(1));
            }
            while(rs1.next()){
               tesi.setText(rs1.getString(1));
            }
            while(rs2.next()){
                unsi.setText(rs1.getString(1));
            }
            while(rs3.next()){
                soli.setText(rs1.getString(1));
            }
            while(rs4.next()){
                wori.setText(rs1.getString(1));
            }
           // System.out.println("Total columns : " + rsmd.getColumnCount());
           // int devint = rsmd.getColumnCount();
          //  System.out.println("total developers"+devint);
           // System.out.println("column name : " + rsmd.getColumnName(1));
           // System.out.println("column data type  : " + rsmd.getColumnTypeName(1));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }







    ProjectPerform(){
        setTitle("Project Performance");
        lbl = new JLabel("Project Performance");
        lbl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
        lbl.setBounds(50,1,500,80);
        add(lbl);




        //EDIT
        pn = new JLabel("Project Name:");
        pn.setBounds(10,250,100,30);
        pn  .setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(pn);

        pni = new JLabel("No info");
        pni.setBounds(100,255,200,23);
        pni.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        add(pni);



        cl = new JLabel("Client:");
        cl.setBounds(240,250,100,30);
        cl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(cl);

        cli = new JLabel("No info");
        cli.setBounds(290,255,200,23);
        cli.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(cli);


        tl = new JLabel("Team Leader:");
        tl.setBounds(10,300,100,30);
        tl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(tl);

        tli = new JLabel("No info");
        tli.setBounds(100,305,200,23);
        tli.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        add(tli);



        dev = new JLabel("Devlopers:");
        dev.setBounds(240,300,100,30);
        dev.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(dev);

        devi = new JLabel("No info");
        devi.setBounds(310,305,200,23);
        devi.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        add(devi);


        tes = new JLabel("Tester:");
        tes.setBounds(430,300,100,30);
        tes.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(tes);

        tesi = new JLabel("No info");
        tesi.setBounds(480,305,200,23);
        tesi.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        add(tesi);


        uns = new JLabel("Unsolved:");
        uns.setBounds(10,350,100,30);
        uns.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(uns);

        unsi = new JLabel("No info");
        unsi.setBounds(80,355,200,23);
        unsi.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        add(unsi);

        sol = new JLabel("Solved:");
        sol.setBounds(240,350,100,30);
        sol.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(sol);

        soli = new JLabel("No info");
        soli.setBounds(290,355,200,23);
        soli.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        add(soli);

        wor = new JLabel("working:");
        wor.setBounds(430,350,100,30);
        wor.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(wor);

        wori = new JLabel("No info");
        wori.setBounds(490,355,200,23);
        wori.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        add(wori);


        tot = new JLabel("Total:");
        tot.setBounds(10,400,100,30);
        tot.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(tot);

        toti = new JLabel("No info");
        toti.setBounds(80,405,200,23);
        toti.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        add(toti);


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
        String str = "select project_name,client,type,team_leader,due from project where manager_n = '"+username+"';" ;
       // String str = "select project_name,client,type,team_leader,due from project where manager_n = '"++"';" ;

        try {
            ps = con.c.prepareStatement(str);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            String pn,cl,ty,le;
            while(rs.next()){
                pn=rs.getString(1);
                cl=rs.getString(2);
                ty=rs.getString(3);
                le=rs.getString(4);


                model.addRow(new Object[]{pn,cl,ty,le});

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
                project_n = model.getValueAt(selectedRowIndex,0).toString();
                pni.setText( model.getValueAt(selectedRowIndex,0).toString());
                cli.setText( model.getValueAt(selectedRowIndex,1).toString());
                tli.setText( model.getValueAt(selectedRowIndex,3).toString());

                gen_data();

            }
        });





        add2 = new JButton("Close");
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
               // modify_data();
                dispose();
            }
        });


    }

    public static void main(String[] args) {
        new ProjectPerform();
    }
}
