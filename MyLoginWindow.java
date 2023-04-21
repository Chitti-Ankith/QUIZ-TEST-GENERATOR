import java.awt.*;
import java.awt.event.*;



class FTerminator extends WindowAdapter{
	
	public void windowClosing(WindowEvent event){ 
	
		System.exit(0);
	}
	}



class MyLoginWindow extends Frame implements ActionListener
{
    
	TextField name,pass,result;
    	Button b1,b2;
    	Label l1;

    MyLoginWindow()
    {
        setLayout(new FlowLayout());
        this.setLayout(null);
        Label n=new Label("Name:",Label.CENTER);
        Label p=new Label("password:",Label.CENTER);
        name=new TextField(20);
        pass=new TextField(20);
	result = new TextField(20);
        pass.setEchoChar('#');
        b1=new Button("Submit");
	result.setEditable(false);
        this.add(n);
        this.add(name);
        this.add(p);
        this.add(pass);
        add(b1);
	this.add(result);
	b1.addActionListener(this);
        n.setBounds(70,90,90,60);
        p.setBounds(70,130,90,60);
        name.setBounds(200,100,90,20);
        pass.setBounds(200,140,90,20);
	result.setBounds(200,180,90,20);
        b1.setBounds(100,260,70,40);
	setSize(400,400);
	setVisible(true);
	setTitle("Quiz Generator");


	FTerminator t = new FTerminator();
	addWindowListener(t);

    }

public void actionPerformed(ActionEvent e)
   {                   
     String str1 = name.getText();
     String str2 = pass.getText();
                        
     if(str1.equals("ankith") && str2.equals("ankith"))
     {
       result.setText("VALID");
	this.dispose();
	Subject s = new Subject();
		
     }
     else
     {
       result.setText("INVALID");
     }
   }	





    public static void main(String args[])
    {
        MyLoginWindow ml=new MyLoginWindow();

    }
}