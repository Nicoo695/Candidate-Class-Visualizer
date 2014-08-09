package controllers;

import models.CandidateClassManager;
import views.ViewsManager;

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

}
