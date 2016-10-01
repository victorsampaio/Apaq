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

public class ApaqMainActivity extends AppCompatActivity implements OnClickListener {

    private static final String Tag_Error ="Error -  Main: ";
    ImageButton enterprise, contact, services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apaq_main);
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


        enterprise = (ImageButton) findViewById(R.id.imgbEnterprise);
        services = (ImageButton) findViewById(R.id.imgbServices);
        contact = (ImageButton) findViewById(R.id.imgbContact);

        enterprise.setOnClickListener(this);
        services.setOnClickListener(this);
        contact.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.imgbEnterprise:
                    Intent itEnterprise = new Intent(getApplicationContext(), EnterpriseActivity.class);
                    startActivity(itEnterprise);
                    break;

                case R.id.imgbServices:
                    //Toast.makeText(getApplicationContext(), "Serviços em desenvolvimento!", Toast.LENGTH_SHORT).show();
                    Intent itServices = new Intent(getApplicationContext(), ServicesActivity.class);
                    startActivity(itServices);
                    break;

                case R.id.imgbContact:
                    Intent itContact = new Intent(getApplicationContext(), ContactActivity.class);
                    startActivity(itContact);
                    break;
                default:
            }
        } catch (Exception e) {
            Log.e(Tag_Error, "-->> Error: " + e);
            Toast.makeText(getApplicationContext(), "Error: ", Toast.LENGTH_SHORT).show();
        }
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

        if (gettingOut){
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
