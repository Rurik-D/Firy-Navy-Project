package main.core;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.frame.Main;

public class Movement implements MouseListener, MouseMotionListener{
	private int X, Y;
	private int gridX = Main.getPlayerGrid().getX() + Grid.getLblBorder();
	private int gridY = Main.getPlayerGrid().getY() + Grid.getLblBorder();
	private int gridW = Main.getPlayerGrid().getWidth();
	private int gridH = Main.getPlayerGrid().getHeight();
	private int boxSide = Grid.getBoxSide();

	


	private Point initialPostion;
	
	public Movement(Component component, Point initialPostion) {
		this.initialPostion = initialPostion;
		component.addMouseListener(this);
		component.addMouseMotionListener(this);
		
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		event.getComponent().setLocation((event.getX() + event.getComponent().getX() - X), (event.getY() + event.getComponent().getY() - Y));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		X = event.getX();
		Y = event.getY();
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		int currentX = event.getComponent().getX();
		int currentY = event.getComponent().getY();
		int componentW = event.getComponent().getWidth();
		int componentH = event.getComponent().getHeight();
		int currentBoxX;
		int currentBoxY;
		
		if (gridX < currentX && currentX + componentW < gridX + gridW && gridY < currentY && currentY + componentH < gridY + gridH) {
			currentBoxX = ((int) (currentX - gridX) / boxSide) * boxSide + gridX;
			currentBoxY = ((int) (currentY - gridY) / boxSide) * boxSide + gridY;

			event.getComponent().setLocation(currentBoxX, currentBoxY);
		} else {
			event.getComponent().setLocation(initialPostion);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
