package com.example.view_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.view_ex2.databinding.ActivityImgViewExBinding;

public class ImgView_Ex extends AppCompatActivity {

    ActivityImgViewExBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_img_view_ex);
        binding = ActivityImgViewExBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();

    }

    private void addEvents() {
        binding.btnChange.setOnClickListener(new View.OnClickListener() {
            // Change image
            @Override
            public void onClick(View v) {
                Log.d("TagValue", "Tag value: " + binding.imgView.getTag());
                if (binding.imgView.getTag() == null || binding.imgView.getTag().equals("shein")) {
                    binding.imgView.setImageResource(R.drawable.uniqlo_logo2);
                    binding.imgView.setTag("uniqlo");
                }
                else {
                binding.imgView.setImageResource(R.drawable.shein_logo);
                binding.imgView.setTag("shein");
                }
            }
        });
//            public void onClick(View v) {
//                Log.d("TagValue", "Tag value: " + binding.imgView.getTag());
//
//                Animation fadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
//                binding.imgView.startAnimation(fadeOut);
//
//                fadeOut.setAnimationListener(new Animation.AnimationListener() {
//                    @Override
//                    public void onAnimationStart(Animation animation) {
//                        // Code khi animation bắt đầu
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animation animation) {
//                        // Code khi animation kết thúc
//
//                        if (binding.imgView.getTag() == null || binding.imgView.getTag().equals("shein")) {
//                            binding.imgView.setImageResource(R.drawable.uniqlo_logo2);
//                            binding.imgView.setTag("uniqlo");
//                        } else {
//                            binding.imgView.setImageResource(R.drawable.shein_logo);
//                            binding.imgView.setTag("shein");
//                        }
//
//                        // Bắt đầu animation fade in
//                        Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
//                        binding.imgView.startAnimation(fadeIn);
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animation animation) {
//                        // Code khi animation lặp lại
//                    }
//        });
//            }
//        });
        binding.closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}