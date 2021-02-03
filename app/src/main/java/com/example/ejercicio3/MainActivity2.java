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

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject>{
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
        tvExpbase = findViewById(R.id.tvDatoExpBase);
        tvAltura = findViewById(R.id.tvDatoAltura);
        tvPeso = findViewById(R.id.tvDatoPeso);
        tvTipo = findViewById(R.id.tvDatoTipo);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            url = (String) bundle.getSerializable("url");
        }
        //para probar que llega el url
        Toast.makeText(MainActivity2.this, "url que llego "+ url, Toast.LENGTH_SHORT).show();
        queue= Volley.newRequestQueue(this);
        request =new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        queue.add(request);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(MainActivity2.this, "conexion fallida", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Log.d("RESPUESTA", response.toString());
        Toast.makeText(MainActivity2.this, "conexion exitosa", Toast.LENGTH_SHORT).show();
    }
}