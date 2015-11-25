import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;


public class Display extends JPanel implements Runnable {
    Data obj_Data;
	public Display(){
		obj_Data=new Data();
		repaint();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public void paint(Graphics g){
		
		super.paint(g);
		this.setBackground(Color.white);
		drawCP(g);
		drawPoly(g);
		if(obj_Data.drawCurve==1){
			drawCurve(g);
		}
		
	}
	
	public void drawCP(Graphics g){
		
		for(int i=0;i<obj_Data.noCP;i++){
			g.fillOval(obj_Data.getControlPointX(i), obj_Data.getControlPointY(i), 5, 5);
			//System.out.println("i am called");
		}
		
	}
	public void drawPoly(Graphics g){
		if(obj_Data.noCP>1){
			for(int i=0;i<obj_Data.noCP-1;i++){
				g.drawLine(obj_Data.getControlPointX(i), obj_Data.getControlPointY(i), obj_Data.getControlPointX(i+1), obj_Data.getControlPointY(i+1));
			}
		}
	}
	
	public void drawCurve(Graphics g){
		g.setColor(Color.BLUE);
		for(int i=0;i<24;i++){
			//g.drawLine(obj_Data.PointsX[i], obj_Data.PointsY[i], obj_Data.PointsX[i+1], obj_Data.PointsY[i+1]);
			g.fillOval(obj_Data.getX(i), obj_Data.getY(i), 1, 1);
			g.drawLine(obj_Data.getX(i), obj_Data.getY(i), obj_Data.getX(i+1), obj_Data.getY(i+1));
		}
	}

}
