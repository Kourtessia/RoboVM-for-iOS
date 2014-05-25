package org.robovm.tableview;

import java.util.ArrayList;
import java.util.List;

import org.robovm.apple.foundation.NSIndexPath;
import org.robovm.apple.uikit.NSIndexPathExtensions;
import org.robovm.apple.uikit.UITableView;
import org.robovm.apple.uikit.UITableViewCell;
import org.robovm.apple.uikit.UITableViewController;
import org.robovm.objc.ObjCClass;
import org.robovm.rt.bro.annotation.MachineSizedFloat;
import org.robovm.rt.bro.annotation.MachineSizedSInt;

public class MobileAppsListViewController extends UITableViewController {

	private static final String CELL_IDENTIFIER = "CellIdentifier";
	
	private List<String> repositories;

	private List<String> getAppArt() {
		if (repositories == null) {
			repositories = new ArrayList<String>();
			repositories.add("Nativ");
			repositories.add("Nicht Nativ");
			repositories.add("Hybrid");
		}
		return repositories;
	}
	
	public MobileAppsListViewController() {
		super();
		this.setTitle("Mobile Apps ");
	}
	
	public @MachineSizedSInt long getNumberOfSections(UITableView tableView){
    	return 1;
    }
    
    public @MachineSizedFloat double getRowHeight(UITableView tableView, NSIndexPath indexPath){
    	return 90;
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
	public void didSelectRow(UITableView tableView, NSIndexPath indexPath) {
		int row = (int) NSIndexPathExtensions.getRow(indexPath);
		String appArt = getAppArt().get(row);
		
		IconsListViewController iconsListViewController = new IconsListViewController();
		iconsListViewController.setAppArt(appArt);
		
		getNavigationController().addStrongRef(iconsListViewController);
		getNavigationController().setHidesBottomBarWhenPushed(true);
		getNavigationController().pushViewController(iconsListViewController, true);
		
	}
	
	public boolean canEditRow(UITableView tableView, NSIndexPath indexPath){
		return true;
	}
	
	@Override
	public long getNumberOfRowsInSection(UITableView tableView, long section) {
		
		return getAppArt().size();
	}
	
	@Override
	public UITableViewCell getRowCell(UITableView tableView,
			NSIndexPath indexPath) {
		UITableViewCell cell = (UITableViewCell) tableView.dequeueReusableCell(CELL_IDENTIFIER);
		int row = (int) indexPath.getIndexAt(1);
		cell.getTextLabel().setText(getAppArt().get(row));
		System.out.println("MobileAppsListViewController.getRowCell  " + row);
		return cell;
	}

}
