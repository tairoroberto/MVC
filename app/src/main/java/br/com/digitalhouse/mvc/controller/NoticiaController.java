package br.com.digitalhouse.mvc.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.util.List;

import br.com.digitalhouse.mvc.DAO.DAOArquivo;
import br.com.digitalhouse.mvc.DAO.DAOInternet;
import br.com.digitalhouse.mvc.model.Noticia;
import br.com.digitalhouse.mvc.view.NoticiasView;

public class NoticiaController {

    private NoticiasView view;

    public NoticiaController(NoticiasView view) {
        this.view = view;
    }

    private boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo;

        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected() &&
                    (networkInfo.getType() == ConnectivityManager.TYPE_WIFI
                            || networkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
        }
        return false;
    }

    @SuppressLint("StaticFieldLeak")
    public void getNoticias(Context context) {
        List<Noticia> noticias;

        if (isNetworkConnected(context)) {

            new AsyncTask<Void, Void, List<Noticia>>() {

                @Override
                protected List<Noticia> doInBackground(Void... voids) {
                    return new DAOInternet().obterListaDeNoticiasDaInternet();
                }

                @Override
                protected void onPostExecute(List<Noticia> noticiasList) {
                    view.mostrarNoticias(noticiasList);
                }
            }.execute();

        } else {
            noticias = new DAOArquivo().obterListaDeNoticiasDoArquivo(context);
            view.mostrarNoticias(noticias);
        }
    }
}
