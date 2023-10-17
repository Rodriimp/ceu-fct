package proyecto;

import javax.swing.JPanel;

public abstract class View extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 819842925717360172L;

	protected App appController;

	public View(App appControler) {
		this.appController = appControler;
	}

}
