package com.example.scts_user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class ThreeFragment extends Fragment {
    private Toolbar toolbar;
    private EditText editTextName, editTextEmail, editTextPhone, editTextPassword;

    private int userID;
    private String userName;
    private String userPhone;
    private String userPassword;
    private String userEmail;
    private String kayitTarihi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_three,container,false);
        toolbar = rootView.findViewById(R.id.toolbar);
        toolbar.setTitle("Hesabım");

        editTextName = rootView.findViewById(R.id.editTextName);
        editTextEmail = rootView.findViewById(R.id.editTextEmail);
        editTextPhone = rootView.findViewById(R.id.editTextPhone);
        editTextPassword = rootView.findViewById(R.id.editTextPassword);

        Bundle bundle = getArguments();
        userID = bundle.getInt("userID");
        userName = bundle.getString("userName");

        userPhone = bundle.getString("userPhone");
        userPassword = bundle.getString("userPassword");
        userEmail = bundle.getString("userEmail");
        kayitTarihi = bundle.getString("kayitTarihi");

        editTextName.setText(userName);
        editTextEmail.setText(userEmail);
        editTextPhone.setText(userPhone);
        editTextPassword.setText(userPassword);

        return rootView;
    }
}
