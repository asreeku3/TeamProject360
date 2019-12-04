package TextEditor;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;


public class teamProject extends JFrame
{
	public static void main(String[] args)
	{
		new teamProject() ; 
	}
	
	public teamProject()
	{
		this.setSize(400,400) ; 
		Toolkit tk = Toolkit.getDefaultToolkit() ; 
		Dimension dim = tk.getScreenSize() ; 
		
		int xPos = (dim.width/2) - (this.getWidth() / 2) ; 
		int yPos = (dim.height/2) - (this.getHeight() / 2) ;
		this.setLocation(xPos, yPos) ; 
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("GUI");
		
		JPanel thePanel = new JPanel() ; 
		
		//DISPLAY TEXTAREA 
		JTextArea textArea1 ; 
		textArea1 = new JTextArea(10, 20) ;
		textArea1.setText("Display");
		textArea1.setLineWrap(true) ;
						
		JScrollPane scrollBar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		thePanel.add(scrollBar1) ; 
		
		//OPEN BUTTON
		JButton bt1 = new JButton("Open") ; 
		bt1.setText("Open");
		bt1.setToolTipText("Click to open a .txt File");
		bt1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				coding of  = new coding() ; 
				try
				{
					of.fileReader();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				textArea1.setText(of.sb.toString());
			}
		});
		thePanel.add(bt1) ; 
		
		//SAVE BUTTON
		JButton bt2 = new JButton("Save") ; 
		bt2.setText("Save");
		bt2.setToolTipText("Click to save the File");
		thePanel.add(bt2) ; 
		
		//FORMAT BUTTON
		JButton bt3 = new JButton("Format") ; 
		bt3.setText("Format");
		bt3.setToolTipText("Click to get the output");
		thePanel.add(bt3) ; 
		
		
		//ERRORS TEXTAREA
		JTextArea textArea2 = new JTextArea(10, 20) ;
		textArea2.setText("Errors");
		textArea2.setLineWrap(true) ;
		
		JScrollPane scrollBar2 = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		thePanel.add(scrollBar2) ; 
		
		
		this.add(thePanel); 
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

}
