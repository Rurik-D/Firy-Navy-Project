import javax.swing.*;
import java.awt.*;
public class Application 
{
	public static void main(String args[]){
	JFrame win;
	win = new JFrame("La Finestra del Lello");
	Container c = win.getContentPane();
	c.add(new JLabel("Lello ciuccia piselli"));
	win.setSize(500,500);
	win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	win.setVisible(true);
	/*JButton moveButton=new JButton("Move");
	*c.add(moveButton);
	*
	*moveButton.setVisible(true);
	*/
	String lista[] = new String[10];
	for(int i=0;i<lista.length;i++) {
		lista[i]="Elemento Creato Dal Dio Lello"+i;
	}
	JComboBox cBox=new JComboBox(lista);
	c.add(cBox);
	}
}