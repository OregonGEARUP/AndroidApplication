package androidapplication.oregongoestocollege.org.itsaplan.blocks;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Bikram Maharjan on 10/20/17.
 */

public class ListOfBlock implements Parcelable{
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

    private ListOfBlock(Parcel in){
        mCountId = in.readInt();
        mIds = in.readString();
        mTitle = in.readString();
        mBlockFileName = in.readString();
    }

    public ListOfBlock() {}

    public static final Creator<ListOfBlock> CREATOR = new Creator<ListOfBlock>() {
        @Override
        public ListOfBlock createFromParcel(Parcel parcel) {
            return new ListOfBlock(parcel);
        }

        @Override
        public ListOfBlock[] newArray(int i) {
            return new ListOfBlock[i];
        }
    };


}
