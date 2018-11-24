package eu.thirdspaceauto.akka.hacksprint.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import eu.thirdspaceauto.akka.hacksprint.Fragments.BottomRollerFragment;
import eu.thirdspaceauto.akka.hacksprint.Fragments.DoubleGrouserShoeFragment;
import eu.thirdspaceauto.akka.hacksprint.Fragments.InfoSheetFragment;
import eu.thirdspaceauto.akka.hacksprint.Fragments.ShoeGrouserHeightFragment;
import eu.thirdspaceauto.akka.hacksprint.Fragments.TrackLinkFragment;


public class InspectionPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public InspectionPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
			case 0:
				InfoSheetFragment infoSheetFragment = new InfoSheetFragment ();
				return infoSheetFragment;
            case 1:
                TrackLinkFragment trackLinkFragment = new TrackLinkFragment();
                return trackLinkFragment;
            case 2:
                TrackLinkFragment trackLinkFragment2 = new TrackLinkFragment();
                return trackLinkFragment2;
            case 3:
                TrackLinkFragment trackLinkFragment3 = new TrackLinkFragment();
                return trackLinkFragment3;
			case 4:
				ShoeGrouserHeightFragment shoeGrouserHeightFragment = new ShoeGrouserHeightFragment ();
				return shoeGrouserHeightFragment;
			case 5:
				DoubleGrouserShoeFragment doubleGrouserShoeFragment = new DoubleGrouserShoeFragment ();
				return doubleGrouserShoeFragment;
			case 6:
				BottomRollerFragment bottomRollerFragment = new BottomRollerFragment ();
				return bottomRollerFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}