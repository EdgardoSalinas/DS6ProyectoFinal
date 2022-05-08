package com.example.proj102;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import Sql.DBHelper;

public class Login extends AppCompatActivity {

    EditText email , password;
    Button btnSubmit;
    TextView createAcc;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Boolean e=false,p=false;
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.text_email);
        password=findViewById(R.id.text_pass);
        btnSubmit = findViewById(R.id.btnSubmit_login);
        dbHelper = new DBHelper(this);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailCheck = email.getText().toString();
                String passCheck = password.getText().toString();
                Cursor  cursor = dbHelper.getData();
                if(cursor.getCount() == 0){
                    Toast.makeText(Login.this,"No Existen Registros",Toast.LENGTH_LONG).show();
                }
                if (loginCheck(cursor,emailCheck,passCheck)) {
                    Intent intent = new Intent(Login.this, activity_instruccion.class);
//                    Intent intent = new Intent(Login.this, Instrucciones.class);
//                    intent.putExtra("email",emailCheck);
                    email.setText("");
                    password.setText("");
                    startActivity(intent);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setCancelable(true);
                    builder.setTitle("Usuario Invalido");
                    builder.setMessage("Usuario Invalido");
                    builder.show();
                }
                dbHelper.close();
            }
        });
        createAcc=findViewById(R.id.createAcc);
        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,SignUp.class);
                startActivity(intent);
            }
        });
    }
    public static boolean loginCheck(Cursor cursor,String emailCheck,String passCheck) {
        while (cursor.moveToNext()){
            if (cursor.getString(0).equals(emailCheck)) {
                if (cursor.getString(2).equals(passCheck)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}