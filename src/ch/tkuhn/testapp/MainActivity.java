package ch.tkuhn.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	public final static String EXTRA_NAME = "ch.tkuhn.testapp.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	int id = item.getItemId();
    	if (id == R.id.action_search) {
            sendName("Searcher");
    	} else if (id == R.id.action_settings) {
            sendName("Tinker");
    	} else {
    		return super.onOptionsItemSelected(item);
    	}
    	return true;
    }

    public void sendName(View view) {
    	EditText editText = (EditText) findViewById(R.id.edit_name);
    	sendName(editText.getText().toString());
    }

    public void sendName(String name) {
    	Intent intent = new Intent(this, HelloActivity.class);
    	intent.putExtra(EXTRA_NAME, name);
    	startActivity(intent);
    }

}
