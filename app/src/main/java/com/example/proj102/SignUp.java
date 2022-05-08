package com.example.proj102;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Sql.DBHelper;

public class SignUp extends AppCompatActivity {

    EditText name , number , email,pass;
    TextView login;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name=findViewById(R.id.textName);
        number=findViewById(R.id.textNumber);
        email=findViewById(R.id.textEmail);
        pass=findViewById(R.id.textPass);
        Button signUpAcc = findViewById(R.id.btnSignUpAcc);
        dbHelper = new DBHelper(this);
        signUpAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String number1 = number.getText().toString();
                String email1 = email.getText().toString();
                String pass1 = pass.getText().toString();
                boolean b =dbHelper.insetUserData(name1,number1,email1,pass1);
                if (b){
                    Toast.makeText(SignUp.this,"Data inserted",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignUp.this,Login.class);
                    startActivity(i);
                }else {
                    Toast.makeText(SignUp.this,"Failed To insert Data",Toast.LENGTH_SHORT).show();
                }
            }
        });
        login=findViewById(R.id.loginAcc);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUp.this,Login.class);
                startActivity(i);
            }
        });
    }

/*    public static class PreguntasDataRow {
        private String nopregunta;
        private String pregunta;
        private String opcion1;
        private String opcion2;
        private String opcion3;
        private String opcion4;
        private String imagen;
        private String respuesta;

        public String getNopregunta() {
            return nopregunta;
        }

        public void setNopregunta(String nopregunta) {
            this.nopregunta = nopregunta;
        }

        public String getPregunta() {
            return pregunta;
        }

        public void setPregunta(String pregunta) {
            this.pregunta = pregunta;
        }

        public String getOpcion1() {
            return opcion1;
        }

        public void setOpcion1(String opcion1) {
            this.opcion1 = opcion1;
        }

        public String getOpcion2() {
            return opcion2;
        }

        public void setOpcion2(String opcion2) {
            this.opcion2 = opcion2;
        }

        public String getOpcion3() {
            return opcion3;
        }

        public void setOpcion3(String opcion3) {
            this.opcion3 = opcion3;
        }

        public String getOpcion4() {
            return opcion4;
        }

        public void setOpcion4(String opcion4) {
            this.opcion4 = opcion4;
        }

        public String getImagen() {
            return imagen;
        }

        public void setImagen(String imagen) {
            this.imagen = imagen;
        }

        public String getRespuesta() {
            return respuesta;
        }

        public void setRespuesta(String respuesta) {
            this.respuesta = respuesta;
        }
    }*/
}