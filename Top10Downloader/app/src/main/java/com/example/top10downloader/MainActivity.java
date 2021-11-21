package com.example.top10downloader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private ListView listApps;
    private String feedUrl = "https://rss.art19.com/apology-line";
    private String feedCacheUrl = "INVALIDATED";
    public static final String STATE_URL = "feedUrl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listApps = findViewById(R.id.xmlListView);

        if(savedInstanceState!=null){
            feedUrl = savedInstanceState.getString(STATE_URL);
            Log.d(TAG, "URL SUCCESSSSSSSSSSSSSSSSS " + feedUrl);
        }

        downloadUrl("https://rss.art19.com/apology-line");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.feeds_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.mnuDan:
                feedUrl="https://feeds.megaphone.fm/WWO3519750118";
                break;
            case R.id.mnuUnraveled:
                feedUrl="https://rss.acast.com/unraveled";
                break;
            case R.id.mnuApology:
                feedUrl="https://rss.art19.com/apology-line";
                break;
            case R.id.mnuRefresh:
                feedCacheUrl = "INVALIDATED";
            default:
                return super.onOptionsItemSelected(item);
        }
        downloadUrl(feedUrl);
        return true;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: ok "+feedUrl );
        outState.putString(STATE_URL, feedUrl);
        super.onSaveInstanceState(outState);
    }

    public void downloadUrl(String feedUrl){
        if(!feedUrl.equalsIgnoreCase(feedCacheUrl)){
            Log.d(TAG, "downloadUrl: Starting AsyncTask");
            DownloadData downloadData = new DownloadData();
            downloadData.execute(feedUrl);
            Log.d(TAG, "downloadUrl: done");
        }else{
            Log.d(TAG, "downloadUrl: URL NOT CHANGED");
        }
    }

    private class DownloadData extends AsyncTask<String, Void,  String>{
        public static final String TAG = "DownloadData";

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            Log.d(TAG, "onPostExecute: parameter is "+s);
            ParseApplication parseApplication = new ParseApplication();
            parseApplication.parse(s);

//            ArrayAdapter<FeedEntry> arrayAdapter = new ArrayAdapter<FeedEntry>(MainActivity.this, android.R.layout.simple_list_item_1, parseApplication.getApplications());
//            listRecord.setAdapter(arrayAdapter);

            FeedAdapter feedAdapter = new FeedAdapter(MainActivity.this, R.layout.list_record, parseApplication.getApplications());
            listApps.setAdapter(feedAdapter);
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.d(TAG, "doInBackground: starts with "+strings[0]);
            String rssFeed = downloadXML(strings[0]);
            if(rssFeed == null){
                Log.e(TAG, "doInBackground: Error in downloading");
            }
            return rssFeed;
        }

        private String downloadXML(String urlPath){
            StringBuilder xmlResult = new StringBuilder();

            try{
                URL url = new URL(urlPath);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                int response = connection.getResponseCode();
                Log.d(TAG, "downloadXML: The response code was "+response);
//                InputStream inputStream = connection.getInputStream();
//                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                BufferedReader reader = new BufferedReader(inputStreamReader);
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                int charsRead;
                char [] inputBuffer = new char[500];
                while(true){
                    charsRead = reader.read(inputBuffer);
                    if(charsRead < 0){
                        break;
                    }
                    if(charsRead > 0){
                        xmlResult.append(String.copyValueOf(inputBuffer, 0, charsRead));
                    }
                }
                reader.close();

                return xmlResult.toString();
            } catch (MalformedURLException e){
                Log.e(TAG, "downloadXML: Incalid URL "+e.getMessage());
            } catch (IOException e){
                Log.e(TAG, "downloadXML: IO exception reading data "+e.getMessage());
            } catch (SecurityException e){
                Log.e(TAG, "downloadXML: Security Exception. Needs permission? "+e.getMessage());
//                e.printStackTrace();
            }
            return null;
        }
    }
}