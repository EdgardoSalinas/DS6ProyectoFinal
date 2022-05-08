package com.example.proj102;
//MUESTRA LAS INSTRUCCIONES-->
//LLAMA LA ACTIVIDAD DE PREGUNTAS Y EL RESULTADO-->
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class activity_instruccion extends AppCompatActivity {

    private Button bt_iniciarprueba;
    private Button bt_cancelarprueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruccion);


        Preguntasaplicadas preguntasaplicadass = ((Preguntasaplicadas)getApplicationContext());

        bt_iniciarprueba=findViewById(R.id.bt_iniciarprueba);
        bt_cancelarprueba=findViewById(R.id.bt_cancelarprueba);

        bt_iniciarprueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i =0; i < 7; i++){
                    Intent intent = new Intent(activity_instruccion.this, activity_preguntas_for.class);
                    startActivity(intent);
                }



            }
        });

        bt_cancelarprueba.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

    }
}
