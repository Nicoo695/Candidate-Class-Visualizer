package tests;

import views.VisualizerView;
import java.util.ArrayList;

/**
 * @author Nicolas Burroni
 * @since 8/4/2014
 */
public class VisualizerTest {
	public static void main(String[] args) {
		VisualizerView c = new VisualizerView();
		c.setVisible(true);
		ArrayList<String> a = new ArrayList<>();
		ArrayList<String> b = new ArrayList<>();
		a.add("int t");
		a.add("double d");
		b.add("void main");
		b.add("void main");
		c.addCandidateClass("Test", a, b);
		c.addCandidateClass("Test", a, b);
		c.addCandidateClass("Test", a, b);
		c.addCandidateClass("Test", a, b);
		c.addCandidateClass("Test", a, b);
		c.addCandidateClass("Test", a, b);
		c.addCandidateClass("Test", a, b);
		c.addCandidateClass("Test", a, b);
		c.addCandidateClass("Test", a, b);
		c.addCandidateClass("Test", a, b);
		c.addCandidateClass("Test", a, b);
		c.addCandidateClass("Test", a, b);

	}
}
