package com.example.scts_user;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class OneFragment extends Fragment {
    private Toolbar toolbar;
    private TextView textView;

    private int userID;
    private String userName;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_one,container,false);

        toolbar = rootView.findViewById(R.id.toolbar);
        toolbar.setTitle("Anasayfa");

        textView = rootView.findViewById(R.id.textView);
        //userID = rootView.getIntent().getIntExtra("userID", 1);

        //userID = getArguments().getInt("userID");
        //Log.e("Kullanıcı id: ", String.valueOf(userID));

        //Toast.makeText(getActivity(), "deneme", Toast.LENGTH_LONG).show();
        //textView.setText(userID);

        Bundle bundle = getArguments();
        userID = bundle.getInt("userID");
        userName = bundle.getString("userName");
        textView.setText("Merhaba, " + userName);


        return rootView;
        //return inflater.inflate(R.layout.fragment_one,container,false);
    }
}
