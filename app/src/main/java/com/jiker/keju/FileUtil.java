package com.jiker.keju;
import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class FileUtil {
	private String mContent = "";
	public FileUtil(String fileName, Context context) {
		try {
			InputStream inputStream = context.getResources().getAssets().open(fileName);
			BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			String line;
			while ((line = bf.readLine()) != null) {
				mContent += line + "\n";
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public String getData(){
		return mContent;
	}
}