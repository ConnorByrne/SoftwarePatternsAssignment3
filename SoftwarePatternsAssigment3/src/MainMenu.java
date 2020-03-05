
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
	
	//Admin this = new Admin(new ArrayList<Customer>(), 0, null, new CustomerAccount());
	

	public static void main(String[] args)
	{
		MainMenu driver = new MainMenu();
		driver.menuStart();
	}
	
	MainMenu(){
		menuStart();
	}
	
	
	
	public void menuStart(){
		   /*The menuStart method asks the user if they are a new customer, an existing customer or an admin. It will then start the create customer process
		  if they are a new customer, or will ask them to log in if they are an existing customer or admin.*/
			this.frame1 = new JFrame("User Type");
			this.frame1.setSize(400, 300);
			this.frame1.setLocation(200, 200);
			this.frame1.addWindowListener(new WindowAdapter() {
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

			Container content = this.frame1.getContentPane();
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
						adminLogon();
						}
					//----------------------------------------------------------------------------------------------------------------
					
					
					
					//if user selects CUSTOMER ---------------------------------------------------------------------------------------- 
					if(user.equals("Customer")	)
					{
						createCustomer();}
					//-----------------------------------------------------------------------------------------------------------------------
				}

				

				

				
			});this.frame1.setVisible(true);	
	}
	

	
