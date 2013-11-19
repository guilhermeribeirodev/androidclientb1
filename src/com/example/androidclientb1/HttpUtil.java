package com.example.androidclientb1;

import android.util.Log;
import com.turbomanage.httpclient.BasicHttpClient;
import com.turbomanage.httpclient.ParameterMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 11/17/13
 * Time: 3:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpUtil {


    public void loginDev(String userEmail) {
        BasicHttpClient httpClient = new BasicHttpClient("http://localhost:8888");
        ParameterMap params = httpClient.newParams()
                .add("continue", "/")
                .add("email", userEmail)
                .add("action", "Log In");
        httpClient.addHeader("name", "value");
        httpClient.setConnectionTimeout(2000);
        HttpResponse httpResponse = (HttpResponse) httpClient.post("/_ah/login", params);
    }


    public static void loginProd(String authToken) {
        BasicHttpClient httpClient = new BasicHttpClient("http://localhost:8081");
        ParameterMap params = httpClient.newParams()
                .add("auth", authToken);
        HttpResponse httpResponse = (HttpResponse) httpClient.get("/items", null);
        Log.v("response",httpResponse.toString());
    }


    public static  String asd() throws IOException {

        HttpClient client = new DefaultHttpClient();

        HttpGet httpget = new HttpGet("http:/localhost:8081/items");

        HttpResponse response = null;

        String result = "";

        try{
            response = client.execute(httpget);

            // Examine the response status
            Log.i("Praeda", response.getStatusLine().toString());

            // Get hold of the response entity
            HttpEntity entity = response.getEntity();
            // If the response does not enclose an entity, there is no need
            // to worry about connection release

            if (entity != null) {

                // A Simple JSON Response Read
                InputStream instream = entity.getContent();
                result = convertStreamToString(instream);
                // now you have the string representation of the HTML request
                instream.close();
            }

        } catch (IOException e1) {
            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


          return result;

    }

    private static  String convertStreamToString(InputStream is) {
    /*
     * To convert the InputStream to String we use the BufferedReader.readLine()
     * method. We iterate until the BufferedReader return null which means
     * there's no more data to read. Each line will appended to a StringBuilder
     * and returned as String.
     */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


    public static String getInputStreamFromUrl(String url) {
        InputStream content = null;
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(url));
            content = response.getEntity().getContent();
        } catch (Exception e) {
            Log.v("[GET REQUEST]", "Network exception", e);
        }
        return convertStreamToString(content);
    }



}
