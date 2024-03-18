package bakerrrr;
import java.awt.Dimension;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.*;
	import java.util.Vector;
	import javax.swing.*;

	public class SetDataBase  extends JFrame{
	protected static final String n1 = null;
	JButton back;
	JPanel fp;	
	JTable jt;
	Vector coulmnNames,data;

	Connection con;
	 Order o1;
		public SetDataBase(Order o1,String cmd) 
		{ 	this.o1=o1;
		connectDatabase();
		if(cmd.equals("insert")) {
		insert();
		readData();
		init();
		}
		else if(cmd.equals("delete")) {
			delete();
			readData();
			init();
		}

		else if(cmd.equals("deleteall")) {
			deleteall();
			init();
		}
		setSize(500,450);
		}
		
		
		public void connectDatabase()  {
		
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			System.out.println("Drivers found");		
			} 
			catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				con=DriverManager.getConnection( "jdbc:ucanaccess://C:\\Users\\sadaf\\Documents\\MyBakery.accdb" ) ;
				System.out.println("Database found");			

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		public void delete() {
			String query ="delete from order where ID=?";
				
			try {
				PreparedStatement pst=con.prepareStatement(query);
				
				pst.setInt(1,o1.getID());	
				pst.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
		}
		
		public void insert() {
			String query ="insert into order"
					+ "(ItemName, Price, Quantity, Weight, TotalBill, Date) "
					+ " values (?,?,?,?,?,?)";
			try {
				PreparedStatement pst=con.prepareStatement(query);

				pst.setString(1,o1.getName());
				pst.setDouble(2, o1.getPrice());
				pst.setInt(3,o1.getQuantity());
				pst.setString(4 ,o1.getWeight());
				pst.setDouble(5 ,o1.getTtl_bil());
				pst.setString(6 ,o1.getDate());
				
				pst.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
		}	
		public void deleteall(){
			Statement stmt;
			try{
					stmt = con.createStatement();
					String query = "Delete from order";
					int deletedRows=stmt.executeUpdate(query);
					if(deletedRows>0){
			
						JOptionPane.showMessageDialog(null,"Deleted All Rows In The Table ","Succesfully", JOptionPane.INFORMATION_MESSAGE, null); 
					 	
					   }else{
						   JOptionPane.showMessageDialog(null,"Table Already ","Succesfully", JOptionPane.INFORMATION_MESSAGE, null); 
						 	  }
									
				   } catch(SQLException s){	
					   JOptionPane.showMessageDialog(null,"Delete all rows from table  ","error", JOptionPane.INFORMATION_MESSAGE, null); 
					 	 
						s.printStackTrace();
					 }
				}
		
	

		public void readData() {
			String s="select * from order";
			Statement st;
			try {
				st = con.createStatement();
				ResultSet rs=st.executeQuery(s);
				ResultSetMetaData md= rs.getMetaData();
				
				data=new Vector();
				coulmnNames=new Vector();
				
				for (int i=1;i<=md.getColumnCount();i++) {
				coulmnNames.add(md.getColumnName(i));
				System.out.println(md.getColumnName(i));
				}

				while(rs.next()) {
					Integer ID=rs.getInt("ID");
					String name=rs.getString("ItemName");
					Double price=rs.getDouble("Price");
					Integer quantity=rs.getInt("Quantity");
					String weight=rs.getString("Weight");
					Double ttl_bil=rs.getDouble("TotalBill");
					String date=rs.getString("Date");
					
					
					Vector row=new Vector();
					row.addElement(ID);
					row.addElement(name);
					row.addElement(price);
					row.addElement(quantity);
					row.addElement(weight);
					row.addElement(ttl_bil);
					row.addElement(date);
					
					data.add(row);
					
				}
				System.out.println(data.toString());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
			public void init() {
			this.getContentPane().removeAll();
			fp=new JPanel();
			back=new JButton("Back");
			jt=new JTable(data,coulmnNames);
			
			
			back.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					QuantityOfItems sf=new QuantityOfItems();
					
					sf.setVisible(true);
					setVisible(false);
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}});
			fp.add(back);
			Dimension d = new Dimension(data.size()*95,6*8 );
			jt.setPreferredScrollableViewportSize( d );
			
			JScrollPane jsp=new JScrollPane(jt);
			
			fp.add(jsp);
			
			this.getContentPane().add(fp);
			pack();
		}
	

	}
