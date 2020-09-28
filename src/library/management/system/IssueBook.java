package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;

public class IssueBook extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,date;
    private JButton b1,b2,b3,b4,dbtn;
    private String sdate;
    

    public static void main(String[] args) {
	new IssueBook().setVisible(true);
			
    }

    public IssueBook() {
        super("book Isuue");
        setBounds(300, 100, 1400, 750);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);
        setResizable(false);

	JLabel l1 = new JLabel("Book_id");
	l1.setFont(new Font("Tahoma", Font.BOLD, 35));
	l1.setForeground(new Color(47, 79, 79));
	l1.setBounds(40, 50, 200, 40);
	contentPane.add(l1);

	JLabel l2 = new JLabel("Name");
	l2.setForeground(new Color(47, 79, 79));
	l2.setFont(new Font("Tahoma", Font.BOLD, 35));
	l2.setBounds(40, 100, 200, 40);
	contentPane.add(l2);

	JLabel l3 = new JLabel("ISBN");
	l3.setForeground(new Color(47, 79, 79));
	l3.setFont(new Font("Tahoma", Font.BOLD, 35));
	l3.setBounds(40, 150, 200, 40);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Publisher");
	l4.setForeground(new Color(47, 79, 79));
	l4.setFont(new Font("Tahoma", Font.BOLD, 35));
	l4.setBounds(40, 200, 200, 40);
	contentPane.add(l4);

	JLabel l5 = new JLabel("Edition");
	l5.setForeground(new Color(47, 79, 79));
	l5.setFont(new Font("Tahoma", Font.BOLD, 35));
	l5.setBounds(40, 250, 200, 40);
	contentPane.add(l5);

	JLabel l6 = new JLabel("Price");
	l6.setForeground(new Color(47, 79, 79));
	l6.setFont(new Font("Tahoma", Font.BOLD, 35));
	l6.setBounds(40, 300, 200, 40);
	contentPane.add(l6);

	JLabel l7 = new JLabel("Pages");
	l7.setForeground(new Color(47, 79, 79));
	l7.setFont(new Font("Tahoma", Font.BOLD, 35));
	l7.setBounds(40, 350, 200, 40);
	contentPane.add(l7);
        
        date = new JTextField();
	date.setForeground(new Color(47, 79, 79));
	date.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	date.setBounds(340, 430, 280, 40);
	contentPane.add(date);
       
        
        dbtn = new JButton("Date");
	dbtn.addActionListener(this);
	dbtn.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	dbtn.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	dbtn.setBounds(40, 430, 200, 40);
	dbtn.setBackground(Color.GRAY);
        dbtn.setForeground(Color.WHITE);
        contentPane.add(dbtn);

	b3 = new JButton("Issue");
	b3.addActionListener(this);
	b3.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
	b3.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	b3.setBounds(150, 510, 200, 40);
	b3.setBackground(Color.GRAY);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

	b4 = new JButton("Back");
	b4.addActionListener(this);
	b4.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
	b4.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	b4.setBounds(500, 630, 200, 40);
	b4.setBackground(Color.GRAY);
        b4.setForeground(Color.WHITE);
        contentPane.add(b4);

	t1 = new JTextField();
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t1.setBounds(250, 50, 200, 40);
	contentPane.add(t1);
	
	b1 = new JButton("Search");
	b1.addActionListener(this);
	b1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.WHITE);
	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
	b1.setBounds(470, 50, 100, 30);
        
	contentPane.add(b1);

	t2 = new JTextField();
	t2.setEditable(false);
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t2.setBounds(250, 100, 200, 40);
	contentPane.add(t2);
	t2.setColumns(10);

	t3 = new JTextField();
	t3.setEditable(false);
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t3.setColumns(10);
	t3.setBounds(250, 150, 200, 40);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setEditable(false);
	t4.setForeground(new Color(47, 79, 79));
	t4.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t4.setColumns(10);
	t4.setBounds(250, 200, 200, 40);
	contentPane.add(t4);

	t5 = new JTextField();
	t5.setEditable(false);
	t5.setForeground(new Color(47, 79, 79));
	t5.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t5.setColumns(10);
	t5.setBounds(250, 250, 200, 40);
	contentPane.add(t5);

	t6 = new JTextField();
	t6.setEditable(false);
	t6.setForeground(new Color(47, 79, 79));
	t6.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t6.setColumns(10);
	t6.setBounds(250, 300, 200, 40);
	contentPane.add(t6);

	t7 = new JTextField();
	t7.setEditable(false);
	t7.setForeground(new Color(47, 79, 79));
	t7.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t7.setColumns(10);
	t7.setBounds(250, 350, 200, 40);
	contentPane.add(t7);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 6, true), "Issue-Book",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setFont(new Font("Tahoma", Font.BOLD, 35));
	panel.setBounds(10, 10, 660, 550);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);

	JLabel l8 = new JLabel("Student_id");
	l8.setForeground(new Color(47, 79, 79));
	l8.setFont(new Font("Tahoma", Font.BOLD, 35));
	l8.setBounds(710, 50, 200, 40);
	contentPane.add(l8);

	JLabel l9 = new JLabel("Name");
	l9.setForeground(new Color(47, 79, 79));
	l9.setFont(new Font("Tahoma", Font.BOLD, 35));
	l9.setBounds(710, 100, 200, 40);
	contentPane.add(l9);

	JLabel l10 = new JLabel("Father's Name");
	l10.setForeground(new Color(47, 79, 79));
	l10.setFont(new Font("Tahoma", Font.BOLD, 35));
	l10.setBounds(710, 150, 280, 40);
	contentPane.add(l10);

	JLabel l11 = new JLabel("Course");
	l11.setForeground(new Color(47, 79, 79));
	l11.setFont(new Font("Tahoma", Font.BOLD, 35));
	l11.setBounds(710, 200, 200, 40);
	contentPane.add(l11);

	JLabel l12 = new JLabel("Branch");
	l12.setForeground(new Color(47, 79, 79));
	l12.setFont(new Font("Tahoma", Font.BOLD, 35));
	l12.setBounds(710, 250, 200, 40);
	contentPane.add(l12);

	JLabel l13 = new JLabel("Year");
	l13.setForeground(new Color(47, 79, 79));
	l13.setFont(new Font("Tahoma", Font.BOLD, 35));
	l13.setBounds(710, 300, 200, 40);
	contentPane.add(l13);

	JLabel l14 = new JLabel("Semester");
	l14.setForeground(new Color(47, 79, 79));
	l14.setFont(new Font("Tahoma", Font.BOLD, 35));
	l14.setBounds(710, 350, 200, 40);
	contentPane.add(l14);

	t8 = new JTextField();
	t8.setForeground(new Color(47, 79, 79));
	t8.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t8.setColumns(10);
	t8.setBounds(980, 50, 200, 40);
	contentPane.add(t8);

	b2 = new JButton("Search");
	b2.addActionListener(this);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
	b2.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
	b2.setBounds(1230, 50, 100, 35);
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	t9 = new JTextField();
	t9.setForeground(new Color(47, 79, 79));
	t9.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t9.setEditable(false);
	t9.setColumns(10);
	t9.setBounds(980, 100, 200, 40);
	contentPane.add(t9);

	t10 = new JTextField();
	t10.setForeground(new Color(47, 79, 79));
	t10.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t10.setEditable(false);
	t10.setColumns(10);
	t10.setBounds(980, 150, 200, 40);
	contentPane.add(t10);

	t11 = new JTextField();
	t11.setForeground(new Color(47, 79, 79));
	t11.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t11.setEditable(false);
	t11.setColumns(10);
	t11.setBounds(980, 200, 200, 40);
	contentPane.add(t11);

	t12 = new JTextField();
	t12.setForeground(new Color(47, 79, 79));
	t12.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t12.setEditable(false);
	t12.setColumns(10);
	t12.setBounds(980, 250, 200, 40);
	contentPane.add(t12);

	t13 = new JTextField();
	t13.setForeground(new Color(47, 79, 79));
	t13.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t13.setEditable(false);
	t13.setColumns(10);
	t13.setBounds(980, 300, 200, 40);
	contentPane.add(t13);

	t14 = new JTextField();
	t14.setForeground(new Color(47, 79, 79));
	t14.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	t14.setEditable(false);
	t14.setColumns(10);
	t14.setBounds(980, 350, 200, 40);
	contentPane.add(t14);

	JPanel panel_1 = new JPanel();
	panel_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180), 6, true), "Student-Deatails",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 149, 237)));
	panel_1.setForeground(new Color(0, 100, 0));
	panel_1.setBounds(680, 10, 670, 550);
        panel_1.setBackground(Color.WHITE);
	contentPane.add(panel_1);
        

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            if(t1.getText()!=""){
                try{
                    conn con = new conn();
                    String sql = "select * from book where book_id = ?";
		    PreparedStatement st = con.c.prepareStatement(sql);
		    st.setString(1, t1.getText());
		    ResultSet rs = st.executeQuery();
		
                    if (rs.next()) {
                        t2.setText(rs.getString("name"));
                        t3.setText(rs.getString("isbn"));
                        t4.setText(rs.getString("publisher"));
                        t5.setText(rs.getString("edition"));
                        t6.setText(rs.getString("price"));
                        t7.setText(rs.getString("pages"));
                        st.close();
		        rs.close();
		    }else{
                    JOptionPane.showMessageDialog(this, "Book Id not exist in database...");
                    }
                }catch(Exception e){}
            }else{
                JOptionPane.showMessageDialog(this, "Enter first Book Id...");
            }
        }
        if(ae.getSource() == b2){
            if(t8.getText()!=""){
                try{
                   conn con = new conn();
                   String sql = "select * from student where student_id = ?";
		   PreparedStatement st = con.c.prepareStatement(sql);
		   st.setString(1, t8.getText());
		   ResultSet rs = st.executeQuery();
                   if (rs.next()) {
                       t9.setText(rs.getString("name"));
                       t10.setText(rs.getString("father"));
                       t11.setText(rs.getString("course"));
                       t12.setText(rs.getString("branch"));
                       t13.setText(rs.getString("year"));
                       t14.setText(rs.getString("semester"));
                       st.close();
		       rs.close();
                    }else{
                       JOptionPane.showMessageDialog(this, "Student Id not exist in database...");
                   }
		}catch(Exception e){}
            }else{
                JOptionPane.showMessageDialog(this, "Enter first Student Id...");
            }
        }
        if(ae.getSource() == b3){
            try{
                conn con = new conn();
	        //((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
                String sql = "insert into issuebook values('"+t1.getText()+"','"+t8.getText()+"','"+t2.getText()+"','"+t9.getText()+"','"+t11.getText()+"','"+t12.getText()+"','"+sdate+"')";
                
		int i = con.s.executeUpdate(sql);
                System.out.print("hello");

		if (i>0){
                    JOptionPane.showMessageDialog(null, "Successfully Book Issued..!");
		    con.c.close();
                }else
                    JOptionPane.showMessageDialog(null, "Error");
            }catch(Exception e){System.out.print(e);}
        }
        if(ae.getSource() == b4){
            this.setVisible(false);
            new Home().setVisible(true);
        }
        if(ae.getSource() == dbtn){
            sdate=LocalDate.now().toString();
            date.setText(sdate);
        }
    }
}
