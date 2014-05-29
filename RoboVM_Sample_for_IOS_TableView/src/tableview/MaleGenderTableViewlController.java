package tableview;
import org.robovm.apple.foundation.NSIndexPath;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.uikit.NSIndexPathExtensions;
import org.robovm.apple.uikit.UITableView;
import org.robovm.apple.uikit.UITableViewCell;
import org.robovm.apple.uikit.UITableViewController;
import org.robovm.rt.bro.annotation.MachineSizedFloat;
import org.robovm.rt.bro.annotation.MachineSizedSInt;


public class MaleGenderTableViewlController extends UITableViewController {

	public long getNumberOfRowsInSection(UITableView tableView, @MachineSizedSInt long section){
		return 5;
	}
	
	public UITableViewCell getRowCell(UITableView tableView, NSIndexPath indexPath){
		
		// IMG Source: http://www.iconarchive.com/show/browser-girl-icons-by-iloveicons.ru/browser-girl-firefox-icon.html
		int row = (int) NSIndexPathExtensions.getRow(indexPath);
		UITableViewCell cell = null;
		if (row == 0)
        {  
			NSURL url = new NSURL(
					"http://icons.iconarchive.com/icons/icons-land/vista-people/64/Occupations-Bartender-Male-Dark-icon.png");
			cell = AddressbookUtils.setContentOfCell("Jens Philip", url, "Salzstr. 17", "jens.philip@jensp.de");
		}
		else if (row == 1){
			NSURL url = new NSURL(
					"http://icons.iconarchive.com/icons/iconshock/trendy-guys/64/matthew-icon.png");
			cell = AddressbookUtils.setContentOfCell("Peter Paul", url, "Amalienstr. 18", "paul@gmx.de");
		}
		else if (row == 2){
			NSURL url = new NSURL(
					"http://icons.iconarchive.com/icons/icons-land/vista-people/64/Occupations-Musician-Male-Dark-icon.png");
			cell = AddressbookUtils.setContentOfCell("Hieronimus Adams", url, "Sonnenstr. 54", "hadams@gmail.com");
		}
		else if (row == 3){
			NSURL url = new NSURL(
					"http://icons.iconarchive.com/icons/icons-land/vista-people/64/Historical-Cowboy-icon.png");
			cell = AddressbookUtils.setContentOfCell("Cowboy Jan", url, "Historical Ring 7", "cowboy@gmail.com");
		}
		else
		{
			NSURL url = new NSURL(
					"http://icons.iconarchive.com/icons/iconshock/trendy-guys/64/david-icon.png");
			cell = AddressbookUtils.setContentOfCell("Peter Paul", url, "Amalienstr. 18", "paul@gmx.de");
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
