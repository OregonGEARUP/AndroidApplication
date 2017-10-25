package androidapplication.oregongoestocollege.org.itsaplan.blocks;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Bikram Maharjan on 10/20/17.
 */

public class StartingBlock implements Parcelable{
    private int mCountId;
    private String mIds;
    private String mTitle;
    private String mBlockFileName;



    public int getCountId() {
        return mCountId;
    }

    public void setCountId(int countId) {
        mCountId = countId;
    }

    public String getIds() {
        return mIds;
    }

    public void setIds(String ids) {
        mIds = ids;
    }


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }


    public String getBlockFileName() {
        return mBlockFileName;
    }

    public void setBlockFileName(String blockFileName) {
        mBlockFileName = blockFileName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mCountId);
        parcel.writeString(mIds);
        parcel.writeString(mTitle);
        parcel.writeString(mBlockFileName);
    }

    private StartingBlock(Parcel in){
        mCountId = in.readInt();
        mIds = in.readString();
        mTitle = in.readString();
        mBlockFileName = in.readString();
    }

    public StartingBlock() {}

    public static final Creator<StartingBlock> CREATOR = new Creator<StartingBlock>() {
        @Override
        public StartingBlock createFromParcel(Parcel parcel) {
            return new StartingBlock(parcel);
        }

        @Override
        public StartingBlock[] newArray(int i) {
            return new StartingBlock[i];
        }
    };


}
