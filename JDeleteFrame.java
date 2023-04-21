import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

class JDeleteFrame extends Frame implements ActionListener{
	
	TextField t1,t2;
	Label l1,l2,l3;
	Button b1,b2;
	
	JDeleteFrame(){

	setLayout(new FlowLayout());
	b1 = new Button("Submit");
	b1.setBounds(270, 90, 110, 24);
	b2 = new Button("Return");
	b2.setBounds(310, 310, 57, 24);
	t1 = new TextField(5);
	l1 = new Label("Enter the Question Number to be deleted");
	l2 = new Label("Question Number not present. Please enter a lower number");
	l2.setBounds(60, 210, 230, 20);
	l3 = new Label("Success");
	l3.setBounds(140, 170, 50, 20);
	
	add(l1);
	l1.setBounds(20, 40, 260, 20);
	add(t1);
	t1.setBounds(300, 40, 60, 20);
	add(b1);
	b1.addActionListener(this);
	b1.setActionCommand("a");
	
	add(b2);
	b2.addActionListener(this);
	b2.setActionCommand("b");

	setSize(400,400);
	setVisible(true);
	setTitle("Quiz Generator");

	FTerminator t = new FTerminator();
	addWindowListener(t);
	
	}

	public void actionPerformed(ActionEvent e)
	{	
		String cmd = e.getActionCommand();
		if(cmd.equals("a")){
		String y = t1.getText();	
		int i = Integer.parseInt(y);
		int l = 0;
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
		add(l2);
		l2.setVisible(true);
		l3.setVisible(false);
		}
		else{
		add(l3);
		l3.setVisible(true);
		l2.setVisible(false);
		}

		try{  					//For the Question File
		BufferedReader reader = new BufferedReader(new FileReader("jques.txt"));
		int lines = 0;
		String curline;
		File inputFile = new File("jques.txt");
		File tempFile = new File("jmyTempFile.txt");
		 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		while((curline = reader.readLine()) != null) {
		lines++;
		String trimmedLine = curline.trim();
		if(lines == i) continue;
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

		try{ //For the Answer File
		BufferedReader reader1 = new BufferedReader(new FileReader("jans.txt"));
		int lines = 0;
		String curline;
		File inputFile1 = new File("jans.txt");
		File tempFile1 = new File("jmyTempFile1.txt");
		 BufferedWriter writer1 = new BufferedWriter(new FileWriter(tempFile1));
		while((curline = reader1.readLine()) != null) {
		lines++;
		String trimmedLine1 = curline.trim();
		if(lines == i) continue;
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
		t1.setText("");
	}
	else if(cmd.equals("b")){
		this.dispose();
		new JSimpleFrame();
	}

}

}

		


