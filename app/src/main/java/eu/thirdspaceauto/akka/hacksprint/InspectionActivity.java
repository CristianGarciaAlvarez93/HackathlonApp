package eu.thirdspaceauto.akka.hacksprint;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

public class InspectionActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		// Sets and asks for the required permissions
		if (ContextCompat.checkSelfPermission(this,
				android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
				!= PackageManager.PERMISSION_GRANTED) {
			if (ActivityCompat.shouldShowRequestPermissionRationale(this,
					android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
			} else {
				ActivityCompat.requestPermissions(this,
						new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
						1);
			}
		}
		
		super.onCreate (savedInstanceState);
		setContentView (R.layout.activity_inspection);
		if (null == savedInstanceState) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.container, CameraFragment.newInstance())
					.commit();
		}
	}
	
}
