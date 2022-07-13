package com.metrocoding.pdfapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.metrocoding.pdfapp.databinding.ActivityMessageBinding;

public class Message extends AppCompatActivity {
        ActivityMessageBinding binding;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            binding =   ActivityMessageBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
        }
}