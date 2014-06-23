package com.codemanager.yahooweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CityInfo extends Activity {

	// declare variables
	TextView tvCityName, tvWeather;
	ImageView ivCity;
	String cName, w;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.city_info);

		// variables init
		vinit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.city_info, menu);
		return true;
	}

	public void vinit() {
		// get widget id's
		tvCityName = (TextView) findViewById(R.id.tvCityName);
		tvWeather = (TextView) findViewById(R.id.tvWeather);
		ivCity = (ImageView) findViewById(R.id.ivCity);

		updateUI();
	}

	public void updateUI() {
		// get intent data
		Intent intent = getIntent();

		// get the city name
		cName = intent.getStringExtra(Main.CITY_NAME).toLowerCase();
//		Toast.makeText(getApplicationContext(), cName, Toast.LENGTH_LONG).show();

		// determine which image should be displayed according to city name
		if (cName.equals("london")) {
			ivCity.setBackgroundResource(R.drawable.london);

		} else if (cName.equals("berlin")) {
			ivCity.setBackgroundResource(R.drawable.berlin);

		} else if (cName.equals("newyork")) {
			ivCity.setBackgroundResource(R.drawable.newyork);

		} else if (cName.equals("paris")) {
			ivCity.setBackgroundResource(R.drawable.paris);

		} else {
			ivCity.setBackgroundResource(R.drawable.oldic_launcher);
		}

		// display the weather of the city
		tvWeather.setText("24 Deg");
	}
}
