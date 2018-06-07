package com.android.teaching.chatapp.interactor;

import android.util.Log;

import com.android.teaching.chatapp.interfaces.MensajeInteractorCallback;
import com.android.teaching.chatapp.model.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FireBaseChatInteractor {
    private ArrayList<Users> contenedorMensajes;


    public FireBaseChatInteractor() {
        this.contenedorMensajes=new ArrayList<>();
    }


    public void getMensajes(final MensajeInteractorCallback llamada){
        FirebaseDatabase bd= FirebaseDatabase.getInstance();
        DatabaseReference referencia = bd.getReference("messages");
        referencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot user: dataSnapshot.getChildren()){
                    Users usuario= user.getValue(Users.class);
                    contenedorMensajes.add(usuario);
                    Log.d("USUARIO",usuario.getText());
                }
                llamada.mensajesListo();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public ArrayList<Users> getContenedorMensajes() {
        return contenedorMensajes;
    }
}
