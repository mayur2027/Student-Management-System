
package studentmanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ViewFrame extends JFrame {
    Container c;
    TextArea ta;
    JButton btnBack;


ViewFrame()
{
    c = getContentPane();
    c.setLayout(new FlowLayout());

    ta = new TextArea(7, 20);
    btnBack = new JButton("Back");

    c.add(ta);
    c.add(btnBack);
    
    StringBuffer sb = new StringBuffer();
    
    try {
        connect obj = new connect();
        String sql = "select * from student";
        Statement stmt = obj.con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
        int rno = rs.getInt(1);
        String name = rs.getString(2);
        sb.append("Rno: "+rno+"   Name: "+" "+ name +" \n");
        }
        rs.close(); 
        obj.con.close(); 
    }
    catch(SQLException se) {
        JOptionPane.showMessageDialog(new JDialog(), "Issue "+ se);
    }
    
    String data = sb.toString();
    ta.setText(data);


    btnBack.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae){
    MainFrame a = new MainFrame();
    dispose();
    }
    });


    setTitle("View Student");
    setSize(300, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    }
    
}
