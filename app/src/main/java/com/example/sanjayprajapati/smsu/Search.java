package com.example.sanjayprajapati.smsu;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sanjayprajapati on 4/9/18.
 */

public class Search extends Fragment
{
    public Search(){}
    ListView lv;
    ArrayAdapter<String> adapter;
    InputStream inputStream;
    String line,result=null;
    String[] data;
    TextView textView;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search,container,false);
        lv = (ListView) view.findViewById(R.id.listview);

        //allow network in main thread
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        //getdata
        getData();
        //textView.setText(data[1].toString());


        adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);



        return view;
    }

    private void getData()  {
        try {
            URL url = new URL("http://dmis.club/dmis_app/getdata.php");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            inputStream = new BufferedInputStream(con.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }

        //READ INPUT STREAM CONTENT INto string
        try {
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb =new StringBuilder();

            while ((line =bufferedReader.readLine()) !=null){
                sb.append(line+"\n");
            }
            inputStream.close();
            result=sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }

        //PARSE JASON ARRAY
        try{
            JSONArray jsonArray=new JSONArray(result);
            JSONObject jsonObject=null;

            data =new String[jsonArray.length()];

            for(int i=0;i<jsonArray.length();i++){
                jsonObject=jsonArray.getJSONObject(i);
                data[i]= jsonObject.getString("Firstname");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
