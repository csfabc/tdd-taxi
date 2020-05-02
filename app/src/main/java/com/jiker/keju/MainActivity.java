package com.jiker.keju;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
	private String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FileUtil fileUtil = new FileUtil("testData.txt", this);
		String receipt = new ParseFile().parseAll(fileUtil.getData());
		Log.i(TAG, "receipt=" + receipt);
	}
}
