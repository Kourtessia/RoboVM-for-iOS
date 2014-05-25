package org.robovm.tableview;

import java.util.ArrayList;
import java.util.List;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSIndexPath;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.uikit.NSIndexPathExtensions;
import org.robovm.apple.uikit.UIImage;
import org.robovm.apple.uikit.UIImageView;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UITableView;
import org.robovm.apple.uikit.UITableViewCell;
import org.robovm.apple.uikit.UITableViewController;
import org.robovm.objc.ObjCClass;
import org.robovm.rt.bro.annotation.MachineSizedFloat;

public class IconsListViewController extends UITableViewController {

	private static final String CELL_IDENTIFIER = "CellIdentifier1";
	private String appArt;

	public void setAppArt(String art) {
		this.appArt = art;
	}
	
	public String getAppArts() {
		return appArt;
	}
	
	private List<String> platforms;

	private List<String> getPlatforms() {
		if (platforms == null) {
			platforms = new ArrayList<String>();
			platforms.add("xCode/Objective-C for iOS"); 
			platforms.add("Eclipse/Java for Android"); 
			platforms.add("Visual Studio/C# for Windows Phone"); 
			platforms.add("Web technologies (HTML5, CSS and JavaScript)"); 
		}
		return platforms;
	}
	
	public IconsListViewController() {
		super();
		this.setTitle("Specific platform with the platform SDK");
	}
	
	public @MachineSizedFloat double getRowHeight(UITableView tableView, NSIndexPath indexPath){
    	return 70;
    }
	
	@Override
	protected void dispose(boolean finalizing) {
		super.dispose(finalizing);
	}

	@Override
	public void viewDidLoad() {
		super.viewDidLoad();
		this.getTableView().registerReusableCellClass(ObjCClass.getByType(UITableViewCell.class), CELL_IDENTIFIER);
	}
	
	@Override
	public long getNumberOfRowsInSection(UITableView tableView, long section) {
		return getPlatforms().size();
	}
	
	@Override
	public UITableViewCell getRowCell(UITableView tableView, NSIndexPath indexPath) {
		UITableViewCell cell = (UITableViewCell) tableView.dequeueReusableCell(CELL_IDENTIFIER);
		int row = (int) NSIndexPathExtensions.getRow(indexPath);
		String text = getPlatforms().get(row);
		UIImageView img = new UIImageView(new CGRect(5, 5, 80, 80));
		
		
		NSURL url = new NSURL("http://icons.iconarchive.com/icons/rockettheme/ecommerce/48/basket-icon.png");
		NSData data = (NSData)NSData.read(url);
		img.setImage(new UIImage(data));		
		cell.getContentView().addSubview(img);
		
		
		UILabel lbl1 = new UILabel(new CGRect(90, 10, cell.getContentView().getFrame().getWidth(), 20));
		lbl1.setText(text);
		cell.getContentView().addSubview(lbl1);
		return cell;
	}
	
	@Override
	public void didSelectRow(UITableView tableView, NSIndexPath indexPath) {
		int row = (int) NSIndexPathExtensions.getRow(indexPath);
		System.out.println(String.format("Selected %s", row));
		AdventagesListViewController adventagesListViewController = new AdventagesListViewController();
		adventagesListViewController.setDetail("Detai");
		
		getNavigationController().addStrongRef(adventagesListViewController);
		getNavigationController().setHidesBottomBarWhenPushed(false);
		getNavigationController().pushViewController(adventagesListViewController, true);
	}
	
}
