package androidapplication.oregongoestocollege.org.itsaplan.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;

import androidapplication.oregongoestocollege.org.itsaplan.R;
import androidapplication.oregongoestocollege.org.itsaplan.adapters.StartingBlockAdapter;
import androidapplication.oregongoestocollege.org.itsaplan.blocks.StartingBlock;

public class StartingBlockActivity extends ListActivity {

    private StartingBlock[] mStartingBlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_block);

        // Test default adapter
//        String[] blockNames = {"first ", "second", "third", "fourth"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, blockNames);
//
//        setListAdapter(adapter);


        StartingBlockAdapter adapter = new StartingBlockAdapter(this, mStartingBlock);


    }

}
