package com.example.tofgi.superdicedefi;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.SecureRandom;

public class DiceActivity extends Activity implements View.OnClickListener {
    private TextView textResult;
    private int max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        max = getIntent().getIntExtra("max", 0);

        TextView textTitle = findViewById(R.id.tvDice);
        textTitle.setText("Dé " + max + " faces");

        textResult = ((TextView)findViewById(R.id.tvResult));
        textResult.setText("");

        Button buttonRoll = (Button)findViewById(R.id.btRoll);
        buttonRoll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SecureRandom random = new SecureRandom();
        int result = random.nextInt(max) + 1;
        textResult.setText(String.valueOf(result));
    }
}
