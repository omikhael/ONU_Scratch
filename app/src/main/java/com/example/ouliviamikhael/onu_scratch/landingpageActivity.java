package com.example.ouliviamikhael.onu_scratch;

/**
 * Created by ouliviamikhael on 15-08-27.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class landingpageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landingpage_activity);
    }



    public void sendMessage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
