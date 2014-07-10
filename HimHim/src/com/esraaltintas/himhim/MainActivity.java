package com.esraaltintas.himhim;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	String msg = "Android : ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(msg, "Bu loga dikkat!");
	
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
			.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			final View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
			Button button = (Button) rootView.findViewById(R.id.myButton); 
			button.setOnClickListener(new OnClickListener() {
				int c=0;
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					
					if (c%2==0){
					
					//Toast.makeText(getActivity(), "mirhibi", Toast.LENGTH_SHORT).show();
						ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView1);
						imageView.setImageResource(R.drawable.myimage);
						Animation hyperspaceJump = AnimationUtils.loadAnimation(getActivity(), R.anim.hyperspace_jump);
						imageView.startAnimation(hyperspaceJump);
						c=c+1;
						return;
					}
					else{
						ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView1);
						imageView.setImageDrawable(null);
						Toast.makeText(getActivity(), "mirhibi", Toast.LENGTH_SHORT).show();
						c=c+1;
						return;
					}
					
				}
			});
			

			return rootView;
		}
	}

}
