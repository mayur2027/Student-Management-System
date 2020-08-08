
package studentmanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    Container c;
    JButton btnAdd, btnView, btnUpdate ,btnDelete;

MainFrame() {
    c = getContentPane();
    c.setLayout(new FlowLayout());
    btnAdd = new JButton("Add");
    btnView = new JButton("View");
    btnUpdate = new JButton("Update");
    btnDelete = new JButton("Delete");
    c.add(btnAdd);
    c.add(btnView);
    c.add(btnUpdate);
    c.add(btnDelete);

    btnAdd.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            AddFrame a = new AddFrame();
            dispose();
        }
    });

    btnView.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            ViewFrame v = new ViewFrame();
            dispose();
        }
    });

    btnUpdate.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            UpdateFrame u = new UpdateFrame();
            dispose();
        }
    });
    
    btnDelete.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            DeleteFrame d = new DeleteFrame();
            dispose();
        }
    });

    setTitle("Student Management System");
    setSize(300, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
    public static void main(String[] args) {
    MainFrame m = new MainFrame();}
}
