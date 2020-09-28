package library.management.system;

import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login_user extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
        private JButton b1,b2,b3;
        private Font f;


	public Login_user() {
        f=new Font("Arial",Font.BOLD,35);
        setResizable(false);        
      
	setBackground(new Color(169, 169, 169));	
        setBounds(600, 300, 800, 500);
		
        panel = new JPanel();
        panel.setBackground(Color.gray);
	setContentPane(panel);
	panel.setLayout(null);

	JLabel l1 = new JLabel("Username : ");
        l1.setFont(f);
	l1.setBounds(120,90,200, 40);
	panel.add(l1);

	JLabel l2 = new JLabel("Password : ");
        l2.setFont(f);
	l2.setBounds(120,140,200,40);
	panel.add(l2);

	textField = new JTextField();
        textField.setFont(f);
	textField.setBounds(350, 90, 250, 40);
	panel.add(textField);
	
	passwordField = new JPasswordField();
        passwordField.setFont(f);
	passwordField.setBounds(350, 150, 250, 40);
	panel.add(passwordField);

	b1 = new JButton("Login");
	b1.addActionListener(this);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
	b1.setForeground(new Color(46, 139, 87));
	b1.setBackground(new Color(250, 250, 210));
	b1.setBounds(270, 230, 300, 35);
	panel.add(b1);
		
        b2 = new JButton("Sign Up");
	b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
	b2.setForeground(new Color(139, 69, 19));
	b2.setBackground(new Color(255, 235, 205));
	b2.setBounds(270, 270, 300, 35);
	panel.add(b2);
        
	b3 = new JButton("Forgot Password");
	b3.addActionListener(this);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        b3.setForeground(new Color(205, 92, 92));
	b3.setBackground(new Color(253, 245, 230));
	b3.setBounds(270, 310, 300, 35);
	panel.add(b3);
	
	}
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                Boolean status = false;
		try {
                    conn con = new conn();
                    String sql = "select * from account where username=? and password=?";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    st.setString(1, textField.getText());
                    st.setString(2, passwordField.getText());

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        this.setVisible(false);
                        new Loading().setVisible(true);
                    } else
			JOptionPane.showMessageDialog(null, "Invalid Login...!.");
                       
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
            }
            if(ae.getSource() == b2){
                setVisible(false);
		Signup su = new Signup();
		su.setVisible(true);
            }   
            if(ae.getSource() == b3){
                setVisible(false);
		Forgot forgot = new Forgot();
		forgot.setVisible(true);
            }
        }
        
  	public static void main(String[] args) {
                new Login_user().setVisible(true);
	}

}
