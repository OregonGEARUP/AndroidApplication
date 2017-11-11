package androidapplication.oregongoestocollege.org.itsaplan.adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidapplication.oregongoestocollege.org.itsaplan.R;

/**
 * Created by Bikram Maharjan on 11/10/17.
 */

public class MyPlanListAdapter extends ArrayAdapter<MyPlanData>{

        private static final String TAG = "MyPlanListAdapter";

        private Context mContext;
        int mResource;

    public MyPlanListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MyPlanData> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        int imageId = getItem(position).getImageId();
        String myPlanListItem = getItem(position).getMyPlanListItem();

        // Create the My List object with the infos
        MyPlanData myPlanData = new MyPlanData(imageId, myPlanListItem);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.myPlanListImage);
        TextView textView = (TextView) convertView.findViewById(R.id.myPlanListText);

        imageView.setImageResource(imageId);
        textView.setText(myPlanListItem);

        return convertView;

    }
}
