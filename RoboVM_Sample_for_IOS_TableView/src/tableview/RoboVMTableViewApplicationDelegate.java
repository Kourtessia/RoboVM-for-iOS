package tableview;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UINavigationController;
import org.robovm.apple.uikit.UINavigationControllerDelegateAdapter;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIWindow;

public class RoboVMTableViewApplicationDelegate extends
		UIApplicationDelegateAdapter {

	private UIWindow window;

	@Override
	public boolean didFinishLaunching(UIApplication application,
			NSDictionary<NSString, ?> launchOptions) {
		
		window = new UIWindow(UIScreen.getMainScreen().getBounds());

		GenderListTableViewController mobileAppsListViewController = new GenderListTableViewController();
		UINavigationController navigationController = new UINavigationController(mobileAppsListViewController);
		navigationController.addStrongRef(mobileAppsListViewController);
		navigationController.setDelegate(new UINavigationControllerDelegateAdapter() {});
		window.setRootViewController(navigationController);
		window.setBackgroundColor(UIColor.colorWhite());
		window.makeKeyAndVisible();

		return true;
	}

	public static void main(String[] args) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(args, null,
				RoboVMTableViewApplicationDelegate.class);
		pool.close();
	}

}
