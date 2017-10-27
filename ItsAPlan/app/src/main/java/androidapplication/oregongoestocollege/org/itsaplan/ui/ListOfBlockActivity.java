package androidapplication.oregongoestocollege.org.itsaplan.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_block);

        // Test default adapter old code
//        String[] blockNames = {"first ", "second", "third", "fourth"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, blockNames);
//
//        setListAdapter(adapter);

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
