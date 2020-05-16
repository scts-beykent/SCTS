package com.example.scts_user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText editTextEmail, editTextPassword;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userGiris();
            }
        });

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Giriş Yap");
        toolbar.setNavigationIcon(R.drawable.ic_arrow);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void userGiris(){
        String url = "https://denizz.me/kullanici/giris";

        StringRequest istek = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Cevap", response);

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    //Tek veri ise..
                    int sonuc = jsonObject.getInt("success");
                    //int userID = jsonObject.getInt("userID");
                    Log.e("sonuc", String.valueOf(sonuc));
                    Log.e("*********", "*********");

                    if(sonuc == 1){
                        int userID = jsonObject.getInt("userID");
                        String userName = jsonObject.getString("userName");
                        String userPhone = jsonObject.getString("userPhone");
                        String userPassword = jsonObject.getString("userPassword");
                        String userEmail = jsonObject.getString("userEmail");
                        String kayitTarihi = jsonObject.getString("kayitTarihi");
                        Log.e("cevap", "basarili");
                        editTextEmail.setText("");
                        editTextPassword.setText("");

                        Toast.makeText(getApplicationContext(), "Giriş yapıldı!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                        intent.putExtra("userID", userID);
                        intent.putExtra("userName", userName);
                        intent.putExtra("userPhone", userPhone);
                        intent.putExtra("userPassword", userPassword);
                        intent.putExtra("userEmail", userEmail);
                        intent.putExtra("kayitTarihi", kayitTarihi);
                        startActivity(intent);

                        /*
                        Bundle bundle = new Bundle();
                        bundle.putInt("userID", userID);
                        OneFragment fragment = new OneFragment();
                        fragment.setArguments(bundle);
                         */
                    }

                    if(sonuc == 0){
                        Log.e("cevap","basarisiz");
                        Toast.makeText(getApplicationContext(), "Lütfen bilgilerinizi kontrol edin!", Toast.LENGTH_LONG).show();
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

                params.put("email", editTextEmail.getText().toString());
                params.put("password", editTextPassword.getText().toString());

                return params;
            }
        };

        Volley.newRequestQueue(this).add(istek);

    }
}
