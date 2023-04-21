import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

class JInsertFrame extends Frame implements ActionListener{

	TextField t1,t2,t3,t4,t5,t6;
	Label l1,l2,l3,l4;
	Button b1,b2,b3,b4,b5;
	int label; //for differentiating MCQ and T/F

	JInsertFrame(){
	
	
	setLayout(new FlowLayout());
	setLayout(null);
	b1 = new Button("MCQ");
	b1.setBounds(60, 40, 57, 24);
	b2 = new Button("T/F");
	b2.setBounds(160, 40, 57, 24);
	b3 = new Button("Fill in the Blanks");
	b3.setBounds(270, 40, 110, 24);
	l1 = new Label("Question:");
	l1.setBounds(20, 100, 60, 20);
	l2 = new Label("Options:");
	l2.setBounds(20, 140, 60, 20);
	l3 = new Label("Answer:");
	l3.setBounds(20, 180, 60, 20);
	l4 = new Label("Success");
	l4.setBounds(48, 230, 60, 20);
	t1 = new TextField(50);
	t1.setBounds(110, 100, 260, 20);
	t2 = new TextField(20);
	t2.setBounds(90, 140, 60, 20);
	t3 = new TextField(20);
	t3.setBounds(170, 140, 60, 20);
	t4 = new TextField(20);	
	t4.setBounds(250, 140, 60, 20);
	t5 = new TextField(20);
	t5.setBounds(320, 140, 60, 20);
	t6 = new TextField(20);
	t6.setBounds(90, 180, 60, 20);
	add(b1);
	b1.addActionListener(this);
	b1.setActionCommand("a");
	add(b2);
	b2.addActionListener(this);
	b2.setActionCommand("b");
	add(b3);
	b3.addActionListener(this);
	b3.setActionCommand("c");

	b4 = new Button("Done");
	b4.setBounds(320, 320, 57, 24);
	b5 = new Button("Return"); 
	b5.setBounds(20, 320, 57, 24);  // Add file functionality to this
	b4.addActionListener(this);
	b4.setActionCommand("d");

	b5.addActionListener(this);
	b5.setActionCommand("e");
	add(b4);
	add(b5);
	setSize(400,400);
	setVisible(true);
	setTitle("Quiz Generator");

	FTerminator t = new FTerminator();
	addWindowListener(t);
	
	}

	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		String y = "";
		if(cmd.equals("a")){
		add(l1);
		add(t1);
		add(l3);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(l2);
		add(t6);
		add(l4);
		l2.setVisible(true);
		t3.setVisible(true);
		t4.setVisible(true);
		t5.setVisible(true);
		t2.setVisible(true);
		setVisible(true); // This is necessary to show the components
		l4.setVisible(false);
		label = 1;
		}
		else if(cmd.equals("b")){
		add(l1);
		add(t1);
		add(l3);
		add(t6);
		add(l4);
		setVisible(true);
		l4.setVisible(false);
		l2.setVisible(false);
		t3.setVisible(false);
		t4.setVisible(false);
		t5.setVisible(false);
		t2.setVisible(false);
		label = 3;
		}
		else if(cmd.equals("c")){
		add(l1);
		add(t1);
		add(l3);
		add(t6);
		add(l4);
		setVisible(true);
		l4.setVisible(false);
		l2.setVisible(false);
		t3.setVisible(false);
		t4.setVisible(false);
		t5.setVisible(false);
		t2.setVisible(false);
		label = 2;
		}
		else if(cmd.equals("d")){
		if(label == 2) 
		y = t1.getText();
		
		if(label == 3) 
		y = t1.getText() + "(T/F)";
	
		else if(label == 1)
		y = t1.getText() + " a)" + t2.getText() + ", b)"+ t3.getText() +", c)"+ t4.getText() +", d)"+ t5.getText();
		int flag = 0;
		String z = t6.getText();

		if(z.equals("")) flag = 1;
		if(y.equals("")) flag = 1;

		if(flag == 0) {
		try{
		
		FileWriter fWriter = new FileWriter("jques.txt", true);
         	BufferedWriter writer = new BufferedWriter(fWriter);
          	writer.write(System.getProperty("line.separator") + y);
          	//writer.newLine();
         	 writer.close();
        	}catch(IOException ie)
		{
		System.out.println(ie);
		}

		try{
		
		FileWriter fWriter = new FileWriter("jans.txt", true);
          	BufferedWriter writer = new BufferedWriter(fWriter);
          	writer.write(System.getProperty("line.separator") + z);
          	//writer.newLine();
         	 writer.close();
		}catch(IOException ze)
		{
		System.out.println(ze);
		}

		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
			
		//add(l4);
		l4.setVisible(true);

		}
		}
		else if(cmd.equals("e")){
		this.dispose(); //For Closing the Current Frame
		new JSimpleFrame(); 
		}
		
}

}
