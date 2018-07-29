package br.com.digitalhouse.mvc.model;

import java.util.List;

public class NoticiasResposta {
    private List<Noticia> noticias;

    public NoticiasResposta() {
    }

    public NoticiasResposta(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
}
