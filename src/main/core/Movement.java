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
 * This class manage the 2D movement of ships.
 * 
 * @see main.navy.PlayerShip
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class Movement implements MouseListener, MouseMotionListener, FrameProportion{
	private int X, Y;
	private int squareSide = Grid.getSquareSide();
	private PlayerShip ship;
	private Point initialPostion;
	
	public Movement(PlayerShip ship) {
		this.ship = ship;
		ship.addMouseListener(this);
		ship.addMouseMotionListener(this);
		
	}
	
	
    /**
     * Invoked when a mouse button is pressed on a component and then
     * dragged.  {@code MOUSE_DRAGGED} events will continue to be
     * delivered to the component where the drag originated until the
     * mouse button is released (regardless of whether the mouse position
     * is within the bounds of the component).
     * <p>
     * Due to platform-dependent Drag&amp;Drop implementations,
     * {@code MOUSE_DRAGGED} events may not be delivered during a native
     * Drag&amp;Drop operation.
     * @param e the event to be processed
     */
	@Override
	public void mouseDragged(MouseEvent event) {
		if (GameButtons.getConfirmSetupVisible() && !GameButtons.getPause()) {
			event.getComponent().setLocation((event.getX() + event.getComponent().getX() - X), (event.getY() + event.getComponent().getY() - Y));
		}
	}

	
    /**
     * Invoked when the mouse cursor has been moved onto a component
     * but no buttons have been pushed.
     * @param e the event to be processed
     */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     * @param e the event to be processed
     */
	@Override
	public void mouseClicked(MouseEvent event) {
	  if (event.getClickCount() == 2 && event.getButton() == MouseEvent.BUTTON1 && GameButtons.getConfirmSetupVisible() && !GameButtons.getPause()) {
		    ship.rotateShip();
		    collisionCheck();
	  }
	}
	

    /**
     * Invoked when a mouse button has been pressed on a component.
     * @param e the event to be processed
     */
	@Override
	public void mousePressed(MouseEvent event) {
		if (GameButtons.getConfirmSetupVisible()) {
			X = event.getX();
			Y = event.getY();
		}
	}
	
	
    /**
     * Invoked when a mouse button has been released on a component.
     * @param e the event to be processed
     */
	@Override
	public void mouseReleased(MouseEvent event) {
		if (GameButtons.getConfirmSetupVisible() && !GameButtons.getPause()) {
			collisionCheck();
			ship.updateShipPosition();
			collisionCheck();
			// checks if each ship has been positioned, if so activate the button to confirm the ships setup
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
	
	
    /**
     * Invoked when the mouse enters a component.
     * @param e the event to be processed.
     */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	
    /**
     * Invoked when the mouse enters a component.
     * @param e the event to be processed.
     */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	
	
	/**
	 * Checks if the ship is inside the grid.
	 */
	private boolean isInsideGrid() {
		int shipX = ship.getX();
		int shipY = ship.getY();
		int shipW = ship.getWidth();
		int shipH = ship.getHeight();
		
		return (gridX < shipX && 
				gridY < shipY && 
				shipX + shipW - paramBorder - posErrTolerance < gridX + gridSide && 
				shipY + shipH - paramBorder - posErrTolerance < gridY + gridSide);
	}

	
	/**
	 * Checks if a certain position does not contain squares occupied
	 * by other ships.
	 */
	private void collisionCheck() {
		int currentSquareX;
		int currentSquareY;
		
		// if the ship is inside the position grid
		if (isInsideGrid()) {
			boolean occupied = false;
			if (ship.getShipPosition().get(0)[0] != -1) {
				squareOccupied:
				for (Ship tmpShip : Pve.getNavy().getPlayerNavy()) {
					// if the analyzed ship is not the ship that was passed to Movement
					if (ship.getShipIndex() != tmpShip.getShipIndex()) {
						// for each square occupied by the ship
						for (int[] square : ship.getShipPosition()) {
							// for each square occupied by others ships
							for (int[] square2 : tmpShip.getShipPosition()) {
								// if one of the squares occupied by the analyzed ship is also occupied by another ship
								if (square[0] == square2[0] && square[1] == square2[1]) {
									// send the ship back to its initial position
									ship.resetLocation();
									occupied = true;
									break squareOccupied;
								}
							}
						}
					}
				}
			}
			// if the position is not occupied
			if (!occupied) {
				currentSquareX = ((int) (ship.getX() - gridX) / squareSide) * squareSide + gridX;
				currentSquareY = ((int) (ship.getY() - gridY) / squareSide) * squareSide + gridY;

				ship.setLocation(currentSquareX, currentSquareY);
			}
		} else {
			ship.resetLocation();
		}
	}
	
}
