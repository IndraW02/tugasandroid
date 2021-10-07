package com.example.indraexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Inisialisasi
    ListView listView;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;

    // Data
    String[] nama = { "Indra", "Wirawan", "Arip", "Suhar" };
    String[] provinsi = {"Jawa Timur", "Jawa Barat", "Jawa Tengah"};
    String[] kota = {"Yogyakarta", "Bandung", "Banyuwangi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // akses list view
        listView = findViewById(R.id.list_all_name);
        ArrayAdapter listAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, nama);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listAdapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Anda Adalah : " + listAdapterView.getItemAtPosition(i) , Toast.LENGTH_SHORT).show();
            }
        });

        // akses spinner
        spinner = findViewById(R.id.category_spinner);
        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, provinsi);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> spinnerAdapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Ini Provinsi " + spinnerAdapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // akses auto complete text
        autoCompleteTextView = findViewById(R.id.new_autocompletetext);
        ArrayAdapter act_adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, kota);
        autoCompleteTextView.setAdapter(act_adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Kota : " + adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}