package views;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Nicolas Burroni
 * @since 7/26/2014
 */
public class ViewsManager {

	private LegacyFileChooserView chooserView;
	private VisualizerView visualizerView;

	public ViewsManager(){
		chooserView = new LegacyFileChooserView();
	}

	public void showLegacyFileChooser(ActionListener browseButtonListener){
		chooserView.setVisible(true);
		chooserView.addBrowseButtonListener(browseButtonListener);
	}

	public String browseLegacyFile(){
		chooserView.setVisible(false);
		String result = showFileChooser();
		if(result == null){
			chooserView.setVisible(true);
			return null;
		} else return result;
	}

	public String showFileChooser(){
		String result = chooserView.browseLegacyFile();
		if(result == null){
			JOptionPane.showMessageDialog(new JFrame(), LanguageManager.getString("browseError"), "Error", JOptionPane.ERROR_MESSAGE);
			return showFileChooser();
		} else if (result.equals("")){
			return null;
		} else return result;
	}
}
