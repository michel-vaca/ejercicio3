package com.example.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ejercicio3.model.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject>{
    TextView tvNombre;
    TextView tvExpbase;
    TextView tvAltura;
    TextView tvPeso;
    TextView tvTipo;
    String url;
    RequestQueue queue;
    JsonObjectRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvNombre = findViewById(R.id.tvNombre);
        tvExpbase = findViewById(R.id.tvDatoExpBase);
        tvAltura = findViewById(R.id.tvDatoAltura);
        tvPeso = findViewById(R.id.tvDatoPeso);
        tvTipo = findViewById(R.id.tvDatoTipo);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            url = (String) bundle.getSerializable("url");
        }
        //para probar que llega el url
       // Toast.makeText(MainActivity2.this, "url que llego "+ url, Toast.LENGTH_SHORT).show();
        queue= Volley.newRequestQueue(this);
        request =new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        queue.add(request);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, getResources().getString(R.string.stErrorConexion), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
//        Log.d("RESPUESTA", response.toString());


        try{
            tvNombre.setText(response.getString("name"));
            tvExpbase.setText(response.getString("base_experience"));
            tvAltura.setText(response.getString("height"));
            tvPeso.setText(response.getString("weight"));

            JSONArray arreglo_jason_tipos= response.getJSONArray("types");
           String[] tipos= new String[arreglo_jason_tipos.length()];
           String tipostexto;
            for (int i=0; i<arreglo_jason_tipos.length();i++) {
                tipos[i]=arreglo_jason_tipos.getJSONObject(i).getJSONObject("type").getString("name");
            }

            // se agrega este codigo por si despues se quiere hacerlo con pokemones con mas de 2 tipos
            tipostexto= tipos[0];
            if(tipos.length>0)
            for (int i=1; i<tipos.length;i++) {
                tipostexto =tipostexto  + "," + tipos[i];
            }

            tvTipo.setText(tipostexto);




            //  Toast.makeText(this,  "cuenta " +  response.getInt("count"), Toast.LENGTH_SHORT).show();

        }catch(JSONException e){


        }/**/

    }
}