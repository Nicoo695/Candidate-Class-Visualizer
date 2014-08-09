package controllers;

import models.CandidateClassManager;
import models.javacandidatestruct.CandidateClass;
import models.javacandidatestruct.JavaAttribute;
import models.javacandidatestruct.JavaMethod;
import views.ViewsManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicolas Burroni
 * @since 7/26/2014
 */
public class VisualizerController {

	private CandidateClassManager modelManager;
	private ViewsManager viewManager;

	public VisualizerController(){
		modelManager = new CandidateClassManager();
		viewManager = new ViewsManager();
	}


	public void runVisualizer(){
		viewManager.showStartupDialog(e -> browseAndVisualizeLegacyFile());
	}

	public void browseAndVisualizeLegacyFile(){
		String result = viewManager.browseLegacyFile();
		if(result != null){
			modelManager.generateClasses(result);
			showCCDs();
			showFile(result);
		}
	}

	public void showCCDs(){
		List<CandidateClass> ccds = modelManager.getNewCandidateClasses();
		for (CandidateClass ccd : ccds) {
			List<JavaAttribute> ccdAttributes = ccd.getAttributes();
			List<JavaMethod> ccdMethods = ccd.getMethods();
			List<String> attributes = new ArrayList<>();
			List<String> methods = new ArrayList<>();
			for (JavaAttribute attribute : ccdAttributes) {
				attributes.add(attribute.toString());
			}
			for (JavaMethod method : ccdMethods) {
				methods.add(method.getUMLString());
			}
			viewManager.addCandidateClass(ccd.getName(), attributes, methods);
		}
	}

	public void showFile(String path){
		File toShow = new File(path);
		String text = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(toShow));
			String line;
			do {
				line = reader.readLine();
				text.concat(line + "\n");
			} while(line != null);
		} catch (java.io.IOException ignored) {}
		viewManager.addLegacyCode(toShow.getName(), text);
	}
}
