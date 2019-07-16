package com.android.priyanka.restapigithubintegration.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageDownloader extends AsyncTask<String,Void, Bitmap> {

    @Override
    protected Bitmap doInBackground(String... strings) {

        try{
            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return  bitmap;
        }
        catch (MalformedURLException e) {
            e.printStackTrace();

        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }


}
