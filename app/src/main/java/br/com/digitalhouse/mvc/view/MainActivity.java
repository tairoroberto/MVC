package br.com.digitalhouse.mvc.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.digitalhouse.mvc.R;
import br.com.digitalhouse.mvc.controller.NoticiaController;
import br.com.digitalhouse.mvc.model.Noticia;

public class MainActivity extends AppCompatActivity implements NoticiasView {

    private ListView listViewNoticias;
    private NoticiaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new NoticiaController(this);
        listViewNoticias = findViewById(R.id.listViewNoticias);
        Button buttonGetNoticias = findViewById(R.id.buttonGetNoticias);

        buttonGetNoticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.getNoticias(MainActivity.this);
            }
        });
    }

    @Override
    public void mostrarNoticias(List<Noticia> noticias) {
        listViewNoticias.setAdapter(new NoticiasAdapter(this, noticias));
    }
}
