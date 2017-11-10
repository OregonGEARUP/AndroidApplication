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
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidapplication.oregongoestocollege.org.itsaplan.R;
import androidapplication.oregongoestocollege.org.itsaplan.blocks.MasterBlock;
import butterknife.ButterKnife;

import static androidapplication.oregongoestocollege.org.itsaplan.ui.MainActivity.BLOCK_NAME;

/**
 * Created by Bikram Maharjan on 11/1/17.
 */

public class MyPlan extends ListActivity {


    private MasterBlock mMasterBlock;

    int [] Images = {R.drawable.colleges_xxxhdpi, R.drawable.scholarships_xxxhdpi, R.drawable.actsat_xxxhdpi, R.drawable.residency_xxhdpi, R.drawable.calendar_xxxhdpi};
    String [] myPlanOptions = {"Colleges", "Scholarships", "ACT / SAT", "Residency Info", "Calendar"};


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

        ListView listView = (ListView)findViewById(android.R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                myPlanOptions);
        setListAdapter(adapter);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

    }

    


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String getMyPlanOptions = myPlanOptions[position];
        String message = String.format("%s is coming soon!",
                getMyPlanOptions);

        switch (getMyPlanOptions) {
            case "Colleges":
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

                break;

            case "Scholarships":
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

                break;

            case "ACT / SAT":
                Intent intentActsat = new Intent(MyPlan.this, Actsat.class);
                startActivity(intentActsat);
                break;

            case "Residency Info":
                Intent intentResidencyInfo = new Intent(MyPlan.this, ResidencyInfo.class);
                startActivity(intentResidencyInfo);
                break;

            case "Calendar":
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

                break;

            default:
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

                break;

        }



    }


    //    @OnClick (R.id.CollegesMyPlan)
//    public void startCollegesActivity(View view){
//        Toast.makeText(this, "My Plan College", Toast.LENGTH_LONG).show();
//
//
//    }

}
