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


import eu.thirdspaceauto.akka.hacksprint.Login.LoginJourneyActivity;
import eu.thirdspaceauto.akka.hacksprint.Utils.LogUtils;
import eu.thirdspaceauto.akka.hacksprint.Utils.Utility;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_CALENDAR;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;
import static android.Manifest.permission.RECEIVE_SMS;


public class SplashActivity extends AppCompatActivity {
    private String TAG = "SplashActivity";
    Intent mainActivityIntent, loginIntent, mapActivityIntent, videoActivityIntent, affdexIntent = null;
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
            requestMultiplePermission();

        }
    }


    private void requestMultiplePermission() {
        // Creating String Array with Permissions.
        ActivityCompat.requestPermissions(SplashActivity.this, new String[]{
                READ_PHONE_STATE,
                ACCESS_FINE_LOCATION,
                ACCESS_COARSE_LOCATION,
                READ_SMS,
                RECEIVE_SMS,
                READ_CALENDAR,
        }, RequestPermissionCode);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                LogUtils.printLog(TAG," --- permission granted result ---");
                if (grantResults.length > 0) {
                    boolean readPhoneState = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean accessFineLocation = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean read_sms = grantResults[2] == PackageManager.PERMISSION_GRANTED;
                    boolean receive_sms = grantResults[3] == PackageManager.PERMISSION_GRANTED;
                    boolean readCalendar = grantResults[4] == PackageManager.PERMISSION_GRANTED;
                    if (readPhoneState && accessFineLocation && read_sms
                            && receive_sms && readCalendar) {
                        LogUtils.printLog(TAG,"Permission Granted");
                    } else {
                        LogUtils.printLog(TAG,"Permission Denied");
                    }
                }
                countDownTimer.start();
                break;
        }
    }

    public boolean checkPermissionIsEnabledOrNot() {
        int firstPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), READ_PHONE_STATE);
        int secondPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION);
        int thirdPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),READ_SMS);
        int fourthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),RECEIVE_SMS);
        int fifthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), READ_CALENDAR);

        return
                firstPermissionResult == PackageManager.PERMISSION_GRANTED &&
                        secondPermissionResult == PackageManager.PERMISSION_GRANTED &&
                        thirdPermissionResult == PackageManager.PERMISSION_GRANTED &&
                        fourthPermissionResult == PackageManager.PERMISSION_GRANTED &&
                        fifthPermissionResult == PackageManager.PERMISSION_GRANTED
                ;
    }



}
