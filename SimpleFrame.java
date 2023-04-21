import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SimpleFrame extends Frame implements ActionListener{

	
	TextField t1,t2,t3;
   	 Button insert,modify,delete,generate,ret;
    	Label l1,l2,l3,subname;
	int sel;

	SimpleFrame(){
	
	setLayout(new FlowLayout());
	this.setLayout(null);
	t1 = new TextField(10);
	t1.setBounds(280,80,90,50);
	t2 = new TextField(10);
	t3 = new TextField(10);
	 l1 = new Label("Insert the Question");
	 l2 = new Label("Modify the Question");
	 l3 = new Label("Delete the Question");
	

	insert = new Button("Insert");
	modify = new Button("Modify");
	delete = new Button("Delete");
	generate = new Button("Generate Quiz");
	ret = new Button("Return");
	add(l1);
	add(insert);
	add(l2);
	add(modify);
	add(l3);
	add(delete);
	add(generate);
	add(ret);
	

		subname = new Label("G.K");
		add(subname);
		subname.setVisible(true);
		subname.setBounds(180,40,40,40);
	
	l1.setBounds(70,80,130,60);
	insert.setBounds(200,80,90,50);
	
	l2.setBounds(70,120,130,60);
	modify.setBounds(200,120,90,50);
	
	l3.setBounds(70,160,130,60);
	delete.setBounds(200,160,90,50);
	generate.setBounds(50,280,120,50);
	ret.setBounds(250,280,120,50);

	insert.addActionListener(this);
	insert.setActionCommand("i");
	modify.addActionListener(this);
	modify.setActionCommand("m");
	delete.addActionListener(this);
	delete.setActionCommand("d");
	generate.addActionListener(this);
	generate.setActionCommand("g");	
	ret.addActionListener(this);
	ret.setActionCommand("r");	
	setSize(400,400);
	setVisible(true);
	setTitle("Quiz Generator");
	
	FTerminator t = new FTerminator();
	addWindowListener(t);

	}
	
	public void actionPerformed(ActionEvent e) //ALways have to override this while declaring implements ActionListener
	{
		
		String cmd = e.getActionCommand();
		if(cmd.equals("i")) 
		{
			new InsertFrame();
			this.dispose();
		}
		else if(cmd.equals("m")) 
		{
			new ModifyFrame();
			this.dispose();
		}
		else if(cmd.equals("d")) 
		{	
			new DeleteFrame();
			this.dispose();
		}
		else if(cmd.equals("g")) 
		{
			new GenerateFrame();	
			this.dispose();
		}
		else if(cmd.equals("r")) 
		{
			new Subject();	
			this.dispose();
		}
	}
	
	/*public static void main(String args[])
    	{
        	SimpleFrame m2=new SimpleFrame();

    	}*/

	
}