package com.br.apaq.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.br.apaq.R;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout rOne, rTwo, rThree, rFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
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

        rOne = (RelativeLayout)findViewById(R.id.relativePhone);
        rTwo = (RelativeLayout)findViewById(R.id.relativeCellphone);
        rThree = (RelativeLayout)findViewById(R.id.relativeEmail);
        rFour = (RelativeLayout)findViewById(R.id.relativeMap);

        rOne.setOnClickListener(this);
        rTwo.setOnClickListener(this);
        rThree.setOnClickListener(this);
        rFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()){
                case R.id.relativePhone:
                    callphone();
                    break;

                case R.id.relativeCellphone:
                    callCellPhone();
                    break;

                case R.id.relativeEmail:
                    sendEmail();
                    break;
                case R.id.relativeMap:
                    Intent itMap = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(itMap);
                    break;
                default:

            }

        }catch (Exception e){

        }
    }

    private void callphone() {

    }

    private void callCellPhone() {

    }

    private void sendEmail() {

    }
}
