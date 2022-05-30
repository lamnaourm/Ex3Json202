package com.example.ex3json202;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView t1, t2, t3;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.nom);
        t2 = findViewById(R.id.adr);
        t3 = findViewById(R.id.specialite);
        lst = findViewById(R.id.lst);

        try {
            JSONObject obj = new JSONObject(loadJsonFromRaw(R.raw.etablissement));

            t1.setText("Nom Etablissement : " + obj.getString("nom"));
            t2.setText("Adresse : " + obj.getString("Adresse"));
            t3.setText("Specialite  : "  + obj.getString("specialite"));
            JSONArray arr = obj.getJSONArray("filieres");
            ArrayList<String> fils = new ArrayList<>();
            for(int i=0;i<arr.length();i++){
                JSONObject o = arr.getJSONObject(i);
                fils.add(o.getString("description") + " - " + o.getInt("nbModule") );
            }

            ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,fils);
            lst.setAdapter(ad);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJsonFromRaw(int resId){
        try {
            InputStream in = getResources().openRawResource(resId);
            byte[] data = new byte[in.available()];
            in.read(data);
            return new String(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}