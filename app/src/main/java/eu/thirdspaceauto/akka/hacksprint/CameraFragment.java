package eu.thirdspaceauto.akka.hacksprint;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;


public class CameraFragment extends Fragment {
	
	//Keep track of camera capture intent
	final int CAMERA_CAPTURE = 1;
	//keep track of cropping intent
	final int PIC_CROP = 2;
	//Captured picture uri
	private Uri uri;
	private Bitmap bitmap;
	
	private ImageView croppedImageView;
	
	public CameraFragment () {
		// Required empty public constructor
	}
	
	public static CameraFragment newInstance () {
		CameraFragment fragment = new CameraFragment ();
		Bundle args = new Bundle ();
		fragment.setArguments (args);
		return fragment;
	}
	
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		Intent getIntent = getActivity ().getIntent ();
		
		if(getIntent.getExtras () != null){
			Bundle bundle = getIntent.getExtras ();
			uri = (Uri)bundle.get ("Uri");
			File file = new File (uri.getPath ());
			bitmap = BitmapFactory.decodeFile (file.getAbsolutePath ());
			Toast.makeText(
						getContext (), "Back in the activity: " + uri.toString (), Toast.LENGTH_LONG)
						.show();
			
		}else {
			Intent cropIntent = new Intent ("com.action.CROP");
			startActivity (cropIntent);
		}
		
	}
	
//	private void performCrop () {
//		Intent cropIntent = new Intent ("android.intent.action.CROP");
//		cropIntent.setDataAndType (uri, "image/*");
//		cropIntent.putExtra ("crop", true);
//		cropIntent.putExtra ("aspectX", 1);
//		cropIntent.putExtra ("aspectY", 1);
//
//		cropIntent.putExtra ("outputX", 256);
//		cropIntent.putExtra ("outputY", 256);
//
//		cropIntent.putExtra ("return-data",true);
//
//		startActivityForResult (cropIntent, PIC_CROP);
//	}
	
	@Override
	public void onResume () {
		super.onResume ();
		if(bitmap != null){
			croppedImageView.setImageBitmap (bitmap);
		}else{
			Log.e ("TAG_LOG", "Bitmap is null");
		}
	}
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container,
							  Bundle savedInstanceState) {
		View view = inflater.inflate (R.layout.fragment_camera, container, false);
		croppedImageView = view.findViewById (R.id.cropped_imageView);
		
		
		// Inflate the layout for this fragment
		return view;
	}
}
