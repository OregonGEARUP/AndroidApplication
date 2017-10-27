package androidapplication.oregongoestocollege.org.itsaplan.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.Arrays;

import androidapplication.oregongoestocollege.org.itsaplan.R;
import androidapplication.oregongoestocollege.org.itsaplan.adapters.ListOfBlockAdapter;
import androidapplication.oregongoestocollege.org.itsaplan.blocks.ListOfBlock;

public class ListOfBlockActivity extends ListActivity {

    private ListOfBlock[] mListOfBlock;

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

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.BLOCK_NAME);

        mListOfBlock = Arrays.copyOf(parcelables, parcelables.length, ListOfBlock[].class);

        ListOfBlockAdapter adapter = new ListOfBlockAdapter(this, mListOfBlock);


        setListAdapter(adapter);

    }

}
