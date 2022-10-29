package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText etCity, etCountry;
    TextView weatherResult, Pressure, Wind, temperature, desc, humid, cloud;
    //Weather api to get the current weather
    private final String url = "https://api.openweathermap.org/data/2.5/weather";
    private final String appid = "76a7e1465b299c91d8e5685a9cfc0a23";
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCity = findViewById(R.id.etCity);
        etCountry = findViewById(R.id.etCountryCode);
        weatherResult = findViewById(R.id.weatherRslt);
        Pressure = findViewById(R.id.Pressure);
        Wind = findViewById(R.id.Wind);
        temperature = findViewById(R.id.temperature);
        desc = findViewById(R.id.Description);
        humid = findViewById(R.id.Humidity);
        cloud = findViewById(R.id.Cloud);

    }

    public void getWeatherDetails(View view) {
        String tempURL = "";
        String city = etCity.getText().toString().trim();
        String country = etCountry.getText().toString().trim();

        //when user doesn't enter a city name
        if (city.equals("")) {
            weatherResult.setText("Enter a city!");

        } else {
            if (!country.equals("")) {
                tempURL = url + "?q=" + city + "," + country + "&appid=" + appid;

            } else {
                tempURL = url + "?q=" + city + "&appid=" + appid;
            }
            StringRequest stringRequest = new StringRequest(Request.Method.POST, tempURL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //Log.d("response", response);
                    String output = "";
                    try{
                        JSONObject jsonResponse = new JSONObject(response);
                        JSONArray jsonArray = jsonResponse.getJSONArray("weather");
                        JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);
                        String description = jsonObjectWeather.getString("description");
                        JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
                        double temp = jsonObjectMain.getDouble("temp") - 237.15;
                        float pressure = jsonObjectMain.getInt("pressure");
                        int humidity = jsonObjectMain.getInt("humidity");
                        JSONObject jsonObjectWind = jsonResponse.getJSONObject("wind");
                        String wind = jsonObjectWind.getString("speed");
                        JSONObject jsonObjectClouds = jsonResponse.getJSONObject("clouds");
                        String clouds = jsonObjectClouds.getString("all");
                        JSONObject jsonObjectSys = jsonResponse.getJSONObject("sys");
                        String countryName = jsonObjectSys.getString("country");
                        String cityName = jsonResponse.getString("name");
                        weatherResult.setTextColor(Color.rgb(0, 0, 0));
                        weatherResult.setTextSize(16);
                        output += "Current weather of " + cityName + " in " + countryName;

                        weatherResult.setText(output);

                        temperature.setText(""+df.format(temp)+"celcius");
                        humid.setText(""+humidity+"%");
                        desc.setText(""+description);
                        Wind.setText(""+wind+"m/s");
                        cloud.setText(""+clouds+"%");
                        Pressure.setText(""+pressure+"hPa");





                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }

                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);


        }
    }
}