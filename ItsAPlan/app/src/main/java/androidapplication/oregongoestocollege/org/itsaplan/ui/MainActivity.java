package androidapplication.oregongoestocollege.org.itsaplan.ui;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_checklist:
                    // Starting Block Activity in a function
                    startingBlockActivity();
                    break;

                case R.id.nav_myplan:
                    Intent intentMyPlan = new Intent(MainActivity.this, MyPlan.class);
                    startActivity(intentMyPlan);
                    break;

                case R.id.nav_passwords:
                    Intent intentPassword = new Intent(MainActivity.this, Password.class);
                    startActivity(intentPassword);
                    break;

                case R.id.nav_info  :
                    Intent intentInfo = new Intent(MainActivity.this, Info.class);
                    startActivity(intentInfo);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);






        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);


        // Call the function
        getBlocks();



        Log.d(TAG, "Main UI code running!");

    }





    // Check Network is available + get the data from JSON file
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
                        String incommingJSONData = response.body().string();
                        Log.v(TAG, incommingJSONData);
                        if (response.isSuccessful()){
                            mMasterBlock = parseMasterBlockDetails(incommingJSONData);
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





    //e
    private MasterBlock parseMasterBlockDetails(String incommingJSONData) throws JSONException{
        MasterBlock masterBlock = new MasterBlock();

        masterBlock.setListOfBlock(getStartingBlockDetails(incommingJSONData));

        return masterBlock;

    }





    // Get the value from blocks.json and parse the data
    private ListOfBlock[] getStartingBlockDetails(String incommingJSONData) throws JSONException {
        JSONArray singleBlockLength = new JSONArray(incommingJSONData);



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
    // End of Get the value from blocks.json







    // Check if Network is available
    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;

        if (networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }

        return isAvailable;
    };
    // End of Check if Network is available







    // Alert error if there is no such block filename
    private void alertUserAboutError() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "error_dialog");

    };
    // End of Alert error if there is no such block filename


//    @OnClick(R.id.getStartedButton)
//    public void getStartedButton(View view){
//        startingBlockActivity();
//    }


    // Starting Block Activity in a function
    public void startingBlockActivity(){
        Intent intent = new Intent(this, ListOfBlockActivity.class);
        intent.putExtra(BLOCK_NAME, mMasterBlock.getListOfBlock());
        startActivity(intent);
    };


    // Open My Plan Activity
//    public void myPlanActivity(){
//        Intent intent = new Intent(this, MyPlan.class);
//        String message = "Hi There My Plan";
//        intent.putExtra(BLOCK_NAME, message);
//        startActivity(intent);
//
//    };
    //End of Onclick with Butterknife. Open the Blocks.json avtivity


}
