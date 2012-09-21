package org.skyight1.neny.android;

import org.skyight1.neny.android.database.RestaurantDatabase;
import org.skyight1.neny.android.database.model.Restaurant;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowRestaurantDetailActivity extends Activity {
	
	private String camis = null;
	
	@Override
	protected void onCreate(Bundle aSavedInstanceState) {
		
		super.onCreate(aSavedInstanceState);
		
		setContentView(R.layout.restaurant_detail);
		
		Bundle extras = getIntent().getExtras();
		
		if (extras != null) {
			
			camis = extras.getString("camis");
			
			if (camis != null) {
				
				Restaurant restaurant = new RestaurantDatabase(this).getRestaurantByCamis(camis);
				
				if (restaurant != null) {
					showRestaurantDetail(restaurant);
				}
				
			}
			
		}

	}
	
	private void showRestaurantDetail(Restaurant restaurant) {
		
		TextView tvRestaurantName = (TextView) findViewById(R.id.tv_detail_restaurant_name);
		
		tvRestaurantName.setText(restaurant.getDoingBusinessAs());
		
	}

}
