package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Nicolas Burroni
 * @since 7/4/2014
 */
public class CandidateClassFrame extends JInternalFrame {

	private JPanel attributesPanel, methodsPanel;

	public CandidateClassFrame(String className, List<String> attributes, List<String> methods, List<String> methodBodies, ActionListener methodButtonListener){
		super(className, true, false, false, true);
		setFrameIcon(null);
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		attributesPanel = new JPanel();
		methodsPanel = new JPanel();
		attributesPanel.setLayout(new BoxLayout(attributesPanel, BoxLayout.Y_AXIS));
		methodsPanel.setLayout(new BoxLayout(methodsPanel, BoxLayout.Y_AXIS));
		//Add attributes and methods
		for (String attribute : attributes) {
			attributesPanel.add(new JLabel(attribute));
		}
		attributesPanel.add(Box.createVerticalStrut(3));
		attributesPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		for (int i = 0; i < methods.size(); i++) {
			methodsPanel.add(new MethodButton(methods.get(i), methodBodies.get(i), methodButtonListener));
		}
		//
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(attributesPanel, constraints);
		constraints.gridy = 1;
		add(methodsPanel, constraints);
		setMinimumSize(new Dimension(150, 150));
		setSize(200, 250);
	}

	public class MethodButton extends JButton {

		private String methodBody;

		public MethodButton(String methodName, String methodBody, ActionListener listener) {
			super(methodName);
			this.methodBody = methodName + "\n" + methodBody;
			addActionListener(listener);
			setContentAreaFilled(false);
			setBorderPainted(false);
		}

		public void showMethodBodyFrame(){
			JOptionPane.showMessageDialog(new JFrame(), methodBody, LanguageManager.getString("methodBody"), JOptionPane.PLAIN_MESSAGE);
		}

	}

}
