package com.example.scts_user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private Button button;
    private Toolbar toolbar;
    private EditText editTextName, editTextEmail, editTextPhone, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextPassword);

        //userKayit();
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userKayit();
            }
        });

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Yeni Hesap Oluştur");
        toolbar.setNavigationIcon(R.drawable.ic_arrow);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    public void userKayit(){
        String url = "https://denizz.me/kullanici/kayit"; //https://denizz.me/servisler/userKayit.php

        StringRequest istek = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Cevap", response);

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    //Tek veri ise..
                    int sonuc = jsonObject.getInt("success");
                    Log.e("sonuc", String.valueOf(sonuc));
                    Log.e("*********", "*********");

                    if(sonuc == 1){
                        Log.e("cevap", "basarili");
                        editTextName.setText("");
                        editTextEmail.setText("");
                        editTextPhone.setText("");
                        editTextPassword.setText("");

                        Toast.makeText(getApplicationContext(), "Hesabınız başarılı bir şekilde oluşturuldu!", Toast.LENGTH_LONG).show();
                    }

                    if(sonuc == 0){
                        Log.e("cevap","basarisiz");
                        Toast.makeText(getApplicationContext(), "Lütfen tüm alanları doldurun!", Toast.LENGTH_LONG).show();
                    }


                    /* Çoklu veri ise..
                    JSONArray kayitSonuc = jsonObject.getJSONArray("success");
                    for(int i = 0; i<kayitSonuc.length(); i++){
                        JSONObject k = kayitSonuc.getJSONObject(i);
                        int sonuc = k.getInt("success");
                        String name = k.getString("name");

                        Log.e("sonuc", String.valueOf(sonuc));
                        Log.e("name", name);
                        Log.e("*********", "*********");
                    }
                    */

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();

                params.put("name", editTextName.getText().toString());
                params.put("email", editTextEmail.getText().toString());
                params.put("password", editTextPassword.getText().toString());
                params.put("phone", editTextPhone.getText().toString());

                return params;
            }
        };

        Volley.newRequestQueue(this).add(istek);

    }
}
