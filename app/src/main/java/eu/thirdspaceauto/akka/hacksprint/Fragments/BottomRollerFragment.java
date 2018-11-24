package eu.thirdspaceauto.akka.hacksprint.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import eu.thirdspaceauto.akka.hacksprint.R;

public class BottomRollerFragment extends Fragment {
	
	public BottomRollerFragment () {
		// Required empty public constructor
	}
	
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
	}
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container,
							  Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate (R.layout.fragment_bottom_roller, container, false);
	}
}
