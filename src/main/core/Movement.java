package main.core;

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
	private Ships ship;

	private Point initialPostion;
	
	public Movement(Ships ship, Point initialPostion) {
		this.ship = ship;
		this.initialPostion = initialPostion;
		ship.addMouseListener(this);
		ship.addMouseMotionListener(this);
		
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
	public void mouseClicked(MouseEvent event) {
	  if (event.getClickCount() == 2 && event.getButton() == MouseEvent.BUTTON1) {
		    ship.rotateShip();
	  }
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
//			for (Ships tmpShip : Main.getShips().getNavy()) {
//				
//			}
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
