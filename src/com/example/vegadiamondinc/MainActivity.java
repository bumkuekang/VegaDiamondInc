package com.example.vegadiamondinc;

import android.support.v7.app.ActionBarActivity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;


public class MainActivity extends ActionBarActivity {
	CharSequence[] gContactUsMethod = {"Call Us", "Email Us"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button vDiaListButton = (Button) findViewById(R.id.ContactUsButton);
        vDiaListButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(0);
				
			}
		});

        Button vContactUsBtn = (Button) findViewById(R.id.ContactUsButton);
        vContactUsBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(2);
				
			}
		});
    }
    
    @Override
    protected Dialog onCreateDialog(int aBtnId) {
    	switch (aBtnId) {
    	case 0:
    		return null;
    	case 2:
    		return new AlertDialog.Builder(this)
    		.setTitle("Please select Contact Method")
    		.setItems(gContactUsMethod, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					switch(which) {
					case 0:
						Intent callIntent = new Intent(Intent.ACTION_CALL);
						callIntent.setData(Uri.parse("tel:4165548863"));
						startActivity(callIntent);
						return;
					case 1:
						return;
					default:
						return;
					}
				}
			}).create();
    	}
    	return null;
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
}

