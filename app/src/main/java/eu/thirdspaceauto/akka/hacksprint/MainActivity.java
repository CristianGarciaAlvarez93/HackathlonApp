package eu.thirdspaceauto.akka.hacksprint;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import eu.thirdspaceauto.akka.hacksprint.Adapter.InspectionPagerAdapter;
import eu.thirdspaceauto.akka.hacksprint.Models.InspectionModel;
import eu.thirdspaceauto.akka.hacksprint.Utils.MarshMallowPermission;
import eu.thirdspaceauto.akka.hacksprint.Utils.PreferencesManager;
import eu.thirdspaceauto.akka.hacksprint.Utils.StringConstants;
import eu.thirdspaceauto.akka.hacksprint.Utils.Utility;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private String TAG = MainActivity.class.getSimpleName();
    private Context context;
    private Activity activity;
    private MarshMallowPermission marshMallowPermission;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView header_userEmail;
    private View headerLayout;
    private DrawerLayout drawerLayout;
    public ViewPager viewPager;
    public int currentFragment = 0;
    public InspectionModel inspectionModel;
    public Button previousButton, nextButton;
    InspectionPagerAdapter inspectionPagerAdapter;
    TabLayout dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        context = this;
        activity = this;
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        marshMallowPermission = new MarshMallowPermission(activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(context,R.drawable.ic_menu_white_24dp));
        toolbar.setTitle("Undercarriage Inspection");
        toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        previousButton = findViewById (R.id.previousButton);
        previousButton.setOnClickListener (this);
        nextButton = findViewById (R.id.nextButton);
        nextButton.setOnClickListener (this);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        headerLayout = navigationView.getHeaderView(0);
        header_userEmail = (TextView) headerLayout.findViewById(R.id.header_userEmail);


        String userEmail = PreferencesManager.getString(StringConstants.KEY_USER_EMAIL,"");
        if(!userEmail.equalsIgnoreCase("")){
            header_userEmail.setText("Welcome "+ userEmail);
        }

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        inspectionPagerAdapter = new InspectionPagerAdapter(getSupportFragmentManager(), 8);
        viewPager.setAdapter(inspectionPagerAdapter);
        viewPager.setCurrentItem(currentFragment);
	
		if(getIntent ().getExtras () != null){
			inspectionModel = new InspectionModel (getIntent ().getExtras ().getString ("model"), "Volvo");
		}
		
        dots = (TabLayout) findViewById(R.id.dots);
        dots.setupWithViewPager(viewPager, true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        int id = item.getItemId();
        switch (id){
            case R.id.logout:
                logout();
                break;
            case R.id.my_excavators:
                break;
            case R.id.old_inspection:
                break;
            case R.id.account:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void logout() {
        Utility.saveJwtToken("");
        PreferencesManager.putString("isUserLoggedIn", "");
        PreferencesManager.putString(StringConstants.KEY_USER_EMAIL, "");
        startActivity(new Intent(MainActivity.this, SplashActivity.class));
        MainActivity.this.finish();
    }
	
	@Override
	public void onClick (View v) {
		switch (v.getId ()){
			case R.id.previousButton:
				if(currentFragment >= 1){
					--currentFragment;
					viewPager.setCurrentItem(currentFragment);
				}
				break;
			case R.id.nextButton:
				if(currentFragment < 7){
					++currentFragment;
					viewPager.setCurrentItem (currentFragment);
				}else {
					Intent intent = new Intent (MainActivity.this, FinalActivity.class);
					startActivity (intent);
				}
				break;
		}
	}
}
