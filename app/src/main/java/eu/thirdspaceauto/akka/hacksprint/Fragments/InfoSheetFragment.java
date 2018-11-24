package eu.thirdspaceauto.akka.hacksprint.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import eu.thirdspaceauto.akka.hacksprint.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InfoSheetFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InfoSheetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoSheetFragment extends Fragment {
	
	public InfoSheetFragment () {
		// Required empty public constructor
	}
	
	public static InfoSheetFragment newInstance () {
		InfoSheetFragment fragment = new InfoSheetFragment ();
		Bundle args = new Bundle ();
		
		fragment.setArguments (args);
		return fragment;
	}
	
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		
	}
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container,
							  Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate (R.layout.fragment_info_sheet, container, false);
	}
}
