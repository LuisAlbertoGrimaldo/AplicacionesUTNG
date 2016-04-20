package mx.edu.utng.pruebasdesoftwares;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by griselda on 06/04/2016.
 */
public class TemaAdapter extends ArrayAdapter {
    public TemaAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);

    }
}
