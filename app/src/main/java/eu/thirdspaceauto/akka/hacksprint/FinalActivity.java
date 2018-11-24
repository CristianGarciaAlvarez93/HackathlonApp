package eu.thirdspaceauto.akka.hacksprint;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import eu.thirdspaceauto.akka.hacksprint.Adapter.InspectionPagerAdapter;
import eu.thirdspaceauto.akka.hacksprint.Utils.MarshMallowPermission;
import eu.thirdspaceauto.akka.hacksprint.Utils.PreferencesManager;
import eu.thirdspaceauto.akka.hacksprint.Utils.StringConstants;
import eu.thirdspaceauto.akka.hacksprint.Utils.Utility;


public class FinalActivity extends AppCompatActivity implements View.OnClickListener{
    private String TAG = FinalActivity.class.getSimpleName();
    private Context context;
    private Activity activity;
    private ImageView excel;
    private Toolbar toolbar;
    private Button new_inspection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        context = this;
        activity = this;
        excel= (ImageView) findViewById(R.id.excel);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new_inspection = (Button) findViewById(R.id.new_inspection);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(context,R.drawable.ic_arrow_back_white_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHome();
            }
        });
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.excel:
                break;
            case R.id.new_inspection:
                gotoHome();
                break;
        }
    }

    private void gotoHome() {
        Intent newIntent = new Intent(FinalActivity.this,MainActivity.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(newIntent);
    }


}
