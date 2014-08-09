package tests;

import views.LegacyChooserView;

/**
 * @author Nicolas Burroni
 * @since 8/3/2014
 */
public class ChooserTest {
	public static void main(String[] args) {
		LegacyChooserView chooser = new LegacyChooserView();
		chooser.setVisible(true);
		chooser.addBrowseButtonListener(e -> chooser.browseLegacyFile());
	}
}
