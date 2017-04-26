package com.example.wilder.houseofcards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.wilder.houseofcards.Politicien.DEPUTE;
import static com.example.wilder.houseofcards.Politicien.MINISTRE;

/**
 * Created by wilder on 05/04/17.
 */

public class PoliticienAdapter extends BaseAdapter implements Filterable{

    private ArrayList<Politicien> elus;
    private int layout;
    private Context context;
    private TextView textViewName;
    private TextView textViewIncome;
    private TextView textViewFunction;
    private TextView textViewBSLevel;

    public PoliticienAdapter(ArrayList<Politicien> array, int layout, Context context){
        this.elus = array;
        this.layout = layout;
        this.context = context;
    }


    @Override
    public int getCount() {
        return elus.size();
    }

    @Override
    public Politicien getItem(int position) {
        return elus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(layout,parent,false);
        }
        textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        textViewIncome = (TextView) convertView.findViewById(R.id.textViewIncome);
        textViewFunction = (TextView) convertView.findViewById(R.id.textViewFunction);
        textViewBSLevel = (TextView) convertView.findViewById(R.id.textViewBsLevel);


        Politicien popol = getItem(position);

        textViewName.setText(popol.getName());
        textViewIncome.setText(String.valueOf(popol.getIncome()));
        textViewBSLevel.setText(String.valueOf(popol.getBullshitLevel()));
        switch (popol.getFunction()){
            case MINISTRE:
                textViewFunction.setText(R.string.ministre);
                break;
            case DEPUTE:
                textViewFunction.setText(R.string.depute);
                break;

        }



        return convertView ;
    }

    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                ArrayList<Politicien> arrayElus = (ArrayList<Politicien>) results.values;
                PoliticienAdapter.this.notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                ArrayList<Politicien> filteredElus = new ArrayList<>();
                FilterResults results = new FilterResults();
// We implement here the filter logic
                if (constraint == null || constraint.length() == 0) {
// No filter implemented we return all the list
                    results.values = elus;
                    results.count = elus.size();
                } else {
// We perform filtering operation

                    String function = constraint.toString();
                    for (Politicien polo : elus) {
                        String poloFunction = Integer.toString(polo.getFunction());
                        if (function.equals(poloFunction)) {
                            filteredElus.add(polo);
                        }

                        results.values = filteredElus;
                        results.count = filteredElus.size();

                    }
                }
                return results;
            }

        };
        return filter;
    }

}
