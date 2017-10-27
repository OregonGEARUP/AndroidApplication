package androidapplication.oregongoestocollege.org.itsaplan.ui;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import androidapplication.oregongoestocollege.org.itsaplan.R;
import androidapplication.oregongoestocollege.org.itsaplan.blocks.MasterBlock;
import androidapplication.oregongoestocollege.org.itsaplan.blocks.ListOfBlock;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String BLOCK_NAME = "BLOCK_NAME";

    private MasterBlock mMasterBlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getBlocks();

        Log.d(TAG, "Main UI code running!");

    }

    private void getBlocks() {
        String starterBlockFileName = "blocks.json";
        String originalUrl = "https://oregongoestocollege.org/mobileApp/json/" + starterBlockFileName;


        if(isNetworkAvailable()){
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(originalUrl)
                    .build();

            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        String jsonData = response.body().string();
                        Log.v(TAG, jsonData);
                        if (response.isSuccessful()){
                            mMasterBlock = parseMasterBlockDetails(jsonData);
                        }
                        else {
                            alertUserAboutError();
                        }
                    } catch (IOException e) {
                        Log.e(TAG, "Exception Caught ", e);
                    }
                    catch (JSONException e){
                        Log.e(TAG, "Exception Caught ", e);
                    }
                }
            });
        }
        else{
            Toast.makeText(this, getString(R.string.network_unavailable), Toast.LENGTH_LONG).show();
        }
        ;
    }


    private MasterBlock parseMasterBlockDetails(String jsonData) throws JSONException{
        MasterBlock masterBlock = new MasterBlock();

        masterBlock.setListOfBlock(getStartingBlockDetails(jsonData));


        return masterBlock;

    }

    // Get the value from blocks.json
    private ListOfBlock[] getStartingBlockDetails(String jsonData) throws JSONException {
        JSONArray singleBlockLength = new JSONArray(jsonData);



        ListOfBlock[] blocks = new ListOfBlock[singleBlockLength.length()];


        Log.d(TAG, "Block JSON Array!: " + singleBlockLength);
        Log.d(TAG, "Block JSON Array length!: " + singleBlockLength.length());


        int counter = 1; // for the incremental value of blocks
        for(int i=0;i<singleBlockLength.length();i++){
            JSONObject jsonBlock = singleBlockLength.getJSONObject(i);
            ListOfBlock listOfBlock = new ListOfBlock();


            listOfBlock.setCountId(counter++);
            // Get id name
            listOfBlock.setIds(jsonBlock.getString("ids"));
            // Get block title
            listOfBlock.setTitle(jsonBlock.getString("title"));
            // Get block file name
            listOfBlock.setBlockFileName(jsonBlock.getString("blockFileName"));

            blocks[i] = listOfBlock;

            Log.d(TAG, "Block JSON **SINGLE** Array!: " + blocks[i]);


        }


        Log.d(TAG, "Entire block array Array!: " + blocks);

        return blocks;


    };



    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;

        if (networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }

        return isAvailable;
    }

    private void alertUserAboutError() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "error_dialog");

    }

    @OnClick(R.id.getStartedButton)
    public void startingBlockActivity(View view){
        Log.d(TAG, "tapped the button: " );
        Toast.makeText(this, getString(R.string.button_pressed), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, ListOfBlockActivity.class);
        intent.putExtra(BLOCK_NAME, mMasterBlock.getListOfBlock());
        startActivity(intent);
    }

//    @OnClick(R.id.startingBlockNameLabel)
//    public void startingBlockActivity(View view){
//        Toast.makeText(this, getString(R.string.button_pressed), Toast.LENGTH_LONG).show();
//
//
//
//
//    }
}
