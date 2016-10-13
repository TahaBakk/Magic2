package com.example.x3727349s.magic;

import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.zip.Inflater;

import static android.R.attr.id;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {


    private Button masVida1, menosVida1, masVeneno1, menosVeneno1, quitarVida1;
    private Button masVida2, menosVida2, masVeneno2, menosVeneno2, quitarVida2;

    private TextView textView1;
    private TextView textView2;

    private int contadorVida1=20, contadorVeneno1=0;
    private int contadorVida2=20, contadorVeneno2=0;


    private Menu btReset;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        textView1 = (TextView) view.findViewById(R.id.textView1);
        textView2 = (TextView) view.findViewById(R.id.textView2);

        /*Des d'aqui estem fent que si li donem click al boto fagin una funció*/

        masVida1 = (Button)  view.findViewById(R.id.masVida1);
        masVida1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                contadorVida1++;
                textView1.setText(contadorVida1+"/"+contadorVeneno1);
            }
        });

        masVida2 = (Button) view.findViewById(R.id.masVida2);
        masVida2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                contadorVida2++;
                textView2.setText(contadorVida2+"/"+contadorVeneno2);
            }
        });

        masVeneno1 = (Button) view.findViewById(R.id.masVeneno1);
        masVeneno1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                contadorVeneno1++;
                textView1.setText(contadorVida1+"/"+contadorVeneno1);
            }
        });

        masVeneno2 = (Button) view.findViewById(R.id.masVeneno2);
        masVeneno2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                contadorVeneno2++;
                textView2.setText(contadorVida2+"/"+contadorVeneno2);
            }
        });

        menosVida1 = (Button) view.findViewById(R.id.menosVida1);
        menosVida1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                contadorVida1--;
                textView1.setText(contadorVida1+"/"+contadorVeneno1);
            }
        });

        menosVida2 = (Button) view.findViewById(R.id.menosVida2);
        menosVida2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                contadorVida2--;
                textView2.setText(contadorVida2+"/"+contadorVeneno2);
            }
        });

        menosVeneno1 = (Button) view.findViewById(R.id.menosVeneno1);
        menosVeneno1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(contadorVeneno1>0){
                    contadorVeneno1--;
                    textView1.setText(contadorVida1+"/"+contadorVeneno1);}
            }
        });

        menosVeneno2 = (Button) view.findViewById(R.id.menosVeneno2);
        menosVeneno2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(contadorVeneno2>0){
                    contadorVeneno2--;
                    textView2.setText(contadorVida2+"/"+contadorVeneno2);}
            }
        });

        quitarVida1 = (Button) view.findViewById(R.id.quitarVida1);
        quitarVida1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                contadorVida1++;
                contadorVida2--;
                textView1.setText(contadorVida1+"/"+contadorVeneno1);
                textView2.setText(contadorVida2+"/"+contadorVeneno2);
            }
        });

        quitarVida2 = (Button) view.findViewById(R.id.quitarVida2);
        quitarVida2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                contadorVida1--;
                contadorVida2++;
                textView1.setText(contadorVida1+"/"+contadorVeneno1);
                textView2.setText(contadorVida2+"/"+contadorVeneno2);
            }
        });

        // btReset = (Menu) view.findViewById(R.id.@+id/mnReset);

        return view;
    }

    /* Link de como hacerlo en el moodle */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    //esto es para inflar el fragment (lo hacemos para el boton reset)
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.reset) {
            reset();
            return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    private void reset() {
        contadorVida1=20;
        contadorVeneno1=0;
        contadorVida2=20;
        contadorVeneno2=0;
        textView1.setText(contadorVida1+"/"+contadorVeneno1);
        textView2.setText(contadorVida2+"/"+contadorVeneno2);

        Snackbar.make(getView(), "se reinicio los contadores", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }





}
