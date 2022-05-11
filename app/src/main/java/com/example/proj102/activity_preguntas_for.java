package com.example.proj102;
//HACE LAS PREGUNTAS
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class activity_preguntas_for extends AppCompatActivity {

    TextView tv_pregunta;
    ImageView iv_imagen;
    RadioGroup rg_radiogroup1;
    RadioButton rb_opcion1;
    RadioButton rb_opcion2;
    RadioButton rb_opcion3;
    RadioButton rb_opcion4;
    Button bt_siguientepregunta;

    String wrespuesta = "";
    String wcorrecto = "";
    RadioButton radiobuttonselected;



    private List<Preguntalineadedato> preguntalineadedatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas_for);

        tv_pregunta = findViewById(R.id.tv_pregunta);
        iv_imagen = findViewById(R.id.iv_imagen);
        rg_radiogroup1 = findViewById(R.id.rg_radioGroup1);
        rb_opcion1 = findViewById(R.id.rb_opcion1);
        rb_opcion2 = findViewById(R.id.rb_opcion2);
        rb_opcion3 = findViewById(R.id.rb_opcion3);
        rb_opcion4 = findViewById(R.id.rb_opcion4);
        bt_siguientepregunta = findViewById(R.id.bt_siguientepregunta);

        bt_siguientepregunta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                int selected_rb_id=rg_radiogroup1.getCheckedRadioButtonId();
                radiobuttonselected=(RadioButton)findViewById(selected_rb_id);

                Intent intent = new Intent();
                String wresultado = tv_pregunta.getText().toString();
                wresultado = wresultado + "," + radiobuttonselected.toString();
                intent.putExtra("resultado",wresultado);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        leerpreguntas();

        Random rand = new Random();
        //        nopregunta = 0;
        Integer nopregunta = rand.nextInt((30 - 1) + 1) + 1;

        Preguntalineadedato datosenunalinea = preguntalineadedatos.get(nopregunta);

        String imagename = datosenunalinea.getImagen();
        int res = getResources().getIdentifier(imagename, "drawable", this.getPackageName());
        iv_imagen.setImageResource(res);

        tv_pregunta.setText(datosenunalinea.getPregunta());

        rb_opcion1.setText(datosenunalinea.getOpcion1());
        rb_opcion2.setText(datosenunalinea.getOpcion2());
        rb_opcion3.setText(datosenunalinea.getOpcion3());
        rb_opcion4.setText(datosenunalinea.getOpcion4());

        wrespuesta = datosenunalinea.getRespuesta();




    }


    private void leerpreguntas() {
        InputStream is = getResources().openRawResource(R.raw.preguntaslistcsv);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line;
        line = "";
        try {
            reader.readLine();
            while ( (line = reader.readLine()) != null)  {
                // dividr por ','
                String[] filas = line.split(",");
                // lee datos de preguntas
                Preguntalineadedato registro = new Preguntalineadedato();
                registro.setNopregunta(filas[0]);
                registro.setPregunta(filas[1]);
                registro.setOpcion1(filas[2]);
                registro.setOpcion2(filas[3]);
                registro.setOpcion3(filas[4]);
                registro.setOpcion4(filas[5]);
                registro.setImagen(filas[6]);
                registro.setRespuesta(filas[7]);
                preguntalineadedatos.add(registro);

                Log.d("ActivityPregunas","Preguntas leidas e insertadas" + registro);

            }
        } catch (IOException e) {
            Log.v("ActivityPreguntas","Error leyendo csv" + line, e);
            e.printStackTrace();
        }

    }

}