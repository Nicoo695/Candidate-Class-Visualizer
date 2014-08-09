package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Nicolas Burroni
 * @since 7/26/2014
 */
public class LegacyChooserView extends JFrame{


	private JPanel root;
	private JButton browseButton;
	private JLabel welcomeLabel;

	public LegacyChooserView(){
		super(LanguageManager.getString("programName"));
		setContentPane(root);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) {}
		setSize(500, 150);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public void addBrowseButtonListener(ActionListener browseButtonListener){
		browseButton.addActionListener(browseButtonListener);
	}

	public String browseLegacyFile(){ //TODO must setVisible false
		JFileChooser chooser = new JFileChooser();
		JFrame chooserFrame = new JFrame();
		chooserFrame.setSize(300, 300);
		chooserFrame.setLocationRelativeTo(null);
		int choice = chooser.showOpenDialog(chooserFrame);
		String returnVal;
		if(choice == JFileChooser.ERROR_OPTION){
			returnVal = null;
		} else if (choice == JFileChooser.CANCEL_OPTION){  //TODO must setVisible true
			returnVal = "";
		} else {
			returnVal = chooser.getSelectedFile().getAbsolutePath();
		}
		return returnVal;
	}

}
