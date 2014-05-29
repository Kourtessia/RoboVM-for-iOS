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
import org.robovm.apple.uikit.UITableViewCellEditingStyle;
import org.robovm.apple.uikit.UITableViewController;
import org.robovm.objc.ObjCClass;
import org.robovm.rt.bro.annotation.MachineSizedFloat;

public class GenderListTableViewController extends UITableViewController {

	private static final String CELL_IDENTIFIER = "AddressbookCell";
	
	private List<String> gender;

	private List<String> getGender() {
		if (gender == null) {
			gender = new ArrayList<String>();
			gender.add("female"); 
			gender.add("male"); 
		}
		return gender;
	}
	
	public GenderListTableViewController() {
		super();
		this.setTitle("Address Book");
		//this.setEditing(true, true);
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
	public long getNumberOfRowsInSection(UITableView tableView, long section) {
		return getGender().size();
	}
	
	@Override
	public boolean canEditRow(UITableView tableView, NSIndexPath indexPath){
		//this.setEditing(true, true);
		//this.commitRowEditingStyle(tableView, UITableViewCellEditingStyle.Delete, indexPath);
		return Boolean.TRUE;
	}
	
	@Override
	public UITableViewCell getRowCell(UITableView tableView, NSIndexPath indexPath) {
		
		UITableViewCell cell = (UITableViewCell) tableView.dequeueReusableCell(CELL_IDENTIFIER);
		int row = (int) NSIndexPathExtensions.getRow(indexPath);
		
		String text = getGender().get(row);
		
		if (text.equals("male"))
        {
			NSURL url = new NSURL("http://icons.iconarchive.com/icons/iconshock/trendy-guys/64/andrew-icon.png");
			setContentOfCell(cell, text, url);
		}
		if (text.equals("female"))
        {
			NSURL url = new NSURL("http://icons.iconarchive.com/icons/iloveicons.ru/browser-girl/64/browser-girl-firefox-icon.png");
			setContentOfCell(cell, text, url);
		}
		return cell;
	}
	
	@Override
	public void didSelectRow(UITableView tableView, NSIndexPath indexPath) {
		int row = (int) NSIndexPathExtensions.getRow(indexPath);
        String text = getGender().get(row);
		
		if (text.equals("female"))
        {
			FemaleGenderTableViewController femaleGenderTableViewController = new FemaleGenderTableViewController();
			willSelectCell(femaleGenderTableViewController, "female") ;
		}
		if (text.equals("male"))
        {
			MaleGenderTableViewlController maleGenderTableViewlController = new MaleGenderTableViewlController();
			willSelectCell(maleGenderTableViewlController, "male") ;
        }
	}
	
	public void willSelectCell(UITableViewController controller, String detail) {
		getNavigationController().addStrongRef(controller);
		getNavigationController().setHidesBottomBarWhenPushed(false);
		getNavigationController().pushViewController(controller, true);
	}
	
	public void setContentOfCell(UITableViewCell cell, String txt, NSURL url) {
		UIImageView img = new UIImageView(new CGRect(25, 5, 80, 80));
    	NSData data = (NSData) NSData.read(url);
		img.setImage(new UIImage(data));
		cell.getContentView().addSubview(img);

		UILabel label = new UILabel(new CGRect(120, 30, cell.getContentView()
				.getFrame().getWidth(), 20));
		label.setText(txt);
		cell.getContentView().addSubview(label);
	}
}
