package main.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import resources.TextManagement;

/**
 * This class manage the PVE (player vs enviorment) mode.
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class Pve {
	private static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
	private static Grid positionGrid = new Grid(300, 200);
	private static Navy navy = new Navy();
	private static int[][] possiblePositions = new int[10][10];
	private static List<List<int[]>> randomNavy = new ArrayList<>();
	private static Grid attackGrid = new Grid(950, 200, positionGrid);
	private static Random random = new Random();
	private static List<int[]> randAttacksMade = new ArrayList<>();
	private static List<Boolean> randAttacksHit = new ArrayList<>();
	private static int consecutiveMissedAttacks = random.nextInt(0, 2);

	
	
	/**
	 * @return the grid (JLabel) to attack the computer navy
	 */
	public static Grid getAttackGrid() {
		return attackGrid;
	}
	
	
	/**
	 * @return the grid (JLabel) to place the ships
	 */
	public static Grid getPositionGrid() {
		return positionGrid;
	}
	
	
	/**
	 * @return the grid (JLabel) to place the ships
	 */
	public static Navy getNavy() {
		return navy;
	}
	
	public static List<List<int[]>> getRandomNavy() {
		setPossiblePositions();
		generateRandomNavy();
		
		return randomNavy;
	}
	
	private static void setPossiblePositions() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				possiblePositions[i][j] = 0;		// 0 libero, 1 occupato
			}
		}
	}
	
	private static int[] checkLastHits() {
		int range = 8;
		int[] missAttack = {-1,-1};
		
		if (randAttacksMade.size() < 8) {
			range = randAttacksMade.size();
		}
		
		for (int i = 0; i < range; i++) {
			if(randAttacksHit.get(i)) {
				return randAttacksMade.get(i);
			}
		}
		
		return missAttack;
	}
	
	

	private static int[] makeBonusAttack(List<Navy> playerNavy, Grid navyGrid) {
		boolean startAttack = false;
		int[] bonusAttack = null;


		while (!startAttack) {
			startAttack = true;
			int randShip = random.nextInt(0, 10);
			int shipSize = playerNavy.get(randShip).getShipSize();
			int randShipBox = random.nextInt(0, shipSize);
			bonusAttack = playerNavy.get(randShip).getShipPosition().get(randShipBox);
			
			for (int[] oldAttack : randAttacksMade) {
				if (bonusAttack[0] == oldAttack[0] && bonusAttack[1] == oldAttack[1]) {
					startAttack = false;
					break;
				}
			}
		}
		return bonusAttack;
		
	}
	
	/**
	 * @return the grid (JLabel) to place the ships
	 */
	public static void makeRandomAttack(List<Navy> playerNavy, Grid navyGrid) {
		TextManagement textManage = Main.getTextManage();
		List<Integer> triedDirections= new ArrayList<>();
		int [] randAttack = new int[2];
		int [] lastHit = checkLastHits();
		int attacksTriedNearLastHit = 0;
		boolean hitted = false;
		boolean startAttack = false;
		
		
		while(!startAttack) {
			startAttack = true;

			if (consecutiveMissedAttacks > 0) {
				randAttack = makeBonusAttack(playerNavy, navyGrid);
				break;
				
			} else if (lastHit[0] != -1 && attacksTriedNearLastHit < 8) {
				int direction = random.nextInt(0, 8);
				
				if (triedDirections.contains(direction)) {
					startAttack = false;
					continue;
				}
				
				randAttack[0] = lastHit[0];
				randAttack[1] = lastHit[1];
				
				
				switch(random.nextInt(0, 8)) {
					case 0:
						randAttack[0]++;
						break;
					case 1:
						randAttack[0]--;
						break;
					case 2:
						randAttack[1]++;
						break;
					case 3:
						randAttack[1]--;
						break;
					case 4:
						randAttack[0]++;
						randAttack[1]++;
						break;
					case 5:
						randAttack[0]--;
						randAttack[1]--;
						break;
					case 6:
						randAttack[0]++;
						randAttack[1]--;
						break;
					case 7:
						randAttack[0]--;
						randAttack[1]++;
						break;
				}
				
				if ( randAttack[0] < 0 || randAttack[1] < 0 || randAttack[0] > 9 || randAttack[1] > 9 ) {
					attacksTriedNearLastHit += 1;
					startAttack = false;
					continue;
				}
				attacksTriedNearLastHit += 1;
				
			} else {
				randAttack[0] = random.nextInt(0, 10);
				randAttack[1] = random.nextInt(0, 10);
				consecutiveMissedAttacks += 1;
			}

			for (int[] oldAttack : randAttacksMade) {
				if ( randAttack[0] == oldAttack[0] && randAttack[1] == oldAttack[1] ) {
					startAttack = false;
					break;
				}
			}
			
		}
		
		// per ogni nave nella flotta del giocatore
		hit:
		for (Navy ship : playerNavy) {
			// per ogni casella occupata dalla nave
			for (int[] shipPos : ship.getShipPosition()) {								
				// se la casella occupata dalla nave è uguale alla casella colpita dal computer
				if (randAttack[0] == shipPos[0] && randAttack[1] == shipPos[1]) {
					hitted = true;
					break hit;
				}
			}

		}

		if (hitted) {
			consecutiveMissedAttacks = 0;
			navyGrid.getHitList().get(randAttack[0] * 10 + randAttack[1]).setVisible(true);
			textManage.hitMessage(2, letters[randAttack[1]] + "" + randAttack[0]);
		} else { 
			navyGrid.getMissList().get(randAttack[0] * 10 + randAttack[1]).setVisible(true);
			textManage.missMessage(2, letters[randAttack[1]] + "" + randAttack[0]); 
		}
		
		randAttacksMade.add(0, randAttack);
		randAttacksHit.add(0, hitted);
	}
	
	private static void generateRandomNavy() {
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
					randX = random.nextInt(0, 10);
					randY = random.nextInt(0, 10 - shipSize);
				} else {
					randX = random.nextInt(0, 10 - shipSize);
					randY = random.nextInt(0, 10);
				}

				occupied = false;
				// se il punto generato è libero (altrimenti ne seleziono un altro)
				if (possiblePositions[randY][randX] == 0) {
					
					// controllo ai lati per evitare di avere tutte le navi appiccicate
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
	
}
