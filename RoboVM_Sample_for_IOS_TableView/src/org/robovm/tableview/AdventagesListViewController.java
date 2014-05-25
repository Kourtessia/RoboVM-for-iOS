package org.robovm.tableview;

import java.util.ArrayList;
import java.util.List;

import org.robovm.apple.foundation.NSIndexPath;
import org.robovm.apple.uikit.NSIndexPathExtensions;
import org.robovm.apple.uikit.UINavigationControllerDelegateAdapter;
import org.robovm.apple.uikit.UITableView;
import org.robovm.apple.uikit.UITableViewCell;
import org.robovm.apple.uikit.UITableViewController;
import org.robovm.objc.ObjCClass;

public class AdventagesListViewController extends UITableViewController {

	private static final String CELL_IDENTIFIER = "CellIdentifier";
	private String detail;

	public void setDetail(String det) {
		this.detail = det;
	}
	
	public String getRepository() {
		return detail;
	}
	
	private List<String> platformDetail;

	private List<String> getDetails() {
		if (platformDetail == null) {
			platformDetail = new ArrayList<String>();
			platformDetail.add("Smoother Experience");
			platformDetail.add("Higher User Engagement, Offline Access");
			platformDetail.add("Ability to send push notifications and reminders to users");
			platformDetail.add("Integrating the unique capabilities of the mobile device into the application");
		}
		return platformDetail;
	}
	
	public AdventagesListViewController() {
		super();
		this.setTitle("iOS native - Pro's");
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
		return getDetails().size();
	}
	
	@Override
	public UITableViewCell getRowCell(UITableView tableView, NSIndexPath indexPath) {
		UITableViewCell cell = (UITableViewCell) tableView.dequeueReusableCell(CELL_IDENTIFIER);
		int row = (int) indexPath.getIndexAt(1);
		String text = getDetails().get(row);
		cell.getTextLabel().setText(text);
		return cell;
	}
	
	@Override
	public void didSelectRow(UITableView tableView, NSIndexPath indexPath) {
		int row = (int) NSIndexPathExtensions.getRow(indexPath);
		System.out.println(String.format("Selected %s", row));
		
		CustomCellTableViewlController customCellTableViewlController = new CustomCellTableViewlController();
		getNavigationController().setDelegate(new UINavigationControllerDelegateAdapter() {});
		getNavigationController().addStrongRef(customCellTableViewlController);
		getNavigationController().pushViewController(customCellTableViewlController, true);
	}
	
}
