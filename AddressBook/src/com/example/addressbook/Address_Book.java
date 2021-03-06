/*Coder:Octavio Gutierrez
Class CIS240TH6C
Class Day Thursday at 6:00pm
Android App. Development
Due: September 13,2012
Program 1
Summary
Create an activity app with a form layout to input name and address. 
The form needs to contain First Name, Last Name, Street Address, Town State, and Zip code.
*/

/*
GitHub History
Sept 11 Initial Build
Sept 11 Fixed Toast output to display EditText.getText() and not EditText()
Sept 12 Added EditText Field highlighting so user won't have to manually delete Text
Sept 12 Secured variables with private 
Sept 13 Updated App Title
Sept 13 Changed Toast.LENGTH_SHORT).show() to Toast.LENGTH_LONG).show()
Source available on GitHub @ git@github.com:tavedroid/CIS240.git 
 */

package com.example.addressbook;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.Toast;

public class Address_Book extends Activity {

	private Button ok;
	private Button clear;
	private EditText fname = null;
	private EditText address = null;
	private EditText city = null;
	private EditText state = null;
	private EditText zip = null;
	private WriteFile writeToFile = new WriteFile();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ok = (Button) findViewById(R.id.okbutton);
        
        ok.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				setInput();
				displayInput();
			}
        	      	
        });
        
        clear = (Button) findViewById(R.id.clearbutton);
        
        clear.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				setInput();
				resetInput();
			}
        	      	
        });  

    }

    //Method to set local variables by findViewById
    private void setInput(){
		fname = (EditText) findViewById(R.id.fname);
		address = (EditText) findViewById(R.id.address);
		city = (EditText) findViewById(R.id.city);
		state = (EditText) findViewById(R.id.state);
		zip = (EditText) findViewById(R.id.zip);
		writeToFile.writeFields();
    }
    
    //Method to reset EditText Input Fields
    private void resetInput(){
		fname.setText("Name");
		address.setText("Address");
		city.setText("City");
		state.setText("State");
		zip.setText("Zip");
    }
    
    //Method to check input and display info 
    private void displayInput(){
    	
    	//Future implementation could verify if entries are valid
    	CharSequence lname = fname.getText();
    	CharSequence laddress = address.getText();
    	CharSequence lcity =  city.getText();
    	CharSequence lstate = state.getText();
    	CharSequence lzip = zip.getText();
    	
    	//Output the information
    	Toast.makeText(getBaseContext(), "You entered: " + lname + " ," + laddress + " ," +  lcity + " ," + lstate + " ," + lzip, Toast.LENGTH_LONG).show();
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    

    
}
