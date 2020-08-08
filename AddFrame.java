

package studentmanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddFrame extends JFrame {
    Container c;
    JLabel lblRno,lblName;
    JTextField txtRno, txtName;
    JButton btnSave, btnBack;

AddFrame()
{
    c= getContentPane();
    c.setLayout(new FlowLayout());
    lblRno= new JLabel("enter Rno");
    lblName= new JLabel("enter name");
    txtRno= new JTextField(10);
    txtName= new JTextField(10);
    btnSave= new JButton("save");
    btnBack= new JButton("Back");
    c.add(lblRno);
    c.add(txtRno);
    c.add(lblName);
    c.add(txtName);
    c.add(btnSave);
    c.add(btnBack);

    btnSave.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
    String rno = txtRno.getText();
    boolean s1 = rno.isEmpty();
    String name = txtName.getText();
    boolean s2 = name.isEmpty();
    if(s1 || s2)
    {
        JOptionPane.showMessageDialog(new JDialog(), "Enter both Name and Rno");
        return;
    }
    
    try {
        if((name.matches("[0-9]+")==true))
        {
            JOptionPane.showMessageDialog(new JDialog(),"Please enter a valid name");
            return;
        }
        String sql = "insert into student values(?, ?)";
        connect obj=new connect();
        PreparedStatement pst = obj.con.prepareStatement(sql);
        pst.setInt(1, Integer.parseInt(rno));
        pst.setString(2, name);
        int r1 = pst.executeUpdate();
        JOptionPane.showMessageDialog(new JDialog(), r1 + " Records Inserted");
        obj.con.close();   
    }
    catch(Exception e) { 
        JOptionPane.showMessageDialog(new JDialog(), "Enter valid RNumber(Integers only..)"); 
    }
    }});
    
        

    btnBack.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
    MainFrame a = new MainFrame();
    dispose();
    } 
    });

    setTitle("Add Student");
    setSize(350,300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
}
          

