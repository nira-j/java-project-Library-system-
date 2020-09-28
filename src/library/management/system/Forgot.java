package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class Forgot extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2,b3;

    public static void main(String[] args) {
	new Forgot().setVisible(true);
    }

    public Forgot() {
        super("Reset User");
        setBounds(500, 200, 800, 700);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);
        setResizable(false);

	JLabel l1 = new JLabel("Name");
	l1.setFont(new Font("Tahoma", Font.BOLD, 30));
	l1.setBounds(40, 50, 200, 40);
	contentPane.add(l1);

	JLabel l2 = new JLabel("Username");
	l2.setFont(new Font("Tahoma", Font.BOLD, 30));
	l2.setBounds(40, 100, 200, 40);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Your Security Question");
	l3.setFont(new Font("Tahoma", Font.BOLD, 20));
	l3.setBounds(40, 150, 300, 30);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Answer");
	l4.setFont(new Font("Tahoma", Font.BOLD, 30));
	l4.setBounds(40, 200, 200, 40);
	contentPane.add(l4);

	JLabel l5 = new JLabel("Password");
	l5.setFont(new Font("Tahoma", Font.BOLD, 30));
	l5.setBounds(40, 250, 200, 40);
	contentPane.add(l5);

	t1 = new JTextField();
	t1.setFont(new Font("Tahoma", Font.BOLD, 30));
	t1.setForeground(new Color(105, 105, 105));
	t1.setBounds(300, 50, 250, 40);
	contentPane.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();
	t2.setEditable(false);
	t2.setFont(new Font("Tahoma", Font.BOLD, 30));
	t2.setForeground(new Color(165, 42, 42));
	t2.setColumns(10);
	t2.setBounds(300, 100, 250, 40);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setEditable(false);
	t3.setFont(new Font("Tahoma", Font.BOLD, 30));
	t3.setForeground(new Color(72, 61, 139));
	t3.setColumns(10);
	t3.setBounds(300, 150, 400, 40);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setFont(new Font("Tahoma", Font.BOLD, 30));
	t4.setForeground(new Color(205, 92, 92));
	t4.setColumns(10);
	t4.setBounds(300, 200, 250, 40);
	contentPane.add(t4);

	t5 = new JTextField();
	t5.setEditable(false);
	t5.setFont(new Font("Tahoma", Font.BOLD, 30));
	t5.setForeground(new Color(50, 205, 50));
	t5.setColumns(10);
	t5.setBounds(300, 250, 250, 40);
	contentPane.add(t5);

	b1 = new JButton("Search");
	b1.addActionListener(this);
	b1.setFont(new Font("Tahoma", Font.BOLD, 30));
	b1.setBounds(570, 50, 150,40);
	b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

	b2 = new JButton("Retrieve");
	b2.addActionListener(this);
	b2.setFont(new Font("Tahoma", Font.BOLD, 30));
	b2.setBounds(570, 200, 200,40);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	b3 = new JButton("Back");
	b3.addActionListener(this);
	b3.setFont(new Font("Tahoma", Font.BOLD, 30));
	b3.setBounds(400, 400, 250, 40);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
	contentPane.add(b3);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(139, 69, 19), 6), "Forgot-Panel",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(178, 34, 34)));
	panel.setBounds(10, 10, 770, 600);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            
            if(ae.getSource() == b1){
                String sql = "select * from account where name=?";
		PreparedStatement st = con.c.prepareStatement(sql);

		st.setString(1, t1.getText());
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
                    t2.setText(rs.getString("username"));
                    t3.setText(rs.getString("sec_q"));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "No user exist with name "+t1.getText());
                    t2.setText("");
                    t3.setText("");
                }
               

            }
            if(ae.getSource() == b2){
                String sql = "select * from account where sec_ans=?";
		PreparedStatement st = con.c.prepareStatement(sql);

		st.setString(1, t4.getText());
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
                    	t5.setText(rs.getString("password"));
		}

            }
            if(ae.getSource() == b3){
                this.setVisible(false);
		new Login_user().setVisible(true);
			
            }
        }catch(Exception e){
            
        }
    }

}
