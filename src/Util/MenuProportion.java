package Util;

import Frame.Menu;

public abstract class MenuProportion{
		private static int panelWidth = Menu.exitPanel.getWidth();
		private static int panelHeight = Menu.exitPanel.getHeight();
		
		protected static int buttonX = (int)Math.round(Menu.WIDTH * 4.427 / 100);
		protected static int buttonY = (int)Math.round(Menu.HEIGHT * 78.587 / 100);
		protected static int buttonW = (int)Math.round(Menu.WIDTH * 17.578 / 100);
		protected static int buttonH = (int)Math.round(Menu.HEIGHT * 4.629 / 100);
		
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
}
