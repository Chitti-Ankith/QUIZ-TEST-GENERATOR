import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.event.*;

class GenerateFrame extends Frame implements ActionListener{
		
		TextField t1,t2,t3,t4;
		Button b0,b1,b2,b3,b4;
		Label l1,l2,l3,l4;
		JTextArea textArea;
		JScrollPane scrollPane;
		private final static String newline = "\n";
		GenerateFrame(){

		setLayout(new FlowLayout());
		b0 = new Button("Submit");
		b1 = new Button("Generate and Export Question Set");
		b2 = new Button("Generate and Export Solution Set");
		b4 = new Button("Return");
		l1 = new Label("Please chose either a Question set or Solution Set");
		l2 = new Label("Enter the number of Questions to be generated");
		l3 = new Label("Enter the number of Answers to be generated");
		l4 = new Label("Too many questions, only few will be generated");
		t1 = new TextField(5);

		textArea = new JTextArea(20,50);
		scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		add(l2);
		add(t1);
		add(b0);
		add(l1);
		add(b1);

		b0.addActionListener(this);
		b0.setActionCommand("z");	
	
		b1.addActionListener(this);
		b1.setActionCommand("a");
		
		add(b2);
		b2.addActionListener(this);
		b2.setActionCommand("b");
		
		add(b4);
		b4.addActionListener(this);
		b4.setActionCommand("d");

		add(scrollPane);

		setSize(900,500);
		setVisible(true);
		setTitle("Quiz Generator");

		FTerminator t = new FTerminator();
		addWindowListener(t);

		}
	
		
		int rand[] = new int[100]; // To store the random Values generated when clicking the submit button

		
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		int i;
		
		if(cmd.equals("z") || cmd.equals("a") || cmd.equals("b")){
		String y = t1.getText();
		int j = Integer.parseInt(y);

		if(cmd.equals("z")){
		
		int l = 0;

		try{ FileReader f1 = new FileReader("ques.txt");
		BufferedReader reader = new BufferedReader(f1);
		String curline;
		while((curline = reader.readLine()) != null) l++;
		
		setVisible(true);
		ArrayList<Integer> list = new ArrayList<Integer>();
       		 for (i=1; i<l; i++){ //check this later ***********
            	list.add(new Integer(i));
       		 }
        	Collections.shuffle(list);
		
		if(l < j) add(l4);
		if(l > j) l4.setVisible(false);		

        	for(i=0; i<j; i++){
		rand[i] = list.get(i);
       	      	}
		reader.close();
		}catch(FileNotFoundException ex){	
		ex.printStackTrace();
       		 }catch(IOException ex){
          	  ex.printStackTrace();
      		  }
		}
			
	        else if(cmd.equals("a")){   // For Questions
		
		textArea.setText("");
		textArea.append("Question Set" + newline);
		setVisible(true);
		try{ 
		
		FileReader f1 = new FileReader("ques.txt");
		BufferedReader reader = new BufferedReader(f1);
		String curline;
		//File inputFile = new File("ques.txt");
		File tempFile = new File("Quiz.txt");
		int count = 0;
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		for(i = 0;i<j;i++)
		{
			int lines = 0;
			
			while((curline = reader.readLine()) != null) {
				lines++;
				String trimmedLine = curline.trim();
				if(lines == rand[i]){
				count++;
				String edit = count + " " + curline;
				textArea.append(edit + newline);
				writer.write(edit + System.getProperty("line.separator"));
				reader.close();
				f1 = new FileReader("ques.txt"); //Have to do this to read the file from the beginning again
				reader = new BufferedReader(f1);
				break;
				}				
			}
			
		}
		writer.close();
		reader.close();		
	
		}catch(FileNotFoundException ex){	
		ex.printStackTrace();
       		 }catch(IOException ex){
          	  ex.printStackTrace();
      		  }
		//t1.setText("");
	}
	
		else if(cmd.equals("b")){   // For Solutions
		
		textArea.setText("");
		textArea.append("Solution Set" + newline);
		setVisible(true);
		try{ 

		FileReader f1 = new FileReader("ans.txt");
		BufferedReader reader = new BufferedReader(f1);
		String curline;
		File tempFile = new File("Solutions.txt");
		int count = 0;
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		for(i = 0;i<j;i++)
		{
			int lines = 0;
			
			while((curline = reader.readLine()) != null) {
				lines++;
				String trimmedLine = curline.trim();
				if(lines == rand[i]){
				count++;
				String edit = count + " " + curline;
				textArea.append(edit + newline);
				writer.write(edit + System.getProperty("line.separator"));
				reader.close();
				f1 = new FileReader("ans.txt"); //Have to do this to read the file from the beginning again
				reader = new BufferedReader(f1);
				break;
				}				
			}
			
		}
		writer.close();
		reader.close();		
	
		}catch(FileNotFoundException ex){	
		ex.printStackTrace();
       		 }catch(IOException ex){
          	  ex.printStackTrace();
      		  }
		//t1.setText("");
		}
			
	}
		else if(cmd.equals("d")){
		this.dispose();
		new SimpleFrame();
		}
	}
}
	