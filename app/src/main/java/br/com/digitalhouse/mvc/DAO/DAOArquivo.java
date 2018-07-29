package br.com.digitalhouse.mvc.DAO;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import br.com.digitalhouse.mvc.model.Noticia;
import br.com.digitalhouse.mvc.model.NoticiasResposta;

public class DAOArquivo {

    public List<Noticia> obterListaDeNoticiasDoArquivo(Context context) {
        try {

            //Stream para ler o arquivo
            AssetManager manager = context.getAssets();
            InputStream newJson = manager.open("news.json");
            BufferedReader bufferedReaderIn= new BufferedReader(new InputStreamReader(newJson));

            //Cria um objeto Gson para analisar o JSON de forma simples
            Gson gson = new Gson();

            //Ultilizando o objeto gson e o métofo fromJson, fazemos a analise do arquivo que temos no bufferedReaderIn, usando como molde a classe "Noticia"
            NoticiasResposta noticiasResposta = gson.fromJson(bufferedReaderIn, NoticiasResposta.class);

            //Retonamos as noticias
            return noticiasResposta.getNoticias();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
