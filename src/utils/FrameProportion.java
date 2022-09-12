package utils;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public interface FrameProportion{
	/*
	 * With these first three lines the program obtains the screen size and 
	 * saves it in two final variables (width and height), on which all the 
	 * proportions of the window will be based.
	 */
	final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	final int WIDTH = (int)screenSize.getWidth();
	final int HEIGHT = (int)screenSize.getHeight();
//	final int WIDTH = 1536;
//	final int HEIGHT = 864;

	final int buttonX = (int)Math.round(WIDTH * 4.427 / 100);
	final int buttonY = (int)Math.round(HEIGHT * 78.587 / 100);
	final int buttonW = (int)Math.round(WIDTH * 17.578 / 100);
	final int buttonH = (int)Math.round(HEIGHT * 4.629 / 100);
	
	final int yesBtnX = (int)Math.round(WIDTH * 6.510 / 100);
	final int yesBtnY = (int)Math.round(HEIGHT * 61.342 / 100);
	final int yesBtnW = (int)Math.round(WIDTH * 7.812 / 100);
	final int noBtnX = (int)Math.round(WIDTH * 16.276 / 100);
	
	final int extLabelW = (int)Math.round(WIDTH * 29.296 / 100);
	final int extLabelX = (int)Math.round(HEIGHT * 2.893 / 100);
	final int extLabelY = (int)Math.round(HEIGHT * 55.555 / 100);
	
	final int fontDim = (int)Math.round((WIDTH + HEIGHT) * 1.458 / 100);
	
	final int titleX = (int)Math.round(WIDTH * 66.40 / 100);
	final int titleY = (int)Math.round(HEIGHT * 8.10 / 100);
	final int titleW = (int)Math.round(WIDTH * 26.04 / 100);
	final int titleH = (int)Math.round(HEIGHT * 57.87 / 100);
	final int titleSpacing = (int)Math.round(HEIGHT * 5.78 / 100);
	final int titleFontDim = (int)Math.round((WIDTH + HEIGHT) * 2.08 / 100);
	
	final int titleLblW = (int)Math.round(WIDTH * 13.02 / 100);
	final int titleLblH = (int)Math.round(HEIGHT * 11.57 / 100);
	
	final int pveMenuX= (int)Math.round(WIDTH * 5.078 / 100);
	final int selectNickX= (int)Math.round(WIDTH * 5.859 / 100);
	final int nicknameBtnY = (int)Math.round(HEIGHT * 21.99 / 100);
	final int confirmBtnY= (int)Math.round(HEIGHT * 27.199 / 100);
	final int startGameBtnY = (int)Math.round(HEIGHT * 50.347 / 100);
	final int selectNickW= (int)Math.round(WIDTH * 15.299 / 100);
	final int pveMenuW = (int)Math.round(WIDTH * 16.276 / 100);
	final int nicknameBtnW = (int)Math.round(WIDTH * 13.02 / 100);
	final int nicknameBtnH = (int)Math.round(HEIGHT * 11.57 / 100);
	
	final int avatarX= (int)Math.round(WIDTH * 7.291 / 100);
	final int avatarY = (int)Math.round(HEIGHT * 33.333 / 100);
	final int avatarSide = (int)Math.round(WIDTH * 3.906 / 100);
	final int avatarSpacing = (int)Math.round(WIDTH * 4.101 / 100);

	final int lessVolumeBtnX = (int)Math.round(WIDTH * 7.161 / 100);
	final int volumeLevelX = (int)Math.round(WIDTH * 11.718 / 100);
	final int moreVolumeBtnX= (int)Math.round(WIDTH * 15.625 / 100);
	final int volumeBtnsY = (int)Math.round(HEIGHT * 71.412 / 100);
	final int lessVolumeBtnW = (int)Math.round(WIDTH * 3.906 / 100);
	final int volumeLevelW = (int)Math.round(WIDTH * 6.51 / 100);
	
	final int itaBtnY = (int)Math.round(HEIGHT * 68.287 / 100);
	final int engBtnY = (int)Math.round(HEIGHT * 72.916 / 100);
	
	final int gridBorder = 5;
	final int gridSide = 300;
	final int gridY = 200;
	final int posGridX = 300;
	final int attGridX = 950;
	final int paramBorder = 30;
	final int squareSide = (int) 300/10;
	
}
