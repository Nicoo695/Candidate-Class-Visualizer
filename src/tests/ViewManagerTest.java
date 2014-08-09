package tests;

import views.ViewsManager;

/**
 * @author Nicolas Burroni
 * @since 8/9/2014
 */
public class ViewManagerTest {
	public static void main(String[] args) {
		ViewsManager m = new ViewsManager();
		m.showStartupDialog(e -> System.out.println(m.browseLegacyFile()));
	}
}
