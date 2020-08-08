
package studentmanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DeleteFrame extends JFrame {
    Container c;
    JLabel lblRno;
    JTextField txtRno;
    JButton btnDelete, btnBack;

    DeleteFrame()
    {
        c= getContentPane();
        c.setLayout(new FlowLayout());
        lblRno= new JLabel("Rno");
        txtRno= new JTextField(10);
        btnDelete= new JButton("Delete");
        btnBack= new JButton("Back");
        c.add(lblRno);
        c.add(txtRno);
        c.add(btnDelete);
        c.add(btnBack);
        
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String rno = txtRno.getText();
                boolean s1 = rno.isEmpty();
                if(s1 == true)
                JOptionPane.showMessageDialog(new JDialog(), "Enter Roll Number");
                try {
                    connect obj = new connect();
                    String sql = "delete from student where Roll_no = ?";
                    PreparedStatement pst = obj.con.prepareStatement(sql);
                    pst.setInt(1, Integer.parseInt(rno));
                    int r1 = pst.executeUpdate();
                    JOptionPane.showMessageDialog(new JDialog(), r1 + " Record Deleted");
                    obj.con.close(); 
                }
                catch(SQLException se) {
                    JOptionPane.showMessageDialog(new JDialog(), "Issue "+ se);
                }
                catch(Exception e) { JOptionPane.showMessageDialog(new JDialog(),"Enter valid RNumber(Integers only..)");
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                MainFrame a = new MainFrame();
                dispose();
            } 
        });

        setTitle("Delete Student");
        setSize(180,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
}
}
