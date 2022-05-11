package com.example.proj102;
//MUESTRA LAS INSTRUCCIONES-->
//LLAMA LA ACTIVIDAD DE PREGUNTAS Y EL RESULTADO-->

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class activity_instruccion extends AppCompatActivity {

    private Button bt_iniciarprueba;
    private Button bt_cancelarprueba;
    private TextView tv_tmprespuesta;
    ArrayList<String> valoresrecibidos = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruccion);


        Preguntasaplicadas preguntasaplicadass = ((Preguntasaplicadas)getApplicationContext());

        bt_iniciarprueba=findViewById(R.id.bt_iniciarprueba);
        bt_cancelarprueba=findViewById(R.id.bt_cancelarprueba);
        tv_tmprespuesta=findViewById(R.id.tv_tmprespuesta);

        ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent intent = result.getData();
                        if (intent != null){
                            try {
                                Bundle extras = getIntent().getExtras();
                                String s = extras.getString("resultado");
                                valoresrecibidos.add(s);
                                Log.i("*****S en getextras*****", String.valueOf(s));
                                tv_tmprespuesta.setText(s);
                            } catch (Exception e){
                                Log.d("MYERROR en getextras", String.valueOf(e));
                            }
//                          String s = extras.getString("resultado");
//                          tv_tmprespuesta.setText(s);
//                          tv_tmprespuesta.setText("finllamado");
                        }
                    }
                }
        );

        bt_iniciarprueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i =0; i < 2; i++){
                    //llamado
                    Intent intent = new Intent(activity_instruccion.this, activity_preguntas_for.class);
//                    startActivity(intent);
                    resultLauncher.launch(intent);
                }
//                tv_tmprespuesta.setText(valoresrecibidos.get(0).toString());

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

