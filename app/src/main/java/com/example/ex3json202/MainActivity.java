package com.example.ex3json202;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView t1, t2, t3;
    ListView lst;
    MyDBFiliere db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new MyDBFiliere(this);

        t1 = findViewById(R.id.nom);
        t2 = findViewById(R.id.adr);
        t3 = findViewById(R.id.specialite);
        lst = findViewById(R.id.lst);

        Etablissement ee = getEtablissementFromJSON();

        t1.setText("Nom Etablissement : " + ee.getNom());
        t2.setText("Adresse : " + ee.getAdresse());
        t3.setText("Specialite  : " + ee.getSpecialite());
        ArrayList<String> fils = new ArrayList<>();
        for (int i = 0; i < ee.getFilieres().size(); i++) {
            fils.add(ee.getFilieres().get(i).getDescription() + " - " + ee.getFilieres().get(i).getNbModule());
        }

        for(Filiere ff : ee.getFilieres())
            MyDBFiliere.insert_filiere(db.getWritableDatabase(),ff);

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, fils);
        lst.setAdapter(ad);
    }

    public String loadJsonFromRaw(int resId) {
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

    public Etablissement getEtablissementFromJSON() {
        Etablissement e = new Etablissement();
        try {
            JSONObject obj = new JSONObject(loadJsonFromRaw(R.raw.etablissement));

            e.setNom(obj.getString("nom"));
            e.setAdresse(obj.getString("Adresse"));
            e.setSpecialite(obj.getString("specialite"));
            JSONArray arr = obj.getJSONArray("filieres");
            for (int i = 0; i < arr.length(); i++) {
                Filiere f = new Filiere();
                JSONObject o = arr.getJSONObject(i);

                f.setCode(o.getString("code"));
                f.setDescription(o.getString("description"));
                f.setNiveau(o.getString("niveau"));
                f.setNbModule(o.getInt("nbModule"));

                e.getFilieres().add(f);
            }
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }

        return e;
    }
}