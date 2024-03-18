package bakerrrr;
import java.awt.*;
import java.awt.event.*; 
 import javax.swing.*;
import javax.swing.border.Border; 

public class Login extends JFrame{
	 	Login(){ 
	 	 	Border border=BorderFactory.createLineBorder(Color.cyan,4); 
	 	 	this.setSize(450,500);  
	 	 	this.setTitle("Welcome To Bakery ");  	 
	 	 	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	 	 	ImageIcon image=new ImageIcon("c2.jpeg"); 
	        JLabel lb=new JLabel();
	 	 	lb.setFont(new Font("Arial",Font.BOLD,40));  
	 	 	lb.setHorizontalTextPosition(lb.CENTER);  	 	
	 	 	lb.setVerticalTextPosition(SwingConstants.BOTTOM); 
	 	 	lb.setForeground(Color.cyan); 
	 	 	 
	 	 	lb.setIcon(image);  	 
	 	 	lb.setBounds(100,20,250,200);  
	 	 	JLabel user=new JLabel("User Name");  	 
	 	 	user.setBounds(80,250,170,20);  	 	
	 	 	JLabel pass=new JLabel("Password");  	 	
	 	 	pass.setBounds(80,300,170,20);  	 
	 	 	JTextField txt=new JTextField(20);  	 
	 	 	txt.setBounds(160,250,170,20); 
	 	 	JPasswordField password=new JPasswordField();  	 
	 	 	password.setBounds(160,300,170,20);  	 	
	 	 	JButton bt=new JButton("Login");  	 	
	 	 	bt.setFont(new Font("Arial",Font.BOLD,12)); 
	 	 	bt.setBounds(170,340,100,30);  
            bt.setFocusable(false); 
	 	 	bt.addActionListener(new ActionListener() { 
	 
	 	 		public void actionPerformed(ActionEvent e) {  
	if(txt.getText().equals("sadaf")&&(password.getText().equals("321"))){ 
		JOptionPane.showMessageDialog(null,"Login Successfully","Confirmation",JOptionPane.INFORMATION_MESSAGE); 
	 	 	 	 	Selectitem si=new Selectitem();
	 	 	 	 	si.setVisible(true);
	 	 	 	     setVisible(false);
	 	 	 	 	
	}  
	 	 	 	 	else  
	 	 	 	 	{ 
	 	JOptionPane.showMessageDialog(null,"Error","Confirmation",JOptionPane.WARNING_MESSAGE); 
	 	 	 	 	} 
	 	 	 	 	 
	 	 	}
	 	 	 	 
	 	 	}); 
	 	 	JPanel p1=new JPanel();  	 
	 	 	p1.setLayout(null);  	 	
	 	 	p1.setBackground(Color.white);  
	 	 	p1.setOpaque(true);  	 
	 	 	p1.setBorder(border);  	 	
	 	 	p1.add(lb);  	 
	 	 	p1.add(user);  	 
	 	 	p1.add(pass);  	 	
	 	 	p1.add(txt);  	 
	 	 	p1.add(password);  	 
	 	 	p1.add(bt);  	 
	 	 	this.getContentPane().add(p1); 
	 	 	this.setVisible(true); 
	 	} 
	 
	 	public static void main(String[] args) { 
	 	 	// TODO Auto-generated method stub  	 	
	 		new Login(); 
	 	} 
	 
	} 
