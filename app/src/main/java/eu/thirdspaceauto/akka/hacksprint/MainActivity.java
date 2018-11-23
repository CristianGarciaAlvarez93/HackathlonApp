package eu.thirdspaceauto.akka.hacksprint;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;

import eu.thirdspaceauto.akka.hacksprint.Utils.LogUtils;
import eu.thirdspaceauto.akka.hacksprint.Utils.MarshMallowPermission;
import eu.thirdspaceauto.akka.hacksprint.Utils.PreferencesManager;
import eu.thirdspaceauto.akka.hacksprint.Utils.StringConstants;
import eu.thirdspaceauto.akka.hacksprint.Utils.Utility;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    private String TAG = MainActivity.class.getSimpleName();
    private Context context;
    private Activity activity;
    private MarshMallowPermission marshMallowPermission;
    private boolean isGyroAvailable = true;
    public static final int GET_LOCATION_PERMISSION_REQUEST_CODE = 11;
    private SettingsClient mSettingsClient;
    private LocationRequest mLocationRequest;
    private LocationSettingsRequest mLocationSettingsRequest;
    private static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;
    private static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView header_userEmail;
    private View headerLayout;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initSMSData();
        initCalendarData();
        initSensorDataService();
        startAlarmManager();

    }

    private void init() {
        context = this;
        activity = this;
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        marshMallowPermission = new MarshMallowPermission(activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(context,R.drawable.ic_menu_white_24dp));
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        headerLayout = navigationView.getHeaderView(0);
        header_userEmail=(TextView) headerLayout.findViewById(R.id.header_userEmail);


        String userEmail = PreferencesManager.getString(StringConstants.KEY_USER_EMAIL,"");
        if(!userEmail.equalsIgnoreCase("")){
            header_userEmail.setText("Welcome "+ userEmail);
        }
    }

    private void initCalendarData() {

    }

    private void initSMSData() {

    }

    private void initSensorDataService() {


    }

    private void startAlarmManager() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        int id = item.getItemId();
        switch (id){
            case R.id.logout:
                logout();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logout() {
        //remove all preferences
        Utility.saveJwtToken("");
        PreferencesManager.putString("isUserLoggedIn", "");
        PreferencesManager.putString(StringConstants.KEY_USER_EMAIL, "");
        startActivity(new Intent(MainActivity.this, SplashActivity.class));
        MainActivity.this.finish();
    }
}
