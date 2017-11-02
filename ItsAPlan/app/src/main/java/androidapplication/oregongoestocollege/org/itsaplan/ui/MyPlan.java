package androidapplication.oregongoestocollege.org.itsaplan.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidapplication.oregongoestocollege.org.itsaplan.R;
import androidapplication.oregongoestocollege.org.itsaplan.blocks.MasterBlock;
import androidapplication.oregongoestocollege.org.itsaplan.blocks.ListOfBlock;
import androidapplication.oregongoestocollege.org.itsaplan.ui.MainActivity;
import butterknife.ButterKnife;

import static androidapplication.oregongoestocollege.org.itsaplan.ui.MainActivity.BLOCK_NAME;

/**
 * Created by Bikram Maharjan on 11/1/17.
 */

public class MyPlan extends MainActivity {
    private MasterBlock mMasterBlock;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_checklist:
                    Intent intentBlockList = new Intent(MyPlan.this, ListOfBlockActivity.class);
                    intentBlockList.putExtra(BLOCK_NAME, mMasterBlock.getListOfBlock());
                    startActivity(intentBlockList);
                    break;

                case R.id.nav_myplan:
                //  My Plan don't need to navigate. Current Activity

                    break;

                case R.id.nav_passwords:
                    Intent intentPassword = new Intent(MyPlan.this, Password.class);
                    startActivity(intentPassword);
                    break;

                case R.id.nav_info:
                    Intent intentInfo = new Intent(MyPlan.this, Info.class);
                    startActivity(intentInfo);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myplan);
        ButterKnife.bind(this);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);



    }
}
