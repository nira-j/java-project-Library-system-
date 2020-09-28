package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibraryManagementSystem extends JFrame implements ActionListener{

        JLabel l1;
        JButton b1;
        Toolkit t;
        
        public LibraryManagementSystem() {
            setSize(1366,590);
            setLayout(null);
            setLocation(300,300);
            setResizable(false);
        
	    l1 = new JLabel("");
            b1 = new JButton("Next");
                
            b1.setBackground(Color.BLUE);
            b1.setForeground(Color.WHITE);
				        
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/first.jpg"));
            Image i3 = i1.getImage().getScaledInstance(1366, 590,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            l1 = new JLabel(i2);
                
            b1.setBounds(1050,480,200,40);
            l1.setBounds(0, 0, 1366, 590);
                
            l1.add(b1);
            add(l1);
                
            b1.addActionListener(this);
         
	}
        
        public void actionPerformed(ActionEvent ae){
                new Login_user().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                LibraryManagementSystem window = new LibraryManagementSystem();
                window.setVisible(true);
                //window.setIcon();
	}
        
        private void setIcon(){
        }
}
