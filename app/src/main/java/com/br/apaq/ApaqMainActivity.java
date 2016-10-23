package com.br.apaq;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.InterstitialCallbacks;
import com.br.apaq.activities.ContactActivity;
import com.br.apaq.activities.EnterpriseActivity;
import com.br.apaq.activities.ServicesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ApaqMainActivity extends AppCompatActivity {

    private static final String Tag_Error = "Error -  Main: ";

    @BindView(R.id.imgbEnterprise)
    ImageButton enterprise;
    @BindView(R.id.imgbContact)
    ImageButton contact;
    @BindView(R.id.imgbServices)
    ImageButton services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apaq_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.mmap);

    /*
        String appKey = "bf1a2363c83fe020437a653ae996e9d5838ad2ee5729612d";
        Appodeal.initialize(this, appKey, Appodeal.INTERSTITIAL | Appodeal.SKIPPABLE_VIDEO | Appodeal.BANNER | Appodeal.REWARDED_VIDEO);
       Appodeal.setTesting(true);
       // Appodeal.show(this, Appodeal.INTERSTITIAL);
        Appodeal.show(this,Appodeal.BANNER_BOTTOM);
*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                String url = "tel:04188996400688";
                Intent itCellPhone = new Intent(Intent.ACTION_CALL, Uri.parse(url));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(itCellPhone);
            }
        });

    }


    @OnClick(R.id.imgbEnterprise)
    public void enterprise() {
        Intent itEnterprise = new Intent(getApplicationContext(), EnterpriseActivity.class);
        startActivity(itEnterprise);
    }

    @OnClick(R.id.imgbServices)
    public void services() {
        Intent itServices = new Intent(getApplicationContext(), ServicesActivity.class);
        startActivity(itServices);
    }

    @OnClick(R.id.imgbContact)
    public void contact() {
        Intent itContact = new Intent(getApplicationContext(), ContactActivity.class);
        startActivity(itContact);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_apaq_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent itDev = new Intent(getApplicationContext(), DevelopersActivity.class);
            startActivity(itDev);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Appodeal.onResume(this, Appodeal.BANNER);
    }


    private boolean gettingOut = false;

    @Override
    public void onBackPressed() {

        if (gettingOut) {
            super.onBackPressed();
            finish();
        } else {
            gettingOut = true;
            Appodeal.show(this, Appodeal.INTERSTITIAL);

            Appodeal.setInterstitialCallbacks(new InterstitialCallbacks() {
                @Override
                public void onInterstitialLoaded(boolean b) {

                }

                @Override
                public void onInterstitialFailedToLoad() {

                }

                @Override
                public void onInterstitialShown() {

                }

                @Override
                public void onInterstitialClicked() {

                }

                @Override
                public void onInterstitialClosed() {
                    onBackPressed();
                }
            });
        }
    }
}
