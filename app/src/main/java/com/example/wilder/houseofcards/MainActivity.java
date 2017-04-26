package com.example.wilder.houseofcards;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView PolList;
    private ArrayList<Politicien> arrayPol;
    private PoliticienAdapter mAdapter;
    private CheckBox ministre;
    private CheckBox deputy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PolList = (ListView) findViewById(R.id.polList);
        arrayPol = new ArrayList<>();
        mAdapter = new PoliticienAdapter(arrayPol,R.layout.item_politician,this);
        ministre = (CheckBox) findViewById(R.id.checkBoxMinistre);
        ministre.isChecked();

        deputy = (CheckBox) findViewById(R.id.checkBoxDeputy);
        deputy.isChecked();

        Depute truc = new Depute("Marine",75000,1000000, Parti.FN,false);
        truc.cauchtByMediaPart();
        truc.setBullshitLevel();

        arrayPol.add(truc);
        arrayPol.add(new Ministre("Valls",120000,10000,Parti.PS));
        arrayPol.add(new Depute("Nobod",150000,2000000,Parti.LR,false));
        arrayPol.add(new Ministre("NVB",167000,500000,Parti.PS));
        arrayPol.add(new Depute("Melanchon",15000,300000,Parti.FI,true));

        PolList.setAdapter(mAdapter);

        PolList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Politicien popo = arrayPol.get(position);
                popo.setBullshitLevel();
                int shade = 255-255/20*popo.getBullshitLevel();
                int color = Color.argb( 200, 255, shade, shade);
                view.setBackgroundColor( color );
                mAdapter.notifyDataSetChanged();
            }
        });
        //mAdapter2 = new PoliticienAdapter(arrayPol,R.layout.item_politician,this);
        ministre.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mAdapter.getFilter().filter(Integer.toString(Politicien.DEPUTE));
            }
        });

        deputy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mAdapter.getFilter().filter(Integer.toString(Politicien.DEPUTE));
            }
        });

    }
}
