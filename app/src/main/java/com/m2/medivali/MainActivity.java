package com.m2.medivali;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.m2.medivali.consulta.consulta_fragment_listar;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    BottomAppBar bottomAppBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.btn_add);
        bottomAppBar = findViewById(R.id.buttonAppBar);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_buttons, new fragmentListButton()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.list_view_itens, new consulta_fragment_listar()).commit();
        }

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call fragment

                new fragmentDailogBox().show(getSupportFragmentManager(), "fragmentDialog");
            }
        });

       bottomAppBar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getSupportFragmentManager().beginTransaction().replace(R.id.list_view_itens, new consulta_fragment_listar()).commit();
           }
       });
    }
}