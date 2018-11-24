package eu.thirdspaceauto.akka.hacksprint.Drawer;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import eu.thirdspaceauto.akka.hacksprint.Adapter.ModelViewAdapter;
import eu.thirdspaceauto.akka.hacksprint.Login.LoginJourneyActivity;
import eu.thirdspaceauto.akka.hacksprint.MainActivity;
import eu.thirdspaceauto.akka.hacksprint.Models.Excavators;
import eu.thirdspaceauto.akka.hacksprint.R;
import eu.thirdspaceauto.akka.hacksprint.Utils.LogUtils;
import eu.thirdspaceauto.akka.hacksprint.Utils.Utility;

public class ModelActivity extends AppCompatActivity implements ModelViewAdapter.ItemClickListener {
    private String TAG = ModelActivity.class.getSimpleName();
    Intent mainActivityIntent = null;
    Activity activity;
    private ModelViewAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button create_model_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_model);
        create_model_btn = (Button) findViewById(R.id.create_model_btn);
        create_model_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ModelActivity.this,CreateModelActivity.class));
            }
        });
        mainActivityIntent = new Intent(ModelActivity.this, MainActivity.class);


        mRecyclerView = (RecyclerView) findViewById(R.id.model_recycler);
        mRecyclerView.setHasFixedSize(true);
        List<Excavators> rowListItem = getAllItemList();

        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ModelViewAdapter(rowListItem,activity);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setClickListener(this);

    }

    private List<Excavators> getAllItemList() {
        List<Excavators> allItems = new ArrayList<Excavators>();
        Excavators excavators = new Excavators();
        excavators.name = "MODEL E2250";
        excavators.info = "NEW MODEL";
        excavators.image = R.drawable.tsa;
        allItems.add(excavators);
        return allItems;
    }

    @Override
    public void itemClick(View view, int position) {
        startActivity(new Intent(this, MainActivity.class));
    }

}
