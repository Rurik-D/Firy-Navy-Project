package main.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import resources.ImagesManagement;
import resources.TextManagement;


/**
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class Grid extends JLabel{
	private char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
	private static int lblBorder = 5;
	private static int parameterBorder = 30;
	private static int boxSide = (int) 300/10;
	private final int W = 300;
	private final int H = 300;
	private JLabel attackGridCover = ImagesManagement.getGridBackground(parameterBorder, parameterBorder, W, H);
	private Color backgroundColor = Color.orange.darker().darker().darker().darker().darker();
	private List<JLabel> missList = new ArrayList<>();
	private List<JLabel> hitList = new ArrayList<>();
	private Grid navyGrid;
	
	// player grid constructor
	public Grid (int x, int y) {
		addParameters();
		setLayout(null);
		setBounds(x, y, W + parameterBorder + lblBorder, H + parameterBorder + lblBorder);
		setOpaque(true);
		setBackground(backgroundColor);
		setVisible(false);
		setNavyGrid();
	}
	
	// attack grid constructor
	public Grid (int x, int y, Grid navyGrid) {
		this.navyGrid = navyGrid;
		addParameters();
		setLayout(null);
		setBounds(x, y, W + parameterBorder + lblBorder, H + parameterBorder + lblBorder);
		setOpaque(true);
		setBackground(backgroundColor);
		setVisible(false);
		add(attackGridCover);
	}
	
	public static int getLblBorder() {
		return lblBorder;
	}
	
	public static int getBoxSide() {
		return boxSide;
	}
	
	public Grid getGrid() {
		return this;
	}
	
	public int getParameterBorder() {
		return parameterBorder;
	}
	
	public List<JLabel> getHitList() {
		return hitList;
	}
	
	public List<JLabel> getMissList() {
		return missList;
	}
	
	
	private  void setNavyGrid() {
		for (int i = 0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				JButton box;
				JLabel hitLbl;
				JLabel missLbl;
				
				hitLbl = new JLabel("");
				hitLbl.setName( letters[j] +  "" + i );
				hitLbl.setBounds(boxSide*i + parameterBorder, boxSide*j + parameterBorder, boxSide, boxSide);
				hitLbl.setVisible(false);
				hitLbl.setIcon(ImagesManagement.getHitLbl(boxSide));
				
				missLbl = new JLabel("");
				missLbl.setName( letters[j] +  "" + i );
				missLbl.setBounds(boxSide*i + parameterBorder, boxSide*j + parameterBorder, boxSide, boxSide);
				missLbl.setVisible(false);
				missLbl.setIcon(ImagesManagement.getMisLbl(boxSide));
				
				box = new JButton("");
				box.setName( letters[j] +  "" + i );
				box.setBounds(boxSide*i + parameterBorder, boxSide*j + parameterBorder, boxSide, boxSide);
				box.setOpaque(false);
				box.setContentAreaFilled(false);
				box.setVisible(true);
				box.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker().darker(), 1));
				box.setBorderPainted(true);
				box.setEnabled(false);
				
				add(missLbl);
				add(hitLbl);
				add(box);
				
				hitList.add(hitLbl);
				missList.add(missLbl);
				
			}
		}
		add(ImagesManagement.getGridBackground(parameterBorder, parameterBorder, W, H));
	}
	
	public void setAttackGrid(List<List<int[]>> computerNavy, List<Navy> playerNavy) {	
		TextManagement textManage = Main.getTextManage();
		attackGridCover.setVisible(false);
		
		for (int i = 0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				JButton box;
				JLabel hitLbl;
				JLabel missLbl;
				
				hitLbl = new JLabel("");
				hitLbl.setName( i + "" + j );
				hitLbl.setBounds(boxSide*i + parameterBorder, boxSide*j + parameterBorder, boxSide, boxSide);
				hitLbl.setVisible(false);
				hitLbl.setIcon(ImagesManagement.getHitLbl(boxSide));
				
				missLbl = new JLabel("");
				missLbl.setName( letters[j] +  "" + i );
				missLbl.setBounds(boxSide*i + parameterBorder, boxSide*j + parameterBorder, boxSide, boxSide);
				missLbl.setVisible(false);
				missLbl.setIcon(ImagesManagement.getMisLbl(boxSide));
				
				box = new JButton("");
				box.setName( letters[j] +  "" + i );
				box.setBounds(boxSide*i + parameterBorder, boxSide*j + parameterBorder, boxSide, boxSide);
				box.setOpaque(false);
				box.setContentAreaFilled(false);
				box.setVisible(true);
				box.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker().darker(),1));
				box.setBorderPainted(true);
				box.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						boolean hit = false;
						hit:
						for (List<int[]> ship: computerNavy) {
							for (int[] occupiedBox : ship) {	

								if ( box.getName().equals(letters[occupiedBox[1]] + "" + occupiedBox[0])) {
									hit = true;
									break hit;
								}
							}
						}
						if (hit) { 
							textManage.hitMessage(1, box.getName());
							hitLbl.setVisible(true);
						} else {
							textManage.missMessage(1, box.getName()); 
							missLbl.setVisible(true);
						}
						
						box.setVisible(false);
						
						Pve.makeRandomAttack(playerNavy, navyGrid);
						
					}
				});
				add(missLbl);
				add(hitLbl);
				add(box);
			}
		}
		add(ImagesManagement.getGridBackground(parameterBorder, parameterBorder, W, H));
	}
	
	private void addParameters() {
		Font paramFont = TextManagement.getParameterFont();
		for (int i = 0; i < 10; i++) {
			JLabel number = new JLabel("" + i);
			JLabel letter = new JLabel("" + letters[i]);
			
			number.setFont(paramFont);
			letter.setFont(paramFont);
			
			number.setForeground(Color.white);
			letter.setForeground(Color.white);
			
			number.setBounds(boxSide*i + parameterBorder + (int) boxSide/3, 1, 30, 30);
			letter.setBounds(10, boxSide*i + parameterBorder, 30, 30);
			
			add(number);
			add(letter);
			
			number.setVisible(true);
			letter.setVisible(true);

		}
	}
}
