package main.core;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.gui.GameButtons;
import main.gui.Grid;
import main.navy.PlayerShip;
import main.navy.Ship;
import utils.FrameProportion;


/**
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class Movement implements MouseListener, MouseMotionListener, FrameProportion{
	private int X, Y;
	private int squareSide = Grid.getSquareSide();
	private PlayerShip ship;
	private Point initialPostion;
	
	public Movement(PlayerShip ship, Point initialPostion) {
		this.ship = ship;
		this.initialPostion = initialPostion;
		ship.addMouseListener(this);
		ship.addMouseMotionListener(this);
		
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		if (GameButtons.getConfirmSetupVisible() && !GameButtons.getPause()) {
			event.getComponent().setLocation((event.getX() + event.getComponent().getX() - X), (event.getY() + event.getComponent().getY() - Y));
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent event) {
	  if (event.getClickCount() == 2 && event.getButton() == MouseEvent.BUTTON1 && GameButtons.getConfirmSetupVisible() && !GameButtons.getPause()) {
		    ship.rotateShip();
		    collisionCheck();
	  }
	}

	@Override
	public void mousePressed(MouseEvent event) {
		if (GameButtons.getConfirmSetupVisible()) {
			X = event.getX();
			Y = event.getY();
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if (GameButtons.getConfirmSetupVisible() && !GameButtons.getPause()) {
			collisionCheck();
			ship.updateShipPosition();
			collisionCheck();
			// controllo se ogni nave � stata posizionata, nel caso attivo il bottone per confermare il setup delle navi
			boolean allPositioned = true;
			for (Ship s : Pve.getNavy().getPlayerNavy()) {
				if (s.getShipPosition().get(0)[0] == -1) {
					allPositioned = false;
					break;
				}
			}
			GameButtons.setConfirmSetupEnabled(allPositioned);
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
	
	
	private void collisionCheck() {
		int currentX = ship.getX();
		int currentY = ship.getY();
		int shipW = ship.getWidth();
		int shipH = ship.getHeight();
		int currentSquareX;
		int currentSquareY;
		
		if (posGridX - posErrTolerance < currentX && 
				gridY - posErrTolerance  < currentY && 
				currentX + shipW + paramBorder - posErrTolerance < posGridX + gridSide && 
				currentY + shipH + paramBorder  - posErrTolerance < gridY + gridSide) {
			
			boolean occupied = false;
			if (ship.getShipPosition().get(0)[0] != -1) {
				squareOccupied:
				for (Ship tmpShip : Pve.getNavy().getPlayerNavy()) {
					//se la nave analizzata non � la nave passata a movement
					if (ship.getShipIndex() != tmpShip.getShipIndex()) {
					//	per ogni cella occupata dalla nave
						for (int[] square : ship.getShipPosition()) {
					//		per ogni cella occupata dalle atre navi
							for (int[] square2 : tmpShip.getShipPosition()) {
					//			se la cella della nava occupa la cella di un'altra nave
								if (square[0] == square2[0] && square[1] == square2[1]) {
					//				rimando la nave alla posizione iniziale
									ship.resetLocation(initialPostion);
									occupied = true;
									break squareOccupied;
								}
							}
						}
					}
				}
			}
			if (!occupied) {
				currentSquareX = ((int) (currentX - posGridX) / squareSide) * squareSide + posGridX;
				currentSquareY = ((int) (currentY - gridY) / squareSide) * squareSide + gridY;

				ship.setLocation(currentSquareX, currentSquareY);
			}
		} else {
			ship.resetLocation(initialPostion);
		}
	}
	
}
