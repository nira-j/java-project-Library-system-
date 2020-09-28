package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddStudent extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3;
    private JComboBox comboBox1, comboBox2, comboBox3, comboBox4;
    JButton b1,b2;

    public static void main(String[] args) {
        new AddStudent().setVisible(true);
    }

    public void random() {
        Random rd = new Random();
	t1.setText("" + rd.nextInt(10000 + 1));
    }

    public AddStudent() {
        super("Add Student");
        setResizable(false);

	setBounds(700, 200, 640, 700);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel l1 = new JLabel("Student_id");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 35));
	l1.setBounds(34, 60, 200, 40);
	contentPane.add(l1);

	JLabel l2 = new JLabel("Name");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 35));
	l2.setBounds(34, 110, 200, 40);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Father's Name");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 35));
	l3.setBounds(34, 160, 280, 40);
	contentPane.add(l3);

        JLabel l4 = new JLabel("Course");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 35));
	l4.setBounds(34, 210, 200, 40);
	contentPane.add(l4);

	

        JLabel l5 = new JLabel("Year");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 35));
	l5.setBounds(34, 260, 200, 40);
	contentPane.add(l5);

	JLabel l6 = new JLabel("Semester");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.BOLD, 35));
	l6.setBounds(34, 310, 200, 40);
	contentPane.add(l6);

	t1 = new JTextField();
	t1.setEditable(false);
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t1.setBounds(300, 60, 250, 40);
	contentPane.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t2.setColumns(10);
	t2.setBounds(300, 110, 250, 40);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t3.setColumns(10);
	t3.setBounds(300, 160, 250, 40);
	contentPane.add(t3);
        
        comboBox1 = new JComboBox();
	comboBox1.setModel(new DefaultComboBoxModel(
			new String[] { "B.E", "B.Tech", "M.Tech", "MBA", "BBA", "BCA", "B.Sc","MCA", "M.Sc", "B.Com", "M.Com" }));
	comboBox1.setForeground(new Color(47, 79, 79));
	comboBox1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	comboBox1.setBounds(300, 210, 250, 40);
	contentPane.add(comboBox1);

	comboBox2 = new JComboBox();
	comboBox2.setModel(new DefaultComboBoxModel(new String[] { "First", "Second", "Third" }));
	comboBox2.setForeground(new Color(47, 79, 79));
	comboBox2.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	comboBox2.setBounds(300, 260, 250, 40);
	contentPane.add(comboBox2);

	comboBox3 = new JComboBox();
	comboBox3.setModel(
			new DefaultComboBoxModel(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th"}));
	comboBox3.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	comboBox3.setForeground(new Color(47, 79, 79));
	comboBox3.setBounds(300, 310, 250, 40);
	contentPane.add(comboBox3);

	b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	b1.setBounds(300, 560, 100, 40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	b2.setBounds(410, 560, 150, 40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	

	

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(102, 205, 170), 6, true), "Add-Student",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
	panel.setBackground(new Color(211, 211, 211));
	panel.setBounds(5, 10, 590, 640);
        
        contentPane.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);
        
	contentPane.add(panel);
	random();
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                    if(!t1.getText().equals("") && !t2.getText().equals("") && !t3.getText().equals("")){
                    conn con = new conn();
                    String sql = "insert into student(student_id, name, father, course, branch, year, semester) values(?, ?, ?, ?, ?, ?, ?)";
		    PreparedStatement st = con.c.prepareStatement(sql);
		    st.setString(1, t1.getText());
		    st.setString(2, t2.getText());
		    st.setString(3, t3.getText());
		    st.setString(4, (String) comboBox1.getSelectedItem());
                    st.setString(5, "null");
		    st.setString(6, (String) comboBox2.getSelectedItem());
		    st.setString(7, (String) comboBox3.getSelectedItem());
		   

		    int i = st.executeUpdate();
		    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                        t3.setText(null);
                        t2.setText(null);
                        random();
                        //this.setVisible(false);
                        //new Home().setVisible(true);
                    }
		    else
                        JOptionPane.showMessageDialog(null, "error");
                    }else
                        JOptionPane.showMessageDialog(null, "first fill all fields");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            
            if(ae.getSource() == b2){
                this.setVisible(false);
		new Home().setVisible(true);		
            }
        }catch(Exception e){
            
        }
    }
}

