package main.core;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import main.frame.GameButtons;


/**
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class Movement implements MouseListener, MouseMotionListener{
	private int X, Y;
	private int gridX = Pve.getPositionGrid().getX() + 30;
	private int gridY = Pve.getPositionGrid().getY() + 30;
	private int gridW = Pve.getPositionGrid().getWidth();
	private int gridH = Pve.getPositionGrid().getHeight();
	private int boxSide = Grid.getBoxSide();
	private Navy ship;

	private Point initialPostion;
	
	public Movement(Navy ship, Point initialPostion) {
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
		    collisionCheck();
	  }
	}

	@Override
	public void mousePressed(MouseEvent event) {
		X = event.getX();
		Y = event.getY();
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		collisionCheck();
		ship.updateShipPosition();
		collisionCheck();
		// controllo se ogni nave è stata posizionata, nel caso attivo il bottone per confermare il setup delle navi
		boolean allPositioned = true;
		for (Navy s : Pve.getNavy().getPlayerNavy()) {
			if (s.getShipPosition().get(0)[0] == -1) {
				allPositioned = false;
				break;
			}
		}
		GameButtons.setConfirmSetupEnabled(allPositioned);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	
	private void collisionCheck() {
		int currentX = ship.getX();
		int currentY = ship.getY();
		int shipW = ship.getWidth();
		int shipH = ship.getHeight();
		int paramBorder = Pve.getPositionGrid().getParameterBorder();
		int currentBoxX;
		int currentBoxY;
		
		if (gridX - 20 < currentX && currentX + shipW + paramBorder - 20 < gridX + gridW && gridY - 20  < currentY && currentY + shipH + paramBorder  - 20 < gridY + gridH) {
			boolean occupied = false;
			if (ship.getShipPosition().get(0)[0] != -1) {
				boxOccupied:
				for (Navy tmpShip : Pve.getNavy().getPlayerNavy()) {
					//se la nave analizzata non è la nave passata a movement
					if (ship.getShipIndex() != tmpShip.getShipIndex()) {
					//	per ogni cella occupata dalla nave
						for (int[] box : ship.getShipPosition()) {
					//		per ogni cella occupata dalle atre navi
							for (int[] box2 : tmpShip.getShipPosition()) {
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
