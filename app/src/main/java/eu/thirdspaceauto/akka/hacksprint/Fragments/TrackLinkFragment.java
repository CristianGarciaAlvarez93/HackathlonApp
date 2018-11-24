package eu.thirdspaceauto.akka.hacksprint.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import eu.thirdspaceauto.akka.hacksprint.Drawer.Preview;
import eu.thirdspaceauto.akka.hacksprint.R;


public class TrackLinkFragment extends Fragment implements View.OnClickListener {
    TextView std_max_value,std_min_value,left_link_pitch_btn,right_link_pitch_btn;
    ImageView right_link_pitch_image, left_link_pitch_image;
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_track_link, container, false);
        std_max_value = rootView.findViewById(R.id.std_max_value);
        std_min_value = rootView.findViewById(R.id.std_min_value);
        left_link_pitch_btn = (Button) rootView.findViewById(R.id.left_link_pitch_btn);
        right_link_pitch_btn= (Button) rootView.findViewById(R.id.right_link_pitch_btn);
        left_link_pitch_image = rootView.findViewById(R.id.left_link_pitch_image);
        right_link_pitch_image= rootView.findViewById(R.id.right_link_pitch_image);

        left_link_pitch_btn.setOnClickListener(this);
        right_link_pitch_btn.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_link_pitch_btn:
                Intent intent = new Intent(getActivity(),Preview.class);
                getActivity().startActivityForResult(intent,100);
                break;
            case R.id.right_link_pitch_btn:
                break;
        }
    }
}
