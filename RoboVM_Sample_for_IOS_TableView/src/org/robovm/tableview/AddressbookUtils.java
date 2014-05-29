package org.robovm.tableview;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UIImage;
import org.robovm.apple.uikit.UIImageView;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UITableViewCell;

public class AddressbookUtils {
	
	public static UITableViewCell setContentOfCell(String name, NSURL url, String adresse, String email) {
		UITableViewCell cell = new UITableViewCell(new CGRect(0, 0, 300, 60));
		UIImageView img = new UIImageView(new CGRect(20, 10, 70, 70));
		NSData data = (NSData)NSData.read(url);
		img.setImage(new UIImage(data));		
		cell.getContentView().addSubview(img);
		
		UILabel label1 = new UILabel(new CGRect(100, 10, cell.getContentView().getFrame().getWidth(), 20));
		label1.setText(name);
		label1.setTextColor(UIColor.colorBrown());
		cell.getContentView().addSubview(label1);
		
		UILabel label2 = new UILabel(new CGRect(100, 35, cell.getContentView().getFrame().getWidth(), 20));
		label2.setText(adresse);
		cell.getContentView().addSubview(label2);
		
		UILabel label3 = new UILabel(new CGRect(100, 55, cell.getContentView().getFrame().getWidth(), 20));
		label3.setText(email);
		cell.getContentView().addSubview(label3);
		return cell;
	}
}
