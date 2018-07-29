package br.com.digitalhouse.mvc.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.mvc.model.Noticia;

public class NoticiasAdapter extends BaseAdapter {

    private List<Noticia> noticias;
    private Context context;

    NoticiasAdapter(Context context, List<Noticia> noticias) {
        this.context = context;
        this.noticias = noticias;
    }

    @Override
    public int getCount() {
        return noticias.size();
    }

    @Override
    public Object getItem(int position) {
        return noticias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, null);
        }

        ((TextView)convertView.findViewById(android.R.id.text1)).setText(noticias.get(position).getTitle());

        return convertView;
    }

    public void updateList(List<Noticia> list){
        this.noticias.clear();
        this.noticias.addAll(list);
        notifyDataSetChanged();
    }
}
