import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

class JModifyFrame extends Frame implements ActionListener{
	
	TextField t1,t2,t3,t4;
	TextField t5,t6,t7,t8; //For MCQ
	Button b1,b2,b3,b4;
	Label l1,l2,l3,l4,l5,l6,l7,l8;
	Label l9,l10;
	Button b5,b6,b7,b8;
	
	int count = 0;	//For identifying whether its a question or an answer
	int lab = 3; //For identifying the question type

	JModifyFrame(){

	setLayout(null);
	b1 = new Button("Question");
	b1.setBounds(80, 40, 110, 24);
	b2 = new Button("Answer");
	b2.setBounds(220, 40, 110, 24);
	b3 = new Button("Done");
	b3.setBounds(300, 340, 57, 24);
	b4 = new Button("Return");
	b4.setBounds(30, 340, 57, 24);
	b5 = new Button("MCQ");
	b5.setBounds(80, 80, 57, 24);
	b6 = new Button("T/F");
	b6.setBounds(160, 80, 57, 24);
	b7 = new Button("FIB");
	b7.setBounds(250, 80, 57, 24);
	b5.addActionListener(this);
	b5.setActionCommand("f");
	b6.addActionListener(this);
	b6.setActionCommand("g");
	b7.addActionListener(this);
	b7.setActionCommand("h");
	t1 = new TextField(5);
	t1.setBounds(270, 120, 60, 20);
	t2 = new TextField(30);
	t2.setBounds(90, 160, 290, 20);
	t5 = new TextField(10);
	t5.setBounds(90, 190, 60, 20);
	t6 = new TextField(10);
	t6.setBounds(160, 190, 60, 20);
	t7 = new TextField(10);
	t7.setBounds(240, 190, 60, 20);
	t8 = new TextField(10);
	t8.setBounds(310, 190, 60, 20);

	l1 = new Label("Please select whether to modify a Question or an Answer");
	l1.setBounds(40, 10, 310, 20);
	l2 = new Label("Enter the Question Number");
	l2.setBounds(20, 120, 190, 20);
	l3 = new Label("Question");
	l3.setBounds(10, 160, 70, 20);
 	l4 = new Label("Enter the Answer Number");
	l4.setBounds(20, 120, 190, 20);
	l5 = new Label("Answer");
	l5.setBounds(10, 160, 70, 20);

	l6 = new Label("Question Number not present. Please enter a lower number");
	l6.setBounds(10, 270, 350, 20);
	l7 = new Label("Answer Number not present. Please enter a lower number");
	l7.setBounds(10, 270, 350, 20);
	l8 = new Label("Success");
	l8.setBounds(10, 270, 290, 20);

	add(l1);
	add(b1);
	b1.addActionListener(this);
	b1.setActionCommand("a");
	add(b2);
	b2.addActionListener(this);
	b2.setActionCommand("b");
	
	add(b3);
	b3.addActionListener(this);
	b3.setActionCommand("d");
	add(b4);
	b4.addActionListener(this);
	b4.setActionCommand("e");
	setSize(400,400);
	setVisible(true);
	setTitle("Quiz Generator");

	FTerminator t = new FTerminator();
	addWindowListener(t);
	
	}

	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		String z = "";
		if(cmd.equals("a")){  //Question
		add(b5);
		add(b6);
		add(b7);
		setVisible(true);
		count = 0;
		}
		else if(cmd.equals("f")){ //MCQ
		add(l2);
		add(t1);
		add(l3);
		add(t2);
		add(t5);
		add(t6);
		add(t7);
		add(t8);
		setVisible(true);
		lab = 1;
		}
		else if(cmd.equals("g")){ // T/F
		add(l2);
		add(t1);
		add(l3);
		add(t2);
		t5.setVisible(false);
		t6.setVisible(false);
		t7.setVisible(false);
		t8.setVisible(false);
		setVisible(true);
		lab = 2;
		}
		else if(cmd.equals("h")){ // FIB
		add(l2);
		add(t1);
		add(l3);
		add(t2);
		t5.setVisible(false);
		t6.setVisible(false);
		t7.setVisible(false);
		t8.setVisible(false);
		setVisible(true);
		lab = 3;
		}
		else if(cmd.equals("b")){
		add(l4);
		add(t1);
		add(l5);
		add(t2);
		setVisible(true);
		count = 1;
		}
		else if(cmd.equals("d")){
		String y = t1.getText();	
		int i = Integer.parseInt(y);
		if(lab == 1)
		z = t2.getText() + " a)" + t5.getText() + ", b)"+ t6.getText() +", c)"+ t7.getText() +", d)"+ t8.getText();
		if(lab == 2) 
		z = t2.getText() + "(T/F)";
		if(lab == 3) 
		z = t2.getText();
	
		int l = 0;   // To check Number error
		try{BufferedReader tester = new BufferedReader(new FileReader("jques.txt"));
		String cur;
		while((cur = tester.readLine()) != null) l++;
		tester.close();
		}catch(FileNotFoundException ex){	
		ex.printStackTrace();
       		 }catch(IOException ex) {
          	  ex.printStackTrace();
      		  }

		if(l<i){
		if(count == 0){
		add(l6);
		l6.setVisible(true);
		l7.setVisible(false);
		l8.setVisible(false);
		}
		
		else if(count == 1){
		add(l7);
		l7.setVisible(true);
		l6.setVisible(false);
		l8.setVisible(false);
		}
		
		}
		
		else{
		add(l8);
		l8.setVisible(true);
		l7.setVisible(false);
		l6.setVisible(false);
		
		if(count == 0){
		try{ 				 //For the Question File
		BufferedReader reader = new BufferedReader(new FileReader("jques.txt"));
		int lines = 0;
		String curline;
		File inputFile = new File("jques.txt");
		File tempFile = new File("jmyTempFile.txt");
		 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		while((curline = reader.readLine()) != null) {
		lines++;
		String trimmedLine = curline.trim();
		if(lines == i) curline = z;
		writer.write(curline + System.getProperty("line.separator"));
		}
		
		writer.close();
		reader.close();
		inputFile.delete();
		tempFile.renameTo(inputFile);
		}catch(FileNotFoundException ex){	
		ex.printStackTrace();
       		 }catch(IOException ex) {
          	  ex.printStackTrace();
      		  }
		}

		if(count == 1){
		try{ 				//For the Answer File
		BufferedReader reader1 = new BufferedReader(new FileReader("jans.txt"));
		int lines = 0;
		String curline;
		File inputFile1 = new File("jans.txt");
		File tempFile1 = new File("jmyTempFile.txt");
		 BufferedWriter writer1 = new BufferedWriter(new FileWriter(tempFile1));
		while((curline = reader1.readLine()) != null) {
		lines++;
		String trimmedLine1 = curline.trim();
		if(lines == i) curline = z;
		writer1.write(curline + System.getProperty("line.separator"));
		}
		
		writer1.close();
		reader1.close();
		inputFile1.delete();
		tempFile1.renameTo(inputFile1);
		}catch(FileNotFoundException ex){	
		ex.printStackTrace();
       		 }catch(IOException ex) {
          	  ex.printStackTrace();
      		  }
		}

		this.dispose();
		new JSimpleFrame();
		}
		t1.setText("");
		t2.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");
		
	}
	else if(cmd.equals("e")){
		this.dispose();
		new JSimpleFrame();
     	}
	}


}
