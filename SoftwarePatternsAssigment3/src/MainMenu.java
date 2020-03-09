
import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.text.MaskFormatter;

import java.util.ArrayList; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainMenu extends Menu{
	
	MainMenu(){
		menuStart();
	}
	
	
	
	public void menuStart(){
		   /*The menuStart method asks the user if they are a new customer, an existing customer or an admin. It will then start the create customer process
		  if they are a new customer, or will ask them to log in if they are an existing customer or admin.*/
			frame1 = new JFrame("User Type");
			frame1.setSize(400, 300);
			frame1.setLocation(200, 200);
			frame1.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) { System.exit(0); }
			});

			JPanel userTypePanel = new JPanel();
			final ButtonGroup userType = new ButtonGroup();
			JRadioButton radioButton;
			userTypePanel.add(radioButton = new JRadioButton("Existing Customer"));
			radioButton.setActionCommand("Customer");
			userType.add(radioButton);
			
			userTypePanel.add(radioButton = new JRadioButton("Administrator"));
			radioButton.setActionCommand("Administrator");
			userType.add(radioButton);
			
			userTypePanel.add(radioButton = new JRadioButton("New Customer"));
			radioButton.setActionCommand("New Customer");
			userType.add(radioButton);

			JPanel continuePanel = new JPanel();
			JButton continueButton = new JButton("Continue");
			continuePanel.add(continueButton);

			Container content = frame1.getContentPane();
			content.setLayout(new GridLayout(2, 1));
			content.add(userTypePanel);
			content.add(continuePanel);



			continueButton.addActionListener(new ActionListener(  ) {
				public void actionPerformed(ActionEvent ae) {
					String user = userType.getSelection().getActionCommand(  );
					
					//if user selects NEW CUSTOMER--------------------------------------------------------------------------------------
					if(user.equals("New Customer"))
					{
						newCustomerFrame();
					}
					
					
					//------------------------------------------------------------------------------------------------------------------
					
					//if user select ADMIN----------------------------------------------------------------------------------------------
					if(user.equals("Administrator")	)
					{
						new AdminMenu();
						}
					//----------------------------------------------------------------------------------------------------------------
					
					
					
					//if user selects CUSTOMER ---------------------------------------------------------------------------------------- 
					if(user.equals("Customer")	)
					{
						new CustomerMenu();}
					//-----------------------------------------------------------------------------------------------------------------------
				}

				

				

				
			});frame1.setVisible(true);	
	}
	public void newCustomerFrame() {

		frame1.dispose();		
		frame2 = new JFrame("Create New Customer");
		frame2.setSize(400, 300);
		frame2.setLocation(200, 200);
		frame2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});
			Container content = frame2.getContentPane();
			content.setLayout(new BorderLayout());
			
			firstNameLabel = new JLabel("First Name:", SwingConstants.RIGHT);
			surnameLabel = new JLabel("Surname:", SwingConstants.RIGHT);
			pPPSLabel = new JLabel("PPS Number:", SwingConstants.RIGHT);
			dOBLabel = new JLabel("Date of birth", SwingConstants.RIGHT);
			firstNameTextField = new JTextField(20);
			surnameTextField = new JTextField(20);
			pPSTextField = new JTextField(20);
			dOBTextField = new JTextField(20);
			JPanel panel = new JPanel(new GridLayout(6, 2));
			panel.add(firstNameLabel);
			panel.add(firstNameTextField);
			panel.add(surnameLabel);
			panel.add(surnameTextField);
			panel.add(pPPSLabel);
			panel.add(pPSTextField);
			panel.add(dOBLabel);
			panel.add(dOBTextField);
				
			panel2 = new JPanel();
			add = new JButton("Add");
			
			 add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
					
		PPS = pPSTextField.getText();
		firstName = firstNameTextField.getText();
		surname = surnameTextField.getText();
		DOB = dOBTextField.getText();
		password = "";
	
		CustomerID = "ID"+PPS ;
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				
				boolean loop = true;
				while(loop){
				 password = JOptionPane.showInputDialog(frame1, "Enter 7 character Password;");
				
				 if(password.length() != 7)//Making sure password is 7 characters
				    {
				    	JOptionPane.showMessageDialog(null, null, "Password must be 7 charatcers long", JOptionPane.OK_OPTION);
				    }
				 else
				 {
					 loop = false;
				 }
				}
				
			    ArrayList<CustomerAccount> accounts = new ArrayList<CustomerAccount> ();
						Customer customer = new Customer(PPS, surname, firstName, DOB, CustomerID, password, accounts);
							
						customerList.add(customer);
					
						JOptionPane.showMessageDialog(frame1, "CustomerID = " + CustomerID +"\n Password = " + password  ,"Customer created.",  JOptionPane.INFORMATION_MESSAGE);
						menuStart();
					frame1.dispose();
			}
		});	
				}
			});						
			JButton cancel = new JButton("Cancel");					
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame2.dispose();
					menuStart();
				}
			});	
			
			panel2.add(add);
			panel2.add(cancel);
			
			content.add(panel, BorderLayout.CENTER);
			content.add(panel2, BorderLayout.SOUTH);
	
			frame2.setVisible(true);		
		
	
		
	}
	    
	    
	    
	
	
	

}

