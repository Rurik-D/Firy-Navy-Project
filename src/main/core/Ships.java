package main.core;

import javax.swing.JLabel;

import main.frame.Main;
import resources.ImagesManagement;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;


public class Ships extends JLabel{
	private ResourceBundle imagesBundle = ResourceBundle.getBundle("utils.file/images");
	private int[][] possiblePositions = new int[10][10];
	private List<int[]> playerPosition = new ArrayList<>();
	private List<int[]> randomPosition = new ArrayList<>();
	private List<Ships> navy = new ArrayList<>();
	private List<List<int[]>> randomNavy = new ArrayList<>();
	private int xPos = 200;
	private int yPos = 650;
	private String type;
	private int boxSide = Grid.getBoxSide();
	private int gridX = Main.getPlayerGrid().getX() + Grid.getLblBorder();
	private int gridY = Main.getPlayerGrid().getY() + Grid.getLblBorder();
	private int gridH = Main.getPlayerGrid().getHeight();
	private int shipW = Grid.getBoxSide();
	private int shipH;
	private int shipIndex;
	private Random random = new Random();

	public Ships() {
		setPossiblePositions();
		generateRandomNavy();
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(possiblePositions[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < 10; i++) {
			switch (i) {
				case 0:
					navy.add(new Ships(xPos, "5_carrier_up", i));
					break;
				case 1:
					navy.add(new Ships(xPos, "4_battleship_up", i));
					break;
				case 2, 3:
					navy.add(new Ships(xPos, "3_cruiser_up", i));
					break;
				case 4, 5, 6:
					navy.add(new Ships(xPos, "3_submarine_up", i));
					break;
				case 7, 8, 9:
					navy.add(new Ships(xPos, "2_assaultShip_up", i));
					break;
				default:
					break;
		}
			xPos += 50;
		}
		
	}
	
	private Ships(int xPos, String type, int shipIndex) {
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
	
	public List<Ships> getNavy() {
		return navy;
	}
	
	public String getType() {
		return type;
	}
	
	public List<int[]> getPlayerPosition(){
		return playerPosition;
	}
	
	public int getShipIndex() {
		return shipIndex;
	}
	
	public List<List<int[]>> getrandomNavy() {
		return randomNavy;
	}
	
	private void generateShip() {
		shipH = Integer.parseInt(type.substring(0, 1)) * shipW;
		setShipIcon();
		setVisible(false);
		updatePlayerPosition();
		Movement move = new Movement(this, new Point(xPos, yPos));
		move = null;
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

				System.out.println(randX);
				System.out.println(randY);

				int[] randPoint = {randX, randY};
				occupied = false;
				// se il punto generato è libero (altrimenti ne seleziono un altro)
				if (possiblePositions[randY][randX] == 0) {
					// se la nave è in verticale
					if(vertical) {
						
						occupiedPoint:
						for (int i = randY; i < randY + shipSize; i++) {
							// se il punto è libero aggiungo il punto alla lista e setto a 1 il punto su possiblePositions
							if (possiblePositions[i][randX] == 0) {
								possiblePositions[i][randX] = positioned+1;
								randomPosition.add(randPoint);
							// se il punto è occupato svuoto la lista e resetto i punti su possiblePositions
							} else {
								occupied = true;
								randomPosition.clear();
								for (int j = randY; i < randY + shipSize; j++) {
									possiblePositions[j][randX] = 0;
									break occupiedPoint;
								}
							}
							// se la linea di punti non è occupata
						}
						if (!occupied) {
							List<int[]> tmpRandPos = new ArrayList<>();
							tmpRandPos = randomPosition;
							randomNavy.add(tmpRandPos);
							randomPosition.clear();
							found = true;
							break positionFound;
						}
						
					// se la nave è in orizzontale
					} else {
						
						occupiedPoint:
						for (int i = randX; i < randX + shipSize; i++) {
							// se il punto è libero aggiungo il punto alla lista e setto a 1 il punto su possiblePositions
							if (possiblePositions[randY][i] == 0) {
								possiblePositions[randY][i] = positioned+1;
								randomPosition.add(randPoint);
							// se il punto è occupato svuoto la lista e resetto i punti su possiblePositions
							} else {
								occupied = true;
								randomPosition.clear();
								for (int j = randX; j < randX + shipSize; j++) {
									possiblePositions[randY][j] = 0;
									break occupiedPoint;
								}
							}
							// se la linea di punti non è occupata
						}
						if (!occupied) {
							List<int[]> tmpRandPos = new ArrayList<>();
							tmpRandPos = randomPosition;
							randomNavy.add(tmpRandPos);
							randomPosition.clear();
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
		updatePlayerPosition();
			
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
		updatePlayerPosition();
	}
	
	public void updatePlayerPosition() {
		int currentBoxX = (int) (this.getX() - gridX) / boxSide;
		int currentBoxY = (int) (this.getY() - gridY) / boxSide;

		if (playerPosition.size() == 0) {
			for (int i = 0; i < Integer.parseInt(type.substring(0, 1)); i++) {
				int[] voidBox = {-1, -1};
				playerPosition.add(voidBox);
				System.out.println(playerPosition.get(i)[0] + ", " + playerPosition.get(i)[1]);
			}
		} else if (this.getY() > gridY + gridH  || this.getX() < gridX) {
			for (int i = 0; i < Integer.parseInt(type.substring(0, 1)); i++) {
				playerPosition.get(i)[0] = -1;
				playerPosition.get(i)[1] = -1;
				System.out.println(playerPosition.get(i)[0] + ", " + playerPosition.get(i)[1]);
			}
		} else {
			for (int i = 0; i < Integer.parseInt(type.substring(0, 1)); i++) {
				playerPosition.get(i)[0] = currentBoxX;
				playerPosition.get(i)[1] = currentBoxY;
				switch(type.charAt(type.length() - 2)) {
					case 'u', 'd':
						playerPosition.get(i)[1] += i;
						break;
					case 'r', 'l':
						playerPosition.get(i)[0] += i;
						break;
				};
				System.out.println(playerPosition.get(i)[0] + ", " + playerPosition.get(i)[1]);
			}
			System.out.println();
		}
	}
}
