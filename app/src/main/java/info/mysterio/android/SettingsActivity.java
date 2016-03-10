package info.mysterio.android;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity{

    EditText txtUrl;
    EditText txtUsername;
    EditText txtPassword;
    SharedPreferences settings;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        txtUrl=(EditText) findViewById(R.id.editText_url);
        txtUsername=(EditText)findViewById(R.id.editText_username);
        txtPassword=(EditText) findViewById(R.id.editText_pass);
        settings=getSharedPreferences("settings",0);
        Log.d("Bledi", "U krijua settings layout");
        getSettings();

    }

    public void SaveData(View v){
        String url      =txtUrl.getText().toString();
        String username =txtUsername.getText().toString();
        String password =txtPassword.getText().toString();
        SharedPreferences.Editor editor=settings.edit();
        editor.putString("url", url);
        editor.putString("username",username);
        editor.putString("password",password);
        editor.commit();
        Toast.makeText(getApplicationContext(),"Te dhenat u ruajten!" , Toast.LENGTH_LONG).show();
        Log.d("Bledi", "Buttoni u klikua");
        Log.d("Bledi", "Te dhenat u rujten");
    }

    public boolean getSettings(){

        String url = settings.getString("url", "error");
        String username = settings.getString("username", "error");
        String password = settings.getString("password", "error");

        if(url!="error"&& username!="error"&&password!="error"){
            txtUrl.setText(url);
            txtUsername.setText(username);
            txtPassword.setText(password);
            return true;
        }else {
            Log.d("Bledi","Te dhenat nuk mund te ngarkohen");
            return  false;

        }

    }

}



















