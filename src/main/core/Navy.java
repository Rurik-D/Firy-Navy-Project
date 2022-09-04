package main.core;

import javax.swing.JLabel;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import resources.ImagesManagement;


/**
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class Navy extends JLabel{
	private ResourceBundle imagesBundle = ResourceBundle.getBundle("utils.file/images");
	private int[][] possiblePositions = new int[10][10];
	private List<int[]> shipPosition = new ArrayList<>();
	private List<Navy> playerNavy = new ArrayList<>();
	private List<List<int[]>> randomNavy = new ArrayList<>();
	private int xPos = 200;
	private int yPos = 650;
	private String type;
	private int boxSide = Grid.getBoxSide();
	private int gridX = Pve.getPositionGrid().getX() + Grid.getLblBorder();
	private int gridY = Pve.getPositionGrid().getY() + Grid.getLblBorder();
	private int gridH = Pve.getPositionGrid().getHeight();
	private int shipW = Grid.getBoxSide();
	private int shipH;
	private int shipIndex;
	private Random random = new Random();

	public Navy() {
		setPossiblePositions();
		generateRandomNavy();
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(possiblePositions[i][j] + " ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.print(randomNavy.get(i).size() + " = ");
			for (int j = 0; j < randomNavy.get(i).size(); j++) {
				System.out.print("[" + randomNavy.get(i).get(j)[0] + ", " + randomNavy.get(i).get(j)[1] + "]");
			}
			System.out.println();
		}
		
		for(int i = 0; i < 10; i++) {
			switch (i) {
				case 0:
					playerNavy.add(new Navy(xPos, "5_carrier_up", i));
					break;
				case 1:
					playerNavy.add(new Navy(xPos, "4_battleship_up", i));
					break;
				case 2, 3:
					playerNavy.add(new Navy(xPos, "3_cruiser_up", i));
					break;
				case 4, 5, 6:
					playerNavy.add(new Navy(xPos, "3_submarine_up", i));
					break;
				case 7, 8, 9:
					playerNavy.add(new Navy(xPos, "2_assaultShip_up", i));
					break;
				default:
					break;
		}
			xPos += 50;
		}
		
	}
	
	private Navy(int xPos, String type, int shipIndex) {
		this.xPos = xPos;
		this.type = type;
		this.shipIndex = shipIndex;
		
		switch (type) {
			case "5_carrier_up":
				generateShip();
				break;
			case "4_battleship_up":
				generateShip();
				break;
			case "3_cruiser_up":
				generateShip();
				break;
			case "3_submarine_up":
				generateShip();
				break;
			case "2_assaultShip_up":
				generateShip();
				break;
			default:
				break;
		}
	}
	
	public List<Navy> getPlayerNavy() {
		return playerNavy;
	}
	
	public String getType() {
		return type;
	}
	
	public List<int[]> getShipPosition(){
		return shipPosition;
	}
	
	public int getShipIndex() {
		return shipIndex;
	}
	
	public List<List<int[]>> getRandomNavy() {
		return randomNavy;
	}
	
	private void generateShip() {
		shipH = Integer.parseInt(type.substring(0, 1)) * shipW;
		setShipIcon();
		setVisible(false);
		updateShipPosition();
		Movement move = new Movement(this, new Point(xPos, yPos));
	}
	
	private void setShipIcon() {
		setIcon(ImagesManagement.getImage(shipW, shipH, imagesBundle.getString("image." + type)));
		setBounds(xPos, yPos, shipW, shipH);
	}
	
	private void setPossiblePositions() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				possiblePositions[i][j] = 0;		// 0 libero, 1 occupato
			}
		}
	}
	
	private void generateRandomNavy() {
		boolean vertical;
		boolean occupied;
		boolean found;
		int shipSize;
		int randX;
		int randY;
		
		for (int positioned = 0; positioned < 10; positioned++) {
			List<int[]> randomPosition = new ArrayList<>();

			found = false;
			vertical = random.nextBoolean();
			// definisco il numero delle caselle della nave selezionata
			shipSize = switch (positioned) {
				case 0 				-> 5;
				case 1 				-> 4;
				case 2, 3, 4, 5, 6 	-> 3;
				case 7, 8, 9 		-> 2;
				default -> 0;
			};
			
			// finché non trovo la posizione
			positionFound:
			while (!found) {
				// genero randomicamente x e y
				if (vertical) {
					randX = random.nextInt(0, 9);
					randY = random.nextInt(0, 9 - shipSize);
				} else {
					randX = random.nextInt(0, 9 - shipSize);
					randY = random.nextInt(0, 9);
				}

				occupied = false;
				// se il punto generato è libero (altrimenti ne seleziono un altro)
				if (possiblePositions[randY][randX] == 0) {
					
					if (randX > 0) {
						if (possiblePositions[randY][randX - 1] != 0) { continue; }
					}
					if (randX < 9) {
						if (possiblePositions[randY][randX + 1] != 0) { continue; }

					}
					if (randY > 0) {
						if (possiblePositions[randY - 1][randX] != 0) { continue; }

					}
					if (randY < 9) {
						if (possiblePositions[randY + 1][randX] != 0) { continue; }

					}
					
					// se la nave è in verticale
					if(vertical) {
						
						for (int i = randY; i < randY + shipSize; i++) {							
							int[] randPoint = {randX, i};
							
							// se il punto è libero aggiungo il punto alla lista e setto a 1 il punto su possiblePositions
							if (possiblePositions[i][randX] == 0) {
								
								if (randX > 0) {
									if ( possiblePositions[i][randX - 1] != 0 ) {
										occupied = true;
										randomPosition.clear();
										for (int j = randY; j < i; j++) {
											possiblePositions[j][randX] = 0;
										}
										break;
									}
								}	
								if (randX < 9) {
									if ( possiblePositions[i][randX + 1] != 0 ) {
										occupied = true;
										randomPosition.clear();
										for (int j = randY; j < i; j++) {
											possiblePositions[j][randX] = 0;
										}
										break;
									}
								}

								possiblePositions[i][randX] = positioned+1;
								randomPosition.add(randPoint);
								
							// se il punto è occupato svuoto la lista e resetto i punti su possiblePositions
							} else {
								occupied = true;
								randomPosition.clear();
								for (int j = randY; j < i; j++) {
									possiblePositions[j][randX] = 0;
								}
								break;
							}
							// se la linea di punti non è occupata
						}
						if (!occupied) {
							randomNavy.add(randomPosition);
							found = true;
							break positionFound;
						}
						
					// se la nave è in orizzontale
					} else {
						
						for (int i = randX; i < randX + shipSize; i++) {
							
							int[] randPoint = {i, randY};
							// se il punto è libero aggiungo il punto alla lista e setto a 1 il punto su possiblePositions
							if (possiblePositions[randY][i] == 0) {	
								if (randY > 0) {
									if (possiblePositions[randY - 1][i] != 0) {
										occupied = true;
										randomPosition.clear();
										for (int j = randX; j < i; j++) {
											possiblePositions[randY][j] = 0;
										}
										break;
									}
									
								}
								if (randY < 9) {
									if (possiblePositions[randY + 1][i] != 0) {
										occupied = true;
										randomPosition.clear();
										for (int j = randX; j < i; j++) {
											possiblePositions[randY][j] = 0;
										}
										break;
									}
								}

								possiblePositions[randY][i] = positioned+1;
								randomPosition.add(randPoint);

							// se il punto è occupato svuoto la lista e resetto i punti su possiblePositions
							} else {
								occupied = true;
								randomPosition.clear();
								for (int j = randX; j < i; j++) {
									possiblePositions[randY][j] = 0;
								}
								break;
							}
							// se la linea di punti non è occupata
						}
						if (!occupied) {
							randomNavy.add(randomPosition);
							found = true;
							break positionFound;
						}
						
					}
				}
			}
		}
	}
	
    public void resetLocation(Point p) {
		if (shipW > shipH) {
			int temp = shipW;
			shipW = shipH;
			shipH = temp;
		}
		setBounds(p.x, p.y, shipW, shipH);
		type = type.substring(0, type.length() - 2) + "up";
		
		setIcon(ImagesManagement.getImage(shipW, shipH, imagesBundle.getString("image." + type)));
		shipPosition.clear();
		updateShipPosition();
			
    }
	
	public void rotateShip() {
		int temp = shipW;
		type = switch(type.charAt(type.length() - 2)) {
			case 'u' -> {shipW = shipH; shipH = temp; yield type.substring(0, type.length() - 2) + "ri";}
			case 'r' -> {shipW = shipH; shipH = temp; yield type.substring(0, type.length() - 2) + "do";}
			case 'd' -> {shipW = shipH; shipH = temp; yield type.substring(0, type.length() - 2) + "le";}
			case 'l' -> {shipW = shipH; shipH = temp; yield type.substring(0, type.length() - 2) + "up";}
			default -> "";
		};
		
		
		setIcon(ImagesManagement.getShipImage(shipW, shipH, type));
		setSize(shipW, shipH);
		updateShipPosition();
	}
	
	public void updateShipPosition() {
		int currentBoxX = (int) (this.getX() - gridX) / boxSide;
		int currentBoxY = (int) (this.getY() - gridY) / boxSide;

		if (shipPosition.size() == 0) {
			for (int i = 0; i < Integer.parseInt(type.substring(0, 1)); i++) {
				int[] voidBox = {-1, -1};
				shipPosition.add(voidBox);
			}
		} else if (this.getY() > gridY + gridH  || this.getX() < gridX) {
			for (int i = 0; i < Integer.parseInt(type.substring(0, 1)); i++) {
				shipPosition.get(i)[0] = -1;
				shipPosition.get(i)[1] = -1;
			}
		} else {
			for (int i = 0; i < Integer.parseInt(type.substring(0, 1)); i++) {
				shipPosition.get(i)[0] = currentBoxX;
				shipPosition.get(i)[1] = currentBoxY;
				switch(type.charAt(type.length() - 2)) {
					case 'u', 'd':
						shipPosition.get(i)[1] += i;
						break;
					case 'r', 'l':
						shipPosition.get(i)[0] += i;
						break;
				};
			}
		}
	}
}
