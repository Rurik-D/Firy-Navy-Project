package main.navy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

import main.gui.Grid;

public class Ship extends JLabel{
	protected List<int[]> shipPosition = new ArrayList<>();
	protected Map<int[], Boolean> shipPos_Hit = new HashMap<>();
	protected int squareSide = Grid.getSquareSide();
	protected int shipW = Grid.getSquareSide();
	protected int shipH;
	protected int xPos;
	protected int yPos = 650;
	protected String type;
	protected int shipIndex;

	public Ship(int xPos, String type, int shipIndex) {
		this.xPos = xPos;
		this.type = type;
		this.shipIndex = shipIndex;
		
	}
	
	/**
	 * 
	 * 
	 */
	public int getShipSize() {
		return Integer.parseInt(type.substring(0, 1));
	}
	
	
	/**
	 * 
	 * 
	 */
	public String getType() {
		return type;
	}
	
	
	/**
	 * 
	 * 
	 */
	public List<int[]> getShipPos_Hit(){
		return shipPosition;
	}
	
	
	/**
	 * 
	 * 
	 */
	public List<int[]> getShipPosition(){
		return shipPosition;
	}
	
	
	/**
	 * 
	 * 
	 */
	public int getShipIndex() {
		return shipIndex;
	}
	
}
