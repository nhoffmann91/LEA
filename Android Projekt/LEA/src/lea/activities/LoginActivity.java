package lea.activities;

import lea.controller.EventHandler;
import lea.helper.Constants;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private Button btnLogin;
	private EditText editTxtUsername;
	private EditText editTxtPassword;

	private OnClickListener onClickHandler = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == btnLogin)
				EventHandler.getInstance().btnLoginClick(
						editTxtUsername.getText().toString(),
						editTxtPassword.getText().toString(),
						(Activity) v.getContext());
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		this.setViewControls();
		this.addEvents();

		if (!getIntent().getExtras().equals(null)) {
			if (getIntent().getExtras().containsKey(Constants.ErrorKey)) {
				Toast.makeText(
						getBaseContext(),
						this.getIntent().getExtras()
								.getString(Constants.ErrorKey),
						Toast.LENGTH_LONG).show();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	private void addEvents() {
		this.btnLogin.setOnClickListener(this.onClickHandler);
	}

	private void setViewControls() {
		this.btnLogin = (Button) findViewById(R.id.btnLogin);
		this.editTxtUsername = (EditText) findViewById(R.id.editTxtUsername);
		this.editTxtPassword = (EditText) findViewById(R.id.editTxtPassword);
	}

}
