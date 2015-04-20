package se.mah.k3.lecture_4_examples_adapter_extra;


import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by K3LARA on 20/04/2015.
 */
public class MyListAdapter extends ArrayAdapter<Book> {
    ArrayList<Book> booksList;
    Context c;

    public MyListAdapter(Context context, ArrayList<Book> booksList) {
        super(context, 0, booksList);
        this.booksList = booksList;
        this.c = context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("MyListAdapter", "Called for position: " + position);
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item,null);
        Book b = booksList.get(position);
        TextView tv = (TextView) convertView.findViewById(R.id.tv_title);
        ImageView iv = (ImageView) convertView.findViewById(R.id.iv_bookcover);
        tv.setText(b.getTitle());
        iv.setImageDrawable(b.getImage());
        return convertView;
    }
}
