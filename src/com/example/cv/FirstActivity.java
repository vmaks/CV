package com.example.cv;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;


//public class FirstActivity extends FragmentActivity
public class FirstActivity extends FragmentActivity implements OnDateSetListener
{
	
	public final static String EXTRA_name = "com.example.cv.name";
	public final static String EXTRA_birthdate = "com.example.cv.birthdate";
	public final static String EXTRA_sex = "com.example.cv.sex";
	public final static String EXTRA_position = "com.example.cv.position";
	public final static String EXTRA_salary = "com.example.cv.salary";
	public final static String EXTRA_phonenumber = "com.example.cv.phonenumber";
	public final static String EXTRA_email = "com.example.cv.email";
	
	public static String sex;
	
    AlertDialog.Builder ad;
    Context context;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		
		Intent intent = getIntent();
				
		///***AlertDialog***///
		AlertDialog.Builder ad;
	    Context context;
	    
	    context = FirstActivity.this;
        String title = "Письмо от работодателя";
        
        ad = new AlertDialog.Builder(context);
        ad.setTitle(title);
        
        ad.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() 
        {
            public void onClick(DialogInterface dialog, int id) 
            {
                
            }
        });
		
		String CheckAnswer = intent.getStringExtra(SecondActivity.EXTRA_CheckAnswer);
		String answer = intent.getStringExtra(SecondActivity.EXTRA_answer);	

		if (TextUtils.equals(CheckAnswer, "true"))
		{			
			if(!TextUtils.isEmpty(answer))
			{				
				ad.setMessage(answer);				
				ad.show();	
			}
			else
			{			
				String CV_answer_denied = getResources().getString(R.string.dialog_cv_message_denied);
				
				ad.setMessage(CV_answer_denied);				
				ad.show();
			}
		}
		
		///***Spinner***///
		Spinner spinner = (Spinner) findViewById(R.id.activity1_edit_sex);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.sex_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		return true;
	}
	
	/** Called when the user clicks the Send button */
    public void activity1_ButtonSendCV(View view) 
    {
        // Do something in response to button
    	
    	Intent intent = new Intent(this, SecondActivity.class);
    	
    	EditText editTextName = (EditText) findViewById(R.id.activity1_edit_name);
    	Button editTextBirthdate = (Button) findViewById(R.id.activity1_edit_birthdate);
    	Spinner editTextSex = (Spinner) findViewById(R.id.activity1_edit_sex);
    	EditText editTextPosition = (EditText) findViewById(R.id.activity1_edit_position);
    	EditText editTextSalary = (EditText) findViewById(R.id.activity1_edit_salary);
    	EditText editTextPhonenumber = (EditText) findViewById(R.id.activity1_edit_phonenumber);
    	EditText editTextEmail = (EditText) findViewById(R.id.activity1_edit_email);
    	  
    	
    	
    	String name = editTextName.getText().toString();
    	String birthdate = editTextBirthdate.getText().toString();
    	sex = editTextSex.getSelectedItem().toString();
    	String position = editTextPosition.getText().toString();
    	String salary = editTextSalary.getText().toString();
    	String phonenumber = editTextPhonenumber.getText().toString();
    	String email = editTextEmail.getText().toString();
    	
    	intent.putExtra(EXTRA_name, name);
    	intent.putExtra(EXTRA_birthdate, birthdate);
    	intent.putExtra(EXTRA_sex, sex);
    	intent.putExtra(EXTRA_position, position);
    	intent.putExtra(EXTRA_salary, salary);
    	intent.putExtra(EXTRA_phonenumber, phonenumber);
    	intent.putExtra(EXTRA_email, email);
    	
    	startActivity(intent);
    }
    
    public void showDatePickerDialog(View view) 
    {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) 
    {
        //do some stuff for example write on log and update TextField on activity
//        Log.w("DatePicker","Date = " + year);
        ((Button) findViewById(R.id.activity1_edit_birthdate)).setText(day + "." + (month+1) + "." + year);
    } 
}
