package com.cursoandroid.firebaseapp.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioReferencia =  databaseReferencia.child("usuarios");
    private DatabaseReference produtoReferencia =  databaseReferencia.child("produtos").child("001");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  Usuario usuario = new Usuario();
        Produto produto = new Produto();

        usuario.setNome("Ana Helena");
        usuario.setSobrenome("Silva");
        usuario.setIdade(25);
        usuario.setSexo("Feminino");


        produto.setCor("branco");
        produto.setDescricao("8 polegadas");
        produto.setFabricante("apple");

        usuarioReferencia.child("003").setValue(usuario);

        produtoReferencia.child("001").setValue(produto);*/


        produtoReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               Log.i("FIREBASE",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
