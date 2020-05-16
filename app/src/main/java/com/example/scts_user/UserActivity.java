package com.example.scts_user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserActivity extends AppCompatActivity {
    private BottomNavigationView bottom_nav;
    private Fragment tempFragment;

    private int userID;
    private String userName;
    private String userPhone;
    private String userPassword;
    private String userEmail;
    private String kayitTarihi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        bottom_nav = findViewById(R.id.bottom_nav);

        userID = getIntent().getIntExtra("userID", 1);
        userName = getIntent().getStringExtra("userName");
        userEmail = getIntent().getStringExtra("userEmail");
        userPassword = getIntent().getStringExtra("userPassword");
        userPhone = getIntent().getStringExtra("userPhone");
        kayitTarihi = getIntent().getStringExtra("kayitTarihi");
        Log.e("Kullanıcı id: ", String.valueOf(userID));

        //getSupportFragmentManager().beginTransaction().add(R.id.fragment_tutucu, new OneFragment()).commit();

        FragmentManager fm = getSupportFragmentManager();
        OneFragment onefragment = new OneFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("userID", userID);
        bundle.putString("userName", userName);
        bundle.putString("userPhone", userPhone);
        bundle.putString("userPassword", userPassword);
        bundle.putString("userEmail", userEmail);
        bundle.putString("kayitTarihi", kayitTarihi);
        onefragment.setArguments(bundle);

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_tutucu,onefragment);
        ft.commit();

        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.action_anasayfa){
                    //Toast.makeText(getApplicationContext(), "Anasayfa", Toast.LENGTH_LONG).show();
                    tempFragment = new OneFragment();
                }

                if(item.getItemId() == R.id.action_paketlerim){
                    //Toast.makeText(getApplicationContext(), "Paketlerim", Toast.LENGTH_LONG).show();
                    tempFragment = new TwoFragment();
                }

                if(item.getItemId() == R.id.action_hesabim){
                    //Toast.makeText(getApplicationContext(), "Hesabım", Toast.LENGTH_LONG).show();
                    tempFragment = new ThreeFragment();
                }

                if(item.getItemId() == R.id.action_ayarlar){
                    //Toast.makeText(getApplicationContext(), "Ayarlar", Toast.LENGTH_LONG).show();
                    tempFragment = new FourFragment();
                }

                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu, tempFragment).commit();

                FragmentManager fm = getSupportFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putInt("userID", userID);
                bundle.putString("userName", userName);
                bundle.putString("userPhone", userPhone);
                bundle.putString("userPassword", userPassword);
                bundle.putString("userEmail", userEmail);
                bundle.putString("kayitTarihi", kayitTarihi);
                tempFragment.setArguments(bundle);
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_tutucu,tempFragment);
                ft.commit();

                return true;
            }
        });
    }
}
