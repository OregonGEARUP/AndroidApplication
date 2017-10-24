package androidapplication.oregongoestocollege.org.itsaplan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidapplication.oregongoestocollege.org.itsaplan.R;
import androidapplication.oregongoestocollege.org.itsaplan.blocks.StartingBlock;

/**
 * Created by Bikram Maharjan on 10/24/17.
 */

public class StartingBlockAdapter extends BaseAdapter {

    private Context mContext;
    private StartingBlock[] mStartingBlocks;


    public StartingBlockAdapter(Context context, StartingBlock[]
            startingBlocks){

        mContext = context;
        mStartingBlocks = startingBlocks;
    }


    @Override
    public int getCount() {
        return mStartingBlocks.length;
    }

    @Override
    public Object getItem(int position) {
        return mStartingBlocks[position];
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
            holder.startingBlockNameLabel = (TextView) view.findViewById(R.id.startingBlockNameLabel);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        StartingBlock startingBlock= mStartingBlocks[position];
        holder.startingBlockNameLabel.setText(startingBlock.getTitle());

        return view;
    }

    private static class ViewHolder {
        TextView startingBlockNameLabel;
    }
}
