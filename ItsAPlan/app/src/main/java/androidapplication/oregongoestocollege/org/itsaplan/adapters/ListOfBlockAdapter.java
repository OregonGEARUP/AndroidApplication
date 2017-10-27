package androidapplication.oregongoestocollege.org.itsaplan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidapplication.oregongoestocollege.org.itsaplan.R;
import androidapplication.oregongoestocollege.org.itsaplan.blocks.ListOfBlock;

/**
 * Created by Bikram Maharjan on 10/24/17.
 */

public class ListOfBlockAdapter extends BaseAdapter {

    private Context mContext;
    private ListOfBlock[] mListOfBlocks;


    public ListOfBlockAdapter(Context context, ListOfBlock[]
            listOfBlocks){

        mContext = context;
        mListOfBlocks = listOfBlocks;
    }


    @Override
    public int getCount() {
        return mListOfBlocks.length;
    }

    @Override
    public Object getItem(int position) {
        return mListOfBlocks[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        // List accessed for the first time
        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.starting_block_list,
                    null);
            holder = new ViewHolder();
            holder.startingBlockCountLabel = (TextView) view.findViewById(R.id.startingBlockCountLabel);
            holder.startingBlockNameLabel = (TextView) view.findViewById(R.id.startingBlockNameLabel);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        ListOfBlock listOfBlock = mListOfBlocks[position];
        holder.startingBlockCountLabel.setText(listOfBlock.getCountId() + ".");
        holder.startingBlockNameLabel.setText(listOfBlock.getTitle());

        return view;
    }

    private static class ViewHolder {
        TextView startingBlockCountLabel;
        TextView startingBlockNameLabel;

    }
}
