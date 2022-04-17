import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class createProject extends JFrame {
    JTextField pnt,cnt,dt,duet ;
    JLabel lbl,pn,cn,ds,ty,tl,due;
    JButton create;
    JComboBox typcb,tlcb;
    String strDate;
    private PreparedStatement ps;
    private ResultSet rs;
    String d[]={"Web Development","Software Development","Mobile App Development","Database Management"};
    String username;
    void get_data_cp(String usn){
        username= usn;
    }


    void check_empty(){
        if(pnt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else if(cnt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else if(dt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else if(duet.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Complete all details");
        }
        else {
            date_check();
        }
    }

    void create_project(){
        String project_name,client_name,desc,type,team_leader,due;
        project_name= pnt.getText();
        client_name= cnt.getText();
        desc=dt.getText();
        type= (String)typcb.getSelectedItem();
        team_leader = (String)tlcb.getSelectedItem();
        due=duet.getText();
        try {
            sqlcon con = new sqlcon();
           // String q1 = "insert into project values(null,'"+project_name+"','"+client_name+"','"+desc+"','"+type+"','"+team_leader+"','"+due+"')";
            String q1 = "insert into project values(null,'"+project_name+"','"+username+"','"+client_name+"','"+desc+"','"+type+"','"+team_leader+"','"+due+"')";
            String q2 ="update leaders set project_name='"+project_name+"' where username='"+team_leader+"'";
            con.s.executeUpdate(q1);
            con.s.executeUpdate(q2);
            System.out.println("Data inserted");
            JOptionPane.showMessageDialog(null, "Project was created and the Leader was assigned");
            setVisible(false);
            new createProject();

        }
        catch (Exception e){
            System.out.println(e);
        }

    }


    void date_check(){
        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
        sdfrmt.setLenient(false);
        try
        {
            Date javaDate = sdfrmt.parse(strDate);
            System.out.println(strDate+" is valid date format");
            create_project();
        }
        catch (ParseException e)
        {
            JOptionPane.showMessageDialog(null, "Invalid Date Format");
            System.out.println(strDate+" is Invalid Date format");
        }
    }


    createProject(){
        setTitle("Create Project");

        lbl = new JLabel("Create Project");
        lbl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
        lbl.setBounds(110,1,450,80);
        add(lbl);

        pn = new JLabel("Project Name");
        pn.setBounds(130,100,100,30);
        pn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(pn);

        pnt = new JTextField();
        pnt.setFont(new Font("Raleway", Font.BOLD, 12));
        pnt.setBounds(240,105,200,23);
        add(pnt);



        cn = new JLabel("Client Name");
        cn.setBounds(130,150,100,30);
        cn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(cn);

        cnt = new JTextField();
        cnt.setFont(new Font("Raleway", Font.BOLD, 12));
        cnt.setBounds(240,155,200,23);
        add(cnt);


        ds = new JLabel("Description");
        ds.setBounds(130,200,100,30);
        ds.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(ds);

        dt = new JTextField();
        dt.setFont(new Font("Raleway", Font.BOLD, 12));
        dt.setBounds(240,205,200,23);
        add(dt);

        ty = new JLabel("Type");
        ty.setBounds(130,250,100,30);
        ty.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(ty);

        typcb= new JComboBox(d);
        typcb.setBounds(240,255,130,20);
        typcb.setFont(new Font("Raleway", Font.PLAIN, 11));
        typcb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(typcb);

        tl = new JLabel("Team Leader");
        tl.setBounds(130,300,100,30);
        tl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(tl);


        tlcb= new JComboBox();
        tlcb.setBounds(240,305,130,20);
        tlcb.setFont(new Font("Raleway", Font.PLAIN, 11));
        tlcb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(tlcb);


        due = new JLabel("Due");
        due.setBounds(130,350,100,30);
        due.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(due);


        //DATA TO COMBO
        sqlcon con = new sqlcon();
        String str = "select * from leaders where project_name is null";
        try {
            ps = con.c.prepareStatement(str);
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String username = rs.getString("username");
                String daters = "Name: "+name+" | Username: "+username;
                tlcb.addItem(username);
            }
        } catch (Exception e) {
            System.out.println(e);
        }







        duet = new JTextField();
        duet.setFont(new Font("Raleway", Font.BOLD, 12));
        duet.setBounds(240,355,200,23);
        duet.setText("dd-MM-yyyy");
        add(duet);



        create = new JButton("Create");
        create.setBounds(232,430,80,25);
        create.setOpaque(false);
        create.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        create.setContentAreaFilled(false);
        add(create);






        setLayout(null);
        setSize(576,541);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strDate = duet.getText();
                check_empty();
            }
        });

    }

    public static void main(String[] args) {
        new createProject();
    }
}
