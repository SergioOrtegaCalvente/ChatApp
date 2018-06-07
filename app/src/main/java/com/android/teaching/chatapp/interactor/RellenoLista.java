package com.android.teaching.chatapp.interactor;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.teaching.chatapp.R;

public class RellenoLista extends BaseAdapter {
    private FireBaseChatInteractor mensajes;
    private Context contexto;


    public RellenoLista(Activity contexto) {
        this.contexto=contexto;
        this.mensajes=new FireBaseChatInteractor();
    }

    public FireBaseChatInteractor getMensajes() {
        return mensajes;
    }

    @Override
    public int getCount() {
            Log.d("Entra en crear ",String.valueOf(this.mensajes.getContenedorMensajes().size()));
        return this.mensajes.getContenedorMensajes().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.lista_mensajes_estilo, parent, false);
        TextView usuario=rowView.findViewById(R.id.usuario_lista);
        usuario.setText(mensajes.getContenedorMensajes().get(position).getUsername());
        TextView mensaje=rowView.findViewById(R.id.mensajes_lista);
        mensaje.setText(mensajes.getContenedorMensajes().get(position).getText());
        return rowView;
    }
}
