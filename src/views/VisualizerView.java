package views;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Nicolas Burroni
 * @since 5/27/2014
 */
public class VisualizerView extends JFrame{

	private JPanel root;
	private JTabbedPane tabbedPane1;
	private JTextArea textArea1;
	private JDesktopPane classesPane;
	private JPanel classesPanel;

	public VisualizerView() {
		super();
		setContentPane(root);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int inset = 60;
		setBounds(inset, inset,
				screenSize.width  - inset*2,
				screenSize.height - inset*2);
		//setMinimumSize(new Dimension(500, 500));
		setLocationRelativeTo(null);
	}

	public void addCandidateClass(String className, List<String> attributes, List<String> methods){
		CandidateClassFrame ccdFrame = new CandidateClassFrame(className, attributes, methods);
		ccdFrame.setVisible(true); //necessary as of 1.3
		classesPane.add(ccdFrame);
		try {
			ccdFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
	}

	private void createUIComponents() {
		classesPane = new JDesktopPane();
	}
}
