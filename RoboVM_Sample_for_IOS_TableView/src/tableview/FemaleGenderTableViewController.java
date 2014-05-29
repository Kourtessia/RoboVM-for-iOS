package tableview;

import org.robovm.apple.foundation.NSIndexPath;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.uikit.NSIndexPathExtensions;
import org.robovm.apple.uikit.UITableView;
import org.robovm.apple.uikit.UITableViewCell;
import org.robovm.apple.uikit.UITableViewController;
import org.robovm.rt.bro.annotation.MachineSizedFloat;
import org.robovm.rt.bro.annotation.MachineSizedSInt;

public class FemaleGenderTableViewController extends UITableViewController {

	public long getNumberOfRowsInSection(UITableView tableView, @MachineSizedSInt long section){
		return 5;
	}
	
	public UITableViewCell getRowCell(UITableView tableView,
			NSIndexPath indexPath) {

		// IMG Sources:
		// http://www.iconarchive.com/show/browser-girl-icons-by-iloveicons.ru/browser-girl-firefox-icon.html
		// Linkware http://www.icons-land.com
		int row = (int) NSIndexPathExtensions.getRow(indexPath);
		UITableViewCell cell = null;
		if (row == 0) {
			NSURL url = new NSURL("http://icons.iconarchive.com/icons/iloveicons.ru/browser-girl/64/browser-girl-internet-explorer-icon.png");
			cell = AddressbookUtils.setContentOfCell("Emilia Hartman", url,
					"Sendlinger Tor Platz 3", "emi@yahoo.de");
		} else if (row == 1) {
			NSURL url = new NSURL("http://icons.iconarchive.com/icons/icons-land/vista-people/64/Medical-Nurse-Female-Light-icon.png");
			cell = AddressbookUtils.setContentOfCell("Nicole Schwarz", url,
					"Salzstr. 81", "nicole.schwarz@gmx.de");
		} else if (row == 2) {
			NSURL url = new NSURL("http://icons.iconarchive.com/icons/iloveicons.ru/browser-girl/64/browser-girl-safari-icon.png");
			cell = AddressbookUtils.setContentOfCell("Klara Cynt",
					url, "Daglfingerstr. 14", "klara.cynt@gmail.com");
		} else if (row == 3) {
			NSURL url = new NSURL("http://icons.iconarchive.com/icons/icons-land/vista-people/64/Occupations-Actor-Female-Light-icon.png");
			cell = AddressbookUtils.setContentOfCell("Lisa Butterfly", url,
					"Marienkäferstr. 53", "lisa.butterfly@gmail.com");
		} else {
			NSURL url = new NSURL("http://icons.iconarchive.com/icons/iloveicons.ru/browser-girl/64/browser-girl-firefox-icon.png");
			cell = AddressbookUtils.setContentOfCell("Frau Fuchs", url,
					"Cordovastr.56", "ela.fuchs@gmx.de");
		}
		return cell;
	}

    public @MachineSizedSInt long getNumberOfSections(UITableView tableView){
    	return 1;
    }
    
    public @MachineSizedFloat double getRowHeight(UITableView tableView, NSIndexPath indexPath){
    	return 90;
    }
    
    public void didSelectRow(UITableView tableView, NSIndexPath indexPath){
		getNavigationController().popToRootViewController(true);
		getNavigationController().setHidesBottomBarWhenPushed(false);
    }
	
}
