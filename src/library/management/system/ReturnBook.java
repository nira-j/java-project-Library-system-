package library.management.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;

public class ReturnBook extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6,date;
    private JButton b1,b2,b3,drbtn;
    private JDateChooser dateChooser;
    private String sdate;

    public static void main(String[] args) {
	new ReturnBook().setVisible(true);
    }

    public void delete() {
        try {
            conn con = new conn();
            String sql = "delete from issueBook where book_id=?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, textField.getText());
            int i = st.executeUpdate();
            if (i > 0)
                JOptionPane.showConfirmDialog(null, "Book Returned");
            else
                JOptionPane.showMessageDialog(null, "error in Deleting");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
	}
    }

    
    public ReturnBook() {
        super("Return Book");
        setBounds(330, 300, 1200, 550);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);
        setResizable(false);
                //**************book id
	JLabel lblNewLabel = new JLabel("Book_id");
	lblNewLabel.setForeground(new Color(0, 0, 0));
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
	lblNewLabel.setBounds(50, 50, 200, 40);
	contentPane.add(lblNewLabel);
        
        textField = new JTextField();
	textField.setForeground(new Color(105, 105, 105));
	textField.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	textField.setBounds(230, 50, 200, 40);
	contentPane.add(textField);
	textField.setColumns(10);
        //********************************
        
        //**********student id************
	JLabel lblStudentid = new JLabel("Student_id");
	lblStudentid.setForeground(Color.BLACK);
	lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 35));
	lblStudentid.setBounds(480, 50, 200, 40);
	contentPane.add(lblStudentid);
        
        textField_1 = new JTextField();
	textField_1.setForeground(new Color(105, 105, 105));
	textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	textField_1.setBounds(700, 50, 200, 40);
	contentPane.add(textField_1);
	textField_1.setColumns(10);
        
        b1 = new JButton("Search");
	b1.addActionListener(this);
	b1.setBounds(930, 50, 100, 30);
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);
        
        //*****************************
        
        //**********
	JLabel lblBook = new JLabel("Book");
	lblBook.setForeground(Color.BLACK);
	lblBook.setFont(new Font("Tahoma", Font.BOLD, 35));
	lblBook.setBounds(50, 110, 200, 40);
	contentPane.add(lblBook);
        
        textField_2 = new JTextField();
	textField_2.setEditable(false);
	textField_2.setForeground(new Color(0, 100, 0));
	textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	textField_2.setBounds(230, 110, 200, 40);
	contentPane.add(textField_2);
	textField_2.setColumns(10);
        //**************
 
        //***********
	JLabel lblName = new JLabel("Name");
	lblName.setForeground(Color.BLACK);
	lblName.setFont(new Font("Tahoma", Font.BOLD, 35));
	lblName.setBounds(480, 110, 200, 40);
	contentPane.add(lblName);
        
        textField_3 = new JTextField();
	textField_3.setEditable(false);
	textField_3.setForeground(new Color(0, 100, 0));
	textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	textField_3.setColumns(10);
	textField_3.setBounds(700, 110, 200, 40);
	contentPane.add(textField_3);
        //************
 
        //***********
        JLabel lblCourse = new JLabel("Course");
	lblCourse.setForeground(Color.BLACK);
	lblCourse.setFont(new Font("Tahoma", Font.BOLD, 35));
	lblCourse.setBounds(50, 170, 200, 40);
	contentPane.add(lblCourse);
        
        textField_4 = new JTextField();
	textField_4.setEditable(false);
	textField_4.setForeground(new Color(0, 100, 0));
	textField_4.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	textField_4.setColumns(10);
	textField_4.setBounds(230, 170, 200, 40);
	contentPane.add(textField_4);
        //**************
              
        JLabel lblBranch = new JLabel("Branch");
	lblBranch.setForeground(Color.BLACK);
	lblBranch.setFont(new Font("Tahoma", Font.BOLD, 35));
	lblBranch.setBounds(480, 170, 200, 40);
	contentPane.add(lblBranch);
        
        textField_5 = new JTextField();
	textField_5.setForeground(new Color(0, 100, 0));
	textField_5.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	textField_5.setEditable(false);
	textField_5.setColumns(10);
	textField_5.setBounds(700, 170, 200, 40);
	contentPane.add(textField_5);

	JLabel lblDateOfIssue = new JLabel("Issued date");
	lblDateOfIssue.setForeground(Color.BLACK);
	lblDateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 35));
	lblDateOfIssue.setBounds(50, 230, 250, 40);
	contentPane.add(lblDateOfIssue);
        
        textField_6 = new JTextField();
	textField_6.setForeground(new Color(0, 100, 0));
	textField_6.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	textField_6.setEditable(false);
	textField_6.setColumns(10);
	textField_6.setBounds(310, 230, 200, 40);
	contentPane.add(textField_6);

	drbtn = new JButton("Return date");
	drbtn.addActionListener(this);
	drbtn.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
	drbtn.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
	drbtn.setBounds(50, 300, 180, 40);
        drbtn.setBackground(Color.GRAY);
        drbtn.setForeground(Color.WHITE);
        contentPane.add(drbtn);
        
        date = new JTextField();
	date.setForeground(new Color(0, 100, 0));
	date.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	date.setEditable(false);
	date.setColumns(10);
	date.setBounds(310, 300, 200, 40);
	contentPane.add(date);
	

	b2 = new JButton("Return");
	b2.addActionListener(this);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	b2.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
	b2.setBounds(700, 240, 150, 40);
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	b3 = new JButton("Back");
	b3.addActionListener(this);
	b3.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	b3.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
	b3.setBounds(700, 300, 150, 40);
        b3.setBackground(Color.GRAY);
        b3.setForeground(Color.WHITE);
	contentPane.add(b3);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 69, 0), 6, true), "Return-Panel",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
	panel.setBounds(10, 10, 1100, 500);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "select * from issueBook where student_id = ? and book_id =?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, textField_1.getText());
		st.setString(2, textField.getText());
		ResultSet rs = st.executeQuery();
		
                while (rs.next()) {
                    textField_2.setText(rs.getString("bname"));
                    textField_3.setText(rs.getString("sname"));
                    textField_4.setText(rs.getString("course"));
                    textField_5.setText(rs.getString("branch"));
                    textField_6.setText(rs.getString("dateOfIssue"));
		}
		st.close();
		rs.close();
		
            }
            if(ae.getSource() == b2){
                String sql = "insert into returnBook(book_id, student_id, bname, sname,course, branch, dateOfIssue, dateOfReturn) values(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, textField.getText());
		st.setString(2, textField_1.getText());
		st.setString(3, textField_2.getText());
		st.setString(4, textField_3.getText());
		st.setString(5, textField_4.getText());
		st.setString(6, textField_5.getText());
		st.setString(7, textField_6.getText());
		st.setString(8, sdate);
		int i = st.executeUpdate();
		if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Successfully returned...");
                    delete();
		} else
                    JOptionPane.showMessageDialog(null, "Error");
		
            }
            if(ae.getSource() == b3){
                this.setVisible(false);
		new Home().setVisible(true);
			
            }
            if(ae.getSource() == drbtn){
                sdate=LocalDate.now().toString();
                date.setText(sdate);
            }
        }catch(Exception e){
            
        }
    }
}
