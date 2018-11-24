package eu.thirdspaceauto.akka.hacksprint.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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
                TrackLinkFragment trackLinkFragment = new TrackLinkFragment();
                return trackLinkFragment;
            case 1:
                TrackLinkFragment trackLinkFragment2 = new TrackLinkFragment();
                return trackLinkFragment2;
            case 2:
                TrackLinkFragment trackLinkFragment3 = new TrackLinkFragment();
                return trackLinkFragment3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}