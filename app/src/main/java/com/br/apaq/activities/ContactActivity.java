package com.br.apaq.activities;

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
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.br.apaq.R;
import com.br.apaq.maps.MapsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactActivity extends AppCompatActivity {

    @BindView(R.id.imgbContactII)
    ImageButton rCall;

    @BindView(R.id.imgbContactIII)
    ImageButton rCell;

    @BindView(R.id.imgbEmail)
    ImageButton email;

    @BindView(R.id.imgbMap)
    ImageButton rRoute;

    @BindView(R.id.imgbFacebook)
    ImageButton rFacebook;

    @BindView(R.id.imgbInstagram)
    ImageButton rInstagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                String url = "tel:04188996400688";
                Intent itCellPhone = new Intent(Intent.ACTION_CALL, Uri.parse(url));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.left_arrow));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @OnClick(R.id.imgbContactII)
    public void call() {
        callphone();
    }

    @OnClick(R.id.imgbContactIII)
    public void callCell() {
        callCellPhone();
    }

    @OnClick(R.id.imgbEmail)
    public void apaqEmail() {
        sendEmail();
    }

    @OnClick(R.id.imgbMap)
    public void apaqRoute() {
        route();
    }

    @OnClick(R.id.imgbFacebook)
    public void apaqFacebook() {
        goFacebook();
    }

    @OnClick(R.id.imgbInstagram)
    public void apaqInstagram() {
        goInstagram();
    }

    private void callphone() {
        String url = "tel:04188999203095";
        Intent itCall = new Intent(Intent.ACTION_CALL, Uri.parse(url));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(itCall);
    }

    private void callCellPhone() {
        String url = "tel:04188996332351";
        Intent itCellPhone = new Intent(Intent.ACTION_CALL, Uri.parse(url));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void sendEmail() {
        // Text to send (Body Text)
        String emailBody = "APAQ! Gostaria de agendar um Horario";
        // Address to send
        String emailAddress = "apaqce@gmail.com";
        // Subject to email
        String emailSubject = "Atendimento App";

        String[] recipients = {emailAddress.toString()};
        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("APAQ: "));
        // prompts email clients only
        email.setType("message/rfc822");
        email.putExtra(Intent.EXTRA_EMAIL, recipients);
        email.putExtra(Intent.EXTRA_SUBJECT, emailSubject.toString());
        email.putExtra(Intent.EXTRA_TEXT, emailBody.toString());

        try {
            // the user can choose the email client
            startActivity(Intent.createChooser(email, "Choose an email client from..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ContactActivity.this, "No email client installed.",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void route() {
        Intent itRoute = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(itRoute);
    }

    private void goInstagram() {
        Uri uri = Uri.parse("https://www.instagram.com/apaqce/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void goFacebook() {
        Uri uri = Uri.parse("https://www.facebook.com/profile.php?id=100010355865082&fref=ts");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
