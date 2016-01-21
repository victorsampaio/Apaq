package com.br.apaq;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

import com.br.apaq.activities.ContactActivity;
import com.br.apaq.activities.EnterpriseActivity;
import com.br.apaq.activities.ServicesActivity;

public class ApaqMainActivity extends AppCompatActivity implements OnClickListener{

    ImageButton enterprise, contact, services;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apaq_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        enterprise = (ImageButton)findViewById(R.id.imgbEnterprise);
        services = (ImageButton)findViewById(R.id.imgbServices);
        contact = (ImageButton)findViewById(R.id.imgbContact);

        enterprise.setOnClickListener(this);
        services.setOnClickListener(this);
        contact.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()){
                case R.id.imgbEnterprise:
                    Intent itEnterprise = new Intent(getApplicationContext(), EnterpriseActivity.class);
                    startActivity(itEnterprise);
                    break;

                case R.id.imgbServices:
                    Intent itServices = new Intent(getApplicationContext(), ServicesActivity.class);
                    startActivity(itServices);
                    break;

                case R.id.imgbContact:
                    Intent itContact = new Intent(getApplicationContext(), ContactActivity.class);
                    startActivity(itContact);
                    break;
                default:
            }
        }catch (Exception e){

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
