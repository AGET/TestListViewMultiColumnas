package com.aldo.aget.testlistviewmulticolumnas.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aldo.aget.testlistviewmulticolumnas.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class ListviewAdapter extends BaseAdapter {

    public ArrayList<HashMap> list;
    private LayoutInflater inflater;
    private Activity activity;

    public ListviewAdapter(Activity activity, ArrayList<HashMap> list) {
        super();
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_row, null);
            Log.v("AGET-titulo","inflado");
        }

        HashMap map = list.get(position);

        TextView columna1 = (TextView) convertView.findViewById(R.id.columna_1);
        TextView columna2 = (TextView) convertView.findViewById(R.id.columna_2);
        TextView columna3 = (TextView) convertView.findViewById(R.id.columna_3);
        TextView columna4 = (TextView) convertView.findViewById(R.id.columna_4);

        //Rellenamos los valores de cada columna de la fila
        columna1.setText((String)map.get("COLUMNA_1"));
        columna2.setText((String)map.get("COLUMNA_2"));
        columna3.setText((String)map.get("COLUMNA_3"));
        columna4.setText((String)map.get("COLUMNA_4"));

        return convertView;
    }
}
