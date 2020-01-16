package com.s.recipepuppy.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.s.recipepuppy.R;
import com.s.recipepuppy.recipepuppy.RecipePuppyActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        navigateToApp();
    }

    private void navigateToApp() {
        Intent intent = new Intent(SplashActivity.this, RecipePuppyActivity.class);
        startActivity(intent);
    }
}
