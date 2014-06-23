package com.codemanager.yahooweather;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main extends Activity {
	
	//declare variables
	ListView lv;
	ArrayList<String> cities;
	ArrayAdapter<String> adapter;
	public final static String CITY_NAME = "";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// bootstrap routine
		vinit();
		
		// add onClickListener method to the list view
		lv.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int pos,
					long id) {
				Intent intent = new Intent(getApplicationContext(),CityInfo.class);
				intent.putExtra(CITY_NAME, lv.getItemIdAtPosition(pos));
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void vinit(){
		//get the widget id's
		lv = (ListView)findViewById(R.id.lvCities);
		
		//array list init
		cities = new ArrayList<String>();
		
		//populate the array list with cities
		cities.add("London");
		cities.add("Berlin");
		cities.add("NewYork");
		cities.add("Paris");
		cities.add("New Delhi");
		cities.add("Hong Kong");
		cities.add("Beijing");
		cities.add("Milan");
		cities.add("Madrid");
		cities.add("Cairo");
		cities.add("Brussles");
		cities.add("Rome");
		cities.add("Mexico City");
		cities.add("Barcelona");
		
		// adapter init
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cities);
		
		// plug the list view into the adapter
		lv.setAdapter(adapter);
	}
}
