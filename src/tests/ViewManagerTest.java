package tests;

import views.LanguageManager;
import views.ViewsManager;

import javax.swing.*;

/**
 * @author Nicolas Burroni
 * @since 8/9/2014
 */
public class ViewManagerTest {
	public static void main(String[] args) {
		ViewsManager m = new ViewsManager();
		m.showLegacyFileChooser(e -> System.out.println(m.browseLegacyFile()));
	}
}
