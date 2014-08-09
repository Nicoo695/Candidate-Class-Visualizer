package views;

import javax.swing.*;

/**
 * @author Nicolas Burroni
 * @since 7/26/2014
 */
public class LegacyChooserView extends JFrame{


	private JPanel root;

	public LegacyChooserView(){
		setContentPane(root);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) {}
	}

	public String chooseLegacyFile(){
		JFileChooser chooser = new JFileChooser();
		setVisible(false);
		JFrame chooserFrame = new JFrame();
		chooserFrame.setSize(300, 300);
		chooserFrame.setLocationRelativeTo(null);
		int choice = chooser.showOpenDialog(chooserFrame);
		String returnVal;
		if(choice == JFileChooser.ERROR_OPTION){
			returnVal = null;
		} else if (choice == JFileChooser.CANCEL_OPTION){
			setVisible(true);
			returnVal = "";
		} else {
			returnVal = chooser.getSelectedFile().getAbsolutePath();
		}

		return returnVal;
	}

}
