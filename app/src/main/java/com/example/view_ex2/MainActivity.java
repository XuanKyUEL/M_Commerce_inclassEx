package com.example.view_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.example.view_ex2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        // Using View Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();

    }

    private void addEvents() {
        binding.btnVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "Vote button clicked");

                String result = "Nền tảng yêu thích của bạn là: " ;
                if (binding.cbDisney.isChecked())
                    result += binding.cbDisney.getText().toString() + ", ";
                if (binding.cbHBO.isChecked())
                    result += binding.cbHBO.getText().toString() + ", ";
                if (binding.cbNetflix.isChecked())
                    result += binding.cbNetflix.getText().toString() + ", ";
                binding.tvResult.setText(result.substring(0, result.length() - 2));
            }
        });
    }
}

