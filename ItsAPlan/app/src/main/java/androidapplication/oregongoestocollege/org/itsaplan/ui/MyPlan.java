package androidapplication.oregongoestocollege.org.itsaplan.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidapplication.oregongoestocollege.org.itsaplan.R;
import androidapplication.oregongoestocollege.org.itsaplan.adapters.MyPlanData;
import androidapplication.oregongoestocollege.org.itsaplan.adapters.MyPlanListAdapter;
import androidapplication.oregongoestocollege.org.itsaplan.blocks.MasterBlock;
import butterknife.ButterKnife;

import static androidapplication.oregongoestocollege.org.itsaplan.ui.MainActivity.BLOCK_NAME;

/**
 * Created by Bikram Maharjan on 11/1/17.
 */

public class MyPlan extends ListActivity {

    private static final String TAG = "MyPlanUI";

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

        ListView listMyPlan = (ListView) findViewById(android.R.id.list);


        MyPlanData college = new MyPlanData(R.drawable.colleges_xxxhdpi, "Colleges");
        MyPlanData scholarships = new MyPlanData(Images[1], myPlanOptions[1]);
        MyPlanData actsat = new MyPlanData(Images[2], myPlanOptions[2]);
        MyPlanData residencyinfo = new MyPlanData(Images[3], myPlanOptions[3]);
        MyPlanData calendar = new MyPlanData(Images[4], myPlanOptions[4]);


        // Add the MyPlanData object to the ArrayList
        ArrayList<MyPlanData> myPlanDataList = new ArrayList<>();

        myPlanDataList.add(college);
        myPlanDataList.add(scholarships);
        myPlanDataList.add(actsat);
        myPlanDataList.add(residencyinfo);
        myPlanDataList.add(calendar);

        MyPlanListAdapter adapter = new MyPlanListAdapter(this, R.layout.myplan_list, myPlanDataList);
        listMyPlan.setAdapter(adapter);

    //        ArrayAdapter<String> adapterText = new ArrayAdapter<String>(this,
    //                R.layout.myplan_list,
    //                myPlanOptions);
    //        listMyPlan.setAdapter(adapterText);


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
