package com.example.cv;

import com.example.cv.FirstActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class SecondActivity extends FragmentActivity 
{
	public final static String EXTRA_answer = "com.example.cv.answer";
	public final static String EXTRA_CheckAnswer = "com.example.cv.CheckAnswer";
	private static String CheckAnswer = "false";
		
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Intent intent = getIntent();
		
		String name = intent.getStringExtra(FirstActivity.EXTRA_name);
		String birthdate = intent.getStringExtra(FirstActivity.EXTRA_birthdate);
		String sex = intent.getStringExtra(FirstActivity.EXTRA_sex);
		String position = intent.getStringExtra(FirstActivity.EXTRA_position);
		String salary = intent.getStringExtra(FirstActivity.EXTRA_salary);
		String phonenumber = intent.getStringExtra(FirstActivity.EXTRA_phonenumber);
		String email = intent.getStringExtra(FirstActivity.EXTRA_email);
		
		CheckAnswer = "false";

		if (name.equals(""))
		{}
		else
		{name = "ФИО: " + name;}
		
		if (birthdate.equals(""))
		{}
		else
		{birthdate = "Дата рождения: " + birthdate;}
		
		if (sex.equals(""))
		{}
		else
		{sex = "Пол: " + sex;}
		
		if (position.equals(""))
		{}
		else
		{position = "Должность: " + position;}
		
		if (salary.equals(""))
		{}
		else
		{salary = "Зарплата: " + salary;}
		
		if (phonenumber.equals(""))
		{}
		else
		{phonenumber = "Номер телефона: " + phonenumber;}
		
		if (email.equals(""))
		{}
		else
		{email = "Email: " + email;}		

		
		TextView TextName = (TextView) findViewById(R.id.activity2_name);
		TextView TextBirthdate = (TextView) findViewById(R.id.activity2_birthdate);
		TextView TextSex = (TextView) findViewById(R.id.activity2_sex);
		TextView TextPosition = (TextView) findViewById(R.id.activity2_position);
		TextView TextSalary = (TextView) findViewById(R.id.activity2_salary);
		TextView TextPhonenumber = (TextView) findViewById(R.id.activity2_phonenumber);
		TextView TextEmail = (TextView) findViewById(R.id.activity2_email);
		
		TextName.setText(name);
		TextBirthdate.setText(birthdate);
		TextSex.setText(sex);
		TextPosition.setText(position);
		TextSalary.setText(salary);
		TextPhonenumber.setText(phonenumber);
		TextEmail.setText(email);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/** Called when the user clicks the Send button */
    public void activity2_ButtonSendAnswer(View view) 
    {
        // Do something in response to button
    	
    	Intent intent = new Intent(this, FirstActivity.class);
    	
    	EditText editTextAnswer = (EditText) findViewById(R.id.activity2_edit_answer_text);
    	
    	CheckAnswer = "true";  
    	String answer = editTextAnswer.getText().toString();    	
    	
    	intent.putExtra(EXTRA_CheckAnswer, CheckAnswer);
    	intent.putExtra(EXTRA_answer, answer);
    	
    	startActivity(intent);
    }

}
