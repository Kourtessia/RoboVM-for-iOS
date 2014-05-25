package org.robovm.tableview;
import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSIndexPath;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.uikit.UIImage;
import org.robovm.apple.uikit.UIImageView;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UITableView;
import org.robovm.apple.uikit.UITableViewCell;
import org.robovm.apple.uikit.UITableViewController;
import org.robovm.rt.bro.annotation.MachineSizedFloat;
import org.robovm.rt.bro.annotation.MachineSizedSInt;


public class CustomCellTableViewlController extends UITableViewController {

	public long getNumberOfRowsInSection(UITableView tableView, @MachineSizedSInt long section){
		return 10;
	}
	
	public UITableViewCell getRowCell(UITableView tableView, NSIndexPath indexPath){
	
		UITableViewCell cell = new UITableViewCell(new CGRect(0, 0, 768, 90));
		UIImageView img = new UIImageView(new CGRect(5, 5, 80, 80));
		
		// Source: http://www.rockettheme.com/
		NSURL url = new NSURL("http://icons.iconarchive.com/icons/rockettheme/ecommerce/48/basket-icon.png");
		NSData data = (NSData)NSData.read(url);
		img.setImage(new UIImage(data));		
		cell.getContentView().addSubview(img);
		
		// content
		UILabel lbl1 = new UILabel(new CGRect(90, 10, cell.getContentView().getFrame().getWidth(), 20));
		lbl1.setText("RoboVM ist ein neues Open-Source Projekt");
		cell.getContentView().addSubview(lbl1);
		
		UILabel lbl2 = new UILabel(new CGRect(90, 35, cell.getContentView().getFrame().getWidth(), 20));
		lbl2.setText("In den RoboVM JAR-Dateien sind die"+
"Cocoa Bindings enthalten, wodurch ein Zugriff auf die nativen Funktionen von iOS gewährleistet wird.");
		cell.getContentView().addSubview(lbl2);
		
		return cell;
	}

    public @MachineSizedSInt long getNumberOfSections(UITableView tableView){
    	return 1;
    }
    
    public @MachineSizedFloat double getRowHeight(UITableView tableView, NSIndexPath indexPath){
    	return 90;
    }
    
    public void didSelectRow(UITableView tableView, NSIndexPath indexPath){
    	MobileAppsListViewController mobileAppsListViewController = new MobileAppsListViewController();		
		getNavigationController().addStrongRef(mobileAppsListViewController);
		getNavigationController().setHidesBottomBarWhenPushed(true);
		getNavigationController().pushViewController(mobileAppsListViewController, true);
    }
	
}
