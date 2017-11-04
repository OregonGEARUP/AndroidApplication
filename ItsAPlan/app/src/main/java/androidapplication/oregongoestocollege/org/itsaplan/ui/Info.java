package androidapplication.oregongoestocollege.org.itsaplan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

import androidapplication.oregongoestocollege.org.itsaplan.R;
import androidapplication.oregongoestocollege.org.itsaplan.blocks.MasterBlock;
import butterknife.ButterKnife;

import static androidapplication.oregongoestocollege.org.itsaplan.ui.MainActivity.BLOCK_NAME;

/**
 * Created by Bikram Maharjan on 11/2/17.
 */

public class Info extends MainActivity{

    private MasterBlock mMasterBlock;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_checklist:
                    Intent intentBlockList = new Intent(Info.this, ListOfBlockActivity.class);
                    intentBlockList.putExtra(BLOCK_NAME, mMasterBlock.getListOfBlock());
                    startActivity(intentBlockList);
                    break;

                case R.id.nav_myplan:
                    Intent intentMyPlan = new Intent(Info.this, MyPlan.class);
                    startActivity(intentMyPlan);
                    break;

                case R.id.nav_passwords:
                    Intent intentPassword = new Intent(Info.this, Password.class);
                    startActivity(intentPassword);
                    break;

                case R.id.nav_info  :
                    // Currently on Info
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ButterKnife.bind(this);

        WebView oregonGEARUPwebsite = (WebView) findViewById(R.id.webview);
        oregonGEARUPwebsite.loadUrl("https://oregongoestocollege.org/5-things");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);


    }
}
