package com.example.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ejercicio3.model.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONArray> {
    ListView lv;
    ArrayList<Pokemon> datos= new ArrayList<>();
    ProgressBar pbConexion;
    String url;
    RequestQueue queue;
    JsonArrayRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pbConexion = findViewById(R.id.pbConexion);
        lv=findViewById(R.id.lv);
        queue= Volley.newRequestQueue(this);
        url=getResources().getString(R.string.base_url)  + "api/v2/pokemon?limit=151";
        /* probando que url esta bien*/
        // url="https://pokeapi.co/api/v2/pokemon?limit=151";
        request =new JsonArrayRequest(Request.Method.GET,url,null,this,this);
        queue.add(request);
        //for para probar que el listview funciona correctamente
        /*for(int i=0;i<10;i++) {
            Pokemon pokemonTnp = new Pokemon(1238+i, "pokemon "+ (i+1), "url" +(i+1),"# " + (i+1), "experiencia base "+ (i+1)
                    , "altura "+ (i+1), "peso "+ (i+1), "tipo "+ (i+1));
            datos.add(pokemonTnp);
        }*/





    }




//


    @Override
    public void onErrorResponse(VolleyError error) {
        pbConexion.setVisibility(View.GONE);// en caso de error en conexion quitas la barra de cargar
        Toast.makeText(this, "Error conexion" , Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onResponse(JSONArray response) {
        pbConexion.setVisibility(View.GONE);// en caso de error en conexion quitas la barra de cargar
        // tienes que sustituir el for de arrib para llenar tu listview con una conexion y llenado del arreglo datos con esa conexion
        Log.d("RESPUESTA", response.toString());
        JSONObject jsonObject;

        try{
            for (int i=0; i<response.length();i++) {
                jsonObject = response.getJSONObject(i);
                String name = jsonObject.getString("name");
                String url = jsonObject.getString("url");
                Pokemon pokemon = new Pokemon(i,name,url,"#"+(i+1));
                datos.add(pokemon);
            }
            Adaptador adaptador = new Adaptador(this, datos );
            lv.setAdapter(adaptador);
        }catch(JSONException e){


        }

    }
}