//	public void admin(){
//		this.frame1 = new JFrame("Administrator Menu");
//		this.frame1.setSize(400, 400);
//		this.frame1.setLocation(200, 200);
//		this.frame1.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent we) { System.exit(0); }
//		});          
//		this.frame1.setVisible(true);
//		
//		JPanel deleteCustomerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		JButton deleteCustomer = new JButton("Delete Customer");	
//		deleteCustomer.setPreferredSize(new Dimension(250, 20));
//		deleteCustomerPanel.add(deleteCustomer);
//		
//		JPanel deleteAccountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		JButton deleteAccount = new JButton("Delete Account");
//		deleteAccount.setPreferredSize(new Dimension(250, 20));	
//		deleteAccountPanel.add(deleteAccount);
//		
//		JPanel bankChargesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		JButton bankChargesButton = new JButton("Apply Bank Charges");
//		bankChargesButton.setPreferredSize(new Dimension(250, 20));	
//		bankChargesPanel.add(bankChargesButton);
//		
//		JPanel interestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		JButton interestButton = new JButton("Apply Interest");
//		interestPanel.add(interestButton);
//		interestButton.setPreferredSize(new Dimension(250, 20));
//		
//		JPanel editCustomerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		JButton editCustomerButton = new JButton("Edit existing Customer");
//		editCustomerPanel.add(editCustomerButton);
//		editCustomerButton.setPreferredSize(new Dimension(250, 20));
//		
//		JPanel navigatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		JButton navigateButton = new JButton("Navigate Customer Collection");
//		navigatePanel.add(navigateButton);
//		navigateButton.setPreferredSize(new Dimension(250, 20));
//		
//		JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		JButton summaryButton = new JButton("Display Summary Of All Accounts");
//		summaryPanel.add(summaryButton);
//		summaryButton.setPreferredSize(new Dimension(250, 20));
//		
//		JPanel accountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		JButton accountButton = new JButton("Add an Account to a Customer");
//		accountPanel.add(accountButton);
//		accountButton.setPreferredSize(new Dimension(250, 20));
//		
//		JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//		JButton returnButton = new JButton("Exit Admin Menu");
//		returnPanel.add(returnButton);
//
//		JLabel label1 = new JLabel("Please select an option");
//		
//		this.content = this.frame1.getContentPane();
//		this.content.setLayout(new GridLayout(9, 1));
//		this.content.add(label1);
//		this.content.add(accountPanel);
//		this.content.add(bankChargesPanel);
//		this.content.add(interestPanel);
//		this.content.add(editCustomerPanel);
//		this.content.add(navigatePanel);
//		this.content.add(summaryPanel);	
//		this.content.add(deleteCustomerPanel);
//		this.content.add(returnPanel);
//		
//		
//		bankChargesButton.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//				bankCharges();
//				}
//			}		
//	     );
//		
//		interestButton.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//				interestButton();
//			}	
//	     });
//		
//		editCustomerButton.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//				editCustomer();
//			}
//	     });
//		
//		summaryButton.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) { summary();}	
//	     });
//		
//		navigateButton.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//				navigate();
//			}
//		});
//		
//		accountButton.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//				account();}
//	     });		
//
//		deleteCustomer.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//				deleteCustomer();
//			}
//	     });		
//		
//		deleteAccount.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//				deleteAccount();
//			}
//			
//	     });		
//		returnButton.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//				frame1.dispose();
//				menuStart();				
//			}
//	     });		
//	}
//	
//	protected void deleteAccount() {
//
//		boolean found = true;
//						 {
//							    Object customerID = JOptionPane.showInputDialog(this.frame1, "Customer ID of Customer from which you wish to delete an account");
//							    
//							    for (Customer aCustomer: this.customerList){
//							    	
//							    	if(aCustomer.getCustomerID().equals(customerID))
//							    	{
//							    		found = true;
//							    		this.customer = aCustomer; 
//							    		break;
//							    	}					    	
//							    }
//							    
//							    if(found == false)
//							    {
//							    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
//							    	if (reply == JOptionPane.NO_OPTION) {
//							    		this.frame1.dispose();
//							    		admin();
//							    	}
//							    }  
//							    else
//							    {
//							    	//Here I would make the user select a an account to delete from a combo box. If the account had a balance of 0 then it would be deleted. (I do not have time to do this)
//							    }
//							    
//							    
//					}
//		
//	}
//
//
//
//	protected void deleteCustomer() {
//
//		boolean found = true;
//		
//		if(this.customerList.isEmpty())
//		{
//			JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
//			dispose();
//			admin();
//		}
//		else
//		{
//			 {
//				    Object customerID = JOptionPane.showInputDialog(this.frame1, "Customer ID of Customer You Wish to Delete:");
//				    
//				    for (Customer aCustomer: this.customerList){
//				    	
//				    	if(aCustomer.getCustomerID().equals(customerID))
//				    	{
//				    		found = true;
//				    		this.customer = aCustomer; 
//				    		break;
//				    	}					    	
//				    }
//				    
//				    if(found == false)
//				    {
//				    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
//				    	if (reply == JOptionPane.NO_OPTION) {
//				    		this.frame1.dispose();
//				    		admin();
//				    	}
//				    }  
//				    else
//				    {
//				    	if(this.customer.getAccounts().size()>0)
//				    	{
//				    		JOptionPane.showMessageDialog(this.frame1, "This customer has accounts. \n You must delete a customer's accounts before deleting a customer " ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
//				    	}
//				    	else
//				    	{
//				    		this.customerList.remove(this.customer);
//				    		JOptionPane.showMessageDialog(this.frame1, "Customer Deleted " ,"Success.",  JOptionPane.INFORMATION_MESSAGE);
//				    	}
//				    }
//				    
//				    
//		}}
//	
//		
//	}
//
//
//
//	protected void account() {
//
//		this.frame1.dispose();
//		
//		if(this.customerList.isEmpty())
//		{
//			JOptionPane.showMessageDialog(this.frame1, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
//			this.frame1.dispose();
//			admin();
//		}
//		else
//		{
//		boolean loop = true;
//		
//		boolean found = false;
//	
//	    while(loop)
//	    {
//	    Object customerID = JOptionPane.showInputDialog(this.frame1, "Customer ID of Customer You Wish to Add an Account to:");
//	    
//	    for (Customer aCustomer: this.customerList){
//	    	
//	    	if(aCustomer.getCustomerID().equals(customerID))
//	    	{
//	    		found = true;
//	    		this.customer = aCustomer; 	
//	    	}					    	
//	    }
//	    
//	    if(found == false)
//	    {
//	    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
//	    	if (reply == JOptionPane.YES_OPTION) {
//	    		loop = true;
//	    	}
//	    	else if(reply == JOptionPane.NO_OPTION)
//	    	{
//	    		this.frame1.dispose();
//	    		loop = false;
//	    	
//	    		admin();
//	    	}
//	    }
//	    else
//	    {
//	    	loop = false;
//	    	//a combo box in an dialog box that asks the admin what type of account they wish to create (deposit/current)
//		    String[] choices = { "Current Account", "Deposit Account" };
//		    String account = (String) JOptionPane.showInputDialog(null, "Please choose account type",
//		        "Account Type", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]); 
//		    
//		    if(account.equals("Current Account"))
//		    {
//		    	//create current account
//		    	boolean valid = true;
//		    	double balance = 0;
//		    	String number = String.valueOf("C" + (this.customerList.indexOf(this.customer)+1) * 10 + (this.customer.getAccounts().size()+1));//this simple algorithm generates the account number
//		    	ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
//		    	int randomPIN = (int)(Math.random()*9000)+1000;
//		           String pin = String.valueOf(randomPIN);
//		    
//		           ATMCard atm = new ATMCard(randomPIN, valid);
//		    	
//		    	CustomerCurrentAccount current = new CustomerCurrentAccount(atm, number, balance, transactionList);
//		    	
//		    	this.customer.getAccounts().add(current);
//		    	JOptionPane.showMessageDialog(this.frame1, "Account number = " + number +"\n PIN = " + pin  ,"Account created.",  JOptionPane.INFORMATION_MESSAGE);
//		    	
//		    	this.frame1.dispose();
//		    	admin();
//		    }
//		    
//		    if(account.equals("Deposit Account"))
//		    {
//		    	//create deposit account
//		    	
//		    	double balance = 0, interest = 0;
//		    	String number = String.valueOf("D" + (this.customerList.indexOf(this.customer)+1) * 10 + (this.customer.getAccounts().size()+1));//this simple algorithm generates the account number
//		    	ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
//		        	
//		    	CustomerDepositAccount deposit = new CustomerDepositAccount(interest, number, balance, transactionList);
//		    	
//		    	this.customer.getAccounts().add(deposit);
//		    	JOptionPane.showMessageDialog(this.frame1, "Account number = " + number ,"Account created.",  JOptionPane.INFORMATION_MESSAGE);
//		    	
//		    	this.frame1.dispose();
//		    	admin();
//		    }
//	    
//	    }			   
//	    }
//		}
//	
//		
//	}
//
//
//
//	protected void navigate() {
//
//		this.frame1.dispose();
//		
//		if(this.customerList.isEmpty())
//		{
//			JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
//			admin();
//		}
//		else
//		{
//
//		JButton first, previous, next, last, cancel;
//		JPanel gridPanel, buttonPanel, cancelPanel;			
//
//		Container content = getContentPane();
//		
//		content.setLayout(new BorderLayout());
//		
//		buttonPanel = new JPanel();
//		gridPanel = new JPanel(new GridLayout(8, 2));
//		cancelPanel = new JPanel();
//						
//		this.firstNameLabel = new JLabel("First Name:", SwingConstants.LEFT);
//		this.surnameLabel = new JLabel("Surname:", SwingConstants.LEFT);
//		this.pPPSLabel = new JLabel("PPS Number:", SwingConstants.LEFT);
//		this.dOBLabel = new JLabel("Date of birth", SwingConstants.LEFT);
//		this.customerIDLabel = new JLabel("CustomerID:", SwingConstants.LEFT);
//		this.passwordLabel = new JLabel("Password:", SwingConstants.LEFT);
//		this.firstNameTextField = new JTextField(20);
//		this.surnameTextField = new JTextField(20);
//		this.pPSTextField = new JTextField(20);
//		this.dOBTextField = new JTextField(20);
//		this.customerIDTextField = new JTextField(20);
//		this.passwordTextField = new JTextField(20);
//		
//		first = new JButton("First");
//		previous = new JButton("Previous");
//		next = new JButton("Next");
//		last = new JButton("Last");
//		cancel = new JButton("Cancel");
//		
//		this.firstNameTextField.setText(this.customerList.get(0).getFirstName());
//		this.surnameTextField.setText(this.customerList.get(0).getSurname());
//		this.pPSTextField.setText(this.customerList.get(0).getPPS());
//		this.dOBTextField.setText(this.customerList.get(0).getDOB());
//		this.customerIDTextField.setText(this.customerList.get(0).getCustomerID());
//		this.passwordTextField.setText(this.customerList.get(0).getPassword());
//		
//		this.firstNameTextField.setEditable(false);
//		this.surnameTextField.setEditable(false);
//		this.pPSTextField.setEditable(false);
//		this.dOBTextField.setEditable(false);
//		this.customerIDTextField.setEditable(false);
//		this.passwordTextField.setEditable(false);
//		
//		gridPanel.add(this.firstNameLabel);
//		gridPanel.add(this.firstNameTextField);
//		gridPanel.add(this.surnameLabel);
//		gridPanel.add(this.surnameTextField);
//		gridPanel.add(this.pPPSLabel);
//		gridPanel.add(this.pPSTextField);
//		gridPanel.add(this.dOBLabel);
//		gridPanel.add(this.dOBTextField);
//		gridPanel.add(this.customerIDLabel);
//		gridPanel.add(this.customerIDTextField);
//		gridPanel.add(this.passwordLabel);
//		gridPanel.add(this.passwordTextField);
//		
//		buttonPanel.add(first);
//		buttonPanel.add(previous);
//		buttonPanel.add(next);
//		buttonPanel.add(last);
//		
//		cancelPanel.add(cancel);
//
//		content.add(gridPanel, BorderLayout.NORTH);
//		content.add(buttonPanel, BorderLayout.CENTER);
//		content.add(cancelPanel, BorderLayout.AFTER_LAST_LINE);
//		first.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//				position = 0;
//				firstNameTextField.setText(customerList.get(0).getFirstName());
//				surnameTextField.setText(customerList.get(0).getSurname());
//				pPSTextField.setText(customerList.get(0).getPPS());
//				dOBTextField.setText(customerList.get(0).getDOB());
//				customerIDTextField.setText(customerList.get(0).getCustomerID());
//				passwordTextField.setText(customerList.get(0).getPassword());				
//					}		
//			     });
//		
//		previous.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//						
//				if(position < 1)
//				{
//					//don't do anything
//				}
//				else
//				{
//					position = position - 1;
//					
//				firstNameTextField.setText(customerList.get(position).getFirstName());
//				surnameTextField.setText(customerList.get(position).getSurname());
//				pPSTextField.setText(customerList.get(position).getPPS());
//				dOBTextField.setText(customerList.get(position).getDOB());
//				customerIDTextField.setText(customerList.get(position).getCustomerID());
//				passwordTextField.setText(customerList.get(position).getPassword());
//				}			
//					}		
//			     });
//		
//		next.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//			
//				if(position == customerList.size()-1)
//				{
//					//don't do anything
//				}
//				else
//				{
//					position = position + 1;
//					
//				firstNameTextField.setText(customerList.get(position).getFirstName());
//				surnameTextField.setText(customerList.get(position).getSurname());
//				pPSTextField.setText(customerList.get(position).getPPS());
//				dOBTextField.setText(customerList.get(position).getDOB());
//				customerIDTextField.setText(customerList.get(position).getCustomerID());
//				passwordTextField.setText(customerList.get(position).getPassword());
//				}		
//				
//				
//										
//					}		
//			     });
//		
//		last.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//			
//				position = customerList.size() - 1;
//		
//				firstNameTextField.setText(customerList.get(position).getFirstName());
//				surnameTextField.setText(customerList.get(position).getSurname());
//				pPSTextField.setText(customerList.get(position).getPPS());
//				dOBTextField.setText(customerList.get(position).getDOB());
//				customerIDTextField.setText(customerList.get(position).getCustomerID());
//				passwordTextField.setText(customerList.get(position).getPassword());								
//					}		
//			     });
//		
//		cancel.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {				
//				dispose();
//				admin();
//					}		
//			     });			
//		setContentPane(content);
//		setSize(400, 300);
//	       setVisible(true);
//			}		
//	
//		
//	}
//
//
//
//	protected void summary() {
//
//		this.frame1.dispose();
//		
//		
//		this.frame1 = new JFrame("Summary of Transactions");
//		this.frame1.setSize(400, 700);
//		this.frame1.setLocation(200, 200);
//		this.frame1.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent we) { System.exit(0); }
//		});          
//		this.frame1.setVisible(true);
//		
//		JLabel label1 = new JLabel("Summary of all transactions: ");
//		
//		JPanel returnPanel = new JPanel();
//		JButton returnButton = new JButton("Return");
//		returnPanel.add(returnButton);
//		
//		JPanel textPanel = new JPanel();
//		
//		textPanel.setLayout( new BorderLayout() );
//		JTextArea textArea = new JTextArea(40, 20);
//		textArea.setEditable(false);
//		textPanel.add(label1, BorderLayout.NORTH);
//		textPanel.add(textArea, BorderLayout.CENTER);
//		textPanel.add(returnButton, BorderLayout.SOUTH);
//		
//		JScrollPane scrollPane = new JScrollPane(textArea);
//		textPanel.add(scrollPane);
//		
//	for (int a = 0; a < this.customerList.size(); a++)//For each customer, for each account, it displays each transaction.
//		{
//			for (int b = 0; b < this.customerList.get(a).getAccounts().size(); b ++ )
//			{
//				this.acc = this.customerList.get(a).getAccounts().get(b);
//				for (int c = 0; c < this.customerList.get(a).getAccounts().get(b).getTransactionList().size(); c++)
//				{
//					
//					textArea.append(this.acc.getTransactionList().get(c).toString());
//					//Int total = acc.getTransactionList().get(c).getAmount(); //I was going to use this to keep a running total but I couldnt get it  working.
//					
//				}				
//			}				
//		}
//		
//		
//		
//		
//		textPanel.add(textArea);
//		this.content.removeAll();
//		
//		
//		Container content = this.frame1.getContentPane();
//		content.setLayout(new GridLayout(1, 1));
//	//	content.add(label1);
//		content.add(textPanel);
//		//content.add(returnPanel);
//		
//		returnButton.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//				frame1.dispose();			
//			admin();				
//			}		
//	     });	
//	
//		
//	}
//
//
//
//	protected void editCustomer() {
//		//boolean loop = true;
//		boolean found = false;
//	
//		if(this.customerList.isEmpty())
//		{
//			JOptionPane.showMessageDialog(this.frame1, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
//			this.frame1.dispose();
//			admin();
//			
//		}
//		else
//		{
//		
//	    while(true)
//	    {
//	    Object customerID = JOptionPane.showInputDialog(this.frame1, "Enter Customer ID:");
//	    
//	    for (Customer aCustomer: this.customerList){
//	    	
//	    	if(aCustomer.getCustomerID().equals(customerID))
//	    	{
//	    		found = true;
//	    		this.customer = aCustomer;
//	    		break;
//	    	}					    	
//	    }
//	    
//	    if(found == false)
//	    {
//	    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
//	    	if (reply == JOptionPane.NO_OPTION) {
//	    		this.frame1.dispose();
//	    		admin();
//	    		break;
//	    	}
//	    }
//	    else
//	    {
//	    	break;
//	    }
//	   
//	    }
//		
//		this.frame1.dispose();
//		
//		this.frame1.dispose();
//		this.frame1 = new JFrame("Administrator Menu");
//		this.frame1.setSize(400, 300);
//		this.frame1.setLocation(200, 200);
//		this.frame1.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent we) { System.exit(0); }
//		});       
//		
//		this.firstNameLabel = new JLabel("First Name:", SwingConstants.LEFT);
//		this.surnameLabel = new JLabel("Surname:", SwingConstants.LEFT);
//		this.pPPSLabel = new JLabel("PPS Number:", SwingConstants.LEFT);
//		this.dOBLabel = new JLabel("Date of birth", SwingConstants.LEFT);
//		this.customerIDLabel = new JLabel("CustomerID:", SwingConstants.LEFT);
//		this.passwordLabel = new JLabel("Password:", SwingConstants.LEFT);
//		this.firstNameTextField = new JTextField(20);
//		this.surnameTextField = new JTextField(20);
//		this.pPSTextField = new JTextField(20);
//		this.dOBTextField = new JTextField(20);
//		this.customerIDTextField = new JTextField(20);
//		this.passwordTextField = new JTextField(20);
//		
//		JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//
//		JPanel cancelPanel = new JPanel();
//		
//		textPanel.add(this.firstNameLabel);
//		textPanel.add(this.firstNameTextField);
//		textPanel.add(this.surnameLabel);
//		textPanel.add(this.surnameTextField);
//		textPanel.add(this.pPPSLabel);
//		textPanel.add(this.pPSTextField);
//		textPanel.add(this.dOBLabel);
//		textPanel.add(this.dOBTextField);
//		textPanel.add(this.customerIDLabel);
//		textPanel.add(this.customerIDTextField);
//		textPanel.add(this.passwordLabel);
//		textPanel.add(this.passwordTextField);
//
//		this.firstNameTextField.setText(this.customer.getFirstName());
//		this.surnameTextField.setText(this.customer.getSurname());
//		this.pPSTextField.setText(this.customer.getPPS());
//		this.dOBTextField.setText(this.customer.getDOB());
//		this.customerIDTextField.setText(this.customer.getCustomerID());
//		this.passwordTextField.setText(this.customer.getPassword());	
//		
//		JButton saveButton = new JButton("Save");
//		JButton cancelButton = new JButton("Exit");
//		
//		cancelPanel.add(cancelButton, BorderLayout.SOUTH);
//		cancelPanel.add(saveButton, BorderLayout.SOUTH);
//
//		Container content = this.frame1.getContentPane();
//		content.setLayout(new GridLayout(2, 1));
//		content.add(textPanel, BorderLayout.NORTH);
//		content.add(cancelPanel, BorderLayout.SOUTH);
//		
//		this.frame1.setContentPane(content);
//		this.frame1.setSize(340, 350);
//		this.frame1.setLocation(200, 200);
//		this.frame1.setVisible(true);
//		this.frame1.setResizable(false);
//		
//		saveButton.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//			
//				customer.setFirstName(firstNameTextField.getText());
//				customer.setSurname(surnameTextField.getText());
//				customer.setPPS(pPSTextField.getText());
//				customer.setDOB(dOBTextField.getText());
//				customer.setCustomerID(customerIDTextField.getText());
//				customer.setPassword(passwordTextField.getText());		
//				
//				JOptionPane.showMessageDialog(null, "Changes Saved.");
//					}		
//			     });
//		
//		cancelButton.addActionListener(new ActionListener(  ) {
//			public void actionPerformed(ActionEvent ae) {
//				frame1.dispose();
//				
//				admin();				
//			}		
//	     });		
//		}
//		
//	}
//
//
//
//	protected void interestButton() {
//		
//		boolean found = false;
//	
//		if(this.customerList.isEmpty())
//		{
//			JOptionPane.showMessageDialog(this.frame1, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
//			this.frame1.dispose();
//			admin();
//			
//		}
//		else
//		{
//	    while(true)
//	    {
//	    Object customerID = JOptionPane.showInputDialog(this.frame1, "Customer ID of Customer You Wish to Apply Interest to:");
//	    
//	    for (Customer aCustomer: this.customerList){
//	    	
//	    	if(aCustomer.getCustomerID().equals(customerID))
//	    	{
//	    		found = true;
//	    		this.customer = aCustomer; 
//	    		break;
//	    	}					    	
//	    }
//	    
//	    if(found == false)
//	    {
//	    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
//	    	if (reply == JOptionPane.NO_OPTION) {
//	    		this.frame1.dispose();
//	    		admin();
//	    		break;
//	    	
//	    		
//	    	}
//	    	
//	    }  
//	    else
//	    {
//	    	this.frame1.dispose();
//	    	this.frame1 = new JFrame("Administrator Menu");
//			this.frame1.setSize(400, 300);
//			this.frame1.setLocation(200, 200);
//			this.frame1.addWindowListener(new WindowAdapter() {
//				public void windowClosing(WindowEvent we) { System.exit(0); }
//			});          
//			this.frame1.setVisible(true);
//		
//		
//		    JComboBox<String> box = new JComboBox<String>();
//		    for (int i =0; i < this.customer.getAccounts().size(); i++)
//		    {
//		    	
//		    	
//		     box.addItem(this.customer.getAccounts().get(i).getNumber());
//		    }
//			
//		    
//		    box.getSelectedItem();
//		
//		    JPanel boxPanel = new JPanel();
//			
//			JLabel label = new JLabel("Select an account to apply interest to:");
//			boxPanel.add(label);
//			boxPanel.add(box);
//			JPanel buttonPanel = new JPanel();
//			JButton continueButton = new JButton("Apply Interest");
//			JButton returnButton = new JButton("Return");
//			buttonPanel.add(continueButton);
//			buttonPanel.add(returnButton);
//			Container content = this.frame1.getContentPane();
//			content.setLayout(new GridLayout(2, 1));
//			
//			content.add(boxPanel);
//			content.add(buttonPanel);
//			
//	
//				if(this.customer.getAccounts().isEmpty())
//				{
//					JOptionPane.showMessageDialog(this.frame1, "This customer has no accounts! \n The admin must add acounts to this customer."   ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
//					this.frame1.dispose();
//					admin();
//				}
//				else
//				{
//				
//			for(int i = 0; i < this.customer.getAccounts().size(); i++)
//		    {
//		    	if(this.customer.getAccounts().get(i).getNumber() == box.getSelectedItem() )
//		    	{
//		    		this.acc = this.customer.getAccounts().get(i);
//		    	}
//		    }
//								
//			continueButton.addActionListener(new ActionListener(  ) {
//				public void actionPerformed(ActionEvent ae) {
//					String euro = "\u20ac";
//				 	double interest = 0;
//				 	boolean loop = true;
//				 	
//				 	while(loop)
//				 	{
//					String interestString = JOptionPane.showInputDialog(frame1, "Enter interest percentage you wish to apply: \n NOTE: Please enter a numerical value. (with no percentage sign) \n E.g: If you wish to apply 8% interest, enter '8'");//the isNumeric method tests to see if the string entered was numeric. 
//					if(isNumeric(interestString))
//					{
//						
//						interest = Double.parseDouble(interestString);
//						loop = false;
//						
//						acc.setBalance(acc.getBalance() + (acc.getBalance() * (interest/100)));
//						
//						JOptionPane.showMessageDialog(frame1, interest + "% interest applied. \n new balance = " + acc.getBalance() + euro ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
//					}
//						
//					
//					else
//					{
//						JOptionPane.showMessageDialog(frame1, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
//					}
//					
//					
//				 	}
//					
//					frame1.dispose();				
//				admin();				
//				}		
//		     });
//			
//			returnButton.addActionListener(new ActionListener(  ) {
//				public void actionPerformed(ActionEvent ae) {
//					frame1.dispose();		
//					menuStart();				
//				}
//		     });	
//			
//				}
//	    }
//	    }
//	    }
//	    
//	
//		
//	}



	public void customer(Customer e1)
	{	
		this.frame1 = new JFrame("Customer Menu");
		e1 = this.e;
		this.frame1.setSize(400, 300);
		this.frame1.setLocation(200, 200);
		this.frame1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});          
		this.frame1.setVisible(true);
		
		if(this.e.getAccounts().size() == 0)
		{
			JOptionPane.showMessageDialog(this.frame1, "This customer does not have any accounts yet. \n An admin must create an account for this customer \n for them to be able to use customer functionality. " ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
			this.frame1.dispose();				
			menuStart();
		}
		else
		{
		JPanel buttonPanel = new JPanel();
		JPanel boxPanel = new JPanel();
		JPanel labelPanel = new JPanel();
		
		JLabel label = new JLabel("Select Account:");
		labelPanel.add(label);
		
		JButton returnButton = new JButton("Return");
		buttonPanel.add(returnButton);
		JButton continueButton = new JButton("Continue");
		buttonPanel.add(continueButton);
		
		JComboBox<String> box = new JComboBox<String>();
	    for (int i =0; i < this.e.getAccounts().size(); i++)
	    {
	     box.addItem(this.e.getAccounts().get(i).getNumber());
	    }
		
	    
	   
	    for(int i = 0; i<this.e.getAccounts().size(); i++)
	    {
	    	if(this.e.getAccounts().get(i).getNumber() == box.getSelectedItem() )
	    	{
	    		this.acc = this.e.getAccounts().get(i);
	    	}
	    }
	    
	    
	    
	
	    
		boxPanel.add(box);
		this.content = this.frame1.getContentPane();
		this.content.setLayout(new GridLayout(3, 1));
		this.content.add(labelPanel);
		this.content.add(boxPanel);
		this.content.add(buttonPanel);
		
		returnButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
			frame1.dispose();				
			menuStart();				
			}		
	     });
		
		continueButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				
		frame1.dispose();
		
		frame1 = new JFrame("Customer Menu");
		frame1.setSize(400, 300);
		frame1.setLocation(200, 200);
		frame1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});          
		frame1.setVisible(true);
		
		JPanel statementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton statementButton = new JButton("Display Bank Statement");
		statementButton.setPreferredSize(new Dimension(250, 20));
		
		statementPanel.add(statementButton);
		
		JPanel lodgementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton lodgementButton = new JButton("Lodge money into account");
		lodgementPanel.add(lodgementButton);
		lodgementButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel withdrawalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton withdrawButton = new JButton("Withdraw money from account");
		withdrawalPanel.add(withdrawButton);
		withdrawButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton returnButton = new JButton("Exit Customer Menu");
		returnPanel.add(returnButton);

		JLabel label1 = new JLabel("Please select an option");
		
		content = frame1.getContentPane();
		content.setLayout(new GridLayout(5, 1));
		content.add(label1);
		content.add(statementPanel);
		content.add(lodgementPanel);
		content.add(withdrawalPanel);
		content.add(returnPanel);
		
		statementButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				frame1.dispose();
				frame1 = new JFrame("Customer Menu");
				frame1.setSize(400, 600);
				frame1.setLocation(200, 200);
				frame1.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) { System.exit(0); }
				});          
				frame1.setVisible(true);
				
				JLabel label1 = new JLabel("Summary of account transactions: ");
				
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
				
				for (int i = 0; i < acc.getTransactionList().size(); i ++)
				{
					textArea.append(acc.getTransactionList().get(i).toString());
					
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
					customer(e);				
					}		
			     });										
			}	
	     });
		
		lodgementButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
			boolean loop = true;
			boolean on = true;
			double balance = 0;

			if(acc instanceof CustomerCurrentAccount)
			{
				int count = 3;
				int checkPin = ((CustomerCurrentAccount) acc).getAtm().getPin();
				loop = true;
				
				while(loop)
				{
					if(count == 0)
					{
						JOptionPane.showMessageDialog(frame1, "Pin entered incorrectly 3 times. ATM card locked."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);
						((CustomerCurrentAccount) acc).getAtm().setValid(false);
						customer(e); 
						loop = false;
						on = false;
					}
					
					String Pin = JOptionPane.showInputDialog(frame1, "Enter 4 digit PIN;");
					int i = Integer.parseInt(Pin);
					
				   if(on)
				   {
					if(checkPin == i)
					{
						loop = false;
						JOptionPane.showMessageDialog(frame1, "Pin entry successful" ,  "Pin", JOptionPane.INFORMATION_MESSAGE);
						
					}
					else
					{
						count --;
						JOptionPane.showMessageDialog(frame1, "Incorrect pin. " + count + " attempts remaining."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);					
					}
				
				}
				}
		
				
			}		if(on == true)
					{
				String balanceTest = JOptionPane.showInputDialog(frame1, "Enter amount you wish to lodge:");//the isNumeric method tests to see if the string entered was numeric. 
				if(isNumeric(balanceTest))
				{
					
					balance = Double.parseDouble(balanceTest);
					loop = false;
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(frame1, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
				}
				
			
			String euro = "\u20ac";
			 acc.setBalance(acc.getBalance() + balance);
			// String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			 Date date = new Date();
			 String date2 = date.toString();
			 String type = "Lodgement";
				double amount = balance;
				
				
				
				
				AccountTransaction transaction = new AccountTransaction(date2, type, amount);
				acc.getTransactionList().add(transaction);
				
			 JOptionPane.showMessageDialog(frame1, balance + euro + " added do you account!" ,"Lodgement",  JOptionPane.INFORMATION_MESSAGE);
			 JOptionPane.showMessageDialog(frame1, "New balance = " + acc.getBalance() + euro ,"Lodgement",  JOptionPane.INFORMATION_MESSAGE);
			}

			}	
	     });
		
		withdrawButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				boolean loop = true;
				boolean on = true;
				double withdraw = 0;

				if(acc instanceof CustomerCurrentAccount)
				{
					int count = 3;
					int checkPin = ((CustomerCurrentAccount) acc).getAtm().getPin();
					loop = true;
					
					while(loop)
					{
						if(count == 0)
						{
							JOptionPane.showMessageDialog(frame1, "Pin entered incorrectly 3 times. ATM card locked."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);
							((CustomerCurrentAccount) acc).getAtm().setValid(false);
							customer(e); 
							loop = false;
							on = false;
						}
						
						String Pin = JOptionPane.showInputDialog(frame1, "Enter 4 digit PIN;");
						int i = Integer.parseInt(Pin);
						
					   if(on)
					   {
						if(checkPin == i)
						{
							loop = false;
							JOptionPane.showMessageDialog(frame1, "Pin entry successful" ,  "Pin", JOptionPane.INFORMATION_MESSAGE);
							
						}
						else
						{
							count --;
							JOptionPane.showMessageDialog(frame1, "Incorrect pin. " + count + " attempts remaining."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);		
						
						}
					
					}
					}
		
				    	
				    	
				    
					
					
				}		if(on == true)
						{
					String balanceTest = JOptionPane.showInputDialog(frame1, "Enter amount you wish to withdraw (max 500):");//the isNumeric method tests to see if the string entered was numeric. 
					if(isNumeric(balanceTest))
					{
						
						withdraw = Double.parseDouble(balanceTest);
						loop = false;
						
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(frame1, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					}
					if(withdraw > 500)
					{
						JOptionPane.showMessageDialog(frame1, "500 is the maximum you can withdraw at a time." ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
						withdraw = 0;
					}
					if(withdraw > acc.getBalance())
					{
						JOptionPane.showMessageDialog(frame1, "Insufficient funds." ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
						withdraw = 0;					
					}
				
				String euro = "\u20ac";
				 acc.setBalance(acc.getBalance()-withdraw);
				   //recording transaction:
			//		String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
				 Date date = new Date();
				 String date2 = date.toString();
				 
				 String type = "Withdraw";
					double amount = withdraw;
					
		
					AccountTransaction transaction = new AccountTransaction(date2, type, amount);
					acc.getTransactionList().add(transaction);
				 
				 
					
				 JOptionPane.showMessageDialog(frame1, withdraw + euro + " withdrawn." ,"Withdraw",  JOptionPane.INFORMATION_MESSAGE);
				 JOptionPane.showMessageDialog(frame1, "New balance = " + acc.getBalance() + euro ,"Withdraw",  JOptionPane.INFORMATION_MESSAGE);
				}
				 
					
					
			}	
	     });
		
		returnButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				frame1.dispose();		
				menuStart();				
			}
	     });		}		
	     });
	}
	}
	

	
	
	
	public void adminLogon() {

		boolean loop = true, loop2 = true;
		boolean cont = false;
	    while(loop)
	    {
	    Object adminUsername = JOptionPane.showInputDialog(this.frame1, "Enter Administrator Username:");

	    if(!adminUsername.equals("admin"))//search admin list for admin with matching admin username
	    {
	    	int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Username. Try again?", JOptionPane.YES_NO_OPTION);
	    	if (reply == JOptionPane.YES_OPTION) {
	    		loop = true;
	    	}
	    	else if(reply == JOptionPane.NO_OPTION)
	    	{
	    		this.frame2.dispose();
	    		loop = false;
	    		loop2 = false;
	    		menuStart();
	    	}
	    }
	    else
	    {
	    	loop = false;
	    }				    
	    }
	    
	    while(loop2)
	    {
	    	Object adminPassword = JOptionPane.showInputDialog(this.frame1, "Enter Administrator Password;");
	    	
	    	   if(!adminPassword.equals("admin11"))//search admin list for admin with matching admin password
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Password. Try again?", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		
			    	}
			    	else if(reply == JOptionPane.NO_OPTION){
			    		this.frame2.dispose();
			    		loop2 = false;
			    		menuStart();
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
		this.frame2.dispose();
	    	loop = false;
	    new AdminMenu();					    
	    }					    
	
		
	}
	
	public void createCustomer() {
		// TODO Auto-generated method stub

		boolean loop = true, loop2 = true;
		boolean cont = false;
		boolean found = false;
		Customer customer = null;
	    while(loop)
	    {
	    Object customerID = JOptionPane.showInputDialog(this.frame1, "Enter Customer ID:");
	    
	    for (Customer aCustomer: this.customerList){
	    	
	    	if(aCustomer.getCustomerID().equals(customerID))//search customer list for matching customer ID
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
	    		this.frame1.dispose();
	    		loop = false;
	    		loop2 = false;
	    		menuStart();
	    	}
	    }
	    else
	    {
	    	loop = false;
	    }
	   
	    }
	    
	    while(loop2)
	    {
	    	Object customerPassword = JOptionPane.showInputDialog(this.frame1, "Enter Customer Password;");
	    	
	    	   if(!customer.getPassword().equals(customerPassword))//check if custoemr password is correct
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect password. Try again?", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		
			    	}
			    	else if(reply == JOptionPane.NO_OPTION){
			    		this.frame1.dispose();
			    		loop2 = false;
			    		menuStart();
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
		this.frame1.dispose();
	    	loop = false;
	    	customer(customer);				    
	    }				    
	
	}
	
	public void newCustomerFrame() {

		this.frame1.dispose();		
		this.frame2 = new JFrame("Create New Customer");
		this.frame2.setSize(400, 300);
		this.frame2.setLocation(200, 200);
		this.frame2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});
			Container content = this.frame2.getContentPane();
			content.setLayout(new BorderLayout());
			
			this.firstNameLabel = new JLabel("First Name:", SwingConstants.RIGHT);
			this.surnameLabel = new JLabel("Surname:", SwingConstants.RIGHT);
			this.pPPSLabel = new JLabel("PPS Number:", SwingConstants.RIGHT);
			this.dOBLabel = new JLabel("Date of birth", SwingConstants.RIGHT);
			this.firstNameTextField = new JTextField(20);
			this.surnameTextField = new JTextField(20);
			this.pPSTextField = new JTextField(20);
			this.dOBTextField = new JTextField(20);
			JPanel panel = new JPanel(new GridLayout(6, 2));
			panel.add(this.firstNameLabel);
			panel.add(this.firstNameTextField);
			panel.add(this.surnameLabel);
			panel.add(this.surnameTextField);
			panel.add(this.pPPSLabel);
			panel.add(this.pPSTextField);
			panel.add(this.dOBLabel);
			panel.add(this.dOBTextField);
				
			this.panel2 = new JPanel();
			this.add = new JButton("Add");
			
			 this.add.addActionListener(new ActionListener() {
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
			
			this.panel2.add(this.add);
			this.panel2.add(cancel);
			
			content.add(panel, BorderLayout.CENTER);
			content.add(this.panel2, BorderLayout.SOUTH);
	
			this.frame2.setVisible(true);		
		
	
		
	}
	    
	    
	    
	
	
	

}

