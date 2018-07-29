package br.com.digitalhouse.mvc.model;

public class Noticia {

    private String title;
    private String date;
    private String description;
    private String author;

    public Noticia() {
    }

    public Noticia(String title, String date, String description, String author) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
