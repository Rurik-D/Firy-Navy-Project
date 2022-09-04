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
	
}
