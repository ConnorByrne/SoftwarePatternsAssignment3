import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AdminMenu extends Menu {
	
	AdminMenu(){
		adminLogon();
	}
	
	public void adminLogon() {

		boolean loop = true, loop2 = true;
		boolean cont = false;
	    while(loop)
	    {
	    Object adminUsername = JOptionPane.showInputDialog(frame1, "Enter Administrator Username:");

	    if(!adminUsername.equals("admin"))//search admin list for admin with matching admin username
	    {
	    	int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Username. Try again?", JOptionPane.YES_NO_OPTION);
	    	if (reply == JOptionPane.YES_OPTION) {
	    		loop = true;
	    	}
	    	else if(reply == JOptionPane.NO_OPTION)
	    	{
	    		frame2.dispose();
	    		loop = false;
	    		loop2 = false;
	    		new MainMenu();
	    	}
	    }
	    else
	    {
	    	loop = false;
	    }				    
	    }
	    
	    while(loop2)
	    {
	    	Object adminPassword = JOptionPane.showInputDialog(frame1, "Enter Administrator Password;");
	    	
	    	   if(!adminPassword.equals("admin11"))//search admin list for admin with matching admin password
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Password. Try again?", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		
			    	}
			    	else if(reply == JOptionPane.NO_OPTION){
			    		frame2.dispose();
			    		loop2 = false;
			    		new MainMenu();
			    	}
			    }
	    	   else
	    	   {
	    		   loop2 =false;
	    		   cont = true;
	    	   }
	    }
	    	
	    if(cont)
	    {
		frame2.dispose();
	    	loop = false;
	    admin();					    
	    }					    
	
		
	}
	
	public void admin(){
		frame1 = new JFrame("Administrator Menu");
		frame1.setSize(400, 400);
		frame1.setLocation(200, 200);
		frame1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});          
		frame1.setVisible(true);
		
		JPanel deleteCustomerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton deleteCustomer = new JButton("Delete Customer");	
		deleteCustomer.setPreferredSize(new Dimension(250, 20));
		deleteCustomerPanel.add(deleteCustomer);
		
		JPanel deleteAccountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton deleteAccount = new JButton("Delete Account");
		deleteAccount.setPreferredSize(new Dimension(250, 20));	
		deleteAccountPanel.add(deleteAccount);
		
		JPanel bankChargesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton bankChargesButton = new JButton("Apply Bank Charges");
		bankChargesButton.setPreferredSize(new Dimension(250, 20));	
		bankChargesPanel.add(bankChargesButton);
		
		JPanel interestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton interestButton = new JButton("Apply Interest");
		interestPanel.add(interestButton);
		interestButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel editCustomerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton editCustomerButton = new JButton("Edit existing Customer");
		editCustomerPanel.add(editCustomerButton);
		editCustomerButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel navigatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton navigateButton = new JButton("Navigate Customer Collection");
		navigatePanel.add(navigateButton);
		navigateButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton summaryButton = new JButton("Display Summary Of All Accounts");
		summaryPanel.add(summaryButton);
		summaryButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel accountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton accountButton = new JButton("Add an Account to a Customer");
		accountPanel.add(accountButton);
		accountButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton returnButton = new JButton("Exit Admin Menu");
		returnPanel.add(returnButton);

		JLabel label1 = new JLabel("Please select an option");
		
		content = frame1.getContentPane();
		content.setLayout(new GridLayout(9, 1));
		content.add(label1);
		content.add(accountPanel);
		content.add(bankChargesPanel);
		content.add(interestPanel);
		content.add(editCustomerPanel);
		content.add(navigatePanel);
		content.add(summaryPanel);	
		content.add(deleteCustomerPanel);
		content.add(returnPanel);
		
		
		bankChargesButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				bankCharges();
				}
			}		
	     );
		
		interestButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				interestButton();
			}	
	     });
		
		editCustomerButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				editCustomer();
			}
	     });
		
		summaryButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) { summary();}	
	     });
		
		navigateButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				navigate();
			}
		});
		
		accountButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				account();}
	     });		

		deleteCustomer.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				deleteCustomer();
			}
	     });		
		
		deleteAccount.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				deleteAccount();
			}
			
	     });		
		returnButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				frame1.dispose();
				new MainMenu();				
			}
	     });		
	}
	
	protected void deleteAccount() {

		boolean found = true;
						 {
							    Object customerID = JOptionPane.showInputDialog(frame1, "Customer ID of Customer from which you wish to delete an account");
							    
							    for (Customer aCustomer: customerList){
							    	
							    	if(aCustomer.getCustomerID().equals(customerID))
							    	{
							    		found = true;
							    		customer = aCustomer; 
							    		break;
							    	}					    	
							    }
							    
							    if(found == false)
							    {
							    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
							    	if (reply == JOptionPane.NO_OPTION) {
							    		frame1.dispose();
							    		admin();
							    	}
							    }  
							    else
							    {
							    	//Here I would make the user select a an account to delete from a combo box. If the account had a balance of 0 then it would be deleted. (I do not have time to do this)
							    }
							    
							    
					}
		
	}



	protected void deleteCustomer() {

		boolean found = true;
		
		if(customerList.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
			dispose();
			admin();
		}
		else
		{
			 {
				    Object customerID = JOptionPane.showInputDialog(frame1, "Customer ID of Customer You Wish to Delete:");
				    
				    for (Customer aCustomer: customerList){
				    	
				    	if(aCustomer.getCustomerID().equals(customerID))
				    	{
				    		found = true;
				    		customer = aCustomer; 
				    		break;
				    	}					    	
				    }
				    
				    if(found == false)
				    {
				    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
				    	if (reply == JOptionPane.NO_OPTION) {
				    		frame1.dispose();
				    		admin();
				    	}
				    }  
				    else
				    {
				    	if(customer.getAccounts().size()>0)
				    	{
				    		JOptionPane.showMessageDialog(frame1, "This customer has accounts. \n You must delete a customer's accounts before deleting a customer " ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
				    	}
				    	else
				    	{
				    		customerList.remove(customer);
				    		JOptionPane.showMessageDialog(frame1, "Customer Deleted " ,"Success.",  JOptionPane.INFORMATION_MESSAGE);
				    	}
				    }
				    
				    
		}}
	
		
	}



	protected void account() {

		frame1.dispose();
		
		if(customerList.isEmpty())
		{
			JOptionPane.showMessageDialog(frame1, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
			frame1.dispose();
			admin();
		}
		else
		{
		boolean loop = true;
		
		boolean found = false;
	
	    while(loop)
	    {
	    Object customerID = JOptionPane.showInputDialog(frame1, "Customer ID of Customer You Wish to Add an Account to:");
	    
	    for (Customer aCustomer: customerList){
	    	
	    	if(aCustomer.getCustomerID().equals(customerID))
	    	{
	    		found = true;
	    		customer = aCustomer; 	
	    	}					    	
	    }
	    
	    if(found == false)
	    {
	    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
	    	if (reply == JOptionPane.YES_OPTION) {
	    		loop = true;
	    	}
	    	else if(reply == JOptionPane.NO_OPTION)
	    	{
	    		frame1.dispose();
	    		loop = false;
	    	
	    		admin();
	    	}
	    }
	    else
	    {
	    	loop = false;
	    	//a combo box in an dialog box that asks the admin what type of account they wish to create (deposit/current)
		    String[] choices = { "Current Account", "Deposit Account" };
		    String account = (String) JOptionPane.showInputDialog(null, "Please choose account type",
		        "Account Type", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]); 
		    
		    if(account.equals("Current Account"))
		    {
		    	//create current account
		    	boolean valid = true;
		    	double balance = 0;
		    	String number = String.valueOf("C" + (customerList.indexOf(customer)+1) * 10 + (customer.getAccounts().size()+1));//this simple algorithm generates the account number
		    	ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
		    	int randomPIN = (int)(Math.random()*9000)+1000;
		           String pin = String.valueOf(randomPIN);
		    
		           ATMCard atm = new ATMCard(randomPIN, valid);
		    	
		    	CustomerCurrentAccount current = new CustomerCurrentAccount(atm, number, balance, transactionList);
		    	
		    	customer.getAccounts().add(current);
		    	JOptionPane.showMessageDialog(frame1, "Account number = " + number +"\n PIN = " + pin  ,"Account created.",  JOptionPane.INFORMATION_MESSAGE);
		    	
		    	frame1.dispose();
		    	admin();
		    }
		    
		    if(account.equals("Deposit Account"))
		    {
		    	//create deposit account
		    	
		    	double balance = 0, interest = 0;
		    	String number = String.valueOf("D" + (customerList.indexOf(customer)+1) * 10 + (customer.getAccounts().size()+1));//this simple algorithm generates the account number
		    	ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
		        	
		    	CustomerDepositAccount deposit = new CustomerDepositAccount(interest, number, balance, transactionList);
		    	
		    	customer.getAccounts().add(deposit);
		    	JOptionPane.showMessageDialog(frame1, "Account number = " + number ,"Account created.",  JOptionPane.INFORMATION_MESSAGE);
		    	
		    	frame1.dispose();
		    	admin();
		    }
	    
	    }			   
	    }
		}
	
		
	}



	protected void navigate() {

		frame1.dispose();
		
		if(customerList.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
			admin();
		}
		else
		{

		JButton first, previous, next, last, cancel;
		JPanel gridPanel, buttonPanel, cancelPanel;			

		Container content = getContentPane();
		
		content.setLayout(new BorderLayout());
		
		buttonPanel = new JPanel();
		gridPanel = new JPanel(new GridLayout(8, 2));
		cancelPanel = new JPanel();
						
		firstNameLabel = new JLabel("First Name:", SwingConstants.LEFT);
		surnameLabel = new JLabel("Surname:", SwingConstants.LEFT);
		pPPSLabel = new JLabel("PPS Number:", SwingConstants.LEFT);
		dOBLabel = new JLabel("Date of birth", SwingConstants.LEFT);
		customerIDLabel = new JLabel("CustomerID:", SwingConstants.LEFT);
		passwordLabel = new JLabel("Password:", SwingConstants.LEFT);
		firstNameTextField = new JTextField(20);
		surnameTextField = new JTextField(20);
		pPSTextField = new JTextField(20);
		dOBTextField = new JTextField(20);
		customerIDTextField = new JTextField(20);
		passwordTextField = new JTextField(20);
		
		first = new JButton("First");
		previous = new JButton("Previous");
		next = new JButton("Next");
		last = new JButton("Last");
		cancel = new JButton("Cancel");
		
		firstNameTextField.setText(customerList.get(0).getFirstName());
		surnameTextField.setText(customerList.get(0).getSurname());
		pPSTextField.setText(customerList.get(0).getPPS());
		dOBTextField.setText(customerList.get(0).getDOB());
		customerIDTextField.setText(customerList.get(0).getCustomerID());
		passwordTextField.setText(customerList.get(0).getPassword());
		
		firstNameTextField.setEditable(false);
		surnameTextField.setEditable(false);
		pPSTextField.setEditable(false);
		dOBTextField.setEditable(false);
		customerIDTextField.setEditable(false);
		passwordTextField.setEditable(false);
		
		gridPanel.add(firstNameLabel);
		gridPanel.add(firstNameTextField);
		gridPanel.add(surnameLabel);
		gridPanel.add(surnameTextField);
		gridPanel.add(pPPSLabel);
		gridPanel.add(pPSTextField);
		gridPanel.add(dOBLabel);
		gridPanel.add(dOBTextField);
		gridPanel.add(customerIDLabel);
		gridPanel.add(customerIDTextField);
		gridPanel.add(passwordLabel);
		gridPanel.add(passwordTextField);
		
		buttonPanel.add(first);
		buttonPanel.add(previous);
		buttonPanel.add(next);
		buttonPanel.add(last);
		
		cancelPanel.add(cancel);

		content.add(gridPanel, BorderLayout.NORTH);
		content.add(buttonPanel, BorderLayout.CENTER);
		content.add(cancelPanel, BorderLayout.AFTER_LAST_LINE);
		first.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				position = 0;
				firstNameTextField.setText(customerList.get(0).getFirstName());
				surnameTextField.setText(customerList.get(0).getSurname());
				pPSTextField.setText(customerList.get(0).getPPS());
				dOBTextField.setText(customerList.get(0).getDOB());
				customerIDTextField.setText(customerList.get(0).getCustomerID());
				passwordTextField.setText(customerList.get(0).getPassword());				
					}		
			     });
		
		previous.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
						
				if(position < 1)
				{
					//don't do anything
				}
				else
				{
					position = position - 1;
					
				firstNameTextField.setText(customerList.get(position).getFirstName());
				surnameTextField.setText(customerList.get(position).getSurname());
				pPSTextField.setText(customerList.get(position).getPPS());
				dOBTextField.setText(customerList.get(position).getDOB());
				customerIDTextField.setText(customerList.get(position).getCustomerID());
				passwordTextField.setText(customerList.get(position).getPassword());
				}			
					}		
			     });
		
		next.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
			
				if(position == customerList.size()-1)
				{
					//don't do anything
				}
				else
				{
					position = position + 1;
					
				firstNameTextField.setText(customerList.get(position).getFirstName());
				surnameTextField.setText(customerList.get(position).getSurname());
				pPSTextField.setText(customerList.get(position).getPPS());
				dOBTextField.setText(customerList.get(position).getDOB());
				customerIDTextField.setText(customerList.get(position).getCustomerID());
				passwordTextField.setText(customerList.get(position).getPassword());
				}		
				
				
										
					}		
			     });
		
		last.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
			
				position = customerList.size() - 1;
		
				firstNameTextField.setText(customerList.get(position).getFirstName());
				surnameTextField.setText(customerList.get(position).getSurname());
				pPSTextField.setText(customerList.get(position).getPPS());
				dOBTextField.setText(customerList.get(position).getDOB());
				customerIDTextField.setText(customerList.get(position).getCustomerID());
				passwordTextField.setText(customerList.get(position).getPassword());								
					}		
			     });
		
		cancel.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {				
				dispose();
				admin();
					}		
			     });			
		setContentPane(content);
		setSize(400, 300);
	       setVisible(true);
			}		
	
		
	}



	protected void summary() {

		frame1.dispose();
		
		
		frame1 = new JFrame("Summary of Transactions");
		frame1.setSize(400, 700);
		frame1.setLocation(200, 200);
		frame1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});          
		frame1.setVisible(true);
		
		JLabel label1 = new JLabel("Summary of all transactions: ");
		
		JPanel returnPanel = new JPanel();
		JButton returnButton = new JButton("Return");
		returnPanel.add(returnButton);
		
		JPanel textPanel = new JPanel();
		
		textPanel.setLayout( new BorderLayout() );
		JTextArea textArea = new JTextArea(40, 20);
		textArea.setEditable(false);
		textPanel.add(label1, BorderLayout.NORTH);
		textPanel.add(textArea, BorderLayout.CENTER);
		textPanel.add(returnButton, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		textPanel.add(scrollPane);
		
	for (int a = 0; a < customerList.size(); a++)//For each customer, for each account, it displays each transaction.
		{
			for (int b = 0; b < customerList.get(a).getAccounts().size(); b ++ )
			{
				acc = customerList.get(a).getAccounts().get(b);
				for (int c = 0; c < customerList.get(a).getAccounts().get(b).getTransactionList().size(); c++)
				{
					
					textArea.append(acc.getTransactionList().get(c).toString());
					//Int total = acc.getTransactionList().get(c).getAmount(); //I was going to use this to keep a running total but I couldnt get it  working.
					
				}				
			}				
		}
		
		
		
		
		textPanel.add(textArea);
		content.removeAll();
		
		
		Container content = frame1.getContentPane();
		content.setLayout(new GridLayout(1, 1));
	//	content.add(label1);
		content.add(textPanel);
		//content.add(returnPanel);
		
		returnButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				frame1.dispose();			
			admin();				
			}		
	     });	
	
		
	}



	protected void editCustomer() {
		//boolean loop = true;
		boolean found = false;
	
		if(customerList.isEmpty())
		{
			JOptionPane.showMessageDialog(frame1, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
			frame1.dispose();
			admin();
			
		}
		else
		{
		
	    while(true)
	    {
	    Object customerID = JOptionPane.showInputDialog(frame1, "Enter Customer ID:");
	    
	    for (Customer aCustomer: customerList){
	    	
	    	if(aCustomer.getCustomerID().equals(customerID))
	    	{
	    		found = true;
	    		customer = aCustomer;
	    		break;
	    	}					    	
	    }
	    
	    if(found == false)
	    {
	    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
	    	if (reply == JOptionPane.NO_OPTION) {
	    		frame1.dispose();
	    		admin();
	    		break;
	    	}
	    }
	    else
	    {
	    	break;
	    }
	   
	    }
		
		frame1.dispose();
		
		frame1.dispose();
		frame1 = new JFrame("Administrator Menu");
		frame1.setSize(400, 300);
		frame1.setLocation(200, 200);
		frame1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});       
		
		firstNameLabel = new JLabel("First Name:", SwingConstants.LEFT);
		surnameLabel = new JLabel("Surname:", SwingConstants.LEFT);
		pPPSLabel = new JLabel("PPS Number:", SwingConstants.LEFT);
		dOBLabel = new JLabel("Date of birth", SwingConstants.LEFT);
		customerIDLabel = new JLabel("CustomerID:", SwingConstants.LEFT);
		passwordLabel = new JLabel("Password:", SwingConstants.LEFT);
		firstNameTextField = new JTextField(20);
		surnameTextField = new JTextField(20);
		pPSTextField = new JTextField(20);
		dOBTextField = new JTextField(20);
		customerIDTextField = new JTextField(20);
		passwordTextField = new JTextField(20);
		
		JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JPanel cancelPanel = new JPanel();
		
		textPanel.add(firstNameLabel);
		textPanel.add(firstNameTextField);
		textPanel.add(surnameLabel);
		textPanel.add(surnameTextField);
		textPanel.add(pPPSLabel);
		textPanel.add(pPSTextField);
		textPanel.add(dOBLabel);
		textPanel.add(dOBTextField);
		textPanel.add(customerIDLabel);
		textPanel.add(customerIDTextField);
		textPanel.add(passwordLabel);
		textPanel.add(passwordTextField);

		firstNameTextField.setText(customer.getFirstName());
		surnameTextField.setText(customer.getSurname());
		pPSTextField.setText(customer.getPPS());
		dOBTextField.setText(customer.getDOB());
		customerIDTextField.setText(customer.getCustomerID());
		passwordTextField.setText(customer.getPassword());	
		
		JButton saveButton = new JButton("Save");
		JButton cancelButton = new JButton("Exit");
		
		cancelPanel.add(cancelButton, BorderLayout.SOUTH);
		cancelPanel.add(saveButton, BorderLayout.SOUTH);

		Container content = frame1.getContentPane();
		content.setLayout(new GridLayout(2, 1));
		content.add(textPanel, BorderLayout.NORTH);
		content.add(cancelPanel, BorderLayout.SOUTH);
		
		frame1.setContentPane(content);
		frame1.setSize(340, 350);
		frame1.setLocation(200, 200);
		frame1.setVisible(true);
		frame1.setResizable(false);
		
		saveButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
			
				customer.setFirstName(firstNameTextField.getText());
				customer.setSurname(surnameTextField.getText());
				customer.setPPS(pPSTextField.getText());
				customer.setDOB(dOBTextField.getText());
				customer.setCustomerID(customerIDTextField.getText());
				customer.setPassword(passwordTextField.getText());		
				
				JOptionPane.showMessageDialog(null, "Changes Saved.");
					}		
			     });
		
		cancelButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				frame1.dispose();
				
				admin();				
			}		
	     });		
		}
		
	}



	protected void interestButton() {
		
		boolean found = false;
	
		if(customerList.isEmpty())
		{
			JOptionPane.showMessageDialog(frame1, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
			frame1.dispose();
			admin();
			
		}
		else
		{
	    while(true)
	    {
	    Object customerID = JOptionPane.showInputDialog(frame1, "Customer ID of Customer You Wish to Apply Interest to:");
	    
	    for (Customer aCustomer: customerList){
	    	
	    	if(aCustomer.getCustomerID().equals(customerID))
	    	{
	    		found = true;
	    		customer = aCustomer; 
	    		break;
	    	}					    	
	    }
	    
	    if(found == false)
	    {
	    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
	    	if (reply == JOptionPane.NO_OPTION) {
	    		frame1.dispose();
	    		admin();
	    		break;
	    	
	    		
	    	}
	    	
	    }  
	    else
	    {
	    	frame1.dispose();
	    	frame1 = new JFrame("Administrator Menu");
			frame1.setSize(400, 300);
			frame1.setLocation(200, 200);
			frame1.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) { System.exit(0); }
			});          
			frame1.setVisible(true);
		
		
		    JComboBox<String> box = new JComboBox<String>();
		    for (int i =0; i < customer.getAccounts().size(); i++)
		    {
		    	
		    	
		     box.addItem(customer.getAccounts().get(i).getNumber());
		    }
			
		    
		    box.getSelectedItem();
		
		    JPanel boxPanel = new JPanel();
			
			JLabel label = new JLabel("Select an account to apply interest to:");
			boxPanel.add(label);
			boxPanel.add(box);
			JPanel buttonPanel = new JPanel();
			JButton continueButton = new JButton("Apply Interest");
			JButton returnButton = new JButton("Return");
			buttonPanel.add(continueButton);
			buttonPanel.add(returnButton);
			Container content = frame1.getContentPane();
			content.setLayout(new GridLayout(2, 1));
			
			content.add(boxPanel);
			content.add(buttonPanel);
			
	
				if(customer.getAccounts().isEmpty())
				{
					JOptionPane.showMessageDialog(frame1, "This customer has no accounts! \n The admin must add acounts to this customer."   ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					frame1.dispose();
					admin();
				}
				else
				{
				
			for(int i = 0; i < customer.getAccounts().size(); i++)
		    {
		    	if(customer.getAccounts().get(i).getNumber() == box.getSelectedItem() )
		    	{
		    		acc = customer.getAccounts().get(i);
		    	}
		    }
								
			continueButton.addActionListener(new ActionListener(  ) {
				public void actionPerformed(ActionEvent ae) {
					String euro = "\u20ac";
				 	double interest = 0;
				 	boolean loop = true;
				 	
				 	while(loop)
				 	{
					String interestString = JOptionPane.showInputDialog(frame1, "Enter interest percentage you wish to apply: \n NOTE: Please enter a numerical value. (with no percentage sign) \n E.g: If you wish to apply 8% interest, enter '8'");//the isNumeric method tests to see if the string entered was numeric. 
					if(isNumeric(interestString))
					{
						
						interest = Double.parseDouble(interestString);
						loop = false;
						
						acc.setBalance(acc.getBalance() + (acc.getBalance() * (interest/100)));
						
						JOptionPane.showMessageDialog(frame1, interest + "% interest applied. \n new balance = " + acc.getBalance() + euro ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
					}
						
					
					else
					{
						JOptionPane.showMessageDialog(frame1, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				 	}
					
					frame1.dispose();				
				admin();				
				}		
		     });
			
			returnButton.addActionListener(new ActionListener(  ) {
				public void actionPerformed(ActionEvent ae) {
					frame1.dispose();		
					new MainMenu();				
				}
		     });	
			
				}
	    }
	    }
	    }
	    
	
		
	}
	
	public void bankCharges() {

		//boolean loop = true;
		
		boolean found = false;
	
		if(customerList.isEmpty())
		{
			JOptionPane.showMessageDialog(frame1, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
			frame1.dispose();
			admin();
			
		}
		else
		{
	    while(true)
	    {
	    Object customerID = JOptionPane.showInputDialog(frame1, "Customer ID of Customer You Wish to Apply Charges to:");
	    
	    for (Customer aCustomer: customerList){
	    	
	    	if(aCustomer.getCustomerID().equals(customerID))
	    	{
	    		found = true;
	    		customer = aCustomer; 
	    		break;
	    	}					    	
	    }
	    
	    if(found == false)
	    {
	    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
	    	if (reply == JOptionPane.NO_OPTION) {
	    		frame1.dispose();
	    		admin();
	    		break;
	    	}
	    	
	    }  
	    else
	    {
	    	frame1.dispose();
	    	frame1 = new JFrame("Administrator Menu");
			frame1.setSize(400, 300);
			frame1.setLocation(200, 200);
			frame1.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) { System.exit(0); }
			});          
			frame1.setVisible(true);
		
		
		    JComboBox<String> box = new JComboBox<String>();
		    for (int i =0; i < customer.getAccounts().size(); i++)
		    {
		    	
		    	
		     box.addItem(customer.getAccounts().get(i).getNumber());
		    }
			
		    
		    box.getSelectedItem();
		
		    JPanel boxPanel = new JPanel();
			boxPanel.add(box);
			
			JPanel buttonPanel = new JPanel();
			JButton continueButton = new JButton("Apply Charge");
			JButton returnButton = new JButton("Return");
			buttonPanel.add(continueButton);
			buttonPanel.add(returnButton);
			Container content = frame1.getContentPane();
			content.setLayout(new GridLayout(2, 1));
			
			content.add(boxPanel);
			content.add(buttonPanel);
			
	
				if(customer.getAccounts().isEmpty())
				{
					JOptionPane.showMessageDialog(frame1, "This customer has no accounts! \n The admin must add acounts to this customer."   ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					frame1.dispose();
					admin();
				}
				else
				{
				
			for(int i = 0; i < customer.getAccounts().size(); i++)
		    {
		    	if(customer.getAccounts().get(i).getNumber() == box.getSelectedItem() )
		    	{
		    		acc = customer.getAccounts().get(i);
		    	}
		    }
								
			continueButton.addActionListener(new ActionListener(  ) {
				public void actionPerformed(ActionEvent ae) {
					String euro = "\u20ac";
				 	
					
					if(acc instanceof CustomerDepositAccount)
					{
					
					
					JOptionPane.showMessageDialog(frame1, "25" + euro + " deposit account fee aplied."  ,"",  JOptionPane.INFORMATION_MESSAGE);
					acc.setBalance(acc.getBalance()-25);
					JOptionPane.showMessageDialog(frame1, "New balance = " + acc.getBalance() ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
					}

					if(acc instanceof CustomerCurrentAccount)
					{
					
					
					JOptionPane.showMessageDialog(frame1, "15" + euro + " current account fee aplied."  ,"",  JOptionPane.INFORMATION_MESSAGE);
					acc.setBalance(acc.getBalance()-25);
					JOptionPane.showMessageDialog(frame1, "New balance = " + acc.getBalance() ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
					}
					
					
					frame1.dispose();				
				admin();				
				}		
		     });
			
			returnButton.addActionListener(new ActionListener(  ) {
				public void actionPerformed(ActionEvent ae) {
					frame1.dispose();		
					new MainMenu();			
				}
		     });	
			
				}
	    }
	    }
	    }
	}

}
