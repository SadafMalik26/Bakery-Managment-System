package bakerrrr;

	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.*;
import javax.swing.border.Border;

	class Selectitem extends JFrame{

 	 	Border border=BorderFactory.createLineBorder(Color.cyan,4); 
	JButton pstry_btn,brd_btn; 
	Selectitem(){
	setSize(500,450); 
	setResizable(false); 
	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);  
	setTitle("Select Your Fvrt One");
	
    //design for Pastry Btn
	pstry_btn=new JButton("Pastry"); 
	pstry_btn.setBounds(200, 130, 100, 60);
	pstry_btn.setFocusPainted(false);
	pstry_btn.setFont(new Font("Calibri", Font.PLAIN, 22));
	
	//design for bread btn
	brd_btn=new JButton("Bread");
	brd_btn.setFocusPainted(false);
	brd_btn.setFont(new Font("Calibri", Font.PLAIN, 22));
	brd_btn.setBounds(200, 230, 100, 60);

	//panel its design and its items data
	 
	JPanel slction_panel=new JPanel();
	slction_panel.setLayout(null);
	slction_panel.setBackground(Color.white);  
	slction_panel.setOpaque(true);  	 
	slction_panel.setBorder(border); 
	

	//after pressing pastry btn get entry into next frame for getting prices 
	slction_panel.add(pstry_btn);
	pstry_btn.addActionListener(new ActionListener() {  	 
	public void actionPerformed(ActionEvent evt) {
		QuantityOfItems pf=new QuantityOfItems("Choclate p","Pineapple p","40","80","2pound","4pound");
	pf.setVisible(true);
	setVisible(false);
	}
	});
	

	//after pressing bread btn get entry into next frame for getting prices 
	slction_panel.add(brd_btn);
	brd_btn.addActionListener(new ActionListener() {  	 	 	
	public void actionPerformed(ActionEvent evt) {
	QuantityOfItems pf=new QuantityOfItems("brown b","white b","60","90","Small","Large"); 	  	 	 
	pf.setVisible(true);
	setVisible(false);
	}
	});
	//adding panel into frame
	getContentPane().add(slction_panel);}

	}




