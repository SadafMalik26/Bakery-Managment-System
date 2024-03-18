package bakerrrr;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
import javax.swing.border.Border;

	class Order{
		int ID;
		private String name;
		private double price;
		private int quantity;
		private String weight;
		private double  ttl_bil;
		public double bttl_bil;
		public String date;

		Order(int ID,String name,double price,int quantity,String weight,double ttl_bil,String date){
			this.name = name;
			this.price = price;
			this.quantity = quantity;
			this.weight = weight;
			this.ttl_bil = ttl_bil;
			this.setID(ID);
            this.date=date;
		}
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getWeight() {
			return weight;
		}
		public void setWeight(String weight) {
			this.weight = weight;
		}
		public double getTtl_bil() {
			return ttl_bil;
		}
		public void setTtl_bil(double ttl_bil) {
			this.ttl_bil = ttl_bil;
		}
		

		public String getDate() {
			return date;
		}


		public void setDate(String date) {

			this.date=date;
		}

	}
		public class QuantityOfItems extends JFrame {
			
	 	 	Border border=BorderFactory.createLineBorder(Color.cyan,4); 
			String bname,bdate;
			double bprice;
			int bquantity=1,bID=1;
			String bweight;
			double bttl_bil=0.0;
			JLabel price1_lbl,price2_lbl;
			JButton option2_btn,option1_btn,back,calculate,history_btn,delbtn,delall_btn;
			JRadioButton small,large;
			ButtonGroup b4;
			JPanel Panel_PB;
			JTable jt;
			QuantityOfItems(){ShowBill();}
			//new QuantityOfItems("option a","option b","price of a","price of b","weigh of a","weight of b ");
			//e,g new QuantityOfItems("Choclate","RedValvet","40","80","2pound","4pound");
			public  QuantityOfItems(String a,String b,String n1,String n2,String p1,String p2){
			setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			setTitle("Select Quantity");
			setSize(500,450);
			setResizable(false);

			Panel_PB=new JPanel();
		  	 
			Panel_PB.setLayout(null);  	 	
			Panel_PB.setBackground(Color.white);  
			Panel_PB.setOpaque(true);  	 
			Panel_PB.setBorder(border);
            //set  design for option a
			option1_btn=new JButton(a);   
			option1_btn.setBounds(80,30,200,40);
			option1_btn.setFocusPainted(false);
			option1_btn.setFont(new Font("Calibri", Font.PLAIN, 22));
			price1_lbl=new JLabel(n1);
			price1_lbl.setBounds(330,30,80,40);
			price1_lbl.setFont(new Font("Calibri", Font.PLAIN, 22));
			Panel_PB.add(option1_btn);
			Panel_PB.add(price1_lbl);
			//if option one selected then
			option1_btn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent evt) {
			bname=option1_btn.getText();	}
			});

			
			//b=weight
			option2_btn=new JButton(b);
			option2_btn.setBounds(80,80,200,40);
			option2_btn.setFocusPainted(false);
			option2_btn.setFont(new Font("Calibri", Font.PLAIN, 22));
			price2_lbl=new JLabel(n2); 
			price2_lbl.setBounds(330,80,80,40);
			price2_lbl.setFont(new Font("Calibri", Font.PLAIN, 22));
			Panel_PB.add(option2_btn);
			Panel_PB.add(price2_lbl);
			option2_btn.addActionListener(new ActionListener() {  	 
			public void actionPerformed(ActionEvent evt) {
			bname=option2_btn.getText();}
			}); 	
			//weight or pounds of item
			radiobutton(p1,p2);
			
			//Return btn design
			back=new JButton("Return");
			back.setBounds(140, 330, 150, 40);
			back.setFont(new Font("Calibri", Font.PLAIN, 24));
			Panel_PB.add(back);
			// action on btn
			back.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent evt) {  
			Selectitem pb=new Selectitem();   	 	
			pb.setVisible(true);
			setVisible(false);}
			});

			//design for calculate bill btn
			calculate=new JButton("Genrate Bill");
			calculate.setBounds(130, 260, 200, 40);
			calculate.setFont(new Font("Calibri", Font.PLAIN, 24));
			Panel_PB.add(calculate);
			//action on bill btn
			calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			if (small.isSelected()) {
			String s= JOptionPane.showInputDialog("Enter Quantity ");
			bquantity = Integer.parseInt(s);
			bprice=Integer.parseInt(n1);
			bweight=p1;}

			else if (large.isSelected()) {
			String test3= JOptionPane.showInputDialog("Enter Quantity ");
			bquantity = Integer.parseInt(test3);
			bprice=Integer.parseInt(n2);           
			bweight=p2;}

			else {
			JOptionPane.showMessageDialog(QuantityOfItems.this, "No Selection Yet !");}
			
			bttl_bil=bprice*bquantity;
			ShowBill();}
			});


}

			public void radiobutton(String p1,String p2) {
		
			small = new JRadioButton(p1);
			small.setBounds(140, 170, 80, 40);
			large = new JRadioButton(p2);  	
			large.setBounds(220, 170, 80, 40);
			b4 = new ButtonGroup();   	
			b4.add(small);  	 	
			b4.add(large);
			Panel_PB.add(large);
			Panel_PB.add(small);

getContentPane().add(Panel_PB);}
			
			public void ShowBill() {
				JPanel billpanel=new JPanel();
				setSize(500,450);
				setResizable(false);
				billpanel.setLayout(null);  	 	
				billpanel.setBackground(Color.white);  
				billpanel.setOpaque(true);  	 
				billpanel.setBorder(border);
				JTextArea bills=new JTextArea(tostring(),20,20);  
				bills.setBounds(30, 30, 350, 200); 	 
				bills.setBackground(Color.cyan);
				JButton j=new JButton("Return"); 
				j.setBounds(80, 330, 150, 40); 
				history_btn=new JButton ("Save and Show History");
				history_btn.setBounds(80, 250, 170, 40);
				delbtn=new JButton("Delete  ");
				delbtn.setBounds(300, 330, 100, 40);
				delall_btn=new JButton("Delete All History ");
				delall_btn.setBounds(280, 250, 170, 40);
				billpanel.add(bills);
				billpanel.add(history_btn);
				billpanel.add(delbtn);
				billpanel.add(delall_btn);
				billpanel.add(j);
				j.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
				Selectitem su=new Selectitem(); 	  	 	 	
				su.setVisible(true);
				setVisible(false);}
				});
				setContentPane(billpanel); 
				setVisible(true);
				Actionn();}
			
		  public  String Date() {
			       DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			       Date today = new Date();
				return bdate=(today.toString());
                 }
				
				public String tostring() {
				return "\n\tName: " +bname+"\n\tPrice: " +bprice+"\n\tQuantity: " +bquantity+"\n\tWeight:" +bweight+"\n\tDate :"+Date()+"\n\tTotal Bill: " +bttl_bil;
				}
                
		
			public void Actionn() {
			history_btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					Order o1=new Order(bID,bname,bprice,bquantity,bweight,bttl_bil,Date());
					SetDataBase db=new SetDataBase(o1,"insert");
					db.setVisible(true);
					setVisible(false);
								
				}

			});
			
			delbtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Order o1=new Order(bID," ",0,0," ",0," ");
					
					SetDataBase sf=new SetDataBase(o1,"delete");
					sf.setVisible(true);
					setVisible(false);			
				}
				
			});
			delall_btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					Order o1=new Order(0,"",0,0,"",0,"");
					SetDataBase db=new SetDataBase(o1,"deleteall");
					db.setVisible(true);
					setVisible(false);
								
				}

			});
			}

		}
