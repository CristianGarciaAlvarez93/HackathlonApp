package eu.thirdspaceauto.akka.hacksprint.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import eu.thirdspaceauto.akka.hacksprint.Fragments.IdlerFragment;
import eu.thirdspaceauto.akka.hacksprint.Fragments.SprocketFragment;
import eu.thirdspaceauto.akka.hacksprint.Fragments.TopRollerFragment;
import eu.thirdspaceauto.akka.hacksprint.Fragments.BottomRollerFragment;
import eu.thirdspaceauto.akka.hacksprint.Fragments.DoubleGrouserShoeFragment;
import eu.thirdspaceauto.akka.hacksprint.Fragments.InfoSheetFragment;
import eu.thirdspaceauto.akka.hacksprint.Fragments.TripleGrouserShoeFragment;
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
				InfoSheetFragment infoSheetFragment = new InfoSheetFragment();
				return infoSheetFragment;
            case 2:
                TrackLinkFragment trackLinkFragment = new TrackLinkFragment();
                return trackLinkFragment;
			case 1:
				TripleGrouserShoeFragment shoeGrouserHeightFragment = new TripleGrouserShoeFragment();
				return shoeGrouserHeightFragment;
			case 3:
				BottomRollerFragment bottomRollerFragment = new BottomRollerFragment();
				return bottomRollerFragment;
            case 4:
                TopRollerFragment topRollerFragment= new TopRollerFragment();
                return topRollerFragment;
            case 5:
                IdlerFragment idlerFragment= new IdlerFragment();
                return idlerFragment;
            case 6:
                SprocketFragment sprocketFragment= new SprocketFragment();
                return sprocketFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}