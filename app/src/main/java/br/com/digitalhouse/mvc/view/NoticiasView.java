package br.com.digitalhouse.mvc.view;

import java.util.List;

import br.com.digitalhouse.mvc.model.Noticia;

public interface NoticiasView {
    void mostrarNoticias(List<Noticia> noticias);
}
