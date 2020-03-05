import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.Random;

public class Vista {

	private Controlador controlador;
	private VentanaPpal ventanaPpal;

	public Vista (Controlador controlador) {

		this.controlador=controlador;
		this.ventanaPpal=new VentanaPpal(this);

		this.ventanaPpal.setVisible(true);

	}
	
	public void writeTextToClipboard(String s) {
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    Transferable transferable = new StringSelection(s);
	    clipboard.setContents(transferable, null);
	}

	public String generateRandomNick() {

		return this.controlador.generateRandomNick();
	}
}
