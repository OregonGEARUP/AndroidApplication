package androidapplication.oregongoestocollege.org.itsaplan.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import androidapplication.oregongoestocollege.org.itsaplan.R;

/**
 * Created by Bikram Maharjan on 11/1/17.
 */

public class BaseActivity extends AppCompatActivity {





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);




    }
}
