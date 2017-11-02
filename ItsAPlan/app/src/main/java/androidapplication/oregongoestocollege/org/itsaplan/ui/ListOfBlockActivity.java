package androidapplication.oregongoestocollege.org.itsaplan.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

import androidapplication.oregongoestocollege.org.itsaplan.R;
import androidapplication.oregongoestocollege.org.itsaplan.adapters.ListOfBlockAdapter;
import androidapplication.oregongoestocollege.org.itsaplan.blocks.ListOfBlock;
import butterknife.OnClick;

import static androidapplication.oregongoestocollege.org.itsaplan.ui.MainActivity.BLOCK_NAME;
import static androidapplication.oregongoestocollege.org.itsaplan.ui.MainActivity.TAG;

public class ListOfBlockActivity extends ListActivity {

    private ListOfBlock[] mListOfBlock;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_checklist:
                    // Currently on Checklist
                    break;

                case R.id.nav_myplan:
                    Intent intentMyPlan = new Intent(ListOfBlockActivity.this, MyPlan.class);
                    startActivity(intentMyPlan);
                    break;

                case R.id.nav_passwords:
                    Intent intentPassword = new Intent(ListOfBlockActivity.this, Password.class);
                    startActivity(intentPassword);
                    break;

                case R.id.nav_info:
                    Intent intentInfo = new Intent(ListOfBlockActivity.this, Info.class);
                    startActivity(intentInfo);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_block);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);



        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(BLOCK_NAME);

        mListOfBlock = Arrays.copyOf(parcelables, parcelables.length, ListOfBlock[].class);

        ListOfBlockAdapter adapter = new ListOfBlockAdapter(this, mListOfBlock);


        setListAdapter(adapter);

    }


//    // Onclick with Butterknife. Open the Blocks.json avtivity

//    @OnClick(R.id.getStartedButton)
//    public void startingBlockActivity(View view){
//        Log.d(TAG, "tapped the button: " );
//        Toast.makeText(this, getString(R.string.button_pressed), Toast.LENGTH_LONG).show();
//
//        Intent intent = new Intent(this, ListOfBlockActivity.class);
//        startActivity(intent);
//    };
//    //End of Onclick with Butterknife. Open the Blocks.json avtivity


}
