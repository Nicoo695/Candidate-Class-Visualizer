package views;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Nicolas Burroni
 * @since 7/26/2014
 */
public class ViewsManager {

	private LegacyFileChooserView chooserView;
	private VisualizerView visualizerView;

	public ViewsManager(ActionListener methodButtonListener,
	                           /*ActionListener renameListener, ActionListener deleteListener, ActionListener commentListener,*/ ActionListener rankingListener){
		chooserView = new LegacyFileChooserView();
		visualizerView = new VisualizerView(methodButtonListener, rankingListener);
	}

	public void showStartupDialog(ActionListener browseButtonListener){
		chooserView.setVisible(true);
		chooserView.addBrowseButtonListener(browseButtonListener);
	}

	public void showVisualizer(){
		visualizerView.setVisible(true);
	}

	/**
	 * Shows a file chooser and returns the file path the user selected.
	 * @return The file path the user selected, or null if the user cancelled.
	 */
	public String browseLegacyFile(){
		chooserView.setVisible(false);
		String result = showFileChooser();
		if(result == null){
			chooserView.setVisible(true);
		}
		return result;
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

	public void addLegacyCode(String fileName, String code){
		visualizerView.addLegacyCode(fileName, code);
	}

	public void addCandidateClass(String className, List<String> attributes, List<String> methods, List<String> methodBodies){
		visualizerView.addCandidateClass(className, attributes, methods, methodBodies);
	}
}
