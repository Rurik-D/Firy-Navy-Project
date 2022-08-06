package Util;

import Frame.Menu;

public abstract class FrameProportion{
		private static int panelWidth = Menu.exitPanel.getWidth();
		private static int panelHeight = Menu.exitPanel.getHeight();
		
		protected static int buttonX = (int)Math.round(Menu.WIDTH * 4.427 / 100);
		protected static int buttonY = (int)Math.round(Menu.HEIGHT * 78.587 / 100);
		protected static int buttonW = (int)Math.round(Menu.WIDTH * 17.578 / 100);
		protected static int buttonH = (int)Math.round(Menu.HEIGHT * 4.629 / 100);
		
		protected static int exitPnlW = (int)Math.round(Menu.WIDTH * 32.552 / 100);
		protected static int exitPnlH = (int)Math.round(Menu.HEIGHT * 23.148 / 100);
		protected static int exitPnlX = (int)Math.round(Menu.WIDTH/2 - exitPnlW/2);
		protected static int exitPnlY = (int)Math.round(Menu.HEIGHT/2 - exitPnlH/2);
		
		protected static int yesBtnX = (int)Math.round(panelWidth * 8.2 / 100);
		protected static int yesBtnY = (int)Math.round(panelHeight * 63.5 / 100);
		protected static int yesBtnW = (int)Math.round(panelWidth * 18.6 / 100);
		protected static int yesBtnH = (int)Math.round(panelHeight * 31.5 / 100);
		protected static int noBtnX = panelWidth - (yesBtnX + yesBtnW);
		
		protected static int extLabelW = (int)Math.round(panelWidth * 64 / 100);
		protected static int extLabelH = (int)Math.round(panelHeight * 10.5 / 100);
		protected static int extLabelX = panelWidth / 2 - extLabelW / 2;
		protected static int extLabelY = (int)Math.round(panelHeight * 25 / 100);
		
		protected static int fontDim = (int)Math.round((panelWidth + panelHeight) * 5 / 100);
		protected static int exitPnlFontDim = (int)Math.round((panelWidth + panelHeight) * 3.571 / 100);
		
		protected static int titleX = (int)Math.round(Menu.WIDTH * 66.40 / 100);
		protected static int titleY = (int)Math.round(Menu.HEIGHT * 8.10 / 100);
		protected static int titleW = (int)Math.round(Menu.WIDTH * 26.04 / 100);
		protected static int titleH = (int)Math.round(Menu.HEIGHT * 57.87 / 100);
		protected static int titleSpacing = (int)Math.round(Menu.HEIGHT * 5.78 / 100);
		protected static int titleFontDim = (int)Math.round((Menu.WIDTH + Menu.HEIGHT) * 2.08 / 100);
		
		protected static int titleLblW = (int)Math.round(Menu.WIDTH * 13.02 / 100);
		protected static int titleLblH = (int)Math.round(Menu.HEIGHT * 11.57 / 100);
		
		protected static int pveMenuX= (int)Math.round(Menu.WIDTH * 5.078 / 100);
		protected static int selectNickX= (int)Math.round(Menu.WIDTH * 5.859 / 100);
		protected static int srnameBtnY = (int)Math.round(Menu.HEIGHT * 21.99 / 100);
		protected static int confirmBtnY= (int)Math.round(Menu.HEIGHT * 27.199 / 100);
		protected static int startGameBtnY = (int)Math.round(Menu.HEIGHT * 50.347 / 100);
		protected static int selectNickW= (int)Math.round(Menu.WIDTH * 15.299 / 100);
		protected static int pveMenuW = (int)Math.round(Menu.WIDTH * 16.276 / 100);
		protected static int srnameBtnW = (int)Math.round(Menu.WIDTH * 13.02 / 100);
		protected static int srnameBtnH = (int)Math.round(Menu.HEIGHT * 11.57 / 100);
		
		protected static int avatarX= (int)Math.round(Menu.WIDTH * 7.291 / 100);
		protected static int avatarY = (int)Math.round(Menu.HEIGHT * 33.333 / 100);
		protected static int avatarSide = (int)Math.round(Menu.WIDTH * 3.906 / 100);
		protected static int avatarSpacing = (int)Math.round(Menu.WIDTH * 4.101 / 100);

		protected static int lessVolumeBtnX = (int)Math.round(Menu.WIDTH * 7.161 / 100);
		protected static int volumeLevelX = (int)Math.round(Menu.WIDTH * 11.718 / 100);
		protected static int moreVolumeBtnX= (int)Math.round(Menu.WIDTH * 15.625 / 100);
		protected static int volumeBtnsY = (int)Math.round(Menu.HEIGHT * 69.444 / 100);
		protected static int lessVolumeBtnW = (int)Math.round(Menu.WIDTH * 3.906 / 100);
		protected static int volumeLevelW = (int)Math.round(Menu.WIDTH * 6.51 / 100);
		
		
}
