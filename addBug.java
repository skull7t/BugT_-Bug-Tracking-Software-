import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addBug extends JFrame {
    JTextField tt,sh,desc ;
    JLabel lbl,pn,cn,ds,ty,tl,due;
    JButton addb;
    JComboBox sever;
    String d[]={"Low","Medium","High","Very High"};
   public static String project_name,username;

    public void get_data_addBug(String prname,String usrn){
        /*String prname1 = prname;
        String usrname = usrn;*/
        project_name = prname;
        username = usrn;
        System.out.println("pname = " + project_name + ", un = " + username);

    }


    void title_check(){
        try{
        sqlcon con = new sqlcon();
        String title;
        title=tt.getText();
        String q  = "select * from bugs where title = '"+title+"'";
        ResultSet rs = con.s.executeQuery(q);
        if(rs.next()){
            JOptionPane.showMessageDialog(null, "Same titled bug already exists");
        }else{
            store_data();

        }
    }
        catch (Exception e){
        System.out.println(e);
    }

    }
    void store_data(){
        String title,short_hand,description,severity;
        title = tt.getText();
        short_hand = sh.getText();
        description= desc.getText();
        severity =  sever.getSelectedItem().toString();
        System.out.println(severity);
        try{
            sqlcon con = new sqlcon();
            String q1 = "insert into bugs(id,project_name,title,short_hand,description,severity,status,tester_name)values(null,'"+project_name+"','"+title+"','"+short_hand+"','"+description+"','"+severity+"','unsolved','"+username+"')";
            con.s.executeUpdate(q1);
            System.out.println("Data inserted");
            JOptionPane.showMessageDialog(null, "Bug added successfully");
            tt.setText("");
            sh.setText("");
            desc.setText("");


        }
        catch (Exception e){
            System.out.println(e);
        }
    }




    addBug(){
        setTitle("Add Bugs");

        lbl = new JLabel("Add Bugs");
        lbl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
        lbl.setBounds(210,1,450,80);
        add(lbl);

        pn = new JLabel("Title");
        pn.setBounds(130,100,100,30);
        pn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(pn);

        tt = new JTextField();
        tt.setFont(new Font("Raleway", Font.BOLD, 12));
        tt.setBounds(240,105,200,23);
        add(tt);



        cn = new JLabel("Short Hand");
        cn.setBounds(130,150,100,30);
        cn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(cn);

        sh = new JTextField();
        sh.setFont(new Font("Raleway", Font.BOLD, 12));
        sh.setBounds(240,155,200,23);
        add(sh);


        ds = new JLabel("Description");
        ds.setBounds(130,200,100,30);
        ds.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(ds);

        desc = new JTextField();
        desc.setFont(new Font("Raleway", Font.BOLD, 12));
        desc.setBounds(240,205,200,23);
        add(desc);

        ty = new JLabel("Severity");
        ty.setBounds(130,250,100,30);
        ty.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(ty);

        sever= new JComboBox(d);
        sever.setBounds(240,255,130,20);
        sever.setFont(new Font("Raleway", Font.PLAIN, 11));
        sever.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(sever);


        addb = new JButton("Add");
        addb.setBounds(232,430,80,25);
        addb.setOpaque(false);
        addb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addb.setContentAreaFilled(false);
        add(addb);






        setLayout(null);
        setSize(576,541);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        addb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                title_check();
            }
        });




    }

    public static void main(String[] args) {
        new addBug();
    }
}
