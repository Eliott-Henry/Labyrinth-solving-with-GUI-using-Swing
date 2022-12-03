package ui_buttons_panel;
import javax.swing.*;

import ui.MazeApp;

public final class SizeChooser extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private final MazeApp mazeApp;
	
	private SizeLabel sizeLabel;
	private PlusSizeButton plusSizeButton;
	private final MinesSizeButton minesSizeButton;
	
	// Besoin d'update ?
	public void notifyForUpdate() {
		sizeLabel.notifyForUpdate();
	}
	
	public SizeChooser(MazeApp mazeApp) {
		super();
		this.mazeApp = mazeApp;
		add(minesSizeButton = new MinesSizeButton(mazeApp));
		add(plusSizeButton = new PlusSizeButton(mazeApp));
		add(sizeLabel = new SizeLabel(mazeApp));
	}
}
