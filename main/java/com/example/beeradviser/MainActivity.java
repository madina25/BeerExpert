package com.example.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.beeradviser.BeerExpert;

import java.lang.reflect.Array;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BeerExpert beerExpert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view){
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.color);
        String selectedBeerType = String.valueOf(color.getSelectedItem());
        List<String> brandList = beerExpert.getBrands(selectedBeerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for(String brand: brandList){
            brandsFormatted.append(brand).append('\n');
        }
        brands.setText(brandsFormatted);

    }
}