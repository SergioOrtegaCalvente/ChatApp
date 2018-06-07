package com.android.teaching.chatapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.teaching.chatapp.interactor.FireBaseChatInteractor;
import com.android.teaching.chatapp.interactor.RellenoLista;
import com.android.teaching.chatapp.interfaces.MensajeInteractorCallback;

public class ChatActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RellenoLista lista;
    private ListView lista_rellenar;
    private FireBaseChatInteractor a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
        lista_rellenar=findViewById(R.id.lista_mensajes);
        lista= new RellenoLista(this);
        lista.getMensajes().getMensajes(new MensajeInteractorCallback() {
            @Override
            public void mensajesListo() {
                lista_rellenar.setAdapter(lista);
            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflador= getMenuInflater();
        inflador.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.agregar_mensaje:
                Intent agregar_mensaje= new Intent(this,NewMessageActivity.class);
                startActivity(agregar_mensaje);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
