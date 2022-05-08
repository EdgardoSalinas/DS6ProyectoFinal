package com.example.proj102;
//NO SE USA
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Instrucciones extends AppCompatActivity {
    TextView text;

    @Override
    public void onBackPressed() {
        Instrucciones.this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones);
        text = findViewById(R.id.changeText);
        Intent intent = getIntent();
        String s2 = intent.getStringExtra("email");
//        text.setText(s2);
//        text.setText(@String/instruccionestexto);

    }
}