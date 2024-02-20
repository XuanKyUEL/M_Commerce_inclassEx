package com.example.view_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.view_ex2.databinding.ActivityMain2Binding;
import com.example.view_ex2.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
        // Using View Binding
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fbEvents();

    }
    private void fbEvents() {
        binding.btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("MainActivity2", "Submitted");
                binding.txtRes.setText("");
                String rs = "Feedback: ";
//                if (binding.radEx.isChecked())
//                    rs += binding.radEx.getText().toString();
//                else if (binding.radGo.isChecked()) {
//                    rs += binding.radGo.getText().toString();
//                }
//                else if (binding.radAv.isChecked()) {
//                    rs +=  binding.radAv.getText().toString();
//                }
//                else if (binding.radBa.isChecked()) {
//                    rs += binding.radBa.getText().toString();
//                }
                RadioGroup radGroup = binding.radGrp;
                int radCheckedId = radGroup.getCheckedRadioButtonId();
                if (radCheckedId > 0) {
                    RadioButton radChecked = findViewById(radCheckedId);
                    rs += radChecked.getText().toString();
                }
                binding.txtRes.setText(rs);
            }
        });
    }
}