package com.example.android.employeesmanagementsoftware;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.android.employeesmanagementsoftware.data.Contracts.EmployeeContract;
import com.example.android.employeesmanagementsoftware.data.Contracts.UserContract;
import com.example.android.employeesmanagementsoftware.data.DBHelpers.EmployeesManagementDbHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Pattern;

public class ConnexionActivity extends AppCompatActivity {

    private EditText mail;
    private EditText pwd;
    private ImageView img;
    private TextView err;
    private FloatingActionButton con;
    private EmployeesManagementDbHelper emdb;
    private Intent intent;
    private Cursor cursor;
    private LottieAnimationView lott;
    private LinearLayout ll;

    private static final String pass_regex = "^([A-Za-z]{3,40})([ \\t][A-Za-z]{3,40})*$";
    private static final String email_regex = "^[-a-z0-9~!$%^&*_=+}{\\'?]+(\\.[-a-z0-9~!$%^&*_=+}{\\'?]+)*@([a-z0-9_][-a-z0-9_]*(\\.[-a-z0-9_]+)*\\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,5})?$";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_connexion);
        intent = getIntent();
        emdb = new EmployeesManagementDbHelper(this);
        mail = findViewById(R.id.et_email);
        pwd = findViewById(R.id.et_pass);
        con = findViewById(R.id.fab_connexion);
        err = findViewById(R.id.textView13);
        img = findViewById(R.id.imageView);
        ll = findViewById(R.id.ll_vert_con);
        lott = findViewById(R.id.lottie_duck);
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connecter(v);
            }
        });


    }

    private void connecter(View v) {

        if (champsCorrect() != 2)
            Snackbar.make(v, "Verifiez les valeurs entrées et essayez encore.", Snackbar.LENGTH_LONG).setAction("", null).show();

        else {
            String m = mail.getText().toString();
            String p = pwd.getText().toString();
            boolean res = emdb.checkUser(m, p);

            if (res) {
                OpenHomePage();
            } else {
                Snackbar.make(v, "identifiant ou mot de passe incorrects.", Snackbar.LENGTH_LONG).setAction("", null).show();

            }
        }


    }

    public void OpenSignupPage(View view) {
        startActivity(new Intent(ConnexionActivity.this, InscriptionActivity.class));
    }

    public void OpenHomePage() {
        img.animate().translationX(-1400).setDuration(1000).setStartDelay(100);
        ll.animate().translationX(1400).setDuration(500).setStartDelay(500);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                lott.setVisibility(View.VISIBLE);
            }
        }, 1500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(ConnexionActivity.this, StartingPageActivity.class).putExtra("email", mail.getText().toString()));
//                finish();
            }
        }, 3000);


    }

    public int champsCorrect() {
        int number_of_matches = 0;
        if (Pattern.matches(pass_regex, pwd.getText().toString()))
            number_of_matches++;
        if (Pattern.matches(email_regex, mail.getText().toString()))
            number_of_matches++;

        return number_of_matches;
    }
}