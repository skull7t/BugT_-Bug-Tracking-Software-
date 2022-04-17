import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class project_info extends JFrame {
    JLabel pn,cl,desc,ty,tl,due,lbl;
    JLabel pni,cli,desci,tyi,tli,duei;
    String proj;
    void get_data_prinfo(String proji){
        proj=proji;
        System.out.println("project = " + proj);
        setdata(proji);
    }
    void setdata(String check){
        sqlcon con = new sqlcon();
        PreparedStatement ps;
        ResultSet rs;
        String str = "select project_name,client,description,type,team_leader,due from project where project_name='"+check+"';" ;
        System.out.println(str);
        try {
            ps = con.c.prepareStatement(str);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            String pn,cl,ds,ty,le,du;
            while(rs.next()){
                pn=rs.getString(1);
                cl=rs.getString(2);
                ds=rs.getString(3);
                ty=rs.getString(4);
                le=rs.getString(5);
                du=rs.getString(6);
                pni.setText(pn);
                cli.setText(cl);
                desci.setText(ds);
                tyi.setText(ty);
                tli.setText(le);
                duei.setText(du);
            }

        }
        catch (Exception e){
            System.out.println(e);
        }


    }


    project_info(){
        setTitle("Project Info");
        lbl = new JLabel(" My Project Information");
        lbl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
        lbl.setBounds(10,1,600,80);
        add(lbl);


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


        desc = new JLabel("Description:");
        desc.setBounds(10,300,100,30);
        desc.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(desc);

        desci = new JLabel("No info");
        desci.setBounds(100,305,200,23);
        desci.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        add(desci);



        ty = new JLabel("Type:");
        ty.setBounds(240,300,100,30);
        ty.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(ty);

        tyi = new JLabel("No info");
        tyi.setBounds(310,305,200,23);
        tyi.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        add(tyi);


        tl = new JLabel("TeamLeader:");
        tl.setBounds(400,250,100,30);
        tl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(tl);

        tli = new JLabel("No info");
        tli.setBounds(500,255,200,23);
        tli.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        add(tli);


        due = new JLabel("Due:");
        due.setBounds(10,350,100,30);
        due.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(due);

        duei = new JLabel("No info");
        duei.setBounds(80,355,200,23);
        duei.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        add(duei);



        setLayout(null);
        setSize(576,541);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args) {
        new project_info();
    }
}
