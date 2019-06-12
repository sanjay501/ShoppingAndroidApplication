package com.example.sanjayprajapati.smsu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Login extends AppCompatActivity {

    private EditText et_fname,et_lname,et_emailid,et_password;
    private Button btnlogin,newaccount;
    private RegisterAsync registerAsync;
    private ProgressDialog pDialog;
    private String fname,lname,emailid,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_emailid=(EditText)findViewById(R.id.et_email);
        et_password=(EditText)findViewById(R.id.et_loginpassword);
        btnlogin=(Button)findViewById(R.id.btn_login);
        newaccount=(Button)findViewById(R.id.btn_new);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {emailid=et_emailid.getText().toString();
                password=et_password.getText().toString();
                fname="";
                lname="";
                String emailpattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (!emailid.matches(emailpattern)){
                    Toast.makeText(Login.this,"Enter valid email id",Toast.LENGTH_SHORT).show();
                }
                else if (password.equals("")){
                    Toast.makeText(Login.this,"Please enter password",Toast.LENGTH_SHORT).show();
                }
                else {
                    registerAsync =new RegisterAsync();
                    registerAsync.execute(fname,lname,emailid,password);

                }
                et_emailid.getText().clear();
                et_password.getText().clear();
            }
        });



    }


    private class RegisterAsync extends AsyncTask<String,Void,String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Login.this);
            pDialog.setMessage("Loging in ...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String Response = "";
            try {
                String data = URLEncoder.encode("firstname", "UTF-8") + "=" + URLEncoder.encode(params[0], "UTF-8");
                data += "&" + URLEncoder.encode("lastname", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8");
                data += "&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8");
                data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(params[3], "UTF-8");

                URL url = new URL("http://dmis.club/dmis_app/images/login.php");
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
                writer.write(data);
                writer.flush();
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String s;
                while ((s = rd.readLine()) != null) {
                    Response += s;
                }
                writer.close();
                rd.close();
                Log.i("Response ", Response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Response;
        }

        protected void onPostExecute(String result) {
            if (pDialog.isShowing())
                Log.d("result",result);
            response(result);
            pDialog.dismiss();
        }
    }

    private void response(String result) {

        try {
            JSONObject jsonObject = new JSONObject(result);
            if (jsonObject != null) {
                String response = jsonObject.getString("response");
                String message=jsonObject.getString("message");
                Log.i("response", response);
                if (response.equals("found")){
                    Intent homeactivity = new Intent(Login.this, BottomTabbedActivity.class);
                    startActivity(homeactivity);
                    Toast.makeText(Login.this,message,Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Login.this,message,Toast.LENGTH_SHORT).show();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
