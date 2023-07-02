package sdmcet.oop.cse;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//class for calculating the total marks using inheritance,interface 
class GradingSystem extends JFrame implements ActionListener {
	//Declarations
	JFrame f;
	JButton b;
	Container contentPane;
	JPanel p;
	JLabel l, l1, l2, l3, l4, l5, l7, l8, l9, l10, l11;
	JTextField t1, t2, t3, t4, t5;
	// parametriszed constructor 
	GradingSystem(String title) {
		super(title);
		//creating a button and instantiating 
		b = new JButton("     Calculate   ");
		b.addActionListener(this);
		//adding labels and instantiating 
		l = new JLabel("    GRADING CALCULATOR ");
		l1 = new JLabel("Enter IA1 Marks:");
		l2 = new JLabel("Enter IA2 Marks:");
		l3 = new JLabel("Enter IA3 Marks:");
		l4 = new JLabel("Enter CTA Marks:");
		l5 = new JLabel("Enter SEE Marks:");
		l7 = new JLabel();
		l8 = new JLabel();
		//adding textfields and instantiating 
		t1 = new JTextField(15);
		t2 = new JTextField(15);
		t3 = new JTextField(15);
		t4 = new JTextField(15);
		t5 = new JTextField(15);
		p = new JPanel();
		//adding the labels,textfields and button to panel
		p.add(l);

		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(l3);
		p.add(t3);
		p.add(l4);
		p.add(t4);
		p.add(l5);
		p.add(t5);
		add(p);
		p.add(b);
		p.add(l7);
		p.add(l8);
		//instantiating content pane
		contentPane = this.getContentPane();
		//using Border Layout
		contentPane.add(p, BorderLayout.CENTER);
		contentPane.add(l, BorderLayout.NORTH);
		

	}
	//performs the action of the given event 
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b) {
			int ia1, ia2, ia3, cta,cie;
			double see;
			//exception handling
			
			if (t1.getText().isEmpty() || t1.getText().equalsIgnoreCase("ab")) {
				ia1 = 0;
			} else
				ia1 = Integer.parseInt(t1.getText()); //coverting string to integer

			if (t2.getText().isEmpty() || t2.getText().equalsIgnoreCase("ab")) {
				ia2 = 0;
			} else
				ia2 = Integer.parseInt(t2.getText());//coverting string to integer
			if (t3.getText().isEmpty() || t3.getText().equalsIgnoreCase("ab")) {
				ia3 = 0;
			} else
				ia3 = Integer.parseInt(t3.getText());//coverting string to integer

			if (t4.getText().isEmpty()) {
				cta = 0;
			} else
				cta = Integer.parseInt(t4.getText());//coverting string to integer

			if (t5.getText().isEmpty() || t5.getText().equalsIgnoreCase("ab")) {
			 see = 0;
			} else
				see = Double.parseDouble(t5.getText());//coverting string to double
			
			//implementing try ,catch and throw
			try {
				if (ia1 < 0 || ia1 > 20 || ia2 < 0 || ia2 > 20 || ia3 < 0 || ia3 > 20) {
					throw new ArithmeticException();
				}
			} catch (ArithmeticException ae) {     //  Exception handling 
				JOptionPane.showMessageDialog(f, l9, "IA Marks entered should be in range 0-20",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				if (cta < 0 || cta > 10) {
					throw new ArithmeticException();
				}
			} catch (ArithmeticException ae) {      // Exception handling 
				JOptionPane.showMessageDialog(f, l10, "error: CTA range should be in 0-10", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				if (see < 0 || see > 100) {       // Exception handling 
					throw new ArithmeticException();
				}
			} catch (ArithmeticException ae) {    // Exception handling 
				JOptionPane.showMessageDialog(f, l11, "error: SEE range should be in 0-100", JOptionPane.ERROR_MESSAGE);
				return;
			}

			String tot;
			//ceil function used to round off the values or marks 
			see = Math.ceil(see / 2);
			//calculating the cie
			if (ia2 >= ia1 && ia3 >= ia1) {
				cie= ia2 + ia3 + cta;
			} else if (ia1 >= ia2 && ia3 >= ia2) {
				cie = ia1 + ia3 + cta;
			} else {
				cie = ia1 + ia2 + cta;
			}
			
			if (cie< 20) {
				JOptionPane.showMessageDialog(this, "Student is Detained from taking SEE", "message", //  Exception handling 
						JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
				;

			}
			//converting the marks 38 and 39 to 40 
			if(cie==38 || cie==39) {
				cie=40;
			}
			cie += see;
			//Calculating the grade 
			if (cie<= 100 && cie>= 90)
				tot = "S";

			else if (cie< 90 && cie>= 80)
				tot= "A";

			else if (cie< 80 && cie>= 70)
				tot = "B";

			else if (cie< 70 && cie>= 60)
				tot= "C";

			else if (cie < 60 && cie>= 50)
				tot = "D";
			else if (cie< 50 && cie >= 40)
				tot= "E";
			else 
				tot = "F";

			l7.setText("Total Marks: " + cie + "   ");

			l8.setText("Grade: " + tot);

		}
	}

}

public class GradeCalculationDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//instantiating the window using jframe 
		JFrame f = new GradingSystem("Student Grading System");
		//adding the dimensions of window and close button
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setBounds(200, 200, 350, 400);
		
		f.setResizable(false);
		f.setVisible(true);
	}

}