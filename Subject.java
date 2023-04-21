import java.awt.*;
import java.awt.event.*;


class Subject extends Frame implements ActionListener{

	Button b1,b2;
	Label l1;
	public int sub = 1;
	
	Subject(){
	setLayout(new BorderLayout());

	Panel p1 = new Panel();
	p1.setLayout(new FlowLayout());
	l1 = new Label("Please Select the Subject");
	p1.add(l1);
	add(p1,BorderLayout.NORTH);
	
	Panel p2 = new Panel();
	p2.setLayout(new GridLayout(1,2));
	b1 = new Button("JAVA");
	b2 = new Button("G.K");
	p2.add(b1);
	p2.add(b2);
	add(p2,BorderLayout.CENTER);
	
	b1.addActionListener(this);
	b1.setActionCommand("a");
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
		if(cmd.equals("a"))
		{
			sub = 1;
			new JSimpleFrame();
			this.dispose();
			
		}

		else if(cmd.equals("b"))
		{	
			sub = 2;
			new SimpleFrame();
			this.dispose();
			
		}
	}

}

	