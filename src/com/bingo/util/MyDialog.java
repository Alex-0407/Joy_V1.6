package com.bingo.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Handler;

import com.bingo.joy.R;

public class MyDialog {
	public static void myDialog(Activity activity, String message) {

		final AlertDialog dialog = new AlertDialog.Builder(activity,
				R.style.CustomAlertDialog).create();
		// adRef.setTitle("��ʾ");
		dialog.setMessage(message);
		dialog.show();

		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {

			public void run() {
				dialog.dismiss();
			}
		}, 2000);
	}
}
