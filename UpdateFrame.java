
package studentmanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateFrame extends JFrame {
    Container c;
    JLabel lblRno,lblName;
    JTextField txtRno, txtName;
    JButton btnUpdate, btnBack;

UpdateFrame()
{
    c= getContentPane();
    c.setLayout(new FlowLayout());
    lblRno= new JLabel("Rno");
    lblName= new JLabel("name");
    txtRno= new JTextField(10);
    txtName= new JTextField(10);
    btnUpdate= new JButton("Update");
    btnBack= new JButton("Back");
    c.add(lblRno);
    c.add(txtRno);
    c.add(lblName);
    c.add(txtName);
    c.add(btnUpdate);
    c.add(btnBack);
    
    btnUpdate.addActionListener(new ActionListener() {
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
            else{
                try {
                    connect obj = new connect();
                    String sql = "update student set S_Name = ? where Roll_No = ? ";
                    if((name.matches("[0-9]+")==true)){
                        JOptionPane.showMessageDialog(new JDialog(),"Please enter a valid name");
                        return;
                    }
                    PreparedStatement pst = obj.con.prepareStatement(sql);
                    pst.setInt(2, Integer.parseInt(rno));
                    pst.setString(1, name);
                    int r1 = pst.executeUpdate();
                    JOptionPane.showMessageDialog(new JDialog(), r1 + " Record Updated");
                    obj.con.close();
                }
                catch(Exception e) { 
                    JOptionPane.showMessageDialog(new JDialog(), "Enter valid RNumber(Integers only..)"); 
                }
            }
        }
    });
    btnBack.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
    MainFrame a = new MainFrame();
    dispose();
    } 
    });

    setTitle("Update");
    setSize(300,200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    }
}
