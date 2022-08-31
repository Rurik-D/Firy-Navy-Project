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
		    borderCheck();
	  }
	}

	@Override
	public void mousePressed(MouseEvent event) {
		X = event.getX();
		Y = event.getY();
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		borderCheck();
		ship.updatePlayerPosition();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	
	private void borderCheck() {
		int currentX = ship.getX();
		int currentY = ship.getY();
		int componentW = ship.getWidth();
		int componentH = ship.getHeight();
		int currentBoxX;
		int currentBoxY;
		
		if (gridX < currentX  + 20 && currentX + componentW - 20 < gridX + gridW && gridY < currentY + 20 && currentY + componentH - 20 < gridY + gridH) {
			boolean occupied = false;
			if (ship.getPlayerPosition().get(0)[0] != -1) {
				boxOccupied:
				for (Ships tmpShip : Main.getShips().getNavy()) {
					//se la nave analizzata non è la nave passata a movement
					if (ship.getShipIndex() != tmpShip.getShipIndex()) {
					//	per ogni cella occupata dalla nave
						for (int[] box : ship.getPlayerPosition()) {
					//		per ogni cella occupata dalle atre navi
							for (int[] box2 : tmpShip.getPlayerPosition()) {
					//			se la cella della nava occupa la cella di un'altra nave
								if (box[0] == box2[0] && box[1] == box2[1]) {
					//				rimando la nave alla posizione iniziale
									ship.resetLocation(initialPostion);
									occupied = true;
									break boxOccupied;
								}
							}
						}
					}
				}
			}
			if (!occupied) {
				currentBoxX = ((int) (currentX - gridX) / boxSide) * boxSide + gridX;
				currentBoxY = ((int) (currentY - gridY) / boxSide) * boxSide + gridY;
				ship.setLocation(currentBoxX, currentBoxY);
			}
		} else {
			ship.resetLocation(initialPostion);
		}
	}
	
}
