import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class App {
	
	JFrame f;
	JPanel ButtonPanel;
	JButton Plot,Clear,Draw;
	Display obj_Display;
	JLabel Remarks;
	Data obj_Data;
	Algorithm obj_algo;
	public App(){
		
		f=new JFrame("Biezer Curve Application | By Shaharyar");
		f.setSize(800, 600);
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		obj_Data=new Data();
		obj_Display=new Display();
		obj_algo=new Algorithm();
		setButtonPanel();
		obj_Display.setBounds(150, 0, 650, 600);
		Thread t_Display=new Thread(obj_Display);
		t_Display.start();
		obj_Display.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int x=e.getX();
				int y=e.getY();
				Remarks.setText(Integer.toString(x)+" "+ Integer.toString(y));
				obj_Data.insert(x, y);
				//f.add(obj_Display);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			
			
		});
		f.add(obj_Display);
		f.validate();
	}
	
	public void setButtonPanel(){
		ButtonPanel=new JPanel();
		ButtonPanel.setBounds(0, 0, 150, 600);
		ButtonPanel.setLayout(null);
		Plot=new JButton("PLOT POINTS");
		Plot.setBounds(0, 20, 150, 50);
		ButtonPanel.add(Plot);
		Draw=new JButton("DRAW CURVE");
		Draw.setBounds(0, 90, 150, 50);
		ButtonPanel.add(Draw);
		Draw.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				obj_algo.Compute();
				
			}
		});
		Clear=new JButton("NEW");
		Clear.setBounds(0, 160, 150, 50);
		ButtonPanel.add(Clear);
		Clear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				obj_Data.Reset();;
				
			}
		});
		f.add(ButtonPanel);
		Remarks=new JLabel();
		Remarks.setBounds(0, 450, 150, 150);
		ButtonPanel.add(Remarks);
		
	}
	
	public static void main(String args[]){
		new App();
	}

}
