package com.android.teaching.chatapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.android.teaching.chatapp.model.Users;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewMessageActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText username;
    private EditText mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        toolbar=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ActionBar accionBAR = getSupportActionBar();
        accionBAR.setDisplayHomeAsUpEnabled(true);
        username=findViewById(R.id.username);
        mensaje=findViewById(R.id.mensaje);
    }
    public void enviar(View view){
        FirebaseDatabase bd= FirebaseDatabase.getInstance();
        DatabaseReference referencia = bd.getReference("messages");
        if(!mensaje.getText().toString().isEmpty() && !username.getText().toString().isEmpty()){
            Users a= new Users(mensaje.getText().toString(),username.getText().toString());
            referencia.push().setValue(a);
        }else{
            if(username.getText().toString().isEmpty() && mensaje.getText().toString().isEmpty()){
                username.setError("Campo debe estar lleno");
                mensaje.setError("Campo debe estar lleno");
            }else{
                if(username.getText().toString().isEmpty()){
                    username.setError("Campo username debe estar rellenad");
                }else{
                    mensaje.setError("Mensaje debe contener algo");
                }
            }
        }

    }
}
