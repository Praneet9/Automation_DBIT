package com.example.vinay.automation;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Vinay on 3/26/2017.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String> {


    Context context;
    AlertDialog alertDialog;
    public BackgroundWorker(Context ctx) {

        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String newuser_url = "http://192.168.43.42/new_user.php";
        String existing_url = "http://192.168.43.42/existing_user.php";
        if(type.equals("new_user")){
            try {
                String name = params[1];
                String rollno = params[2];
                String age = params[3];
                String gender = params[4];
                String contact = params[5];
                String address = params[6];
                String source = params[7];
                String destination = params[8];
                String year = params[9];
                String semester = params[10];
                String sclass = params[11];
                String email = params[12];
                String password = params[13];
                URL url = new URL(newuser_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"
                        +URLEncoder.encode("rollno","UTF-8")+"="+URLEncoder.encode(rollno,"UTF-8")+"&"
                        +URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode(age,"UTF-8")+"&"
                        +URLEncoder.encode("gender","UTF-8")+"="+URLEncoder.encode(gender,"UTF-8")+"&"
                        +URLEncoder.encode("contact","UTF-8")+"="+URLEncoder.encode(contact,"UTF-8")+"&"
                        +URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")+"&"
                        +URLEncoder.encode("source","UTF-8")+"="+URLEncoder.encode(source,"UTF-8")+"&"
                        +URLEncoder.encode("destination","UTF-8")+"="+URLEncoder.encode(destination,"UTF-8")+"&"
                        +URLEncoder.encode("year","UTF-8")+"="+URLEncoder.encode(year,"UTF-8")+"&"
                        +URLEncoder.encode("semester","UTF-8")+"="+URLEncoder.encode(semester,"UTF-8")+"&"
                        +URLEncoder.encode("sclass","UTF-8")+"="+URLEncoder.encode(sclass,"UTF-8")+"&"
                        +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while((line =bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("existing_user")) {
            try {
                String rollno = params[1];
                String semester = params[2];
                String year = params[3];
                String sclass = params[4];
                URL url = new URL(existing_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("rollno","UTF-8")+"="+URLEncoder.encode(rollno,"UTF-8")+"&"
                        +URLEncoder.encode("semester","UTF-8")+"="+URLEncoder.encode(semester,"UTF-8")+"&"
                        +URLEncoder.encode("year","UTF-8")+"="+URLEncoder.encode(year,"UTF-8")+"&"
                        +URLEncoder.encode("sclass","UTF-8")+"="+URLEncoder.encode(sclass,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while((line =bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
