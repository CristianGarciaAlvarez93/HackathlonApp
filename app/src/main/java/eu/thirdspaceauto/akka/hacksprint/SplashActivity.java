package eu.thirdspaceauto.akka.hacksprint;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;


import eu.thirdspaceauto.akka.hacksprint.Drawer.ModelActivity;
import eu.thirdspaceauto.akka.hacksprint.Login.LoginJourneyActivity;
import eu.thirdspaceauto.akka.hacksprint.Utils.LogUtils;
import eu.thirdspaceauto.akka.hacksprint.Utils.Utility;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_CALENDAR;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;
import static android.Manifest.permission.RECEIVE_SMS;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


public class SplashActivity extends AppCompatActivity {
    private String TAG = "SplashActivity";
    Intent mainActivityIntent, loginIntent,modelActivityIntent, mapActivityIntent, videoActivityIntent, affdexIntent = null;
    Activity activity;
    CountDownTimer countDownTimer;
    public static final int RequestPermissionCode = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        mainActivityIntent = new Intent(SplashActivity.this, MainActivity.class);
        modelActivityIntent = new Intent(SplashActivity.this, ModelActivity.class);
        loginIntent = new Intent(SplashActivity.this, LoginJourneyActivity.class);

        countDownTimer = new CountDownTimer(1500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                if(Utility.getJwtToken().equalsIgnoreCase("")){
                    //not logged in
                    SplashActivity.this.startActivity(loginIntent);
                    SplashActivity.this.finish();
                }else{
                    SplashActivity.this.startActivity(mainActivityIntent);
                    SplashActivity.this.finish();
                }
            }
        };
        checkForPermission();
    }
    private void checkForPermission() {
        if (checkPermissionIsEnabledOrNot()) {
            //all permission granted
            countDownTimer.start();
        } else {
            //Calling method to enable permission.
            checkPermissionIsEnabledOrNot();

        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                LogUtils.printLog(TAG, " --- permission granted result ---");
                if (grantResults.length > 0) {

                    boolean readExternalStorage = grantResults[4] == PackageManager.PERMISSION_GRANTED;
                    boolean writeExternalStorage = grantResults[5] == PackageManager.PERMISSION_GRANTED;
                    boolean cameraPermission = grantResults[6] == PackageManager.PERMISSION_GRANTED;
                    if (readExternalStorage &&
                            writeExternalStorage && cameraPermission) {
                        LogUtils.printLog(TAG, "Permission Granted");
                    } else {
                        LogUtils.printLog(TAG, "Permission Denied");
                    }
                }
                countDownTimer.start();
                break;
        }
    }

    public boolean checkPermissionIsEnabledOrNot() {

        int fifthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        int sixthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int seventhtPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA);
        return
                fifthPermissionResult == PackageManager.PERMISSION_GRANTED &&
                        sixthPermissionResult == PackageManager.PERMISSION_GRANTED &&
                        seventhtPermissionResult == PackageManager.PERMISSION_GRANTED
                ;
    }


}
