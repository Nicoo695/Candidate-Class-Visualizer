package views;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Nicolas Burroni
 * @since 7/4/2014
 */
public class CandidateClassPanel extends JPanel {

	private JLabel classNameLabel;
	private JPanel attributesPanel, methodsPanel;


	public CandidateClassPanel(String className, List<String> attributes, List<String> methods){
		super(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
	}

}
