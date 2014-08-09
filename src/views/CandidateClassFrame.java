package views;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Nicolas Burroni
 * @since 7/4/2014
 */
public class CandidateClassFrame extends JInternalFrame {

	private JPanel attributesPanel, methodsPanel;

	public CandidateClassFrame(String className, List<String> attributes, List<String> methods){
		super(className, true, false, false, true);
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		attributesPanel = new JPanel();
		methodsPanel = new JPanel();
		attributesPanel.setLayout(new BoxLayout(attributesPanel, BoxLayout.Y_AXIS));
		methodsPanel.setLayout(new BoxLayout(methodsPanel, BoxLayout.Y_AXIS));
		addAttributesAndMethods(attributes, methods);
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(attributesPanel, constraints);
		constraints.gridy = 1;
		add(methodsPanel, constraints);
		setMinimumSize(new Dimension(150, 150));
		setSize(200, 250);
	}

	private void addAttributesAndMethods(List<String> attributes, List<String> methods){
		for (String attribute : attributes) {
			attributesPanel.add(new JLabel(attribute));
		}
		attributesPanel.add(Box.createVerticalStrut(3));
		attributesPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		for (String method : methods) {
			methodsPanel.add(new JLabel((method)));
		}
	}

}
